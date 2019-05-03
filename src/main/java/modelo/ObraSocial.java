package modelo;

public class ObraSocial {
	
	private String nombre;
	private int numeroAfiliado;
	
	public ObraSocial() {
	
	}
	
	public ObraSocial(String nombre, int numeroAfiliado) {
		this.nombre = nombre;
		this.numeroAfiliado = numeroAfiliado;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(int numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}

	@Override
	public String toString() {
		return "ObraSocial [nombre=" + nombre + ", numeroAfiliado=" + numeroAfiliado + "]";
	}
	
}
