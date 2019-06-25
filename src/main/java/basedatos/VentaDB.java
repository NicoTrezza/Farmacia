package basedatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.bson.Document;

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
	
	public List<Venta> consulta1(LocalDate fechaInicio, LocalDate fechaFin, Sucursal sucursal) {
		List<Venta> lstVentas = new ArrayList<Venta>();
		Document query = new Document();
		query.append("fecha", new Document().append("$lte", fechaFin).append("$gte",fechaInicio)).append("sucursal.ticketFiscal", sucursal.getTicketFiscal());
		for (Venta venta : this.coleccion.find(query)) {
			lstVentas.add(venta);
		}
		return lstVentas;
	}
	
	public List<Venta> consulta2(Boolean obraSocial,LocalDate fechaInicio,LocalDate fechaFin){
		List<Venta> lstVentas = new ArrayList<Venta>();
		Document query= new Document();
		if (obraSocial) {
			query.append("fecha",new Document().append("$lte",fechaFin).append("$gte",fechaInicio));
			query.append("cliente.obraSocial", new Document().append("$ne", null));
		} else {
			query.append("fecha",new Document().append("$lte",fechaFin).append("$gte",fechaInicio));
			query.append("cliente.obraSocial", null);
		}
		for (Venta venta : this.coleccion.find(query)) {
			lstVentas.add(venta);
		}
		return lstVentas;
	}
	
	public List<Venta> consulta3(String formaDePago,LocalDate fechaInicio,LocalDate fechaFin){
		List<Venta> lstVentas = new ArrayList<Venta>();
		Document query= new Document();
		query.append("formaDePago.nombre", formaDePago);
		query.append("fecha",new Document().append("$lte",fechaFin).append("$gte",fechaInicio));
		for (Venta venta : this.coleccion.find(query)) {
			lstVentas.add(venta);
		}
		return lstVentas;
	}
}
