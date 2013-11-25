package poligran.gerencia.jpa.dao.impl;

import static org.junit.Assert.fail;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poligran.gerencia.jpa.entities.Candidato;
import poligran.gerencia.jpa.entities.Eleccion;

public class DefaultCandidatoDAOTest {
	
	DefaultCandidatoDAO dao = new DefaultCandidatoDAO();
	EntityManagerFactory emf;

	@Before
	public void setUp() throws Exception {
		// Open a database connection
        // (create a new database if it doesn't exist yet):
		try {
			emf = Persistence.createEntityManagerFactory("GerenciaSisEleccionesEM");
		    dao.setEm(emf.createEntityManager());
		    dao.getEm().setFlushMode(FlushModeType.COMMIT);
		    dao.getEm().getEntityManagerFactory().getCache().evictAll();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@After
	public void tearDown() throws Exception {
		if(emf!=null){
			emf.close();
		}
	}

	@Test
	public void testLoadAll() {
		try {
			System.out.println("Candidatos: ");
			for (Candidato elem : dao.loadAll()) {
				System.out.println("- "+elem.getNombreCompleto());
			}			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testLoadByElection() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCandidato() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistrarCandidato() {
		
		Candidato c = new Candidato();
		c.setNombreCompleto("Juan Rodrigo Torres");
		c.setFechaNaciemto(new Date());
		c.setImagen("");
		c.setNumeroLista(1111);
		c.setNumID(80133351);
		
		try {
			dao.registrarCandidato(c);
			this.testLoadAll();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testActualizarCandidato() {
		fail("Not yet implemented");
	}

}
