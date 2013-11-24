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

/**
 * @author Bosz2013
 *
 */
@Entity
public class Eleccion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	private Integer id;
	
	@Column
	private Date fechaNaciemto;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "stock")
    @Cascade({CascadeType.SAVE_UPDATE})
	private List<Candidato> candidates;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
}
