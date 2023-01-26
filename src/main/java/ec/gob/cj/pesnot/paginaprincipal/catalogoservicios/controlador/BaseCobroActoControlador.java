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
import org.springframework.http.MediaType;

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
	
	@GetMapping(value="/basesCobroActos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List <BaseCobroActo> obtenerBaseCobroActos(){
		return baseCobroService.getBaseCobro();
	}
	
	@GetMapping(value="/basesCobroActos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<BaseCobroActo> obtenerActoPorId(@PathVariable ("id") Long id) {
		
		return baseCobroService.baseById(id);	
	}
	@GetMapping(value="/basesCobroActos/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseCobroActo obtenerBaseCobroByNombre(@PathVariable("nombre") String id) {
		return baseCobroService.getBaseByNombre(id);
	}

	
	@PostMapping(value="/baseCobroActos", produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseCobroActo guardarBaseCobro(@RequestBody BaseCobroActo baseObj) {
		return baseCobroService.ingresarBase(baseObj);
	}
	
	


}
