package co.edu.unbosque.exceptions;

/**
 * La clase PagoException representa una excepción lanzada cuando se produce un error durante el proceso de pago.
 */
public class PagoException extends Exception{
	
	/**
     * Constructor de la clase PagoException.
     * @param mensaje El mensaje de error asociado con la excepción.
     */
	
	public PagoException(String mensaje) {
		super(mensaje);
	}
}
