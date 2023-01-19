package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity(name = "TablaTarifaCatalogoActo")
public class TablaTarifaCatalogoActo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTablaTarifaCatalogoActo")
	private Long idTablaTarifaCatalogoActo;

	@ManyToOne(targetEntity = TablaTarifa.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idTablaTarifa", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private TablaTarifa idTablaTarifa;

	@ManyToOne(targetEntity = ActoNotarial.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCatalogoActoNotarial", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private ActoNotarial idCatalogoActoNotarial;

	@Column(name = "fechaCreacionTablaTarifaCatalogoActo")
	private Date fechaCreacionTablaTarifaCatalogoActo;

	@Column(name = "fechaModificacionTablaTarifaCatalogoActo")
	private Date fechaModificacionTablaTarifaCatalogoActo;

	@Column(name = "usuarioCreacionTablaTarifaCatalogoActo")
	private Long usuarioCreacionTablaTarifaCatalogoActo;
	
	@Column(name = "usuarioModificacionTablaTarifaCatalogoActo")
	private Long usuarioModificacionTablaTarifaCatalogoActo;

	@Column(name = "estadoActivo")
	private Boolean estadoActivo;

	public TablaTarifaCatalogoActo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdTablaTarifaCatalogoActo() {
		return idTablaTarifaCatalogoActo;
	}

	public void setIdTablaTarifaCatalogoActo(Long idTablaTarifaCatalogoActo) {
		this.idTablaTarifaCatalogoActo = idTablaTarifaCatalogoActo;
	}

	public TablaTarifa getIdTablaTarifa() {
		return idTablaTarifa;
	}

	public void setIdTablaTarifa(TablaTarifa idTablaTarifa) {
		this.idTablaTarifa = idTablaTarifa;
	}

	public ActoNotarial getIdCatalogoActoNotarial() {
		return idCatalogoActoNotarial;
	}

	public void setIdCatalogoActoNotarial(ActoNotarial idCatalogoActoNotarial) {
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
	}

	public Date getFechaCreacionTablaTarifaCatalogoActo() {
		return fechaCreacionTablaTarifaCatalogoActo;
	}

	public void setFechaCreacionTablaTarifaCatalogoActo(Date fechaCreacionTablaTarifaCatalogoActo) {
		this.fechaCreacionTablaTarifaCatalogoActo = fechaCreacionTablaTarifaCatalogoActo;
	}

	public Date getFechaModificacionTablaTarifaCatalogoActo() {
		return fechaModificacionTablaTarifaCatalogoActo;
	}

	public void setFechaModificacionTablaTarifaCatalogoActo(Date fechaModificacionTablaTarifaCatalogoActo) {
		this.fechaModificacionTablaTarifaCatalogoActo = fechaModificacionTablaTarifaCatalogoActo;
	}

	public Long getUsuarioCreacionTablaTarifaCatalogoActo() {
		return usuarioCreacionTablaTarifaCatalogoActo;
	}

	public void setUsuarioCreacionTablaTarifaCatalogoActo(Long usuarioCreacionTablaTarifaCatalogoActo) {
		this.usuarioCreacionTablaTarifaCatalogoActo = usuarioCreacionTablaTarifaCatalogoActo;
	}

	public Long getUsuarioModificacionTablaTarifaCatalogoActo() {
		return usuarioModificacionTablaTarifaCatalogoActo;
	}

	public void setUsuarioModificacionTablaTarifaCatalogoActo(Long usuarioModificacionTablaTarifaCatalogoActo) {
		this.usuarioModificacionTablaTarifaCatalogoActo = usuarioModificacionTablaTarifaCatalogoActo;
	}

	public Boolean getEstadoActivo() {
		return estadoActivo;
	}

	public void setEstadoActivo(Boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}

	@Override
	public String toString() {
		return "TablaTarifaCatalogoActo [idTablaTarifaCatalogoActo=" + idTablaTarifaCatalogoActo + ", idTablaTarifa="
				+ idTablaTarifa + ", idCatalogoActoNotarial=" + idCatalogoActoNotarial
				+ ", fechaCreacionTablaTarifaCatalogoActo=" + fechaCreacionTablaTarifaCatalogoActo
				+ ", fechaModificacionTablaTarifaCatalogoActo=" + fechaModificacionTablaTarifaCatalogoActo
				+ ", usuarioCreacionTablaTarifaCatalogoActo=" + usuarioCreacionTablaTarifaCatalogoActo
				+ ", usuarioModificacionTablaTarifaCatalogoActo=" + usuarioModificacionTablaTarifaCatalogoActo
				+ ", estadoActivo=" + estadoActivo + "]";
	}
	
	
}
