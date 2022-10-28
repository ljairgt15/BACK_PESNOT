package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;



import org.junit.jupiter.api.Test;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Tarifa;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@SpringBootTest
@RunWith(SpringRunner.class)
class TarifaTest {
	
	Tarifa objTarifa = new Tarifa(1l,"String",1,1);
	

	@Test
	void testGetIdTarifa() {
		objTarifa.getIdTarifa();
	}

	@Test
	void testSetIdTarifa() {
		objTarifa.setIdTarifa(1l);
	}

	@Test
	void testGetActo() {
		objTarifa.getActo();
		}

	@Test
	void testSetActo() {
		objTarifa.setActo("Principal");
	}

	@Test
	void testGetIdTipoTarifa() {
		objTarifa.getIdTipoTarifa();
	}

	@Test
	void testSetIdTipoTarifa() {
		objTarifa.setIdTipoTarifa(4);
	}

	@Test
	void testGetIdEstado() {
		objTarifa.getIdEstado();
	}

	@Test
	void testSetIdEstado() {
		objTarifa.setIdEstado(2);
	}

}
