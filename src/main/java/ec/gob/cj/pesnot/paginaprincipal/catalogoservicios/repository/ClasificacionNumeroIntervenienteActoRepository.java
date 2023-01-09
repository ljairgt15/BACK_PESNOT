package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ClasificacionNumeroIntervinienteActo;


@Repository
public interface ClasificacionNumeroIntervenienteActoRepository extends JpaRepository<ClasificacionNumeroIntervinienteActo,Long>{

	@Query(nativeQuery = true,value="SELECT TOP 1 * FROM ClasificacionNumeroIntervienteacto c WHERE c.nombreClasificacionNumeroIntervienteActo LIKE :nombre%")
	ClasificacionNumeroIntervinienteActo getClasificacionByNombre(@Param("nombre") String nombre);
}
