package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;

@Repository
public interface ActoNotarialRepository extends JpaRepository<ActoNotarial, Long> {
	
	
	@Query(nativeQuery = true,value = "SELECT * FROM CATALOGOACTONOTARIAL a WHERE a.NOMBRECATALOGOACTONOTARIAL LIKE :nombre%") //revisar si es "a" o "as a"
	List<ActoNotarial> getActosLike(@Param("nombre") String nombre);	
	
	@Query(nativeQuery = true,value = "SELECT * FROM CATALOGOACTONOTARIAL a WHERE a.IDTIPOLIBRO = :libro") //revisar si es "a" o "as a"
	List<ActoNotarial> getActosLibros(@Param("libro") String libro);	
}
