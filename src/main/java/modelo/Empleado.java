package modelo;

public class Empleado extends Persona{
	private int cuil;

	public Empleado(String nombre, String apellido, int dni, Domicilio domicilio, int cuil) {
		super(nombre, apellido, dni, domicilio);
		this.cuil = cuil;
	}

	public int getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
		this.cuil = cuil;
	}

	@Override
	public String toString() {
		return "Empleado [cuil=" + cuil + ", toString()=" + super.toString() + "]";
	}
	
}
