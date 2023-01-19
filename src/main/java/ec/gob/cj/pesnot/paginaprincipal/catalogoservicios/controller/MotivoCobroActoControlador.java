package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.MotivoCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.MotivoCobroActoService;

@RestController
@RequestMapping("MotivoCobroActo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MotivoCobroActoControlador {

	@Autowired
	private MotivoCobroActoService motivoCobroActoSvc;

	public MotivoCobroActoControlador(MotivoCobroActoService motivoCobroActoEntrante) {
		super();
		this.motivoCobroActoSvc = motivoCobroActoEntrante;

	}

	@GetMapping("/getMotivoCobroActo")
	public List<MotivoCobroActo> obtenerMotivoCobroActo() {

		return motivoCobroActoSvc.getMotivoCobroActo();
	}
	
	@PostMapping("/saveMotivoCobroActo")
	public MotivoCobroActo guardarMotivoCobroActo(@RequestBody MotivoCobroActo motivoCobroAdj) {

		return motivoCobroActoSvc.ingresarMotivoCobroActo(motivoCobroAdj);
	}

	@GetMapping("/getMotivoCobroActoById/{id}")
	public Optional<MotivoCobroActo> obtenerMotivoCobroActoPorId(@PathVariable("id") Long id) {

		return motivoCobroActoSvc.getMotivoCobroActoById(id);
	}

	@GetMapping("/getMotivoCobroActoByNombre/{nombre}")
	public Optional<MotivoCobroActo> obtenerMotivoCobroActoPorNombre(@PathVariable("nombre") String nombre){
		
		return motivoCobroActoSvc.getMotivoCobroActoLike(nombre);
	}
	

	@GetMapping("/getMotivoCobroActoUnico/{nombre}")
	public MotivoCobroActo obtenerMotivoCobroActoUnico(@PathVariable("nombre") String nombre){
		
		return motivoCobroActoSvc.getMotivoUnico(nombre);
	}
	
	
	
	
	

}
