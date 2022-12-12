package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.AdjuntoLibro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.BaseCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.ActoNotarialControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.AdjuntoLibroControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.BaseCobroActoControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.LibroControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.MotivoCobroActoControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.MotivoCobroCatalogoActoControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ActoNotarialRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.AdjuntoLibroRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.BaseCobroActoRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.LibroRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.MotivoCobroActoRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.MotivoCobroCatalogoActoRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoNotarialService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.AdjuntoLibroService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.BaseCobroActoService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.LibroService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.MotivoCobroActoService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.MotivoCobroCatalogoActoService;

public class MotivoCobroCatalogoActoTest {
	@Autowired
	@Spy
	private MotivoCobroActoRepository motivoRepo = Mockito.mock(MotivoCobroActoRepository.class);

	@Autowired
	@Spy
	private MotivoCobroActoService motivoSvc = Mockito.mock(MotivoCobroActoService.class);

	@Autowired
	@Spy
	private MotivoCobroActoControlador motivoCont = Mockito.mock(MotivoCobroActoControlador.class);

	@Autowired
	@Spy
	private MotivoCobroCatalogoActoRepository motivoCatRepo = Mockito.mock(MotivoCobroCatalogoActoRepository.class);

	@Autowired
	@Spy
	private MotivoCobroCatalogoActoService motivoCatSvc = Mockito.mock(MotivoCobroCatalogoActoService.class);

	@Autowired
	@Spy
	private MotivoCobroCatalogoActoControlador motivoCatCont = Mockito.mock(MotivoCobroCatalogoActoControlador.class);

	@Autowired
	@Spy
	private BaseCobroActoRepository baseRepo = Mockito.mock(BaseCobroActoRepository.class);

	@Autowired
	@Spy
	private BaseCobroActoService baseSvc = Mockito.mock(BaseCobroActoService.class);

	@Autowired
	@Spy
	private BaseCobroActoControlador baseCont = Mockito.mock(BaseCobroActoControlador.class);

	@Autowired
	@Spy
	private AdjuntoLibroRepository adjLibroRepo = Mockito.mock(AdjuntoLibroRepository.class);

	@Autowired
	@Spy
	private AdjuntoLibroService adjLibroSvc = Mockito.mock(AdjuntoLibroService.class);

	@Autowired
	@Spy
	private AdjuntoLibroControlador adjLibroCont = Mockito.mock(AdjuntoLibroControlador.class);

	@Autowired
	@Spy
	private LibroRepository libroRepo = Mockito.mock(LibroRepository.class);

	@Autowired
	@Spy
	private LibroService libroSvc = Mockito.mock(LibroService.class);

	@Autowired
	@Spy
	private LibroControlador libroCont = Mockito.mock(LibroControlador.class);

	@Autowired
	@Spy
	private ActoNotarialRepository actNotRepo = Mockito.mock(ActoNotarialRepository.class);
	@Autowired
	@Spy
	private ActoNotarialService actNotSvc = Mockito.mock(ActoNotarialService.class);

