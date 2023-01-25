/*package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.BaseCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.BaseCobroActoControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.BaseCobroActoRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.BaseCobroActoService;


@SpringBootTest
public class BaseCobroActoTest {
	
	@Autowired
	@Spy
	private BaseCobroActoRepository baseRepo = Mockito.mock(BaseCobroActoRepository.class);

	@Autowired
	@Spy
	private BaseCobroActoService baseSvc = Mockito.mock(BaseCobroActoService.class);

	@Autowired
	@Spy
	private BaseCobroActoControlador baseCont = Mockito.mock(BaseCobroActoControlador.class);
	

	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de base cobros y no sea nulo")
	void listarLibros() {
		assertNotNull(baseRepo.findAll());
		assertNotNull(baseSvc.getBaseCobro());
		assertNotNull(baseCont.obtenerBaseCobroActos());
	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga la base de cobro guardado y no sea nulo ")
	void guardarLibro() {

		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		BaseCobroActo base = baseRepo.save(baseObj);

		assertNotNull(base);
		base = baseSvc.ingresarBase(baseObj);
		assertNotNull(base);
		base = baseCont.guardarBaseCobro(baseObj);
		assertNotNull(base);


	}

	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void getLibroById() {

		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		BaseCobroActo base = baseRepo.save(baseObj);
		assertNotNull(baseRepo.findById(base.getIdBaseCobroActo()));
		assertNotNull(baseSvc.baseById(base.getIdBaseCobroActo()));
		assertNotNull(baseCont.obtenerActoPorId(base.getIdBaseCobroActo()))	;
	}
	@Test
	@DisplayName("Debe pasar cuando se obtenga un objeto adjuntosLibro")
	void getLibroByNombre() {
		BaseCobroActo baseObj = new BaseCobroActo();
		baseObj.setNombreBaseCobroActo("por acto");
		baseObj.setDescripcionBaseCobroActo("por acto notarial");
		baseObj.setEstadoBaseCobroActo(true);
		BaseCobroActo base = baseRepo.save(baseObj);
		assertNotNull(baseRepo.getBaseActoByNombre(base.getNombreBaseCobroActo()));
		assertNotNull(baseSvc.getActoByNombre(base.getNombreBaseCobroActo()));
		assertNotNull(baseCont.obtenerBaseCobroByNombre(base.getNombreBaseCobroActo()));

	}

	@Test
	@DisplayName("La prueba pasa cuando se instancia lo relacionado al modelo")
	void modeloAdjuntoLibro() {
		BaseCobroActo baseObj1 = new BaseCobroActo(new Long(1),"nuvo","asa",true);
		BaseCobroActo baseObj = new BaseCobroActo("nuvo","asa",true);
		baseObj.setDescripcionBaseCobroActo("ddd");
		baseObj.setNombreBaseCobroActo("adjuntoGuardado!");
		baseObj.setIdBaseCobroActo(new Long(1));
		baseObj.setEstadoBaseCobroActo(false);
		baseObj.getDescripcionBaseCobroActo();
		baseObj.isEstadoBaseCobroActo();
	}

}
*/
