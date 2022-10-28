package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Acto;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Tarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.TarifaService;





@RestController
@RequestMapping("api/v3")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class ActoControlador {
	
	
	
	@Autowired
	public ActoService actoService;
	
	
	@Autowired
	public TarifaService tarifaService;
	
	
	
	public ActoControlador(ActoService actoService, TarifaService tarifaService) {
		super();
		this.actoService = actoService;
		this.tarifaService = tarifaService;
	}



	@RequestMapping(path = "/actos", method= RequestMethod.GET)
	public List<Acto> getListaActos()
	{
		
	List<Acto> ListaActos = actoService.getActos();
	
	return ListaActos;
	
	}
	
	
	@RequestMapping(path = "/tarifa", method= RequestMethod.GET)
	public List<Tarifa> getListaTarifa()
	{
		
	List<Tarifa> ListaTarifa = tarifaService.getTarifa();
	
	return ListaTarifa;
	
	}
	
	
	
	@PostMapping("/saveActos")
	public Acto guardarActos(@RequestBody Acto objActo) {
		
		
		return actoService.saveActo(objActo);
		
	}
	
	
	
	
	@PostMapping("/saveTarifa")
	public Tarifa guardarActos(@RequestBody Tarifa tarifa) {
		
		
		return tarifaService.ingresarTarifa(tarifa);
		
	}
	


}
