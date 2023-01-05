package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

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

@Entity(name = "ActoRangoTarifa")
public class ActoRangoTarifa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idActoRangoTarifa")
	private Long idActoRangoTarifa;

	@ManyToOne(targetEntity = RangoTarifa.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idRangoTarifa", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private RangoTarifa idRangoTarifa;

	@ManyToOne(targetEntity = ActoNotarial.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCatalogoActoNotarial", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private ActoNotarial idCatalogoActoNotarial;

	@Column(name = "porcentajeActoRangoTarifa")
	private Double porcentajeActoRangoTarifa;

	@Column(name = "porcentajeParticipacionNotarioActoRangoTarifa")
	private Double porcentajeParticipacionNotarioActoRangoTarifa;

	@Column(name = "porcentajeParticipacionEstadoActoRangoTarifa")
	private Double porcentajeParticipacionEstadoActoRangoTarifa;

	@Column(name = "excedenteActoRangoTarifa")
	private Double excedenteActoRangoTarifa;

	@Column(name = "estadoActoRangoTarifa")
	private Boolean estadoActoRangoTarifa;

	public ActoRangoTarifa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActoRangoTarifa(Long idActoRangoTarifa, RangoTarifa idRangoTarifa, ActoNotarial idCatalogoActoNotarial,
			Double porcentajeActoRangoTarifa, Double porcentajeParticipacionNotarioActoRangoTarifa,
			Double porcentajeParticipacionEstadoActoRangoTarifa, Double excedenteActoRangoTarifa,
			Boolean estadoActoRangoTarifa) {
		super();
		this.idActoRangoTarifa = idActoRangoTarifa;
		this.idRangoTarifa = idRangoTarifa;
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
		this.porcentajeActoRangoTarifa = porcentajeActoRangoTarifa;
		this.porcentajeParticipacionNotarioActoRangoTarifa = porcentajeParticipacionNotarioActoRangoTarifa;
		this.porcentajeParticipacionEstadoActoRangoTarifa = porcentajeParticipacionEstadoActoRangoTarifa;
		this.excedenteActoRangoTarifa = excedenteActoRangoTarifa;
		this.estadoActoRangoTarifa = estadoActoRangoTarifa;
	}

	public Long getIdActoRangoTarifa() {
		return idActoRangoTarifa;
	}

	public void setIdActoRangoTarifa(Long idActoRangoTarifa) {
		this.idActoRangoTarifa = idActoRangoTarifa;
	}

	public RangoTarifa getIdRangoTarifa() {
		return idRangoTarifa;
	}

	public void setIdRangoTarifa(RangoTarifa idRangoTarifa) {
		this.idRangoTarifa = idRangoTarifa;
	}

	public ActoNotarial getIdCatalogoActoNotarial() {
		return idCatalogoActoNotarial;
	}

	public void setIdCatalogoActoNotarial(ActoNotarial idCatalogoActoNotarial) {
		this.idCatalogoActoNotarial = idCatalogoActoNotarial;
	}

	public Double getPorcentajeActoRangoTarifa() {
		return porcentajeActoRangoTarifa;
	}

	public void setPorcentajeActoRangoTarifa(Double porcentajeActoRangoTarifa) {
		this.porcentajeActoRangoTarifa = porcentajeActoRangoTarifa;
	}

	public Double getPorcentajeParticipacionNotarioActoRangoTarifa() {
		return porcentajeParticipacionNotarioActoRangoTarifa;
	}

	public void setPorcentajeParticipacionNotarioActoRangoTarifa(Double porcentajeParticipacionNotarioActoRangoTarifa) {
		this.porcentajeParticipacionNotarioActoRangoTarifa = porcentajeParticipacionNotarioActoRangoTarifa;
	}

	public Double getPorcentajeParticipacionEstadoActoRangoTarifa() {
		return porcentajeParticipacionEstadoActoRangoTarifa;
	}

	public void setPorcentajeParticipacionEstadoActoRangoTarifa(Double porcentajeParticipacionEstadoActoRangoTarifa) {
		this.porcentajeParticipacionEstadoActoRangoTarifa = porcentajeParticipacionEstadoActoRangoTarifa;
	}

	public Double getExcedenteActoRangoTarifa() {
		return excedenteActoRangoTarifa;
	}

	public void setExcedenteActoRangoTarifa(Double excedenteActoRangoTarifa) {
		this.excedenteActoRangoTarifa = excedenteActoRangoTarifa;
	}

	public Boolean getEstadoActoRangoTarifa() {
		return estadoActoRangoTarifa;
	}

	public void setEstadoActoRangoTarifa(Boolean estadoActoRangoTarifa) {
		this.estadoActoRangoTarifa = estadoActoRangoTarifa;
	}

	@Override
	public String toString() {
		return "ActoRangoTarifa [idActoRangoTarifa=" + idActoRangoTarifa + ", idRangoTarifa=" + idRangoTarifa
				+ ", idCatalogoActoNotarial=" + idCatalogoActoNotarial + ", porcentajeActoRangoTarifa="
				+ porcentajeActoRangoTarifa + ", porcentajeParticipacionNotarioActoRangoTarifa="
				+ porcentajeParticipacionNotarioActoRangoTarifa + ", porcentajeParticipacionEstadoActoRangoTarifa="
				+ porcentajeParticipacionEstadoActoRangoTarifa + ", excedenteActoRangoTarifa="
				+ excedenteActoRangoTarifa + ", estadoActoRangoTarifa=" + estadoActoRangoTarifa + "]";
	}

}
