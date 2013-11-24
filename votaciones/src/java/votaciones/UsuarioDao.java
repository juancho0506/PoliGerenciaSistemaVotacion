package votaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class UsuarioDao {
	// Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    @Transactional
    public void persist(Usuario usuario) {
        em.persist(usuario);
    }
 
    // Retrieves all the guests:
    public List<Usuario> getAll() {
        TypedQuery<Usuario> query = em.createQuery(
            "SELECT u FROM Usuario u ORDER BY u.id", Usuario.class);
        
        System.out.println("Lista de resultados");
        List<Usuario> l = query.getResultList();
        System.out.println(l);
        
        return l;
    }
}
