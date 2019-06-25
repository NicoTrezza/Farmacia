package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import basedatos.ClienteDB;
import basedatos.EmpleadoDB;
import basedatos.FormaDePagoDB;
import basedatos.ProductoDB;
import basedatos.SucursalDB;
import basedatos.VentaDB;
import modelo.Cliente;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.FormaDePago;
import modelo.Producto;
import modelo.ProductoVendido;
import modelo.Sucursal;
import modelo.Venta;
import modelo.ObraSocial;

public class Test {

	public static void main(String[] args) {
		
		// Cliente
		ClienteDB dbCliente = new ClienteDB();
		
		dbCliente.insertar(new Cliente("Juan", "Benitez", 12345687, new ObraSocial("Osecac", 122), new Domicilio("San aguston", 141, "San Nicolas", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Norma", "Andres", 32165498, new ObraSocial("Pami", 222), new Domicilio("Gral Belgrano", 122, "Lanus", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Marcos", "Ibañez", 12345687, new ObraSocial("Osecac", 123), new Domicilio("San aguston", 133, "San Nicolas", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Damian", "Santi.", 32165498, new ObraSocial("Pami", 223), new Domicilio("Gral Belgrano", 144, "Lanus", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Martín", "O.", 12345687, new ObraSocial("Osecac", 124), new Domicilio("San aguston", 155, "San Nicolas", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Nehuén", "V.", 32165498, new ObraSocial("Pami", 224), new Domicilio("Gral Belgrano", 166, "Lanus", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Jonathan", "M.", 12345687, new ObraSocial("Osecac", 125), new Domicilio("San aguston", 177, "San Nicolas", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Florencia", "L.", 32165498, new ObraSocial("Pami", 225), new Domicilio("Gral Belgrano", 188, "Lanus", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Cristina", "Samaniego", 12345687, new ObraSocial("Osecac", 126), new Domicilio("San aguston", 199, "San Nicolas", "Buenos Aires")));
		dbCliente.insertar(new Cliente("Analáa", "Quiroga", 32165498, new ObraSocial("Pami", 226), new Domicilio("Gral Belgrano", 200, "Lanus", "Buenos Aires")));
		
		for (Cliente persona : dbCliente.encontrar()) {
			System.out.println("Cliente : "+persona.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}
		
		// Cliente
		EmpleadoDB dbEmpleado = new EmpleadoDB();
		
		dbEmpleado.insertar(new Empleado("Lionel", "Messi", 12345680, new ObraSocial("Galeno", 333), new Domicilio("San Martin", 11, "Avellaneda", "Buenos Aires"), 555l));
		dbEmpleado.insertar(new Empleado("José", "Lucero", 12345679, null, new Domicilio("Martinez", 666, "Belgrano", "Buenos Aires"), 444l));
		dbEmpleado.insertar(new Empleado("Victor", "Ibañez", 36068006, new ObraSocial("IOMA", 666), new Domicilio("Calle 832", 2070, "Quilmes", "Buenos Aires"), 333l));
		dbEmpleado.insertar(new Empleado("Nico", "Trezza", 12345678, new ObraSocial("IOMA", 667), new Domicilio("Calle A", 777, "Turdela", "Buenos Aires"), 222l));
		dbEmpleado.insertar(new Empleado("Pablo", "Lopez", 38601565, new ObraSocial("IOMA", 668), new Domicilio("Calle B", 2200, "Temperley", "Buenos Aires"), 111l));
		
		for (Empleado persona : dbEmpleado.encontrar()) {
			System.out.println("Empleado : "+persona.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}
		
		
		// Sucursales
		SucursalDB dbSucursal = new SucursalDB();
		
		try {
			Empleado encargado = dbEmpleado.encontrar(111l);
			List<Empleado> empleados = new ArrayList<Empleado>();
			
			empleados.add(dbEmpleado.encontrar(222l));
			empleados.add(dbEmpleado.encontrar(333l));
			dbSucursal.insertar(new Sucursal(encargado, empleados, "0001-00001234", new Domicilio("Calle B", 2200, "Temperley", "Buenos Aires")));
			empleados.clear();
			empleados.add(dbEmpleado.encontrar(555l));
			dbSucursal.insertar(new Sucursal(encargado, empleados, "0002-00001234", new Domicilio("Calle B", 2200, "Temperley", "Buenos Aires")));
			empleados.clear();
			empleados.add(dbEmpleado.encontrar(444l));
			empleados.add(dbEmpleado.encontrar(111l));
			dbSucursal.insertar(new Sucursal(encargado, empleados, "0003-00001234", new Domicilio("Calle B", 2200, "Temperley", "Buenos Aires")));
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		for (Sucursal sucursal : dbSucursal.encontrar()) {
			System.out.println("Sucursal : "+sucursal.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}
		
		
		// Productos
		ProductoDB dbprod = new ProductoDB();
		
		dbprod.insertar(new Producto("Medicamento", "Remedio1", "BL", 1001, 20));
		dbprod.insertar(new Producto("Medicamento", "Remedio2", "IN", 1002, 180));
		dbprod.insertar(new Producto("Medicamento", "Remedio3", "BÓ", 1003, 400));
		dbprod.insertar(new Producto("Medicamento", "Aspirina1", "BY", 2001, 59));
		dbprod.insertar(new Producto("Medicamento", "Aspirina2", "GSK", 2002, 100));
		dbprod.insertar(new Producto("Medicamento", "Aspirina3", "MA", 2003, 450));
		dbprod.insertar(new Producto("Medicamento", "Aspirina4", "MA", 2004, 300));
		dbprod.insertar(new Producto("Medicamento", "Aspirina5", "DF", 2005, 765));
		dbprod.insertar(new Producto("Perfumería", "EnjuagueA", "CG", 30001, 95));
		dbprod.insertar(new Producto("Perfumería", "DesodoranteA", "ST", 30002, 45));
		dbprod.insertar(new Producto("Perfumería", "TalcoA", "RX", 30003, 50));
		
		for (Producto producto : dbprod.encontrar()) {
			System.out.println("Productos : "+producto.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}
		
		// FormaDePagos
		FormaDePagoDB dbFormaDePAgo = new FormaDePagoDB();

		dbFormaDePAgo.insertar(new FormaDePago("Efectivo"));
		dbFormaDePAgo.insertar(new FormaDePago("Tarjeta crédito"));
		dbFormaDePAgo.insertar(new FormaDePago("Tarjeta débito"));
		
		for (FormaDePago fp : dbFormaDePAgo.encontrar()) {
			System.out.println("FormaDePagos : "+fp.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}
		

		// Ventas
		VentaDB dbV = new VentaDB();
		
		try {
			FormaDePagoDB dbF = new FormaDePagoDB();
			ProductoDB dbP = new ProductoDB();
			// Sucursal 0001
			// empleados 222l, 333l
				//-----Mes 1------//
				//1.cliente Benitez
				List<ProductoVendido> lstProductos = new ArrayList<ProductoVendido>();
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),3));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 1, 1), 10, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//2.cliente Benitez
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),3));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30003),5));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 1, 2), 11, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//3.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 1, 2), 13, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//4.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),3));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 1, 5), 14, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//5.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),5));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),5));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 1, 15), 15, dbF.encontrar("Tarjeta débito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//6.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),5));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),5));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2002),5));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),5));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 1, 30), 16, dbF.encontrar("Tarjeta débito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//-----Mes 2------//
				//7.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),3));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 2, 5), 21, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//8.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30003),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 2, 10), 22, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//9.cliente Benitez
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 2, 11), 23, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//10.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30003),2));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 2, 12), 24, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//11.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2003),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),3));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 2, 14), 25, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//12.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 2, 28), 26, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//------Mes 3-----//
				//13.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 3), 31, dbF.encontrar("Tarjeta débito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//14.cliente Benitez
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30003),4));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 3), 32, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//15.cliente Benitez
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 4), 33, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//16.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 4), 34, dbF.encontrar("Tarjeta débito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//17.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),3));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 5), 35, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//18.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 10), 36, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//19.cliente Benitez
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 11), 37, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//20.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30003),2));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 12), 38, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//21.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2003),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),3));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 14), 39, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//22.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 29), 40, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//23.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),10));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 30), 39, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//24.cliente Benitez
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 3, 30), 40, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//-----Mes 4------//
				//25.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 4, 3), 41, dbF.encontrar("Tarjeta débito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//26.cliente Benitez
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30003),4));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 4, 3), 42, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//27.cliente Benitez
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 4, 4), 43, dbF.encontrar("Efectivo"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//28.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 4, 4), 44, dbF.encontrar("Tarjeta débito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(12345687),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//29.cliente Andres
				lstProductos.add(new ProductoVendido(dbP.encontrar(1001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1002),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(1003),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2005),2));
				lstProductos.add(new ProductoVendido(dbP.encontrar(2004),3));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 4, 6), 45, dbF.encontrar("Tarjeta crédito"),
						lstProductos,
						dbSucursal.encontrar("0001",222L),
						dbSucursal.encontrar("0001",333L),
						dbCliente.encontrar(32165498),
						dbSucursal.encontrar("0001")));
				lstProductos.clear();
				//30.cliente Marcos
				lstProductos.add(new ProductoVendido(dbP.encontrar(30001),1));
				lstProductos.add(new ProductoVendido(dbP.encontrar(30002),1));
				dbV.insertar(new Venta(
						LocalDate.of(2019, 4, 11), 46, dbF.encontrar("Efectivo"),
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
			System.out.println("Venta : "+venta.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}
		
	}

}
