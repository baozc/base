			var lottery = 0;
            var Secondms_jx = 60*1000;
            var minutems_jx = 1000;
            var wait_time = 0;
        
            function show_date_time(diff,obj) {
				
                if(diff <= 0) {
                    $("#liMinute").html('00');
                    $("#liSecond").html('00');
                    $("#liMilliSecond").html('00');
                    if(lottery==0){ //#
                        rTimeout = window.clearTimeout(rTimeout);
                        $('#divLotteryTime').html("<span >计算中...</span>");
        
                        setTimeout(function(){
                            lottery = 1;
							 $.post('/content/lotteryy','skin=product&id='+key,function(data){
							window.location.reload();
							 },'json');
                        }, 3000);
                                    }
                    return false;
                }
        
                DifferSecond   = Math.floor(diff / Secondms_jx);
                diff -= DifferSecond * Secondms_jx;
                DifferMinute   = Math.floor(diff / minutems_jx);
                diff -= DifferMinute * minutems_jx;
        
                if(DifferSecond.toString().length < 2) DifferSecond = '0'+DifferSecond;
                if(DifferMinute.toString().length < 2) DifferMinute = '0'+DifferMinute;
        
                wait_time=wait_time-1000;
                $("#liMinute").html(DifferSecond);
                $("#liSecond").html(DifferMinute);
        
                if($("#jx_load").is(':visible')){
                    $("#jx_load").hide();
                    $('#jx_clock').show();
                }
            }
            $(document).ready(function(){
                wait_time = parseInt(lost_time);				
                rTimeout = window.setInterval(function(){ show_date_time(wait_time, null); }, 1000);
				show_date_time(wait_time, null);
        
                //毫秒单独计时
                var h = 100;
                timeID_h_jx = window.setInterval(function(){
                    if(h<=0) h = 100;
                    h = parseInt(h)-1;
                    if(h.toString().length < 1) h = '00';
                    if(h.toString().length == 1) h = '0'+h;
                    if(h.toString().length > 2) h = '99';
        
                    $("#liMilliSecond").html(h);
                }, 10);
            } );
			 $(function() {
  TouchSlide({
   slideCell : "#single-item",
   mainCell : ".bd",
   titCell : ".slick-dots li",
   titOnClassName : "slick-active"
  });
  tabs(".tab", ".tab-nav li", ".tab-item", "on", "click");

  $('.m-detail-codes-btn').bind('click', function() {
   $(this).hide();
   $('.m-detail-code').hide();
   $('.m-detail-codes').show();
   $('.m-detail-codes-btn-hide').show();
  })
  $('.m-detail-codes-btn-hide').bind('click', function() {
   $(this).hide();
   $('.m-detail-codes').hide();
   $('.m-detail-code').show();
   $('.m-detail-codes-btn').show();
  })
 });

 var isLoad = {
  "join" : false,
  "win" : false,
  "share" : false
 };

 function mLoad(type) {
  if (isLoad[type] == false) {
   if (type == 'share') {
    $('.shareList').more({
     'address' : '../../content/share_ajax/all@goods_id=34&type=db',
     'amount' : 10
    })
   } else {
    $('#' + type).pageload({
     url : '../ajax_' + type,
     param : 'id=874',
     trigger : '.getMore_' + type
    });
   }
   isLoad[type] = true;
  }
 }