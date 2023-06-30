<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title></title> 
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilos.css">
</head>  
<body>
	<form class="formulario" action="Login" method="post">
    
	    <h1>Login</h1>
	    <span class="mensaje"> <c:out value="${mensaje}"/> </span>
	  	<div class="contenedor">
	     	<div class="input-contenedor">
		     	<i class="fas fa-envelope icon"></i>
		        <input name="email" type="text" placeholder="Correo Electronico">
	        </div>
	         
	      	<div class="input-contenedor">
		    	<i class="fas fa-key icon"></i>
		     	<input name="password" type="password" placeholder="Contraseña">
	     	</div>
	     	<input type="submit" value="Login" class="button">
	    	<p>Al registrarte, aceptas nuestras Condiciones de uso y Política de privacidad.</p>
	    	<p>No tienes una cuenta? <a class="link" href="registrarvista.html">Registrate </a></p>
	  	</div>
    </form>
    
</body>
<script src="scripts/script.js"></script>
</html>