package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Acto;


@Repository
public interface ActoRepository extends JpaRepository<Acto,Long >
{
	
	@Query(nativeQuery = true , value="SELECT * FROM TARIFA as t INNER JOIN ACTO as a on t.IDACTO=a.IDACTO  INNER JOIN  DETALLETARIFA as d on t.IDTARIFA=d.IDTARIFA INNER JOIN LIBRO as l on a.IDLIBRO=l.IDLIBRO")
	List<Acto>  getActos( );
	
	
	

}
