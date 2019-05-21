package basedatos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;

import modelo.FormaDePago;

public class FormaDePagoDB extends Conexion {

	private MongoCollection<FormaDePago> coleccion;
	
	public FormaDePagoDB() {
		super();
		this.coleccion = this.db.getCollection("FormaDePago", FormaDePago.class);
	}

	public void insertar(FormaDePago formaDePago) {
		this.coleccion.insertOne(formaDePago);
	}

	public List<FormaDePago> encontrar() {
		List<FormaDePago> lista = new ArrayList<FormaDePago>();

		for (FormaDePago formaDePago : this.coleccion.find()) {
			lista.add(formaDePago);
		}

		return lista;
	}

	public FormaDePago encontrar(String nombre) throws Exception {
		return this.coleccion.find(eq("nombre", nombre)).first();
	}

	public UpdateResult actualizar(FormaDePago formaDePago, String newNombre) throws Exception {
		return this.coleccion.updateOne(eq("nombre", formaDePago.getNombre()), combine(set("nombre", newNombre)));
	}

	public DeleteResult eliminar(FormaDePago formaDePago) throws Exception {
		return this.coleccion.deleteOne(eq("nombre", formaDePago.getNombre()));
	}
	
	public DeleteResult eliminar() throws Exception {
		return this.coleccion.deleteMany(exists("nombre"));
	}

}
