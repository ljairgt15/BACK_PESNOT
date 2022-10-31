package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ADJUNTOLIBRO")
public class AdjuntoLibro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDADJUNTOLIBRO")
	private Long idAdjuntoLibro;
	
	@Column(name="NOMBREADJUNTOLIBRO")
	private String nombreAdjuntoLibro;
	
	@Column(name="ARCHIVOADJUNTOLIBRO")
	private byte archivoAdjuntoLibro;
	
	@Column(name="OBSERVACIONADJUNTOLIBRO")
	private String observacionAdjuntoLibro;
	

	public AdjuntoLibro() {
		super();
	}


	public AdjuntoLibro(Long idAdjuntoLibro, String nombreAdjuntoLibro, byte archivoAdjuntoLibro,
			String observacionAdjuntoLibro) {
		super();
		this.idAdjuntoLibro = idAdjuntoLibro;
		this.nombreAdjuntoLibro = nombreAdjuntoLibro;
		this.archivoAdjuntoLibro = archivoAdjuntoLibro;
		this.observacionAdjuntoLibro = observacionAdjuntoLibro;
	}


	public Long getIdAdjuntoLibro() {
		return idAdjuntoLibro;
	}


	public void setIdAdjuntoLibro(Long idAdjuntoLibro) {
		this.idAdjuntoLibro = idAdjuntoLibro;
	}


	public String getNombreAdjuntoLibro() {
		return nombreAdjuntoLibro;
	}


	public void setNombreAdjuntoLibro(String nombreAdjuntoLibro) {
		this.nombreAdjuntoLibro = nombreAdjuntoLibro;
	}


	public byte getArchivoAdjuntoLibro() {
		return archivoAdjuntoLibro;
	}


	public void setArchivoAdjuntoLibro(byte archivoAdjuntoLibro) {
		this.archivoAdjuntoLibro = archivoAdjuntoLibro;
	}


	public String getObservacionAdjuntoLibro() {
		return observacionAdjuntoLibro;
	}


	public void setObservacionAdjuntoLibro(String observacionAdjuntoLibro) {
		this.observacionAdjuntoLibro = observacionAdjuntoLibro;
	}


	@Override
	public String toString() {
		return "AdjuntoLibro [idAdjuntoLibro=" + idAdjuntoLibro + ", nombreAdjuntoLibro=" + nombreAdjuntoLibro
				+ ", archivoAdjuntoLibro=" + archivoAdjuntoLibro + ", observacionAdjuntoLibro="
				+ observacionAdjuntoLibro + "]";
	}
	
	

}
