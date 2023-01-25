/*package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.BaseCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.MotivoCobroActoControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.MotivoCobroActoRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.MotivoCobroActoService;

@SpringBootTest
public class MotivoCobroActoTest {

	@Autowired
	@Spy
	private MotivoCobroActoRepository motivoRepo = Mockito.mock(MotivoCobroActoRepository.class);

	@Autowired
	@Spy
	private MotivoCobroActoService motivoSvc = Mockito.mock(MotivoCobroActoService.class);

	@Autowired
	@Spy
	private MotivoCobroActoControlador motivoCont = Mockito.mock(MotivoCobroActoControlador.class);

	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de base cobros y no sea nulo")
	void listarLibros() {
		assertNotNull(motivoRepo.findAll());
		assertNotNull(motivoSvc.getMotivoCobroActo());
		assertNotNull(motivoCont.obtenerMotivoCobroActo());
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga la base de cobro guardado y no sea nulo ")
	void guardarLibro() {

		MotivoCobroActo motivo = new MotivoCobroActo();
		motivo.setNombreMotivoCobroActo(null);
		motivo.setDescripcionMotivoCobroActo(null);
		motivo.setEstadoMotivoCobroActo(true);
		MotivoCobroActo motivoS = motivoRepo.save(motivo);

		assertNotNull(motivoS);
		motivoS = motivoSvc.ingresarMotivoCobroActo(motivo);
		assertNotNull(motivoS);
		motivoS = motivoCont.guardarMotivoCobroActo(motivoS);
		assertNotNull(motivoS);

	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void getLibroById() {

		MotivoCobroActo motivo = new MotivoCobroActo();
		motivo.setNombreMotivoCobroActo(null);
		motivo.setDescripcionMotivoCobroActo(null);
		motivo.setEstadoMotivoCobroActo(true);
		MotivoCobroActo motivoS = motivoRepo.save(motivo);
		assertNotNull(motivoRepo.findById(motivoS.getIdMotivoCobroActo()));
		assertNotNull(motivoSvc.getMotivoCobroActoById(motivoS.getIdMotivoCobroActo()));
		assertNotNull(motivoCont.obtenerMotivoCobroActoPorId(motivoS.getIdMotivoCobroActo()));
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void getLibroByNombre() {
		MotivoCobroActo motivo = new MotivoCobroActo();
		motivo.setNombreMotivoCobroActo(null);
		motivo.setDescripcionMotivoCobroActo(null);
		motivo.setEstadoMotivoCobroActo(true);
		MotivoCobroActo motivoS = motivoRepo.save(motivo);
		assertNotNull(motivoRepo.getMotivoCobroByNombre(motivoS.getNombreMotivoCobroActo()));
		assertNotNull(motivoSvc.getMotivoCobroActoLike(motivoS.getNombreMotivoCobroActo()));
		assertNotNull(motivoCont.obtenerMotivoCobroActoPorNombre(motivoS.getNombreMotivoCobroActo()));

	}

	@Test
	@DisplayName("La prueba pasa cuando se instancia lo relacionado al modelo")
	void modeloAdjuntoLibro() {
		MotivoCobroActo motivo = new MotivoCobroActo(new Long(1), "no", "aa", true);

		motivo.setIdMotivoCobroActo(null);
		motivo.getDescripcionMotivoCobroActo();
		motivo.getEstadoMotivoCobroActo();
		motivo.toString();
	}
}
*/
