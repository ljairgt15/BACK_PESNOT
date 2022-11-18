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
@Table(name = "MOTIVOCOBROCATALOGOACTO")
public class MotivoCobroCatalogoActo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDMOTIVOCOBROCATALOGOACTO")
	private Long idMotivoCobroCatalogoActo;

	@ManyToOne(targetEntity = ActoNotarial.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDCATALOGOACTONOTARIAL", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private ActoNotarial idCatalogoActoNotarial;

	@ManyToOne(targetEntity = MotivoCobroActo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDMOTIVOCOBROACTO", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private MotivoCobroActo idMotivoCobroActo;

	@Column(name = "VALORMOTIVOCOBROCATALOGOACTO")
	private Double valorMotivoCobroCatalogoActo;

	@Column(name = "PORCENTAJEMOTIVOCOBROCATALOGOACTO")
	private Double porcentajeMotivoCobroCatalogoActo;

	@Column(name = "ESTADOMOTIVOCOBROCATALOGOACTO")
	private Boolean estadoMotivoCobroCatalogoActo;

	public MotivoCobroCatalogoActo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotivoCobroCatalogoActo(Long idMotivoCobroCatalogoActo, ActoNotarial idCatalogoActoNotarial,
			MotivoCobroActo idMotivoCobroActo, Double valorMotivoCobroCatalogoActo,
			Double porcentaajeMotivoCobroCatalogoActo, Boolean estadomotivoCobroCatalogoActo) {
		super();
		this.idMotivoCobroCatalogoActo = idMotivoCobroCatalogoActo;
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
		this.idMotivoCobroActo = idMotivoCobroActo;
		this.valorMotivoCobroCatalogoActo = valorMotivoCobroCatalogoActo;
		this.porcentajeMotivoCobroCatalogoActo = porcentaajeMotivoCobroCatalogoActo;
		this.estadoMotivoCobroCatalogoActo = estadomotivoCobroCatalogoActo;
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

	public void setPorcentajeMotivoCobroCatalogoActo(Double porcentaajeMotivoCobroCatalogoActo) {
		this.porcentajeMotivoCobroCatalogoActo = porcentaajeMotivoCobroCatalogoActo;
	}

	public Boolean getEstadomotivoCobroCatalogoActo() {
		return estadoMotivoCobroCatalogoActo;
	}

	public void setEstadomotivoCobroCatalogoActo(Boolean estadomotivoCobroCatalogoActo) {
		this.estadoMotivoCobroCatalogoActo = estadomotivoCobroCatalogoActo;
	}

	@Override
	public String toString() {
		return "MotivoCobroCatalogoActo [idMotivoCobroCatalogoActo=" + idMotivoCobroCatalogoActo
				+ ", idCatalogoActoNotarial=" + idCatalogoActoNotarial + ", idMotivoCobroActo=" + idMotivoCobroActo
				+ ", valorMotivoCobroCatalogoActo=" + valorMotivoCobroCatalogoActo
				+ ", porcentaajeMotivoCobroCatalogoActo=" + porcentajeMotivoCobroCatalogoActo
				+ ", estadomotivoCobroCatalogoActo=" + estadoMotivoCobroCatalogoActo + "]";
	}

}
