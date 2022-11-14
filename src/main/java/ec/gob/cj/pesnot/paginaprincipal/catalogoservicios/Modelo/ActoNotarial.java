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
@Table(name = "CATALOGOACTONOTARIAL")
public class ActoNotarial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDCATALOGOACTONOTARIAL")
	private Long idCatalogoActoNotarial;
	
	@ManyToOne(targetEntity = BaseCobroActo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDBASECOBROACTO",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private BaseCobroActo idBaseCobroActo;

	@ManyToOne(targetEntity = Libro.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDTIPOLIBRO",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private Libro idTipoLibro;
	
	@Column(name = "NOMBRECATALOGOACTONOTARIAL")
	private String nombreCatalogoActoNotarial;

	@Column(name = "ARTICULOCATALOGOACTONOTARIAL")
	private String articuloCatalogoActoNotarial;
	
	@Column(name = "GRAVAIVACATALOGOACTONOTARIAL")
	private Boolean gravaIvaCatalogoActoNotarial;
	
	@Column(name = "VALOREXONERACIONCATALOGOACTONOTARIAL") 	
	private Long valorExoneracionCatalogoActoNotarial;
	
	@Column(name = "VALOREXTRACATALOGOACTONOTARIAL") 	
	private Long valorExtraCatalogoActoNotarial;

	@Column(name = "HABILITANTECIUDADANOCATALOGOACTONOTARIAL")
	private Boolean habilitanteCiudadanoCatalogoActoNotarial;
	
	@Column(name = "TRAMITEUNILATERALCATALOGOACTONOTARIAL")
	private Boolean tramiteUnilateralCatalogoActoNotarial;

	@Column(name = "ESTADOCATALAGOACTONOTARIAL")
	private Boolean estadoCatalogoActoNotarial;
	
	@Column(name="TARIFACATALOGOACTONOTARIAL")
	private Long tarifaCatalogoActoNotarial;
	
	@Column(name="USACALCULOTABLACATALOGOACTONOTARIAL")
	private Boolean usaCalculoTablaCatalogoActoNotarial;
	

	
	
	public ActoNotarial() {
		super();
	}
	
	



	public ActoNotarial(Long idCatalogoActoNotarial, BaseCobroActo idBaseCobroActo, Libro idTipoLibro,
			String nombreCatalogoActoNotarial, String articuloCatalogoActoNotarial,
			Boolean gravaIvaCatalogoActoNotarial, Long valorExoneracionCatalogoActoNotarial,
			Long valorExtraCatalogoActoNotarial, Boolean habilitanteCiudadanoCatalogoActoNotarial,
			Boolean tramiteUnilateralCatalogoActoNotarial, Boolean estadoCatalogoActoNotarial,
			Long tarifaCatalogoActoNotarial, Boolean usaCalculoTablaCatalogoActoNotarial) {
		super();
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
		this.idBaseCobroActo = idBaseCobroActo;
		this.idTipoLibro = idTipoLibro;
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




	public Long getValorExoneracionCatalogoActoNotarial() {
		return valorExoneracionCatalogoActoNotarial;
	}




	public void setValorExoneracionCatalogoActoNotarial(Long valorExoneracionCatalogoActoNotarial) {
		this.valorExoneracionCatalogoActoNotarial = valorExoneracionCatalogoActoNotarial;
	}




	public Long getValorExtraCatalogoActoNotarial() {
		return valorExtraCatalogoActoNotarial;
	}




	public void setValorExtraCatalogoActoNotarial(Long valorExtraCatalogoActoNotarial) {
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




	public Long getTarifaCatalogoActoNotarial() {
		return tarifaCatalogoActoNotarial;
	}




	public void setTarifaCatalogoActoNotarial(Long tarifaCatalogoActoNotarial) {
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
				+ ", idTipoLibro=" + idTipoLibro + ", nombreCatalogoActoNotarial=" + nombreCatalogoActoNotarial
				+ ", articuloCatalogoActoNotarial=" + articuloCatalogoActoNotarial + ", gravaIvaCatalogoActoNotarial="
				+ gravaIvaCatalogoActoNotarial + ", valorExoneracionCatalogoActoNotarial="
				+ valorExoneracionCatalogoActoNotarial + ", valorExtraCatalogoActoNotarial="
				+ valorExtraCatalogoActoNotarial + ", habilitanteCiudadanoCatalogoActoNotarial="
				+ habilitanteCiudadanoCatalogoActoNotarial + ", tramiteUnilateralCatalogoActoNotarial="
				+ tramiteUnilateralCatalogoActoNotarial + ", estadoCatalogoActoNotarial=" + estadoCatalogoActoNotarial
				+ ", tarifaCatalogoActoNotarial=" + tarifaCatalogoActoNotarial
				+ ", usaCalculoTablaCatalogoActoNotarial=" + usaCalculoTablaCatalogoActoNotarial + "]";
	}
	
	

	
}
