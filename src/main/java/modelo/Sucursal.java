package modelo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Sucursal {

	private ObjectId id;
	private Empleado encargado;
	private List<Empleado> empleados = new ArrayList<Empleado>();
	private String ticketFiscal;
	private Domicilio domicilio;

	public Sucursal() {

	}

	public Sucursal(Empleado encargado, List<Empleado> empleados, String ticketFiscal, Domicilio domicilio) {
		super();
		this.encargado = encargado;
		this.empleados = empleados;
		this.ticketFiscal = ticketFiscal;
		this.domicilio = domicilio;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Empleado getEncargado() {
		return encargado;
	}

	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public String getTicketFiscal() {
		return ticketFiscal;
	}

	public void setTicketFiscal(String ticketFiscal) {
		this.ticketFiscal = ticketFiscal;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Sucursal [id=" + id + ", encargado=" + encargado + ", empleados=" + empleados + ", ticketFiscal="
				+ ticketFiscal + ", domicilio=" + domicilio + "]";
	}

	public Document toJson() {
		return new Document("_id", getId())
				.append("domicilio", getDomicilio().toJson())
//				.append("empleados", getEmpleados())
				.append("encargado", getEncargado().toJson())
				.append("ticketFiscal", getTicketFiscal())
			;
	}

}
