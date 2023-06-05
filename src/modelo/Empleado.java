package modelo;

public class Empleado extends Usuario{
	
	String opciones[] = {"1. Verificar integrantes de grupo",
                         "2. Registrat consumo",
                         "3. Solicitar producto en Restaurante",
                         "4. Consultar factura",
                         "5. Guardar y salir"
            };

	public Empleado(String login, String password, String nombre, String tipo, String correo) {
		super(login, password, nombre, tipo, correo);
	}
	
	public String[] ShowOptions() {		
		return opciones;
		
	}

}

