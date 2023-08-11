<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="../estilos/index.css">
	<title>Xtreme - Admin</title>
</head>
<body>
	<nav class="nav-bar">
		<ul>
			<li><a href="/alquiler_vehiculos/administrador/inicio.jsp">Inicio</a></li>
			<li><a href="#"><c:out value="${usuario.getFullName()}"/></a></li>
			<li>Usuarios
				<ul>
					<li><a href="registrar-usuario.jsp">Registrar</a></li>
					<li><a href="modificar-usuario.jsp">Modificar</a></li>
					<li><a href="eliminar-usuario.jsp">Eliminar</a></li>
				</ul>
			<li>Tipos de vehículos
				<ul>
					<li><a href="#">Registrar</a></li>
					<li><a href="#">Modificar</a></li>
					<li><a href="#">Eliminar</a></li>
				</ul>
			</li>
			<li>Vehículos
				<ul>
					<li><a href="#">Registrar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/modificar-vehiculo.jsp">Modificar</a></li>
					<li><a href="#">Eliminar</a></li>
				</ul>
			</li>
			<li><a href="../Logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	<main class="main"></main>
</body>
</html>