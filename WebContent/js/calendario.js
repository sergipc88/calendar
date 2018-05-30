$(document).ready(function(){
	
	$('#alta').click(function(){
		
		$.post("citas", 
				{description : $('#description').val(), 
				fInit : $('#fInit').val(), 
				fFin : $('#fFin').val(), 
				hInit : $('#hInit').val(),
				hFin : $('#hFin').val(),
				idcal : $('#idcal').val()
				},
				function(data) {
					
					console.log(data);
					$('#newCita').trigger("reset");
					$('#calendar').fullCalendar('refetchEvents');
				},"json");
			
	});
	
	
	
	
	
	
	
	
	
	
})