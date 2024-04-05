package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.exceptions.ObjetoExistenteException;
import co.edu.unbosque.exceptions.ObjetoNoExistenteException;

/**
 * La interfaz InterfaceDAO proporciona métodos para operaciones básicas de acceso a datos.
 * @param <Tipo> El tipo de objeto con el que trabaja la interfaz.
 * @param <Identificador> El tipo de identificador utilizado para buscar objetos.
 */
public interface InterfaceDAO<Tipo, Identificador> {

    /**
     * Crea un nuevo objeto.
     * @param objeto El objeto a crear.
     * @return El objeto creado.
     * @throws ObjetoExistenteException Si el objeto ya existe.
     */
	Tipo crear(Tipo objeto)  throws ObjetoExistenteException;
	
	/**
     * Busca un objeto por su identificador.
     * @param identificador El identificador del objeto a buscar.
     * @return El objeto encontrado, o null si no se encuentra.
     */
	Tipo buscar(Identificador identificador);
	
	/**
     * Cancela un objeto existente.
     * @param objetoCancelar El objeto a cancelar.
     * @return El objeto cancelado.
     * @throws ObjetoNoExistenteException Si el objeto no existe.
     */
	Tipo cancelar(Tipo objetoCancelar) throws ObjetoNoExistenteException;
	
	/**
     * Modifica un objeto existente.
     * @param objetoModificar El objeto a modificar.
     * @return El objeto modificado.
     * @throws ObjetoNoExistenteException Si el objeto no existe.
     */
	Tipo modificar(Tipo objetoModificar) throws ObjetoNoExistenteException;
	

    /**
     * Consulta todos los objetos del tipo especificado.
     * @return Un ArrayList que contiene todos los objetos del tipo especificado.
     */
	ArrayList<Tipo> consular();
	
	
}