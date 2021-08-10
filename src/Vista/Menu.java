package Vista;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Modelo.CategoriaEnum;
import Modelo.Cliente;
import Servicio.ArchivoServicio;
import Servicio.ClienteServicio;
import Servicio.ExportadorCsv;
import Servicio.ExportadorTxt;
import Utilidades.Utilidades;

public class Menu implements AccionesMenu {

	ClienteServicio clienteservicio;
	ArchivoServicio archivoservicio;

	static String fileName = "Clientes";

	static String fileName1 = "DBClientes.csv";

	static Scanner sc = new Scanner(System.in);

	public void iniciarMenu() throws InterruptedException {

		int seleccion;

		do {
			System.out.println("Opciones");
			System.out.println("1 Listar Clientes");
			System.out.println("2 Agregar Cliente");
			System.out.println("3 Editar Cliente");
			System.out.println("4 Cargar Datos");
			System.out.println("5 Exportar Datos");
			System.out.println("6 Espera 30 segundos");
			System.out.println("7 Limpieza Pantalla");
			System.out.println("8 Salir");
			System.out.println("Ingrese una opcion: ");
			seleccion = 0;
			try {

				seleccion = Integer.parseInt(sc.nextLine().trim());

			} catch (Exception e) {

				System.out.println("Debe ingresar un valor valido segun menu ");
			}
			switch (seleccion) {
			case 1: {
				listarCliente();
				break;
			}
			case 2: {
				agregarCliente();
				break;
			}
			case 3: {
				editarCliente();
				break;
			}
			case 4: {
				importarDatos();
				break;
			}
			case 5: {
				exportarDatos();
				break;
			}
			case 6: {
				Utilidades.esperar();
				break;
			}
			case 7: {
				Utilidades.limpiar();
				break;
			}
			case 8: {
				terminarPrograma();
				break;
			}

			default: {
				System.out.println("Debe ingresar opcion entre 1 y 8 ");
				break;
			}
			}
		} while (seleccion != 8);

		sc.close();

	}

	@Override
	public void listarCliente() {

		ClienteServicio.retornoListarClientes();
	}

	@Override
	public void agregarCliente() {

		System.out.println(" ");
		System.out.println("------------Crear Cliente------------");
		System.out.println(" ");
		System.out.println("Ingresa RUN del cliente (Formato 99999999-X): ");

		String rutingreso = "";
		String nombreingreso = "";
		String apellidoingreso = "";
		Integer indice;
		String aniosingreso = "";
		String rutavalidar;

		try {

			rutingreso = sc.nextLine().trim();

		} catch (Exception e) {

			System.out.println("Debe ingresar un rut valido ");
			return;
		}

		rutavalidar = rutingreso.replace(".", "");

		if (!validaRut(rutavalidar)) {
			System.out.println("Debe ingresar un rut valido ");
			return;
		}
		indice = -1;
		indice = existeCliente(rutingreso, ClienteServicio.getListaClientes());

		if (indice >= 0) {
			System.out.println("Debe ingresar un rut que no exista ");
			return;
		}

		System.out.println(" ");
		System.out.println("Ingresa Nombre del cliente: ");

		try {

			nombreingreso = sc.nextLine().trim();

		} catch (Exception e) {

			System.out.println("Debe ingresar un nombre valido ");
			return;
		}

		if ((nombreingreso == null) || (nombreingreso == "") || (nombreingreso == " ")
				|| (nombreingreso.length() < 1)) {
			System.out.println("Debe ingresar un nombre valido ");
			return;
		}

		System.out.println(" ");
		System.out.println("Ingresa Apellido del cliente: ");

		try {

			apellidoingreso = sc.nextLine().trim();

		} catch (Exception e) {

			System.out.println("Debe ingresar un apellido valido ");
			return;
		}

		if ((apellidoingreso == null) || (apellidoingreso == "") || (apellidoingreso == " ")
				|| (apellidoingreso.length() < 1)) {

			System.out.println("Debe ingresar un apellido valido ");
			return;
		}

		System.out.println(" ");
		System.out.println("Ingresa Años como cliente: ");

		try {

			aniosingreso = sc.nextLine().trim();

		} catch (Exception e) {

			System.out.println("Debe ingresar una cantidad valida ");
			return;
		}

		if ((aniosingreso == null) || (aniosingreso == "") || (aniosingreso == " ") || (aniosingreso.length() < 1))

		{

			System.out.println("Debe ingresar una cantidad valida ");
			return;
		}

		String string = rutingreso;
		String[] parts = string.split("-");
		String part1 = parts[0];
		String part2 = parts[1];

		DecimalFormat formatea = new DecimalFormat("###,###.##");

		part1 = part1.replace(".", "");
		part1 = (formatea.format(Integer.parseInt(part1)));

		rutingreso = part1 + "-" + part2;

		ClienteServicio.agregarCliente(rutingreso, nombreingreso, apellidoingreso, String.valueOf(aniosingreso));

		return;

	}

