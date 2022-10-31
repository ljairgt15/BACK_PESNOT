package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name="IDACTONOTARIAL")
	private Long id;
	
	//TODO Forein key de base cobro 
	@Column(name = "IDBASECOBRO")
	private Long baseCobro;

	@ManyToOne(targetEntity = Libro.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDTIPOLIBRO",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private Libro libroActoNotarial;
	
	@Column(name = "NOMBRECATALOGOACTONOTARIAL")
	private String nombreActoNotarial;

	@Column(name = "ARTICULOCATALOGOACTONOTARIAL")
	private String articuloActoNotarial;
	
	@Column(name = "GRAVALIVACATALOGOACTONOTARIAL")
	private Boolean grabalIva;
	
	@Column(name = "VALOREXONERACIONCATALOGOACTONOTARIAL") 	
	private Long valorExoneracion;
	
	@Column(name = "VALOREXTRACATALOGOACTONOTARIAL") 	
	private Long valorExtra;

	@Column(name = "HABILITANTECIUDADANOACTONOTARIAL")
	private Boolean habilitanteCiudadano;
	
	@Column(name = "TRAMITEUNILATERALACTONOTARIAL")
	private Boolean tramiteUnilateralCiudadano;

	@Column(name = "ESTADOACTONOTARIAL")
	private Boolean estado;

	
	
	public ActoNotarial() {
		super();
	}
	
	public ActoNotarial(Long id, Long baseCobro, Libro libroActoNotarial, String nombreActoNotarial,
			String articuloActoNotarial, Boolean grabalIva, Long valorExoneracion, Long valorExtra,
			Boolean habilitanteCiudadano, Boolean tramiteUnilateralCiudadano, Boolean estado) {
		super();
		this.id = id;
		this.baseCobro = baseCobro;
		this.libroActoNotarial = libroActoNotarial;
		this.nombreActoNotarial = nombreActoNotarial;
		this.articuloActoNotarial = articuloActoNotarial;
		this.grabalIva = grabalIva;
		this.valorExoneracion = valorExoneracion;
		this.valorExtra = valorExtra;
		this.habilitanteCiudadano = habilitanteCiudadano;
		this.tramiteUnilateralCiudadano = tramiteUnilateralCiudadano;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBaseCobro() {
		return baseCobro;
	}

	public void setBaseCobro(Long baseCobro) {
		this.baseCobro = baseCobro;
	}

	public Libro getLibroActoNotarial() {
		return libroActoNotarial;
	}

	public void setLibroActoNotarial(Libro libroActoNotarial) {
		this.libroActoNotarial = libroActoNotarial;
	}

	public String getNombreActoNotarial() {
		return nombreActoNotarial;
	}

	public void setNombreActoNotarial(String nombreActoNotarial) {
		this.nombreActoNotarial = nombreActoNotarial;
	}

	public String getArticuloActoNotarial() {
		return articuloActoNotarial;
	}

	public void setArticuloActoNotarial(String articuloActoNotarial) {
		this.articuloActoNotarial = articuloActoNotarial;
	}

	public Boolean getGrabalIva() {
		return grabalIva;
	}

	public void setGrabalIva(Boolean grabalIva) {
		this.grabalIva = grabalIva;
	}

	public Long getValorExoneracion() {
		return valorExoneracion;
	}

	public void setValorExoneracion(Long valorExoneracion) {
		this.valorExoneracion = valorExoneracion;
	}

	public Long getValorExtra() {
		return valorExtra;
	}

	public void setValorExtra(Long valorExtra) {
		this.valorExtra = valorExtra;
	}

	public Boolean getHabilitanteCiudadano() {
		return habilitanteCiudadano;
	}

	public void setHabilitanteCiudadano(Boolean habilitanteCiudadano) {
		this.habilitanteCiudadano = habilitanteCiudadano;
	}

	public Boolean getTramiteUnilateralCiudadano() {
		return tramiteUnilateralCiudadano;
	}

	public void setTramiteUnilateralCiudadano(Boolean tramiteUnilateralCiudadano) {
		this.tramiteUnilateralCiudadano = tramiteUnilateralCiudadano;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ActoNotarial [id=" + id + ", baseCobro=" + baseCobro + ", libroActoNotarial=" + libroActoNotarial
				+ ", nombreActoNotarial=" + nombreActoNotarial + ", articuloActoNotarial=" + articuloActoNotarial
				+ ", grabalIva=" + grabalIva + ", valorExoneracion=" + valorExoneracion + ", valorExtra=" + valorExtra
				+ ", habilitanteCiudadano=" + habilitanteCiudadano + ", tramiteUnilateralCiudadano="
				+ tramiteUnilateralCiudadano + ", estado=" + estado + "]";
	}	
	

}
