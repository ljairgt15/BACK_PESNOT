package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Tarifa;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa,Long> {	
	@Query(nativeQuery = true , value="SELECT * FROM TARIFA as t INNER JOIN ACTO as a on t.IDACTO=a.IDACTO")
	List<Tarifa>  getTarifa( );
}
