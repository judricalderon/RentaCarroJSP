package co.edu.unbosque.controller;

import jakarta.mail.internet.ParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import co.edu.unbosque.exceptions.FechaNoValidaException;
import co.edu.unbosque.exceptions.NoCuposException;
import co.edu.unbosque.exceptions.ObjetoExistenteException;
import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.model.EnumEstadoReserva;
import co.edu.unbosque.model.ReservaDTO;
import co.edu.unbosque.service.ServicioEmpleado;
import co.edu.unbosque.service.ServicioPago;
import co.edu.unbosque.service.ServicioUsuario;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicioEmpleado servcioEmpleado;  
	private ServicioUsuario servcioUsuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        servcioUsuario = new ServicioUsuario();
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
		
		String boton = request.getParameter("boton");
		switch (boton) {
		case "consultarVehiculos":
				var vehiculosDto = servcioUsuario.consultarVehiculos();
				request.setAttribute("vehiculosDto",  vehiculosDto);
				request.getRequestDispatcher("Vehiculo.jsp").forward(request, response);
				break;
		case ("buscar"):
			try {
				var vehiculoDto = servcioUsuario.buscarVehiculo(request.getParameter("tipoAuto"), request.getParameter("marcaAuto"), request.getParameter("modeloAuto"), request.getParameter("anioAuto"));
				request.setAttribute("vehiculoDto", vehiculoDto);
				request.setAttribute("vehiculosDto",  servcioUsuario.consultarVehiculos());
				request.getRequestDispatcher("Vehiculo.jsp").forward(request, response);
			} catch (ObjetoNoExistenteException e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			} 
			break;
		case ("rentarVehiculo"):
			try {
				var vehiculoDto = servcioEmpleado.buscarPorId(Integer.parseInt(request.getParameter("idVehiculo")));
				request.setAttribute("vehiculoDto", vehiculoDto);
				request.getRequestDispatcher("Renta.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				String mensajeError = "Llene todos los campos requeridos";
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			} catch (ObjetoNoExistenteException e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
				break;
		case ("generarRenta"):
			
			try {
				var reservaDto = servcioUsuario.crearReserva(new ReservaDTO(servcioEmpleado.buscarPorId(Integer.parseInt(request.getParameter("idVehiculo"))), request.getParameter("nombreUsuario"), Integer.parseInt(request.getParameter("idUsuario")), LocalDate.parse(request.getParameter("fechaInicio")), LocalDate.parse(request.getParameter("fechaFinal")), 0, null));
				request.setAttribute("reservaDto", reservaDto);
				request.getRequestDispatcher("index.html").forward(request, response);
			} catch (ObjetoExistenteException | ObjetoNoExistenteException | NoCuposException
					| FechaNoValidaException e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				String mensajeError = "Llene todos los campos requeridos";
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
				break;
		case ("buscarReserva"):
			try {
				var reservaDto = servcioUsuario.buscarReserva(Integer.parseInt(request.getParameter("idUsuario")));
				request.setAttribute("reservaDto", reservaDto);
				request.getRequestDispatcher("ConsultaRenta.jsp").forward(request, response);
			} catch (ObjetoNoExistenteException e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				String mensajeError = "Llene todos los campos requeridos";
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
				break;
		default:
			System.out.println("no existe opcion");
			break;
		}
	}

}
