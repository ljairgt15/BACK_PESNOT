package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actoRequisitos")
public class RequisitoActoNotarial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idactoRequisito;
	
	@Column(name = "idActoNotarial" )
	private Long idActoNotarial;
	
	@Column(name = "idrequisito")
	private String requisito;

	public RequisitoActoNotarial(Long idactoRequisito, Long idActoNotarial, String requisito) {
		super();
		this.idactoRequisito = idactoRequisito;
		this.idActoNotarial = idActoNotarial;
		this.requisito = requisito;
	}

	public RequisitoActoNotarial() {
		super();
	}

	public Long getIdactoRequisito() {
		return idactoRequisito;
	}

	public void setIdactoRequisito(Long idactoRequisito) {
		this.idactoRequisito = idactoRequisito;
	}

	public Long getIdActoNotarial() {
		return idActoNotarial;
	}

	public void setIdActoNotarial(Long idActoNotarial) {
		this.idActoNotarial = idActoNotarial;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
