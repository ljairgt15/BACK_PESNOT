package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RANGOTARIFA")
public class RangoTarifa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDRANGOTARIFA")
	private Long idRangoTarifa;

	@Column(name = "VALORMAXIMORANGOTARIFA")
	private Long valorMaximoRangoTarifa;

	@Column(name = "VALORMINIMORANGOTARIFA")
	private Long valorMinimoRangoTarifa;

	@Column(name = "ESTADORANGOTARIFA")
	private Boolean estadoRangoTarifa;

	public RangoTarifa() {
		super();
	}

	public RangoTarifa(Long idRangoTarifa, Long valorMaximoRangoTarifa, Long valorMinimoRangoTarifa,
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

	public Long getValorMaximoRangoTarifa() {
		return valorMaximoRangoTarifa;
	}

	public void setValorMaximoRangoTarifa(Long valorMaximoRangoTarifa) {
		this.valorMaximoRangoTarifa = valorMaximoRangoTarifa;
	}

	public Long getValorMinimoRangoTarifa() {
		return valorMinimoRangoTarifa;
	}

	public void setValorMinimoRangoTarifa(Long valorMinimoRangoTarifa) {
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
