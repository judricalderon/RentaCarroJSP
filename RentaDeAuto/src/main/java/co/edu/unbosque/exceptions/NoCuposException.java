package co.edu.unbosque.exceptions;

/**
 * La clase NoCuposException representa una excepción lanzada cuando no hay cupos disponibles.
 */
public class NoCuposException extends Exception{

	/**
     * Constructor de la clase NoCuposException.
     * @param mensaje El mensaje de error asociado con la excepción.
     */
	public NoCuposException(String mensaje) {
		super(mensaje);
	}
}
