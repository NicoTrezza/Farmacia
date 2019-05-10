package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.bson.types.ObjectId;

public class Venta {
	
	private ObjectId id;
	private GregorianCalendar date;
	private int numeroTicket;
	private float totalVenta;
	private FormaDePago formaDePago;
	private List<Producto> productosVendidos = new ArrayList<Producto>();
	private Empleado empleadoQueAtendio;
	private Empleado empleadoQueCobro;
	
	public Venta() {
		
	}
	
	public Venta(GregorianCalendar date, int numeroTicket, float totalVenta, FormaDePago formaDePago,
			List<Producto> productosVendidos, Empleado empleadoQueAtendio, Empleado empleadoQueCobro) {
		super();
		this.date = date;
		this.numeroTicket = numeroTicket;
		this.totalVenta = totalVenta;
		this.formaDePago = formaDePago;
		this.productosVendidos = productosVendidos;
		this.empleadoQueAtendio = empleadoQueAtendio;
		this.empleadoQueCobro = empleadoQueCobro;
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public GregorianCalendar getDate() {
		return date;
	}
	
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
	public int getNumeroTicket() {
		return numeroTicket;
	}
	
	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}
	
	public float getTotalVenta() {
		return totalVenta;
	}
	
	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	public FormaDePago getFormaDePago() {
		return formaDePago;
	}
	
	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	public List<Producto> getProductosVendidos() {
		return productosVendidos;
	}
	
	public void setProductosVendidos(List<Producto> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	
	public Empleado getEmpleadoQueAtendio() {
		return empleadoQueAtendio;
	}
	
	public void setEmpleadoQueAtendio(Empleado empleadoQueAtendio) {
		this.empleadoQueAtendio = empleadoQueAtendio;
	}
	
	public Empleado getEmpleadoQueCobro() {
		return empleadoQueCobro;
	}
	
	public void setEmpleadoQueCobro(Empleado empleadoQueCobro) {
		this.empleadoQueCobro = empleadoQueCobro;
	}
	
	@Override
	public String toString() {
		return "Venta [id=" + id + ", date=" + date + ", numeroTicket=" + numeroTicket + ", totalVenta=" + totalVenta
				+ ", formaDePago=" + formaDePago + ", productosVendidos=" + productosVendidos + ", empleadoQueAtendio="
				+ empleadoQueAtendio + ", empleadoQueCobro=" + empleadoQueCobro + "]";
	}
	
}
