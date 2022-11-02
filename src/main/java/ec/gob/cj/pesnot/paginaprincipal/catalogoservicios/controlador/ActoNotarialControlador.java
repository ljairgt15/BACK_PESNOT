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
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RequisitoActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoNotarialService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.RequisitoActoNotarialService;

@RestController
@RequestMapping("ActoNotarial")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActoNotarialControlador {

	@Autowired
	private ActoNotarialService actoNotarialService;
	@Autowired
	private RequisitoActoNotarialService requisitoActoNotarialService;

	public ActoNotarialControlador(ActoNotarialService actoNotarialService,
			RequisitoActoNotarialService requisitoActoNotarialService) {
		super();
		this.actoNotarialService = actoNotarialService;
		this.requisitoActoNotarialService = requisitoActoNotarialService;
	}

	@GetMapping("/getActos")
	public List<ActoNotarial> getActosNotariales() {

		List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotariales();
		return ListaActosNotariales;

	}
	

	@GetMapping("getActoById/{id}")
	public ActoNotarial getActoNotarialTarifa(@PathVariable("id") Long id) {

		return actoNotarialService.getActoNotarialTarifa(id);

	}
	//TODO no esta implementado nada en el repositorio


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
