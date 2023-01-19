package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TablaTarifa")
public class TablaTarifa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTablaTarifa")
	private Long idTablaTarifa;

	@Column(name = "nombreTablaTarifa")
	private String nombreTablaTarifa;

	@Column(name = "fechaCreacionTablaTarifa")
	private Date fechaCreacionTablaTarifa;

	@Column(name = "fechaModificacionTablaTarifa")
	private Date fechaModificacionTablaTarifa;

	@Column(name = "usuarioCreacionTablaTarifa")
	private Long usuarioCreacionTablaTarifa;
	
	@Column(name = "usuarioModificacionTablaTarifa")
	private Long usuarioModificacionTablaTarifa;

	@Column(name = "estadoActivo")
	private Boolean estadoActivo;

	public TablaTarifa() {
		super();
	}

	public Long getIdTablaTarifa() {
		return idTablaTarifa;
	}

	public void setIdTablaTarifa(Long idTablaTarifa) {
		this.idTablaTarifa = idTablaTarifa;
	}

	public String getNombreTablaTarifa() {
		return nombreTablaTarifa;
	}

	public void setNombreTablaTarifa(String nombreTablaTarifa) {
		this.nombreTablaTarifa = nombreTablaTarifa;
	}

	public Date getFechaCreacionTablaTarifa() {
		return fechaCreacionTablaTarifa;
	}

	public void setFechaCreacionTablaTarifa(Date fechaCreacionTablaTarifa) {
		this.fechaCreacionTablaTarifa = fechaCreacionTablaTarifa;
	}

	public Date getFechaModificacionTablaTarifa() {
		return fechaModificacionTablaTarifa;
	}

	public void setFechaModificacionTablaTarifa(Date porcentajeParticipacionEstadoActoRangoTarifa) {
		this.fechaModificacionTablaTarifa = porcentajeParticipacionEstadoActoRangoTarifa;
	}

	public Long getUsuarioCreacionTablaTarifa() {
		return usuarioCreacionTablaTarifa;
	}

	public void setUsuarioCreacionTablaTarifa(Long usuarioCreacionTablaTarifa) {
		this.usuarioCreacionTablaTarifa = usuarioCreacionTablaTarifa;
	}

	public Long getUsuarioModificacionTablaTarifa() {
		return usuarioModificacionTablaTarifa;
	}

	public void setUsuarioModificacionTablaTarifa(Long usuarioModificacionTablaTarifa) {
		this.usuarioModificacionTablaTarifa = usuarioModificacionTablaTarifa;
	}

	public Boolean getEstadoActivo() {
		return estadoActivo;
	}

	public void setEstadoActivo(Boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}

	@Override
	public String toString() {
		return "TablaTarifa [idTablaTarifa=" + idTablaTarifa + ", nombreTablaTarifa=" + nombreTablaTarifa
				+ ", fechaCreacionTablaTarifa=" + fechaCreacionTablaTarifa
				+ ", porcentajeParticipacionEstadoActoRangoTarifa=" + fechaModificacionTablaTarifa
				+ ", usuarioCreacionTablaTarifa=" + usuarioCreacionTablaTarifa + ", usuarioModificacionTablaTarifa="
				+ usuarioModificacionTablaTarifa + ", estadoActivo=" + estadoActivo + "]";
	}
	
	

}
