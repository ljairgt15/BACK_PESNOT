package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="ACTO")
public class Acto {
	
	@Id
	@Column(name="IDACTO")
	private Long idActo;
	
	@Column(name="IDLIBRO")
	private Long idLibro;
	
	@Column(name="ARTICULO")
	private String articulo;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="FECHAINICIO")
	private Date fechaInicio;
	
	@Column(name="FECHAFIN")
	private Date fechaFin;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="OBSERVACION")
	private String observacion;
	
	@Column(name="REQUERIDOCOMPARECIENTE")
	private Boolean requeridoCompareciente;
	
	@Column(name="VALOREXTRA")
	private String valorExtra;
	
	@Column(name="LOGICACALCULO_ID")
	private int logicaCalculoId;
	
	@Column(name="PLANTILLA_ID")
	private int plantillaId;
	
	@Column(name="PAGAIVA")
	private Boolean pagaIva;
	
	@Column(name="EXONERADO")
	private Boolean exonerado;
	
	@Column(name="GUARDAEXTRACTO")
	private Boolean guardaExtracto;
	
	@Column(name="MENSAJESELACTO")
	private String  mensajeSelActo;
	
	@Column(name="VALIDAADULTOMAYOR")
	private Boolean validaAdultoMayor;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="TARIFA")
	private int TARIFA;
	
	
	

	public Acto() {
		super();
	}




	public Acto(Long idActo, Long idLibro, String articulo, String estado, Date fechaInicio, Date fechaFin,
			String nombre, String observacion, Boolean requeridoCompareciente, String valorExtra, int logicaCalculoId,
			int plantillaId, Boolean pagaIva, Boolean exonerado, Boolean guardaExtracto, String mensajeSelActo,
			Boolean validaAdultoMayor, String titulo, int tARIFA) {
		super();
		this.idActo = idActo;
		this.idLibro = idLibro;
		this.articulo = articulo;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nombre = nombre;
		this.observacion = observacion;
		this.requeridoCompareciente = requeridoCompareciente;
		this.valorExtra = valorExtra;
		this.logicaCalculoId = logicaCalculoId;
		this.plantillaId = plantillaId;
		this.pagaIva = pagaIva;
		this.exonerado = exonerado;
		this.guardaExtracto = guardaExtracto;
		this.mensajeSelActo = mensajeSelActo;
		this.validaAdultoMayor = validaAdultoMayor;
		this.titulo = titulo;
		TARIFA = tARIFA;
	}




	public Long getIdActo() {
		return idActo;
	}




	public void setIdActo(Long idActo) {
		this.idActo = idActo;
	}




	public Long getIdLibro() {
		return idLibro;
	}




	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}




	public String getArticulo() {
		return articulo;
	}




	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}




	public Date getFechaInicio() {
		return fechaInicio;
	}




	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}




	public Date getFechaFin() {
		return fechaFin;
	}




	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getObservacion() {
		return observacion;
	}




	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}




	public Boolean getRequeridoCompareciente() {
		return requeridoCompareciente;
	}




	public void setRequeridoCompareciente(Boolean requeridoCompareciente) {
		this.requeridoCompareciente = requeridoCompareciente;
	}




	public String getValorExtra() {
		return valorExtra;
	}




	public void setValorExtra(String valorExtra) {
		this.valorExtra = valorExtra;
	}




	public int getLogicaCalculoId() {
		return logicaCalculoId;
	}




	public void setLogicaCalculoId(int logicaCalculoId) {
		this.logicaCalculoId = logicaCalculoId;
	}




	public int getPlantillaId() {
		return plantillaId;
	}




	public void setPlantillaId(int plantillaId) {
		this.plantillaId = plantillaId;
	}




	public Boolean getPagaIva() {
		return pagaIva;
	}




	public void setPagaIva(Boolean pagaIva) {
		this.pagaIva = pagaIva;
	}




	public Boolean getExonerado() {
		return exonerado;
	}




	public void setExonerado(Boolean exonerado) {
		this.exonerado = exonerado;
	}




	public Boolean getGuardaExtracto() {
		return guardaExtracto;
	}




	public void setGuardaExtracto(Boolean guardaExtracto) {
		this.guardaExtracto = guardaExtracto;
	}




	public String getMensajeSelActo() {
		return mensajeSelActo;
	}




	public void setMensajeSelActo(String mensajeSelActo) {
		this.mensajeSelActo = mensajeSelActo;
	}




	public Boolean getValidaAdultoMayor() {
		return validaAdultoMayor;
	}




	public void setValidaAdultoMayor(Boolean validaAdultoMayor) {
		this.validaAdultoMayor = validaAdultoMayor;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public int getTARIFA() {
		return TARIFA;
	}




	public void setTARIFA(int tARIFA) {
		TARIFA = tARIFA;
	}
	
}
