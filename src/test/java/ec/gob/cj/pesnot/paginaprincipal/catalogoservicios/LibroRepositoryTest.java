package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.LibroRepository;
@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class LibroRepositoryTest {
	
@Autowired
public LibroRepository libroR;


@Test
private void testGuardarLibro() {
	


//	Libro librotest = new Libro(1l,"Auditivo",1,1,"Solo Creacion");
	
//	libroR.save(librotest);

}

}
