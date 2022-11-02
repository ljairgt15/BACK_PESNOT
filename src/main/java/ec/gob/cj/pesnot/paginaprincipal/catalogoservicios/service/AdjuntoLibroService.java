package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.AdjuntoLibro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.AdjuntoLibroRepository;


@Service
public class AdjuntoLibroService {
	public AdjuntoLibroRepository aLibroRepository;
	public AdjuntoLibroService( AdjuntoLibroRepository aLibroRepository) {
		super();
		this.aLibroRepository=aLibroRepository;
	}

	public List<AdjuntoLibro> getAdjuntoLibros() 
	{	
		List<AdjuntoLibro> ListaAdjuntoLibros = new ArrayList<>();	
		ListaAdjuntoLibros = aLibroRepository.findAll();
		return ListaAdjuntoLibros;
	}

	public AdjuntoLibro ingresarAdjuntoLibro(AdjuntoLibro adjuntoLibro) 
	{		
		return  aLibroRepository.save(adjuntoLibro); 		
	}
	public Optional<AdjuntoLibro> getAdjuntoLibroByNombre(String adjuntoLibro) 
	{		
		return  aLibroRepository.getAdjuntoByNombre(adjuntoLibro); 		
	}
	public Optional<AdjuntoLibro> aLibroById(Long idEntrante)
	{		
		return  aLibroRepository.findById(idEntrante);
	}


}
