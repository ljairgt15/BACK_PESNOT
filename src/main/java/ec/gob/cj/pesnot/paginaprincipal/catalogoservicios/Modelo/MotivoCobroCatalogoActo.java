package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "MotivoCobroCatalogoacto")
public class MotivoCobroCatalogoActo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMotivoCobroCatalogoActo")
	private Long idMotivoCobroCatalogoActo;

	@ManyToOne(targetEntity = ActoNotarial.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCatalogoActoNotarial", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private ActoNotarial idCatalogoActoNotarial;

	@ManyToOne(targetEntity = MotivoCobroActo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idMotivoCobroActo", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private MotivoCobroActo idMotivoCobroActo;

	@Column(name = "valorMotivoCobroCatalogoActo")
	private Double valorMotivoCobroCatalogoActo;

	@Column(name = "porcentajeMotivoCobroCatalogoActo")
	private Double porcentajeMotivoCobroCatalogoActo;

	@Column(name = "estadoMotivoCobroCatalogoActo")
	private Boolean estadoMotivoCobroCatalogoActo;
	
	@Column(name = "porcentajeParticipacionEstadoMotivoCobroCatalogoActo")
	private Double 	porcentajeParticipacionEstadoMotivoCobroCatalogoActo;
	
	@Column(name = "porcentajeParticipacionNotarioMotivoCobroCatalogoActo")
	private Double porcentajeParticipacionNotarioMotivoCobroCatalogoActo;


	public MotivoCobroCatalogoActo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getIdMotivoCobroCatalogoActo() {
		return idMotivoCobroCatalogoActo;
	}


	public void setIdMotivoCobroCatalogoActo(Long idMotivoCobroCatalogoActo) {
		this.idMotivoCobroCatalogoActo = idMotivoCobroCatalogoActo;
	}


	public ActoNotarial getIdCatalogoActoNotarial() {
		return idCatalogoActoNotarial;
	}


	public void setIdCatalogoActoNotarial(ActoNotarial idCatalogoActoNotarial) {
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
	}


	public MotivoCobroActo getIdMotivoCobroActo() {
		return idMotivoCobroActo;
	}


	public void setIdMotivoCobroActo(MotivoCobroActo idMotivoCobroActo) {
		this.idMotivoCobroActo = idMotivoCobroActo;
	}


	public Double getValorMotivoCobroCatalogoActo() {
		return valorMotivoCobroCatalogoActo;
	}


	public void setValorMotivoCobroCatalogoActo(Double valorMotivoCobroCatalogoActo) {
		this.valorMotivoCobroCatalogoActo = valorMotivoCobroCatalogoActo;
	}


	public Double getPorcentajeMotivoCobroCatalogoActo() {
		return porcentajeMotivoCobroCatalogoActo;
	}


	public void setPorcentajeMotivoCobroCatalogoActo(Double porcentajeMotivoCobroCatalogoActo) {
		this.porcentajeMotivoCobroCatalogoActo = porcentajeMotivoCobroCatalogoActo;
	}


	public Boolean getEstadoMotivoCobroCatalogoActo() {
		return estadoMotivoCobroCatalogoActo;
	}


	public void setEstadoMotivoCobroCatalogoActo(Boolean estadoMotivoCobroCatalogoActo) {
		this.estadoMotivoCobroCatalogoActo = estadoMotivoCobroCatalogoActo;
	}


	public Double getPorcentajeParticipacionEstadoMotivoCobroCatalogoActo() {
		return porcentajeParticipacionEstadoMotivoCobroCatalogoActo;
	}


	public void setPorcentajeParticipacionEstadoMotivoCobroCatalogoActo(
			Double porcentajeParticipacionEstadoMotivoCobroCatalogoActo) {
		this.porcentajeParticipacionEstadoMotivoCobroCatalogoActo = porcentajeParticipacionEstadoMotivoCobroCatalogoActo;
	}


	public Double getPorcentajeParticipacionNotarioMotivoCobroCatalogoActo() {
		return porcentajeParticipacionNotarioMotivoCobroCatalogoActo;
	}


	public void setPorcentajeParticipacionNotarioMotivoCobroCatalogoActo(
			Double porcentajeParticipacionNotarioMotivoCobroCatalogoActo) {
		this.porcentajeParticipacionNotarioMotivoCobroCatalogoActo = porcentajeParticipacionNotarioMotivoCobroCatalogoActo;
	}


	@Override
	public String toString() {
		return "MotivoCobroCatalogoActo [idMotivoCobroCatalogoActo=" + idMotivoCobroCatalogoActo
				+ ", idCatalogoActoNotarial=" + idCatalogoActoNotarial + ", idMotivoCobroActo=" + idMotivoCobroActo
				+ ", valorMotivoCobroCatalogoActo=" + valorMotivoCobroCatalogoActo
				+ ", porcentajeMotivoCobroCatalogoActo=" + porcentajeMotivoCobroCatalogoActo
				+ ", estadoMotivoCobroCatalogoActo=" + estadoMotivoCobroCatalogoActo
				+ ", porcentajeParticipacionEstadoMotivoCobroCatalogoActo="
				+ porcentajeParticipacionEstadoMotivoCobroCatalogoActo
				+ ", porcentajeParticipacionNotarioMotivoCobroCatalogoActo="
				+ porcentajeParticipacionNotarioMotivoCobroCatalogoActo + "]";
	}


}
