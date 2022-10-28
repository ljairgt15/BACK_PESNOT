package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Acto;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ActoRepository;

@Service
public class ActoService {	
	
	public ActoRepository actoRepository;
		
	public ActoService(ActoRepository actoRepository) {
		super();
		this.actoRepository = actoRepository;
	}

	public List<Acto> getActos()
	
	{
		List<Acto> ListaActos = new ArrayList<>();
		
		ListaActos= actoRepository.getActos();
		
		return ListaActos;	
	}	
	
	public Acto saveActo(Acto objActo) {
		
		return actoRepository.save(objActo);		
	}	
}
