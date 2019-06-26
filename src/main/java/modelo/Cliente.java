package modelo;

import org.bson.Document;

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

	public Document toJson() {
		Document doc = new Document("_id", getId())
				.append("apellido", getApellido())
				.append("dni", getDni())
				.append("domicilio", this.getDomicilio().toJson())
				.append("nombre", this.getNombre())
			;
		if (this.getObraSocial() != null) {
			doc.append("obraSocial", this.getObraSocial().toJson());
		}else {
			doc.append("obraSocial",null);
		}
		return doc;
	}
	
}
