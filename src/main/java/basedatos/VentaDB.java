package basedatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.*;

import modelo.Sucursal;
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
		return this.coleccion.find(eq("fecha", date)).first();
	}
	
	public List<Venta> encontrar(LocalDate date, LocalDate date2) {
		List<Venta> lista = new ArrayList<Venta>();

		for (Venta venta : this.coleccion.find(and(gte("fecha", date),lt("fecha", date2)))) {
			lista.add(venta);
		}

		return lista;
	}
	
	public List<Venta> encontrar(LocalDate date, LocalDate date2, Sucursal sucursal) {
		List<Venta> lista = new ArrayList<Venta>();

		for (Venta venta : this.coleccion.find(and(gte("fecha", date),lt("fecha", date2),eq("sucursal.ticketFiscal",sucursal.getTicketFiscal())))) {
			lista.add(venta);
		}

		return lista;
	}
}
