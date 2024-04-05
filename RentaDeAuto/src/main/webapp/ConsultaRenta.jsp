<%@page import="co.edu.unbosque.model.EnumEstadoReserva"%>
<%@page import="co.edu.unbosque.model.ReservaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Renta</title>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<link rel="stylesheet" href="css/makeupConsultarRenta.css">
<script src="js/logicaVista.js"></script>
</head>
<body>


<div class="encabezado">
 
        <a href="#" class="logo">
            <img src="image/logo.svg" alt="Ridex logo">
          </a>
        <button onclick="irInicio()" class="btn">Regresar Inicio</button>
    </div>

   <!-- IDENTIFICACION PARA EL USUARIO -->

	<div class="contenedor">
		<form action="ServletUsuario" method="post">
				<label>Numero de identificación:</label> 
				<input type="text" name="idUsuario">
			<div class="btn">
				<button class="btn" type="submit" name="boton" value="buscarReserva">Consultar Renta</button>
			</div>
		</form>
	</div>


    <div class="contenedorTabla">
	<% ReservaDTO reservaDto = (ReservaDTO) request.getAttribute("reservaDto"); %>
	<% if(reservaDto != null){ %>
	

          <h3>Consultar Rentas</h3>
            <table>
                <thead>
                    <tr>
                    <th> Tipo de auto </th>
                    <th> Marca de Auto </th>
                    <th> Modelo de Auto </th>
                    <th> Año del auto </th>
                    <th> Nombre  </th>
                    <th> ID</th>
                    <th> Fecha inicio</th>
                    <th> Fecha final </th>
                    <th> Precio total</th>
                    <th> Estado Reserva</th>
                    <th> Pagar </th>
                   
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td><%= reservaDto.getVehiculoAlquilado().getTipo() %></td>
                    <td><%= reservaDto.getVehiculoAlquilado().getMarca() %> </td>
                    <td><%= reservaDto.getVehiculoAlquilado().getModelo() %> </td>
                    <td><%= reservaDto.getVehiculoAlquilado().getAnio()%> </td>
                    <td><%= reservaDto.getNombreUsuario() %> </td>
                    <td><%= reservaDto.getIdUsuario() %> </td> 
                    <td><%= reservaDto.getFechaInicio() %> </td>
                    <td><%= reservaDto.getFechaFinal() %> </td>
                    <td><%= reservaDto.getPrecioTotal() %> </td>
                    <td><%= reservaDto.getEstado() %> </td>
                    
                    <form action="ServletPago" method="post">
                        <input type="hidden" name="idReserva"	value="<%= reservaDto.getIdUsuario() %>">
						<%if(!(reservaDto.getEstado() == EnumEstadoReserva.CONFIRMADA || reservaDto.getEstado() == EnumEstadoReserva.PAGA)){ %>
                     <td> <button class="btn" type="submit" name="boton" value="irPagar">Pagar</button> </td>
                     </form>
                    </tr>
               		<% }else{ %>
                 		<td> <button class="btn" type="button">   </button> </td>
                 	<%} %>
                </tbody>
            </table>
      
	<% } else{ %>
	
		<p>Busque sus reservas llenando el campo ID</p>
	
	<% } %>
	
	</div>
	 
	 <section class="section get-start">
        <div class="container">


          <ul class="get-start-list">

            <li>
              <div class="get-start-card">

                <div class="card-icon icon-1">
                  <ion-icon name="person-add-outline"></ion-icon>
                </div>

                <h3 class="card-title">Crear renta</h3>

                <p class="card-text">
                
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Quae tenetur omnis asperiores cum fugiat atque debitis facere, a, laboriosam eligendi optio nemo sint libero labore. Voluptatem hic laudantium fuga repellendus?
                  
                </p>

              </div>
            </li>

            <li>
              <div class="get-start-card">

                <div class="card-icon icon-2">
                  <ion-icon name="car-outline"></ion-icon>
                </div>

                <h3 class="card-title">Cuéntanos qué coche quieres</h3>

                <p class="card-text">
                
                 Lorem ipsum dolor sit amet consectetur adipisicing elit. Quae tenetur omnis asperiores cum fugiat atque debitis facere, a, laboriosam eligendi optio nemo sint libero labore. Voluptatem hic laudantium fuga repellendus?
                </p>

              </div>
            </li>

            <li>
              <div class="get-start-card">

                <div class="card-icon icon-3">
                  <ion-icon name="person-outline"></ion-icon>
                </div>

                <h3 class="card-title">Coincidencia con el vendedor</h3>

                <p class="card-text">
                
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quae tenetur omnis asperiores cum fugiat atque debitis facere, a, laboriosam eligendi optio nemo sint libero labore. Voluptatem hic laudantium fuga repellendus?
                  
                </p>

              </div>
            </li>

            <li>
              <div class="get-start-card">

                <div class="card-icon icon-4">
                  <ion-icon name="card-outline"></ion-icon>
                </div>

                <h3 class="card-title">Hacer un trato</h3>

                <p class="card-text">
                
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quae tenetur omnis asperiores cum fugiat atque debitis facere, a, laboriosam eligendi optio nemo sint libero labore. Voluptatem hic laudantium fuga repellendus?
                  
                </p>

              </div>
            </li>

          </ul>

        </div>
      </section>
</body>
</html>