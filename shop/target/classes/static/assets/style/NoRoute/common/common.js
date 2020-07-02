/*
 * A JavaScript implementation of the RSA Data Security, Inc. MD5 Message
 * Digest Algorithm, as defined in RFC 1321.
 * Version 2.1 Copyright (C) Paul Johnston 1999 - 2002.
 * Other contributors: Greg Holt, Andrew Kepert, Ydnar, Lostinet
 * Distributed under the BSD License
 * See http://pajhome.org.uk/crypt/md5 for more info.
 */

/*
 * Configurable variables. You may need to tweak these to be compatible with
 * the server-side, but the defaults work in most cases.
 */
 if(location.href.indexOf("test.ylbang360.com")>0){//测试环境
	var commonad= "http://test.ylbang360.com/";
	var ajaxhost= "http://test2.miyukeji.com/";
 }else{//生产环境
	var commonad= "http://m.ylbang360.com/";
	var ajaxhost= "http://m.miyukeji.com/";
 }

 // function getOpenid (){
 //   wxAuth();
 //   return window.localStorage.getItem('openid')
 // }
var hexcase = 0;  /* hex output format. 0 - lowercase; 1 - uppercase        */
var b64pad  = ""; /* base-64 pad character. "=" for strict RFC compliance   */
var chrsz   = 8;  /* bits per input character. 8 - ASCII; 16 - Unicode      */

/*
 * These are the functions you'll usually want to call
 * They take string arguments and return either hex or base-64 encoded strings
 */
function hex_md5(s){ return binl2hex(core_md5(str2binl(s), s.length * chrsz));}
function b64_md5(s){ return binl2b64(core_md5(str2binl(s), s.length * chrsz));}
function str_md5(s){ return binl2str(core_md5(str2binl(s), s.length * chrsz));}
function hex_hmac_md5(key, data) { return binl2hex(core_hmac_md5(key, data)); }
function b64_hmac_md5(key, data) { return binl2b64(core_hmac_md5(key, data)); }
function str_hmac_md5(key, data) { return binl2str(core_hmac_md5(key, data)); }

/*
 * Perform a simple self-test to see if the VM is working
 */
function md5_vm_test()
{
  return hex_md5("abc") == "900150983cd24fb0d6963f7d28e17f72";
}

/*
 * Calculate the MD5 of an array of little-endian words, and a bit length
 */
