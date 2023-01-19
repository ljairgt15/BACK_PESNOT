package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.MotivoCobroCatalogoActo;

@Repository
public interface MotivoCobroCatalogoActoRepository extends JpaRepository <MotivoCobroCatalogoActo,Long> {
	
    @Modifying
	@Query(nativeQuery = true,value = "update MotivoCobroCatalogoacto set estadoMotivoCobroCatalogoActo=0 where idCatalogoActoNotarial =:idActo") 
	void deshabilitar(@Param("idActo") String idActo);
    
    @Query(nativeQuery = true,value = "SELECT TOP 1 * FROM MotivoCobroCatalogoacto c WHERE c.idCatalogoActoNotarial= :idCatalogoActoNotarial AND c.idMotivoCobroActo=:idMotivoCobroActo")
	MotivoCobroCatalogoActo getActoMotivoUnico(@Param("idCatalogoActoNotarial") String idCatalogoActoNotarial, @Param("idMotivoCobroActo") String idMotivoCobroActo);
	
}
