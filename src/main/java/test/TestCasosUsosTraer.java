package test;

import java.time.LocalDate;
import org.bson.Document;
import basedatos.VentaDB;

public class TestCasosUsosTraer {

	public static void main(String[] args) throws Exception {
		VentaDB dbV = new VentaDB();
		
		System.out.println("Caso Uso 1:");
		for (Document venta : dbV.consulta1(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 2, 1))) {
			System.out.println(venta);
		}
		
		System.out.println("Caso Uso 2:");
		for (Document venta : dbV.consulta2(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 2, 1))) {
			System.out.println(venta);
		}
		
		System.out.println("Caso Uso 3:");
		for (Document venta : dbV.consulta3(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 2, 1))) {
			System.out.println(venta);
		}
		
		System.out.println("Caso Uso 4:");
		for (Document venta : dbV.consulta4(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 2, 1))) {
			System.out.println(venta);
		}
		
		System.out.println("Caso Uso 5:");
		for (Document venta : dbV.consulta5(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 2, 1))) {
			System.out.println(venta);
		}
		
		System.out.println("Caso Uso 6:");
		for (Document venta : dbV.consulta6(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 2, 1))) {
			System.out.println(venta);
		}
		
		System.out.println("Caso Uso 7:");
		for (Document venta : dbV.consulta7(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 2, 1))) {
			System.out.println(venta);
		}
		
		System.out.println("Caso Uso 8:");
		for (Document venta : dbV.consulta8(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 2, 1))) {
			System.out.println(venta);
		}
		
	}

}
