package modelo;

import java.util.ArrayList;

public class Habitacion 
{
	//Atributos
	private String idHabitacion;
	private String tipoHabitacion;
	private ArrayList<Cama> listaCamas;
	private ArrayList<Adicion> listaAdiciones;
	private ArrayList<String> listaAdHotel;
	private ArrayList<Reserva> listaReservas;
	private int capacidad;
	private int precioBase;
	private float precioFinal;
	 
	//Generador
	public Habitacion(String idHabitacion, String tipoHabitacion, ArrayList<Cama> listaCamas, ArrayList<Adicion> listaAdiciones, int capacidad, int precioBase, int precioFinal,  ArrayList<String> lista)
	{
		this.idHabitacion = idHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.listaCamas = listaCamas;
		this.listaAdiciones = listaAdiciones;
		this.listaReservas = new ArrayList<Reserva>();
		this.listaAdHotel = lista;
		this.capacidad = capacidad;
		this.precioBase = precioBase;
		this.precioFinal = precioFinal;
	}

	public int getPrecioBase() {
		return precioBase;
	}

	public ArrayList<String> getAdicionesHotel() {
		return listaAdHotel;
	}
	
	public  void setAdicionesHotel(ArrayList<String> lista) {
		listaAdHotel=lista;
	}
	
	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}

	//Getters and Setters
	public String getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(String idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public ArrayList<Cama> getListaCamas() {
		return listaCamas;
	}

	public void setListaCamas(ArrayList<Cama> listaCamas) {
		this.listaCamas = listaCamas;
	}

	public ArrayList<Adicion> getListaAdiciones() {
		return listaAdiciones;
	}

	public void setListaAdiciones(ArrayList<Adicion> listaAdiciones) {
		this.listaAdiciones = listaAdiciones;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public float getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	
	
	//Metodos
	
	
	
}
