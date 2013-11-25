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

import poligran.gerencia.jpa.dao.VotoDAO;
import poligran.gerencia.jpa.entities.Voto;

/**
 * @author Bosz2013
 *
 */
public class DefaultVotoDAO implements VotoDAO {
	
	private static final String PERSISTENCE_UNIT_NAME = "GerenciaSisEleccionesEM";
	private EntityManagerFactory entityFactory;
	
	private EntityManager em;
	
	
	public DefaultVotoDAO() {
		entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityFactory.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
		em.getEntityManagerFactory().getCache().evictAll();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#loadByElection(int)
	 */
	@Override
	public List<Voto> loadByElection(int idEleccion)
			throws PersistenceException {
		Query q = em.createNamedQuery("voto.loadByElection", Voto.class);
		q.setParameter("idEleccion", idEleccion);
		return q.getResultList();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#loadByCandidateElection(int, int)
	 */
	@Override
	public List<Voto> loadByCandidateElection(int idEleccion, int IdCandidato)
			throws PersistenceException {
		Query q = em.createNamedQuery("voto.loadByCandidateElection", Voto.class);
		q.setParameter("idEleccion", idEleccion);
		q.setParameter("numID", IdCandidato);
		return q.getResultList();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#getVoto(int)
	 */
	@Override
	public Voto getVoto(int id) throws PersistenceException {
		return em.find(Voto.class, id);
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#registrarVoto(poligran.gerencia.jpa.entities.Voto)
	 */
	@Override
	public void registrarVoto(Voto v) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(v);
		em.flush();
		em.getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see poligran.gerencia.jpa.dao.VotoDAO#actualizarVoto(poligran.gerencia.jpa.entities.Voto)
	 */
	@Override
	public void actualizarVoto(Voto v) throws PersistenceException {
		em.getTransaction().begin();
		em.merge(v);
		em.flush();
		em.getTransaction().commit();
	}

}
