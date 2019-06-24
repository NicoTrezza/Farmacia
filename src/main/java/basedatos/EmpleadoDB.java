package basedatos;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.Empleado;

public class EmpleadoDB extends Conexion {

	private MongoCollection<Empleado> coleccion;
	
	public EmpleadoDB() {
		super();
		this.coleccion = this.db.getCollection("empleado", Empleado.class);
	}

	public void insertar(Empleado persona) {
		this.coleccion.insertOne(persona);
	}
	
	public List<Empleado> encontrar() {
		List<Empleado> lista = new ArrayList<Empleado>();
		
		for (Empleado persona : this.coleccion.find()) {
			lista.add(persona);
		}
		
		return lista;
	}
	
	public Empleado encontrar(long CUIL) throws Exception {
		MongoCollection<Empleado> coleccionE;
		coleccionE = this.db.getCollection("empleado", Empleado.class);
		return coleccionE.find(eq("cuil", CUIL)).first();
	}
	

}
