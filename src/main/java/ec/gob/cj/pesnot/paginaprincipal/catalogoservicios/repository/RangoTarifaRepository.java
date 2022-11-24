package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoTarifa;

@Repository
public interface RangoTarifaRepository extends JpaRepository <RangoTarifa,Long>{

	@Query(nativeQuery = true,value="SELECT * FROM RANGOTARIFA r WHERE r.VALORMAXIMORANGOTARIFA=:valorMax AND r.VALORMINIMORANGOTARIFA=:valorMin")
	Optional<RangoTarifa> getRangoByMinMax(@Param("valorMax") Double valorMax, @Param("valorMin") Double valorMin);	
}
