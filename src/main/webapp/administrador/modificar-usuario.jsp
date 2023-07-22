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
					<li><a href="#">Registrar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/modificar-usuario.jsp">Modificar</a></li>
					<li><a href="#">Eliminar</a></li>
				</ul>
			</li>
			<li><a href="/alquiler_vehiculos/Logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	<main>
	
	<%-- FORMULARIO DE BUSQUEDA --%>
		<form action="/alquiler_vehiculos/buscarusuario" method="post">
			<fieldset>
				<legend>Buscar por DNI</legend>
				<label for="dni">DNI</label>
				<input type="text" id="dni" name="dni">
				<input type="submit" value="Buscar">
			</fieldset>
		</form>
		<br>
		
	<%-- FORMULARIO DE MODIFICACIÓN --%>
		<c:if test="${usuarioBuscado != null}">
			<form action="/alquiler_vehiculos/modificarusuario" method="post">
				<input type="hidden" id="id" name="id" value="${usuarioBuscado.getId()}">
				<label for="email">E-mail</label>
				<input type="email" id="email" name="email" value="${usuarioBuscado.getEmail()}">
				<br><br>
				<label for="nombre">Nombre</label>
				<input type="text" id="nombre" name="nombre" value="${usuarioBuscado.getNombre()}">
				<br><br>
				<label for="apellido">Apellido</label>
				<input type="text" id="apellido" name="apellido" value="${usuarioBuscado.getApellido()}">
				<br><br>
				<label for="dni">DNI</label>
				<input type="text" id="dni" name="dni" value="${usuarioBuscado.getDNI()}">
				<br><br>
				<label for="telefono">Teléfono</label>
				<input type="text" id="telefono" name="telefono" value="${usuarioBuscado.getTelefono()}">
				<br><br>
				<label for="direccion">Dirección</label>
				<input type="text" id="direccion" name="direccion" value="${usuarioBuscado.getDireccion()}">
				<br><br>
				<label for="tipo">Tipo de usuario</label>
				<select name="tipo" id="tipo">
				<c:choose>
					<c:when test="${usuarioBuscado.isAdmin()}">
						<option value="${Rol.ADMIN}" selected>Administrador</option>
						<option value="${Rol.CLIENTE}">Cliente</option>
					</c:when>
					<c:otherwise>
						<option value="${Rol.ADMIN}">Administrador</option>
						<option value="${Rol.CLIENTE}" selected>Cliente</option>
					</c:otherwise>
				</c:choose>
				</select>
				<br><br>
				<label for="habilitado">Habilitado</label>
				<c:choose>
					<c:when test="${usuarioBuscado.isHabilitado()}">
						<input type="checkbox" checked="checked" id="habilitado" name="habilitado">
					</c:when>
					<c:otherwise>
						<input type="checkbox" id="habilitado" name="habilitado">
					</c:otherwise>
				</c:choose>
				<br><br>
				<input type="submit" value="Modificar">
			</form>
		</c:if>
	<%-- MENSAJES --%>
		<c:if test="${succes != null}"><span> <c:out value="${succes}"/> </span></c:if>
		<c:if test="${invalidData != null}"><span> <c:out value="${invalidData}"/> </span></c:if>
		<c:if test="${notFound != null}"><span> <c:out value="${notFound}"/> </span></c:if>
	</main>
</body>
</html>