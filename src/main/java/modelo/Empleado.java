package modelo;

import org.bson.Document;

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
		return "Empleado [cuil=" + cuil + ", " + super.toString() + "]";
	}
	
	public Document toJson() {
		Document doc = new Document("_id", getId())
				.append("apellido", getApellido())
				.append("cuil", getCuil())
				.append("dni", getDni())
				.append("domicilio", this.getDomicilio().toJson())
				.append("nombre", this.getNombre())
			;
		if (this.getObraSocial() != null) {
			doc.append("obraSocial", this.getObraSocial().toJson());
		}
		return doc;
	}

}
