package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="TIPOLIBRO")
public class Libro {
	
	@Id
	@Column(name="IDTIPOLIBRO")
	private Long idTipoLibro;
	//TODO poner referencia al adjunto libro
	@Column(name="IDADJUNTOLIBRO")
	private Long idAdjuntoLibro;
	
	@Column(name="NOMBRETIPOLIBRO")
	private String nombreTipoLibro;
	
	@Column(name="ESTADOACTIVO")
	private boolean estadoActivo;
	
	

	public Libro() {
		super();
	}

	


	public Libro(Long idTipoLibro, Long idAdjuntoLibro, String nombreTipoLibro, boolean estadoActivo) {
		super();
		this.idTipoLibro = idTipoLibro;
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



	public Long getIdAdjuntoLibro() {
		return idAdjuntoLibro;
	}



	public void setIdAdjuntoLibro(Long idAdjuntoLibro) {
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
