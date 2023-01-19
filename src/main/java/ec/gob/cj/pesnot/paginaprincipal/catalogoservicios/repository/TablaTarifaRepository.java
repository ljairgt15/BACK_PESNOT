package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifa;

public interface TablaTarifaRepository extends JpaRepository<TablaTarifa, Long> {
	@Query(nativeQuery = true,value="SELECT * FROM TablaTarifa r WHERE r.nombreTablaTarifa= :nombreTabla")
	TablaTarifa getTablaByNombre(@Param("nombreTabla") String  nombreTabla);

}
