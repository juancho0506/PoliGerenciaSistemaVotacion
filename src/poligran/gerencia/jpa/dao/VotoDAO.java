package poligran.gerencia.jpa.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.Voto;

/**
 * 
 * @author Rodrigo Torres
 *
 */
public interface VotoDAO {
	
	public List<Voto> loadByElection(int idEleccion)throws PersistenceException;
	
	public List<Voto> loadByCandidateElection(int idEleccion, int IdCandidato)throws PersistenceException;
	
	public Voto getVoto(int id)throws PersistenceException;
	
	public void registrarVoto(Voto v) throws PersistenceException;
	
	public void actualizarVoto(Voto v) throws PersistenceException;
}
