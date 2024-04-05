package co.edu.unbosque.model.persistance;

import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.model.Vehiculo;

/**
 * La interfaz InterfaceVehiculoDAO extiende InterfaceDAO y proporciona métodos adicionales para operaciones específicas de Vehiculo.
 * @param <Tipo> El tipo de objeto con el que trabaja la interfaz.
 */
public interface InterfaceVehiculoDAO<Tipo> extends InterfaceDAO<Vehiculo, Integer>{

    /**
     * Busca un vehículo por tipo, marca, modelo y año.
     * @param tipo El tipo de vehículo a buscar.
     * @param marca La marca del vehículo a buscar.
     * @param modelo El modelo del vehículo a buscar.
     * @param anio El año del vehículo a buscar.
     * @return El vehículo encontrado.
     * @throws ObjetoNoExistenteException Si el vehículo no existe.
     */

	Tipo buscar(String tipo, String marca,String modelo,String anio) throws ObjetoNoExistenteException;
	
	
}
