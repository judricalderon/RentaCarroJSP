<%@page import="co.edu.unbosque.model.VehiculoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Renta de Autos</title> 
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  
    <link rel="stylesheet" href="css/makeupAuto.css">
 
    <script src="js/logicaVista.js"></script>
</head>
<body>

<!-- datos del servlet-->

    <div class="encabezado">
        <a href="#" class="logo">
            <img src="image/logo.svg" alt="Ridex logo">
          </a>  
          
        <button onclick="irConsultaRenta()" class="btn">Consultar Renta</button>
        <button onclick="irInicio()" class="btn">Regresar Inicio</button>
    </div>

 <!-- buscar  por parametro -->
    <div class="contenedor">
        <form action="ServletUsuario" method="post">
            <h3>Buscar Auto</h3> <br>

            <label for="tipoAuto" class="labelF">Tipo de Auto</label>
            <input type="text" id="tipoAuto" name="tipoAuto"><br>

            <label for="MarcaAuto" class="labelF">Marca de Auto </label>
            <input type="text" id="marcaAuto" name="marcaAuto"><br>

            <label for="modeloAuto" class="labelF">Modelo de Auto</label>
            <input type="text" id="modeloAuto" name="modeloAuto"><br>

            <label for="anioAuto" class="labelF">Año del auto</label>
            <input type="text" id="anioAuto" name="anioAuto"><br>

            <label for="precioAlquiler" class="labelF">Precio Alquiler</label>
            <input type="text" id="precioAlquiler" name="precioAlquiler"><br>

          <div class="btn">
             <button class="btn" type="submit" name="boton" value="buscar">Buscar</button>
         </div>

        </form>

    </div>

    
    <!-- tarjeta buscada por parametro -->
    
    
    <%  VehiculoDTO vehiculoDto = (VehiculoDTO) request.getAttribute("vehiculoDto");   %>
    
    <% if(vehiculoDto != null) { %>
		<form action="ServletUsuario" method="post">
		<section class="section featured-car" id="featured-car">
			<div class="container">

				<div class="title-wrapper">
					<h2 class="h2 section-title">Auto encontrado</h2>

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

									<!-- Boton Rentar -->
									<input type="hidden" value="<%= vehiculoDto.getId() %>" name="idVehiculo">
									<button class="btn" name="boton" value="rentarVehiculo">Rentar</button>

								</div>
				     </ul>
			   </div>
		</section>
	</form>
	<%
	}
	%>


<!-- buscar  por normal -->

	
		
		
		
	<section class="section featured-car" id="featured-car">
		<div class="container">

			<div class="title-wrapper">
				<h2 class="h2 section-title">Auto disponibles</h2>
			</div>
          
			<ul class="featured-car-list">
              <% ArrayList<VehiculoDTO> vehiculosDto = (ArrayList<VehiculoDTO>) request.getAttribute("vehiculosDto"); %>
	<% if(vehiculosDto!= null){ %>
	<% for(VehiculoDTO aux : vehiculosDto){ %>
	<form action="ServletUsuario" method="post">
				<li>
					<div class="featured-car-card">

						<!-- imagen-->
						<figure class="card-banner">
							<img src="image/<%= aux.getImagen() %>">
						</figure>
 
						<!-- marca  -->
						<div class="card-content">

							<div class="card-title-wrapper">
								<h3 class="h3 card-title">
									<p><%= aux.getMarca() %></p>
								</h3>

								<!-- año del auto-->
								<data class="year" value="2021">Año: <%= aux.getAnio() %></data>
							</div>

							<!-- items - icons -->
							<ul class="card-list">
								<!-- Cantidad disponible -->
								<li class="card-list-item">
									<ion-icon name="people-outline"></ion-icon>
									<span class="card-item-text">Disponibles: <%= aux.getCantidadVehiculosDisponibles() %> </span>
								</li>

								<!-- modelo de auto -->
								<li class="card-list-item">
									<ion-icon name="flash-outline"></ion-icon>
									<span class="card-item-text">Modelo: <%= aux.getModelo() %></span>
								</li>
								
								<!-- tipo de auto -->
								<li class="card-list-item">
									<ion-icon name="hardware-chip-outline"></ion-icon>
									<span class="card-item-text"><%= aux.getTipo() %></span>
								</li>	
							</ul>

							<!-- precio alquiler -->
							<div class="card-price-wrapper">
								<p class="card-price">
									<strong>Precio: <%= aux.getPrecioAlquiler() %></strong>/ dia
								</p>

								<!-- Boton Rentar -->
								<input type="hidden" value="<%= aux.getId() %>" name="idVehiculo">
								<button class="btn" name="boton" value="rentarVehiculo">Rentar</button>
							</div>	
						</div>
					</div>
				</li>	
				</form>
					<% } %>	
			</ul>	
		</div>
	</section>



<% } %>

</body>
</html>