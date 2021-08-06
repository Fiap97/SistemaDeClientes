package servicio;


import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {

	List<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio() {
		super();
	}

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}
	
	
	public void listarClientes(){
		
		this.listaClientes.stream().forEach(
			(cliente)-> {
				System.out.println(cliente.toString());
			}
		);
		
	}
	public void agregarCliente(String run,String nombre, String apellido, String aniosCliente) {
		
		Cliente cliente = new Cliente(run,nombre,apellido,aniosCliente);
		listaClientes.add(cliente);
		System.out.println("Cliente agregado correctamente");
		
	}
	
	//Hago este cambio de estado suponiendo que primero listaron a los clientes y vieron los estados que tenia cada uno
	public void cambiarEstado(String run) {
		
		for(Cliente cliente : listaClientes){
			if(cliente.getRunCliente().equals(run)) {
				if(cliente.getNombreCategoria()==CategoriaEnum.Activo) {
					cliente.setNombreCategoria(CategoriaEnum.Inactivo);
					System.out.println("Estado cambiado a inactivo");
				}
				else {
					cliente.setNombreCategoria(CategoriaEnum.Activo);
					System.out.println("Estado cambiado a activo");
				}
			}
		}
		
	}
	
	public void editarCliente(String run,String nombre, String apellido, String aniosCliente) {
		

		for(Cliente cliente : listaClientes){
			if(cliente.getRunCliente().equals(run)) {
				cliente.setNombreCliente(nombre);
				cliente.setApellidoCliente(apellido);
				cliente.setAniosCliente(aniosCliente);
			}
		}
		
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	
	
	
}
