package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="AUDITORIAADMINISTRACIONPESNOT")
public class AuditoriaAdministracionPesnot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDAUDITORIA")
	private Long idAuditoria;
	
	@Column(name="NOMBRETABLA")
	private String nombreTabla;
	
	@Column(name="VALORESANTERIORES")
	private String valoresAnteriores;
	
	@Column(name="VALORESACTUALES")
	private String valoresActuales;
	
	@Column(name="USUARIO")
	private String usuario;
	
	@Column(name="ROLUSUARIO")
	private String rolUsuario;
	
	@Column(name="FECHA")
	private Date fecha;
	
	@Column(name="ACCION")
	private String accion;
	
	
	public AuditoriaAdministracionPesnot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditoriaAdministracionPesnot(Long idAuditoria, String nombreTabla, String valoresAnteriores,
			String valoresActuales, String usuario, String rolUsuario, Date fecha, String accion) {
		super();
		this.idAuditoria = idAuditoria;
		this.nombreTabla = nombreTabla;
		this.valoresAnteriores = valoresAnteriores;
		this.valoresActuales = valoresActuales;
		this.usuario = usuario;
		this.rolUsuario = rolUsuario;
		this.fecha = fecha;
		this.accion = accion;
	}

	public Long getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(Long idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public String getValoresAnteriores() {
		return valoresAnteriores;
	}

	public void setValoresAnteriores(String valoresAnteriores) {
		this.valoresAnteriores = valoresAnteriores;
	}

	public String getValoresActuales() {
		return valoresActuales;
	}

	public void setValoresActuales(String valoresActuales) {
		this.valoresActuales = valoresActuales;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	@Override
	public String toString() {
		return "AuditoriaAdministracionPesnot [idAuditoria=" + idAuditoria + ", nombreTabla=" + nombreTabla
				+ ", valoresAnteriores=" + valoresAnteriores + ", valoresActuales=" + valoresActuales + ", usuario="
				+ usuario + ", rolUsuario=" + rolUsuario + ", fecha=" + fecha + ", accion=" + accion + "]";
	}
	
}
