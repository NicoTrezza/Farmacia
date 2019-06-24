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
import modelo.Persona;
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
		
		dbEmpleado.insertar(new Empleado("Lionel", "Messi", 98765412, new ObraSocial("Galeno", 333), new Domicilio("San Martin", 11, "Avellaneda", "Buenos Aires"), 20987654120L));
		dbEmpleado.insertar(new Empleado("Gonzalo", "Banzas", 65498722, null, new Domicilio("Martinez", 666, "Belgrano", "Buenos Aires"), 20654987220L));
		dbEmpleado.insertar(new Empleado("Victor", "Ibañez", 36068006, new ObraSocial("IOMA", 666), new Domicilio("Calle 832", 2070, "Quilmes", "Buenos Aires"), 111));
		dbEmpleado.insertar(new Empleado("Nico", "Trezza", 12345678, new ObraSocial("IOMA", 667), new Domicilio("Calle A", 777, "Turdela", "Buenos Aires"), 222));
		dbEmpleado.insertar(new Empleado("Pablo", "Lopez", 38601565, new ObraSocial("IOMA", 668), new Domicilio("Calle B", 2200, "Temperley", "Buenos Aires"), 333));
		
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
			dbSucursal.insertar(new Sucursal(encargado, empleados, "0002-00001234", new Domicilio("Calle B", 2200, "Temperley", "Buenos Aires")));
			dbSucursal.insertar(new Sucursal(encargado, empleados, "0003-00001234", new Domicilio("Calle B", 2200, "Temperley", "Buenos Aires")));
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		for (Sucursal sucursal : dbSucursal.encontrar()) {
			System.out.println("Sucursal : "+sucursal.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
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
			List<ProductoVendido> lstProductos = new ArrayList<ProductoVendido>();
			lstProductos.add(new ProductoVendido(dbP.encontrar(20022),3));
			lstProductos.add(new ProductoVendido(dbP.encontrar(20028),1));
			dbV.insertar(new Venta(LocalDate.now(), 1, dbF.encontrar("Efectivo"), lstProductos, dbEmpleado.encontrar(20987654120L), dbEmpleado.encontrar(20654987220L), dbCliente.encontrar(12345687), dbSucursal.encontrar("0001-00001234")));
		} catch (Exception e) {
			System.out.println(e);
		}

		for (Venta venta : dbV.encontrar()) {
			System.out.println("Venta : "+venta.toJson().toJson(new JsonWriterSettings(JsonMode.SHELL)));
		}
		
	}

}
