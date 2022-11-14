package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Spy;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.AdjuntoLibro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.AdjuntoLibroControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.AdjuntoLibroRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.AdjuntoLibroService;

@SpringBootTest
public class AdjLibroTest {
	@Autowired
	@Spy
	private AdjuntoLibroRepository adjLibroRepo = Mockito.mock(AdjuntoLibroRepository.class);

	@Autowired
	@Spy
	private AdjuntoLibroService adjLibroSvc = Mockito.mock(AdjuntoLibroService.class);

	@Autowired
	@Spy
	private AdjuntoLibroControlador adjLibroCont = Mockito.mock(AdjuntoLibroControlador.class);

	@Mock
	private SpringApplicationBuilder springApplicationBuilder;

	@Test
	public void main() {
		BackPesnotApplication.main(new String[] {});
	}

	@Test
	public void testIt() {
		BackPesnotApplication notificacionesApplication = new BackPesnotApplication();
		when(springApplicationBuilder.sources(BackPesnotApplication.class)).thenReturn(springApplicationBuilder);

		SpringApplicationBuilder result = notificacionesApplication.configure(springApplicationBuilder);

		verify(springApplicationBuilder).sources(BackPesnotApplication.class);
		assertEquals(springApplicationBuilder, result);
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de adjuntosLibro y no sea nulo")
	void listarAdjuntos() {
		assertNotNull(adjLibroRepo.findAll());
		assertNotNull(adjLibroSvc.getAdjuntoLibros());
		assertNotNull(adjLibroCont.obtenerAdjLibros());
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga el adjuntoLibro guardado y no sea ")
	void guardarAdjunto() {

		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		AdjuntoLibro adjuntoGuardadoR;
		adjLibroCont.guardarAdjLibro(adjuntoGuardado);
		adjLibroSvc.ingresarAdjuntoLibro(adjuntoGuardado);
		adjuntoGuardadoR = adjLibroRepo.save(adjuntoGuardado);
		assertNotNull(adjuntoGuardadoR);
		adjuntoGuardadoR = adjLibroSvc.ingresarAdjuntoLibro(adjuntoGuardado);
		assertNotNull(adjuntoGuardadoR);
		adjuntoGuardadoR = adjLibroCont.guardarAdjLibro(adjuntoGuardado);
		assertNotNull(adjuntoGuardadoR);


	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void obtenerAdjuntoPorId() {
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		AdjuntoLibro adjuntoGuardadoR;
		adjLibroCont.guardarAdjLibro(adjuntoGuardado);
		adjLibroSvc.ingresarAdjuntoLibro(adjuntoGuardado);
		adjuntoGuardadoR = adjLibroRepo.save(adjuntoGuardado);
		assertNotNull(adjLibroRepo.findById(adjuntoGuardadoR.getIdAdjuntoLibro()));
		assertNotNull(adjLibroSvc.aLibroById(adjuntoGuardadoR.getIdAdjuntoLibro()));
		assertNotNull(adjLibroCont.obtenerAdjLibroById(adjuntoGuardadoR.getIdAdjuntoLibro()));
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void obtenerAdjuntoPorNombre() {
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro();
		adjuntoGuardado.setNombreAdjuntoLibro("nuevo");
		adjuntoGuardado.setArchivoAdjuntoLibro((byte) 1);
		adjuntoGuardado.setObservacionAdjuntoLibro("111");
		AdjuntoLibro adjuntoGuardadoR;
		adjLibroCont.guardarAdjLibro(adjuntoGuardado);
		adjLibroSvc.ingresarAdjuntoLibro(adjuntoGuardado);
		adjuntoGuardadoR = adjLibroRepo.save(adjuntoGuardado);
		assertNotNull(adjLibroRepo.getAdjuntoByNombre(adjuntoGuardadoR.getNombreAdjuntoLibro()));
		assertNotNull(adjLibroSvc.getAdjuntoLibroByNombre(adjuntoGuardadoR.getNombreAdjuntoLibro()));
		assertNotNull(adjLibroCont.obtenerAdjLibroByNombre(adjuntoGuardadoR.getNombreAdjuntoLibro()));
	}

	@Test
	@DisplayName("La prueba pasa cuando se instancie todo lo relacionado al modelo")
	void modeloAdjuntoLibro() {
		Byte jair = (byte) 1;
		AdjuntoLibro adjuntoGuardado = new AdjuntoLibro(1l, "nombre", jair, "111");
		adjuntoGuardado.setIdAdjuntoLibro(2l);
		adjuntoGuardado.getArchivoAdjuntoLibro();
		adjuntoGuardado.getIdAdjuntoLibro();
		adjuntoGuardado.getNombreAdjuntoLibro();
		adjuntoGuardado.getObservacionAdjuntoLibro();
		adjuntoGuardado.toString();
	}

}
