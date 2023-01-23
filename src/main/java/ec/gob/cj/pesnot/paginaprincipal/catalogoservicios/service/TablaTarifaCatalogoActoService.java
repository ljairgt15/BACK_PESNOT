package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifaCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.TablaTarifaCatalogoActoRepository;

@Service
public class TablaTarifaCatalogoActoService {

	@Autowired
	public TablaTarifaCatalogoActoRepository actoRangoTarifaRepository;

	public List<TablaTarifaCatalogoActo> getActoRangoTarifa() {
		return actoRangoTarifaRepository.findAll();

	}
	public List<TablaTarifaCatalogoActo> getActoRangoTarifaActivos(){
		return actoRangoTarifaRepository.getTablaCatalogoActivos();
	}
	
	public List<TablaTarifaCatalogoActo> getTablasAsociadas(String idCatalogo){
		return actoRangoTarifaRepository.getTablasAsociadasTabla(idCatalogo);
	}
	

	public TablaTarifaCatalogoActo ingresarActoRangoTarifa(TablaTarifaCatalogoActo actoRangoTarifa) {
		return actoRangoTarifaRepository.save(actoRangoTarifa);
	}
	
	@Transactional
	public void deshabilitar(String idCatalogo) {
		actoRangoTarifaRepository.deshabilitar(idCatalogo);
	}

	public Optional<TablaTarifaCatalogoActo> getActoRangoTarifaById(Long id) {

		return actoRangoTarifaRepository.findById(id);
	}
	public TablaTarifaCatalogoActo getTablaActoUnico(String idActo, String idTabla) {
		
		return actoRangoTarifaRepository.getTablaActo(idActo, idTabla);
		
	}
	



}
