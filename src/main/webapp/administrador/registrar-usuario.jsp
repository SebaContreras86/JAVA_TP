<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "entities.Rol" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/alquiler_vehiculos/estilos/index.css">
	<link rel="stylesheet" href="/alquiler_vehiculos/estilos/abm-usuarios.css">
	<title>Xtreme - Admin</title>
</head>
<body>
	<nav class="nav-bar">
		<ul>
			<li><a href="/alquiler_vehiculos/administrador/inicio.jsp">Inicio</a></li>
			<li><a href="#"><c:out value="${usuario.getFullName()}"/></a></li>
			<li>Usuarios
				<ul>
					<li><a href="/alquiler_vehiculos/administrador/registrar-usuario.jsp">Registrar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/modificar-usuario.jsp">Modificar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/eliminar-usuario.jsp">Eliminar</a></li>
				</ul>
			</li>
			<li>Tipos de vehículos
				<ul>
					<li><a href="#">Registrar</a></li>
					<li><a href="#">Modificar</a></li>
					<li><a href="#">Eliminar</a></li>
				</ul>
			</li>
			<li>Vehículos
				<ul>
					<li><a href="/alquiler_vehiculos/LoadPage">Registrar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/modificar-vehiculo.jsp">Modificar</a></li>
					<li><a href="#">Eliminar</a></li>
				</ul>
			</li>
			<li><a href="/alquiler_vehiculos/Logout">Cerrar sesión</a></li>
		</ul>
	</nav>
	<main class="main main-register">
		<h1><span>Registrar usuario</span></h1>
	<%-- FORMULARIO DE REGISTRO --%>
		<section class="data-section">
			<form action="/alquiler_vehiculos/registrarusuario" method="post">
				<fieldset>
					<legend>Datos del usuario</legend>
					<input type="hidden" id="id" name="id">
					<div>
						<label for="email">E-mail</label>
						<input type="email" id="email" name="email">
					</div>
					<div>
						<label for="password">Contraseña</label>
						<input type="text" id="password" name="password">
					</div>
					<div>
						<label for="nombre">Nombre</label>
						<input type="text" id="nombre" name="nombre">
					</div>
					<div>
						<label for="apellido">Apellido</label>
						<input type="text" id="apellido" name="apellido">
					</div>
					<div>
						<label for="dni">DNI</label>
						<input type="text" id="dni" name="dni">
					</div>
					<div>
						<label for="telefono">Teléfono</label>
						<input type="text" id="telefono" name="telefono">
					</div>
					<div>
						<label for="direccion">Dirección</label>
						<input type="text" id="direccion" name="direccion">
					</div>
					<div>
						<label for="tipo">Tipo de usuario</label>
						<select name="tipo" id="tipo">
							<option value="${Rol.ADMIN}">Administrador</option>
							<option value="${Rol.CLIENTE}" selected>Cliente</option>
						</select>
					</div>
					<div>
						<label for="habilitado">Habilitado</label>
						<input type="checkbox" checked="checked" id="habilitado" name="habilitado">
					</div>
					<input type="submit" value="Registrar">
				</fieldset>
			</form>
			<%-- MENSAJES --%>
			<c:if test="${succes != null}"><span> <c:out value="${succes}"/> </span></c:if>
			<c:if test="${invalidData != null}"><span> <c:out value="${invalidData}"/> </span></c:if>
		</section>
	</main>
</body>
</html>