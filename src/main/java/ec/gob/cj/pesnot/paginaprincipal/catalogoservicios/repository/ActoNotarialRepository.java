package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;





@Repository
public interface ActoNotarialRepository extends JpaRepository<ActoNotarial, Long> {
	
	List<ActoNotarial> findByNombreActoNotarial(String nombreActoNotarial);
	
	@Query(nativeQuery = true,value = "SELECT * FROM acto_notarial a WHERE a.nombre_acto_notarial LIKE :nombre%") //revisar si es "a" o "as a"
	List<ActoNotarial> getActosLike(@Param("nombre") String nombre);	
	
	@Query(nativeQuery = true,value = "SELECT * FROM acto_notarial a WHERE a.libro_acto_notarial LIKE :libro%") //revisar si es "a" o "as a"
	List<ActoNotarial> getActosLibros(@Param("libro") String libro);	
}
