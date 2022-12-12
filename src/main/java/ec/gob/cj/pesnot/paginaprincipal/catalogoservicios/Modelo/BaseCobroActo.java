package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="BASECOBROACTO")
public class BaseCobroActo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDBASECOBROACTO")
	private Long idBaseCobroActo;
	
	@Column(name="NOMBREBASECOBROACTO")
	private String nombreBaseCobroActo;
	
	@Column(name="DESCRIPCIONBASECOBROACTO")
	private String descripcionBaseCobroActo;
	
	@Column(name="ESTADOBASECOBROACTO")
	private boolean estadoBaseCobroActo;
	
	

	public BaseCobroActo() {
		super();
	}



	public BaseCobroActo(Long idBaseCobroActo, String nombreBaseCobroActo, String descripcionBaseCobroActo,
			boolean estadoBaseCobroActo) {
		super();
		this.idBaseCobroActo = idBaseCobroActo;
		this.nombreBaseCobroActo = nombreBaseCobroActo;
		this.descripcionBaseCobroActo = descripcionBaseCobroActo;
		this.estadoBaseCobroActo = estadoBaseCobroActo;
	}
	
	



	public BaseCobroActo(String nombreBaseCobroActo, String descripcionBaseCobroActo, boolean estadoBaseCobroActo) {
		super();
		this.nombreBaseCobroActo = nombreBaseCobroActo;
		this.descripcionBaseCobroActo = descripcionBaseCobroActo;
		this.estadoBaseCobroActo = estadoBaseCobroActo;
	}



	public Long getIdBaseCobroActo() {
		return idBaseCobroActo;
	}



	public void setIdBaseCobroActo(Long idBaseCobroActo) {
		this.idBaseCobroActo = idBaseCobroActo;
	}



	public String getNombreBaseCobroActo() {
		return nombreBaseCobroActo;
	}



	public void setNombreBaseCobroActo(String nombreBaseCobroActo) {
		this.nombreBaseCobroActo = nombreBaseCobroActo;
	}



	public String getDescripcionBaseCobroActo() {
		return descripcionBaseCobroActo;
	}



	public void setDescripcionBaseCobroActo(String descripcionBaseCobroActo) {
		this.descripcionBaseCobroActo = descripcionBaseCobroActo;
	}



	public boolean isEstadoBaseCobroActo() {
		return estadoBaseCobroActo;
	}



	public void setEstadoBaseCobroActo(boolean estadoBaseCobroActo) {
		this.estadoBaseCobroActo = estadoBaseCobroActo;
	}



	@Override
	public String toString() {
		return "BaseCobroActo [idBaseCobroActo=" + idBaseCobroActo + ", nombreBaseCobroActo=" + nombreBaseCobroActo
				+ ", descripcionBaseCobroActo=" + descripcionBaseCobroActo + ", estadoBaseCobroActo="
				+ estadoBaseCobroActo + "]";
	}
	
	
	
	
	

}
