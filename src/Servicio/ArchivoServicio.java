package Servicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Modelo.CategoriaEnum;
import Modelo.Cliente;

public class ArchivoServicio extends ClienteServicio {

	public static void cargarDatos(String fileName, String directorio) {

		directorio = directorio + "\\" + fileName;

		System.out.println("Archivo  " + directorio);

		File fl = new File(directorio);

		try {
			FileReader fr = new FileReader(fl);
			BufferedReader br = new BufferedReader(fr);
			listaClientes.clear();

			String linea = br.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");

				if (campos.length == 5) {

					Cliente MiCliente = new Cliente();
					MiCliente.setRunCliente(campos[0]);
					MiCliente.setNombreCliente(campos[1]);
					MiCliente.setApellidoCliente(campos[2]);
					MiCliente.setAniosCliente(campos[3]);
					MiCliente.setNombreCategoria(CategoriaEnum.ACTIVO);

					if (campos[4].equalsIgnoreCase("Inactivo")) {
						MiCliente.setNombreCategoria(CategoriaEnum.INACTIVO);
					}

					listaClientes.add(MiCliente);

				}

				linea = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado, revisar ruta y nombre del archivo ");
			return;
		} catch (IOException e) {
			System.out.println("Archivo con problemas de acceso ");
			return;

		}
		System.out.println("Datos correctamente cargados en la lista ");

		return;
	}

	public void exportar(String fileName, List<Cliente> ListaClientes) {

		try {
			File archivo = new File(fileName);
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Cliente clie : ListaClientes) {
				String estado = "Activo";
				if (clie.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
					estado = "Activo";
				} else if (clie.getNombreCategoria().equals(CategoriaEnum.INACTIVO)) {
					estado = "Inactivo";
				}
				bw.write(clie.getRunCliente() + "," + clie.getNombreCliente() + "," + clie.getApellidoCliente() + ","
						+ clie.getAniosCliente() + "," + estado + "\n");
			}
			bw.close();
			System.out.println("Datos de clientes exportados correctamente en formato csv.");

		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
			System.out.println(e.getMessage());
		}

	}

}
