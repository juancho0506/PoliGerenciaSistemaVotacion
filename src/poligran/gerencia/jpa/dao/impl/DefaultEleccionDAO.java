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

import poligran.gerencia.jpa.dao.EleccionDAO;
import poligran.gerencia.jpa.entities.Eleccion;

/**
 * @author Rodrigo Torres
 *
 */
public class DefaultEleccionDAO implements EleccionDAO{
	
	private static final String PERSISTENCE_UNIT_NAME = "GerenciaSisEleccionesEM";
	private EntityManagerFactory entityFactory;
	
	private EntityManager em;

	public DefaultEleccionDAO() {
		entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = entityFactory.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
		em.getEntityManagerFactory().getCache().evictAll();
	}

	@Override
	public List<Eleccion> loadAll() throws PersistenceException {
		return em.createNamedQuery("eleccion.loadAll", Eleccion.class).getResultList();
	}

	@Override
	public Eleccion getEleccion(int id) throws PersistenceException {
		return em.find(Eleccion.class, id);
	}

	@Override
	public void registrarEleccion(Eleccion e) throws PersistenceException {
		em.getTransaction().begin();
		em.persist(e);
		em.flush();
		em.getTransaction().commit();
	}

	@Override
	public void actualizarEleccion(Eleccion e) throws PersistenceException {
		em.getTransaction().begin();
		em.merge(e);
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
