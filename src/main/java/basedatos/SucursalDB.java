package basedatos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import modelo.Domicilio;
import modelo.Empleado;
import modelo.Sucursal;

public class SucursalDB extends Conexion{
	private MongoCollection<Sucursal> coleccion;
	
	public SucursalDB() {
		super();
		this.coleccion = this.db.getCollection("sucursal", Sucursal.class);
	}
	
	public void insertar(Sucursal sucursal) {
		this.coleccion.insertOne(sucursal);
	}
	
	public List<Sucursal> encontrar() {
		List<Sucursal> lista = new ArrayList<Sucursal>();
		
		for (Sucursal sucursal : this.coleccion.find()) {
			lista.add(sucursal);
		}
		return lista;
	}
	
	public Sucursal encontrar(String ticketFiscal) {
		Document regQuery = new Document();
		Document findQuery = new Document();
		
		regQuery.append("$regex", "^(?)" + Pattern.quote(ticketFiscal.substring(0, 4)));		
		findQuery.append("ticketFiscal", regQuery);
		
		return this.coleccion.find(findQuery).first();
	}
	
	public UpdateResult actualizar(Empleado encargado, List<Empleado> empleados, String ticketFiscal, Domicilio domicilio) throws Exception {
		Document regQuery = new Document();
		Document findQuery = new Document();
		
		regQuery.append("$regex", "^(?)" + Pattern.quote(ticketFiscal.substring(0, 4)));		
		findQuery.append("ticketFiscal", regQuery);
		
		return this.coleccion.updateOne(findQuery, combine(set("encargado", encargado), set("empleados", empleados), set("domicilio", domicilio)));
	}
	
	public DeleteResult eliminar(Sucursal sucursal) throws Exception {
		Document regQuery = new Document();
		Document findQuery = new Document();
		
		regQuery.append("$regex", "^(?)" + Pattern.quote(sucursal.getTicketFiscal().substring(0, 4)));		
		findQuery.append("ticketFiscal", regQuery);
		return this.coleccion.deleteOne(findQuery);
	}
}
