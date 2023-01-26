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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifaCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.TablaTarifaCatalogoActoService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TablaTarifaCatalogoActoControlador {
	
	@Autowired
	TablaTarifaCatalogoActoService service;
	
	public TablaTarifaCatalogoActoControlador(TablaTarifaCatalogoActoService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value="/tablaActos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TablaTarifaCatalogoActo> getAll(){
		
		return service.getActoRangoTarifa();
	}
	
	@GetMapping(value="/tablaActos/activos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TablaTarifaCatalogoActo> getAllActivos(){
		return service.getActoRangoTarifaActivos();
	}
	@GetMapping(value="/tablaActos/acto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TablaTarifaCatalogoActo> getTablasAsociadas(@PathVariable("id") String id){
		return service.getTablasAsociadas(id);
	}
	
	
	@GetMapping(value="/tablaActos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Optional<TablaTarifaCatalogoActo> obtenerRangoTarifaById(@PathVariable("id") Long id)
	{
		return service.getActoRangoTarifaById(id);
	}
	
	@GetMapping(value="/tablaActos/tabla/{idTabla}/acto/{idCatalogo}", produces = MediaType.APPLICATION_JSON_VALUE)
	private TablaTarifaCatalogoActo getTablaTarifaCatalogoActo(@PathVariable("idTabla") String idTabla, @PathVariable("idCatalogo") String idCatalogo) {
		return service.getTablaActoUnico(idCatalogo, idTabla);
	}
	
	@PostMapping(value="/tablaActos", produces = MediaType.APPLICATION_JSON_VALUE)
	private TablaTarifaCatalogoActo ingresarTablaTarifaCatalogoActo(@RequestBody  TablaTarifaCatalogoActo entrante)
	{
		return service.ingresarActoRangoTarifa(entrante);
		
	}
	
	@GetMapping(value="tablaActos/desactivar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deshabilitar(@PathVariable("id") String id) {
		service.deshabilitar(id);
	}
	

}
