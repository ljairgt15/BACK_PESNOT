package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.TablaTarifaCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.MotivoCobroCatalogoActoRepository;

@Service
public class MotivoCobroCatalogoActoService {
	@Autowired
	public MotivoCobroCatalogoActoRepository motivoCatalogoRepo;
	
	public MotivoCobroCatalogoActoService(MotivoCobroCatalogoActoRepository motivoCatalogoRepoEntrante) {
		super();
		this.motivoCatalogoRepo=motivoCatalogoRepoEntrante;
	}
	
	public List<MotivoCobroCatalogoActo> getMotivoCobroCatalogo(){
		return motivoCatalogoRepo.findAll();
	}
	public List<MotivoCobroCatalogoActo> getMotivosAsociadas(String idCatalogo){
		return  motivoCatalogoRepo.getMotivosAsociadasTabla(idCatalogo);
	}
	
	public MotivoCobroCatalogoActo ingresarMotivoCobroCatalogoActo(MotivoCobroCatalogoActo motivo) {
		return motivoCatalogoRepo.save(motivo);
	}
	
	public Optional<MotivoCobroCatalogoActo> getMotivoCobroCatalogoById(Long id){
		return motivoCatalogoRepo.findById(id);
	}
	
	public MotivoCobroCatalogoActo getTarifa(String idActo, String idMotivo) {
		
		return motivoCatalogoRepo.getActoMotivoUnico(idActo, idMotivo);
		
	}
	

	
	@Transactional
	public void deshabilitar(String idCatalogo) {
		motivoCatalogoRepo.deshabilitar(idCatalogo);
	}
}
