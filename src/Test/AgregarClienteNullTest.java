package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Servicio.ClienteServicio;
import Vista.Menu;

public class AgregarClienteNullTest {

	@Test
	public void test1() {

		Servicio.ClienteServicio.agregarCliente(null, "JUAN", "PEREZ", "44 años");

		assertTrue(Menu.existeCliente(null, ClienteServicio.getListaClientes()) == -1);

	}

	@Test
	public void test2() {

		Servicio.ClienteServicio.agregarCliente("9323281-K", null, "PEREZ", "44 años");

		assertTrue(Menu.existeCliente("9323281-K", ClienteServicio.getListaClientes()) == -1);
	}

	@Test
	public void test3() {

		Servicio.ClienteServicio.agregarCliente("9323281-K", "JUAN", null, "44 años");

		assertTrue(Menu.existeCliente("9323281-K", ClienteServicio.getListaClientes()) == -1);

	}

	@Test
	public void test4() {

		Servicio.ClienteServicio.agregarCliente("9323281-K", "JUAN", "PEREZ", null);

		assertTrue(Menu.existeCliente("9323281-K", ClienteServicio.getListaClientes()) == -1);

	}

}
