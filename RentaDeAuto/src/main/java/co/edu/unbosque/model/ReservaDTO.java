package co.edu.unbosque.model;

import java.time.LocalDate;

/**
 * La clase ReservaDTO representa una reserva de vehículo en formato de transferencia de datos (DTO).
 */
public class ReservaDTO {

	private VehiculoDTO vehiculoAlquilado; 
	private String nombreUsuario;
	private int idUsuario;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private int precioTotal;
	private EnumEstadoReserva estado;
	
	 /**
     * Constructor para crear un objeto ReservaDTO.
     * @param vehiculoAlquilado El vehículo alquilado en formato DTO.
     * @param nombreUsuario El nombre del usuario que realiza la reserva.
     * @param idUsuario El ID del usuario que realiza la reserva.
     * @param fechaInicio La fecha de inicio de la reserva.
     * @param fechaFinal La fecha de finalización de la reserva.
     * @param precioTotal El precio total de la reserva.
     * @param estado El estado de la reserva.
     */
	public ReservaDTO(VehiculoDTO vehiculoAlquilado, String nombreUsuario, int idUsuario, LocalDate fechaInicio,
			LocalDate fechaFinal, int precioTotal, EnumEstadoReserva estado) {
		this.vehiculoAlquilado = vehiculoAlquilado;
		this.nombreUsuario = nombreUsuario;
		this.idUsuario = idUsuario;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.precioTotal = precioTotal;
		this.estado = estado;
	}
	
	 /**
     * Obtiene el vehículo alquilado en formato DTO.
     * @return El vehículo alquilado.
     */
    public VehiculoDTO getVehiculoAlquilado() {
        return vehiculoAlquilado;
    }
    
    /**
     * Establece el vehículo alquilado en formato DTO.
     * @param vehiculoAlquilado El vehículo alquilado.
     */
    public void setVehiculoAlquilado(VehiculoDTO vehiculoAlquilado) {
        this.vehiculoAlquilado = vehiculoAlquilado;
    }
    
    /**
     * Obtiene el nombre del usuario que realizó la reserva.
     * @return El nombre del usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    /**
     * Establece el nombre del usuario que realizó la reserva.
     * @param nombreUsuario El nombre del usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    /**
     * Obtiene el ID del usuario que realizó la reserva.
     * @return El ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    
    /**
     * Establece el ID del usuario que realizó la reserva.
     * @param idUsuario El ID del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * Obtiene la fecha de inicio de la reserva.
     * @return La fecha de inicio.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    
    /**
     * Establece la fecha de inicio de la reserva.
     * @param fechaInicio La fecha de inicio.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    /**
     * Obtiene la fecha de finalización de la reserva.
     * @return La fecha de finalización.
     */
    public LocalDate getFechaFinal() {
        return fechaFinal;
    }
    
    /**
     * Establece la fecha de finalización de la reserva.
     * @param fechaFinal La fecha de finalización.
     */
    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    /**
     * Obtiene el precio total de la reserva.
     * @return El precio total.
     */
    public int getPrecioTotal() {
        return precioTotal;
    }
    
    /**
     * Establece el precio total de la reserva.
     * @param precioTotal El precio total.
     */
    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    /**
     * Obtiene el estado de la reserva.
     * @return El estado de la reserva.
     */
    public EnumEstadoReserva getEstado() {
        return estado;
    }
    
    /**
     * Establece el estado de la reserva.
     * @param estado El estado de la reserva.
     */
    public void setEstado(EnumEstadoReserva estado) {
        this.estado = estado;
    }
    
}
