 
$(function(){
	$(".rel-form-radio span").click(function(){
		$(".rel-form-radio span").removeClass("custom-radio");
		$(this).addClass("custom-radio");
	});
	



	$(".mo-footer-left label").click(function(){
		
		if ($(this).parent("span").hasClass("all-check")) {
			$(this).parent("span").removeClass("all-check");
		} else{
			$(this).parent("span").addClass("all-check");
		}
	})
});

 
$(function(){
	
	
	$(".pop-btn").click(function(){
		$(".pop-shade").fadeIn(400);
		$(".pop-hide").fadeIn(400);
		$(".i-body").css("overflow","hidden");
	})
	$(".pop-shade").click(function(){
		
		$(".pop-hide").fadeOut(400);
		$(".pop-shade").fadeOut(400);
		$(".i-body").css("overflow","auto");
	})

	
	
});


 