function core_md5(x, len)
{
  /* append padding */
  x[len >> 5] |= 0x80 << ((len) % 32);
  x[(((len + 64) >>> 9) << 4) + 14] = len;

  var a =  1732584193;
  var b = -271733879;
  var c = -1732584194;
  var d =  271733878;

  for(var i = 0; i < x.length; i += 16)
  {
    var olda = a;
    var oldb = b;
    var oldc = c;
    var oldd = d;

    a = md5_ff(a, b, c, d, x[i+ 0], 7 , -680876936);
    d = md5_ff(d, a, b, c, x[i+ 1], 12, -389564586);
    c = md5_ff(c, d, a, b, x[i+ 2], 17,  606105819);
    b = md5_ff(b, c, d, a, x[i+ 3], 22, -1044525330);
    a = md5_ff(a, b, c, d, x[i+ 4], 7 , -176418897);
    d = md5_ff(d, a, b, c, x[i+ 5], 12,  1200080426);
    c = md5_ff(c, d, a, b, x[i+ 6], 17, -1473231341);
    b = md5_ff(b, c, d, a, x[i+ 7], 22, -45705983);
    a = md5_ff(a, b, c, d, x[i+ 8], 7 ,  1770035416);
    d = md5_ff(d, a, b, c, x[i+ 9], 12, -1958414417);
    c = md5_ff(c, d, a, b, x[i+10], 17, -42063);
    b = md5_ff(b, c, d, a, x[i+11], 22, -1990404162);
    a = md5_ff(a, b, c, d, x[i+12], 7 ,  1804603682);
    d = md5_ff(d, a, b, c, x[i+13], 12, -40341101);
    c = md5_ff(c, d, a, b, x[i+14], 17, -1502002290);
    b = md5_ff(b, c, d, a, x[i+15], 22,  1236535329);

    a = md5_gg(a, b, c, d, x[i+ 1], 5 , -165796510);
    d = md5_gg(d, a, b, c, x[i+ 6], 9 , -1069501632);
    c = md5_gg(c, d, a, b, x[i+11], 14,  643717713);
    b = md5_gg(b, c, d, a, x[i+ 0], 20, -373897302);
    a = md5_gg(a, b, c, d, x[i+ 5], 5 , -701558691);
    d = md5_gg(d, a, b, c, x[i+10], 9 ,  38016083);
    c = md5_gg(c, d, a, b, x[i+15], 14, -660478335);
    b = md5_gg(b, c, d, a, x[i+ 4], 20, -405537848);
    a = md5_gg(a, b, c, d, x[i+ 9], 5 ,  568446438);
    d = md5_gg(d, a, b, c, x[i+14], 9 , -1019803690);
    c = md5_gg(c, d, a, b, x[i+ 3], 14, -187363961);
    b = md5_gg(b, c, d, a, x[i+ 8], 20,  1163531501);
    a = md5_gg(a, b, c, d, x[i+13], 5 , -1444681467);
    d = md5_gg(d, a, b, c, x[i+ 2], 9 , -51403784);
    c = md5_gg(c, d, a, b, x[i+ 7], 14,  1735328473);
    b = md5_gg(b, c, d, a, x[i+12], 20, -1926607734);

    a = md5_hh(a, b, c, d, x[i+ 5], 4 , -378558);
    d = md5_hh(d, a, b, c, x[i+ 8], 11, -2022574463);
    c = md5_hh(c, d, a, b, x[i+11], 16,  1839030562);
    b = md5_hh(b, c, d, a, x[i+14], 23, -35309556);
    a = md5_hh(a, b, c, d, x[i+ 1], 4 , -1530992060);
    d = md5_hh(d, a, b, c, x[i+ 4], 11,  1272893353);
    c = md5_hh(c, d, a, b, x[i+ 7], 16, -155497632);
    b = md5_hh(b, c, d, a, x[i+10], 23, -1094730640);
    a = md5_hh(a, b, c, d, x[i+13], 4 ,  681279174);
    d = md5_hh(d, a, b, c, x[i+ 0], 11, -358537222);
    c = md5_hh(c, d, a, b, x[i+ 3], 16, -722521979);
    b = md5_hh(b, c, d, a, x[i+ 6], 23,  76029189);
    a = md5_hh(a, b, c, d, x[i+ 9], 4 , -640364487);
    d = md5_hh(d, a, b, c, x[i+12], 11, -421815835);
    c = md5_hh(c, d, a, b, x[i+15], 16,  530742520);
    b = md5_hh(b, c, d, a, x[i+ 2], 23, -995338651);

    a = md5_ii(a, b, c, d, x[i+ 0], 6 , -198630844);
    d = md5_ii(d, a, b, c, x[i+ 7], 10,  1126891415);
    c = md5_ii(c, d, a, b, x[i+14], 15, -1416354905);
    b = md5_ii(b, c, d, a, x[i+ 5], 21, -57434055);
    a = md5_ii(a, b, c, d, x[i+12], 6 ,  1700485571);
    d = md5_ii(d, a, b, c, x[i+ 3], 10, -1894986606);
    c = md5_ii(c, d, a, b, x[i+10], 15, -1051523);
    b = md5_ii(b, c, d, a, x[i+ 1], 21, -2054922799);
    a = md5_ii(a, b, c, d, x[i+ 8], 6 ,  1873313359);
    d = md5_ii(d, a, b, c, x[i+15], 10, -30611744);
    c = md5_ii(c, d, a, b, x[i+ 6], 15, -1560198380);
    b = md5_ii(b, c, d, a, x[i+13], 21,  1309151649);
    a = md5_ii(a, b, c, d, x[i+ 4], 6 , -145523070);
    d = md5_ii(d, a, b, c, x[i+11], 10, -1120210379);
    c = md5_ii(c, d, a, b, x[i+ 2], 15,  718787259);
    b = md5_ii(b, c, d, a, x[i+ 9], 21, -343485551);

    a = safe_add(a, olda);
    b = safe_add(b, oldb);
    c = safe_add(c, oldc);
    d = safe_add(d, oldd);
  }
  return Array(a, b, c, d);

}

