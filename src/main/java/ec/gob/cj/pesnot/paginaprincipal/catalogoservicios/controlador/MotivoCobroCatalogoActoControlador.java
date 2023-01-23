package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

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

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.MotivoCobroCatalogoActoService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MotivoCobroCatalogoActoControlador {

	@Autowired
	private MotivoCobroCatalogoActoService motivoSvc;

	public MotivoCobroCatalogoActoControlador(MotivoCobroCatalogoActoService motivoCobroActoEntrante) {

		super();
		this.motivoSvc = motivoCobroActoEntrante;

	}

	@GetMapping("/motivosCobroActos")
	public List<MotivoCobroCatalogoActo> getMotivoCobroCatalogo() {

		return motivoSvc.getMotivoCobroCatalogo();
	}
	@GetMapping("/motivoActos/acto/{id}")
	public List<MotivoCobroCatalogoActo> getMotivosAsociadas(@PathVariable("id") String id){
		return motivoSvc.getMotivosAsociadas(id);
	}
	


	@GetMapping("/motivosCobroActos/{id}")
	public Optional<MotivoCobroCatalogoActo> getMotivoCobroCatalogoById(@PathVariable("id") Long id) {
		return motivoSvc.getMotivoCobroCatalogoById(id);
	}

	@PostMapping("/motivosCobroActos")
	public MotivoCobroCatalogoActo guardarMotivoCobroCatalogoActo(@RequestBody MotivoCobroCatalogoActo motivo) {
		return motivoSvc.ingresarMotivoCobroCatalogoActo(motivo);

	}

	@GetMapping("/motivosCobroActos/desactivar/{id}")
	public void deshabilitar(@PathVariable("id") String id) {
		motivoSvc.deshabilitar(id);
	}

}
