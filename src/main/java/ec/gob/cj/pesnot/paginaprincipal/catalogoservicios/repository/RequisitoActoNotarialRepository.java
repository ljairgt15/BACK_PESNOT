package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RequisitoActoNotarial;

@Repository
public interface RequisitoActoNotarialRepository extends JpaRepository<RequisitoActoNotarial,Long> {
	
	
	List<RequisitoActoNotarial >  findByIdActoNotarial(Long idActoNotarial);
	
	

}
