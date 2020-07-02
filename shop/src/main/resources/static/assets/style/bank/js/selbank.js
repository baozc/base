;$(function(){
    $(".hotBank-list-ico").bind('click',function(){
    	$('#chose_input').val($(this).attr('title'));
        $('.bank_xl').hide();
        $("#chose_bank").parent('div').find('img').addClass('jt_xz');
    });
    $("#chose_bank").click(function(){
    	var Obank_xl = $('.bank_xl');
    	var Ochose_bank = $("#chose_bank").parent('div').find('img');
        if (Obank_xl.is(':hidden')) {
        	Obank_xl.show();
        	Ochose_bank.removeClass('jt_xz');
        }else{
        	Obank_xl.hide();
        	Ochose_bank.addClass('jt_xz');
        }
    });
});