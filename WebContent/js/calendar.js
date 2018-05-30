
$(document).ready(function(){

	
	$('#enviar').prop('disabled', true);
	
	$(".required").focusout(
			
			function(){
				
				if($.trim($(this).val())==""){
					$(this).addClass("requiredError");
				}
				
				
			});
	
	$(".required").focus(
			function(){
				$(this).removeClass("requiredError");
			});	

	
	
$("#rePass").keyup(	
	function(){
		console.log($.trim($("#rePass").val() +"---" + $.trim($("#pass").val())));
		

		if($.trim($("#rePass").val()) != $.trim($("#pass").val())){
			console.log("amor 2");

			$("#rePass").addClass("errorPass");
		}else{
			$("#rePass").removeClass("errorPass");
		};
		
	});
	

$(document).ajaxError(function(event, jqXHR, settings, exception) { console.log(exception) });
	

$("#nameUser").keyup(
	
	function(){	
		$.post("nombreRepetido", 
				{user : $('#nameUser').val()},
				function(data) {
					console.log(data);
					console.log(data.isRepeated);
					if(data.isRepeated ){
						$('#nameUser').addClass("nameRepited");
					}else if(!data.isRepeated){
						$("#nameUser").removeClass("nameRepited");
					}
					comprobar();
				},"json");
		
	});



$("#mailUser").keyup(
		function(){	
			
			$.post("mailComprovation", 
					{mail : $('#mailUser').val()},
					function(data) {						
						console.log(data);
						console.log(data.isRepeated);
						if(data.wrongFormat || data.isRepeated ){
							$('#mailUser').addClass("mailWrongformat");
						}else if(!data.wrongFormat || !data.isRepeated){
							$("#mailUser").removeClass("mailWrongformat");
						}
						comprobar();	
						
					},"json");
			
		} 
		 
);


function comprobar(){
	 
 	var usuario = $.trim($("#nameUser").val());
 	var mail = 	$.trim($("#mailUser").val());
 	var pass = $.trim($("#pass").val());
 	var repass = $.trim($("#rePass").val());
 
	if($('#mailUser').hasClass("mailWrongformat")||
		$('#nameUser').hasClass("nameRepited")||
		$(".required").hasClass("requiredError")||
		$("#rePass").hasClass("errorPass")
		||usuario==""||mail==""||pass==""||repass==""){
		
		$("#enviar").prop('disabled', true);
		
	}else{
		
		$("#enviar").prop('disabled', false);
		
	}
}



$(".required").keyup(
	function(){	 comprobar()}
);

});




	

