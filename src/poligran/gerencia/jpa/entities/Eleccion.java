/**
 * 
 */
package poligran.gerencia.jpa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * @author Bosz2013
 *
 */
@Entity
@NamedQueries(
	@NamedQuery(name="eleccion.loadAll", query="SELECT e FROM Eleccion e")
)
public class Eleccion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	private Integer idEleccion;
	
	@Column
	private Date fechaNaciemto;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "eleccion")
    @Cascade({CascadeType.SAVE_UPDATE})
	private List<Candidato> candidates;
	

	public Integer getIdEleccion() {
		return idEleccion;
	}

	public void setIdEleccion(Integer id) {
		this.idEleccion = id;
	}

	public Date getFechaNaciemto() {
		return fechaNaciemto;
	}

	public void setFechaNaciemto(Date fechaNaciemto) {
		this.fechaNaciemto = fechaNaciemto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Candidato> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidato> candidates) {
		this.candidates = candidates;
	}
	
}
