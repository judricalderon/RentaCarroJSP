package co.edu.unbosque.service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import co.edu.unbosque.exceptions.FechaNoValidaException;
import co.edu.unbosque.exceptions.NoCuposException;
import co.edu.unbosque.exceptions.ObjetoExistenteException;
import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.model.EnumEstadoReserva;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.ReservaDTO;
import co.edu.unbosque.model.Vehiculo;
import co.edu.unbosque.model.VehiculoDTO;
import co.edu.unbosque.model.persistance.DataMapper;
import co.edu.unbosque.model.persistance.InterfaceDAO;
import co.edu.unbosque.model.persistance.InterfaceVehiculoDAO;
import co.edu.unbosque.model.persistance.ReservaDAO;
import co.edu.unbosque.model.persistance.VehiculoDAO;
import jakarta.mail.internet.ParseException;

/**
 * La clase ServicioUsuario proporciona métodos para gestionar vehículos y reservas para los usuarios.
 */
public class ServicioUsuario {

	private InterfaceVehiculoDAO<Vehiculo> vehiculoDao;
	private InterfaceDAO<Reserva, Integer> reservaDao;

	/**
     * Constructor de la clase ServicioUsuario.
     */
	public ServicioUsuario() {
		vehiculoDao = new VehiculoDAO();
		reservaDao = new ReservaDAO();
	}

	/**
     * Consulta todos los vehículos disponibles.
     * @return Una lista de objetos VehiculoDTO que representan los vehículos disponibles.
     */
	public ArrayList<VehiculoDTO> consultarVehiculos() {
		return DataMapper.deArrayEntidadVehiculo(vehiculoDao.consular());
	}

	/**
     * Busca un vehículo por sus características.
     * @param tipo El tipo de vehículo.
     * @param marca La marca del vehículo.
     * @param modelo El modelo del vehículo.
     * @param anio El año del vehículo.
     * @return Un objeto VehiculoDTO que representa el vehículo encontrado.
     * @throws ObjetoNoExistenteException Si el vehículo no existe.
     */
	public VehiculoDTO buscarVehiculo(String tipo, String marca, String modelo, String anio)
			throws ObjetoNoExistenteException {
		return DataMapper.deEntidadVehiculo(vehiculoDao.buscar(tipo, marca, modelo, anio));
	}
	

	 /**
     * Busca una reserva por su identificador.
     * @param id El identificador de la reserva.
     * @return Un objeto ReservaDTO que representa la reserva encontrada.
     * @throws ObjetoNoExistenteException Si la reserva no existe.
     */
	public ReservaDTO buscarReserva(int id) throws ObjetoNoExistenteException {
		var aux1 = reservaDao.buscar(id);
		if (aux1 != null) {
			return DataMapper.deEntidadReserva(aux1);
		} else {
			throw new ObjetoNoExistenteException("La reserva que desea buscar no existe ");
		}
	}

	 /**
     * Crea una nueva reserva.
     * @param objetoDto El objeto ReservaDTO que representa la reserva a crear.
     * @return Un objeto ReservaDTO que representa la reserva creada.
     * @throws ObjetoExistenteException Si la reserva ya existe.
     * @throws ObjetoNoExistenteException Si el vehículo no existe.
     * @throws NoCuposException Si no hay cupos disponibles para reservar el vehículo.
     * @throws FechaNoValidaException Si la fecha de inicio es posterior a la fecha final.
     */
	public ReservaDTO crearReserva(ReservaDTO objetoDto)
			throws ObjetoExistenteException, ObjetoNoExistenteException, NoCuposException, FechaNoValidaException {
		Reserva reserva = DataMapper.deReservaDTO(objetoDto);
		if (reserva.getVehiculoAlquilado().getCantidadVehiculosDisponibles() > 0) {
			if (reserva.getFechaInicio().isAfter(reserva.getFechaFinal()) == false) {

				reserva.setEstado(EnumEstadoReserva.COTIZADA);
				reserva.setPrecioTotal((reserva.getVehiculoAlquilado().calcularPrecioTotal(
						(int) reserva.getFechaInicio().until(reserva.getFechaFinal(), ChronoUnit.DAYS)+ 1)));
				reserva.getVehiculoAlquilado().setCantidadVehiculosDisponibles(
						reserva.getVehiculoAlquilado().getCantidadVehiculosDisponibles() - 1);
				vehiculoDao.modificar(reserva.getVehiculoAlquilado());
				return DataMapper.deEntidadReserva(reservaDao.crear(reserva));

			} else {
				throw new FechaNoValidaException("La fecha de inicio no debe ser posterior a la fecha final");
			}
		} else {
			throw new NoCuposException("No hay cupos para reserva el vehiculo!");
		}
	}

}