/*
 * These functions implement the four basic operations the algorithm uses.
 */
function md5_cmn(q, a, b, x, s, t)
{
  return safe_add(bit_rol(safe_add(safe_add(a, q), safe_add(x, t)), s),b);
}
function md5_ff(a, b, c, d, x, s, t)
{
  return md5_cmn((b & c) | ((~b) & d), a, b, x, s, t);
}
function md5_gg(a, b, c, d, x, s, t)
{
  return md5_cmn((b & d) | (c & (~d)), a, b, x, s, t);
}
function md5_hh(a, b, c, d, x, s, t)
{
  return md5_cmn(b ^ c ^ d, a, b, x, s, t);
}
function md5_ii(a, b, c, d, x, s, t)
{
  return md5_cmn(c ^ (b | (~d)), a, b, x, s, t);
}

/*
 * Calculate the HMAC-MD5, of a key and some data
 */
function core_hmac_md5(key, data)
{
  var bkey = str2binl(key);
  if(bkey.length > 16) bkey = core_md5(bkey, key.length * chrsz);

  var ipad = Array(16), opad = Array(16);
  for(var i = 0; i < 16; i++)
  {
    ipad[i] = bkey[i] ^ 0x36363636;
    opad[i] = bkey[i] ^ 0x5C5C5C5C;
  }

  var hash = core_md5(ipad.concat(str2binl(data)), 512 + data.length * chrsz);
  return core_md5(opad.concat(hash), 512 + 128);
}

/*
 * Add integers, wrapping at 2^32. This uses 16-bit operations internally
 * to work around bugs in some JS interpreters.
 */
function safe_add(x, y)
{
  var lsw = (x & 0xFFFF) + (y & 0xFFFF);
  var msw = (x >> 16) + (y >> 16) + (lsw >> 16);
  return (msw << 16) | (lsw & 0xFFFF);
}

/*
 * Bitwise rotate a 32-bit number to the left.
 */
function bit_rol(num, cnt)
{
  return (num << cnt) | (num >>> (32 - cnt));
}

/*
 * Convert a string to an array of little-endian words
 * If chrsz is ASCII, characters >255 have their hi-byte silently ignored.
 */
function str2binl(str)
{
  var bin = Array();
  var mask = (1 << chrsz) - 1;
  for(var i = 0; i < str.length * chrsz; i += chrsz)
    bin[i>>5] |= (str.charCodeAt(i / chrsz) & mask) << (i%32);
  return bin;
}

/*
 * Convert an array of little-endian words to a string
 */
function binl2str(bin)
{
  var str = "";
  var mask = (1 << chrsz) - 1;
  for(var i = 0; i < bin.length * 32; i += chrsz)
    str += String.fromCharCode((bin[i>>5] >>> (i % 32)) & mask);
  return str;
}

/*
 * Convert an array of little-endian words to a hex string.
 */
function binl2hex(binarray)
{
  var hex_tab = hexcase ? "0123456789ABCDEF" : "0123456789abcdef";
  var str = "";
  for(var i = 0; i < binarray.length * 4; i++)
  {
    str += hex_tab.charAt((binarray[i>>2] >> ((i%4)*8+4)) & 0xF) +
           hex_tab.charAt((binarray[i>>2] >> ((i%4)*8  )) & 0xF);
  }
  return str;
}

/*
 * Convert an array of little-endian words to a base-64 string
 */
