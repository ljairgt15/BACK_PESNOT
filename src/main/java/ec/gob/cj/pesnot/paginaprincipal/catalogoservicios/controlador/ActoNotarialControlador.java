package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoNotarialService;

@RestController
@RequestMapping("ActoNotarial")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActoNotarialControlador {
	@Autowired
	private ActoNotarialService actoNotarialService;


	public ActoNotarialControlador(ActoNotarialService actoNotarialService
			) {
		super();
		this.actoNotarialService = actoNotarialService;
	}

	@GetMapping("/getActos")
	public List<ActoNotarial> getActosNotariales() {

		List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotariales();
		return ListaActosNotariales;

	}

	@GetMapping("getActoById/{id}")
	public ActoNotarial getActoNotarialById(@PathVariable("id") Long id) {

		return actoNotarialService.getActoNotarialById(id);

	}
	@GetMapping("getActosLike/{nombre}")
	public List<ActoNotarial> getActoLik(@PathVariable("nombre") String nombre) {

		return actoNotarialService.getActosLike(nombre);

	}

	@GetMapping("geActoByLibros/{libro}")
	public List<ActoNotarial> getActoLibro(@PathVariable("libro") String libro) {
		return actoNotarialService.getActosLibros(libro);

	}
	@PostMapping("/saveActNot")
	public ActoNotarial guardarActNot(@RequestBody ActoNotarial objAct) {
		
		return actoNotarialService.ingresarActoNotarialL(objAct);		
	}
}
