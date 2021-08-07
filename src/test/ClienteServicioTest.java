package test;

import static org.junit.Assert.*;

import org.junit.Test;

import servicio.ClienteServicio;

public class ClienteServicioTest {

	
	@Test
	public void agregarClienteTest() {
		
		ClienteServicio clienteServicio = new ClienteServicio();
		String agregarClienteRes = clienteServicio.agregarCliente("19.145.452-8","Pablo","Perez","5 años");
		assertEquals("Cliente agregado correctamente", agregarClienteRes);
	}
	
	@Test
	public void agregarClienteNullTest() {
		
		ClienteServicio clienteServicio = new ClienteServicio();
		String agregarClienteRes = clienteServicio.agregarCliente(null,null,null,null);
		assertEquals("Cliente agregado correctamente", agregarClienteRes);
	}
	
	@Test
	public void test() {
	
	}

}


