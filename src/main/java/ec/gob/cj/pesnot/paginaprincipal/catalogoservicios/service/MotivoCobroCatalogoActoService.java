package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.MotivoCobroCatalogoActoRepository;

@Service
public class MotivoCobroCatalogoActoService {
	
	public MotivoCobroCatalogoActoRepository motivoCatalogoRepo;

	public MotivoCobroCatalogoActoService(MotivoCobroCatalogoActoRepository motivoCatalogoRepoEntrante) {
		super();
		this.motivoCatalogoRepo=motivoCatalogoRepoEntrante;
	}
	
	public List<MotivoCobroCatalogoActo> getMotivoCobroCatalogo(){
		return motivoCatalogoRepo.findAll();
	}
	
	public MotivoCobroCatalogoActo ingresarMotivoCobroCatalogoActo(MotivoCobroCatalogoActo motivo) {
		return motivoCatalogoRepo.save(motivo);
	}
	
	public Optional<MotivoCobroCatalogoActo> getMotivoCobroCatalogoById(Long id){
		return motivoCatalogoRepo.findById(id);
	}
}