	@Autowired
	@Spy
	private ActoNotarialControlador actNotCont = Mockito.mock(ActoNotarialControlador.class);

	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de base cobros y no sea nulo")
	void listarLibros() {
		assertNotNull(motivoCatRepo.findAll());
		assertNotNull(motivoCatSvc.getMotivoCobroCatalogo());
		assertNotNull(motivoCatCont.getMotivoCobroCatalogo());
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga la base de cobro guardado y no sea nulo ")
	void guardarLibro() {

		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		baseObj = baseRepo.save(baseObj);
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		adjuntoGuardado = adjLibroRepo.save(adjuntoGuardado);
		Libro libroGuardado = new Libro();
		libroGuardado.setIdAdjuntoLibro(adjuntoGuardado);
		libroGuardado.setEstadoActivo(false);
		libroGuardado.setIdTipoLibro(1l);
		libroGuardado.setNombreTipoLibro("jair");
		libroGuardado = libroRepo.save(libroGuardado);
		ActoNotarial actoNot = new ActoNotarial();
		actoNot.setArticuloCatalogoActoNotarial("art 22");
		actoNot.setEstadoCatalogoActoNotarial(false);
		actoNot.setGravaIvaCatalogoActoNotarial(true);
		actoNot.setHabilitanteCiudadanoCatalogoActoNotarial(false);
		actoNot.setIdBaseCobroActo(baseObj);
		actoNot.setIdTipoLibro(libroGuardado);
		actoNot.setNombreCatalogoActoNotarial("multas");
		actoNot.setTramiteUnilateralCatalogoActoNotarial(true);
		actoNot.setValorExoneracionCatalogoActoNotarial(1l);
		actoNot.setValorExtraCatalogoActoNotarial(1l);
		actoNot = actNotRepo.save(actoNot);

		MotivoCobroActo motivo = new MotivoCobroActo();
		motivo.setNombreMotivoCobroActo(null);
		motivo.setDescripcionMotivoCobroActo(null);
		motivo.setEstadoMotivoCobroActo(true);
		MotivoCobroActo motivoS = motivoRepo.save(motivo);

		MotivoCobroCatalogoActo motivoCat = new MotivoCobroCatalogoActo();
		motivoCat.setEstadoMotivoCobroCatalogoActo(true);
		motivoCat.setPorcentajeMotivoCobroCatalogoActo(new Double(10));
		motivoCat.setValorMotivoCobroCatalogoActo(new Double(40));
		motivoCat.setIdCatalogoActoNotarial(actoNot);
		motivoCat.setIdMotivoCobroActo(motivoS);
		MotivoCobroCatalogoActo motivoNot = motivoCatRepo.save(motivoCat);
		assertNotNull(motivoNot);
		motivoNot = motivoCatSvc.ingresarMotivoCobroCatalogoActo(motivoCat);
		assertNotNull(actoNot);
		motivoNot = motivoCatCont.guardarMotivoCobroCatalogoActo(motivoCat);
		assertNotNull(actoNot);

	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void getLibroById() {

		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		baseObj = baseRepo.save(baseObj);
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		adjuntoGuardado = adjLibroRepo.save(adjuntoGuardado);
		Libro libroGuardado = new Libro();
		libroGuardado.setIdAdjuntoLibro(adjuntoGuardado);
		libroGuardado.setEstadoActivo(false);
		libroGuardado.setIdTipoLibro(1l);
		libroGuardado.setNombreTipoLibro("jair");
		libroGuardado = libroRepo.save(libroGuardado);
		ActoNotarial actoNot = new ActoNotarial();
		actoNot.setArticuloCatalogoActoNotarial("art 22");
		actoNot.setEstadoCatalogoActoNotarial(false);
		actoNot.setGravaIvaCatalogoActoNotarial(true);
		actoNot.setHabilitanteCiudadanoCatalogoActoNotarial(false);
		actoNot.setIdBaseCobroActo(baseObj);
		actoNot.setIdTipoLibro(libroGuardado);
		actoNot.setNombreCatalogoActoNotarial("multas");
		actoNot.setTramiteUnilateralCatalogoActoNotarial(true);
		actoNot.setValorExoneracionCatalogoActoNotarial(1l);
		actoNot.setValorExtraCatalogoActoNotarial(1l);
		actoNot = actNotRepo.save(actoNot);

		MotivoCobroActo motivo = new MotivoCobroActo();
		motivo.setNombreMotivoCobroActo(null);
		motivo.setDescripcionMotivoCobroActo(null);
		motivo.setEstadoMotivoCobroActo(true);
		MotivoCobroActo motivoS = motivoRepo.save(motivo);

		MotivoCobroCatalogoActo motivoCat = new MotivoCobroCatalogoActo();
		motivoCat.setEstadoMotivoCobroCatalogoActo(true);
		motivoCat.setPorcentajeMotivoCobroCatalogoActo(new Double(10));
		motivoCat.setValorMotivoCobroCatalogoActo(new Double(40));
		motivoCat.setIdCatalogoActoNotarial(actoNot);
		motivoCat.setIdMotivoCobroActo(motivoS);

		assertNotNull(actNotRepo.findById(actoNot.getIdCatalogoActoNotarial()));
		assertNotNull(actNotSvc.getActoNotarialById(actoNot.getIdCatalogoActoNotarial()));
		assertNotNull(actNotCont.obtenerActoNotarialPorId(actoNot.getIdCatalogoActoNotarial()));
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void desha() {
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		baseObj = baseRepo.save(baseObj);
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		adjuntoGuardado = adjLibroRepo.save(adjuntoGuardado);
		Libro libroGuardado = new Libro();
		libroGuardado.setIdAdjuntoLibro(adjuntoGuardado);
		libroGuardado.setEstadoActivo(false);
		libroGuardado.setIdTipoLibro(1l);
		libroGuardado.setNombreTipoLibro("jair");
		libroGuardado = libroRepo.save(libroGuardado);
		ActoNotarial actoNot = new ActoNotarial();
		actoNot.setArticuloCatalogoActoNotarial("art 22");
		actoNot.setEstadoCatalogoActoNotarial(false);
		actoNot.setGravaIvaCatalogoActoNotarial(true);
		actoNot.setHabilitanteCiudadanoCatalogoActoNotarial(false);
		actoNot.setIdBaseCobroActo(baseObj);
		actoNot.setIdTipoLibro(libroGuardado);
		actoNot.setNombreCatalogoActoNotarial("multas");
		actoNot.setTramiteUnilateralCatalogoActoNotarial(true);
		actoNot.setValorExoneracionCatalogoActoNotarial(1l);
		actoNot.setValorExtraCatalogoActoNotarial(1l);
		actoNot = actNotRepo.save(actoNot);

		MotivoCobroActo motivo = new MotivoCobroActo();
		motivo.setNombreMotivoCobroActo(null);
		motivo.setDescripcionMotivoCobroActo(null);
		motivo.setEstadoMotivoCobroActo(true);
		MotivoCobroActo motivoS = motivoRepo.save(motivo);

		MotivoCobroCatalogoActo motivoCat = new MotivoCobroCatalogoActo();
		motivoCat.setEstadoMotivoCobroCatalogoActo(true);
		motivoCat.setPorcentajeMotivoCobroCatalogoActo(new Double(10));
		motivoCat.setValorMotivoCobroCatalogoActo(new Double(40));
		motivoCat.setIdCatalogoActoNotarial(actoNot);
		motivoCat.setIdMotivoCobroActo(motivoS);
		
		assertNotNull(motivoCatRepo.findById(motivoCat.getIdMotivoCobroCatalogoActo()));
		assertNotNull(motivoCatSvc.getMotivoCobroCatalogoById(motivoCat.getIdMotivoCobroCatalogoActo()));
		assertNotNull(motivoCatCont.getMotivoCobroCatalogoById(motivoCat.getIdMotivoCobroCatalogoActo()));

	}

	@Test
	@DisplayName("La prueba pasa cuando se instancie todo lo relacionado al modelo")
	void modeloAdjuntoLibro() {
		MotivoCobroActo motivo = new MotivoCobroActo();
		motivo.setNombreMotivoCobroActo(null);
		motivo.setDescripcionMotivoCobroActo(null);
		motivo.setEstadoMotivoCobroActo(true);
		MotivoCobroActo motivoS = motivoRepo.save(motivo);
	}

}
