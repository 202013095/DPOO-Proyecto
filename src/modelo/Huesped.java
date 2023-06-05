package modelo;

public class Huesped 
{
	//Atributos
	private String nombre;
	private String documento;
	private String correo;
	private String celular;
	private String edad;
	
	//Generador
	public Huesped(String nombre, String documento, String correo, String celular, String edad)  
	{
		this.nombre = nombre;
		this.documento = documento;
		this.correo = correo;
		this.celular = celular;
		this.edad =  edad;
	}

	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	// Métodos sobrecargados de una superclase
	@Override
	public boolean equals(Object obj)
	{
		if (obj.getClass() != this.getClass())
			return false;
		else
		{
			Huesped otro = (Huesped) obj;
			return this.nombre.equals(otro.nombre);
		}
	}
			
}
