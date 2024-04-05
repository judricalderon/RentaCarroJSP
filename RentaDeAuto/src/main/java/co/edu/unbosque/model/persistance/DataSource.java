package co.edu.unbosque.model.persistance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import co.edu.unbosque.model.EnumEstadoReserva;
import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.Vehiculo;

/**
 * La clase DataSource proporciona métodos para interactuar con la fuente de datos de vehículos y reservas.
 */
public class DataSource {

	static ArrayList<Vehiculo> datosVehiculos;
	static ArrayList<Reserva> datosReservas;

	static {
		datosVehiculos = new ArrayList<Vehiculo>();
		datosReservas = new ArrayList<Reserva>();	
		cargarDatos();
	}
 
	/**
     * Crea un nuevo vehículo y lo agrega a la fuente de datos.
     * @param objeto El vehículo a crear.
     * @return El vehículo creado.
     */
	public Vehiculo crearVehiculo(Vehiculo objeto) {
		datosVehiculos.add(objeto);
		return objeto;
	}

	/**
     * Busca un vehículo por su identificador.
     * @param identificador El identificador del vehículo a buscar.
     * @return El vehículo encontrado o null si no se encuentra.
     */
	public Vehiculo buscarVehiculo(Integer identificador) {
		Optional<Vehiculo> aux = datosVehiculos.stream().filter( objeto -> objeto.getId() == identificador).findFirst();
		if(aux.isPresent()) {
			return datosVehiculos.stream().filter( objeto -> objeto.getId() == identificador).findFirst().get();
		}else {
			return null;
		}
	}

	 /**
     * Busca un vehículo por sus parámetros (tipo, marca, modelo y año).
     * @param tipo El tipo del vehículo a buscar.
     * @param marca La marca del vehículo a buscar.
     * @param modelo El modelo del vehículo a buscar.
     * @param anio El año del vehículo a buscar.
     * @return El vehículo encontrado o null si no se encuentra.
     */
	public Vehiculo buscarVehiculoParametros(String tipo, String marca, String modelo, String anio) {
		Optional<Vehiculo> aux = datosVehiculos.stream().filter(objeto -> (objeto.getTipo().equalsIgnoreCase(tipo)&& objeto.getMarca().equalsIgnoreCase(marca)&& objeto.getModelo().equalsIgnoreCase(modelo) && objeto.getAnio().equalsIgnoreCase(anio) )).findFirst();
		if(aux.isPresent()) {
			return datosVehiculos.stream().filter(objeto -> (objeto.getTipo().equalsIgnoreCase(tipo)&& objeto.getMarca().equalsIgnoreCase(marca)&& objeto.getModelo().equalsIgnoreCase(modelo) && objeto.getAnio().equalsIgnoreCase(anio) )).findFirst().get();
		}else {
			return null;
		}
	}

	/**
     * Cancela un vehículo eliminándolo de la lista de datos de vehículos.
     * @param objetoCancelar El vehículo a cancelar.
     * @return El vehículo cancelado.
     */
	public Vehiculo cancelarVehiculo(Vehiculo objetoCancelar) {
		datosVehiculos.remove(objetoCancelar);
		return objetoCancelar;
	}

	 /**
     * Modifica un vehículo existente.
     * @param objetoModificar El vehículo modificado.
     * @return El vehículo modificado o null si el vehículo no existe.
     */
	public Vehiculo modificarVehiculo(Vehiculo objetoModificar) {
		var aux = buscarVehiculo(objetoModificar.getId());
		if(aux!=null) {
			cancelarVehiculo(aux);
			return crearVehiculo(objetoModificar);
		}else {
			return null;
		}
	}

	 /**
     * Consulta todos los vehículos disponibles.
     * @return Un ArrayList de vehículos.
     */
	public ArrayList<Vehiculo> consularVehiculos(){
		return datosVehiculos;
	}


	/**
     * Crea una nueva reserva y la agrega a la lista de datos de reservas.
     * @param objeto La reserva a crear.
     * @return La reserva creada.
     */
	public Reserva crearReserva(Reserva objeto){
		datosReservas.add(objeto);
		return objeto;
	}

	/**
     * Busca una reserva por el identificador de usuario.
     * @param identificador El identificador de usuario de la reserva a buscar.
     * @return La reserva encontrada o null si no se encuentra.
     */
	public Reserva buscarReserva(Integer identificador) {
		Optional<Reserva> aux = datosReservas.stream().filter(objeto -> objeto.getIdUsuario() == identificador).findFirst();
		if(aux.isPresent()) {
			return datosReservas.stream().filter(objeto -> objeto.getIdUsuario() == identificador).findFirst().get();
		}else {
			return null;
		}
	}

	 /**
     * Cancela una reserva eliminándola de la lista de datos de reservas.
     * @param objetoCancelar La reserva a cancelar.
     * @return La reserva cancelada.
     */
	public Reserva cancelarReserva(Reserva objetoCancelar) {
		datosReservas.remove(objetoCancelar);
		return objetoCancelar;
	}
	
	/**
     * Modifica una reserva existente.
     * @param objetoModificar La reserva modificada.
     * @return La reserva modificada o null si la reserva no existe.
     */
	public Reserva modificarReserva(Reserva objetoModificar) {
		var aux = buscarReserva(objetoModificar.getIdUsuario());
		if(aux!=null) {
			cancelarReserva(aux);
			return crearReserva(objetoModificar);
		}else {
			return null;
		}
	}
	
	/**
     * Consulta todas las reservas existentes.
     * @return Un ArrayList de reservas.
     */
	public ArrayList<Reserva> consultarReservas(){
		return datosReservas;
	}
	
	/**
     * Método privado para cargar datos iniciales de vehículos y reservas.
     */
	public static void cargarDatos(){
		Vehiculo vehiculo = new Vehiculo(0, "car-1.jpg", "Automatico", "Toyota", "R4V4", "2021",100000, 10);
		Vehiculo vehiculo2 = new Vehiculo(1, "car-2.jpg", "Manual", "BMW", "F26", "2020",80000, 5);
		Vehiculo vehiculo3 = new Vehiculo(2, "car-3.jpg", "Manual", "Volkswagen", "Golf MK6", "2018", 90000, 6);
		Vehiculo vehiculo4 = new Vehiculo(3, "car-4.jpg", "Automatico", "Cadilac", "Royal", "2019", 150000, 4);
		datosVehiculos.add(vehiculo);
		datosVehiculos.add(vehiculo2);
		datosVehiculos.add(vehiculo3);
		datosVehiculos.add(vehiculo4);
		Reserva reserva = new Reserva(vehiculo, "David Camacho", 1005, LocalDate.of(2024, 3, 20), LocalDate.of(2024, 3, 25) , 1000, EnumEstadoReserva.COTIZADA);
		datosReservas.add(reserva);

	}

}
