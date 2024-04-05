package co.edu.unbosque.service;

import java.util.ArrayList;

import co.edu.unbosque.exceptions.ObjetoExistenteException;
import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.model.EnumEstadoReserva;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.ReservaDTO;
import co.edu.unbosque.model.Vehiculo;
import co.edu.unbosque.model.VehiculoDTO;
import co.edu.unbosque.model.persistance.DataMapper;
import co.edu.unbosque.model.persistance.InterfaceDAO;
import co.edu.unbosque.model.persistance.ReservaDAO;
import co.edu.unbosque.model.persistance.VehiculoDAO;

/**
 * La clase ServicioEmpleado proporciona métodos para realizar operaciones relacionadas con vehículos y reservas.
 */
public class ServicioEmpleado {

	private InterfaceDAO<Vehiculo, Integer> vehiculoDao;
	private InterfaceDAO<Reserva, Integer> reservaDao;

	/**
     * Constructor de la clase ServicioEmpleado.
     */
	public ServicioEmpleado() {
		vehiculoDao = new VehiculoDAO();
		reservaDao = new ReservaDAO();
	}

	/**
     * Consulta todas las reservas globales y las devuelve como una lista de objetos ReservaDTO.
     * @return Una lista de objetos ReservaDTO que representan todas las reservas globales.
     */
	public ArrayList<ReservaDTO> consultarReservasGlobales() {
		return DataMapper.deArrayEntidadReserva(reservaDao.consular());
	}

	   /**
     * Crea un nuevo vehículo a partir de un objeto VehiculoDTO y lo devuelve como un objeto VehiculoDTO.
     * @param objetoDto El objeto VehiculoDTO que representa el vehículo a crear.
     * @return El objeto VehiculoDTO creado.
     * @throws ObjetoExistenteException Si el vehículo ya existe.
     */
	public VehiculoDTO crearVehiculo(VehiculoDTO objetoDto) throws ObjetoExistenteException {
		return DataMapper.deEntidadVehiculo(vehiculoDao.crear(DataMapper.deVehiculoDTO(objetoDto)));
	}

	  /**
     * Modifica el estado de una reserva especificada por un objeto ReservaDTO y una acción (Confirmar o Cancelar).
     * @param reservaDto El objeto ReservaDTO que representa la reserva a modificar.
     * @param accion La acción a realizar (Confirmar o Cancelar).
     * @throws ObjetoNoExistenteException Si la reserva no existe.
     */
	public void modificarEstadoReserva(ReservaDTO reservaDto, String accion) throws ObjetoNoExistenteException {
		if (accion.equalsIgnoreCase("Confirmar")) {
			reservaDto.setEstado(EnumEstadoReserva.CONFIRMADA);
			reservaDao.modificar(DataMapper.deReservaDTO(reservaDto));
		} else if (accion.equalsIgnoreCase("Cancelar")) {
			reservaDto.setEstado(EnumEstadoReserva.CANCELADA);
			reservaDao.modificar(DataMapper.deReservaDTO(reservaDto));
		}
	}

	 /**
     * Busca un vehículo por su identificador y devuelve un objeto VehiculoDTO.
     * @param id El identificador del vehículo a buscar.
     * @return El objeto VehiculoDTO que representa el vehículo encontrado.
     * @throws ObjetoNoExistenteException Si el vehículo no existe.
     */
	public VehiculoDTO buscarPorId(int id)  throws ObjetoNoExistenteException {
		var vehiculoDto = DataMapper.deEntidadVehiculo(vehiculoDao.buscar(id));
		if(vehiculoDto!=null){
			return vehiculoDto;
		}else{
			throw new ObjetoNoExistenteException("El vehiculo no existe");
		}

	}


}
