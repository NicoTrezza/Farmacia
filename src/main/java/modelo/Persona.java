package modelo;

import org.bson.types.ObjectId;

public class Persona {

	private ObjectId id;
	private String nombre;
	private String apellido;
	private int dni;
	private ObraSocial obraSocial;
	private Domicilio domicilio;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, String apellido, int dni, ObraSocial obraSocial, Domicilio domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.obraSocial = obraSocial;
		this.domicilio = domicilio;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", obraSocial="
				+ obraSocial + ", domicilio=" + domicilio + "]";
	}
	
}
