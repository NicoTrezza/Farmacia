package modelo;

public class Cliente extends Persona {

	public Cliente() {
		
	}

	public Cliente(String nombre, String apellido, int dni, ObraSocial obraSocial, Domicilio domicilio) {
		super(nombre, apellido, dni, obraSocial, domicilio);
	}
	
	@Override
	public String toString() {
		return "Cliente [" + super.toString() + "]";
	}
	
}
