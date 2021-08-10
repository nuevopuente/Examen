package Servicio;

import java.util.ArrayList;

import Modelo.CategoriaEnum;
import Modelo.Cliente;

public class ClienteServicio extends Cliente {

	static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio() {
		super();
	}

	public ClienteServicio(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		super(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
	}

	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public static void setListaClientes(ArrayList<Cliente> listaClientes) {
		ClienteServicio.listaClientes = listaClientes;
	}

	public static void retornoListarClientes() {

		listaClientes.stream().forEach((cliente) -> {
			System.out.println(cliente.toString());
		});
		return;
	}

	public static void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente,
			String aniosCliente) {

		if ((runCliente != null) && (nombreCliente != null) && (apellidoCliente != null) && (aniosCliente != null)) {

			Cliente clien = new Cliente();
			clien.setRunCliente(runCliente);
			clien.setNombreCliente(nombreCliente);
			clien.setApellidoCliente(apellidoCliente);
			clien.setAniosCliente(aniosCliente);
			clien.setNombreCategoria(CategoriaEnum.ACTIVO);

			listaClientes.add(clien);
		}

		return;
	}

	public static void editarCliente(int indice, String runCliente, String nombreCliente, String apellidoCliente,
			String aniosCliente, CategoriaEnum categ) {

		Cliente clien = new Cliente();
		clien.setRunCliente(runCliente);
		clien.setNombreCliente(nombreCliente);
		clien.setApellidoCliente(apellidoCliente);
		clien.setAniosCliente(aniosCliente);
		clien.setNombreCategoria(categ);
		listaClientes.set(indice, clien);

		return;
	}

	public static void editarCliente(int indice, CategoriaEnum categ) {

		Cliente clien = new Cliente();

		clien = listaClientes.get(indice);

		clien.setNombreCategoria(categ);

		listaClientes.set(indice, clien);

		return;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteServicio [getRunCliente()=");
		builder.append(getRunCliente());
		builder.append(", getNombreCliente()=");
		builder.append(getNombreCliente());
		builder.append(", getApellidoCliente()=");
		builder.append(getApellidoCliente());
		builder.append(", getAniosCliente()=");
		builder.append(getAniosCliente());
		builder.append(", getNombreCategoria()=");
		builder.append(getNombreCategoria());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}

}
