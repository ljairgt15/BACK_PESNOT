package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoRangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.MotivoCobroCatalogoActoRepository;

@Service
public class MotivoCobroCatalogoActoService {
	
	public MotivoCobroCatalogoActoRepository motivoCatalogoRepo;
	

	@Autowired
	private MotivoCobroActoService motivoCobroActoSvc;
	
	
	@Autowired
	private ActoNotarialService actoNotarialSvc;

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
	
	public Double getTarifaActosMotivo( String nombreBase, String nombreClasificacion, String nombreLibro, String nombreActo, String nombreMotivo) {
		ActoNotarial actoBuscado=actoNotarialSvc.getActoByParametros(nombreBase, nombreClasificacion, nombreLibro, nombreActo);
		MotivoCobroActo motivoBuscado= motivoCobroActoSvc.getMotivoUnico(nombreMotivo);
		MotivoCobroCatalogoActo actoMotivoBuscado= new MotivoCobroCatalogoActo();
		String idActo= actoBuscado.getIdCatalogoActoNotarial().toString();
		String idMotivo= motivoBuscado.getIdMotivoCobroActo().toString();
		actoMotivoBuscado= motivoCatalogoRepo.getActoMotivoUnico(idActo, idMotivo);
		return actoMotivoBuscado.getValorMotivoCobroCatalogoActo();

	}
	
	@Transactional
	public void deshabilitar(String idCatalogo) {
		motivoCatalogoRepo.deshabilitar(idCatalogo);
	}
}