function binl2b64(binarray)
{
  var tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  var str = "";
  for(var i = 0; i < binarray.length * 4; i += 3)
  {
    var triplet = (((binarray[i   >> 2] >> 8 * ( i   %4)) & 0xFF) << 16)
                | (((binarray[i+1 >> 2] >> 8 * ((i+1)%4)) & 0xFF) << 8 )
                |  ((binarray[i+2 >> 2] >> 8 * ((i+2)%4)) & 0xFF);
    for(var j = 0; j < 4; j++)
    {
      if(i * 8 + j * 6 > binarray.length * 32) str += b64pad;
      else str += tab.charAt((triplet >> 6*(3-j)) & 0x3F);
    }
  }
  return str;
}

function random(min,max){
	return Math.floor(min+Math.random()*(max-min));
}


//float comparation
function num_f(a)
{
	a = parseFloat(a);
	if(isNaN(a)) return 0;

	var PRECISION = 2;
	var dec = Math.pow(10, PRECISION);
	return Math.round(a * dec) / dec;
}
function cmp_f(a, op, b)
{
	eval('r = num_f(' + a + '-' + b  + ')' + op + '0');
	return r;
}

//object copy
function obj_cpy(a)
{
	if(arguments.lenght < 1)
		return {};

	var obj;
	if(typeof(a) === 'object')
	{
	    obj= (a.constructor === Array)?[]:{};
	    for(var i = 0; i < arguments.length; i++)
	    {
	    	var dist_obj = arguments[i];
	        for(var name in dist_obj)
	        {
	        	if(dist_obj.hasOwnProperty(name))
	        	{
		            if(typeof(dist_obj[name]) === 'object')
		                obj[name] = obj_cpy(dist_obj[name]);
		            else
		                obj[name] = dist_obj[name];
	        	}
	        }
	    }
	}
	else
		obj = a;

	return obj;
};

function in_array(value, array)
{
	var i = array.length;
	while (i--)
	{
		if (array[i] === value)
			return true;
	}
	return false;
}

Date.prototype.toMyString = function()
{
	return this.getFullYear() + '-' + (this.getMonth() < 9 ? '0':'') + (this.getMonth() + 1) + '-' + (this.getDate() < 10 ? '0':'') + this.getDate();
}
Date.prototype.cmpDate = function()
{
	if(arguments.length < 2)
		return undefined;

	eval_str = 'ret_val = ' + this.getTime() + arguments[0] + arguments[1].getTime();
	eval(eval_str);
	return ret_val;
}
Date.prototype.addDay = function()
{
	var add_day = 0;
	if(arguments.length > 0) add_day = parseInt(arguments[0]); if(isNaN(add_day)) add_day = 0;
	this.setTime(this.getTime() + 86400000 * add_day);
}
Date.prototype.dupDate = function()
{
	var date = new Date;
	date.setTime(this.getTime());
	return date;
}

