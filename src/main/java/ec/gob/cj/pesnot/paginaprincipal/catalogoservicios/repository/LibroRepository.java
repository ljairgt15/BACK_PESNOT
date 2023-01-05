package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;



@Repository
public interface LibroRepository extends JpaRepository<Libro, Long > {
	@Query(nativeQuery = true,value="SELECT TOP 1 * FROM TipoLibro c WHERE c.NOMBRETIPOLIBRO LIKE :nombre%")
	Optional<Libro> getLibroByNombre(@Param("nombre") String nombre);
	
	@Query(nativeQuery = true,value="SELECT * FROM TipoLibro where ESTADOACTIVO='true'")
	List<Libro> getAllActives();
	
	@Query(nativeQuery = true,value="select  DISTINCT j.IDTIPOLIBRO, j.ESTADOACTIVO, j.NOMBRETIPOLIBRO, j.IDADJUNTOLIBRO from CatalogoActoNotarial as c left join TipoLibro as j on j.IDTIPOLIBRO=c.IDTIPOLIBRO")
	List<Libro>getAllLibrosWithActosN();
}
