package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RequisitoActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoNotarialService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.RequisitoActoNotarialService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class ActoNotarialControlador {
	
	@Autowired
	private ActoNotarialService  actoNotarialService;
	@Autowired
	private RequisitoActoNotarialService requisitoActoNotarialService;
	
	
	
	public ActoNotarialControlador(ActoNotarialService actoNotarialService,
			RequisitoActoNotarialService requisitoActoNotarialService) {
		super();
		this.actoNotarialService = actoNotarialService;
		this.requisitoActoNotarialService = requisitoActoNotarialService;
	}
	
	
	
	@RequestMapping(path = "/actos", method= RequestMethod.GET)
	public List<ActoNotarial> getActosNotariales()
	{
		
		List<ActoNotarial> ListaActosNotariales=actoNotarialService.getActosNotariales();
		return ListaActosNotariales;
		
	}
	
	
	
	
	@GetMapping(path = "requisitos/{id}")
	public List<RequisitoActoNotarial> ListaRequisitosActos(@PathVariable Long id)
	{

		return requisitoActoNotarialService.getRequisitosActosNotarialesId(id);

	}
	
	
	
	
@GetMapping (path ="tarifa/{id}")
public ActoNotarial  getActoNotarialTarifa(@PathVariable Long id)
{

return actoNotarialService.getActoNotarialTarifa(id);

}



@GetMapping(path = "actosNotariales/{nombre}")
public List<ActoNotarial> getActoNotarialNombre(@PathVariable String nombre){
	
	
	return actoNotarialService.getActoNotarialNombre(nombre);
	
}



@GetMapping(path = "actosLike/{nombre}")
public List<ActoNotarial> getActoLik(@PathVariable String nombre) {
	
	return actoNotarialService.getActosLike(nombre);


}



@GetMapping(path = "libros/{libro}")
public List<ActoNotarial> getActoLibro(@PathVariable String libro)
{
	return actoNotarialService.getActosLibros(libro);
	

}






}
