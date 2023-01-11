package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.math.BigDecimal;

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

	public RangoTarifa() {
		super();
	}

	public RangoTarifa(Long idRangoTarifa, BigDecimal valorMaximoRangoTarifa, BigDecimal valorMinimoRangoTarifa,
			Boolean estadoRangoTarifa) {
		super();
		this.idRangoTarifa = idRangoTarifa;
		this.valorMaximoRangoTarifa = valorMaximoRangoTarifa;
		this.valorMinimoRangoTarifa = valorMinimoRangoTarifa;
		this.estadoRangoTarifa = estadoRangoTarifa;
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

	@Override
	public String toString() {
		return "RangoTarifa [idRangoTarifa=" + idRangoTarifa + ", valorMaximoRangoTarifa=" + valorMaximoRangoTarifa
				+ ", valorMinimoRangoTarifa=" + valorMinimoRangoTarifa + ", estadoRangoTarifa=" + estadoRangoTarifa
				+ "]";
	}
}
