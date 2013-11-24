package poligran.gerencia.jpa.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="candidato.loadAll", query="SELECT c FROM Candidato c"),
	@NamedQuery(name="candidato.loadByElection", query="SELECT c FROM Candidato c WHERE c.eleccion.idEleccion =:idEleccion")
})
public class Candidato {
	
	@Id
	@Column
	@Basic(optional=false)
	private Integer numID;
	
	@Column
	private String nombreCompleto;
	@Column
	private String imagen;
	@Column
	private Date fechaNaciemto;
	@Column
	private Integer numeroLista;

	@ManyToOne(targetEntity=Eleccion.class)
	@JoinColumn(name="eleccion")
	private Eleccion eleccion;
	
	public Integer getNumID() {
		return numID;
	}

	public void setNumID(Integer numID) {
		this.numID = numID;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getFechaNaciemto() {
		return fechaNaciemto;
	}

	public void setFechaNaciemto(Date fechaNaciemto) {
		this.fechaNaciemto = fechaNaciemto;
	}

	public Integer getNumeroLista() {
		return numeroLista;
	}

	public void setNumeroLista(Integer numeroLista) {
		this.numeroLista = numeroLista;
	}

	public Eleccion getEleccion() {
		return eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}
}
