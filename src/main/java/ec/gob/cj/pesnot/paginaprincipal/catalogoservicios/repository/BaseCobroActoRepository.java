package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.BaseCobroActo;

@Repository
public interface BaseCobroActoRepository extends JpaRepository<BaseCobroActo,Long>{

	@Query(nativeQuery = true,value="SELECT TOP 1 * FROM BaseCobroActo c WHERE c.nombreBaseCobroActo LIKE :nombre%")
	BaseCobroActo getBaseActoByNombre(@Param("nombre") String nombre);

}
