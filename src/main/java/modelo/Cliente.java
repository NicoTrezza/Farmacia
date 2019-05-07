package modelo;

public class Cliente extends Persona {

	public Cliente(String nombre, String apellido, int dni, Domicilio domicilio) {
		super(nombre, apellido, dni, domicilio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente [toString()=" + super.toString() + "]";
	}
	
}
