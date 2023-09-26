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
		<h1><span>Registrar vehículo</span></h1>
	<%-- FORMULARIO DE REGISTRO --%>
		<section class="data-section">
			<form action="/alquiler_vehiculos/registrarvehiculo" method="post">
				<fieldset>
					<legend>Datos del vehículo</legend>
					<div>
						<label for="patente">Patente</label>
						<input type="text" id="patente" name="patente">
					</div>
					<div>
						<label for="nro-carroceria">Nro de carrocería</label>
						<input type="text" id="nro-carroceria" name="nro-carroceria">
					</div>
					<div>
						<label for="marca">Marca</label>
						<input type="text" id="marca" name="marca">
					</div>
					<div>
						<label for="kilometraje">Kilometraje</label>
						<input type="text" id="kilometraje" name="kilometraje">
					</div>
					<div>
						<label for="anio">Año</label>
						<input type="text" id="anio" name="anio">
					</div>
					<div>
						<label for="tipo">Tipo de vehículo</label>
						<select name="tipo" id="tipo">
							<c:forEach items="${tvDAO.getAll()}" var="tipo">
								<option value="${tipo.getTipo()}" selected>
									<c:out value="${tipo.getTipo().toUpperCase()}"/>
								</option>
							</c:forEach>
						</select>
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