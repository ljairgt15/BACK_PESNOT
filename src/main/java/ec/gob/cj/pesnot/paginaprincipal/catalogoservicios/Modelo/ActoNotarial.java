package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acto_notarial")
public class ActoNotarial {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name = "nombre_acto_notarial")
	private String nombreActoNotarial;

	@Column(name = "libro_acto_notarial")
	private String libroActoNotarial;

	@Column(name = "estado_acto_notarial")
	private String estadoActoNotarial;
	
	@Column(name = "tarifa")
	private BigDecimal tarifa;

	public BigDecimal getTarifa() {
		return tarifa;
	}

	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
	}



	public ActoNotarial(Long id, String nombreActoNotarial, String libroActoNotarial, String estadoActoNotarial,
			BigDecimal tarifa) {
		super();
		this.id = id;
		this.nombreActoNotarial = nombreActoNotarial;
		this.libroActoNotarial = libroActoNotarial;
		this.estadoActoNotarial = estadoActoNotarial;
		this.tarifa = tarifa;
	}

	public ActoNotarial() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreActoNotarial() {
		return nombreActoNotarial;
	}

	public void setNombreActoNotarial(String nombreActoNotarial) {
		this.nombreActoNotarial = nombreActoNotarial;
	}

	public String getLibroActoNotarial() {
		return libroActoNotarial;
	}

	public void setLibroActoNotarial(String libroActoNotarial) {
		this.libroActoNotarial = libroActoNotarial;
	}

	public String getEstadoActoNotarial() {
		return estadoActoNotarial;
	}

	public void setEstadoActoNotarial(String estadoActoNotarial) {
		this.estadoActoNotarial = estadoActoNotarial;
	}
}
