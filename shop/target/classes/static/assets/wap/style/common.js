$(function() {
	scrollLoading();
});
function scrollLoading() {
	if ($(".scrollLoading").length > 0)
		$(".scrollLoading").scrollLoading();
}
// 确认消息
function zz_confirm(msg, url) {
	layer.confirm(msg, function() {
		if (url)
			location.href = url;
	});
}
// 判断时间断，问候
function welcome_time() {
	var now = new Date();
	var hour = now.getHours()
	var str = '';
	if (hour < 6) {
		str = "凌晨好！"
	} else if (hour < 9) {
		str = "早上好！"
	} else if (hour < 12) {
		str = "上午好！"
	} else if (hour < 14) {
		str = "中午好！"
	} else if (hour < 17) {
		str = "下午好！"
	} else if (hour < 19) {
		str = "傍晚好！"
	} else if (hour < 22) {
		str = "晚上好！"
	} else {
		str = "夜里好！"
	}
	document.getElementById('hello').innerHTML = str;
}
// 获取验证码 act操作类型
function getSmsVerify(act, btn, mobile) {
	mobile = mobile ? mobile : $('#mobile').val();
	btn = btn ? btn : '#btnSms';
	act = act ? act : 'sms_register';
	var scode = $('#scode').val();
	var username = $('#username').length > 0 ? $('#username').val() : '';
	var password = $('#password').length > 0 ? $('#password').val() : '';
	var D = {
		act : act,
		mobile : mobile,
		scode : scode,
		username : username,
		password : password
	};
	$.post("/welcome/sms", D, function(data) {
		var type = 8;
		if (data.isSuccess == true) {
			RemainTime(btn);
			type = 1;
			if ($('#btnVoice').length > 0)
				$('#btnVoice').hide();
		} else {
			$(".imgcode").attr("src", "/captcha?t=" + Math.random());
		}
		if (data.message)
			//layer.alert(data.message, type);
		alert(data.message);
	}, "json");
}
// 短信验证码按钮倒计时
var iTime = zTime = 60;
var Account;
function RemainTime(btn) {
	$(btn).attr('disabled', true);
	var iSecond, sSecond = "", sTime = "";
	if (iTime >= 0) {
		iSecond = parseInt(iTime % 60);
		iMinute = parseInt(iTime / 60);
		if (iSecond >= 0) {
			if (iMinute > 0) {
				sSecond = iMinute + "分" + iSecond + "秒";
			} else {
				sSecond = iSecond + "秒";
			}
		}
		sTime = sSecond;
		if (iTime == 0) {
			clearTimeout(Account);
			sTime = '获取短信验证码';
			$(btn).attr('disabled', false);
			iTime = zTime;
		} else {
			Account = setTimeout(function() {
				RemainTime(btn);
			}, 1000);
			iTime = iTime - 1;
		}
	}
	$(btn).val(sTime);
}
function getVoiceVerify(btn, mobile) {
	mobile = mobile ? mobile : $('#mobile').val();
	btn = btn ? btn : '#btnVoice';
	var D = {
		mobile : mobile,
		submit : 'ok'
	};
	$.post("welcome/voice", D, function(data) {
		var type = 8;
		if (data.error == 0) {
			RemainTime2(btn);
			type = 1;
			if ($('#btnSms').length > 0)
				$('#btnSms').hide();
		}
		if (data.message)
			layer.alert(data.message, type);
	}, "json");
}
function RemainTime2(btn) {
	$(btn).attr('disabled', true);
	var iSecond, sSecond = "", sTime = "";
	if (iTime >= 0) {
		iSecond = parseInt(iTime % 60);
		iMinute = parseInt(iTime / 60);
		if (iSecond >= 0) {
			if (iMinute > 0) {
				sSecond = iMinute + "分" + iSecond + "秒";
			} else {
				sSecond = iSecond + "秒";
			}
		}
		sTime = sSecond;
		if (iTime == 0) {
			clearTimeout(Account);
			sTime = '获取语音验证码';
			$(btn).attr('disabled', false);
			iTime = zTime;
		} else {
			Account = setTimeout(function() {
				RemainTime(btn);
			}, 1000);
			iTime = iTime - 1;
		}
	}
	$(btn).val(sTime);
}
function addToCart(id, type, obj, pre) {
	obj = obj ? obj : '';
	pre = pre ? pre : '';
	id = parseInt(id);
	var qty = ($('#qty_' + id).length > 0 && type != 'buy_buy') ? $('#qty_' + id).val() : 1;
	$.post('/cart/addCart.json', {
		id : id,
		qty : qty
	}, function(data) {
		if (data.success == false) {
			var params = ' ';
			if (data.url) {
				params = function() {
					location.href = data.url;
				};
			}
			layer.alert(data.message, 8, params);
		} else {
			if (type == 'buy' || type == 'buy_buy') {
				location.href = '/cart';
			} else if (type == 'free') {
				location.href = '/cart/free';
			} else {
				loadCart();
				// $('#cartNum,.cartNum').html(data.cartNum);
				// layer.alert('加入购物车成功','1');
				MoveBox(obj, id, pre);
			}
		}
	}, "json");
}
// 添加购物车
function addToBuy(id, type, obj, pre) {
	obj = obj ? obj : '';
	pre = pre ? pre : '';
	id = parseInt(id);
	var qty = ($('#qty_' + id).length > 0 && type != 'buy_buy') ? $('#qty_' + id).val() : 1;

	$.post('/buy/addCart.json', {
		"id" : id,
		"buyNum" : qty
	}, function(data) {
		if (data.success == false) {
			layer.alert(data.message, 8, params);
		} else {
			if (type == 'buy' || type == 'buy_buy') {
				location.href = '/buy/';
			} else {
				loadCart();
				MoveBox(obj, id, pre);
			}
		}
	}, "json");
}
function loadCart() {
	$.post('/cart/loadCart.json', {
		u : 1
	}, function(data) {
		// $('#cart_info').html(data.html);
		$('#cartNum,.cartNum').html(data.message.length);
	}, "json");
}
function delCart(id, type) {
	type = type ? type : 0;
	if (id) {
		$.post('/cart/deleteCart.json', {
			ids : id
		}, function(data) {
			if (type == 1) {
				location.reload();
			} else {
				loadCart();
			}
		});
	}
}
// 删除购物车
function delBuy(id, type) {
	if (id) {
		$.post('/buy/deleteCart.json', {
			ids : id
		}, function(data) {
			// 购物车明细中删除要刷新页面
			if (type == 1) {
				window.location.reload();
			} else {
				loadCart();
			}
		});

	}
}
// 加入购物车特效
function MoveBox(t, id, pre) {
	pre = pre ? pre : '';
	var divTop = $(t).offset().top;
	var divLeft = $(t).offset().left;
	var cartBox = $("#cartNum").last();
	var src = $('#buy_img_' + id + pre).attr('src');
	$('body').append('<div class="ui-cart-move"><img src="' + src + '" /></div>');
	var obj = $('.ui-cart-move').last();

	obj.css({
		"position" : "absolute",
		"z-index" : "1000",
		"left" : divLeft + "px",
		"top" : divTop + "px"
	}).animate({
		"left" : cartBox.offset().left + "px",
		"top" : cartBox.offset().top + "px"
	}, 500).fadeTo(0, 0.1, function() {
		obj.remove();
	});
}

