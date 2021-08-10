package Modelo;

public class Cliente {

	String runCliente;
	String nombreCliente;
	String apellidoCliente;
	String aniosCliente;
	CategoriaEnum nombreCategoria;

	public Cliente() {
		super();
	}

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("------------Datos del Cliente--------------");
		builder.append("\n");
		builder.append("\n");
		builder.append("Run del cliente: ");
		builder.append(getRunCliente());
		builder.append("\n");
		builder.append("Nombre del Cliente: ");
		builder.append(getNombreCliente());
		builder.append("\n");
		builder.append("Apellido del Cliente: ");
		builder.append(getApellidoCliente());
		builder.append("\n");
		builder.append("Años como Cliente: ");
		builder.append(getAniosCliente());
		builder.append("\n");
		builder.append("Categoría del Cliente: ");
		builder.append(getNombreCategoria());
		builder.append("\n");
		builder.append("\n");
		builder.append("-------------------------------------------");

		return builder.toString();
	}

}
