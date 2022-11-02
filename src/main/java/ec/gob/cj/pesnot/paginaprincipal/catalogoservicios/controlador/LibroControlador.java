package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.LibroService;

@RestController
@RequestMapping("Libros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LibroControlador {	
	
	@Autowired
	private LibroService libroService;

	public LibroControlador(LibroService libroService) {
		super();
		this.libroService = libroService;
	}	
	
	@GetMapping("/getLibros")
	public List<Libro> getLibros()
	{		
	List<Libro> ListaLibros = libroService.getLibros();	
	return ListaLibros;	
	}	
	
	@PostMapping("/saveLibros")
	public Libro guardarLibro(@RequestBody Libro objLibro) {
		
		return libroService.ingresarLibrosL(objLibro);		
	}
	
	@GetMapping("/getLibroById/{id}")
	public Optional<Libro> obtenerLibroById(@PathVariable("id") Long id) {
		return libroService.libroById(id);
	}
	@GetMapping("/getLibroByNombre/{nombre}")
	public Optional<Libro> obtenerLibroByNombre(@PathVariable("nombre") String id) {
		return libroService.getLibroByNombre(id);
	}

}
