package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOGOACTO")
public class MotivoCobroActo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDMOTIVOCOBROACTO")
	private Long idMotivoCobroActo;
	
	@Column(name="NOMBREMOTIVOCOBROACTO")
	private String nombreMotivoCobroActo;
	
	@Column(name="DESCRIPCIONMOTIVOCOBROACTO")
	private String descripcionMotivoCobroActo;
	
	@Column(name="ESTADOMOTIVOCOBROACTO")
	private Boolean estadoMotivoCobroActo;

	public MotivoCobroActo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotivoCobroActo(Long idMotivoCobroActo, String nombreMotivoCobroActo, String descripcionMotivoCobroActo,
			Boolean estadoMotivoCobroActo) {
		super();
		this.idMotivoCobroActo = idMotivoCobroActo;
		this.nombreMotivoCobroActo = nombreMotivoCobroActo;
		this.descripcionMotivoCobroActo = descripcionMotivoCobroActo;
		this.estadoMotivoCobroActo = estadoMotivoCobroActo;
	}

	public Long getIdMotivoCobroActo() {
		return idMotivoCobroActo;
	}

	public void setIdMotivoCobroActo(Long idMotivoCobroActo) {
		this.idMotivoCobroActo = idMotivoCobroActo;
	}

	public String getNombreMotivoCobroActo() {
		return nombreMotivoCobroActo;
	}

	public void setNombreMotivoCobroActo(String nombreMotivoCobroActo) {
		this.nombreMotivoCobroActo = nombreMotivoCobroActo;
	}

	public String getDescripcionMotivoCobroActo() {
		return descripcionMotivoCobroActo;
	}

	public void setDescripcionMotivoCobroActo(String descripcionMotivoCobroActo) {
		this.descripcionMotivoCobroActo = descripcionMotivoCobroActo;
	}

	public Boolean getEstadoMotivoCobroActo() {
		return estadoMotivoCobroActo;
	}

	public void setEstadoMotivoCobroActo(Boolean estadoMotivoCobroActo) {
		this.estadoMotivoCobroActo = estadoMotivoCobroActo;
	}

	@Override
	public String toString() {
		return "MotivoCobroActo [idMotivoCobroActo=" + idMotivoCobroActo + ", nombreMotivoCobroActo="
				+ nombreMotivoCobroActo + ", descripcionMotivoCobroActo=" + descripcionMotivoCobroActo
				+ ", estadoMotivoCobroActo=" + estadoMotivoCobroActo + "]";
	}
	
	
	

}
