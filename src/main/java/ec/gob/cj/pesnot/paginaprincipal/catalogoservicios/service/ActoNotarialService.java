package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ActoNotarialRepository;


@Service
public class ActoNotarialService {	
	
	public ActoNotarialRepository actoNotarialRepository;
	
	
	public ActoNotarialService(ActoNotarialRepository actoNotarialRepository) {
		super();
		this.actoNotarialRepository = actoNotarialRepository;
	}
	
		
	public List<ActoNotarial> getActosNotariales()
     {		
		List<ActoNotarial> ListActosNotariales= new ArrayList<>();
		
		ListActosNotariales= actoNotarialRepository.findAll();
				
	    return ListActosNotariales;		
     }
	public List<ActoNotarial> getActosNotarialesActivos()
    {		
		List<ActoNotarial> ListActosNotariales= new ArrayList<>();
		
		ListActosNotariales= actoNotarialRepository.getActosActivos();
				
	    return ListActosNotariales;		
    }
	
	public List<ActoNotarial> getActosConTarifas()
    {		
		List<ActoNotarial> ListActosNotariales= new ArrayList<>();
		
		ListActosNotariales= actoNotarialRepository.getActosConTarifa();
				
	    return ListActosNotariales;		
    }
	
	public ActoNotarial ingresarActoNotarialL(ActoNotarial actNot) 
	{		
		return  actoNotarialRepository.save(actNot); 		
	}
	
	public Optional<ActoNotarial> getActoNotarialById(Long id) {		
		
		Optional<ActoNotarial> actoNotarialTarifa= actoNotarialRepository.findById(id);
		
			return actoNotarialTarifa;
	}	
	


	public List<ActoNotarial>getActosLike(String nombre) {		
			
			List<ActoNotarial> ListaLike = new ArrayList<>();
			
			ListaLike = actoNotarialRepository.getActosLike(nombre);
			
			return ListaLike;			
		}
	
	public List<ActoNotarial> getActosLibros(String libro) {
		
		List<ActoNotarial> ListaActosLibros = new ArrayList<>();
		
		ListaActosLibros = actoNotarialRepository.getActosByIdLibro(libro);
		
		return ListaActosLibros;		
	}
}
