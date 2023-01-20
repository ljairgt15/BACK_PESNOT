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
	
	@GetMapping("/getTablaActo")
	public List<TablaTarifaCatalogoActo> getAll(){
		
		return service.getActoRangoTarifa();
	}
	
	@GetMapping("/getTablaActoActivos")
	public List<TablaTarifaCatalogoActo> getAllActivos(){
		return service.getActoRangoTarifaActivos();
	}
	
	@GetMapping("/getTablaCatalogo/{id}")
	private Optional<TablaTarifaCatalogoActo> obtenerRangoTarifaById(@PathVariable("id") Long id)
	{
		return service.getActoRangoTarifaById(id);
	}
	
	@GetMapping("/getTablaCatalogoUnico/{idTabla}/{idCatalogo}")
	private TablaTarifaCatalogoActo getTablaTarifaCatalogoActo(@PathVariable("idTabla") String idTabla, @PathVariable("idCatalogo") String idCatalogo) {
		return service.getTablaActoUnico(idCatalogo, idTabla);
	}
	
	@PostMapping("/saveRangoTarifa")
	private TablaTarifaCatalogoActo ingresarTablaTarifaCatalogoActo(@RequestBody  TablaTarifaCatalogoActo entrante)
	{
		return service.ingresarActoRangoTarifa(entrante);
		
	}
	
	@GetMapping("/actualizar/{id}")
	public void deshabilitar(@PathVariable("id") String id) {
		service.deshabilitar(id);
	}

}
