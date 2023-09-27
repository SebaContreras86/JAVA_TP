<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="/alquiler_vehiculos/estilos/index.css">
	<link rel="stylesheet" href="/alquiler_vehiculos/estilos/abm-usuarios.css">
	<title>Xtreme-Admin</title>
</head>
<body>
	<nav class="nav-bar">
		<ul>
			<li><a href="/alquiler_vehiculos/administrador/inicio.jsp">Inicio</a></li>
			<li><a href="#"><c:out value="${usuario.getFullName()}"/></a></li>
			<li>Usuarios
				<ul>
					<li><a href="/alquiler_vehiculos/administrador/usuarios/registrar-usuario.jsp">Registrar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/usuarios/modificar-usuario.jsp">Modificar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/usuarios/eliminar-usuario.jsp">Eliminar</a></li>
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
					<li><a href="/alquiler_vehiculos/administrador/vehiculos/modificar-vehiculo.jsp">Modificar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/vehiculos/eliminar-vehiculo.jsp">Eliminar</a></li>
				</ul>
			</li>
			<li><a href="/alquiler_vehiculos/Logout">Cerrar sesión</a></li>
		</ul>
	</nav>
		<main class="main main-delete">
		<h1><span>Eliminar vehículo</span></h1>
		<section class="search">
			<%-- FORMULARIO DE BUSQUEDA --%>
			<form action="/alquiler_vehiculos/buscarvehiculo" method="post">
				<fieldset>
					<legend>Buscar por patente</legend>
					<label for="dni">Patente</label>
					<input type="text" id="patente" name="patente">
					<input type="submit" value="Buscar">
				</fieldset>
			</form>
		</section>
		
		<section class="delete-section">
			<%-- DATOS DEL VEHICULO A ELIMINAR --%>
			<c:if test="${vehiculoBuscado != null}">
				<ul>
					<li>PATENTE: <c:out value="${vehiculoBuscado.getPatente().toUpperCase()}"/> </li>
					<li>CARROCERÍA: <c:out value="${vehiculoBuscado.getNroCarroceria()}"/> </li>
					<li>MARCA: <c:out value="${vehiculoBuscado.getMarca()}"/> </li>
					<li>KILOMETRAJE: <c:out value="${vehiculoBuscado.getKilometraje()}"/> Kms</li>
					<li>AÑO: <c:out value="${vehiculoBuscado.getAnio()}"/> </li>
					<li>TIPO: <c:out value="${vehiculoBuscado.getTipoVehiculo().getTipo()}"/> </li>
				</ul>
				<a href="/alquiler_vehiculos/eliminarvehiculo">Eliminar</a>
			</c:if>
			<%-- MENSAJES --%>
			<c:if test="${succes != null}"><span> <c:out value="${succes}"/> </span></c:if>
			<c:if test="${notFound != null}"><span> <c:out value="${notFound}"/> </span></c:if>
		</section>
	</main>
	<c:set var="returnTo" scope="session" value="administrador/vehiculos/eliminar-vehiculo.jsp"/>
</body>
</html>