// 设置为主页
function SetHome(obj, vrl) {
	try {
		obj.style.behavior = url('#default#homepage');
		obj.setHomePage(vrl);
	} catch (e) {
		if (window.netscape) {
			try {
				netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
			} catch (e) {
				alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为 true ,双击即可。");
			}
			/*
			 * var prefs = Components.classes[ @mozilla.org/preferences-service
			 * ].getService(Components.interfaces.nsIPrefBranch);
			 * prefs.setCharPref( browser.startup.homepage ,vrl);
			 */
		} else {
			alert("您的浏览器不支持，请按照下面步骤操作：\n1.打开浏览器设置。\n2.点击设置网页。\n3.输入：" + vrl + "点击确定。");
		}
	}
}
// 加入收藏 兼容360和IE6
function AddFavorites(sTitle, sURL) {
	try {
		window.external.AddFavorite(sURL, sTitle);
	} catch (e) {
		try {
			window.sidebar.addPanel(sTitle, sURL, "");
		} catch (e) {
			alert("加入收藏失败，请使用Ctrl+D进行添加");
		}
	}
}
// 第三方登录
function oauth(url) {
	// window.open(url,'newwindow','toolbar=no,scrollbars=yes,resizable=no,top=0,left=0,width=500,height=300');
	window.location.href = url;
}

// 终端模板切换
function tplDevice(cli) {
	var host = '1' + window.location.host;
	var url = '';
	if (host.indexOf('www.') == 1) {
		if (cli == 'mobile') {
			url = location.href.replace('www.', 'm.');
		}
	} else if (host.indexOf('m.') == 1) {
		if (cli == 'pc') {
			url = location.href.replace('m.', 'www.');
		}
	} else {
		if (location.search) {
			url = location.href + '&tpl=' + cli;
		} else {
			url = location.href + '?tpl=' + cli;
		}
	}
	if (url) {
		location.href = url;
	}
}

//揭晓商品轮询
$.getScript('/assets/wap/style/template-native.js');
var ids_time = 10; // 推送揭晓商品时间间隔
function compaceIds(skin){
    skin=skin?skin:'win';
    apiUrl=apiUrl?apiUrl:'';
    $.ajax({
        type: 'post',
        url: apiUrl+'/content/ajaxIds',
        data: 'skin='+skin+'&ids='+$('#ids').val(),
        dataType: apiUrl?'jsonp':'json',
        jsonp: "callback",
        success:function(data){
            if(data.error==1){
                var html = '';
                var list = data.listDjx.list;
                var index = 0;
                if(list.length>0){
                    for(var i = 0; i < list.length; i++){
                        if(list[i].wait_status==0){
                            html += template(skin+'AjaxTmpl', {
                                m:list[i],
                                index:index,
                                data:data.data
                            });
                            index++;
                            onload_leftTime_jx(list[i].buy_id,list[i].has_time,skin);
                        }
                    }
                }
                $('#ids').val(data.ids);
                $('#win-list').prepend(html);
            }
        }
    });
}