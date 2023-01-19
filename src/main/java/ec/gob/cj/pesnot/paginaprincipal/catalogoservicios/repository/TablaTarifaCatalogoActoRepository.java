package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifaCatalogoActo;

@Repository
public interface TablaTarifaCatalogoActoRepository extends JpaRepository<TablaTarifaCatalogoActo, Long> {
	@Modifying
	@Query(nativeQuery = true, value = "update TablaTarifaCatalogoActo set estadoActivo=0 where idCatalogoActoNotarial=:idCatalogoActoNotarial")
	void deshabilitar(@Param("idCatalogoActoNotarial") String idCatalogoActoNotarial);

	@Query(nativeQuery = true, value = "SELECT TOP 1 * FROM TablaTarifaCatalogoActo c WHERE c.idCatalogoActoNotarial= :idCatalogoActoNotarial AND c.idTablaTarifa= :idTablaTarifa")
	TablaTarifaCatalogoActo getTablaActo(@Param("idCatalogoActoNotarial") String idCatalogoActoNotarial,
			@Param("idTablaTarifa") String idTablaTarifa);

}
