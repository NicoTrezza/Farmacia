package basedatos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.*;

import modelo.Venta;

public class VentaDB extends Conexion {

	private MongoCollection<Venta> coleccion;
	
	public VentaDB() {
		super();
		this.coleccion = this.db.getCollection("venta", Venta.class);
	}
	
	public void insertar(Venta venta) {
		this.coleccion.insertOne(venta);
	}
	
	public List<Venta> encontrar() {
		List<Venta> lista = new ArrayList<Venta>();

		for (Venta venta : this.coleccion.find()) {
			lista.add(venta);
		}

		return lista;
	}
	
	public Venta encontrar(GregorianCalendar date) {
		return this.coleccion.find(eq("date", date)).first();
	}
	
}
