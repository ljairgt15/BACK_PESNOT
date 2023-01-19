package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.ActoRangoTarifa;

@Repository
public interface ActoRangoTarifaRepository extends JpaRepository <ActoRangoTarifa, Long> {
    @Modifying
	@Query(nativeQuery = true,value = "update ActoRangoTarifa set estadoActoRangoTarifa=0 where idCatalogoActoNotarial =:idActo") 
	void deshabilitar(@Param("idActo") String idActo);
    
	@Query(nativeQuery = true,value = "SELECT TOP 1 * FROM ActoRangoTarifa c WHERE c.idCatalogoActoNotarial= :idCatalogoActoNotarial AND c.idRangoTarifa= :idRangoTarifa")
	ActoRangoTarifa getActoRangoUnico(@Param("idCatalogoActoNotarial") String idCatalogoActoNotarial, @Param("idRangoTarifa") String idRangoTarifa);

}
