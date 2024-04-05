package co.edu.unbosque.exceptions;

/**
 * La clase ObjetoNoExistenteException representa una excepción lanzada cuando un objeto no existe.
 */
public class ObjetoNoExistenteException extends Exception{

	/**
     * Constructor de la clase ObjetoNoExistenteException.
     * @param mensaje El mensaje de error asociado con la excepción.
     */
	public ObjetoNoExistenteException(String mensaje) {
		super(mensaje);
	}
}
