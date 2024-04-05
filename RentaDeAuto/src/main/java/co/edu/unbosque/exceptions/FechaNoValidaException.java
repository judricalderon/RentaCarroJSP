package co.edu.unbosque.exceptions;

/**
 * La clase FechaNoValidaException representa una excepción lanzada cuando una fecha no es válida.
 */
public class FechaNoValidaException extends Exception{
	
	 /**
     * Constructor de la clase FechaNoValidaException.
     * @param mensaje El mensaje de error asociado con la excepción.
     */
	public FechaNoValidaException(String mensaje) {
		super(mensaje);
	}
}
