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
import modelo.Cliente;
import modelo.Empleado;
import modelo.FormaDePago;

import modelo.Producto;

import modelo.Sucursal;
import modelo.Venta;
import negocio.SucursalABM;
import negocio.VentaABM;

public class TestTraer {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		ClienteDB dbCliente = new ClienteDB();
		EmpleadoDB dbEmpleado = new EmpleadoDB();
		
		
		SucursalDB dbSucursal = new SucursalDB();
		ProductoDB dbprod = new ProductoDB();
		FormaDePagoDB dbFormaDePAgo = new FormaDePagoDB();


		// Cliente
		for (Cliente persona : dbCliente.encontrar()) {
			System.out.println("Cliente : "+persona.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}

		// Empleado
		for (Empleado persona : dbEmpleado.encontrar()) {
			System.out.println("Empleado : "+persona.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}

		// Sucursales
		for (Sucursal sucursal : dbSucursal.encontrar()) {
			System.out.println("Sucursal : "+sucursal.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}

		// Productos
		for (Producto producto : dbprod.encontrar()) {
			System.out.println("Productos : "+producto.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}

		// FormaDePagos
		for (FormaDePago fp : dbFormaDePAgo.encontrar()) {
			System.out.println("FormaDePagos : "+fp.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}

		// Ventas
		for (Venta venta : dbV.encontrar()) {
			System.out.println("Venta : "+venta.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}
		
		
		VentaDB dbV = new VentaDB();
		
		//test 1
		int total = 0;
		System.out.println("Venta :");
		for (Venta venta : dbV.consulta1(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 3, 30),SucursalABM.getInstance().encontrar("0001"))) {
			System.out.println(venta.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
			total += 1;
		}
		System.out.println("total: "+total+" ventas de la sucursal: "+SucursalABM.getInstance().encontrar("0001").getTicketFiscal()+", Fechas entre "+LocalDate.of(2019, 1, 1).toString()+" y "+LocalDate.of(2019, 3, 30).toString());
		
		//test 2
		
	}

}
