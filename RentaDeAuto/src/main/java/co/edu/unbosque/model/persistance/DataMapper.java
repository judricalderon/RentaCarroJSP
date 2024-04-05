package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.model.Reserva;
import co.edu.unbosque.model.ReservaDTO;
import co.edu.unbosque.model.Vehiculo;
import co.edu.unbosque.model.VehiculoDTO;

/**
 * La clase DataMapper proporciona métodos estáticos para mapear entre entidades y DTOs.
 */
public class DataMapper {
	
	  /**
     * Convierte un objeto Vehiculo a un objeto VehiculoDTO.
     * @param vehiculo El objeto Vehiculo a convertir.
     * @return El objeto VehiculoDTO resultante.
     */
	public static VehiculoDTO deEntidadVehiculo(Vehiculo vehiculo) {
		return new VehiculoDTO(vehiculo.getId(), vehiculo.getImagen(), vehiculo.getTipo(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getAnio(), vehiculo.getPrecioAlquiler(), vehiculo.getCantidadVehiculosDisponibles());
	}
	
	 /**
     * Convierte un objeto VehiculoDTO a un objeto Vehiculo.
     * @param vehiculoDTO El objeto VehiculoDTO a convertir.
     * @return El objeto Vehiculo resultante.
     */
	public static Vehiculo deVehiculoDTO(VehiculoDTO vehiculoDTO) {
		return new Vehiculo(vehiculoDTO.getId(), vehiculoDTO.getImagen(), vehiculoDTO.getTipo(), vehiculoDTO.getMarca(), vehiculoDTO.getModelo(), vehiculoDTO.getAnio(), vehiculoDTO.getPrecioAlquiler(), vehiculoDTO.getCantidadVehiculosDisponibles());
	}
	
	/**
     * Convierte un objeto Reserva a un objeto ReservaDTO.
     * @param reserva El objeto Reserva a convertir.
     * @return El objeto ReservaDTO resultante.
     */
	public static ReservaDTO deEntidadReserva(Reserva reserva) {
		return new ReservaDTO(DataMapper.deEntidadVehiculo(reserva.getVehiculoAlquilado()), reserva.getNombreUsuario(),reserva.getIdUsuario(),reserva.getFechaInicio(), reserva.getFechaFinal(), reserva.getPrecioTotal(), reserva.getEstado());
	}
	
	 /**
     * Convierte un objeto ReservaDTO a un objeto Reserva.
     * @param reservaDTO El objeto ReservaDTO a convertir.
     * @return El objeto Reserva resultante.
     */
	public static Reserva deReservaDTO(ReservaDTO reservaDTO) {
		return new Reserva(DataMapper.deVehiculoDTO(reservaDTO.getVehiculoAlquilado()), reservaDTO.getNombreUsuario(),reservaDTO.getIdUsuario(),reservaDTO.getFechaInicio(), reservaDTO.getFechaFinal(), reservaDTO.getPrecioTotal(), reservaDTO.getEstado());
	}

	 /**
     * Convierte un ArrayList de Vehiculo a un ArrayList de VehiculoDTO.
     * @param arrayVehiculo El ArrayList de Vehiculo a convertir.
     * @return El ArrayList de VehiculoDTO resultante.
     */
	public static ArrayList<VehiculoDTO> deArrayEntidadVehiculo(ArrayList<Vehiculo> arrayVehiculo) {
		ArrayList<VehiculoDTO> vehiculosDto = new ArrayList<VehiculoDTO>();
		for(Vehiculo aux : arrayVehiculo) {
			vehiculosDto.add(DataMapper.deEntidadVehiculo(aux));
		}
		return vehiculosDto;
	}
	
	 /**
     * Convierte un ArrayList de VehiculoDTO a un ArrayList de Vehiculo.
     * @param arrayVehiculoDto El ArrayList de VehiculoDTO a convertir.
     * @return El ArrayList de Vehiculo resultante.
     */
	public static ArrayList<Vehiculo> deArrayVehiculoDto(ArrayList<VehiculoDTO> arrayVehiculoDto) {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		for(VehiculoDTO aux : arrayVehiculoDto) {
			vehiculos.add(DataMapper.deVehiculoDTO(aux));
		}
		return vehiculos;
	}
	
	 /**
     * Convierte un ArrayList de Reserva a un ArrayList de ReservaDTO.
     * @param arrayReserva El ArrayList de Reserva a convertir.
     * @return El ArrayList de ReservaDTO resultante.
     */
	public static ArrayList<ReservaDTO> deArrayEntidadReserva(ArrayList<Reserva> arrayReserva) {
		ArrayList<ReservaDTO> reservasDto = new ArrayList<ReservaDTO>();
		for(Reserva aux : arrayReserva) {
			reservasDto.add(DataMapper.deEntidadReserva(aux));
		}
		return reservasDto;
	}
	
	
	/**
     * Convierte un ArrayList de ReservaDTO a un ArrayList de Reserva.
     * @param arrayReservaDto El ArrayList de ReservaDTO a convertir.
     * @return El ArrayList de Reserva resultante.
     */
	public static ArrayList<Reserva> deArrayReservaDto(ArrayList<ReservaDTO> arrayReservaDto) {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		for(ReservaDTO aux : arrayReservaDto) {
			reservas.add(DataMapper.deReservaDTO(aux));
		}
		return reservas;
	}
	
	
	
}
