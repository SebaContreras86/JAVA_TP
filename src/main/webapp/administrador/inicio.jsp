<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Xtreme - Admin</title>
</head>
<body>
	<h1>Bienvenido, <c:out value="${usuario.getFullName()}"/></h1>
	<nav>
		<ul>
			<li><a href="/alquiler_vehiculos/administrador/inicio.jsp">Inicio</a></li>
			<li>Usuarios
				<ul>
					<li><a href="registrar-usuario.jsp">Registrar</a></li>
					<li><a href="modificar-usuario.jsp">Modificar</a></li>
					<li><a href="eliminar-usuario.jsp">Eliminar</a></li>
				</ul>
			</li>
			<li><a href="../Logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	<main></main>
</body>
</html>