package basedatos;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.Cliente;

public class ClienteDB extends Conexion {

	private MongoCollection<Cliente> coleccion;
	
	public ClienteDB() {
		super();
		this.coleccion = this.db.getCollection("cliente", Cliente.class);
	}

	public void insertar(Cliente persona) {
		this.coleccion.insertOne(persona);
	}
	
	public List<Cliente> encontrar() {
		List<Cliente> lista = new ArrayList<Cliente>();
		
		for (Cliente persona : this.coleccion.find()) {
			lista.add(persona);
		}
		
		return lista;
	}
	
	public Cliente encontrar(int dni) throws Exception {
		MongoCollection<Cliente> coleccionE;
		coleccionE = this.db.getCollection("cliente", Cliente.class);
		return coleccionE.find(eq("dni", dni)).first();
	}
}
