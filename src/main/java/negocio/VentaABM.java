package negocio;

import java.time.LocalDate;
import java.util.List;

import basedatos.VentaDB;
import modelo.Sucursal;
import modelo.Venta;

public class VentaABM {

	private static VentaABM instanciaEmpresa = null;
	VentaDB dbV = new VentaDB();
	
	protected VentaABM() {
	}

	public static VentaABM getInstance() {
		if (instanciaEmpresa == null) {
			instanciaEmpresa = new VentaABM();
		}
		return instanciaEmpresa;
	}
	
	
	public List<Venta> DetalleVentas(LocalDate date, LocalDate date2){
		return dbV.encontrar(date,date2);
	}
	
	public List<Venta> DetalleVentas(LocalDate date, LocalDate date2, Sucursal sucursal){
		return dbV.encontrar(date,date2,sucursal);
	}
	
	public List<Venta> encontrar(LocalDate date, LocalDate date2){
		return dbV.encontrar(date,date2);
	}


}
