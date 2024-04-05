<%@page import="co.edu.unbosque.model.VehiculoDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Renta</title>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <link rel="stylesheet" href="css/makeupRentar.css">
    <script src="js/logicaVista.js"></script>
</head>
<body>

<div class="encabezado">
        <a href="#" class="logo">
            <img src="image/logo.svg" alt="Ridex logo">
        </a>
        <button onclick="irInicio()" class="btn">Regresar Inicio</button>
    </div>




	<% VehiculoDTO vehiculoDto = (VehiculoDTO) request.getAttribute("vehiculoDto");  %>
	
	 <% if(vehiculoDto != null) { %>
		
		<section class="section featured-car" id="featured-car">
			<div class="container">

				<div class="title-wrapper">
					<h2 class="h2 section-title">Auto a rentar</h2>

				</div>

				<ul class="featured-car-list">

					<li>
						<div class="featured-car-card">

							<!-- imagen-->

							<figure class="card-banner">
								<img src="image/<%= vehiculoDto.getImagen() %>">
							</figure>
 
							<!-- marca  -->

							<div class="card-content">

								<div class="card-title-wrapper">
									<h3 class="h3 card-title">
										<p><%= vehiculoDto.getMarca() %></p>
									</h3>

									<!-- año del auto-->

									<data class="year" value="2021">Año: <%= vehiculoDto.getAnio() %></data>
								</div>

								<!-- items - icons -->
								<ul class="card-list">


									<!-- Cantidad disponible -->

									<li class="card-list-item"><ion-icon name="people-outline"></ion-icon>
										<span class="card-item-text">Disponibles: <%= vehiculoDto.getCantidadVehiculosDisponibles() %> </span></li>

									<!-- modelo de auto -->

									<li class="card-list-item"><ion-icon name="flash-outline"></ion-icon>

										<span class="card-item-text">Modelo: <%= vehiculoDto.getModelo() %></span></li>
										
										<!-- tipo de auto -->
										
									<li class="card-list-item">
                                        <ion-icon name="hardware-chip-outline"></ion-icon>
  
                                        <span class="card-item-text"><%= vehiculoDto.getTipo() %></span>
                                    </li>	

								</ul>

								<!-- precio alquiler -->
								<div class="card-price-wrapper">

									<p class="card-price">
										<strong>Precio: <%= vehiculoDto.getPrecioAlquiler() %></strong>/ dia
									</p>


								</div>
				</ul>
			</div>
		</section>
	<%
	}
	%>

  <div class="contenedor">
    <form action="ServletUsuario" method="post">
        <h3>Ingresa tus Datos</h3> <br>

        <label for="Nombre" class="labelF">Nombre</label>
        <input type="text" id="nombreUsuario" name="nombreUsuario"><br>

        <label for="idUsuario" class="labelF" >Identificación</label>
        <input type="text" id="idUsuario" name="idUsuario"><br>

        <label for="fechaInicio" class="labelF" >Fecha Inicio </label>
        <input type="date" id="fechaInicio" name="fechaInicio">

        <label for="fechaFinal" class="labelF" >Fecha Final </label>
        <input type="date" id="fechaFinal" name="fechaFinal">
		
		<input type="hidden" name="idVehiculo" value="<%= vehiculoDto.getId()%>">
      <div class="btn">
         <button class="btn" name="boton" value="generarRenta" type="submit">Generar Renta</button>
     </div>

    </form>

</div>

</body>
</html>