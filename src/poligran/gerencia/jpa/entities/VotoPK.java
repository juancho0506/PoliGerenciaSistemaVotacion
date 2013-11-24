/**
 * 
 */
package poligran.gerencia.jpa.entities;

import java.io.Serializable;

/**
 * @author Bosz2013
 *
 */
public class VotoPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9081765604885059957L;
	
	
	private Integer numID;
	
	private Integer idEleccion;
	
	private String usuarioId;

	public Integer getNumID() {
		return numID;
	}

	public void setNumID(Integer numID) {
		this.numID = numID;
	}

	public Integer getIdEleccion() {
		return idEleccion;
	}

	public void setIdEleccion(Integer idEleccion) {
		this.idEleccion = idEleccion;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String username) {
		this.usuarioId = username;
	}
	
}
