package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
	private Empleado encargado;
	private List<Empleado> empleados=new ArrayList<Empleado>();
	private int ticketFsical;
	private Domicilio domicilio;
	
	public Sucursal(Empleado encargado, List<Empleado> empleados, int ticketFsical,Domicilio domicilio) {
		super();
		this.encargado = encargado;
		this.empleados = empleados;
		this.ticketFsical = ticketFsical;
		this.domicilio = domicilio;
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

	public int getTicketFsical() {
		return ticketFsical;
	}

	public void setTicketFsical(int ticketFsical) {
		this.ticketFsical = ticketFsical;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Sucursal [encargado=" + encargado + ", empleados=" + empleados + ", ticketFsical=" + ticketFsical
				+ ", domicilio=" + domicilio + "]";
	}
	
}
