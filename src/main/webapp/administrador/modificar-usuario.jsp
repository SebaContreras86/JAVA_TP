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
	<main class="main main-modify">
		<h1><span>Modificar usuario</span></h1>
		<section class="search">
	<%-- FORMULARIO DE BUSQUEDA --%>
			<form action="/alquiler_vehiculos/buscarusuario" method="post">
				<fieldset>
					<legend>Buscar por DNI</legend>
					<label for="dni">DNI</label>
					<input type="text" id="dni" name="dni">
					<input type="submit" value="Buscar">
				</fieldset>
			</form>
			<c:if test="${notFound != null}"><span> <c:out value="${notFound}"/> </span></c:if>
		</section>
		
		<section class="data-section">
	<%-- FORMULARIO DE MODIFICACIÓN --%>
		<c:if test="${usuarioBuscado != null}">
			<form action="/alquiler_vehiculos/modificarusuario" method="post">
				<fieldset>
					<legend>Datos del usuario</legend>
					<input type="hidden" id="id" name="id" value="${usuarioBuscado.getId()}">
					<div>
						<label for="email">E-mail</label>
						<input type="email" id="email" name="email" value="${usuarioBuscado.getEmail()}">
					</div>
					<div>
						<label for="nombre">Nombre</label>
						<input type="text" id="nombre" name="nombre" value="${usuarioBuscado.getNombre()}">
					</div>
					<div>
						<label for="apellido">Apellido</label>
						<input type="text" id="apellido" name="apellido" value="${usuarioBuscado.getApellido()}">
					</div>
					<div>
						<label for="dni">DNI</label>
						<input type="text" id="dni" name="dni" value="${usuarioBuscado.getDNI()}">
					</div>
					<div>
						<label for="telefono">Teléfono</label>
						<input type="text" id="telefono" name="telefono" value="${usuarioBuscado.getTelefono()}">
					</div>
					<div>
						<label for="direccion">Dirección</label>
						<input type="text" id="direccion" name="direccion" value="${usuarioBuscado.getDireccion()}">
					</div>
					<div>
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
					</div>
					<div>
						<label for="habilitado">Habilitado</label>
						<c:choose>
							<c:when test="${usuarioBuscado.isHabilitado()}">
								<input type="checkbox" checked="checked" id="habilitado" name="habilitado">
							</c:when>
							<c:otherwise>
								<input type="checkbox" id="habilitado" name="habilitado">
							</c:otherwise>
						</c:choose>
					</div>
					<input type="submit" value="Modificar">
				</fieldset>
			</form>
		</c:if>
	<%-- MENSAJES --%>
		<c:if test="${succes != null}"><span> <c:out value="${succes}"/> </span></c:if>
		<c:if test="${invalidData != null}"><span> <c:out value="${invalidData}"/> </span></c:if>
		</section>
	</main>
	<c:set var="returnTo" scope="session" value="administrador/modificar-usuario.jsp"/>
</body>
</html>