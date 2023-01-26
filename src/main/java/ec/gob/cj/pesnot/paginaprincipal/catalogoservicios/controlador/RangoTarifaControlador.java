package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import java.math.BigDecimal;
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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.RangoTarifaService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RangoTarifaControlador {

	@Autowired
	private RangoTarifaService service;

	public RangoTarifaControlador(RangoTarifaService serviceEntramter) {
		super();
		this.service = serviceEntramter;
	}

	@GetMapping(value="/rangos", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<RangoTarifa> obtenerRangoTarifa() {
		return service.getRangoTarifa();
	}
	
	@GetMapping(value="/rangos/activos", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<RangoTarifa> obtenerRangoTarifaActivos() {
		return service.getRangosActivos();
	}
	
	@GetMapping(value="/rangos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Optional<RangoTarifa> obtenerRangoTarifaById(@PathVariable("id") Long id)
	{
		return service.getRangoTarifaById(id);
	}
	@GetMapping(value="/rangos/maximo/{max}/minimo/{min}", produces = MediaType.APPLICATION_JSON_VALUE)
	private RangoTarifa obtenerRangoTarifaByMinMax(@PathVariable("max") BigDecimal  max, @PathVariable("min")BigDecimal min)
	{
		return service.getRangoTarifaByMinMax(max, min);
	}

	
	@PostMapping(value="/rangos", produces = MediaType.APPLICATION_JSON_VALUE)
	private RangoTarifa ingresarRangoTarifa(@RequestBody RangoTarifa rangoTafEntrante)
	{
		return service.ingresarRangoTarifa(rangoTafEntrante);
		
	}
}
