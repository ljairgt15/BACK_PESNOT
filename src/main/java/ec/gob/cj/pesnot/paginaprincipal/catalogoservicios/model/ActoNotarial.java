package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "CatalogoActoNotarial")
public class ActoNotarial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCatalogoActoNotarial")
	private Long idCatalogoActoNotarial;
	
	@ManyToOne(targetEntity = Libro.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoLibro",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private Libro idTipoLibro;
	
	@ManyToOne(targetEntity = BaseCobroActo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idBaseCobroActo",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private BaseCobroActo idBaseCobroActo;

	@Column(name = "idTasaImpuesto")
	private Long idTasaImpuesto;
	
	@Column(name = "nombreCatalogoActoNotarial")
	private String nombreCatalogoActoNotarial;

	@Column(name = "articuloCatalogoActoNotarial")
	private String articuloCatalogoActoNotarial;
	
	@Column(name="tarifaCatalogoActoNotarial")
	private Double tarifaCatalogoActoNotarial;
	
	@Column(name = "gravaIVACatalogoActoNotarial")
	private Boolean gravaIvaCatalogoActoNotarial;
	
	@Column(name = "valorExoneracionCatalogoActoNotarial") 	
	private BigDecimal valorExoneracionCatalogoActoNotarial;
	
	@Column(name = "valorExtraCatalogoActoNotarial") 	
	private BigDecimal valorExtraCatalogoActoNotarial;

	@Column(name = "habilitableCiudadanoCatalogoActoNotarial")
	private Boolean habilitanteCiudadanoCatalogoActoNotarial;
	
	@Column(name = "tramiteUnilateralCatalogoActoNotarial")
	private Boolean tramiteUnilateralCatalogoActoNotarial;
	
	@Column(name = "tramiteBilateralCatalogoActoNotarial")
	private Boolean tramiteBilateralCatalogoActoNotarial;
	
	@Column(name="usaCalculoTablaCatalogoActoNotarial")
	private Boolean usaCalculoTablaCatalogoActoNotarial;
	
	@Column(name = "estadoCatalogoActoNotarial")
	private Boolean estadoCatalogoActoNotarial;
	
	@Column(name="fechaCreacionCatalogoActoNotarial")
	private Date fechaCreacionCatalogoActoNotarial;
	
	@Column(name="fechaModificacionCatalogoActoNotarial")
	private Date fechaModificacionCatalogoActoNotarial;
	
	@Column(name = "usuarioCreacionCatalogoActoNotarial")
	private Long usuarioCreacionCatalogoActoNotarial;
	
	@Column(name = "usuarioModificacionCatalogoActoNotarial")
	private Long usuarioModificacionCatalogoActoNotarial;
	
		
	
	public ActoNotarial() {
		super();
	}



	public Long getIdCatalogoActoNotarial() {
		return idCatalogoActoNotarial;
	}



	public void setIdCatalogoActoNotarial(Long idCatalogoActoNotarial) {
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
	}



	public Libro getIdTipoLibro() {
		return idTipoLibro;
	}



	public void setIdTipoLibro(Libro idTipoLibro) {
		this.idTipoLibro = idTipoLibro;
	}



	public BaseCobroActo getIdBaseCobroActo() {
		return idBaseCobroActo;
	}



	public void setIdBaseCobroActo(BaseCobroActo idBaseCobroActo) {
		this.idBaseCobroActo = idBaseCobroActo;
	}



	public Long getIdTasaImpuesto() {
		return idTasaImpuesto;
	}



	public void setIdTasaImpuesto(Long idTasaImpuesto) {
		this.idTasaImpuesto = idTasaImpuesto;
	}



	public String getNombreCatalogoActoNotarial() {
		return nombreCatalogoActoNotarial;
	}



	public void setNombreCatalogoActoNotarial(String nombreCatalogoActoNotarial) {
		this.nombreCatalogoActoNotarial = nombreCatalogoActoNotarial;
	}



	public String getArticuloCatalogoActoNotarial() {
		return articuloCatalogoActoNotarial;
	}



	public void setArticuloCatalogoActoNotarial(String articuloCatalogoActoNotarial) {
		this.articuloCatalogoActoNotarial = articuloCatalogoActoNotarial;
	}



	public Double getTarifaCatalogoActoNotarial() {
		return tarifaCatalogoActoNotarial;
	}



	public void setTarifaCatalogoActoNotarial(Double tarifaCatalogoActoNotarial) {
		this.tarifaCatalogoActoNotarial = tarifaCatalogoActoNotarial;
	}



	public Boolean getGravaIvaCatalogoActoNotarial() {
		return gravaIvaCatalogoActoNotarial;
	}



	public void setGravaIvaCatalogoActoNotarial(Boolean gravaIvaCatalogoActoNotarial) {
		this.gravaIvaCatalogoActoNotarial = gravaIvaCatalogoActoNotarial;
	}



	public BigDecimal getValorExoneracionCatalogoActoNotarial() {
		return valorExoneracionCatalogoActoNotarial;
	}



	public void setValorExoneracionCatalogoActoNotarial(BigDecimal valorExoneracionCatalogoActoNotarial) {
		this.valorExoneracionCatalogoActoNotarial = valorExoneracionCatalogoActoNotarial;
	}



	public BigDecimal getValorExtraCatalogoActoNotarial() {
		return valorExtraCatalogoActoNotarial;
	}



	public void setValorExtraCatalogoActoNotarial(BigDecimal valorExtraCatalogoActoNotarial) {
		this.valorExtraCatalogoActoNotarial = valorExtraCatalogoActoNotarial;
	}



	public Boolean getHabilitanteCiudadanoCatalogoActoNotarial() {
		return habilitanteCiudadanoCatalogoActoNotarial;
	}



	public void setHabilitanteCiudadanoCatalogoActoNotarial(Boolean habilitanteCiudadanoCatalogoActoNotarial) {
		this.habilitanteCiudadanoCatalogoActoNotarial = habilitanteCiudadanoCatalogoActoNotarial;
	}



	public Boolean getTramiteUnilateralCatalogoActoNotarial() {
		return tramiteUnilateralCatalogoActoNotarial;
	}



	public void setTramiteUnilateralCatalogoActoNotarial(Boolean tramiteUnilateralCatalogoActoNotarial) {
		this.tramiteUnilateralCatalogoActoNotarial = tramiteUnilateralCatalogoActoNotarial;
	}



	public Boolean getTramiteBilateralCatalogoActoNotarial() {
		return tramiteBilateralCatalogoActoNotarial;
	}



	public void setTramiteBilateralCatalogoActoNotarial(Boolean tramiteBilateralCatalogoActoNotarial) {
		this.tramiteBilateralCatalogoActoNotarial = tramiteBilateralCatalogoActoNotarial;
	}



	public Boolean getUsaCalculoTablaCatalogoActoNotarial() {
		return usaCalculoTablaCatalogoActoNotarial;
	}



	public void setUsaCalculoTablaCatalogoActoNotarial(Boolean usaCalculoTablaCatalogoActoNotarial) {
		this.usaCalculoTablaCatalogoActoNotarial = usaCalculoTablaCatalogoActoNotarial;
	}



	public Boolean getEstadoCatalogoActoNotarial() {
		return estadoCatalogoActoNotarial;
	}



	public void setEstadoCatalogoActoNotarial(Boolean estadoCatalogoActoNotarial) {
		this.estadoCatalogoActoNotarial = estadoCatalogoActoNotarial;
	}



	public Date getFechaCreacionCatalogoActoNotarial() {
		return fechaCreacionCatalogoActoNotarial;
	}



	public void setFechaCreacionCatalogoActoNotarial(Date fechaCreacionCatalogoActoNotarial) {
		this.fechaCreacionCatalogoActoNotarial = fechaCreacionCatalogoActoNotarial;
	}



	public Date getFechaModificacionCatalogoActoNotarial() {
		return fechaModificacionCatalogoActoNotarial;
	}



	public void setFechaModificacionCatalogoActoNotarial(Date fechaModificacionCatalogoActoNotarial) {
		this.fechaModificacionCatalogoActoNotarial = fechaModificacionCatalogoActoNotarial;
	}



	public Long getUsuarioCreacionCatalogoActoNotarial() {
		return usuarioCreacionCatalogoActoNotarial;
	}



	public void setUsuarioCreacionCatalogoActoNotarial(Long usuarioCreacionCatalogoActoNotarial) {
		this.usuarioCreacionCatalogoActoNotarial = usuarioCreacionCatalogoActoNotarial;
	}



	public Long getUsuarioModificacionCatalogoActoNotarial() {
		return usuarioModificacionCatalogoActoNotarial;
	}



	public void setUsuarioModificacionCatalogoActoNotarial(Long usuarioModificacionCatalogoActoNotarial) {
		this.usuarioModificacionCatalogoActoNotarial = usuarioModificacionCatalogoActoNotarial;
	}



	@Override
	public String toString() {
		return "ActoNotarial [idCatalogoActoNotarial=" + idCatalogoActoNotarial + ", idTipoLibro=" + idTipoLibro
				+ ", idBaseCobroActo=" + idBaseCobroActo + ", idTasaImpuesto=" + idTasaImpuesto
				+ ", nombreCatalogoActoNotarial=" + nombreCatalogoActoNotarial + ", articuloCatalogoActoNotarial="
				+ articuloCatalogoActoNotarial + ", tarifaCatalogoActoNotarial=" + tarifaCatalogoActoNotarial
				+ ", gravaIvaCatalogoActoNotarial=" + gravaIvaCatalogoActoNotarial
				+ ", valorExoneracionCatalogoActoNotarial=" + valorExoneracionCatalogoActoNotarial
				+ ", valorExtraCatalogoActoNotarial=" + valorExtraCatalogoActoNotarial
				+ ", habilitanteCiudadanoCatalogoActoNotarial=" + habilitanteCiudadanoCatalogoActoNotarial
				+ ", tramiteUnilateralCatalogoActoNotarial=" + tramiteUnilateralCatalogoActoNotarial
				+ ", tramiteBilateralCatalogoActoNotarial=" + tramiteBilateralCatalogoActoNotarial
				+ ", usaCalculoTablaCatalogoActoNotarial=" + usaCalculoTablaCatalogoActoNotarial
				+ ", estadoCatalogoActoNotarial=" + estadoCatalogoActoNotarial + ", fechaCreacionCatalogoActoNotarial="
				+ fechaCreacionCatalogoActoNotarial + ", fechaModificacionCatalogoActoNotarial="
				+ fechaModificacionCatalogoActoNotarial + ", usuarioCreacionCatalogoActoNotarial="
				+ usuarioCreacionCatalogoActoNotarial + ", usuarioModificacionCatalogoActoNotarial="
				+ usuarioModificacionCatalogoActoNotarial + "]";
	}
	
	

	
	
	
	
}
