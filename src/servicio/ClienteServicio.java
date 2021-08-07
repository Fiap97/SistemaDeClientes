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
	public String agregarCliente(String run,String nombre, String apellido, String aniosCliente) {
		
		String resultado="";
		
		for(Cliente cliente: listaClientes) {
			if(cliente.getRunCliente().equalsIgnoreCase(run)) {
				return resultado= "Cliente ya existe";
			}
		}
		Cliente clienteNuevo = new Cliente(run,nombre,apellido,aniosCliente);
		listaClientes.add(clienteNuevo);
		resultado= "Cliente agregado correctamente";
		return resultado;
		
	}
	
	//Hago este cambio de estado suponiendo que primero listaron a los clientes y vieron los estados que tenia cada uno
	public String cambiarEstado(String run) {
		
		
		for(Cliente cliente : listaClientes){
			if(cliente.getRunCliente().equals(run)) {
				if(cliente.getNombreCategoria()==CategoriaEnum.Activo) {
					cliente.setNombreCategoria(CategoriaEnum.Inactivo);
					return "Estado cambiado a inactivo";
				}
				else {
					cliente.setNombreCategoria(CategoriaEnum.Activo);
					return "Estado cambiado a activo";
				}
			}	
		}
		return "Cliente no se encuentra";
		
	}
	
	public String editarCliente(String run,String nombre, String apellido, String aniosCliente) {
		
		
		for(Cliente cliente : listaClientes){
			if(cliente.getRunCliente().equals(run)) {
				cliente.setNombreCliente(nombre);
				cliente.setApellidoCliente(apellido);
				cliente.setAniosCliente(aniosCliente);
				return "Cliente editado correctamente";
			}
		}
		return "Cliente no ha sido encontrado";
		
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	
	
	
}
