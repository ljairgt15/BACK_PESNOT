	package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

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
@Table(name ="TipoLibro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTipoLibro")
	private Long idTipoLibro;
	
	@ManyToOne(targetEntity = AdjuntoLibro.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idAdjuntoLibro",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private AdjuntoLibro idAdjuntoLibro;
	
	@Column(name="nombreTipoLibro")
	private String nombreTipoLibro;
	
	@Column(name="estadoActivo")
	private boolean estadoActivo;
	
	

	public Libro() {
		super();
	}



	public Libro(Long idTipoLibro, AdjuntoLibro idAdjuntoLibro, String nombreTipoLibro, boolean estadoActivo) {
		super();
		this.idTipoLibro = idTipoLibro;
		this.idAdjuntoLibro = idAdjuntoLibro;
		this.nombreTipoLibro = nombreTipoLibro;
		this.estadoActivo = estadoActivo;
	}
	



	public Libro(AdjuntoLibro idAdjuntoLibro, String nombreTipoLibro, boolean estadoActivo) {
		super();
		this.idAdjuntoLibro = idAdjuntoLibro;
		this.nombreTipoLibro = nombreTipoLibro;
		this.estadoActivo = estadoActivo;
	}



	public Long getIdTipoLibro() {
		return idTipoLibro;
	}



	public void setIdTipoLibro(Long idTipoLibro) {
		this.idTipoLibro = idTipoLibro;
	}



	public AdjuntoLibro getIdAdjuntoLibro() {
		return idAdjuntoLibro;
	}



	public void setIdAdjuntoLibro(AdjuntoLibro idAdjuntoLibro) {
		this.idAdjuntoLibro = idAdjuntoLibro;
	}



	public String getNombreTipoLibro() {
		return nombreTipoLibro;
	}



	public void setNombreTipoLibro(String nombreTipoLibro) {
		this.nombreTipoLibro = nombreTipoLibro;
	}



	public boolean isEstadoActivo() {
		return estadoActivo;
	}



	public void setEstadoActivo(boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}



	@Override
	public String toString() {
		return "Libro [idTipoLibro=" + idTipoLibro + ", idAdjuntoLibro=" + idAdjuntoLibro + ", nombreTipoLibro="
				+ nombreTipoLibro + ", estadoActivo=" + estadoActivo + "]";
	}
	
}
