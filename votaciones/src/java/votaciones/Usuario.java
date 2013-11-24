package votaciones;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Usuario implements Serializable{
	  private static final long serialVersionUID = 1L;
  
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String usuario;
    private String clave;
 
    // Constructors:
    public Usuario() {
    }
 
    

    // String Representation:
    @Override
    public String toString() {
        return getUsuario();
    }



    public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}
}
