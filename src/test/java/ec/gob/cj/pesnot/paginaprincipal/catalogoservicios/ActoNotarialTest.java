/*package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.AdjuntoLibro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.BaseCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.ActoNotarialControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.AdjuntoLibroControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.BaseCobroActoControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.LibroControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ActoNotarialRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.AdjuntoLibroRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.BaseCobroActoRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.LibroRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoNotarialService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.AdjuntoLibroService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.BaseCobroActoService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.LibroService;

@SpringBootTest
public class ActoNotarialTest {

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
	@DisplayName("Debe pasar cuando se obtenga una lista no nula de actos")
	void listarActos() {
		assertNotNull(actNotRepo.findAll());
		assertNotNull(actNotSvc.getActosNotariales());
		assertNotNull(actNotCont.obtenerActosNotariales());
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista no nula de actos")
	void guardarActos() {
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
		assertNotNull(actoNot);
		actoNot = actNotSvc.ingresarActoNotarialL(actoNot);
		assertNotNull(actoNot);
		actoNot = actNotCont.guardarActNot(actoNot);
		assertNotNull(actoNot);
	}

	@Test

	@DisplayName("Debe pasar cuado se obtenga la lista de actos por id")
	void getActoNotById() {

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
		assertNotNull(actNotRepo.findById(actoNot.getIdCatalogoActoNotarial()));
		assertNotNull(actNotSvc.getActoNotarialById(actoNot.getIdCatalogoActoNotarial()));
		assertNotNull(actNotCont.obtenerActoNotarialPorId(actoNot.getIdCatalogoActoNotarial()));

	}

	@Test

	@DisplayName("Debe pasar cuado se obtenga la lista de actos por nombre")
	void getActoNotByNombre() {
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		baseObj=baseRepo.save(baseObj);
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
		assertNotNull(actNotRepo.getActosLike(actoNot.getNombreCatalogoActoNotarial()));
		assertNotNull(actNotSvc.getActosLike(actoNot.getNombreCatalogoActoNotarial()));
		assertNotNull(actNotCont.obtenerActoLikeNombre(actoNot.getNombreCatalogoActoNotarial()));
	}

	@Test

	@DisplayName("Debe pasar cuado se obtenga la lista de actos por nombre")
	void getActoNotByLibro() {
		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		baseObj=baseRepo.save(baseObj);
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
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
		assertNotNull(actNotRepo.getActosByIdLibro(libroGuardado.getIdTipoLibro().toString()));
		assertNotNull(actNotSvc.getActosLibros(libroGuardado.getIdTipoLibro().toString()));
		assertNotNull(actNotCont.obtenerActoLibro(libroGuardado.getIdTipoLibro().toString()));
	}

	@Test

	@DisplayName("Debe pasar cuado se obtenga la lista de actos por nombre")
	void getLibroConActos() {
		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		baseObj=baseRepo.save(baseObj);
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
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
		assertNotNull(libroRepo.getAllLibrosWithActosN());
		assertNotNull(libroSvc.getLibrosWithActN());
		assertNotNull(libroCont.obtenerLibrosConActosN());

	}

	@Test

	@DisplayName("Debe pasar cuando se prueba el modelo")
	void probarModelo() {
		Libro libro = new Libro();
		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		baseObj=baseRepo.save(baseObj);
		/*ActoNotarial acto = new ActoNotarial(1l, baseObj, libro, "iar", "art 24", true, 2l, 2l, true, true, true, 12.50,
				true);
		acto.setIdCatalogoActoNotarial(4l);
		acto.toString();
		acto.getArticuloCatalogoActoNotarial();
		acto.getEstadoCatalogoActoNotarial();
		acto.getGravaIvaCatalogoActoNotarial();
		acto.getHabilitanteCiudadanoCatalogoActoNotarial();
		acto.getIdBaseCobroActo();
		acto.getIdCatalogoActoNotarial();
		acto.getIdTipoLibro();
		acto.getNombreCatalogoActoNotarial();
		acto.getTramiteUnilateralCatalogoActoNotarial();
		acto.getValorExoneracionCatalogoActoNotarial();
		acto.getValorExtraCatalogoActoNotarial();
		acto.getTarifaCatalogoActoNotarial();
		acto.getUsaCalculoTablaCatalogoActoNotarial();
		acto.setTarifaCatalogoActoNotarial(null);
		acto.setUsaCalculoTablaCatalogoActoNotarial(null);
	}

}
*/

