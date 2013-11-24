package votaciones;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class UsuarioController {
	@Autowired
    private UsuarioDao usuarioDao;
  
 
    @RequestMapping(value="/admin/usuario")
    public ModelAndView listaUsuarios(HttpServletRequest request) {
        // Handle a new guest (if any):
        String usuario = request.getParameter("usuario");
        System.out.println("Usuario: ");
        System.out.println(usuario);
        String clave = request.getParameter("clave");
        if (usuario != null){
        	System.out.println("Almacenando el usuario");
        	Usuario u = new Usuario();
        	u.setUsuario(usuario);
        	u.setClave(clave);
        	usuarioDao.persist(u);
    	}
        
        // Prepare the result view (usuario.jsp):
        return new ModelAndView("usuario.jsp", "usuarioDao", usuarioDao);
    }
}
