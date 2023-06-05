package modelo;

public class Descuento extends Fecha{

	//Atributos
	private float descuento;
	
	//Generador
	public Descuento(String fechaInit, String fechaFinit, float descuento) {
		super(fechaInit, fechaFinit);
		
		this.descuento = descuento;
	}
	
	//Getters and Setters
	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
}
