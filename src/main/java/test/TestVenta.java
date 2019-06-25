package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import basedatos.EmpleadoDB;
import basedatos.ClienteDB;
import basedatos.FormaDePagoDB;
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
		EmpleadoDB dbEmpleado = new EmpleadoDB();
		ClienteDB dbCliente = new ClienteDB();
		
		SucursalDB dbSucursal = new SucursalDB();
		
		List<ProductoVendido> lstProductos = new ArrayList<ProductoVendido>();

		try {
			
			//5.cliente Marcos
			lstProductos.add(new ProductoVendido(dbP.encontrar(2005),5));
			lstProductos.add(new ProductoVendido(dbP.encontrar(2004),5));
			lstProductos.add(new ProductoVendido(dbP.encontrar(2002),5));
			
			dbV.insertar(new Venta(
					LocalDate.of(2019, 2, 5), 22, dbF.encontrar("Efectivo"),
					lstProductos,
					dbSucursal.encontrar("0001",222L),
					dbSucursal.encontrar("0001",333L),
					dbCliente.encontrar(12345687),
					dbSucursal.encontrar("0001")));
			lstProductos.clear();
			

		} catch (Exception e) {
			System.out.println(e);
		}

		for (Venta venta : dbV.encontrar()) {
			System.out.println(venta.toString());
		}
		
//		System.out.println(dbV.encontrar(LocalDate.of(2013, 6, 10),LocalDate.of(2019, 10, 02),dbSucursal.encontrar("0001")));
//		System.out.println(dbV.consulta1(LocalDate.of(2013, 6, 10),LocalDate.of(2019, 10, 02),dbSucursal.encontrar("0001")));
		
		//System.out.println(dbV.encontrar(LocalDate.of(2013, 6, 10),LocalDate.of(2019, 10, 02)));
		
	}

}
