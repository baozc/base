/** 会员对象 */
var MembersObject = {
	init : function() {
		// 注册新会员按钮事件
		this._reg_add_members_btn_event();
		// 注册或者编辑 会员，弹出框的保存按钮事件
		this._reg_save_member_btn_event();
		// 上传图片控件的点击事件
		this._reg_files_event();
		// 初始化应用表格
		this._init_app_table();
		// 注册表格中编辑与删除按钮事件
		this._reg_table_edit_and_delete_btn_event();
		// 注册时间控件
		this._reg_datetime_events();
		//this.site_preview();
	},
	// 注册时间控件
	_reg_datetime_events : function() {
		$('.wz-datetime').datetimepicker({
			language : "zh-CN",
			format : "yyyy-mm-dd hh:ii",
			autoclose : true,
			todayBtn : true,
			todayHighlight : true,
			minuteStep : 1
		});
	},
	// 注册表格中编辑与删除按钮事件
	_reg_table_edit_and_delete_btn_event : function() {

		// 删除按钮
		$(document).on("click", ".pf-table-btn-delete", function() {
			var $tr = $(this).closest("tr");
			// 行数据
			var rowData = $tr.data("data");
			showConfirmDialog(function() {
				// 异步请求
				$.ajax({
					type : "GET",
					cache : false,
					dataType : "json",
					url : "/yqsc/stores/delete.json?id=" + rowData.id,
					success : function(data) {
						if (data != undefined && data.isSuccess == true) {
							showPopup("删除成功!");
							$("#pf-table-members").bootstrapTable("refresh");
						} else {
							showAlertDialog(data.message, "异常");
						}
					}
				});
			}, "是否删除商户：" + rowData.storeName, "系统");
		});

		// 审核按钮
		$(document).on("click", ".verify", function() {
			var $tr = $(this).closest("tr");
			// 行数据
			var rowData = $tr.data("data");
			showConfirmDialog(function() {
				// 异步请求
				$.ajax({
					type : "GET",
					cache : false,
					dataType : "json",
					url : "/yqsc/stores/audit.json?done=true&id=" + rowData.id,
					success : function(data) {
						if (data != undefined && data.isSuccess == true) {
							showPopup("审核成功!");
							$("#pf-table-members").bootstrapTable("refresh");
						} else {
							showAlertDialog(data.message, "异常");
						}
					}
				});
			}, "是否审核商户：" + rowData.storeName, "系统");
		});
		
		// 分佣设置按钮
		$(document).on("click", ".saleSet", function() {
			var sale = window.prompt("请设置分佣比例");
			if(sale != null && sale !=''){
				var $tr = $(this).closest("tr");
				// 行数据
				var rowData = $tr.data("data");
				showConfirmDialog(function() {
					// 异步请求
					$.ajax({
						type : "GET",
						cache : false,
						dataType : "json",
						url : "/yqsc/stores/saleSet.json?sale="+sale+"&id=" + rowData.id,
						success : function(data) {
							if (data != undefined && data.isSuccess == true) {
								showPopup("设置成功!");
								$("#pf-table-members").bootstrapTable("refresh");
							} else {
								showAlertDialog(data.message, "异常");
							}
						}
					});
				}, "是否设置比例为：" + sale, "系统");
			}
			
		});
		
		
				// 拒绝按钮
		$(document).on("click", ".btn-primary", function() {
			var $tr = $(this).closest("tr");
			// 行数据
			var rowData = $tr.data("data");
			showConfirmDialog(function() {
				// 异步请求
				$.ajax({
					type : "GET",
					cache : false,
					dataType : "json",
					url : "/yqsc/stores/audit.json?done=false&id=" + rowData.id,
					success : function(data) {
						if (data != undefined && data.isSuccess == true) {
							showPopup("拒绝成功!");
							$("#pf-table-members").bootstrapTable("refresh");
						} else {
							showAlertDialog(data.message, "异常");
						}
					}
				});
			}, "是否拒绝审核商户：" + rowData.storeName, "系统");
		});
	},
	// 初始化应用表格
	_init_app_table : function() {
		$("#pf-table-members").bootstrapTable({
			method : 'get',
			url : "/yqsc/stores/all.json",
			cache : false,
			// height : 400,
			sidePagination : 'server', // client or server
			queryParamsType : 'pageSize',
			search : true,
			striped : true,
			clickToSelect : true,
			pagination : true,
			pageSize : 20,
			pageList : [ 10, 20, 50, 100, 200 ],
			paginationDetail : true,
			paginationHAlign : 'right', // right, left
			showColumns : true,
			showRefresh : true,
			minimumCountColumns : 2,
			checkboxHeader : true,
			ct : true,
			onLoadSuccess : function() {
			},
			columns : [ {
				field : 'id',
				title : '商户编号',
				align : 'center',
				valign : 'middle',
				visible : true,
				sortable : false

			}, {
				field : 'storeName',
				title : '商户名称',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false
			}, {
				field : 'createBy',
				title : '会员名称',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false
			}, {
				field : 'mobile',
				title : '手机',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false
			}, {
				field : 'weixin',
				title : '微信',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false
			},  {
				field : 'audit',
				title : '审核状态',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false,
				formatter : function(value, row, index) {
					return (value == 1) ? "审核通过" : "审核中";
				}
			}, {
				field : 'accountBalance',
				title : '商户积分',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false
			}, {
				field : 'saleScore',
				title : '商户分佣比例%',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false
			}, {
				field : 'score_do_tixian',
				title : '已提现总额',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false
			}, {
				field : 'score_can_tixian',
				title : '未提现总额',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false
			},  {
				field : 'oprate',
				title : '操作',
				align : 'left',
				valign : 'middle',
				visible : true,
				sortable : false,
				formatter : function(value, row, index) {
					var html = ' <a _href="/yqsc/storeAccountDetail?storeId=' + row.id + '" class="am-btn am-btn-success am-btn-xs newAccountAmount">充值</a>&nbsp;';
					html = html + ' <a  class="am-btn am-btn-success am-btn-xs saleSet">分佣设置</a>&nbsp;';
					html = html + ' <a  class="am-btn am-btn-success am-btn-xs verify">通过</a>&nbsp;';
					html = html + '<a  class="am-btn btn-primary am-btn-xs">拒绝</a>&nbsp;';
					html = html + '<a class="am-btn am-btn-danger am-btn-xs pf-table-btn-delete" style="margin-right:5px;">删除</a>';
					return html;
				}

			} ]
		});
	},

	site_preview : function() {
		$(document).on(
				"click",
				".newAccountAmount",
				function() {
					if ($.support.leadingWhitespace) {
						alert("不支持在IE浏览器下充值，建议使用谷歌浏览器或者360极速浏览器或者直接在微信上预览。");
						return;
					}
					var left = ($(window).width() - 850) / 2;
					window.open($(this).attr("_href"), "充值", "height=650,width=850,top=100,left=" + left
							+ ",toolbar=yes,menubar=yes,scrollbars=no, resizable=no,location=no, status=no");
				});
	},

	// 上传图片控件的点击事件
	_reg_files_event : function() {
		bindFileChange("headPhotoFile");
		/** 绑定文件选择后的事件处理 */
		function bindFileChange(fileId) {
			$("#" + fileId).bind(
					"change",
					function() {
						var fileName = $(this).val();
						if (fileName == "") {
							showPopup("请选择图片");
							return;
						} else if (fileName.indexOf(".jpg") > 0 || fileName.indexOf(".jpeg") > 0 || fileName.indexOf(".png") > 0 || fileName.indexOf(".gif") > 0
								|| fileName.indexOf(".JPG") > 0 || fileName.indexOf(".JPEG") > 0 || fileName.indexOf(".PNG") > 0 || fileName.indexOf(".GIF") > 0
								|| fileName.indexOf(".bmp") > 0) {
							if (!checkImgSize(fileId, 0.5)) {
								$(this).val("");
								return;
							}
							$("#" + fileId).parent().next().html('');
							if (window.FileReader) {
								var fr = new FileReader();
								fr.onloadend = function(e) {
									$("#" + fileId).parent().next().append('<img src="' + e.target.result + '"  alt="" class="thumbnail" style="height: 100px;">');
								};
								fr.readAsDataURL(this.files[0]);
							}
						} else {
							$(this).val("");
							showPopup("图片格式不正确！");
							return;
						}
					});
		}

		/** 校验图片大小 */
		function checkImgSize(fileId, imgSize) {
			if (!imgSize) {
				imgSize = 1;
			}
			var file = document.getElementById(fileId);
			var totalSize = 0;
			for (var i = 0; i < file.files.length; i++) {
				if (file.files[i].size >= 1024 * 1024 * imgSize) {
					showPopup("图片[" + file.files[i].name + "]不能超过" + imgSize + "M");
					return false;
				}
				totalSize += file.files[i].size;

			}
			if (totalSize >= 1024 * 1024 * 5) {
				showPopup("图片上传，不能超过5M");
				return false;
			}
			return true;
		}

	},
	// 注册新会员按钮事件
	_reg_add_members_btn_event : function() {
		$("#pf-add-member-btn").click(function() {
			//
			var $modal = $("#pf-modal-user");
			// 输入字段全部置为空
			$modal.find("input[type='text']").val("");
			$("#lbl_password").text("初始密码");
			$("#password").val("123456");
			$("#accountBalance").val("0");

			$("#id").val("");
			$("input[type='radio'][name='innerUser'][value='false']").trigger("click");
			$("#pf-modal-user").modal('show');
		});
	},
	// 注册或者编辑 会员，弹出框的保存按钮事件
	_reg_save_member_btn_event : function() {
		Ladda.bind('#btn-save-user');
		// 保存并使用按钮
		$("#btn-save-user").click(function() {
			// 用户名
			if (validate($("#userName"), "用户名不能为空") == false) {
				return;
			}
			// 昵称
			if (validate($("#nickName"), "昵称不能为空") == false) {
				return;
			}
			// 真实姓名
			if (validate($("#trueName"), "真实姓名不能为空") == false) {
				return;
			}
			if ($("#id").val() == "" && $("#password").val() == "") {
				if (validate($("#password"), "初始密码不能为空") == false) {
					return;
				}
			}
			// 电话
			if (validate($("#mobile"), "手机号不能为空") == false) {
				return;
			}
			// 邮箱
			/*
			 * if (validate($("#email"), "邮箱不能为空") == false) { return; }
			 */
			$("#saveForm").ajaxSubmit({
				dataType : "json",
				success : function(data) {
					// 关闭加载中
					Ladda.stopAll();
					if (data != undefined) {
						if (data.isSuccess == true) {
							showPopup("保存成功!");
							$("#pf-table-members").bootstrapTable("refresh");
							$("#pf-modal-user").modal('hide');
						} else {
							showPopup(data.message);
						}
					} else {
						showPopup("保存失败!");
					}
				}
			});

		});
		/** 校验方法 */
		function validate($input, errorMsg) {
			var val = $input.val();
			if ($.trim(val) == "") {
				showPopup(errorMsg);
				$input.focus();
				Ladda.stopAll();
				return false;
			} else {
				return true;
			}
		}
	}

}
MembersObject.init();
