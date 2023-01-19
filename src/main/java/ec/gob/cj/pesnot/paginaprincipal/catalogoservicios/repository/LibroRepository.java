package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;



@Repository
public interface LibroRepository extends JpaRepository<Libro, Long > {
	@Query(nativeQuery = true,value="SELECT TOP 1 * FROM TipoLibro c WHERE c.nombreTipoLibro LIKE :nombre%")
	Libro getLibroByNombre(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM TipoLibro where estadoActivo='true'")
	List<Libro> getAllActives();
	
	@Query(nativeQuery = true,value="select  DISTINCT j.idTipoLibro, j.estadoActivo, j.nombreTipoLibro, j.idAdjuntoLibro from CatalogoActoNotarial as c left join TipoLibro as j on j.idTipoLibro=c.idTipoLibro")
	List<Libro>getAllLibrosWithActosN();
}
