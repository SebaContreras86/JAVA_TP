<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<li><a href="/alquiler_vehiculos/administrador/usuarios/registrar-usuario.jsp">Registrar</a></li>
					<li><a href="/alquiler_vehiculos/administrador/usuarios/modificar-usuario.jsp">Modificar</a></li>
					<li><a href="/alquiler_vehiculos/administrador//usuarios/eliminar-usuario.jsp">Eliminar</a></li>
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
	<main class="main main-modify">
		<h1><span>Modificar vehículo</span></h1>
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
			<c:if test="${notFound != null}"><span> <c:out value="${notFound}"/> </span></c:if>
		</section>
		
		<section class="data-section">
	<%-- FORMULARIO DE MODIFICACIÓN --%>
		<c:if test="${vehiculoBuscado != null}">
			<form action="/alquiler_vehiculos/modificarvehiculo" method="post">
				<fieldset>
					<legend>Datos del vehículo</legend>
					<div>
						<label for="patente">Patente</label>
						<input type="text" id="patente" name="patente" value="${vehiculoBuscado.getPatente()}">
					</div>
					<div>
						<label for="nro-carroceria">Nro de carrocería</label>
						<input type="text" id="nro-carroceria" name="nro-carroceria" value="${vehiculoBuscado.getNroCarroceria()}">
					</div>
					<div>
						<label for="marca">Marca</label>
						<input type="text" id="marca" name="marca" value="${vehiculoBuscado.getMarca()}">
					</div>
					<div>
						<label for="kilometraje">Kilometraje</label>
						<input type="text" id="kilometraje" name="kilometraje" value="${vehiculoBuscado.getKilometraje()}">
					</div>
					<div>
						<label for="anio">Año</label>
						<input type="text" id="anio" name="anio" value="${vehiculoBuscado.getAnio()}">
					</div>
					<div>
						<label for="tipo">Tipo de vehículo</label>
						<select name="tipo" id="tipo">
							<c:forEach items="${tiposVehiculos}" var="tipo">
								<c:choose>
									<c:when test="${vehiculoBuscado.getTipoVehiculo().equals(tipo)}">
										<option value="${tipo.getTipo()}" selected>
											<c:out value="${tipo.getTipo().toUpperCase()}"/>
										</option>
									</c:when>
									<c:otherwise>
										<option value="${tipo.getTipo()}">
											<c:out value="${tipo.getTipo().toUpperCase()}"/>
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
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
	<c:set var="returnTo" scope="session" value="administrador/vehiculos/modificar-vehiculo.jsp"/>
</body>
</html>