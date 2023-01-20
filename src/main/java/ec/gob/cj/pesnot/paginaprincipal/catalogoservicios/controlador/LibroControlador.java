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
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LibroControlador {

	@Autowired
	private LibroService libroService;

	public LibroControlador(LibroService libroService) {
		super();
		this.libroService = libroService;
	}

	@GetMapping("/libros")
	public List<Libro> obtenerLibros() {
		List<Libro> ListaLibros = libroService.getLibros();
		return ListaLibros;
	}

	@GetMapping("/libros/actos")
	public List<Libro> obtenerLibrosConActosN() {
		List<Libro> ListaLibros = libroService.getLibrosWithActN();
		return ListaLibros;
	}

	@GetMapping("/libros/activos")
	public List<Libro> obtenerLibrosActivos() {
		List<Libro> ListaLibros = libroService.getLibrosActivos();
		return ListaLibros;
	}

	@PostMapping("/libros")
	public Libro guardarLibro(@RequestBody Libro objLibro) {

		return libroService.ingresarLibrosL(objLibro);
	}

	/*
	 * @PostMapping("/saveLibrosAdministracion") public Optional<Libro>
	 * guardarLibroAdmin(@RequestBody Libro objLibro) {
	 * 
	 * return libroService.ingresarAdministracion(objLibro); }
	 */

	@GetMapping("/libros/{id}")
	public Optional<Libro> obtenerLibroById(@PathVariable("id") Long id) {
		return libroService.libroById(id);
	}

	@GetMapping("/libros/nombre/{nombre}")
	public Libro obtenerLibroByNombre(@PathVariable("nombre") String id) {
		return libroService.getLibroByNombre(id);
	}

}
