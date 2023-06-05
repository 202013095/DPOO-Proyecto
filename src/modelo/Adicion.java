package modelo;

public class Adicion
{
	//Atributos
	private String adicion;
	private Float precio;
	
	//Generador
	public Adicion(String adicion, Float precio)
	{
		this.adicion = adicion;
		this.precio = precio;
	}

	//Getters and Setters
	public String getAdicion() {
		return adicion;
	}

	public void setAdicion(String adicion) {
		this.adicion = adicion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}	
}
