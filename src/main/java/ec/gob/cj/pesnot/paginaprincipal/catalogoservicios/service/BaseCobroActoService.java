package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.BaseCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.BaseCobroActoRepository;

@Service
public class BaseCobroActoService {

	public BaseCobroActoRepository baseRepository;

	public BaseCobroActoService(BaseCobroActoRepository baserepository) {
		super();
		this.baseRepository = baserepository;
	}

	public List<BaseCobroActo> getBaseCobro() {
		return baseRepository.findAll();
	}

	public Optional<BaseCobroActo> baseById(Long idEntrante) {
		return baseRepository.findById(idEntrante);
	}

	public BaseCobroActo ingresarBase(BaseCobroActo baseActo) {
		return baseRepository.save(baseActo);
	}

	public Optional<BaseCobroActo> getActoByNombre(String id) {
		return baseRepository.getBaseActoByNombre(id);
	}

}
