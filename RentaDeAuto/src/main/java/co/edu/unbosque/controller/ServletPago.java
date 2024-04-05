package co.edu.unbosque.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.exceptions.PagoException;
import co.edu.unbosque.service.ServicioEmpleado;
import co.edu.unbosque.service.ServicioPago;
import co.edu.unbosque.service.ServicioUsuario;

@WebServlet("/ServletPago")
public class ServletPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicioPago servicioPago;
	private ServicioUsuario servcioUsuario;
	private ServicioEmpleado servcioEmpleado;  
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPago() {
		super();
		servicioPago = new ServicioPago();
		servcioUsuario = new ServicioUsuario();
		servcioEmpleado = new ServicioEmpleado();
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
		case "irPagar":
			
			try {
				var reservaDto = servcioUsuario.buscarReserva(Integer.parseInt(request.getParameter("idReserva")));
				request.setAttribute("reservaDto", reservaDto);
				request.getRequestDispatcher("Pago.jsp").forward(request, response);
			} catch (ObjetoNoExistenteException e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
			break;

		case "pagar":
			try {
				
				var reservaDto = servcioUsuario.buscarReserva(Integer.parseInt(request.getParameter("idUsuario")));
				servicioPago.pagar(reservaDto, Double.parseDouble(request.getParameter("precioPagar")));
				request.getRequestDispatcher("ConsultaRenta.jsp").forward(request, response);
			} catch (ObjetoNoExistenteException | PagoException e) {
				String mensajeError = e.getMessage();
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				String mensajeError = "Llene todos los campos requeridos";
				request.setAttribute("mensajeError", mensajeError);
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
		default:
			break;
		}

	}

}
