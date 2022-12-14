package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.AuditoriaAdministracionPesnot;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.AuditoriaAdministracionPesnotRepository;


@Service
public class AuditoriaAdministracionPesnotService <T, ID> {
	private Class<T> persistentClass;
	protected EntityManager em;
	
	/*public AuditoriaAdministracionPesnotService(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("jpaCuentasBancarias").createEntityManager();
	}
*/
	public AuditoriaAdministracionPesnotRepository audiRepo;

	public AuditoriaAdministracionPesnotService(AuditoriaAdministracionPesnotRepository audiRepoE) {
		super();
		this.audiRepo=audiRepoE;
	}
	
    
    public void ingresarAdministracionI(T entity, String usuario, String rolUsuario, String accion) {
    	AuditoriaAdministracionPesnot audi= new AuditoriaAdministracionPesnot();
    	String datosAntiguos= entity.toString();
    	 String datosNuevos="";
    	//datosNuevos = entity.toString();
    	audi.setValoresAnteriores(datosAntiguos);
    		em.getTransaction().begin();
    		try {
    			audi= audiRepo.save(audi);
    			em.getTransaction().commit();
    		} catch (Exception e) {
    			System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
    			if (em.getTransaction().isActive())
    				em.getTransaction().rollback();
    		}

    	
    	
    }


}
