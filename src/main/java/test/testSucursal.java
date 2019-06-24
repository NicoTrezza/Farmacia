package test;

import java.util.ArrayList;
import java.util.List;

import basedatos.SucursalDB;
import modelo.Sucursal;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.ObraSocial;

public class testSucursal {

	public static void main(String[] args) {
		SucursalDB dbSucursal = new SucursalDB();
		ObraSocial obraSocial = new ObraSocial("IOMA", 666);
		Domicilio domicilio = new Domicilio("Calle Falsa", 123, "Temperley", "Buenos Aires");
		Domicilio domicilio1 = new Domicilio("Calle Falsa", 456, "Temperley", "Buenos Aires");
		Empleado encargado = new Empleado("Victor", "Ibañez", 98765432, obraSocial, domicilio, 111);
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		empleados.add(new Empleado("Nico", "Trezza", 12345678, obraSocial, domicilio, 222));
		empleados.add(new Empleado("Pablo", "Lopez", 38601565, obraSocial, domicilio, 333));
		
		Sucursal sucursal = new Sucursal(encargado, empleados, "0001-00001234", domicilio1);
		dbSucursal.insertar(sucursal);
		
		/*try {
			dbSucursal.actualizar(encargado, empleados, "0001-00001234", domicilio1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			dbSucursal.eliminar(sucursal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println(dbSucursal.encontrar("0001-00001234"));
	}

}
