/*package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.AdjuntoLibro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.AdjuntoLibroControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.LibroControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.AdjuntoLibroRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.LibroRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.AdjuntoLibroService;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.LibroService;



@SpringBootTest
@RunWith(SpringRunner.class)
class LibroTest {
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
	

	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de Libro y no sea nulo")
	void listarLibros() {
		assertNotNull(libroRepo.findAll());
		assertNotNull(libroSvc.getLibros());
		assertNotNull(libroCont.obtenerLibros());
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga el Libro guardado y no sea ")
	void guardarLibro() {
		
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		adjuntoGuardado=adjLibroRepo.save(adjuntoGuardado);
		Libro libroGuardado= new Libro();
		libroGuardado.setIdAdjuntoLibro(adjuntoGuardado);
		libroGuardado.setEstadoActivo(false);
		libroGuardado.setIdTipoLibro(1l);
		libroGuardado.setNombreTipoLibro("jair");
		Libro libroGuardadoR;
		libroGuardadoR = libroRepo.save(libroGuardado);
		assertNotNull(libroGuardadoR);
		libroGuardadoR = libroSvc.ingresarLibrosL(libroGuardado);
		assertNotNull(libroGuardadoR);
		libroGuardadoR = libroCont.guardarLibro(libroGuardadoR);
		assertNotNull(libroGuardadoR);


	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void getLibroById() {
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		adjuntoGuardado=adjLibroRepo.save(adjuntoGuardado);
		Libro libroGuardado= new Libro();
		libroGuardado.setIdAdjuntoLibro(adjuntoGuardado);
		libroGuardado.setEstadoActivo(false);
		libroGuardado.setIdTipoLibro(1l);
		libroGuardado.setNombreTipoLibro("jair");
		Libro libroGuardadoR=libroRepo.save(libroGuardado);
		assertNotNull(libroRepo.findById(libroGuardadoR.getIdTipoLibro()));
		assertNotNull(libroSvc.libroById(libroGuardadoR.getIdTipoLibro()));
		assertNotNull(libroCont.obtenerLibroById(libroGuardadoR.getIdTipoLibro()));		
	}
	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void getLibrosActivos() {
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		adjuntoGuardado=adjLibroRepo.save(adjuntoGuardado);
		Libro libroGuardado= new Libro();
		libroGuardado.setIdAdjuntoLibro(adjuntoGuardado);
		libroGuardado.setEstadoActivo(true);
		libroGuardado.setIdTipoLibro(1l);
		libroGuardado.setNombreTipoLibro("jair");
		libroRepo.save(libroGuardado);
		assertNotNull(libroRepo.getAllActives());
		assertNotNull(libroSvc.getLibrosActivos());
		assertNotNull(libroCont.obtenerLibrosActivos());

	}
	

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void getLibroByNombre() {
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		adjuntoGuardado=adjLibroRepo.save(adjuntoGuardado);
		Libro libroGuardado= new Libro();
		libroGuardado.setIdAdjuntoLibro(adjuntoGuardado);
		libroGuardado.setEstadoActivo(false);
		libroGuardado.setIdTipoLibro(1l);
		libroGuardado.setNombreTipoLibro("jair");
		Libro libroGuardadoR=libroRepo.save(libroGuardado);
		assertNotNull(libroRepo.getLibroByNombre(libroGuardadoR.getNombreTipoLibro()));
		assertNotNull(libroSvc.getLibroByNombre(libroGuardadoR.getNombreTipoLibro()));
		assertNotNull(libroCont.obtenerLibroByNombre(libroGuardadoR.getNombreTipoLibro()));		
	}

	@Test
	@DisplayName("La prueba pasa cuando se instancia lo relacionado al modelo")
	void modeloAdjuntoLibro() {
		Byte jair = (byte) 1;
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro(1l, "nombre", jair, "111");
		Libro Libro= new Libro(1l,adjuntoGuardado,"cra",true);
		Libro.getIdAdjuntoLibro();
		Libro.getIdTipoLibro();
		Libro.getNombreTipoLibro();
		Libro.isEstadoActivo();
		Libro.setIdTipoLibro(1l);
		Libro.toString();
	}
	
	
}
*/
