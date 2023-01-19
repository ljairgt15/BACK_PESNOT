package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model;

public class RangoMotivo {
	
	private Long id;
	private ActoNotarial acto;
	private Double precio;
	
	
	public RangoMotivo() {
		super();
	}
	
	public RangoMotivo(Long id, ActoNotarial acto, Double precio) {
		super();
		this.id = id;
		this.acto = acto;
		this.precio = precio;
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "RangoMotivo [id=" + id + ", acto=" + acto + ", precio=" + precio + "]";
	}
	
	
	
	
	
	

}
