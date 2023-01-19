package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

public class ReporteTarifas {
	private String nombreCatalogo;
	private String articuloCatalogo;
	private String nombreTipoLibro;
	private Boolean esTabla;
	private String valorCalculado;
	private Boolean estadoCatalogo;

	public ReporteTarifas() {
	}

	public ReporteTarifas(String nombreCatalogo, String articuloCatalogo, String nombreTipoLibro, Boolean esTabla,
			String valorCalculado, Boolean estadoCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
		this.articuloCatalogo = articuloCatalogo;
		this.nombreTipoLibro = nombreTipoLibro;
		this.esTabla = esTabla;
		this.valorCalculado = valorCalculado;
		this.estadoCatalogo = estadoCatalogo;
	}

	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}

	public String getArticuloCatalogo() {
		return articuloCatalogo;
	}

	public void setArticuloCatalogo(String articuloCatalogo) {
		this.articuloCatalogo = articuloCatalogo;
	}

	public String getNombreTipoLibro() {
		return nombreTipoLibro;
	}

	public void setNombreTipoLibro(String nombreTipoLibro) {
		this.nombreTipoLibro = nombreTipoLibro;
	}

	public String getEsTabla() {
		return esTabla ? "Tabla" : "Tarifa";
	}

	public void setEsTabla(Boolean esTabla) {
		this.esTabla = esTabla;
	}

	public String getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(String valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public String getEstadoCatalogo() {
		return estadoCatalogo ? "Activo" : "Inactivo";
	}

	public void setEstadoCatalogo(Boolean estadoCatalogo) {
		this.estadoCatalogo = estadoCatalogo;
	}

	@Override
	public String toString() {
		return "ReporteTarifas [nombreCatalogo=" + nombreCatalogo + ", articuloCatalogo=" + articuloCatalogo
				+ ", nombreTipoLibro=" + nombreTipoLibro + ", esTabla=" + esTabla + ", valorCalculado=" + valorCalculado
				+ ", estadoCatalogo=" + estadoCatalogo + "]";
	}
	
	

}
