package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.AdjuntoLibro;

@Repository
public interface AdjuntoLibroRepository extends JpaRepository<AdjuntoLibro, Long>{
	
	@Query(nativeQuery = true,value="SELECT TOP 1 * FROM AdjuntoLibro c WHERE c.NombreAdjuntoLibro LIKE :nombre%")
	Optional<AdjuntoLibro> getAdjuntoByNombre(@Param("nombre") String nombre);

}
