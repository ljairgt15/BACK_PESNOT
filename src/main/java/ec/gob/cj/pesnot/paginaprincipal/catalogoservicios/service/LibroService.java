package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.LibroRepository;

@Service
public class LibroService {	
	
	public LibroRepository libroRepository;	
	
	public LibroService(LibroRepository libroRepository) {
		super();
		this.libroRepository = libroRepository;
	}

	public List<Libro> getLibros() 
	{	
		List<Libro> ListaLibros = new ArrayList<>();	
		ListaLibros = libroRepository.findAll();
		return ListaLibros;
	}

	public Libro ingresarLibrosL(Libro libro) 
	{		
		return  libroRepository.save(libro); 		
	}
	public Optional<Libro> libroById(Long idEntrante)
	{		
		return  libroRepository.findById(idEntrante);
	}


}
