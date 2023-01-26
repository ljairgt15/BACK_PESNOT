package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    @GetMapping(value = "/actosNotariales", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoNotarial> obtenerActosNotariales() {

        List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotariales();
        return ListaActosNotariales;

    }

    @GetMapping(value = "/actosNotariales/obtenerTarifaDeMotivosP/{nombreBase}/{nombreLibro}/{nombreActo}/{nombreMotivo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double obtenerPrecioMotivoActoP(@PathVariable String nombreBase, @PathVariable String nombreLibro, @PathVariable String nombreActo, @PathVariable String nombreMotivo) {

        return actoNotarialService.getTarifaActosMotivo(nombreBase, nombreLibro, nombreActo, nombreMotivo);
    }

    @GetMapping(value = "/actosNotariales/obtenerTarifaDeMotivos/{idActo}/{idMotivo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double obtenerPrecioMotivoActo(@PathVariable String idActo, @PathVariable String idMotivo) {

        return actoNotarialService.getTarifaActosMotivoconId(idActo, idMotivo);
    }


    @GetMapping(value = "/actosNotariales/obtenerTarifaDeTabla/{idActo}/{idTabla}/{idRango}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double obtenerPrecioTablaActo(@PathVariable String idActo, @PathVariable String idTabla, @PathVariable String idRango) {
        return actoNotarialService.getTarifaActosTablaRango(idActo, idTabla, idRango);
    }

    @GetMapping(value = "/actosNotariales/obtenerTarifa", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/actosNotariales/activos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoNotarial> obtenerActosNotarialesActivos() {

        List<ActoNotarial> ListaActosNotariales = actoNotarialService.getActosNotarialesActivos();
        return ListaActosNotariales;
    }

    @GetMapping(value = "actosNotariales/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ActoNotarial> obtenerActoNotarialPorId(@PathVariable("id") Long id) {

        return actoNotarialService.getActoNotarialById(id);

    }

    //CON PAT
    @GetMapping(value = "actosNotariales/base/{nombreBase}/libro/{nombreLibro}/nombre/{nombreActo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActoNotarial obtenerActoNotarialPorParametros(@PathVariable String nombreBase, @PathVariable String nombreLibro, @PathVariable String nombreActo) {

        return actoNotarialService.getActoByParametros(nombreBase, nombreLibro, nombreActo);
    }

    @GetMapping(value = "actosNotariales/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoNotarial> obtenerActoLikeNombre(@PathVariable("nombre") String nombre) {

        return actoNotarialService.getActosLike(nombre);

    }

    @GetMapping(value = "actosNotariales/libro/{libro}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoNotarial> obtenerActoLibro(@PathVariable("libro") String libro) {
        return actoNotarialService.getActosLibros(libro);

    }

    @GetMapping(value = "actosNotariales/tarifasAsociadas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoNotarial> obtenerActosTarifa() {
        return actoNotarialService.getActosConTarifas();
    }

    @GetMapping(value = "actosNotariales/tarifasGenerales", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RangoMotivo> obtenerTarifas() {
        return actoNotarialService.getListaMostrar();
    }

    @PostMapping(value = "/actosNotariales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActoNotarial guardarActNot(@RequestBody ActoNotarial objAct) {

        return actoNotarialService.ingresarActoNotarialL(objAct);
    }
}
