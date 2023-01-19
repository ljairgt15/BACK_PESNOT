package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

public class RangoMotivo {
	
	private Long id;
	private ActoNotarial acto;
	private String precio;
	
	
	public RangoMotivo() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ActoNotarial getActo() {
		return acto;
	}


	public void setActo(ActoNotarial acto) {
		this.acto = acto;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "RangoMotivo [id=" + id + ", acto=" + acto + ", precio=" + precio + "]";
	}
		
	
}
