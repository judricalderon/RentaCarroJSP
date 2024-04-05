package co.edu.unbosque.service;

import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.exceptions.PagoException;
import co.edu.unbosque.model.EnumEstadoReserva;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.ReservaDTO;
import co.edu.unbosque.model.persistance.DataMapper;
import co.edu.unbosque.model.persistance.InterfaceDAO;
import co.edu.unbosque.model.persistance.ReservaDAO;

/**
 * La clase ServicioPago gestiona el proceso de pago de reservas.
 */
public class ServicioPago {

	private InterfaceDAO<Reserva, Integer> reservaDao;

	/**
     * Constructor de la clase ServicioPago.
     */
	public ServicioPago() {
		reservaDao = new ReservaDAO();
	}

	/**
     * Realiza el proceso de pago de una reserva.
     * @param reservaDto La reserva a pagar en formato DTO.
     * @param cantidadIngresada La cantidad de dinero ingresada para el pago.
     * @throws ObjetoNoExistenteException Si la reserva no existe.
     * @throws PagoException Si el pago no puede ser procesado.
     */
	public void pagar(ReservaDTO reservaDto, double cantidadIngresada)
			throws ObjetoNoExistenteException, PagoException {

		if (reservaDto.getPrecioTotal() == (int) cantidadIngresada) {
			if (reservaDao.buscar(DataMapper.deReservaDTO(reservaDto).getIdUsuario()) != null) {
				reservaDto.setEstado(EnumEstadoReserva.PAGA);
				reservaDao.modificar(DataMapper.deReservaDTO(reservaDto));

			} else {
				throw new ObjetoNoExistenteException("La reserva que trata de pagar no existe");
			}
		} else {
			throw new PagoException("El valor que trata de pagar es diferente al necesario");
		}

	}

}
