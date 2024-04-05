package co.edu.unbosque.model;

/**
 * La clase Vehiculo representa un vehículo disponible para alquiler.
 */
public class Vehiculo {
	
	private int id;
	private String imagen;
	private String tipo;
	private String marca;
	private String modelo;
	private String anio;
	private int precioAlquiler;
	private int cantidadVehiculosDisponibles;
	
	/**
     * Constructor para crear un objeto Vehiculo.
     * @param id El ID del vehículo.
     * @param imagen La URL de la imagen del vehículo.
     * @param tipo El tipo de vehículo.
     * @param marca La marca del vehículo.
     * @param modelo El modelo del vehículo.
     * @param anio El año de fabricación del vehículo.
     * @param precioAlquiler El precio de alquiler por día del vehículo.
     * @param cantidadVehiculosDisponibles La cantidad de vehículos disponibles para alquiler.
     */
	public Vehiculo(int id, String imagen, String tipo, String marca, String modelo, String anio, int precioAlquiler,
			int cantidadVehiculosDisponibles) {
		this.id = id;
		this.imagen = imagen;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.precioAlquiler = precioAlquiler;
		this.cantidadVehiculosDisponibles = cantidadVehiculosDisponibles;
	}
	
	/**
     * Calcula el precio total del alquiler del vehículo para un número de días especificado.
     * @param numeroDias El número de días de alquiler.
     * @return El precio total del alquiler.
     */
    public int calcularPrecioTotal(int numeroDias){
        return precioAlquiler * numeroDias;
    }
    
    /**
     * Obtiene el ID del vehículo.
     * @return El ID del vehículo.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Establece el ID del vehículo.
     * @param id El ID del vehículo.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtiene la URL de la imagen del vehículo.
     * @return La URL de la imagen.
     */
    public String getImagen() {
        return imagen;
    }
    
    /**
     * Establece la URL de la imagen del vehículo.
     * @param imagen La URL de la imagen.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     * Obtiene el tipo de vehículo.
     * @return El tipo de vehículo.
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Establece el tipo de vehículo.
     * @param tipo El tipo de vehículo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Obtiene la marca del vehículo.
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Establece la marca del vehículo.
     * @param marca La marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Obtiene el modelo del vehículo.
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Establece el modelo del vehículo.
     * @param modelo El modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Obtiene el año de fabricación del vehículo.
     * @return El año de fabricación del vehículo.
     */
    public String getAnio() {
        return anio;
    }
    
    /**
     * Establece el año de fabricación del vehículo.
     * @param anio El año de fabricación del vehículo.
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    /**
     * Obtiene el precio de alquiler por día del vehículo.
     * @return El precio de alquiler por día.
     */
    public int getPrecioAlquiler() {
        return precioAlquiler;
    }
    
    /**
     * Establece el precio de alquiler por día del vehículo.
     * @param precioAlquiler El precio de alquiler por día.
     */
    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    
    /**
     * Obtiene la cantidad de vehículos disponibles para alquiler.
     * @return La cantidad de vehículos disponibles.
     */
    public int getCantidadVehiculosDisponibles() {
        return cantidadVehiculosDisponibles;
    }
    
    /**
     * Establece la cantidad de vehículos disponibles para alquiler.
     * @param cantidadVehiculosDisponibles La cantidad de vehículos disponibles.
     */
    public void setCantidadVehiculosDisponibles(int cantidadVehiculosDisponibles) {
        this.cantidadVehiculosDisponibles = cantidadVehiculosDisponibles;
    }

}