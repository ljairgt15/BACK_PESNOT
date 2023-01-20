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
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.TablaTarifaService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TablaTarifaControlador {
	
	@Autowired
	TablaTarifaService service;
	
	
	@GetMapping("/getTabla")
	public List<TablaTarifa> getAll(){
		return service.getTablas();
	}
	
	@GetMapping("/getRangoTarifaActivos")
	public List<TablaTarifa> getAllActivos(){
		return service.getTablasActivas();
	}
	
	@GetMapping("/getTablaById/{id}")
	private Optional<TablaTarifa> obtenerTablaById(@PathVariable("id") Long id)
	{
		return service.getTablaById(id);
	}
	
	@GetMapping("/getTabla/{nombre}")
	private TablaTarifa obtenerByNombre(@PathVariable("nombre") String  nombre)
	{
		return service.getUnicoByNombre(nombre);
	}
	
	@PostMapping("/saveTablaTarifa")
	private TablaTarifa ingresarTabla (@RequestBody  TablaTarifa entrante)
	{
		return service.ingresarTabla(entrante);
		
	}
}
