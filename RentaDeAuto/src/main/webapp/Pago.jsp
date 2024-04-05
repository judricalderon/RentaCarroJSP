<%@page import="co.edu.unbosque.model.ReservaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pago</title>
    <link rel="stylesheet" href="css/makeupPago.css">
    <script src="js/logicaVista.js"></script>
</head>
<body>
    <div class="encabezado">
        <a href="#" class="logo">
            <img src="image/logo.svg" alt="Ridex logo">
          </a>
        <button onclick="irInicio()" class="btn">Regresar Inicio</button>
    </div>
         
    <% ReservaDTO reservaDto = (ReservaDTO) request.getAttribute("reservaDto");  %>

	<%if(reservaDto != null) { %>
	
			<div class="contenedor">
		    <form action="ServletPago" method="post">
		        <h3>Pago</h3> <br>
		
		        <div class="logo-container">
		            <img src="image/visa_logo.jpg" alt="Visa Logo" class="card-logo">
		            <img src="image/mastercard_logo.jpg" alt="Mastercard Logo" class="card-logo">
		        </div>
		
		        <label for="Numero" class="labelF">Número de tarjeta</label>
		        <input type="text" id="numeroTarjeta" name="numeroTarjeta"><br>
		
		        <label for="CodigoTajerta" class="labelF">CVV </label>
		        <input type="text" id="cvv" name="cvv"><br>
		
		        <label for="fechaFinal" class="labelF">Fecha Final </label>
		        <input type="date" id="fechaFinal" name="fechaFinal">
				
				<label for="precio" class="labelF">Precio Total </label>
		        <input type="text" id="precio" name="precio" placeholder= "<%= reservaDto.getPrecioTotal() %> COP" readonly="readonly"><br>
		        
		        <label for="precio" class="labelF">Precio a Pagar </label>
		        <input type="text" id="precioPagar" name="precioPagar"><br>
		        
		        <input type="hidden" value=<%= reservaDto.getIdUsuario() %> name="idUsuario">
		      <div class="btn">
		         <button class="btn" type="submit" name="boton" value="pagar">Pagar</button>
		     </div>
		
		    </form>
		 </div>
	<% }%>
	
</body>
</html>