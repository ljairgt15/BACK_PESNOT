package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoTarifa;

@Repository
public interface RangoTarifaRepository extends JpaRepository <RangoTarifa,Long>{

	@Query(nativeQuery = true,value="SELECT * FROM RangoTarifa r WHERE r.valorMaximoRangoTarifa=:valorMax AND r.valorMinimoRangoTarifa=:valorMin")
	RangoTarifa getRangoByMinMax(@Param("valorMax") BigDecimal valorMax, @Param("valorMin")BigDecimal valorMin);
	
	@Query(nativeQuery = true,value = "SELECT * from RangoTarifa r where r.estadoRangoTarifa='true'")
	List<RangoTarifa> getRangosActivos();
	
	
}
