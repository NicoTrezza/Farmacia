package test;

import basedatos.ProductoDB;
import modelo.Producto;

public class TestProducto {

	public static void main(String[] args) {

		
		ProductoDB db = new ProductoDB();
		// 01.eliminar todos los productors
		try {
			db.eliminarProductos();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// 02.agregar objetos
		try {
			db.insertar(new Producto("Bebida", "Coca-Cola Zero", "Coca-Cola Company", 10001, 20));
			db.insertar(new Producto("Bebida", "Coca-Cola", "Coca-Cola Company", 10036, 18));
			db.insertar(new Producto("Aseo", "Shampoo Sedal", "P&G", 10022, 30));
			db.insertar(new Producto("Alimento", "Frutillas", "ArgentinaRural", 10101, 64));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		for (Producto producto : db.encontrar()) {
			System.out.println(producto);
		}
		
		// 03.traer un objeto
		try {
			System.out.println(db.encontrar(10001));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 04.modificar un objeto
		try {
			System.out.println(db.actualizarPrecio(10001, 30.0f));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 05.eliminar un objeto
		try {
			System.out.println(db.eliminar(10001));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 06.eliminar objetos
		try {
			db.insertar(new Producto("Bebida", "Coca-Cola Zero2", "Coca-Cola Company", 10001, 20));
			db.insertar(new Producto("Bebida", "Coca-Cola2", "Coca-Cola Company", 10036, 18));
			System.out.println(db.eliminarProductos("Coca-Cola Company"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
