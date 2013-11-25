/**
 * 
 */
package poligran.gerencia.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import poligran.gerencia.jpa.dao.CandidatoDAO;
import poligran.gerencia.jpa.entities.Candidato;
import poligran.gerencia.jpa.entities.Eleccion;

/**
 * @author Bosz2013
 *
 */
public class DefaultCandidatoDAO implements CandidatoDAO {
	
	private static final String PERSISTENCE_UNIT_NAME = "GerenciaSisEleccionesEM";
	private EntityManagerFactory entityFactory;
	
	private EntityManager em;
	

	public DefaultCandidatoDAO() {
		entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityFactory.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
		em.getEntityManagerFactory().getCache().evictAll();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.CandidatoDAO#loadAll()
	 */
	@Override
	public List<Candidato> loadAll() throws PersistenceException {
		return em.createNamedQuery("candidato.loadAll", Candidato.class).getResultList();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.CandidatoDAO#loadByElection(poligran.gerencia.jpa.entities.Eleccion)
	 */
	@Override
	public List<Candidato> loadByElection(Eleccion e)
			throws PersistenceException {
		
		Query q = em.createNamedQuery("candidato.loadByElection", Candidato.class);
		q.setParameter("idEleccion", e.getIdEleccion());
		return q.getResultList();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.CandidatoDAO#getCandidato(int)
	 */
	@Override
	public Candidato getCandidato(int id) throws PersistenceException {
		return em.find(Candidato.class, id);
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.CandidatoDAO#registrarCandidato(poligran.gerencia.jpa.entities.Candidato)
	 */
	@Override
	public void registrarCandidato(Candidato c) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(c);
		em.flush();
		em.getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.CandidatoDAO#actualizarCandidato(poligran.gerencia.jpa.entities.Candidato)
	 */
	@Override
	public void actualizarCandidato(Candidato c) throws PersistenceException {
		em.getTransaction().begin();
		em.merge(c);
		em.flush();
		em.getTransaction().commit();
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
