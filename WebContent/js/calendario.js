$(document).ready(function(){
	var id;
	$('#calendar').fullCalendar({
		
		 		  locale: 'es',
		 		  
		 		 header: {
				        left: 'prev,next today',
				        center: 'title',
				        right: 'month,agendaWeek,agendaDay,listWeek,listDay'
				 },
				 
				 views: {
				        listDay: { buttonText: 'citas diarias' },
				        listWeek: { buttonText: 'citas semanales' }
				 },
		
				  events:'http://localhost:8080/com.calendar/recuperarcitas',
						
				  dayClick: function(date, jsEvent, view) {

					  $('#pop').click();
					  $('#fInit').val(date.format('DD/MM/YYYY')); 
				  	
				  },
		
				  
				  eventClick: function(calEvent, jsEvent, view) {
		 	  
					  
					  var start = calEvent.start;
					  var end = calEvent.end;
		  	
					  $('#pop').click();
					  $('#fInit').val(start.format('DD/MM/YYYY')); 
					  $('#hInit').val(start.format('HH:mm'));
					  $('#fFin').val(end.format('DD/MM/YYYY'));
					  $('#hFin').val(end.format('HH:mm'));
					  $('#description').val(calEvent.title);
					  $('#idcal').val(calEvent.resourceId);
					 // $('#id').val( calEvent.id);
					  id = calEvent.id;
					  $('#alta').val("Modificar Fecha");
					  $('#titulo').text("Modificar cita");
					  $('#newCita').attr('action', 'modificarCita');
				  
				  },
				  			
				  editable: true,
				  eventDurationEditable: true,
				  			  
				  eventDrop: function(event, delta, revertFunc) {
					  
					  var start = event.start;
					  var dayStart =  start.format('DD/MM/YYYY');
					  var hourStart = start.format('HH:mm');
					  var end = event.end;
					  var dayEnd =  end.format('DD/MM/YYYY');
					  var hourEnd = end.format('HH:mm');
					  
					
					  
					  $.post('modificarCita', 
							{description : event.title, 
							fInit : dayStart, 
							fFin : dayEnd, 
							hInit : hourStart,
							hFin : hourEnd,
							idcal : event.resourceId,
							id : event.id
							},
							
							function(data) {
								$('#calendar').fullCalendar('refetchEvents');
							},"json");
					   
				  },
				  
				  eventResize: function(event, delta, revertFunc) {
					  
					  var start = event.start;
					  var dayStart =  start.format('DD/MM/YYYY');
					  var hourStart = start.format('HH:mm');
					  var end = event.end;
					  var dayEnd =  end.format('DD/MM/YYYY');
					  var hourEnd = end.format('HH:mm');
					  
					//  alert(start.format('DD/MM/YYYY'));
					  
					  $.post('modificarCita', 
							{description : event.title, 
							fInit : dayStart, 
							fFin : dayEnd, 
							hInit : hourStart,
							hFin : hourEnd,
							idcal : event.resourceId,
							id : event.id
							},
							
							function(data) {
								$('#calendar').fullCalendar('refetchEvents');
							},"json");
				    

				  }
		})
	
	$('#alta').click(function(){
		
		var action = $('#newCita').attr('action');
		
		
			$.post(action, 
					{description : $('#description').val(), 
					fInit : $('#fInit').val(), 
					fFin : $('#fFin').val(), 
					hInit : $('#hInit').val(),
					hFin : $('#hFin').val(),
					idcal : $('#idcal').val(),
					id : id
					},
					function(data) {
						
						console.log(data);
						$('#newCita').trigger("reset");
						$('#calendar').fullCalendar('refetchEvents');
						$('#alta').val("dar de alta");
						$('#fInit').val(""); 
						$('#hInit').val("");
						$('#fFin').val("");
						$('#hFin').val("");
						$('#description').val("");
						 
						$('#titulo').text("Nueva Cita");
						$('#newCita').attr('action', 'citas');
					},"json");
			
		
		
		
			
	});
	
	
	$('#close').click(function(){
		
		$('#alta').val("dar de alta");
		
		$('#fInit').val(""); 
		$('#hInit').val("");
		$('#fFin').val("");
		$('#hFin').val("");
		$('#description').val("");
		 
		$('#titulo').text("Nueva Cita");
		$('#newCita').attr('action', 'citas');
		$('#newCita').trigger("reset");
	
		
	})
	
	
	
	
	
	
	
	
	
	
})