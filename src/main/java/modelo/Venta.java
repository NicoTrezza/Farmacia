package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Venta {

	private ObjectId id;
	private LocalDate fecha;
	private int numeroTicket;
	private float totalVenta;
	private FormaDePago formaDePago;
	private List<ProductoVendido> productosVendidos = new ArrayList<ProductoVendido>();
	private Empleado empleadoQueAtendio;
	private Empleado empleadoQueCobro;
	private Cliente cliente;

	public Venta() {

	}

	public Venta(LocalDate fecha, int numeroTicket, FormaDePago formaDePago, List<ProductoVendido> productosVendidos,
			Empleado empleadoQueAtendio, Empleado empleadoQueCobro, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.numeroTicket = numeroTicket;
		this.totalVenta = totalVenta();
		this.formaDePago = formaDePago;
		this.productosVendidos = productosVendidos;
		this.empleadoQueAtendio = empleadoQueAtendio;
		this.empleadoQueCobro = empleadoQueCobro;
		this.cliente = cliente;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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

	public List<ProductoVendido> getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(List<ProductoVendido> productosVendidos) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private float totalVenta() {
		float total = 0;
		for (ProductoVendido productoV : productosVendidos) {
			total += productoV.getSubTotalVenta();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", numeroTicket=" + numeroTicket + ", totalVenta=" + totalVenta
				+ ", formaDePago=" + formaDePago + ", productosVendidos=" + productosVendidos + ", empleadoQueAtendio="
				+ empleadoQueAtendio + ", empleadoQueCobro=" + empleadoQueCobro + ", cliente=" + cliente + "]";
	}

}
