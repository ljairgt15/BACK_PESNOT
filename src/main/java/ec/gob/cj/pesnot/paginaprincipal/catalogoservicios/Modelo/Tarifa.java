package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="TARIFA")
public class Tarifa {
	
	@Id
	@Column(name="IDTARIFA")
	private Long idTarifa;
	
	
	@Column(name="NOMBRE")
	private String acto;
	
	@Column(name="IDTIPOTARIFA")
	private int idTipoTarifa;
	
	@Column(name="IDESTADO")
	private int idEstado;

	public Tarifa(Long idTarifa, String acto, int idTipoTarifa, int idEstado) {
		super();
		this.idTarifa = idTarifa;
		this.acto = acto;
		this.idTipoTarifa = idTipoTarifa;
		this.idEstado = idEstado;
	}

	public Tarifa() {
		super();
	}

	public Long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getActo() {
		return acto;
	}

	public void setActo(String acto) {
		this.acto = acto;
	}

	public int getIdTipoTarifa() {
		return idTipoTarifa;
	}

	public void setIdTipoTarifa(int idTipoTarifa) {
		this.idTipoTarifa = idTipoTarifa;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	
	
	
	
	

		
	
	
	
	
	

}
