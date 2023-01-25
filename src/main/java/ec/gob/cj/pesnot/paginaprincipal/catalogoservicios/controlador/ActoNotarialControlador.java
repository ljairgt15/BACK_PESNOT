package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoMotivo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoNotarialService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActoNotarialControlador {
    @Autowired
    private ActoNotarialService actoNotarialService;

    public ActoNotarialControlador(ActoNotarialService actoNotarialService) {
        super();
        this.actoNotarialService = actoNotarialService;
    }

    @GetMapping("/actosNotariales")
    public List<ActoNotarial> obtenerActosNotariales() {

        List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotariales();
        return ListaActosNotariales;

    }

    @GetMapping("/actosNotariales/obtenerTarifaDeMotivosP/{nombreBase}/{nombreLibro}/{nombreActo}/{nombreMotivo}")
    public Double obtenerPrecioMotivoActoP(@PathVariable String nombreBase, @PathVariable String nombreLibro, @PathVariable String nombreActo, @PathVariable String nombreMotivo) {

        return actoNotarialService.getTarifaActosMotivo(nombreBase, nombreLibro, nombreActo, nombreMotivo);
    }

    @GetMapping("/actosNotariales/obtenerTarifaDeMotivos/{idActo}/{idMotivo}")
    public Double obtenerPrecioMotivoActo(@PathVariable String idActo, @PathVariable String idMotivo) {

        return actoNotarialService.getTarifaActosMotivoconId(idActo, idMotivo);
    }

    //TODO EDITAR QUIERO BUSCAR QUE EL ACTO A QUE TABLA PERTENECE Y A QUE RANGO PARA QUE ME DE EL PRECIO

    @GetMapping("/actosNotariales/obtenerTarifaDeTabla/{idActo}/{idTabla}/{idRango}")
    public Double obtenerPrecioTablaActo(@PathVariable String idActo, @PathVariable String idTabla, @PathVariable String idRango) {
        return actoNotarialService.getTarifaActosTablaRango(idActo, idTabla, idRango);
    }

    @GetMapping("/actosNotariales/obtenerTarifa")
    public Double obtenerPrecioGeneral(@RequestParam(name = "usaTablaMotivo", required = true, defaultValue = "true") Boolean usaCalculo, @RequestParam(name = "idActo", required = true, defaultValue = "") Long idActo, @RequestParam(name = "idMotivo", required = false, defaultValue = "null") Long idMotivo, @RequestParam(name = "idTabla", required = false, defaultValue = "") Long idTabla, @RequestParam(name = "idRango", required = false, defaultValue = "") Long idRango) {
        Double precio = null;
        try {
            if (!usaCalculo) {
                System.out.println("Entrando a motivos");
                precio = actoNotarialService.getTarifaActosMotivoconId(idActo.toString(), idMotivo.toString());
            } else {
                System.out.println("Entrando a tabla");
                precio = actoNotarialService.getTarifaActosTablaRango(idActo.toString(), idTabla.toString(), idRango.toString());
            }
            return precio;

        } catch (NullPointerException err) {
            System.out.println("No se puede encontrar la tarifa de dicho catalogo, revise bien los parametros mandados " + err);

        } catch (Exception err) {
            System.out.println("Error general " + err);

        }
        return precio;
    }
	/*
	// Obtener Tarifas ya sea de tabla o tarifa para bpmn
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


    @GetMapping("/actosNotariales/activos")
    public List<ActoNotarial> obtenerActosNotarialesActivos() {

        List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotarialesActivos();
        return ListaActosNotariales;
    }

    @GetMapping("actosNotariales/{id}")
    public Optional<ActoNotarial> obtenerActoNotarialPorId(@PathVariable("id") Long id) {

        return actoNotarialService.getActoNotarialById(id);

    }

    //CON PAT
    @GetMapping("actosNotariales/base/{nombreBase}/libro/{nombreLibro}/nombre/{nombreActo}")
    public ActoNotarial obtenerActoNotarialPorParametros(@PathVariable String nombreBase, @PathVariable String nombreLibro, @PathVariable String nombreActo) {

        return actoNotarialService.getActoByParametros(nombreBase, nombreLibro, nombreActo);
    }

    @GetMapping("actosNotariales/nombre/{nombre}")
    public List<ActoNotarial> obtenerActoLikeNombre(@PathVariable("nombre") String nombre) {

        return actoNotarialService.getActosLike(nombre);

    }

    @GetMapping("actosNotariales/libro/{libro}")
    public List<ActoNotarial> obtenerActoLibro(@PathVariable("libro") String libro) {
        return actoNotarialService.getActosLibros(libro);

    }

    @GetMapping("actosNotariales/tarifasAsociadas")
    public List<ActoNotarial> obtenerActosTarifa() {
        return actoNotarialService.getActosConTarifas();
    }

    @GetMapping("actosNotariales/tarifasGenerales")
    public List<RangoMotivo> obtenerTarifas() {
        return actoNotarialService.getListaMostrar();
    }

    @PostMapping("/actosNotariales")
    public ActoNotarial guardarActNot(@RequestBody ActoNotarial objAct) {

        return actoNotarialService.ingresarActoNotarialL(objAct);
    }
}
