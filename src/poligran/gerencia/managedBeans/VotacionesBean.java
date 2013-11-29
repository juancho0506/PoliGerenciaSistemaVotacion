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
import poligran.gerencia.jpa.entities.Candidato;
import poligran.gerencia.jpa.entities.Eleccion;
import poligran.gerencia.jpa.entities.Usuario;

/**
 * @author Rodrigo Torres
 *
 */
@ManagedBean(name="votacionesoBean")
public class VotacionesBean {
	
	private List<Eleccion> elecciones = new ArrayList<Eleccion>();
	private List<Candidato> candidatos = new ArrayList<Candidato>();
	private Eleccion eleccionActual = null;
	
	private String message = "";
	private EleccionDAO eleccionDAO;
	private CandidatoDAO candidatoDAO;
	private VotoDAO votoDAO;
	private boolean mostrarCandidatos = false;
	private boolean votoRealizado;
	 
	/**
	 * 
	 */
	public VotacionesBean() {
		eleccionDAO = new DefaultEleccionDAO();
		candidatoDAO = new DefaultCandidatoDAO();
		votoDAO = new DefaultVotoDAO();
		try {
			elecciones = eleccionDAO.loadAll();
		} catch (Exception e) {
			message = "ERROR no se pudo crear la instancia de la pagina!";
		}
	}
	
	public String votarCandidato(){
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
			String idCandidato = params.get("id");
			//usuarioServ.activarUsuario(username);
			message = "INFO: Usuario activado con EXITO.";
		}catch(Exception e){
			e.printStackTrace();
			message = "ERROR no se pudo crear la instancia de la pagina!";
			
		}
		return "EXITO";
	}
	
	public String loadCandidatesElection(){
		candidatos = new ArrayList<Candidato>();
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		String eleccionId = params.get("id");
		Eleccion e = eleccionDAO.getEleccion(Integer.parseInt(eleccionId));
		
		candidatos = candidatoDAO.loadByElection(e);
		mostrarCandidatos = true;
		return "EXITO";
	}

	public List<Eleccion> getElecciones() {
		return elecciones;
	}

	public void setElecciones(List<Eleccion> elecciones) {
		this.elecciones = elecciones;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EleccionDAO getEleccionDAO() {
		return eleccionDAO;
	}

	public void setEleccionDAO(EleccionDAO eleccionDAO) {
		this.eleccionDAO = eleccionDAO;
	}

	public CandidatoDAO getCandidatoDAO() {
		return candidatoDAO;
	}

	public void setCandidatoDAO(CandidatoDAO candidatoDAO) {
		this.candidatoDAO = candidatoDAO;
	}

	public VotoDAO getVotoDAO() {
		return votoDAO;
	}

	public void setVotoDAO(VotoDAO votoDAO) {
		this.votoDAO = votoDAO;
	}

	public boolean isVotoRealizado() {
		return votoRealizado;
	}

	public void setVotoRealizado(boolean votoRealizado) {
		this.votoRealizado = votoRealizado;
	}

	public boolean isMostrarCandidatos() {
		return mostrarCandidatos;
	}

	public void setMostrarCandidatos(boolean mostrarCandidatos) {
		this.mostrarCandidatos = mostrarCandidatos;
	}
	
}
