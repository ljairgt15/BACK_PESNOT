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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ClasificacionNumeroIntervinienteActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ClasificacionNumeroIntervenienteActoService;

@RestController
@RequestMapping("Clasificacion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClasificacionNumeroIntervenienteActoControlador {
	
	@Autowired
	private ClasificacionNumeroIntervenienteActoService clasificacionSvc;
	
	public ClasificacionNumeroIntervenienteActoControlador(ClasificacionNumeroIntervenienteActoService ServiceEntrante
			) {
		super();
		this.clasificacionSvc=ServiceEntrante;
	}
	
	@GetMapping("/getClasificacion")
	public List <ClasificacionNumeroIntervinienteActo> obtenerBaseCobroActos(){
		return clasificacionSvc.getBaseCobro();
	}
	
	@GetMapping("/getClasificacionById/{id}")
	public Optional<ClasificacionNumeroIntervinienteActo> obtenerActoPorId(@PathVariable ("id") Long id) {
		
		return clasificacionSvc.baseById(id);	
	}
	
	@GetMapping("/getClasificacionByNombre/{nombre}")
	public ClasificacionNumeroIntervinienteActo obtenerobtenerClasifiacionByNombre(@PathVariable("nombre") String nombre) {
		return clasificacionSvc.getClasificacionByNombre(nombre);
	}
	
	@PostMapping("/saveClasificacion")
	public ClasificacionNumeroIntervinienteActo guardarBaseCobro(@RequestBody ClasificacionNumeroIntervinienteActo baseObj) {
		return clasificacionSvc.ingresarBase(baseObj);
	}

}
