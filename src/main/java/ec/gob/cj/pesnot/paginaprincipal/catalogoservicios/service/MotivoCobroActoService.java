package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.MotivoCobroActoRepository;

@Service
public class MotivoCobroActoService {

	public MotivoCobroActoRepository motivoRepo;

	public MotivoCobroActoService(MotivoCobroActoRepository motivoRepoEntrante) {
		super();
		this.motivoRepo = motivoRepoEntrante;
	}

	public List<MotivoCobroActo> getMotivoCobroActo() {

		return motivoRepo.findAll();
	}

	public MotivoCobroActo ingresarMotivoCobroActo(MotivoCobroActo motivoObj) {

		return motivoRepo.save(motivoObj);

	}

	public Optional<MotivoCobroActo> getMotivoCobroActoLike(String nombre) {

		return motivoRepo.getMotivoCobroByNombre(nombre);
	}

	public Optional<MotivoCobroActo> getMotivoCobroActoById(Long id) {

		return motivoRepo.findById(id);

	}

}
