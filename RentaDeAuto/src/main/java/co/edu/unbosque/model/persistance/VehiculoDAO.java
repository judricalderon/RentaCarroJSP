package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.exceptions.ObjetoExistenteException;
import co.edu.unbosque.exceptions.ObjetoNoExistenteException;
import co.edu.unbosque.model.Vehiculo;

/**
 * La clase VehiculoDAO implementa InterfaceVehiculoDAO para la gestión de vehículos.
 */
public class VehiculoDAO implements InterfaceVehiculoDAO<Vehiculo> {

	private DataSource dataSource;

    /**
     * Constructor de la clase VehiculoDAO.
     */
	public VehiculoDAO() {
		dataSource = new DataSource();
	}

	@Override
	public Vehiculo crear(Vehiculo objeto) throws ObjetoExistenteException {
		if (buscar(objeto.getId()) == null) {
			return dataSource.crearVehiculo(objeto);
		} else {
			throw new ObjetoExistenteException("El Vehiculo que trata de crear ya existe!");
		}
	}

	@Override
	public Vehiculo buscar(Integer identificador) {
		return dataSource.buscarVehiculo(identificador);
	}

	@Override
	public Vehiculo cancelar(Vehiculo objetoCancelar) throws ObjetoNoExistenteException {
		return dataSource.cancelarVehiculo(objetoCancelar);
	}

	@Override
	public Vehiculo modificar(Vehiculo objetoModificar) throws ObjetoNoExistenteException {
		if (buscar(objetoModificar.getId()) != null) {
			return dataSource.modificarVehiculo(objetoModificar);
		} else {
			throw new ObjetoNoExistenteException("El vehiculo que trata de modificar no existe!");
		}
	}

	@Override
	public ArrayList<Vehiculo> consular() {
		return dataSource.consularVehiculos();
	}

	@Override
	public Vehiculo buscar(String tipo, String marca, String modelo, String anio) throws ObjetoNoExistenteException {
		var aux = dataSource.buscarVehiculoParametros(tipo, marca, modelo, anio);
		if (aux != null) {
			return aux;
		} else {
			throw new ObjetoNoExistenteException("El Vehiculo que desea buscar no existe!");
		}
	}

}
