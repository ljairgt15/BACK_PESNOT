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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoRangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoRangoTarifaService;

@RestController
@RequestMapping("ActoRango")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActoRangoControlador {
	@Autowired
	private ActoRangoTarifaService service;

	public ActoRangoControlador(ActoRangoTarifaService serviceEntramter) {
		super();
		this.service = serviceEntramter;
	}

	@GetMapping("/getActoRangoTarifa")
	private List<ActoRangoTarifa> obtenerActoRangoTarifa() {
		return service.getActoRangoTarifa();
	}
	
	@GetMapping("/getActoRangoTarifaById/{id}")
	private Optional<ActoRangoTarifa> obtenerActoRangoTarifaById(@PathVariable("id") Long id)
	{
		return service.getActoRangoTarifaById(id);
	}
	
	@PostMapping("/saveActoRangoTarifa")
	private ActoRangoTarifa ingresarRangoTarifa(@RequestBody ActoRangoTarifa arangoTafEntrante)
	{
		return service.ingresarActoRangoTarifa(arangoTafEntrante);
		
	}
	
}
