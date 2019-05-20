package basedatos;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import modelo.Producto;

public class ProductoDB extends Conexion {

	private MongoCollection<Producto> coleccion;
	
	public ProductoDB() {
		super();
		this.coleccion = this.db.getCollection("producto", Producto.class);
	}

	public void insertar(Producto producto) {
		this.coleccion.insertOne(producto);
	}

	public List<Producto> encontrar() {
		List<Producto> lista = new ArrayList<Producto>();

		for (Producto producto : this.coleccion.find()) {
			lista.add(producto);
		}

		return lista;
	}

	public Producto encontrar(int codigo) throws Exception {
		return this.coleccion.find(eq("codigo", codigo)).first();
	}

	public UpdateResult actualizarPrecio(int codigo, float precio) throws Exception {
		return this.coleccion.updateOne(eq("codigo", codigo), combine(set("precio", precio),set("precio", precio)));
	}
	
	public UpdateResult actualizar(int codigo, String descripcion,String laboratorio) throws Exception {
		return this.coleccion.updateOne(eq("codigo", codigo), combine(set("descripcion", descripcion),set("laboratorio", laboratorio)));
	}

	public DeleteResult eliminar(int codigo) throws Exception {
		return this.coleccion.deleteOne(eq("codigo", codigo));
	}

	public DeleteResult eliminarProductos() throws Exception {
		return this.coleccion.deleteMany(exists("_id"));
	}

	public DeleteResult eliminarProductos(String laboratorio) throws Exception {
		return this.coleccion.deleteMany(eq("laboratorio", laboratorio));
	}

}