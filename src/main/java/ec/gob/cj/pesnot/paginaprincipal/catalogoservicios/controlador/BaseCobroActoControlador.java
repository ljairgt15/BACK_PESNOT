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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.BaseCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.BaseCobroActoService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BaseCobroActoControlador {
	
	@Autowired
	private BaseCobroActoService baseCobroService;
	
	public BaseCobroActoControlador(BaseCobroActoService baseCobroServiceEntrante
			) {
		super();
		this.baseCobroService=baseCobroServiceEntrante;
	}
	
	@GetMapping("/BaseCobroActo")
	public List <BaseCobroActo> obtenerBaseCobroActos(){
		return baseCobroService.getBaseCobro();
	}
	
	@GetMapping("/BaseCobroActo/{id}")
	public Optional<BaseCobroActo> obtenerActoPorId(@PathVariable ("id") Long id) {
		
		return baseCobroService.baseById(id);	
	}
	@GetMapping("/BaseCobroActo/nombre/{nombre}")
	public BaseCobroActo obtenerBaseCobroByNombre(@PathVariable("nombre") String id) {
		return baseCobroService.getBaseByNombre(id);
	}

	
	@PostMapping("/BaseCobroActo")
	public BaseCobroActo guardarBaseCobro(@RequestBody BaseCobroActo baseObj) {
		return baseCobroService.ingresarBase(baseObj);
	}
	
	


}