	@Override
	public void editarCliente() {

		int indice, opcion2a;
		String rutingreso, rutavalidar;

		do {

			opcion2a = 0;

			System.out.println("------------Editar Cliente------------");
			System.out.println("Seleccione que desea hacer: ");
			System.out.println("1.- Cambiar el estado del cliente ");
			System.out.println("2.- Editar los datos ingresados del Cliente ");
			System.out.println("3.- Cancelar esta opcion ");
			System.out.println(" ");
			System.out.println("Ingrese opcion: ");

			try {
				opcion2a = Integer.parseInt(sc.nextLine().trim());

			} catch (Exception e) {

				System.out.println("Debe ingresar un numero entre 1 y 3 ");
			}

			if ((opcion2a < 1) || (opcion2a > 3)) {
				System.out.println("Debe ingresar un numero entre 1 y 3 ");
			}
		} while ((opcion2a < 1) || (opcion2a > 3));

		if (opcion2a == 3) {
			return;
		}

		System.out.println("--------------------------------------");
		System.out.println(" ");
		System.out.println("Ingresa RUN del cliente a editar (Formato 99999999-X) : ");

		rutingreso = "";

		try {

			rutingreso = sc.nextLine().trim();

		} catch (Exception e) {

			System.out.println("Debe ingresar un rut valido ");
			return;
		}

		rutavalidar = rutingreso.replace(".", "");

		if (!validaRut(rutavalidar)) {
			System.out.println("Debe ingresar un rut valido ");
			return;
		}

		indice = -1;
		indice = existeCliente(rutingreso, ClienteServicio.getListaClientes());

		if (indice < 0) {
			System.out.println("Debe ingresar un rut existente ");
			return;
		}

		if (opcion2a == 1) {

			editarClienteEnum(indice, ClienteServicio.getListaClientes());
		} else {
			editarClienteOtros(indice, ClienteServicio.getListaClientes());
		}

		return;
	}

	@Override
	public void importarDatos() {

		String directorio = " ";

		System.out.println("----------Cargar Datos en Windows--------- ");
		System.out.println("Ingrese la ruta donde se encuentra el archivo DBClientes.csv ");
		try {
			directorio = sc.nextLine().trim();

		} catch (Exception e) {

			System.out.println("Debe ingresar una ruta correcta para el archivo ");
			return;
		}

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("------------------------------------------------ ");

		ArchivoServicio.cargarDatos(fileName1, directorio);

		return;

	}

	@Override
	public void exportarDatos() {

		String directorio = " ";
		String exte;
		int opcion;

		do {
			opcion = 0;

			System.out.println(" ");
			System.out.println(" ");
			System.out.println("----------Exportar Datos--------- ");
			System.out.println("Seleccione el formato a exportar ");
			System.out.println("1.- Formato csv ");
			System.out.println("2.- Formato txt ");
			System.out.println("3.- Cancelar la opción ");
			try {
				opcion = Integer.parseInt(sc.nextLine().trim());

			} catch (Exception e) {

				System.out.println("Debe ingresar un numero entre 1 y 3 ");
			}

			if ((opcion < 1) || (opcion > 3)) {
				System.out.println("Debe ingresar un numero entre 1 y 3 ");
			}

		} while ((opcion < 1) || (opcion > 3));

		if (opcion == 3) {
			return;
		}

		if (opcion == 1) {
			exte = ".csv";
		} else {
			exte = ".txt";
		}

		System.out.println("Ingrese la ruta donde desea exportar el archivo clientes" + exte);

		try {
			directorio = sc.nextLine().trim();

		} catch (Exception e) {

			System.out.println("Debe ingresar una ruta correcta para el archivo ");
			return;
		}

		String ruta = directorio + "\\" + fileName + exte;

		if (opcion == 1) {
			ExportadorCsv expcsv = new ExportadorCsv();

			expcsv.exportarDatos(ruta, ClienteServicio.getListaClientes());

		} else {
			ExportadorTxt exptxt = new ExportadorTxt();

			exptxt.exportarDatos(ruta, ClienteServicio.getListaClientes());

		}

		return;
	}

