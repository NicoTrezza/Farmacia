package test;

import basedatos.FormaDePagoDB;
import modelo.FormaDePago;

public class TestFormaPago {

	public static void main(String[] args) {

		FormaDePagoDB db = new FormaDePagoDB();

		db.insertar(new FormaDePago("Efectivo"));
		db.insertar(new FormaDePago("Tarjeta crédito"));
		db.insertar(new FormaDePago("Tarjeta débito"));

		for (FormaDePago fp : db.encontrar()) {
			System.out.println(fp.toString());
		}

		try {
			db.insertar(new FormaDePago("Cheque"));
			System.out.println(db.encontrar("Cheque"));
			db.actualizar(db.encontrar("Cheque"), "Paypal");
			db.eliminar(db.encontrar("Paypal"));
			db.eliminar();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
