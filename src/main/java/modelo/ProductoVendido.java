package modelo;

import org.bson.types.ObjectId;

public class ProductoVendido {

	private ObjectId id;
	private Producto producto;
	private int cantidad;
	private float subTotalVenta;

	public ProductoVendido() {
		super();
	}

	public ProductoVendido(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.subTotalVenta = subtotalVenta();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getSubTotalVenta() {
		return subTotalVenta;
	}

	public void setSubTotalVenta(float subTotalVenta) {
		this.subTotalVenta = subTotalVenta;
	}

	private float subtotalVenta() {
		return getProducto().getPrecio()*getCantidad();
	}
	
	@Override
	public String toString() {
		return "ProductoVendido [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", subTotalVenta="
				+ subTotalVenta + "]";
	}

}
