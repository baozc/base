<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/taglibs.jsp"%>
	<title>交易投诉</title>
	<meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="${wapBase}/style/charge/css/charge.css">
	<link rel="stylesheet" href="${wapBase}/style/charge/css/reset.css">
	<script src="${wapBase}/style/charge/js/jquery.min.js"></script>
	<style>
	.up-imgs,.close-upimg{display: block;width: 29.5%;height: 9rem;float: left;margin: 5px 5px;}
	.z_photo .z_file{
		position: relative;
	}
	.z_file  .file{
		width: 100%;
		/*height: 100%;*/
		opacity: 0;
		position: absolute;
		top: 0px;
		left: 0px;
		z-index: 100;
	}
	.pic-container {
	    min-height: 120px;
	    height: 100%;
	    display: inline-table;
	    padding-left: 3px;
	    padding-bottom: 5px;
	}
	.pic-evdc {
	    display: block;
	    width: 29.5%;
	    height: 9.1rem;
	    float: left;
	    margin: 5px 5px;
	    /*border: 1px solid #ACACAC;*/
	}
	</style>
</head>
<body>
<div class="">
<p class="tips-notice">商家在哪里发布违规信息?</p>
<ul class="charge-list">
	<li class="charge-classes" id="official-account">公众号</li>
	<li class="charge-classes" id="app">应用(app)</li>
	<li class="charge-classes" id="website">网站</li>
	<li class="charge-classes" id="others">其他</li>
</ul>
</div>

<section class="detail-container">
	<div class="site-box" id="site-box">
		<p class="tips-notice" id="charge-class"></p>

		<p><input type="text" name="charge_name" style="padding-left: 5px;margin: auto;"></p>

	</div>

	<div class="desc-box" id="desc-box">
		<p class="tips-notice" id="charge-desc">描述</p>
		<textarea  name="" id="item-desc" cols="30" rows="10" placeholder="请说明而已类型, 描述交易过程"></textarea>
	</div>

	<div class="pic-box" id="pic-box">
	<p class="tips-notice" id="charge-desc">图片证据(选填)</p>
		<p class="tips-pic">最多可上传6张图
		<div class="pic-container">
			<section class="z_file fl">
				<img class="pic-evdc" id="pic-evdc" name="file" src="${wapBase}/style/charge/images/sdf_a.jpg" alt="">
				<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple="">
			</section>
		</div>
	</div>

	<input type="button" class="charge-submit" id="charge-submit" value="提交">

</section>

<!-- <aside class="mask works-mask">
	<div class="mask-content">
		<p class="del-p ">您确定要删除图片吗？</p>
		<p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
	</div>
</aside> -->

<script>
	$(function() {
        var $siteBox = $('#site-box');
        var $descBox = $('#desc-box');
        var $picBox = $('#pic-box');
        var $chargeSubmit = $('#charge-submit');
        var $getSite = $('#get-site');

        $siteBox.hide();
        $descBox.hide();
        $picBox.hide();
        $chargeSubmit.hide();

        $('li').on('click', function(e) {
            $('li img').remove();
            $(this).append('<img class="check" src="${wapBase}/style/charge/images/check.png" alt="">' + '</img>');
            $descBox.show();
            $picBox.show();
            $chargeSubmit.show();
            $siteBox.show();

        });

        $('li').on('click', function(){
			$('#charge-class').text($(this).text())
		});

		// $('#website').on('click', function(){
		//     $('#charge-class').append('<a class="get-site" id="get-site" href="get-site.html">'+ '如何获取网址' + '</a>');
		// });

		$('.charge-submit').on('click', function(){
			if($('#item-desc').val()){
				window.location = '/charge-success.php';
			}else{
				alert('请输入描述');
			}
		});


    });
