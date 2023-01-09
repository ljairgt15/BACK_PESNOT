package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.math.BigDecimal;

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
	
	@ManyToOne(targetEntity = BaseCobroActo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idBaseCobroActo",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private BaseCobroActo idBaseCobroActo;

	@ManyToOne(targetEntity = Libro.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoLibro",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private Libro idTipoLibro;
	
	@ManyToOne(targetEntity = ClasificacionNumeroIntervinienteActo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idClasificacionNumeroIntervienteActo",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private ClasificacionNumeroIntervinienteActo idClasificacionNumeroInterveniente;
	
	@Column(name = "idTasaImpuesto")
	private Long idTasaImpuesto;
	
	@Column(name = "nombreCatalogoActoNotarial")
	private String nombreCatalogoActoNotarial;

	@Column(name = "articuloCatalogoActoNotarial")
	private String articuloCatalogoActoNotarial;
	
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

	@Column(name = "estadoCatalogoActoNotarial")
	private Boolean estadoCatalogoActoNotarial;
	
	@Column(name="tarifaCatalogoActoNotarial")
	private Double tarifaCatalogoActoNotarial;
	
	@Column(name="usaCalculoTablaCatalogoActoNotarial")
	private Boolean usaCalculoTablaCatalogoActoNotarial;
	
	
	

	
	
	public ActoNotarial() {
		super();
	}


	public ActoNotarial(Long idCatalogoActoNotarial, BaseCobroActo idBaseCobroActo, Libro idTipoLibro,
			ClasificacionNumeroIntervinienteActo idClasificacionNumeroInterveniente, String nombreCatalogoActoNotarial,
			Long idTasaImpuesto,
			String articuloCatalogoActoNotarial, Boolean gravaIvaCatalogoActoNotarial,
			BigDecimal valorExoneracionCatalogoActoNotarial, BigDecimal valorExtraCatalogoActoNotarial,
			Boolean habilitanteCiudadanoCatalogoActoNotarial, Boolean tramiteUnilateralCatalogoActoNotarial,
			Boolean estadoCatalogoActoNotarial, Double tarifaCatalogoActoNotarial,
			Boolean usaCalculoTablaCatalogoActoNotarial) {
		super();
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
		this.idBaseCobroActo = idBaseCobroActo;
		this.idTipoLibro = idTipoLibro;
		this.idClasificacionNumeroInterveniente = idClasificacionNumeroInterveniente;
		this.idTasaImpuesto=idTasaImpuesto;
		this.nombreCatalogoActoNotarial = nombreCatalogoActoNotarial;
		this.articuloCatalogoActoNotarial = articuloCatalogoActoNotarial;
		this.gravaIvaCatalogoActoNotarial = gravaIvaCatalogoActoNotarial;
		this.valorExoneracionCatalogoActoNotarial = valorExoneracionCatalogoActoNotarial;
		this.valorExtraCatalogoActoNotarial = valorExtraCatalogoActoNotarial;
		this.habilitanteCiudadanoCatalogoActoNotarial = habilitanteCiudadanoCatalogoActoNotarial;
		this.tramiteUnilateralCatalogoActoNotarial = tramiteUnilateralCatalogoActoNotarial;
		this.estadoCatalogoActoNotarial = estadoCatalogoActoNotarial;
		this.tarifaCatalogoActoNotarial = tarifaCatalogoActoNotarial;
		this.usaCalculoTablaCatalogoActoNotarial = usaCalculoTablaCatalogoActoNotarial;
	}


	public Long getIdCatalogoActoNotarial() {
		return idCatalogoActoNotarial;
	}


	public void setIdCatalogoActoNotarial(Long idCatalogoActoNotarial) {
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
	}


	public BaseCobroActo getIdBaseCobroActo() {
		return idBaseCobroActo;
	}


	public void setIdBaseCobroActo(BaseCobroActo idBaseCobroActo) {
		this.idBaseCobroActo = idBaseCobroActo;
	}


	public Libro getIdTipoLibro() {
		return idTipoLibro;
	}


	public void setIdTipoLibro(Libro idTipoLibro) {
		this.idTipoLibro = idTipoLibro;
	}


	public ClasificacionNumeroIntervinienteActo getIdClasificacionNumeroInterveniente() {
		return idClasificacionNumeroInterveniente;
	}


	public void setIdClasificacionNumeroInterveniente(
			ClasificacionNumeroIntervinienteActo idClasificacionNumeroInterveniente) {
		this.idClasificacionNumeroInterveniente = idClasificacionNumeroInterveniente;
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


	public Boolean getEstadoCatalogoActoNotarial() {
		return estadoCatalogoActoNotarial;
	}


	public void setEstadoCatalogoActoNotarial(Boolean estadoCatalogoActoNotarial) {
		this.estadoCatalogoActoNotarial = estadoCatalogoActoNotarial;
	}


	public Double getTarifaCatalogoActoNotarial() {
		return tarifaCatalogoActoNotarial;
	}


	public void setTarifaCatalogoActoNotarial(Double tarifaCatalogoActoNotarial) {
		this.tarifaCatalogoActoNotarial = tarifaCatalogoActoNotarial;
	}


	public Boolean getUsaCalculoTablaCatalogoActoNotarial() {
		return usaCalculoTablaCatalogoActoNotarial;
	}


	public void setUsaCalculoTablaCatalogoActoNotarial(Boolean usaCalculoTablaCatalogoActoNotarial) {
		this.usaCalculoTablaCatalogoActoNotarial = usaCalculoTablaCatalogoActoNotarial;
	}


	@Override
	public String toString() {
		return "ActoNotarial [idCatalogoActoNotarial=" + idCatalogoActoNotarial + ", idBaseCobroActo=" + idBaseCobroActo
				+ ", idTipoLibro=" + idTipoLibro + ", idClasificacionNumeroInterveniente="
				+ idClasificacionNumeroInterveniente + ", idTasaImpuesto=" + idTasaImpuesto
				+ ", nombreCatalogoActoNotarial=" + nombreCatalogoActoNotarial + ", articuloCatalogoActoNotarial="
				+ articuloCatalogoActoNotarial + ", gravaIvaCatalogoActoNotarial=" + gravaIvaCatalogoActoNotarial
				+ ", valorExoneracionCatalogoActoNotarial=" + valorExoneracionCatalogoActoNotarial
				+ ", valorExtraCatalogoActoNotarial=" + valorExtraCatalogoActoNotarial
				+ ", habilitanteCiudadanoCatalogoActoNotarial=" + habilitanteCiudadanoCatalogoActoNotarial
				+ ", tramiteUnilateralCatalogoActoNotarial=" + tramiteUnilateralCatalogoActoNotarial
				+ ", estadoCatalogoActoNotarial=" + estadoCatalogoActoNotarial + ", tarifaCatalogoActoNotarial="
				+ tarifaCatalogoActoNotarial + ", usaCalculoTablaCatalogoActoNotarial="
				+ usaCalculoTablaCatalogoActoNotarial + "]";
	}
	
	
	
	
}
