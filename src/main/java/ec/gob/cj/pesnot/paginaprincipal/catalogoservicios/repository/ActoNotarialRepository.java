package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;

@Repository
public interface ActoNotarialRepository extends JpaRepository<ActoNotarial, Long> {
	
	
	@Query(nativeQuery = true,value = "SELECT * FROM CatalogoActoNotarial a WHERE a.nombreCatalogoActoNotarial LIKE :nombre%")
	List<ActoNotarial> getActosLike(@Param("nombre") String nombre);	
	
	@Query(nativeQuery = true,value = "SELECT * FROM CatalogoActoNotarial a WHERE a.idTipoLibro = :libro")
	List<ActoNotarial> getActosByIdLibro(@Param("libro") String libro);
	
	@Query(nativeQuery = true,value = "SELECT * from CatalogoActoNotarial where estadoCatalogoActoNotarial='true'")
	List<ActoNotarial> getActosActivos();
	
	@Query(nativeQuery = true,value = "SELECT DISTINCT A.idCatalogoActoNotarial,A.idTasaImpuesto, A.articuloCatalogoActoNotarial, A.estadoCatalogoActoNotarial, A.gravaIVACatalogoActoNotarial, A.habilitableCiudadanoCatalogoActoNotarial,A.nombreCatalogoActoNotarial, A.tarifaCatalogoActoNotarial,A.tramiteUnilateralCatalogoActoNotarial,A.usaCalculoTablaCatalogoActoNotarial,A.valorExoneracionCatalogoActoNotarial,A.valorExtraCatalogoActoNotarial, A.idBaseCobroActo,A.idClasificacionNumeroIntervienteActo, A.idTipoLibro from CatalogoActoNotarial as a join MotivoCobroCatalogoacto as m on a.idCatalogoActoNotarial=m.idCatalogoActoNotarial UNION SELECT DISTINCT A.idCatalogoActoNotarial,A.idTasaImpuesto,A.articuloCatalogoActoNotarial, A.estadoCatalogoActoNotarial, A.gravaIVACatalogoActoNotarial, A.habilitableCiudadanoCatalogoActoNotarial,A.nombreCatalogoActoNotarial, A.tarifaCatalogoActoNotarial,A.tramiteUnilateralCatalogoActoNotarial,A.usaCalculoTablaCatalogoActoNotarial,A.valorExoneracionCatalogoActoNotarial,A.valorExtraCatalogoActoNotarial, A.idBaseCobroActo,A.idClasificacionNumeroIntervienteActo, A.idTipoLibro from CatalogoActoNotarial as a join ActoRangoTarifa as m on a.idCatalogoActoNotarial=m.idCatalogoActoNotarial")
	List<ActoNotarial> getActosConTarifa();
	
	@Query(nativeQuery = true,value = "SELECT DISTINCT A.IDCATALOGOACTONOTARIAL, A.ARTICULOCATALOGOACTONOTARIAL, A.ESTADOCATALAGOACTONOTARIAL, A.GRAVAIVACATALOGOACTONOTARIAL, A.HABILITANTECIUDADANOCATALOGOACTONOTARIAL,A.NOMBRECATALOGOACTONOTARIAL, A.TARIFACATALOGOACTONOTARIAL,A.TRAMITEUNILATERALCATALOGOACTONOTARIAL,A.USACALCULOTABLACATALOGOACTONOTARIAL,A.VALOREXONERACIONCATALOGOACTONOTARIAL,A.VALOREXTRACATALOGOACTONOTARIAL, A.IDBASECOBROACTO,A.IDCLASIFICACIONNUMEROINTERVIENTEACTO, A.IDTIPOLIBRO from CatalogoActoNotarial as a join MotivoCobroCatalogoacto as m on a.IDCATALOGOACTONOTARIAL=m.IDCATALOGOACTONOTARIAL UNION SELECT DISTINCT A.IDCATALOGOACTONOTARIAL, A.ARTICULOCATALOGOACTONOTARIAL, A.ESTADOCATALAGOACTONOTARIAL, A.GRAVAIVACATALOGOACTONOTARIAL, A.HABILITANTECIUDADANOCATALOGOACTONOTARIAL,A.NOMBRECATALOGOACTONOTARIAL, A.TARIFACATALOGOACTONOTARIAL, A.TRAMITEUNILATERALCATALOGOACTONOTARIAL,A.USACALCULOTABLACATALOGOACTONOTARIAL,A.VALOREXONERACIONCATALOGOACTONOTARIAL, A.VALOREXTRACATALOGOACTONOTARIAL, A.IDBASECOBROACTO,A.IDCLASIFICACIONNUMEROINTERVIENTEACTO,A.IDTIPOLIBRO from CatalogoActoNotarial as a join ActoRangoTarifa as m on a.IDCATALOGOACTONOTARIAL=m.IDCATALOGOACTONOTARIAL") //revisar si es "a" o "as a"
	List<ActoNotarial> getActosConTarifaParametros();
	
	@Query(nativeQuery = true,value = "SELECT TOP 1 * FROM CatalogoActoNotarial c WHERE c.idTipoLibro= :idTipoLibro AND c.idBaseCobroActo= :idBaseCobroActo AND c.idClasificacionNumeroIntervienteActo= :idClasificacion AND c.nombreCatalogoActoNotarial= :nombreCatalogo")
	ActoNotarial getActoUnico(@Param("nombreCatalogo") String nombre, @Param("idTipoLibro") String idTipoLibro, @Param("idBaseCobroActo") String idBaseCobroActo, @Param("idClasificacion") String idClasificacion);


}
