package Servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Modelo.CategoriaEnum;
import Modelo.Cliente;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportarDatos(String fileName, List<Cliente> ListaClientes) {

		try {
			File archivo = new File(fileName);
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);

			ListaClientes.stream().forEach((cliente) -> {
				try {
					bw.write("------------Datos del Cliente--------------\r\n");
					bw.write("\r\n");
					bw.write("\n");
					bw.write("Run del cliente: ");
					bw.write(cliente.getRunCliente() + "\r\n");
					bw.write("\n");
					bw.write("Nombre del Cliente: ");
					bw.write(cliente.getNombreCliente() + "\r\n");
					bw.write("\n");
					bw.write("Apellido del Cliente: ");
					bw.write(cliente.getApellidoCliente() + "\r\n");
					bw.write("\n");
					bw.write("Años como Cliente: ");
					bw.write(cliente.getAniosCliente() + "\r\n");
					bw.write("\n");
					bw.write("Categoría del Cliente: ");
					String estado = "Activo";
					if (cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
						estado = "Activo";
					} else if (cliente.getNombreCategoria().equals(CategoriaEnum.INACTIVO)) {
						estado = "Inactivo";
					}
					bw.write(estado + "\r\n");
					bw.write("\n");
					bw.write("\n");
					bw.write("-------------------------------------------\r\n");
				} catch (IOException e) {
					System.out.println("Error al escribir el archivo");
					System.out.println(e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			bw.close();
			System.out.println("Datos de clientes exportados correctamente en formato txt.");

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo");
			System.out.println(e.getMessage());
		}
	}

}
