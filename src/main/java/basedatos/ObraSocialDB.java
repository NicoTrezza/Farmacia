package basedatos;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import modelo.ObraSocial;

public class ObraSocialDB extends Conexion {

	private MongoCollection<ObraSocial> coleccion;

	public ObraSocialDB() {
		super();
		this.coleccion = this.db.getCollection("obrasocial", ObraSocial.class);
	}

	public void insertar(ObraSocial obraSocial) {
		this.coleccion.insertOne(obraSocial);
	}
	
	public List<ObraSocial> encontrar() {
		List<ObraSocial> lista = new ArrayList<ObraSocial>();
		
		for (ObraSocial obraSocial : this.coleccion.find()) {
			lista.add(obraSocial);
		}
		
		return lista;
	}
	
}
