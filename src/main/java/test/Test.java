package test;

import basedatos.PersonaDB;
import modelo.Cliente;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.Persona;
import modelo.ObraSocial;

public class Test {

	public static void main(String[] args) {
		
		PersonaDB db = new PersonaDB();
		
		//db.insertar(new Cliente("Juan", "Benitez", 12345687, new ObraSocial("Osecac", 1), new Domicilio("San aguston", 141, "San Nicolas", "Buenos Aires")));
		//db.insertar(new Cliente("Norma", "Andres", 32165498, new ObraSocial("Pami", 1), new Domicilio("Gral Belgrano", 10, "Lanus", "Buenos Aires")));
		//db.insertar(new Empleado("Lionel", "Messi", 98765412, new ObraSocial("Galeno", 1), new Domicilio("San Martin", 11, "Avellaneda", "Buenos Aires"), 20987654120L));
		//db.insertar(new Empleado("Gonzalo", "Banzas", 65498722, null, new Domicilio("Martinez", 666, "Belgrano", "Buenos Aires"), 20654987220L));

		for (Persona persona : db.encontrar()) {
			System.out.println(persona);
		}
		
	}

}
