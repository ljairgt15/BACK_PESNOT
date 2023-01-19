package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifaRango;

public interface TablaTarifaRangoRepository extends JpaRepository <TablaTarifaRango, Long> {
	
	@Modifying
	@Query(nativeQuery = true, value = "update TablaTarifaRango set estadoTablaTarifaRango=0 where idTablaTarifa=:idTablaTarifa")
	void deshabilitar(@Param("idTablaTarifa") String idTablaTarifa);

	@Query(nativeQuery = true, value = "SELECT TOP 1 * FROM TablaTarifaRango c WHERE c.idTablaTarifa= :idTablaTarifa AND c.idRangoTarifa= :idRangoTarifa")
	TablaTarifaRango getTablaRangoUnico(@Param("idTablaTarifa") String idTablaTarifa,
			@Param("idRangoTarifa") String idRangoTarifa);
	
	@Query(nativeQuery = true, value = "SELECT * FROM TablaTarifaRango c WHERE c.idTablaTarifa= :idTablaTarifa")
	List<TablaTarifaRango> getTablaUnicaConRango(@Param("idTablaTarifa") String idTablaTarifa);

}

