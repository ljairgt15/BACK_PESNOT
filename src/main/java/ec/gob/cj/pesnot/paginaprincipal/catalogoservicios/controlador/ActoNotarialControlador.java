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

	public ActoNotarialControlador(ActoNotarialService actoNotarialService) {
		super();
		this.actoNotarialService = actoNotarialService;
	}

	@GetMapping("/getActos")
	public List<ActoNotarial> obtenerActosNotariales() {

		List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotariales();
		return ListaActosNotariales;

	}

	@GetMapping("/getMotivoCobroActo/{nombreBase}/{nombreLibro}/{nombreActo}/{nombreMotivo}")
	public Double obtenerPrecioMotivoCobroActo(@PathVariable String nombreBase,
			 @PathVariable String nombreLibro, @PathVariable String nombreActo,
			@PathVariable String nombreMotivo) {

		return actoNotarialService.getTarifaActosMotivo(nombreBase, nombreLibro, nombreActo,
				nombreMotivo);
	}
	/*
	//BODY
	@PostMapping("geTarifaMotivo/")
	public Double obtenerActoNotarialPorParametros(@RequestBody ActoNotarial acto, @PathVariable String nombreActo) {

		return actoNotarialService.getTarifaActosMotivoconActo(acto, nombreActo);
	}
	*/
	
	//TODO EDITAR QUIERO BUSCAR QUE EL ACTO A QUE TABLA PERTENECE Y A QUE RANGO PARA QUE ME DE EL PRECIO
	/*
	@GetMapping("/getRangoActo/{nombreBase}/{nombreLibro}/{nombreActo}/{max}/{min}")
	public Double obtenerPrecioMotivoCobroActo(@PathVariable String nombreBase,
			 @PathVariable String nombreLibro, @PathVariable String nombreActo,
			@PathVariable BigDecimal max, @PathVariable BigDecimal min) {

		return actoNotarialService.getTarifaActosTabla(nombreBase, nombreLibro, nombreActo, max,
				min);
	}
	
	
	//TODO EDITAR TARIFAS
	@GetMapping("/getTarifaGeneral")
	public Double obtenerPrecioGeneral(
			@RequestParam(name = "boolean", required = true, defaultValue = "null") Boolean usaCalculo,
			@RequestParam(name = "base", required = true, defaultValue = "null") String nombreBase,
			@RequestParam(name = "libro", required = true, defaultValue = "null") String nombreLibro,
			@RequestParam(name = "acto", required = true, defaultValue = "null") String nombreActo,
			@RequestParam(name = "motivo", required = false, defaultValue = "null") String nombreMotivo,
			@RequestParam(name = "max", required = false, defaultValue = "0") BigDecimal max,
			@RequestParam(name = "min", required = false, defaultValue = "0") BigDecimal min) {
		Double precio = null;
		try {
			ActoNotarial actoBuscado = actoNotarialService.getActoByParametros(nombreBase,
					nombreLibro, nombreActo);
			if (actoBuscado == null) {
				precio = null;
				System.out.print("no se pudo");
			} else {
				if (usaCalculo) {
					BigDecimal maximo = max.setScale(4, RoundingMode.UP);
					BigDecimal minimo = min.setScale(4, RoundingMode.UP);
					System.out.println("rango controlador" + maximo);
					System.out.println("rango controlador" + minimo);
					//TODO EN ESTE DEBIA HABER UN SERVICIO QUE RECORRA EL OTRO CAMINO QUE SE TIENE
					precio = actoNotarialService.getTarifaActosTablaConActo(actoBuscado, maximo, minimo);
				} else {
					precio = actoNotarialService.getTarifaActosMotivoconActo(actoBuscado, nombreMotivo);

				}
				return precio;
			}
			return precio;
		} catch (NullPointerException err) {
			System.out.println("No se puede encontrar la tarifa de dicho catalogo, revise bien los parametros mandados " + err);

		}
		return precio;
	}
	*/

	@GetMapping("/getActosActivos")
	public List<ActoNotarial> obtenerActosNotarialesActivos() {

		List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotarialesActivos();
		return ListaActosNotariales;
	}

	@GetMapping("getActoById/{id}")
	public Optional<ActoNotarial> obtenerActoNotarialPorId(@PathVariable("id") Long id) {

		return actoNotarialService.getActoNotarialById(id);

	}
	
	//CON PAT 
	@GetMapping("getActoByParametros/{nombreBase}/{nombreLibro}/{nombreActo}")
	public ActoNotarial obtenerActoNotarialPorParametros(@PathVariable String nombreBase,
			 @PathVariable String nombreLibro,
			@PathVariable String nombreActo) {

		return actoNotarialService.getActoByParametros(nombreBase, nombreLibro, nombreActo);
	}
	
	/*
	//PRUEBA CON BODY
	
	@PostMapping("getActoByParametros")
	// @ResponseBody
	public ActoNotarial obtenerActoNotarialPorParametrosII(@RequestBody String nombreBase,
			 @RequestBody String nombreLibro, @RequestBody String nombreActo) {
		// public ActoNotarial obtenerActoNotarialPorParametrosII(
		// @RequestParam(required=true) String nombreBase,@RequestParam(required=true)
		// String nombreClasificacion, @RequestParam(required=true) String nombreLibro,
		// @RequestParam(required=true) String nombreActo) {

		return actoNotarialService.getActoByParametros(nombreBase, nombreLibro, nombreActo);
	}
	*/

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
		return actoNotarialService.getListaMostrar();
	}

	@PostMapping("/saveActNot")
	public ActoNotarial guardarActNot(@RequestBody ActoNotarial objAct) {

		return actoNotarialService.ingresarActoNotarialL(objAct);
	}
}
