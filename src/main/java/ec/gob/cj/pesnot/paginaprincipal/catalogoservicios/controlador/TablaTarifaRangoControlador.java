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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifaRango;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.TablaTarifaRangoService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TablaTarifaRangoControlador {
	
	
	@Autowired
	TablaTarifaRangoService service;
	
	
	@GetMapping("/tablaRangos")
	public List<TablaTarifaRango> getAll(){
		return service.getTablasConRangos();
		
	}
	
	@GetMapping("/tablaRangos/activos")
	public List<TablaTarifaRango> getActivos(){
		return service.getTablasRangosActivos();
		
	}
	@GetMapping("/tablaRangos/tabla/{idTabla}")
	private List <TablaTarifaRango> getTablaRangoUnico(@PathVariable("idTabla") String idTabla){
		return service.getTablaConRangos(idTabla);
	}
	
	@GetMapping("/tablaRangos/{id}")
	private Optional<TablaTarifaRango> obtenerTablaRangoTarifaById(@PathVariable("id") Long id)
	{
		return service.getTablaRangosById(id); 
	}
	@GetMapping("/tablaRangos/desactivar/{id}")
	public void deshabilitar(@PathVariable("id") String id) {
		service.deshabilitar(id);
	}
	
	@GetMapping("/tablaRangos/tabla/{idTabla}/rango/{idRango}")
	private TablaTarifaRango getTablaRangoUnico(@PathVariable("idTabla") String idTabla, @PathVariable("idRango") String idRango) {
		return service.getTablaRangoUnico(idTabla, idRango);
	}
	

	
	@PostMapping("/tablaRangos")
	private TablaTarifaRango ingresarTablaRangoTarifa(@RequestBody TablaTarifaRango entrante)
	{
		return service.ingresarTablasRango(entrante);
		
	}
}
