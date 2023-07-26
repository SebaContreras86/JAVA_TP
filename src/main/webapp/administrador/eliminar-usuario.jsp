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
					<li><a href="/alquiler_vehiculos/administrador/eliminar-usuario.jsp">Eliminar</a></li>
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
		
	<%-- DATOS DEL USUARIO A ELIMINAR --%>
		<c:if test="${usuarioBuscado != null}">
			<ul>
				<li>ID: <c:out value="${usuarioBuscado.getId()}"/> </li>
				<li>E-MAIL: <c:out value="${usuarioBuscado.getEmail()}"/> </li>
				<li>NOMBRE: <c:out value="${usuarioBuscado.getNombre()}"/> </li>
				<li>APELLIDO: <c:out value="${usuarioBuscado.getApellido()}"/> </li>
				<li>DNI: <c:out value="${usuarioBuscado.getDNI()}"/> </li>
				<li>TELÉFONO: <c:out value="${usuarioBuscado.getTelefono()}"/> </li>
				<li>DIRECCIÓN: <c:out value="${usuarioBuscado.getDireccion()}"/> </li>
				<li>TIPO: <c:out value="${usuarioBuscado.getRol()}"/> </li>
				<li>HABILITADO: <c:out value="${usuarioBuscado.isHabilitado()}"/> </li>
			</ul>
			<a href="/alquiler_vehiculos/eliminarusuario">Eliminar</a>
		</c:if>
	<%-- MENSAJES --%>
		<c:if test="${succes != null}"><span> <c:out value="${succes}"/> </span></c:if>
		<c:if test="${notFound != null}"><span> <c:out value="${notFound}"/> </span></c:if>
	</main>
	<c:set var="returnTo" scope="session" value="administrador/eliminar-usuario.jsp"/>
</body>
</html>