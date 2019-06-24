package negocio;

import basedatos.ClienteDB;
import modelo.Cliente;
import modelo.Empleado;

public class ClienteABM {

	private static ClienteABM instanciaEmpresa = null;
	ClienteDB dbPersona = new ClienteDB();

	protected ClienteABM() {
	}

	public static ClienteABM getInstance() {
		if (instanciaEmpresa == null) {
			instanciaEmpresa = new ClienteABM();
		}
		return instanciaEmpresa;
	}

	public Cliente encontrarCliente(int dni) throws Exception {
		return dbPersona.encontrar(dni);
	}

//	public Empleado encontrarEmpleado(long cuil) throws Exception {
//		return dbPersona.encontrar(cuil);
//	}

}
