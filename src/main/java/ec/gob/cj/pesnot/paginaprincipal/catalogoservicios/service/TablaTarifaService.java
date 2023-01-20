package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.TablaTarifaRepository;

@Service
public class TablaTarifaService {
	
	@Autowired
	TablaTarifaRepository tablaTarifaRepo;
	
	public List <TablaTarifa> getTablas(){
		return tablaTarifaRepo.findAll();
	}
	public List<TablaTarifa> getTablasActivas(){
		return tablaTarifaRepo.getTablaTarifaActivos();
	}
	
	public Optional<TablaTarifa> getTablaById(Long id) {
		return tablaTarifaRepo.findById(id);
	}
	
	public TablaTarifa ingresarTabla(TablaTarifa tablaEntrante) {
		return tablaTarifaRepo.save(tablaEntrante);
	}
	
	public TablaTarifa getUnicoByNombre(String nombre) {
		return tablaTarifaRepo.getTablaByNombre(nombre);
	}
	
}
