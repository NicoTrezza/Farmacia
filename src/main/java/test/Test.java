package test;

import basedatos.ObraSocialDB;
import modelo.ObraSocial;

public class Test {

	public static void main(String[] args) {
		
		ObraSocialDB db = new ObraSocialDB();
		
		//db.insertar(new ObraSocial("Ocecac", 1));
		//db.insertar(new ObraSocial("Galeno", 2));
		//db.insertar(new ObraSocial("Pami", 3));
		
		for (ObraSocial obraSocial : db.encontrar()) {
			System.out.println(obraSocial);
		}
		
	}

}
