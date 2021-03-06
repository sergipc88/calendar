<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import= "com.addapta.calendar.persistence.entity.User" %> 
 	
      
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
	<title>
	Cita
</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Icons -->
<link href="css/flag-icon.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/simple-line-icons.min.css" rel="stylesheet">

<link href="css/style.css?v=1.6" rel="stylesheet">

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

		<!-- FIN MENU SUPERIOR -->

		<!-- INICIO BARRA SUPERIOR DE EVENTOS -->
		<ul class="nav navbar-nav ml-auto">

			<li class="nav-item dropdown"><a class="nav-link nav-link"
				data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
				aria-expanded="false"> <img
					src="http://pupillam.addapta.com/themes/Default/img/anonymous_240.jpg?v=1.0"
					class="img-avatar" alt="sergio.garcia">
			</a>
				<div class="dropdown-menu dropdown-menu-right">
					<a class="dropdown-item" href="main.jsp"> <i class="fa fa-lock"></i>Main
					</a> <a class="dropdown-item" href="index.jsp"><i class="fa fa-lock"></i>Cerrar Sesi�n</a>
				</div></li>
			<button class="navbar-toggler aside-menu-toggler" type="button">
				<span class="navbar-toggler-icon"></span>
			</button>

		</ul>
		<!-- FIN BARRA SUPERIOR DE EVENTOS -->
	</header>

	<div class="app-body">
		<main class="main">
			<div class="container-fluid">
				<div class="animated fadeIn ">
					<div class="row">
						<div class="col-md-12">
							<br>
							<div class="card card-accent-primary">
								<div class="card-header">
									Main
								</div>
								<div class="card-body">
									
									<form  action="calendar">
										<div class="form-group">
											<label for="user">Fecha de alta*</label>
											<input class="form-control  "  type="text" name="fechainit" maxlength="255">
											<p id="displayName"></p>
										</div>
										<div class="form-group">
											<label for="mail">fecha de baja*</label>
											<input class="form-control "  type="text" name="fechaFin" maxlength="255">
										</div>
										<div class="form-group">
											<label for="mail">descripcion*</label>
											<textarea class="form-control "  type="text" name="descripcion" maxlength="255"></textarea>
										</div>
										<div class="form-group">
											<input class="btn btn-lg btn-success btn-block "  type="submit" value="dar de alta"  >
										</div>
										<div class="form-group">
											<p> <c:out value="${error}"></c:out></p>
										</div>
									</form>
									
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
	
	

	






	<footer class="app-footer">
		<span><a href="http://coreui.io/pro/">Calendar</a> © 2018 IT
			Partner</span>
	</footer>



	<script src="js/jquery.js"></script>
	<script
		src="js/bootstrap.js"></script>
	<script
		src="js/pace.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/main.js?v=1.9"></script>
</body>
</html>

