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
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.AdjuntoLibro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.AdjuntoLibroService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdjuntoLibroControlador {
	
	@Autowired
	private AdjuntoLibroService aLibroService;

	public AdjuntoLibroControlador(AdjuntoLibroService aLibroService) {
		super();
		this.aLibroService = aLibroService;
	}	
	
	@GetMapping("/adjuntosLibros")
	public List<AdjuntoLibro> obtenerAdjLibros()
	{		
	List<AdjuntoLibro> ListaAdjLibros = aLibroService.getAdjuntoLibros();
	return ListaAdjLibros;	
	}	
	
	@PostMapping("/adjuntosLibros")
	public AdjuntoLibro guardarAdjLibro(@RequestBody AdjuntoLibro objAdjLibro) {
		
		return aLibroService.ingresarAdjuntoLibro(objAdjLibro);		
	}
	
	@GetMapping("/adjuntosLibros/{id}")
	public Optional<AdjuntoLibro> obtenerAdjLibroById(@PathVariable("id") Long id) {
		return aLibroService.aLibroById(id);
	}
	
	@GetMapping("/adjuntosLibros/nombre/{nombre}")
	public Optional<AdjuntoLibro> obtenerAdjLibroByNombre(@PathVariable("nombre") String id) {
		return aLibroService.getAdjuntoLibroByNombre(id);
	}
	

}
