package poligran.gerencia.jpa.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import poligran.gerencia.jpa.entities.Candidato;
import poligran.gerencia.jpa.entities.Eleccion;

/**
 * 
 * @author Rodrigo Tores
 *
 */
public interface CandidatoDAO {
	
	public List<Candidato> loadAll()throws PersistenceException;
	
	public List<Candidato> loadByElection(Eleccion e)throws PersistenceException;
	
	public Candidato getCandidato(int id)throws PersistenceException;
	
	public void registrarCandidato(Candidato c) throws PersistenceException;
	
	public void actualizarCandidato(Candidato c) throws PersistenceException;
}
