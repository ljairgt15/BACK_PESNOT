package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoRangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ActoRangoTarifaRepository;

@Service
public class ActoRangoTarifaService {

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

}
