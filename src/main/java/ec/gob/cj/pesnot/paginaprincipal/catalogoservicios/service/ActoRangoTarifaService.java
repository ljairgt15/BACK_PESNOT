package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoRangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ActoRangoTarifaRepository;

@Service
public class ActoRangoTarifaService {
	@Autowired
	private RangoTarifaService rangoSvc;
	
	@Autowired
	private ActoNotarialService actoNotarialSvc;

	public ActoRangoTarifaRepository actoRangoTarifaRepository;

	public ActoRangoTarifaService(ActoRangoTarifaRepository actoRangoTarifaEntrante) {
		super();
		this.actoRangoTarifaRepository = actoRangoTarifaEntrante;
	}

	public List<ActoRangoTarifa> getActoRangoTarifa() {
		return actoRangoTarifaRepository.findAll();

	}

	public ActoRangoTarifa ingresarActoRangoTarifa(ActoRangoTarifa actoRangoTarifa) {
		return actoRangoTarifaRepository.save(actoRangoTarifa);
	}
	
	@Transactional
	public void deshabilitar(String idCatalogo) {
		actoRangoTarifaRepository.deshabilitar(idCatalogo);
	}

	public Optional<ActoRangoTarifa> getActoRangoTarifaById(Long id) {

		return actoRangoTarifaRepository.findById(id);
	}
	
	public Double getTarifaActosTabla( String nombreBase, String nombreClasificacion, String nombreLibro, String nombreActo, Double max, Double min) {
		ActoNotarial actoBuscado=actoNotarialSvc.getActoByParametros(nombreBase, nombreClasificacion, nombreLibro, nombreActo);
		RangoTarifa rangoBuscado= rangoSvc.getRangoTarifaByMinMax(max, min);
		ActoRangoTarifa actoRangoBuscado= new ActoRangoTarifa();
		String idActo= actoBuscado.getIdCatalogoActoNotarial().toString();
		String idRango= rangoBuscado.getIdRangoTarifa().toString();
		actoRangoBuscado= actoRangoTarifaRepository.getActoRangoUnico(idActo,idRango);
		return actoRangoBuscado.getPorcentajeActoRangoTarifa()*425;

	}

}
