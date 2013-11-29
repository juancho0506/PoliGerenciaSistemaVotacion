/**
 * 
 */
package poligran.gerencia.managedBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import poligran.gerencia.jpa.dao.CandidatoDAO;
import poligran.gerencia.jpa.dao.EleccionDAO;
import poligran.gerencia.jpa.dao.VotoDAO;
import poligran.gerencia.jpa.dao.impl.DefaultCandidatoDAO;
import poligran.gerencia.jpa.dao.impl.DefaultEleccionDAO;
import poligran.gerencia.jpa.dao.impl.DefaultVotoDAO;
import poligran.gerencia.jpa.entities.Usuario;

/**
 * @author Rodrigo Torres
 *
 */
@ManagedBean(name="votacionesoBean")
public class VotacionesBean {
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private String value = "This editor is provided by PrimeFaces";
	
	private String message = "";
	private EleccionDAO eleccionDAO;
	private CandidatoDAO candidatoDAO;
	private VotoDAO votoDAO;
	 
	/**
	 * 
	 */
	public VotacionesBean() {
		eleccionDAO = new DefaultEleccionDAO();
		candidatoDAO = new DefaultCandidatoDAO();
		votoDAO = new DefaultVotoDAO();
		try {
			//usuarios = usuarioServ.listarUsuarios();
		} catch (Exception e) {
			message = "ERROR no se pudo crear la instancia de la pagina!";
		}
	}
	
	public String activarUsuario(){
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
			String username = params.get("id");
			//usuarioServ.activarUsuario(username);
			message = "INFO: Usuario activado con EXITO.";
		}catch(Exception e){
			e.printStackTrace();
			message = "ERROR no se pudo crear la instancia de la pagina!";
			
		}
		return "EXITO";
	}
	
	public String desactivarUsuario(){
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
			String username = params.get("id");
			//usuarioServ.desactivarUsuario(username);
			message = "INFO: Usuario desactivado con EXITO.";
		}catch(Exception e){
			e.printStackTrace();
			message = "ERROR no se pudo crear la instancia de la pagina!";
			
		}
		return "EXITO";
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getValue() {
		return value;
	}
 
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
