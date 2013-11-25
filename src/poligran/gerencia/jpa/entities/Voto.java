/**
 * 
 */
package poligran.gerencia.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * @author Bosz2013
 *
 */
@Entity
@IdClass(value=VotoPK.class)
@NamedQueries({
	@NamedQuery(name="voto.loadByCandidateElection", query="SELECT v FROM Voto v WHERE " +
			"v.eleccion.idEleccion =:idEleccion AND v.candidato.numID =:numID"),
	@NamedQuery(name="voto.loadByElection", query="SELECT v FROM Voto v WHERE " +
					"v.eleccion.idEleccion =:idEleccion")
})
public class Voto {
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	private Integer id;*/
	
	@ManyToOne(targetEntity=Candidato.class, optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="candidato")
	@Id
	private Candidato candidato;
	
	@ManyToOne(targetEntity=Eleccion.class, optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="eleccion")
	@Id
	private Eleccion eleccion;
	
	@Id
	private String usuarioId;

	/*public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Eleccion getEleccion() {
		return eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}

	public String getUsuario() {
		return usuarioId;
	}

	public void setUsuario(String usuario) {
		this.usuarioId = usuario;
	}
	
	

}
