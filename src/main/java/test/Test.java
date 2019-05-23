package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import basedatos.FormaDePagoDB;
import basedatos.PersonaDB;
import basedatos.ProductoDB;
import basedatos.VentaDB;
import modelo.Cliente;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.FormaDePago;
import modelo.Persona;
import modelo.Producto;
import modelo.ProductoVendido;
import modelo.Venta;
import modelo.ObraSocial;

public class Test {

	public static void main(String[] args) {
		
		// Personas
		PersonaDB db = new PersonaDB();
		
		db.insertar(new Cliente("Juan", "Benitez", 12345687, new ObraSocial("Osecac", 1), new Domicilio("San aguston", 141, "San Nicolas", "Buenos Aires")));
		db.insertar(new Cliente("Norma", "Andres", 32165498, new ObraSocial("Pami", 1), new Domicilio("Gral Belgrano", 10, "Lanus", "Buenos Aires")));
		db.insertar(new Empleado("Lionel", "Messi", 98765412, new ObraSocial("Galeno", 1), new Domicilio("San Martin", 11, "Avellaneda", "Buenos Aires"), 20987654120L));
		db.insertar(new Empleado("Gonzalo", "Banzas", 65498722, null, new Domicilio("Martinez", 666, "Belgrano", "Buenos Aires"), 20654987220L));

		for (Persona persona : db.encontrar()) {
			System.out.println(persona);
		}
		
		// Productos
		ProductoDB dbprod = new ProductoDB();
		
		dbprod.insertar(new Producto("Medicamento", "Ronyol", "Baliarda", 10001, 20));
		dbprod.insertar(new Producto("Medicamento", "Clonagin", "INVESTI", 10006, 180));
		dbprod.insertar(new Producto("Medicamento", "Biperineto", "Bagó", 10011, 400));
		dbprod.insertar(new Producto("Medicamento", "Aspirina", "BAYER", 10018, 59));
		dbprod.insertar(new Producto("Medicamento", "Levo-tiroxina", "GSK", 10019, 100));
		dbprod.insertar(new Producto("Medicamento", "semanar 160", "MA", 10022, 450));
		dbprod.insertar(new Producto("Medicamento", "semanar 80", "MA", 10028, 300));
		dbprod.insertar(new Producto("Medicamento", "Halopidol Decanoato", "DF", 10101, 765));
		dbprod.insertar(new Producto("Perfumería", "Enjuague Bucal", "Colgato", 20022, 95));
		dbprod.insertar(new Producto("Perfumería", "Desodorante aerosol Evolution", "ST", 20028, 45));
		dbprod.insertar(new Producto("Perfumería", "Talco", "Rexona", 20101, 50));
		
		for (Producto producto : dbprod.encontrar()) {
			System.out.println(producto);
		}
		
		// FormaDePagos
		FormaDePagoDB dbFormaDePAgo = new FormaDePagoDB();

		dbFormaDePAgo.insertar(new FormaDePago("Efectivo"));
		dbFormaDePAgo.insertar(new FormaDePago("Tarjeta crédito"));
		dbFormaDePAgo.insertar(new FormaDePago("Tarjeta débito"));
		
		for (FormaDePago fp : dbFormaDePAgo.encontrar()) {
			System.out.println(fp.toString());
		}
		

		// Ventas
		VentaDB dbV = new VentaDB();
		try {
			FormaDePagoDB dbF = new FormaDePagoDB();
			ProductoDB dbP = new ProductoDB();
			PersonaDB dbPersonas = new PersonaDB();
			List<ProductoVendido> lstProductos = new ArrayList<ProductoVendido>();
			lstProductos.add(new ProductoVendido(dbP.encontrar(20022),3));
			lstProductos.add(new ProductoVendido(dbP.encontrar(20028),1));
			dbV.insertar(new Venta(LocalDate.now(), 1, dbF.encontrar("Cheque"), lstProductos, dbPersonas.encontrar(20987654120L), dbPersonas.encontrar(20654987220L), dbPersonas.encontrar(12345687)));
		} catch (Exception e) {
			System.out.println(e);
		}

		for (Venta venta : dbV.encontrar()) {
			System.out.println(venta.toString());
		}
		
	}

}
