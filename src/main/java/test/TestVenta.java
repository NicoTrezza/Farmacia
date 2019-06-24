package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import basedatos.FormaDePagoDB;
import basedatos.PersonaDB;
import basedatos.ProductoDB;
import basedatos.SucursalDB;
import basedatos.VentaDB;
import modelo.ProductoVendido;
import modelo.Venta;

public class TestVenta {

	public static void main(String[] args) {

		VentaDB dbV = new VentaDB();
		FormaDePagoDB dbF = new FormaDePagoDB();
		ProductoDB dbP = new ProductoDB();
		PersonaDB dbPersonas = new PersonaDB();
		SucursalDB dbSucursal = new SucursalDB();
		
		List<ProductoVendido> lstProductos = new ArrayList<ProductoVendido>();

		try {
			
			lstProductos.add(new ProductoVendido(dbP.encontrar(20022),3));
			lstProductos.add(new ProductoVendido(dbP.encontrar(20028),1));
			dbV.insertar(new Venta(LocalDate.now(), 1, dbF.encontrar("Efectivo"), lstProductos, dbPersonas.encontrar(20987654120L), dbPersonas.encontrar(20654987220L), dbPersonas.encontrar(12345687), dbSucursal.encontrar("0001-00001234")));

		} catch (Exception e) {
			System.out.println(e);
		}

		for (Venta venta : dbV.encontrar()) {
			System.out.println(venta.toString());
		}
		
		System.out.println(dbV.encontrar(LocalDate.of(2013, 6, 10),LocalDate.of(2019, 10, 02)));
		
	}

}
