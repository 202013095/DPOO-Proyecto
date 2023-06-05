package modelo;

import java.util.ArrayList;

public class ItemMenu {
	
	//Atributos
	private String nombrePlato;
	private String paraHabitacion;
	private String tipoPlato;
	private int precio;
	
	//Generador
	public ItemMenu(String nombre, String habitacion,String tipo, int precio)
	{
		this.nombrePlato = nombre;
		this.paraHabitacion = habitacion;
		this.tipoPlato = tipo;
		this.precio = precio;
	}
	
	public String getNombre() {
			return nombrePlato;
		
	}
	
	public String getTipo() {
		return tipoPlato;
	
}
	public String getTrueHabitacion() {
		return paraHabitacion;
	
}
	public int getPrecio() {
		return precio;
	}

	}