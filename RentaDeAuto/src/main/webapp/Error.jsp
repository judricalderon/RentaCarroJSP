<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link rel="stylesheet" href="css/makeupError.css">
<script src="js/logicaVista.js"></script>
</head>
<body>

    <div class="encabezado">
        <a href="#" class="logo">
            <img src="image/logo.svg" alt="Ridex logo">
          </a>
        <button onclick="irInicio()" class="btn">Regresar Inicio</button>
    </div>
    
   
			<div class="contenedor">
		         
		         <h1>¡Ups! Ha ocurrido un error</h1> <br>
		         
		       	<% String mensajeError = (String) request.getAttribute("mensajeError"); %>

	            <h1><%= mensajeError %></h1>
		    
		   </div>

</body>
</html>