/**
 * 
 */
package poligran.gerencia.jpa.dao;

import java.util.List;

import javax.persistence.PersistenceException;
import poligran.gerencia.jpa.entities.Eleccion;

/**
 * @author Rodrigo Torres
 *
 */
public interface EleccionDAO {
	
	public List<Eleccion> loadAll()throws PersistenceException;
	
	public Eleccion getEleccion(int id)throws PersistenceException;
	
	public void registrarEleccion(Eleccion e) throws PersistenceException;
	
	public void actualizarEleccion(Eleccion e) throws PersistenceException;

}
