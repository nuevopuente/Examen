package Servicio;

import java.util.List;

import Modelo.Cliente;

public abstract class Exportador extends ArchivoServicio {

	public abstract void exportarDatos(String fileName, List<Cliente> ListaClientes);

}