/* 检测IE兼容性 */
function IEtest()
{
	  var Sys = {};
		var ua = navigator.userAgent.toLowerCase();
		var s;

		(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :

		(s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :

		(s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :

		(s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :

		(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

		if (Sys.ie)
		{
			var version = (Sys.ie).match(/6\.0/);
			if(version == "6.0")
			{
				window.location.replace("http://www.yzg365.com/app/html/updatebrowser.html");
			}
			else
			{
				return Sys.ie;
			}
		}
		else
		{
			return s;
		}
}


// <summary>
// 格式化显示日期时间
// </summary>
// <param name="x">待显示的日期时间，例如new Date()</param>
// <param name="y">需要显示的格式，例如yyyy-MM-dd hh:mm:ss</param>
function date2str(x,y) {
 var z = {M:x.getMonth()+1,d:x.getDate(),h:x.getHours(),m:x.getMinutes(),s:x.getSeconds()};
 y = y.replace(/(M+|d+|h+|m+|s+)/g,function(v) {return ((v.length>1?"0":"")+eval('z.'+v.slice(-1))).slice(-2)});
 return y.replace(/(y+)/g,function(v) {return x.getFullYear().toString().slice(-v.length)});
}

/**
 * 设置cookie
 * @param cookieName
 * @param cookieValue
 * @param seconds 过期时间
 * @param path 路径
 * @param domain 域
 */
function setCookie(cookieName,cookieValue, seconds, path, domain, secure) {
	var expires = new Date();
	expires.setTime(expires.getTime() + seconds);
	document.cookie = cookieName + '=' + escape(cookieValue) + (seconds ? '; expires=' + expires.toGMTString() : '') + (path ? '; path=' + path : '/') + (domain ? '; domain=' + domain : '') + (secure ? '; secure' : '');
}
//获取cookie
function getCookie(c_name){
	if (document.cookie.length > 0){
		c_start=document.cookie.indexOf(c_name + "=");
		if (c_start != -1){
			c_start=c_start + c_name.length + 1;
			c_end=document.cookie.indexOf(";", c_start);
			if (c_end == -1) c_end = document.cookie.length;
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

//获取域名
function getHost(url) {
	var host = "null";
	if (typeof url == "undefined" || null == url) url = window.location.href;
	var regex = /.*\:\/\/([^\/|:]*).*/;
	var match = url.match(regex);
	if (typeof match != "undefined" && null != match) host = match[1];
	if (typeof host != "undefined" && null != host) {
		var strAry = host.split(".");
		if (strAry.length > 1) host = strAry[strAry.length - 2] + "." + strAry[strAry.length - 1];
	}
	return host;
}

function getParamByUrl(name){
	var search = decodeURI(location.href);
	var result = search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
	if (result == null || result.length < 1) {
		return "";
	}

	if (result[1].indexOf('#') > 0 || result[1].indexOf('#') == 0) {
        result[1] = result[1].slice(0, result[1].indexOf('#'));
    }
	return result[1];
};

function is_weixn(){
    var ua = navigator.userAgent.toLowerCase();
    if(ua.match(/MicroMessenger/i)=="micromessenger") {
        return true;
    } else {
        return false;
    }
}

function wxAuth(initAjax){
	if(!is_weixn()){
		initAjax();
		return null;
	}
	var openid = window.localStorage.getItem("openid");
	console.log("wxAuthz:"+openid);
	if(openid == null){
		var code = getParamByUrl('code');
		if(code) {
			if (code.indexOf('#') != -1) {
				code = code.slice(0, code.indexOf('#'))
			}
			$.post("http://m.miyukeji.com/Home/Account/ajaxWxUserByCode", {code:code},function(res){
				if(res.rsc === '1001'){
					openid = res.data.openid;
					window.localStorage.setItem('openid', openid);
					initAjax();
				} else {
					if (localStorage.getOp != 'true') {
						localStorage.getOp = 'true';
						getOpid();
					}
				}
			});
		} else {
			getOpid()
		}

		function getOpid () {
			var url = 'http://m.ylbang360.com/get-weixin-code.html';
			var redirect_uri = encodeURIComponent(window.location.href);
			var scope = 'snsapi_userinfo';
			var state = 'weixin';
			var appid = 'wx3f42f08d4aa88322';
			var wx_href = url+'?appid='+appid+'&redirect_uri='+redirect_uri+'&scope='+scope+'&state='+state;
			window.location.href = wx_href;
		}
	}else{
		initAjax();
	}
}



function timeOut(id){
  var value = $('.' + id).val()
  $('.'+id).attr('disabled','disabled').val('提交中')
  setTimeout(function(){
    $('.'+id).removeAttr('disabled').val(value)
  },5000)
}



// 百度统计
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?0c11acafe0510093dd5f2c2d4dfe8ac0";
  var s = document.getElementsByTagName("script")[0];
  s.parentNode.insertBefore(hm, s);
})();


//验证手机号是否合法
function _m_verify_tel (str) {
  if (str[0] == 1 && str.length == 11) {
    return true
  } else {
    return false
  }
}