	@Override
	public void terminarPrograma() {

		System.out.println("Saliendo del sistema ");
		return;
	}

	public static Boolean validaRut(String rut) {

		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rut);

		if (matcher.matches() == false)
			return false;
		String[] stringRut = rut.split("-");

		return stringRut[1].toLowerCase().equals(Menu.dv(stringRut[0]));
	}

	public static String dv(String rut) {
		Integer M = 0, S = 1, T = Integer.parseInt(rut);
		for (; T != 0; T = (int) Math.floor(T /= 10))
			S = (S + T % 10 * (9 - M++ % 6)) % 11;
		return (S > 0) ? String.valueOf(S - 1) : "k";
	}

	public static int existeCliente(String rut, ArrayList<Cliente> listaClientes) {

		if (rut == null) {
			return -1;
		}

		String string = rut;
		String[] parts = string.split("-");

		String part1 = parts[0];
		String part2 = parts[1];
		String rutaux;

		DecimalFormat formatea = new DecimalFormat("###,###.##");

		part1 = part1.replace(".", "");

		part1 = (formatea.format(Integer.parseInt(part1)));

		rutaux = part1 + "-" + part2;

		int encontrado = -1;

		for (int i = 0; i < listaClientes.size(); i++) {

			if ((listaClientes.get(i).getRunCliente().equalsIgnoreCase(rut))
					|| (listaClientes.get(i).getRunCliente().equalsIgnoreCase(rutaux))) {
				encontrado = i;
			}

		}
		return encontrado;
	}

	public static void editarClienteEnum(int indice, ArrayList<Cliente> listaClientes) {

		System.out.println("-----Actualizando estado del cliente-----");

		CategoriaEnum catenum;
		catenum = listaClientes.get(indice).getNombreCategoria();

		int opcion;

		do {
			opcion = 0;

			System.out.println("El estado actual es: " + catenum);

			if (catenum == CategoriaEnum.ACTIVO) {

				System.out.println("1.- Si desea cambiar el estado del Cliente a Inactivo");
				System.out.println("2.- Si desea mantener el estado del cliente Activo");
				System.out.println("3.- Si desea salir de esta funcion ");
			} else {
				System.out.println("1.- Si desea cambiar el estado del Cliente a Activo");
				System.out.println("2.- Si desea mantener el estado del cliente Inactivo");
				System.out.println("3.- Si desea salir de esta funcion ");
			}

			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Ingrese Opcion: ");
			System.out.println("--------------------------------------");

			try {
				opcion = Integer.parseInt(sc.nextLine().trim());

			} catch (Exception e) {

				System.out.println("Debe ingresar un numero entre 1 y 3 ");
			}

			if ((opcion < 1) || (opcion > 3)) {
				System.out.println("Debe ingresar un numero entre 1 y 3 ");
			}

		} while ((opcion < 1) || (opcion > 3));

		if ((catenum == CategoriaEnum.ACTIVO) && (opcion == 1)) {

			ClienteServicio.editarCliente(indice, CategoriaEnum.INACTIVO);
		}

		if ((catenum == CategoriaEnum.INACTIVO) && (opcion == 1)) {

			ClienteServicio.editarCliente(indice, CategoriaEnum.ACTIVO);
		}

		return;
	}

	public static void editarClienteOtros(int indice, ArrayList<Cliente> listaClientes) {

		System.out.println("-----Actualizando datos del cliente-----");

		int opcion, vuelta;
		String rutavalidar;

		do {
			opcion = 0;

			System.out.println("1.- El RUN del cliente es: " + listaClientes.get(indice).getRunCliente());
			System.out.println("2.- El Nombre del cliente es: " + listaClientes.get(indice).getNombreCliente());
			System.out.println("3.- El Apellido del cliente es: " + listaClientes.get(indice).getApellidoCliente());
			System.out.println("4.- Los años como Cliente son : " + listaClientes.get(indice).getAniosCliente());
			System.out.println("5.- Ingrese 5 pasa Salir ");

			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Ingrese Opcion a editar  de los datos del cliente : ");
			System.out.println("---------------------------------------------------");

			try {
				opcion = Integer.parseInt(sc.nextLine().trim());

			} catch (Exception e) {

				System.out.println("Debe ingresar un numero entre 1 y 5 ");
			}

			if ((opcion < 1) || (opcion > 5)) {
				System.out.println("Debe ingresar un numero entre 1 y 5 ");
			}

		} while ((opcion < 1) || (opcion > 5));

		if (opcion == 5) {
			return;
		}

		if (opcion == 1) {
			System.out.println("1.- Ingrese nuevo RUN del cliente (Formato 99999999-X): ");
			String rutingreso = "";

			try {

				rutingreso = sc.nextLine().trim();

			} catch (Exception e) {

				System.out.println("Debe ingresar un rut valido ");
				return;
			}

			rutavalidar = rutingreso.replace(".", "");
			if (!validaRut(rutavalidar)) {
				System.out.println("Debe ingresar un rut valido ");
				return;
			}

			vuelta = existeCliente(rutingreso, listaClientes);

			if (!(vuelta == -1)) {
				System.out.println("Debe ingresar un rut que no exista ");
				return;
			}

			String string = rutingreso;
			String[] parts = string.split("-");
			String part1 = parts[0];
			String part2 = parts[1];

			DecimalFormat formatea = new DecimalFormat("###,###.##");

			part1 = part1.replace(".", "");
			part1 = (formatea.format(Integer.parseInt(part1)));

			rutingreso = part1 + "-" + part2;

			ClienteServicio.editarCliente(indice, rutingreso, listaClientes.get(indice).getNombreCliente(),
					listaClientes.get(indice).getApellidoCliente(), listaClientes.get(indice).getAniosCliente(),
					listaClientes.get(indice).getNombreCategoria());

		}

		if (opcion == 2) {

			System.out.println("1.- Ingrese nuevo Nombre del cliente: ");
			String nombreingreso = "";

			try {

				nombreingreso = sc.nextLine().trim();

			} catch (Exception e) {

				System.out.println("Debe ingresar un nombre valido ");
				return;
			}

			if ((nombreingreso == null) || (nombreingreso == "") || (nombreingreso == " ")
					|| (nombreingreso.length() < 1))

			{
				System.out.println("Debe ingresar un nombre valido ");
				return;
			}

			ClienteServicio.editarCliente(indice, listaClientes.get(indice).getRunCliente(), nombreingreso,
					listaClientes.get(indice).getApellidoCliente(), listaClientes.get(indice).getAniosCliente(),
					listaClientes.get(indice).getNombreCategoria());

		}

		if (opcion == 3) {

			System.out.println("1.- Ingrese nuevo Apellido del cliente: ");
			String apellidoingreso = "";

			try {

				apellidoingreso = sc.nextLine().trim();

			} catch (Exception e) {

				System.out.println("Debe ingresar un apellido valido ");
				return;
			}

			if ((apellidoingreso == null) || (apellidoingreso == "") || (apellidoingreso == " ")
					|| (apellidoingreso.length() < 1))

			{
				System.out.println("Debe ingresar un apellido valido ");
				return;
			}

			ClienteServicio.editarCliente(indice, listaClientes.get(indice).getRunCliente(),
					listaClientes.get(indice).getNombreCliente(), apellidoingreso,
					listaClientes.get(indice).getAniosCliente(), listaClientes.get(indice).getNombreCategoria());

		}

		if (opcion == 4) {

			System.out.println("1.- Ingrese nuevo Años como cliente: ");
			String anosingreso = "";

			try {

				anosingreso = sc.nextLine().trim();

			} catch (Exception e) {

				System.out.println("Debe ingresar una cantidad valida ");
				return;
			}

			if ((anosingreso == null) || (anosingreso == "") || (anosingreso == " ") || (anosingreso.length() < 1))

			{
				System.out.println("Debe ingresar un cantidad valido ");
				return;
			}

			ClienteServicio.editarCliente(indice, listaClientes.get(indice).getRunCliente(),
					listaClientes.get(indice).getNombreCliente(), listaClientes.get(indice).getApellidoCliente(),
					anosingreso, listaClientes.get(indice).getNombreCategoria());

		}
		System.out.println("---------------------------------------------------");
		System.out.println("Datos cambiados con éxito ");

		return;
	}

}
