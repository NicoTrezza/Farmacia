package basedatos;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.Cliente;
import modelo.Empleado;
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
	
	public Empleado encontrar(long CUIL) throws Exception {
		MongoCollection<Empleado> coleccionE;
		coleccionE = this.db.getCollection("persona", Empleado.class);
		return coleccionE.find(eq("cuil", CUIL)).first();
	}
	
	public Cliente encontrar(int dni) throws Exception {
		MongoCollection<Cliente> coleccionE;
		coleccionE = this.db.getCollection("persona", Cliente.class);
		return coleccionE.find(eq("dni", dni)).first();
	}
}
