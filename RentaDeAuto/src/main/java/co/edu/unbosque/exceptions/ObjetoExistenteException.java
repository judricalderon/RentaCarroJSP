package co.edu.unbosque.exceptions;

/**
 * La clase ObjetoExistenteException representa una excepción lanzada cuando un objeto ya existe.
 */
public class ObjetoExistenteException extends Exception {

	/**
     * Constructor de la clase ObjetoExistenteException.
     * @param mensaje El mensaje de error asociado con la excepción.
     */
	public ObjetoExistenteException(String mensaje) {
		super(mensaje);
	}
}
