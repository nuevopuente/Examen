package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Servicio.ClienteServicio;
import Vista.Menu;

public class agregarClienteTest {

	@Test
	public void test() {

		Servicio.ClienteServicio.agregarCliente("9323281-K", "SDSDS", "SDSDSD", "44");

		assertTrue(Menu.existeCliente("9323281-K", ClienteServicio.getListaClientes()) > -1);

	}

}
