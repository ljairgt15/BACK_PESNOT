package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Spy;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador.AdjuntoLibroControlador;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.modelo.Catalogo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.AdjuntoLibroRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.AdjuntoLibroService;

@SpringBootTest
public class AdjLibroTest {
	@Autowired
	@Spy
	private AdjuntoLibroRepository adjLibroRepo = Mockito.mock(AdjuntoLibroRepository.class);
	
	@Autowired
	@Spy
	private AdjuntoLibroService adjLibroservice = Mockito.mock(AdjuntoLibroService.class);
	
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
	    assertEquals(springApplicationBuilder,result);
	  }

    @Test
    @DisplayName("Debe pasar cuando se obtenga una lista de adjuntosLibro y no sea nulo")
    void listarAdjuntos() {
        assertNotNull(adjLibroRepo.findAll());
    }
    

	
	
	

}
