package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ClasificacionNumeroIntervinienteActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ClasificacionNumeroIntervenienteActoRepository;

@Service
public class ClasificacionNumeroIntervenienteActoService {
	
	public ClasificacionNumeroIntervenienteActoRepository clasifiacionNumeroIntervenienteActoRepository;

	public ClasificacionNumeroIntervenienteActoService(ClasificacionNumeroIntervenienteActoRepository clasifiacionNumeroIntervenienteActoRepository) {
		super();
		this.clasifiacionNumeroIntervenienteActoRepository=clasifiacionNumeroIntervenienteActoRepository;
	}

	public List<ClasificacionNumeroIntervinienteActo> getBaseCobro() {
		return clasifiacionNumeroIntervenienteActoRepository.findAll();
	}

	public Optional<ClasificacionNumeroIntervinienteActo> baseById(Long idEntrante) {
		return clasifiacionNumeroIntervenienteActoRepository.findById(idEntrante);
	}

	public ClasificacionNumeroIntervinienteActo ingresarBase(ClasificacionNumeroIntervinienteActo baseActo) {
		return clasifiacionNumeroIntervenienteActoRepository.save(baseActo);
	}
	public ClasificacionNumeroIntervinienteActo getClasificacionByNombre(String clasificacionNombre) {
		return clasifiacionNumeroIntervenienteActoRepository.getClasificacionByNombre(clasificacionNombre);
	}

}
