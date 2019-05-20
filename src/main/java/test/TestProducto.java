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
			db.insertar(new Producto("Comprimidos", "Ronyol", "Baliarda", 10001, 20));
			db.insertar(new Producto("Comprimidos", "Clonagin", "INVESTI", 10006, 18));
			db.insertar(new Producto("Comprimidos", "Biperineto", "Bagó", 10011, 30));
			db.insertar(new Producto("Comprimidos", "Aspirina", "BAYER", 10018, 30));
			db.insertar(new Producto("Comprimidos", "Levo-tiroxina", "GSK", 10019, 30));
			db.insertar(new Producto("Comprimidos", "semanar 160", "MA", 10022, 30));
			db.insertar(new Producto("Comprimidos", "semanar 80", "MA", 10028, 30));
			db.insertar(new Producto("Intravenosa", "Halopidol Decanoato", "DF", 10101, 64));
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
			System.out.println(db.actualizarPrecio(10101, 120.0f));
			System.out.println(db.actualizar(10101, "Intraarterial","Halopidol Decanoato 3ml"));
			
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
			db.insertar(new Producto("Comprimidos", "semanar 40", "MA", 10022, 30));
			db.insertar(new Producto("Comprimidos", "semanar 120", "MA", 10028, 30));
			System.out.println(db.eliminarProductos("MA"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
