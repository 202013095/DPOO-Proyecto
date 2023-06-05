package modelo;

public class Administrador extends Usuario{
	
	/*Atributes*/
	

	String opciones[] = {"GESTIONAR HABITACIONES",
			"1. Modificar precio de habitaciones",
            "2. Modificar precio de una habitacion",
            "3. Modificar adiciones de una habitacion",
            "4. Modificar camas de una habitacion",
            "5. Modificar precio de una habitacion",
            "6. Agregar habitacion", 
			"GESTIONAR PROMOCIONES Y DESCUENTOS",
			"7. Modificar tarifas de temporada",
            "8. Agregar tarifas temporada",
            "9. Eliminar tarifas de temporada",
            "10.Agregar descuento por rango de fechas",
			"GESTIONAR SERVICIOS",
			"11.Agregar Servicio",
            "12.Eliminar servicio",
			"SALIRY GUARDAR CAMBIOS",
			"13.Salir"};
			             

	public Administrador(String login, String password, String nombre, String usuario, String correo) {
		super(login, password, nombre, usuario, correo);
		// TODO Auto-generated constructor stub
	}

	public String[] ShowOptions() {		
		return opciones;
		
	}
	
	
	
	/*Falta Implementacion: Eliminar los prints*/
	public static void modificarPrecioHabitaciones() {
		
		System.out.println("Precio modificado exitosamente");
	}
	
	public static  void modificarPrecioUnaHabitacion() {
    	
    	System.out.println("Precio de la habitacion xx modificado exitosamente");
    }
	
	public static  void AdicionesHabitaciones() {
    	System.out.println("Habitacion editada correctamente");
    }
    
	public static  void CamasEnHabitacines() {
    	System.out.println("Habitacion editada correctamente");
    }
    
	public static  void PrecioHabitaciones() {
    	System.out.println("Precio editado correctamente");   
    }
    
	public static  void AgrgarHabitacion() {
    	System.out.println("Habitacion agregada exitosamente");
    }
    
	public static  void GuardarCambios() {
    	System.out.println("Cambios guardados de manera exitosa");
    }
    	
    
    }
	
