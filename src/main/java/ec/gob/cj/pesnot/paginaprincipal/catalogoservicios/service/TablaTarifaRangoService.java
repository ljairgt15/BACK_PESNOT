package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.TablaTarifaRangoRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifaRango;

@Service
public class TablaTarifaRangoService {
	
	@Autowired
	TablaTarifaRangoRepository repoTablaRango;
	
	public List<TablaTarifaRango> getTablasConRangos(){
		return repoTablaRango.findAll();
	}
	
	public List<TablaTarifaRango> getTablasRangosActivos(){
		return repoTablaRango.getTablaRangoActivos();
	}
	
	public Optional<TablaTarifaRango> getTablaRangosById(Long id ) {
		return repoTablaRango.findById(id);
	}
	
	public TablaTarifaRango ingresarTablasRango(TablaTarifaRango tablaRangos) {
		return repoTablaRango.save(tablaRangos);
	}
	
	@Transactional
	public void deshabilitar(String idTabla) {
		repoTablaRango.deshabilitar(idTabla);
	}
	
	public TablaTarifaRango getTablaRangoUnico(String idTabla, String idRango) {
		return repoTablaRango.getTablaRangoUnico(idTabla, idRango);
	}
	
	public List<TablaTarifaRango> getTablaConRangos(String idTabla) {
		return repoTablaRango.getTablaUnicaConRango(idTabla);

	}


}
