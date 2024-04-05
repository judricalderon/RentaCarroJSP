<%@page import="co.edu.unbosque.model.ReservaDTO"%>
<%@page import="co.edu.unbosque.model.EnumEstadoReserva"%>
<%@page import="co.edu.unbosque.model.VehiculoDTO"%>
<%@page import="co.edu.unbosque.model.ReservaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleado</title>
    <script src="js/logicaVista.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <link rel="stylesheet" href="css/makeupEmpleado.css">
    <link rel="stylesheet" href="css/makeupAuto.css">
</head>
<body>

	<!-- datos del servlet-->

	<%ArrayList<ReservaDTO> reservasDTO = (ArrayList<ReservaDTO>) request.getAttribute("reservasDto");%>
	<%ArrayList<VehiculoDTO> vehiculosDTO = (ArrayList<VehiculoDTO>) request.getAttribute("vehiculosDto");%>
	

    <div class="encabezado">
        <a href="#" class="logo">
            <img src="image/logo.svg" alt="Ridex logo">
          </a>
        <button onclick="irInicio()" class="btn">Regresar Inicio</button>
    </div>

    
        <div class="contenedorTabla">
          <h3>Consultar Rentas</h3>
            <table>
                <thead>
                    <tr>
                    <th> Marca de Auto </th>
                    <th> Tipo de Auto </th>
                    <th> Modelo de Auto </th>
                    <th> Año del auto </th>
                    <th> Nombre  </th>
                    <th> ID</th>
                    <th> Fecha inicio</th>
                    <th> Fecha final </th>
                    <th> Precio total</th>
                    <th> Estado Reserva</th>
                    </tr>
                </thead>
                <tbody>
                <%for(ReservaDTO reservaDto:reservasDTO){ %>
              <form action="ServletEmpleado" method="post">
                    <tr>
                     <td><%= reservaDto.getVehiculoAlquilado().getMarca() %> </td>
                    <td> <%= reservaDto.getVehiculoAlquilado().getTipo() %></td>
                       <td><%= reservaDto.getVehiculoAlquilado().getModelo() %></td>
                       <td><%= reservaDto.getVehiculoAlquilado().getAnio() %> </td>
                           <td> <%= reservaDto.getNombreUsuario() %></td>
                          <td> <%= reservaDto.getIdUsuario() %></td> 
                          <td> <%= reservaDto.getFechaInicio() %></td>
                          <td> <%= reservaDto.getFechaFinal()%></td>
                       <td> <%= reservaDto.getPrecioTotal()%></td>
                       <td><%= reservaDto.getEstado()%> </td>
                       <% if(!(reservaDto.getEstado() == EnumEstadoReserva.CONFIRMADA || reservaDto.getEstado() == EnumEstadoReserva.CANCELADA || reservaDto.getEstado() == EnumEstadoReserva.COTIZADA)){ %>
                        <input type="hidden" name="idReserva" value="<%=reservaDto.getIdUsuario() %>">
                       <td> <button class="btn" type="submit" name="boton" value="confirmar">Confimar</button> </td>
                       <td> <button class="btn"type="submit" name="boton" value="cancelar">Cancelar</button></td>
                       		<%} %>
                      <% } %>
                    </tr>
                    </form>
                    
                </tbody>
            </table>
      </div>
    

    <div class="contenedor">
        <form action="ServletEmpleado" method="post">
            <h3>Crear Auto</h3> <br>

            <label for="idVuelo" class="labelF"> ID Auto</label>
            <input type="text" id="idVehiculo" name="idVehiculo"><br>

			<label for="idVuelo" class="labelF">Imagen auto</label>
            <input type="text" id="imagen" name="imagen"><br>

            <label for="MarcaAuto" class="labelF">Marca de Auto </label>
            <input type="text" id="marcaAuto" name="marcaAuto"><br>

            <label for="tipoAuto" class="labelF">Tipo de Auto</label>
         
            <select id="origen" name="tipoAuto">
            <option value="">Seleccione tipo de auto</option>
            <option id="tipoAuto" name="tipoAuto" value="Automatico">Automatico</option>
            <option id="tipoAuto" name="tipoAuto" value="Manual">Manual</option>
      	    </select><br>

            <label for="modeloAuto" class="labelF"> Modelo de Auto</label>
            <input type="text" id="modeloAuto" name="modeloAuto"><br>

            <label for="añoAuto" class="labelF">Año del Auto</label>
            <input type="text" id="anioAuto" name="anioAuto"><br>

            <label for="precioAlquiler" class="labelF">Precio Alquiler</label>
            <input type="text" id="precioAlquiler" name="precioAlquiler"><br>
            
            <label for="precioAlquiler" class="labelF">Cantidad vehiculos disponbiles</label>
            <input type="text" id="vehiculosDisponibles" name="vehiculosDisponibles"><br>

          <div class="btn">
             <button class="btn" type="submit" name="boton" value="crearVehiculo">Crear</button>
         </div>

    

    </div>
    
  
      
 
    <section class="section featured-car" id="featured-car">
    
      <div class="container">
        <div class="title-wrapper">
          <h2 class="h2 section-title">Auto Creado</h2>
        </div>
        <ul class="featured-car-list">
         <% for (VehiculoDTO aux : vehiculosDTO) { %>
         
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

									<li class="card-list-item"><ion-icon name="people-outline"></ion-icon>
										<span class="card-item-text">Disponibles: <%= aux.getCantidadVehiculosDisponibles() %> </span></li>

									<!-- modelo de auto -->

									<li class="card-list-item"><ion-icon name="flash-outline"></ion-icon>

										<span class="card-item-text">Modelo: <%= aux.getModelo() %></span></li>
										
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
								</div>
        <% } %>
        </ul>
      </div>
    </section>
 
</body>
</html>