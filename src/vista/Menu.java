package vista;


import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu {



	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportarCsv = new ExportadorCsv();
	ExportadorTxt exportarTxt = new ExportadorTxt();

	private final String fileName = "Clientes";
	private Scanner scanner = new Scanner(System.in);

	public void iniciarMenu() {

		
		int opcion;

		do {
			
			System.out.println("Menú\n"
					+ "1.Listar clientes \n"
					+ "2.Agregar clientes \n"
					+ "3.Editar Cliente \n"
					+ "4.Cargar datos \n"
					+ "5.Exportar datos\n"
					+ "6.Salir");
			
			System.out.println("Ingrese una opcion");
			opcion=scanner.nextInt();
			
			
			switch(opcion) {
			case 1:
				System.out.println("Listar clientes");
				listarClientes();
				break;
			case 2:
				System.out.println("Agregar cliente");
				agregarCliente();
				break;
			case 3:
				System.out.println("Editar cliente");
				int op;
				do {
					System.out.println("1.-Cambiar el estado del Cliente");
					System.out.println("2.-Editar los datos ingresados del Cliente");
					System.out.println("3.-Salir");
					System.out.println("Ingrese opcion");
					op=scanner.nextInt();
					scanner.nextLine();
					
					switch(op) {
						case 1:
							String run;
							System.out.println("Ingrese run  de cliente a cambiar de estado: ");
							run=scanner.nextLine();
							cambiarEstado(run);
							break;
						case 2:
							String run2;
							System.out.println("Ingrese run  de cliente a editar: ");
							run2=scanner.nextLine();
							editarCliente(run2);
							break;
						case 3:
							System.out.println("Saliendo de editar cliente");
						default:
							System.out.println("Opcion ingresada no es valida");
					}
				}while(op!=3);
					
				break;
			case 4:
				//Interprete que hay que pasarle la ruta y no el nombre del archivo
				scanner.nextLine();
				String ruta;
				System.out.println("Importacion de datos");
				System.out.println("Ingrese la ruta");
				ruta=scanner.nextLine();
				//Le pase la lista tambien porque se me hace mas ordenado
				importarDatos(ruta,clienteServicio.getListaClientes());
				break;
			case 5:
				int opci;
				System.out.println("Exportacion de datos");
				System.out.println("Elija el formato a exportar");
				System.out.println("1.-Formato csv\n"
							  	 + "2.-Formato txt");
				opci=scanner.nextInt();
				scanner.nextLine();
				switch(opci) {
					case 1:
						exportarDatosCsv();
						break;
					case 2:
						exportarDatosTxt();
						break;
					default:
						System.out.println("La opcion ingresada no es valida");
				}
				
				break;
			case 6:
				terminarPrograma();
				break;
			default:
				System.out.println("La opcion ingresada no es valida");
			}
		}while(opcion!=6);

	}
	
	public void listarClientes() {
		clienteServicio.listarClientes();
		
	}
	
	public void agregarCliente() {
		
		String run;
		String nombre;
		String apellido;
		String aniosDeCliente;
		scanner.nextLine();
		System.out.println("Ingrese run");
		run=scanner.nextLine();
		System.out.println("Ingrese nombre");
		nombre=scanner.nextLine();
		System.out.println("Ingrese apellido");
		apellido=scanner.nextLine();
		System.out.println("ingrese años de cliente");
		aniosDeCliente=scanner.nextLine();
		System.out.println(clienteServicio.agregarCliente(run, nombre, apellido, aniosDeCliente));
		
	}
	
	public void cambiarEstado(String run) {
		
		System.out.println(clienteServicio.cambiarEstado(run));
		
	}
	
	public void editarCliente(String run) {
		
		String nombre;
		String apellido;
		String aniosDeCliente;
		
		System.out.println("Ingrese nombre");
		nombre=scanner.nextLine();
		System.out.println("Ingrese apellido");
		apellido=scanner.nextLine();
		System.out.println("ingrese años de cliente");
		aniosDeCliente=scanner.nextLine();
		System.out.println(clienteServicio.editarCliente(run, nombre, apellido, aniosDeCliente));
		
	}

	public void importarDatos(String ruta,List<Cliente> listaCliente) {
		archivoServicio.cargarDatos(ruta,listaCliente);
	}
	
	public void exportarDatosCsv() {
		exportarCsv.exportar(fileName, clienteServicio.getListaClientes());
	}
	public void exportarDatosTxt() {
		exportarTxt.exportar(fileName, clienteServicio.getListaClientes());
	}
	
	public void terminarPrograma() {
		Utilidad uti = new Utilidad();
		uti.limpiandoPantalla();
	}
}
