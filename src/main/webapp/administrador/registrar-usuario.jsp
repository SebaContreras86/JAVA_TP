<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "entities.Rol" %>
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
					<li><a href="/alquiler_vehiculos/administrador/registrar-usuario.jsp">Registrar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/modificar-usuario.jsp">Modificar</a></li>
					<li><a href="#">Eliminar</a></li>
				</ul>
			</li>
			<li><a href="/alquiler_vehiculos/Logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	<main>

	<%-- FORMULARIO DE REGISTRO --%>
		<form action="/alquiler_vehiculos/registrarusuario" method="post">
			<input type="hidden" id="id" name="id">
			<label for="email">E-mail</label>
			<input type="email" id="email" name="email">
			<br><br>
			<label for="password">Contraseña</label>
			<input type="text" id="password" name="password">
			<br><br>
			<label for="nombre">Nombre</label>
			<input type="text" id="nombre" name="nombre">
			<br><br>
			<label for="apellido">Apellido</label>
			<input type="text" id="apellido" name="apellido">
			<br><br>
			<label for="dni">DNI</label>
			<input type="text" id="dni" name="dni">
			<br><br>
			<label for="telefono">Teléfono</label>
			<input type="text" id="telefono" name="telefono">
			<br><br>
			<label for="direccion">Dirección</label>
			<input type="text" id="direccion" name="direccion">
			<br><br>
			<label for="tipo">Tipo de usuario</label>
			<select name="tipo" id="tipo">
				<option value="${Rol.ADMIN}">Administrador</option>
				<option value="${Rol.CLIENTE}" selected>Cliente</option>
			</select>
			<br><br>
			<label for="habilitado">Habilitado</label>
			<input type="checkbox" checked="checked" id="habilitado" name="habilitado">
			<br><br>
			<input type="submit" value="Registrar">
		</form>
	<%-- MENSAJES --%>
		<c:if test="${succes != null}"><span> <c:out value="${succes}"/> </span></c:if>
		<c:if test="${invalidData != null}"><span> <c:out value="${invalidData}"/> </span></c:if>
	</main>
</body>
</html>