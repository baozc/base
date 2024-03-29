﻿/*
 * 
 * TreeTable 0.1 - Client-side TreeTable Viewer!
 * @requires jQuery v1.3
 * 
 * Copyright (c) 2009 Hao Chen
 * Email:xchpanda@163.com
 * 
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 * Revision: 2009-7-29
 * 
 */

(function($) {
	$.extend({
		treetable : new function() {

			this.defaults = {
				id_col : 0,
				parent_col : 1,
				handle_col : 2,
				order_col : -1,
				open_img : "images/minus.gif",
				close_img : "images/plus.gif",
				is_open_start : false
			};

			// jquery的trim处理不了&nbsp;产生的"空格"
			function trim(str) {
				return str.replace(/(^[\s\xA0]*)|([\s\xA0]*$)/g, "");
			}

			this.construct = function(settings) {

				if (this.size() != 1)
					return;// 只处理一个表格

				if (this[0].tagName.toUpperCase() != "TBODY")
					return;// 只应用于tbody

				var config = $.extend({}, $.treetable.defaults, settings);

				if (config.id_col == null || config.parent_col == null || config.handle_col == null)
					return;

				var $this = $(this);
				var tr_arr = new Array();
				var tr_sort = new Array();

				// 构建行对象数组
				$this.find("tr").each(function() {
					var id = $.trim($(this).find("td:eq(" + config.id_col + ")").text());
					var parent = $.trim($(this).find("td:eq(" + config.parent_col + ")").text());
					tr_arr.push({
						'id' : id,
						'parent' : parent,
						'level' : 0,
						'node' : 'leaf',
						'expanded' : config.is_open_start,
						'obj' : $(this)
					});
				});

				var len = tr_arr.length;
				var level = 0;

				/*
				 * 检查tr_arr中的每一行的父行是否再tr_sort中， 如果有则插入到tr_sort的父行后，从tr_arr中删除
				 * 直到tr_arr都为null,生成排好序的tr_sort
				 */
				while (len > 0) {
					for (var i = 0; i < tr_arr.length; i++) {
						var o = tr_arr[i];

						if (o == null)
							continue;

						if (o.parent == "" || o.parent == o.id) {// 根行直接压入tr_sort
							tr_sort.push(o);
							tr_arr[i] = null;
							len = len - 1;
						} else {
							for (var j = 0; j < tr_sort.length; j++) {
								if (tr_sort[j].id == o.parent) {
									o.level = tr_sort[j].level + 1;// 从父行累计生成层次level
									tr_sort[j].node = 'node';
									tr_sort.splice(j + 1, 0, o);// 数组插入
									tr_arr[i] = null;
									len = len - 1;
									break;
								}
							}
						}
					}
					level = level + 1;
				}// while

				// 展开事件动作函数
				var fn_click = function() {
					
					var id = trim($(this).parent().find("td:eq(" + config.id_col + ")").text());// 获取当前行ID
					var v = -1;
					for (var j = 0; j < tr_sort.length; j++) {
						var o = tr_sort[j];
						if (o.id == id) {// 在tr_sort找到行对象

							v = o.level;
							var img = o.obj.find("td:eq(" + config.handle_col + ") img")[0];
							if (o.node == 'leaf') {
								img.src = config.open_img;
								return;
							}
							if (!o.expanded) {// 通过图标判断是展开还是收起
								img.src = config.open_img;
								o.expanded = true;
							} else {
								img.src = config.close_img;
								o.expanded = false;
							}

							var show = o.expanded;

							var f = false;// 父行收起标志
							var tmp = 0;// 父行的层次

							for (var i = j + 1; i < tr_sort.length; i++) {// 根据level更新后续的子行
								o = tr_sort[i];

								var img = o.obj.find("td:eq(" + config.handle_col + ") img")[0];

								var t = !o.expanded;// 判断是否是收起状态

								if (o.level > v && show) {// 展开操作
									if (!f && !t) {// 父行未收起，且当前行是展开状态
										o.obj.show("fast");
									} else if (!f && t) {// 父行未收起，且当前行是收起状态
										tmp = o.level;
										f = true;
										o.obj.show("fast");
									} else if (f && o.level <= tmp) {// 同级的前一行是收起状态
										if (!t) {
											f = false;
										} else {
											tmp = o.level;
										}
										o.obj.show("fast");
									} else {
										;
									}

								} else if (o.level > v && !show) {// 收起操作则隐藏所以子行
								// o.obj.hide("normal");
									o.obj.hide("fast");
								} else if (o.level <= v) {// 到达非子行，处理完毕
									break;
								}
							}

							break;
						}
					}
				}

				// 重新绘制表格，添加展开动作图标
				for (var j = tr_sort.length - 1; j > -1; j--) {// prepend插入tbody内需使用反序
					var o = tr_sort[j];
					// 节点前的图标
					var tree_open_tag = config.close_img;
					if (config.is_open_start == true) {
						tree_open_tag = config.open_img;
					}
					var img = $("<img src='" + tree_open_tag + "'>");
				

					var td = o.obj.find("td:eq(" + config.handle_col + ")");
					td.prepend("&nbsp;");
					td.prepend(img);
					td.click(fn_click);
					td.css("cursor","pointer");

					var s = new Array((o.level + 1) * 5).join("&nbsp;");// 生成缩进空格
					td.prepend(s);
					o.obj.data("level", o.level);
					// 默认收起，则子节点隐藏
					if (config.is_open_start == false && o.level > 0) {
						o.obj.hide();
					}
					$this.prepend(o.obj);

				}// for

			}// construct
		}// treetable

	});

	$.fn.extend({
		treetable : $.treetable.construct
	});

})(jQuery);