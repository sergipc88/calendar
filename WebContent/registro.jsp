<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="es">
<head>
<title>
	Registro
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
									Registro de Usuarios
								</div>
								<div class="card-body">
									
									<form  action="controlador">
										<div class="form-group">
											<label for="user">Nombre de Usuario*</label>
											<input class="form-control required " id="nameUser" type="text" name="user" maxlength="255">
											<p id="displayName"></p>
										</div>
										<div class="form-group">
											<label for="mail">Correo electronico*</label>
											<input class="form-control required" id="mailUser" type="text" name="mail" maxlength="255">
										</div>
										<div class="form-group">
											<label for="pass">Contraseña*</label>
											<input class="form-control required" id="pass" type="text" name="pass" maxlength="255">
										</div>
										<div class="form-group">
											<label for="repitPass">Repetir contraseña*</label>
											<input class="form-control required " id="rePass" type="text" name="repitPass" maxlength="255">
										</div>
										<div class="form-group">
											<input class="btn btn-lg btn-success btn-block " id="enviar" type="submit" value="Registrarse"  >
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
	<script src="js/calendar.js"></script>
</body>
</html>