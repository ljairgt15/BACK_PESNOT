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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "TablaTarifaRango")
public class TablaTarifaRango {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTablaTarifaRango")
	private Long idTablaTarifaRango;
	
	@ManyToOne(targetEntity = RangoTarifa.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idRangoTarifa", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private RangoTarifa idRangoTarifa;
	
	@ManyToOne(targetEntity = TablaTarifa.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idTablaTarifa", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private TablaTarifa idTablaTarifa;
	
	@Column(name = "porcentajeTablaTarifaRango")
	private Double porcentajeTablaTarifaRango;

	@Column(name = "porcentajeParticipacionNotarioTablaTarifaRango")
	private Double porcentajeParticipacionNotarioTablaTarifaRango;

	@Column(name = "porcentajeParticipacionEstadoTablaTarifaRango")
	private Double porcentajeParticipacionEstadoTablaTarifaRango;

	@Column(name = "excedenteTablaTarifaRango")
	private Double excedenteTablaTarifaRango;


	@Column(name = "fechaCreacionTablaTarifaRango")
	private Date fechaCreacionTablaTarifa;

	@Column(name = "fechaModificacionTablaTarifaRango")
	private Date porcentajeParticipacionEstadoActoRangoTarifa;

	@Column(name = "usuarioCreacionTablaTarifaRango")
	private Long usuarioCreacionTablaTarifa;
	
	@Column(name = "usuarioModificacionTablaTarifaRango")
	private Long usuarioModificacionTablaTarifa;

	@Column(name = "estadoTablaTarifaRango")
	private Boolean estadoTablaTarifaRango;

	public TablaTarifaRango() {
		super();
	}

	public Long getIdTablaTarifaRango() {
		return idTablaTarifaRango;
	}

	public void setIdTablaTarifaRango(Long idTablaTarifaRango) {
		this.idTablaTarifaRango = idTablaTarifaRango;
	}

	public RangoTarifa getIdRangoTarifa() {
		return idRangoTarifa;
	}

	public void setIdRangoTarifa(RangoTarifa idRangoTarifa) {
		this.idRangoTarifa = idRangoTarifa;
	}

	public TablaTarifa getIdTablaTarifa() {
		return idTablaTarifa;
	}

	public void setIdTablaTarifa(TablaTarifa idTablaTarifa) {
		this.idTablaTarifa = idTablaTarifa;
	}

	public Double getPorcentajeTablaTarifaRango() {
		return porcentajeTablaTarifaRango;
	}

	public void setPorcentajeTablaTarifaRango(Double porcentajeTablaTarifaRango) {
		this.porcentajeTablaTarifaRango = porcentajeTablaTarifaRango;
	}

	public Double getPorcentajeParticipacionNotarioTablaTarifaRango() {
		return porcentajeParticipacionNotarioTablaTarifaRango;
	}

	public void setPorcentajeParticipacionNotarioTablaTarifaRango(Double porcentajeParticipacionNotarioTablaTarifaRango) {
		this.porcentajeParticipacionNotarioTablaTarifaRango = porcentajeParticipacionNotarioTablaTarifaRango;
	}

	public Double getPorcentajeParticipacionEstadoTablaTarifaRango() {
		return porcentajeParticipacionEstadoTablaTarifaRango;
	}

	public void setPorcentajeParticipacionEstadoTablaTarifaRango(Double porcentajeParticipacionEstadoTablaTarifaRango) {
		this.porcentajeParticipacionEstadoTablaTarifaRango = porcentajeParticipacionEstadoTablaTarifaRango;
	}

	public Double getExcedenteTablaTarifaRango() {
		return excedenteTablaTarifaRango;
	}

	public void setExcedenteTablaTarifaRango(Double excedenteTablaTarifaRango) {
		this.excedenteTablaTarifaRango = excedenteTablaTarifaRango;
	}

	public Date getFechaCreacionTablaTarifa() {
		return fechaCreacionTablaTarifa;
	}

	public void setFechaCreacionTablaTarifa(Date fechaCreacionTablaTarifa) {
		this.fechaCreacionTablaTarifa = fechaCreacionTablaTarifa;
	}

	public Date getPorcentajeParticipacionEstadoActoRangoTarifa() {
		return porcentajeParticipacionEstadoActoRangoTarifa;
	}

	public void setPorcentajeParticipacionEstadoActoRangoTarifa(Date porcentajeParticipacionEstadoActoRangoTarifa) {
		this.porcentajeParticipacionEstadoActoRangoTarifa = porcentajeParticipacionEstadoActoRangoTarifa;
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

	public Boolean getEstadoTablaTarifaRango() {
		return estadoTablaTarifaRango;
	}

	public void setEstadoTablaTarifaRango(Boolean estadoTablaTarifaRango) {
		this.estadoTablaTarifaRango = estadoTablaTarifaRango;
	}

	@Override
	public String toString() {
		return "TablaTarifaRango [idTablaTarifaRango=" + idTablaTarifaRango + ", idRangoTarifa=" + idRangoTarifa
				+ ", idTablaTarifa=" + idTablaTarifa + ", porcentajeTablaTarifaRango=" + porcentajeTablaTarifaRango
				+ ", porcentajeParticipacionNotarioTablaTarifaRango=" + porcentajeParticipacionNotarioTablaTarifaRango
				+ ", porcentajeParticipacionEstadoTablaTarifaRango=" + porcentajeParticipacionEstadoTablaTarifaRango
				+ ", excedenteTablaTarifaRango=" + excedenteTablaTarifaRango + ", fechaCreacionTablaTarifa="
				+ fechaCreacionTablaTarifa + ", porcentajeParticipacionEstadoActoRangoTarifa="
				+ porcentajeParticipacionEstadoActoRangoTarifa + ", usuarioCreacionTablaTarifa="
				+ usuarioCreacionTablaTarifa + ", usuarioModificacionTablaTarifa=" + usuarioModificacionTablaTarifa
				+ ", estadoTablaTarifaRango=" + estadoTablaTarifaRango + "]";
	}

}