</script>
<!-- <script src="js/imgUp.js"></script> -->
<script>
	$(function(){
	var delParent;
	var defaults = {
		fileType         : ["jpg","JPG","png","PNG","gif","bmp","jpeg"],		// 上传文件的类型
		fileSize         : 1024 * 1024 * 1                  // 上传文件的大小 10M
	};
	$('#pic-evdc').on('click', function(){
		$("#file").click();
	});
	
	/*点击图片的文本框*/
	$(".file").change(function(){

		var idFile = $(this).attr("id");
		var file = document.getElementById(idFile);
		var imgContainer = $(this).parents(".pic-container");	//存放图片的父亲元素
		var fileList = file.files; 								//获取的图片文件
		var input = $(this).parent();							//文本框的父亲元素
		var imgArr = [];
		//遍历得到的图片文件
		var numUp = imgContainer.find(".up-section").length;
		var totalNum = numUp + fileList.length;  //总的数量
		
		// $('.picnum').text(fileList.length);
		if(fileList.length > 6 || totalNum > 6 ){
			alert("上传图片数目不可以超过6个，请重新选择");  //一次选择上传超过6个 或者是已经上传和这次上传的到的总数也不可以超过5个
		}else if(numUp < 6){
			
			fileList = validateUp(fileList);
			// $('.picnum').text(fileList.length);
			if($('.up-section').length > 0){
				var $section = $(".up-section");
			}else{
				var $section = $("<section class='up-section fl loading'>");
				imgContainer.prepend($section);
			}
			
			for(var i = 0;i<fileList.length;i++){
				var imgUrl = window.URL.createObjectURL(fileList[i]);
				imgArr.push(imgUrl);
				// var $section = $("<section class='up-section fl loading'>");
				// imgContainer.prepend($section);
			 // var $span = $("<span class='up-span'>");
			 //     $span.appendTo($section);
			
		     var $img0 = $("<img class='close-upimg'>").on("click",function(event){
				    event.preventDefault();
					event.stopPropagation();
					$(".works-mask").show();
					delParent = $(this).parent();
				});   
				//$img0.attr("src","images/add-pic2.jpg").appendTo($section);
		     var $img = $("<img class='up-imgs up-opcity'>");
		         $img.attr("src",imgArr[i]);
		         $img.appendTo($section);
		     // var $p = $("<p class='img-name-p'>");
		     //     $p.html(fileList[i].name).appendTo($section);
		     // var $input = $("<input id='taglocation' name='taglocation' value='' type='hidden'>");
		     //     $input.appendTo($section);
		     // var $input2 = $("<input id='tags' name='tags' value='' type='hidden'/>");
		     //     $input2.appendTo($section);
		      
		   }
		}
		setTimeout(function(){
             $(".up-section").removeClass("loading");
		 	 $(".up-imgs").removeClass("up-opcity");
		 },0);
		 numUp = imgContainer.find(".up-section").length;
		if(numUp >= 6){
			$(this).parent().hide();
		}
	});
	
    $(".z_photo").delegate(".close-upimg","click",function(){
     	  $(".works-mask").show();
     	  delParent = $(this).parent();
	});
		
	$(".wsdel-ok").click(function(){
		$(".works-mask").hide();
		var numUp = delParent.siblings().length;
		if(numUp < 6){
			delParent.parent().find(".z_file").show();
		}
		 delParent.remove();
	});
	
	$(".wsdel-no").click(function(){
		$(".works-mask").hide();
	});
		
	function validateUp(files){
		var arrFiles = [];//替换的文件数组
		for(var i = 0, file; file = files[i]; i++){
			//获取文件上传的后缀名
			var newStr = file.name.split("").reverse().join("");
			if(newStr.split(".")[0] != null){
					var type = newStr.split(".")[0].split("").reverse().join("");
					// console.log(type+"===type===");
					// if(jQuery.inArray(type, defaults.fileType) > -1){
					// 	// 类型符合，可以上传
					// 	if (file.size >= defaults.fileSize) {
					// 		// alert(file.size);
					// 		alert('"'+ file.name +'"文件大小过大');	
					// 	} else {
							// 在这里需要判断当前所有文件中
							arrFiles.push(file);	
					// 	}
					// }else{
					// 	alert('"'+ file.name +'"上传类型不符合');	
					// }
				}else{
					alert('"'+ file.name +'"不支持的文件类型');	
				}
		}
		return arrFiles;
	}
	
})
</script>
</body>
</html>