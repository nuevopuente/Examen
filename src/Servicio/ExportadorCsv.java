package Servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Modelo.CategoriaEnum;
import Modelo.Cliente;

public class ExportadorCsv extends Exportador {

	@Override
	public void exportarDatos(String fileName, List<Cliente> ListaClientes) {
		// TODO Auto-generated method stub
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
