package basedatos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;

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
	
public AggregateIterable<Document> consulta1(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return this.db.getCollection("venta").aggregate(Arrays.asList(
				Aggregates.match(and(gte("fecha",fechaInicio),lt("fecha",fechaFin))),
				Aggregates.group("$sucursal.ticketFiscal",Accumulators.sum("Cantidad de Ventas",1),Accumulators.sum("Total Ganancias","$totalVenta"))
				)
				);
	}
	
	public AggregateIterable<Document> consulta3(LocalDate fechaInicio, LocalDate fechaFin) {
			
		return this.db.getCollection("venta").aggregate(Arrays.asList(
			Aggregates.match(and(gte("fecha",fechaInicio),lt("fecha",fechaFin))),
			Aggregates.group(and(eq("sucursal","$sucursal.ticketFiscal"),eq("formaDePago","$formaDePago.nombre")),Accumulators.sum("Cantidad de Ventas",1),Accumulators.sum("Total Ganancias","$totalVenta"))
			)
			);
	}
	
	public AggregateIterable<Document> consulta2(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return this.db.getCollection("venta").aggregate(Arrays.asList(
			Aggregates.match(and(gte("fecha",fechaInicio),lt("fecha",fechaFin))),
			Aggregates.group(and(eq("sucursal","$sucursal.ticketFiscal"),eq("obraSocial","$cliente.obraSocial.nombre")),Accumulators.sum("Cantidad de Ventas",1),Accumulators.sum("Total Ganancias","$totalVenta"))
			)
			);
	}
	
	public AggregateIterable<Document> consulta4(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return this.db.getCollection("venta").aggregate(Arrays.asList(
			Aggregates.match(and(gte("fecha",fechaInicio),lt("fecha",fechaFin))),
			Aggregates.group(and(eq("tipo","$productosVendidos.producto.tipo"),eq("sucursal","$sucursal.ticketFiscal")),Accumulators.sum("Cantidad de Ventas",1),Accumulators.sum("Total Ganancias","$totalVenta"))
			)
			);
	}
	
	public AggregateIterable<Document> consulta5(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return this.db.getCollection("venta").aggregate(Arrays.asList(
			Aggregates.match(and(gte("fecha",fechaInicio),lt("fecha",fechaFin))),
			Aggregates.group(and(eq("sucursal","$sucursal.ticketFiscal"),eq("productos","$productosVendidos.producto.descripcion")),Accumulators.sum("Monto","$productosVendidos.subTotalVenta")),
			Aggregates.sort(Sorts.descending("Monto"))
			)
			);
	}
	
	public AggregateIterable<Document> consulta6(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return this.db.getCollection("venta").aggregate(Arrays.asList(
			Aggregates.match(and(gte("fecha",fechaInicio),lt("fecha",fechaFin))),
			Aggregates.group(and(eq("sucursal","$sucursal.ticketFiscal"),eq("productos","$productosVendidos.producto.descripcion")),Accumulators.sum("Cantidad","$productosVendidos.cantidad")),
			Aggregates.sort(Sorts.descending("Monto"))
			)
			);
	}
	
	public AggregateIterable<Document> consulta7(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return this.db.getCollection("venta").aggregate(Arrays.asList(
			Aggregates.match(and(gte("fecha",fechaInicio),lt("fecha",fechaFin))),
			Aggregates.group(and(eq("sucursal","$sucursal.ticketFiscal"),eq("cliente","$cliente.apellido")),Accumulators.sum("Monto","$productosVendidos.subTotalVenta")),
			Aggregates.sort(Sorts.descending("Monto"))
			)
			);
	}
	
	public AggregateIterable<Document> consulta8(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return this.db.getCollection("venta").aggregate(Arrays.asList(
			Aggregates.match(and(gte("fecha",fechaInicio),lt("fecha",fechaFin))),
			Aggregates.group(and(eq("sucursal","$sucursal.ticketFiscal"),eq("cliente","$cliente.apellido")),Accumulators.sum("Cantidad","$productosVendidos.cantidad")),
			Aggregates.sort(Sorts.descending("Monto"))
			)
			);
	}
}
