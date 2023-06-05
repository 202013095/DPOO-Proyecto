package modelo;

public class Cama 
{
	//Atributos
	private String tipo;
	private int capacidad;
	private float precio;
	
	//Generador
	public Cama(String tipo, int capacidad, float precio)
	{
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.precio = precio;
	}
	
	//Getters and Setters
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}
