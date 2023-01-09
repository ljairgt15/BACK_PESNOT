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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoMotivo;
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
	public List<ActoNotarial> obtenerActosNotariales() {

		List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotariales();
		return ListaActosNotariales;

	}
	
	@GetMapping("/getMotivoCobroActo/{nombreBase}/{nombreClasificacion}/{nombreLibro}/{nombreActo}/{nombreMotivo}")
	public Double obtenerPrecioMotivoCobroActo(@PathVariable String nombreBase,@PathVariable String nombreClasificacion, @PathVariable String nombreLibro, @PathVariable String nombreActo, @PathVariable String nombreMotivo) {

		return actoNotarialService.getTarifaActosMotivo(nombreBase, nombreClasificacion, nombreLibro, nombreActo, nombreMotivo);
	}
	@GetMapping("/getRangoActo/{nombreBase}/{nombreClasificacion}/{nombreLibro}/{nombreActo}/{max}/{min}")
	public Double obtenerPrecioMotivoCobroActo(@PathVariable String nombreBase,@PathVariable String nombreClasificacion, @PathVariable String nombreLibro, @PathVariable String nombreActo, @PathVariable Double max, @PathVariable Double min ) {

		return actoNotarialService.getTarifaActosTabla(nombreBase, nombreClasificacion, nombreLibro, nombreActo, max, min);
	}
	
	@GetMapping("/getActosActivos")
	public List<ActoNotarial> obtenerActosNotarialesActivos() {

		List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotarialesActivos();
		return ListaActosNotariales;
	}

	@GetMapping("getActoById/{id}")
	public Optional<ActoNotarial> obtenerActoNotarialPorId(@PathVariable("id") Long id) {

		return actoNotarialService.getActoNotarialById(id);

	}
	@GetMapping("getActoByParametros/{nombreBase}/{nombreClasificacion}/{nombreLibro}/{nombreActo}")
	public ActoNotarial obtenerActoNotarialPorParametros( @PathVariable String nombreBase,@PathVariable String nombreClasificacion, @PathVariable String nombreLibro, @PathVariable String nombreActo) {

		return actoNotarialService.getActoByParametros(nombreBase, nombreClasificacion, nombreLibro, nombreActo);

	}
	
	@GetMapping("getActosLike/{nombre}")
	public List<ActoNotarial> obtenerActoLikeNombre(@PathVariable("nombre") String nombre) {

		return actoNotarialService.getActosLike(nombre);

	}

	@GetMapping("geActoByLibros/{libro}")
	public List<ActoNotarial> obtenerActoLibro(@PathVariable("libro") String libro) {
		return actoNotarialService.getActosLibros(libro);

	}
	@GetMapping("geActoConTarifas")
	public List<ActoNotarial> obtenerActosTarifa() {
		return actoNotarialService.getActosConTarifas();
	}
	
	@GetMapping("getTarifas")
	public List<RangoMotivo> obtenerTarifas() {
		return actoNotarialService.getActosPrecio();
	}
	
	@PostMapping("/saveActNot")
	public ActoNotarial guardarActNot(@RequestBody ActoNotarial objAct) {
		
		return actoNotarialService.ingresarActoNotarialL(objAct);		
	}
}
