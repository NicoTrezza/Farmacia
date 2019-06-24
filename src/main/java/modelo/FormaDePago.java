package modelo;

import org.bson.Document;

public class FormaDePago {
	
	private String nombre;

	public FormaDePago() {
		
	}
	
	public FormaDePago(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "FormaDePago [" + nombre + "]";
	}

	public Document toJson() {
		return new Document("nombre", this.getNombre());
	}
}
