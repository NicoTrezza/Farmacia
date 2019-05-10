package basedatos;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.Persona;

public class PersonaDB extends Conexion {

	private MongoCollection<Persona> coleccion;
	
	public PersonaDB() {
		super();
		this.coleccion = this.db.getCollection("persona", Persona.class);
	}

	public void insertar(Persona persona) {
		this.coleccion.insertOne(persona);
	}
	
	public List<Persona> encontrar() {
		List<Persona> lista = new ArrayList<Persona>();
		
		for (Persona persona : this.coleccion.find()) {
			lista.add(persona);
		}
		
		return lista;
	}
}
