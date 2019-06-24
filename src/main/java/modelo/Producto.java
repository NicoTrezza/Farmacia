package modelo;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Producto {
	
	private ObjectId id;
	private String tipo;
	private String descripcion;
	private String laboratorio;
	private int codigo;
	private float precio;
	
	public Producto() {
		
	}
	
	public Producto(String tipo, String descripcion, String laboratorio, int codigo, float precio) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.laboratorio = laboratorio;
		this.codigo = codigo;
		this.precio = precio;
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", laboratorio=" + laboratorio + ", codigo="
				+ codigo + ", precio=" + precio + "]";
	}
	
	public Document toJson() {
		return new Document("_id", getId())
				.append("codigo", getCodigo())
				.append("descripcion", getDescripcion())
				.append("laboratorio", getLaboratorio())
				.append("precio", this.getPrecio())
				.append("tipo", this.getTipo())
			;
	}

}
