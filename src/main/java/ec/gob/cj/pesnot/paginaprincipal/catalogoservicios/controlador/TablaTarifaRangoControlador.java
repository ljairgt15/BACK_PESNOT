package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifaRango;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.TablaTarifaRangoService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TablaTarifaRangoControlador {
	
	
	@Autowired
	TablaTarifaRangoService service;
	
	
	@GetMapping(value="/tablaRangos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TablaTarifaRango> getAll(){
		return service.getTablasConRangos();
		
	}
	
	@GetMapping(value="/tablaRangos/activos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TablaTarifaRango> getActivos(){
		return service.getTablasRangosActivos();
		
	}
	@GetMapping(value="/tablaRangos/tabla/{idTabla}", produces = MediaType.APPLICATION_JSON_VALUE)
	private List <TablaTarifaRango> getTablaRangoUnico(@PathVariable("idTabla") String idTabla){
		return service.getTablaConRangos(idTabla);
	}
	
	@GetMapping(value="/tablaRangos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Optional<TablaTarifaRango> obtenerTablaRangoTarifaById(@PathVariable("id") Long id)
	{
		return service.getTablaRangosById(id); 
	}
	@GetMapping(value="/tablaRangos/desactivar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deshabilitar(@PathVariable("id") String id) {
		service.deshabilitar(id);
	}
	
	@GetMapping(value="/tablaRangos/tabla/{idTabla}/rango/{idRango}")
	private TablaTarifaRango getTablaRangoUnico(@PathVariable("idTabla") String idTabla, @PathVariable("idRango") String idRango) {
		return service.getTablaRangoUnico(idTabla, idRango);
	}
	

	
	@PostMapping(value="/tablaRangos", produces = MediaType.APPLICATION_JSON_VALUE)
	private TablaTarifaRango ingresarTablaRangoTarifa(@RequestBody TablaTarifaRango entrante)
	{
		return service.ingresarTablasRango(entrante);
		
	}
}
