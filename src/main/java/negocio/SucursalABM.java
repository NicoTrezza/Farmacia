package negocio;

import basedatos.SucursalDB;
import modelo.Sucursal;

public class SucursalABM {

	private static SucursalABM instanciaEmpresa = null;
	SucursalDB dbSucursal = new SucursalDB();
	
	protected SucursalABM() {
	}

	public static SucursalABM getInstance() {
		if (instanciaEmpresa == null) {
			instanciaEmpresa = new SucursalABM();
		}
		return instanciaEmpresa;
	}

	public Sucursal encontrar(String ticketFiscal) {
		return dbSucursal.encontrar(ticketFiscal);
	}
	
}
