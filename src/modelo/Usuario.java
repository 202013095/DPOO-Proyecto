package modelo;

public class Usuario 
{
	//Atributos
	private String login;
	private String password;
	private String nombre;
	private String tipoUsuario;
	private String correo;
	//public Calendar calendario= new GregorianCalendar();
	
	//Generador
	public Usuario(String login, String password, String nombre, String usuario, String correo)
	{
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.tipoUsuario = usuario;
		this.correo = correo;
	}

	//Getters and Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String[] ShowOptions() {
		return null;	
	}
	
	public static String[] ReturnOptionInput(int input) {	
		return null;
	}
}
