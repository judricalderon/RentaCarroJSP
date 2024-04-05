package co.edu.unbosque.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import co.edu.unbosque.exceptions.ObjetoExistenteException;
import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.model.VehiculoDTO;
import co.edu.unbosque.service.ServicioEmpleado;
import co.edu.unbosque.service.ServicioUsuario;

@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicioEmpleado servcioEmpleado;  
	private ServicioUsuario usuario;
	private String id ;
	private int idVehiculo ;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEmpleado() {
		super();
		usuario = new ServicioUsuario();
		servcioEmpleado = new ServicioEmpleado();
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String boton = request.getParameter("boton");
		


		switch (boton) {
		case "irEmpleado":
			var vehiculosDto = usuario.consultarVehiculos();
			var reservasDto = servcioEmpleado.consultarReservasGlobales();
			request.setAttribute("vehiculosDto", vehiculosDto );
			request.setAttribute("reservasDto", reservasDto );
			request.getRequestDispatcher("Empleado.jsp").forward(request, response);
			break;
		case "crearVehiculo":

			try {
				servcioEmpleado.crearVehiculo(new VehiculoDTO(Integer.parseInt(request.getParameter("idVehiculo")), request.getParameter("imagen"), request.getParameter("tipoAuto"),request.getParameter("marcaAuto"), request.getParameter("modeloAuto"), request.getParameter("anioAuto"), Integer.parseInt(request.getParameter("precioAlquiler")), Integer.parseInt(request.getParameter("vehiculosDisponibles"))));
				request.setAttribute("vehiculosDto", usuario.consultarVehiculos());;
				request.setAttribute("reservasDto", servcioEmpleado.consultarReservasGlobales());
				request.getRequestDispatcher("Empleado.jsp").forward(request, response);
			} catch (ObjetoExistenteException  e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				String mensajeError = "Llene todos los campos";
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
			
			break;


		case "confirmar":
			String idReserva = request.getParameter("idReserva");
			idVehiculo = Integer.parseInt(idReserva);
		
	
			try {
				servcioEmpleado.modificarEstadoReserva(usuario.buscarReserva(idVehiculo),boton);
				request.setAttribute("reservasDto", servcioEmpleado.consultarReservasGlobales());
				request.setAttribute("vehiculosDto", usuario.consultarVehiculos());
				request.getRequestDispatcher("Empleado.jsp").forward(request, response);
			} catch (ObjetoNoExistenteException e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
				
			

			break;


		case "cancelar":
			idReserva = request.getParameter("idReserva");
			idVehiculo = Integer.parseInt(idReserva);
			try {
				servcioEmpleado.modificarEstadoReserva(usuario.buscarReserva(idVehiculo),boton);
				request.setAttribute("reservasDto", servcioEmpleado.consultarReservasGlobales());
				request.setAttribute("vehiculosDto", usuario.consultarVehiculos());
				request.getRequestDispatcher("Empleado.jsp").forward(request, response);
			} catch (ObjetoNoExistenteException e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
			

			break;

		
		default:
			break;
		}

	}

}