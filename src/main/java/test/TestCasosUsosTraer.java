package test;

import java.time.LocalDate;

import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import basedatos.ClienteDB;
import basedatos.EmpleadoDB;
import basedatos.FormaDePagoDB;
import basedatos.ProductoDB;
import basedatos.SucursalDB;
import basedatos.VentaDB;

import modelo.Venta;

public class TestCasosUsosTraer {

	public static void main(String[] args) throws Exception {

		ClienteDB dbCliente = new ClienteDB();
		EmpleadoDB dbEmpleado = new EmpleadoDB();
		
		SucursalDB dbSucursal = new SucursalDB();
		ProductoDB dbprod = new ProductoDB();
		FormaDePagoDB dbFormaDePAgo = new FormaDePagoDB();
		
		VentaDB dbV = new VentaDB();
		
		//test 1
		int total = 0;
		System.out.println("Caso Uso 1:");
		for (Venta venta : dbV.consulta1(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 3, 30),dbSucursal.encontrar("0001"))) {
			System.out.println(venta.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
			total += 1;
		}
		System.out.println("total: "+total+" ventas de la sucursal: "+dbSucursal.encontrar("0001").getTicketFiscal()+", Fechas entre "+LocalDate.of(2019, 1, 1).toString()+" y "+LocalDate.of(2019, 3, 30).toString());
		
		//test 2

	}

}
