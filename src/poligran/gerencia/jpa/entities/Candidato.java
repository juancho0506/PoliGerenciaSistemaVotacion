package poligran.gerencia.jpa.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
}
