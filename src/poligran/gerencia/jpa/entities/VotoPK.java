/**
 * 
 */
package poligran.gerencia.jpa.entities;

import java.io.Serializable;


/**
 * @author Rodrigo Torres
 *
 */
public class VotoPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4882836295840214551L;

	Candidato candidato;
	
	Eleccion eleccion;
	
	String usuarioId;
	
}
