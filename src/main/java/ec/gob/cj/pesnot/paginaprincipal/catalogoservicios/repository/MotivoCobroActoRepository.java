package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.MotivoCobroActo;

@Repository
public interface MotivoCobroActoRepository extends JpaRepository<MotivoCobroActo,Long> {
	@Query(nativeQuery = true,value="SELECT TOP 1 * FROM MotivoCobroActo c WHERE c.nombreMotivoCobroActo LIKE :nombre%")
	Optional<MotivoCobroActo> getMotivoCobroByNombre(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT TOP 1 * FROM MotivoCobroActo c WHERE c.nombreMotivoCobroActo = :nombre")
	MotivoCobroActo getMotivoCobroUnico(@Param("nombre") String nombre);

}
