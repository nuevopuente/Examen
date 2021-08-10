package Utilidades;

public class Utilidades {

	public static void esperar() throws InterruptedException {
		System.out.println("Esperando 30 segundos.......");
		Thread.sleep(30000);
		System.out.println("Retorno al Menu");
	}

	public static void limpiar() {

		System.out.println(new String(new char[50]).replace("\0", "\r\n"));

	}

}
