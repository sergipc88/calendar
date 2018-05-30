/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    $('[data-toggle="popover"]').popover();
    
    //Carga el horario en index.php
    if( $('#tt').length )   {
        var ttid = $("#TTID").val();
        var ttdate = $("#TTDATE").val();
        var fromtt = $("#FROMTT").val();
        var personalcalendar = $("#PERSONALCALENDAR").val();
        var schoolcalendar = $("#SCHOOLCALENDAR").val();
        var spacebooking = $("#SPACEBOOKING").val();
        $("#tt").load("index_tt_ajax.php",
            {"gibbonTTID": ttid, "ttDate": ttdate, "fromTT": fromtt, "personalCalendar": personalcalendar, "schoolCalendar": schoolcalendar, "spaceBookingCalendar": spacebooking}); //Añadimos la validacion del formulario
    }
});


function loadLargeModal(url, title, data, sucess, deletefunction) {
    $("#largeModalCotainer").load(url.replace(' ','%20'),data,sucess);
    $("#largeModalTitle").text(title);
    if (deletefunction) {
        $("#button-delete").removeClass("d-none");
        $("#button-delete").click(deletefunction);
    } else {
        $("#button-delete").addClass("d-none");
    }
}

function submitPopover(eventId) {
    $.validator.setDefaults( {
        submitHandler: function () {
          alert( 'submitted!' );
        }
    });
    
    if($("#action")) {
        if($("#action").valid()) {
            $.post(
                    $("#action").attr('action'),
                    $("#action").serialize(),
                    function(data){
                        $.post(
                            "returnProcess_ajax.php",
                            {returnCode : data["returnCode"]} ,
                            function(data) {

                                if (data["class"]=="success") {
                                    refreshScreen();
                                    $("#popover-"+eventId).popover("hide");
                                    toastr.info('Informacion', data["message"], {
                                        closeButton: true,
                                        progressBar: true,
                                    });
                                } else {
                                    toastr.error('Error',data["message"],{
                                       closeButton: true,
                                       progressBar: true,
                                    });
                                }

                            }
                        ,"json");
                    }
            ,"json");
        }
    }
}

function submitLargeModal() {
    
    $.validator.setDefaults( {
        submitHandler: function () {
          alert( 'submitted!' );
        }
    });
    
    if($("#action")) {
        if($("#action").valid()) {
            $.post(
                    $("#action").attr('action'),
                    $("#action").serialize(),
                    function(data){
                        $.post(
                            "returnProcess_ajax.php",
                            {returnCode : data["returnCode"]} ,
                            function(data) {

                                if (data["class"]=="success") {
                                    refreshScreen();
                                    $("#largeModal .close").click();
                                    toastr.info('Informacion', data["message"], {
                                        closeButton: true,
                                        progressBar: true,
                                    });
                                } else {
                                    toastr.error('Error',data["message"],{
                                       closeButton: true,
                                       progressBar: true,
                                    });
                                }

                            }
                        ,"json");
                    }
            ,"json");
        }
    }
}