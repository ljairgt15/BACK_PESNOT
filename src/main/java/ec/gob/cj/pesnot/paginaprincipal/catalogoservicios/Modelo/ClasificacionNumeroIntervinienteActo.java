package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClasificacionNumeroIntervienteacto")
public class ClasificacionNumeroIntervinienteActo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idClasificacionNumeroIntervienteActo") 
	private Long idClasificacionNumeroIntervinienteActo;
	
	@Column(name="nombreClasificacionNumeroIntervienteActo")
	private String nombreClasificacionNumeroIntervinienteActo;
	
	@Column(name="estadoClasificacionNumeroIntervienteActo") 
	private Boolean estadoClasificacionNumeroIntervinienteActo;

	public ClasificacionNumeroIntervinienteActo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClasificacionNumeroIntervinienteActo(Long idClasificacionNumeroIntervinienteActo,
			String nombreClasificacionNumeroIntervinienteActo, Boolean estadoClasificacionNumeroIntervinienteActo) {
		super();
		this.idClasificacionNumeroIntervinienteActo = idClasificacionNumeroIntervinienteActo;
		this.nombreClasificacionNumeroIntervinienteActo = nombreClasificacionNumeroIntervinienteActo;
		this.estadoClasificacionNumeroIntervinienteActo = estadoClasificacionNumeroIntervinienteActo;
	}

	public Long getIdClasificacionNumeroIntervinienteActo() {
		return idClasificacionNumeroIntervinienteActo;
	}

	public void setIdClasificacionNumeroIntervinienteActo(Long idClasificacionNumeroIntervinienteActo) {
		this.idClasificacionNumeroIntervinienteActo = idClasificacionNumeroIntervinienteActo;
	}

	public String getNombreClasificacionNumeroIntervinienteActo() {
		return nombreClasificacionNumeroIntervinienteActo;
	}

	public void setNombreClasificacionNumeroIntervinienteActo(String nombreClasificacionNumeroIntervinienteActo) {
		this.nombreClasificacionNumeroIntervinienteActo = nombreClasificacionNumeroIntervinienteActo;
	}

	public Boolean getEstadoClasificacionNumeroIntervinienteActo() {
		return estadoClasificacionNumeroIntervinienteActo;
	}

	public void setEstadoClasificacionNumeroIntervinienteActo(Boolean estadoClasificacionNumeroIntervinienteActo) {
		this.estadoClasificacionNumeroIntervinienteActo = estadoClasificacionNumeroIntervinienteActo;
	}

	@Override
	public String toString() {
		return "ClasificacionNumeroIntervinienteActo [idClasificacionNumeroIntervinienteActo="
				+ idClasificacionNumeroIntervinienteActo + ", nombreClasificacionNumeroIntervinienteActo="
				+ nombreClasificacionNumeroIntervinienteActo + ", estadoClasificacionNumeroIntervinienteActo="
				+ estadoClasificacionNumeroIntervinienteActo + "]";
	}
	
	

}
