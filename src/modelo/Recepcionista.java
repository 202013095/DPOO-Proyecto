package modelo;

public class Recepcionista extends Usuario{
	
	String opciones[] = {"1. Gestionar Reservas",
		                 "2. Registrar Huesped o Grupo",
		                 "3. Obtener Factura",
		                 "4. Consultar Habitaciones"
		                 };

	public Recepcionista(String login, String password, String nombre, String tipo, String correo) {
		super(login, password, nombre, tipo, correo);
	}
	
	public String[] ShowOptions() {		
		return opciones;
		
	}
	
	

}
