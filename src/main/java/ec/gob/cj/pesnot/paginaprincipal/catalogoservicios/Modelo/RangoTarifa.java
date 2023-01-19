package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RangoTarifa")
public class RangoTarifa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRangoTarifa")
	private Long idRangoTarifa;

	@Column(name = "valorMaximoRangoTarifa")
	private BigDecimal valorMaximoRangoTarifa;

	@Column(name = "valorMinimoRangoTarifa")
	private BigDecimal valorMinimoRangoTarifa;

	@Column(name = "estadoRangoTarifa")
	private Boolean estadoRangoTarifa;
	
	@Column(name = "fechaCreacionRangoTarifa")
	private Date fechaCreacionRangoTarifa;
	
	@Column(name = "fechaModificacionRangoTarifa")
	private Date fechaModificacionRangoTarifa;
	
	@Column(name = "usuarioCreacionRangoTarifa")
	private Long usuarioCreacionRangoTarifa;
	
	@Column(name = "usuarioModificacionRangoTarifa")
	private Long usuarioModificacionRangoTarifa;

	public RangoTarifa() {
		super();
	}

	public Long getIdRangoTarifa() {
		return idRangoTarifa;
	}

	public void setIdRangoTarifa(Long idRangoTarifa) {
		this.idRangoTarifa = idRangoTarifa;
	}

	public BigDecimal getValorMaximoRangoTarifa() {
		return valorMaximoRangoTarifa;
	}

	public void setValorMaximoRangoTarifa(BigDecimal valorMaximoRangoTarifa) {
		this.valorMaximoRangoTarifa = valorMaximoRangoTarifa;
	}

	public BigDecimal getValorMinimoRangoTarifa() {
		return valorMinimoRangoTarifa;
	}

	public void setValorMinimoRangoTarifa(BigDecimal valorMinimoRangoTarifa) {
		this.valorMinimoRangoTarifa = valorMinimoRangoTarifa;
	}

	public Boolean getEstadoRangoTarifa() {
		return estadoRangoTarifa;
	}

	public void setEstadoRangoTarifa(Boolean estadoRangoTarifa) {
		this.estadoRangoTarifa = estadoRangoTarifa;
	}

	public Date getFechaCreacionRangoTarifa() {
		return fechaCreacionRangoTarifa;
	}

	public void setFechaCreacionRangoTarifa(Date fechaCreacionRangoTarifa) {
		this.fechaCreacionRangoTarifa = fechaCreacionRangoTarifa;
	}

	public Date getFechaModificacionRangoTarifa() {
		return fechaModificacionRangoTarifa;
	}

	public void setFechaModificacionRangoTarifa(Date fechaModificacionRangoTarifa) {
		this.fechaModificacionRangoTarifa = fechaModificacionRangoTarifa;
	}

	public Long getUsuarioCreacionRangoTarifa() {
		return usuarioCreacionRangoTarifa;
	}

	public void setUsuarioCreacionRangoTarifa(Long usuarioCreacionRangoTarifa) {
		this.usuarioCreacionRangoTarifa = usuarioCreacionRangoTarifa;
	}

	public Long getUsuarioModificacionRangoTarifa() {
		return usuarioModificacionRangoTarifa;
	}

	public void setUsuarioModificacionRangoTarifa(Long usuarioModificacionRangoTarifa) {
		this.usuarioModificacionRangoTarifa = usuarioModificacionRangoTarifa;
	}

	@Override
	public String toString() {
		return "RangoTarifa [idRangoTarifa=" + idRangoTarifa + ", valorMaximoRangoTarifa=" + valorMaximoRangoTarifa
				+ ", valorMinimoRangoTarifa=" + valorMinimoRangoTarifa + ", estadoRangoTarifa=" + estadoRangoTarifa
				+ ", fechaCreacionRangoTarifa=" + fechaCreacionRangoTarifa + ", fechaModificacionRangoTarifa="
				+ fechaModificacionRangoTarifa + ", usuarioCreacionRangoTarifa=" + usuarioCreacionRangoTarifa
				+ ", usuarioModificacionRangoTarifa=" + usuarioModificacionRangoTarifa + "]";
	}
	
}
