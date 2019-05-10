package modelo;

public class Empleado extends Persona {
	
	private long cuil;
	
	public Empleado() {
		
	}

	public Empleado(String nombre, String apellido, int dni, ObraSocial obraSocial, Domicilio domicilio, long cuil) {
		super(nombre, apellido, dni, obraSocial, domicilio);
		this.cuil = cuil;
	}

	public long getCuil() {
		return cuil;
	}

	public void setCuil(long cuil) {
		this.cuil = cuil;
	}

	@Override
	public String toString() {
		return "Empleado [cuil=" + cuil + ", toString()=" + super.toString() + "]";
	}
	
}
