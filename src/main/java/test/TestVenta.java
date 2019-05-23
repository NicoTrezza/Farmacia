package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import basedatos.FormaDePagoDB;
import basedatos.PersonaDB;
import basedatos.ProductoDB;
import basedatos.VentaDB;
import modelo.ProductoVendido;
import modelo.Venta;

public class TestVenta {

	public static void main(String[] args) {

		VentaDB dbV = new VentaDB();
		FormaDePagoDB dbF = new FormaDePagoDB();
		ProductoDB dbP = new ProductoDB();
		PersonaDB dbPersonas = new PersonaDB();
		List<ProductoVendido> lstProductos = new ArrayList<ProductoVendido>();

		try {
			
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
