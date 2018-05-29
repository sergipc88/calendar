<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="com.addapta.calendar.persistence.entity.User"%>
<%@ page isELIgnored="false"%>

<%-- <%
    HttpSession objSesion = request.getSession(false); 
    User user = (User)objSesion.getAttribute("user");
    if(user == null || user.getId()== 0){
    	response.sendRedirect("http://localhost:8080/com.calendar/login.jsp");
    }
    %> --%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="es">
<head>
<title>Calendar</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Icons -->
<link href="css/flag-icon.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/simple-line-icons.min.css" rel="stylesheet">
<link href="css/style.css?v=1.6" rel="stylesheet">
<link href="css/fullcalendar.min.css" rel="stylesheet">

</head>
<body
	class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">

	<header class="app-header navbar">
	<button class="navbar-toggler mobile-sidebar-toggler d-lg-none"
		type="button">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="#"></a>
	<button class="navbar-toggler sidebar-toggler d-md-down-none"
		type="button">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- MENU SUPERIOR -->
	<ul class="nav navbar-nav d-md-down-none mr-auto">



	</ul>

	<!-- FIN MENU SUPERIOR --> <!-- INICIO BARRA SUPERIOR DE EVENTOS -->
	<ul class="nav navbar-nav ml-auto">

		<li class="nav-item dropdown"><a class="nav-link nav-link"
			data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
			aria-expanded="false"> <img
				src="http://pupillam.addapta.com/themes/Default/img/anonymous_240.jpg?v=1.0"
				class="img-avatar" alt="sergio.garcia">
		</a>
			<div class="dropdown-menu dropdown-menu-right">
				<a class="dropdown-item" href="main.jsp"> <i class="fa fa-lock"></i>Main
				</a> <a class="dropdown-item" href="index.jsp"><i class="fa fa-lock"></i>Cerrar
					Sesión</a>
			</div></li>
		<button class="navbar-toggler aside-menu-toggler" type="button">
			<span class="navbar-toggler-icon"></span>
		</button>

	</ul>
	<!-- FIN BARRA SUPERIOR DE EVENTOS --> </header>

	<!-- 	<div class="app-body">
		<main class="main">
			<div class="container-fluid">
				<div class="animated fadeIn ">
					<div class="row">
						<div class="col-lg-12">
							<div id="calendar">
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>  -->

	<div class="app-body">
		<main class="main">
		<div class="container-fluid">
			<div class="animated fadeIn ">
				<div class="row">
					<div class="col-md-12">
						<br>
						<div class="card card-accent-primary">
							<div class="card-header">My Calendar      </div>
							<div class="card-body">
								<div id="calendar">
								 <button type="button" id="pop" class="btn btn-primary" data-toggle="modal" data-target="#primaryModal">
                    Nueva Cita
                  </button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="modal fade " id="primaryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="none: block;">
          <div class="modal-dialog modal-primary" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h4 class="modal-title">Nueva Cita</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span>
                </button>
              </div>
              <div class="modal-body">
               <form  action="citas">
										<div class="form-group">
											<label for="user">Fecha de Inicio*</label>
											<input class="form-control " placeholder=" yyyy-MM-dd"  type="text" name="fInit" maxlength="255">
											<p id="displayName"></p>
										</div>
										<div class="form-group">
											<label for="user">Hora de inicio*</label>
											<input class="form-control " placeholder="HH:mm:ss"  type="text" name="hInit" maxlength="255">
											<p id="displayName"></p>
										</div>
										<div class="form-group">
											<label for="mail">fecha de finalización*</label>
											<input class="form-control " placeholder="yyyy-MM-dd"  type="text" name="fFin" maxlength="255">
										</div>
										<div class="form-group">
											<label for="user">Hora de finalización*</label>
											<input class="form-control " placeholder="HH:mm:ss"  type="text" name="hFin" maxlength="255">
											<p id="displayName"></p>
										</div>
										<div class="form-group">
											<label for="mail">descripcion*</label>
											<textarea class="form-control "  type="text" name="description" maxlength="255"></textarea>
										</div>
										<div class="form-group">
										
											<label for="user">Elije calendario*</label>
											<select class="form-control "  name="idcal" maxlength="255">
											<c:forEach var="calendario" items="${calendar}">
												<option value="${calendario.id}" > ${calendario.nombre} </option>
											</c:forEach>
											
											
											 </select>
											<p id="displayName"></p>
										</div>
										<input type="hidden" name="action" value="alta">
										<div class="form-group">
											<input class="btn btn-lg btn-success btn-block "  type="submit" value="dar de alta"  >
										</div>
										<div class="form-group">
											<p> <c:out value="${error}"></c:out></p>
										</div>
									</form>
              </div>
              <div class="modal-footer">
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
		
		</main>
	</div>
	








	<footer class="app-footer"> <span><a
		href="http://coreui.io/pro/">Calendar</a> Â© 2018 IT Partner</span> </footer>







	<script src="js/jquery.js"></script>
	<script> 
	$(document).ready(function() {

  		// page is now ready, initialize the calendar...

  		$('#calendar').fullCalendar({
  			events:'http://localhost:8080/com.calendar/recuperarcitas'
  						
  				
  			
  			
  			
  		})

	});
	</script>
	<script src="js/bootstrap.js"></script>
	<script src="js/pace.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/main.js?v=1.9"></script>
	<script src="js/moment.min.js"></script>
	<script src="js/fullcalendar.js"></script>
</body>
</html>

