package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.exceptions.ObjetoExistenteException;
import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.model.Reserva;


/**
 * La clase ReservaDAO implementa InterfaceDAO para la gestión de reservas.
 */
public class ReservaDAO implements InterfaceDAO<Reserva, Integer> {
	
	private DataSource dataSource;
	
	 /**
     * Constructor de la clase ReservaDAO.
     */
	public ReservaDAO() {
		dataSource = new DataSource();
	}

	@Override
	public Reserva crear(Reserva objeto) throws ObjetoExistenteException {
		if(buscar(objeto.getIdUsuario())== null) {
			return dataSource.crearReserva(objeto);
		}else {
			throw new ObjetoExistenteException("Solo se puede realizar una reserva por ID");
		}
	}

	@Override
	public Reserva buscar(Integer identificador){
		return dataSource.buscarReserva(identificador);
	}

	@Override
	public Reserva cancelar(Reserva objetoCancelar) throws ObjetoNoExistenteException {
		return dataSource.cancelarReserva(objetoCancelar);
	}

	@Override
	public Reserva modificar(Reserva objetoModificar) throws ObjetoNoExistenteException {
		if(buscar(objetoModificar.getIdUsuario())!= null) {
			return dataSource.modificarReserva(objetoModificar);
		}else {
			throw new ObjetoNoExistenteException("La reserva que trata de modificar no existe");
		}
	}

	@Override
	public ArrayList<Reserva> consular() {
		return dataSource.consultarReservas();
	}

	

}
