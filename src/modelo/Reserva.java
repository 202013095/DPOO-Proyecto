package modelo;

import java.util.ArrayList;

public class Reserva extends Fecha{
	
	private boolean checkIn;
	private ArrayList<String> listaHuespedes;
	private Factura factura;
	private String habitacion;
	
	public Reserva(String fechaInit, String fechaFinit, boolean checkIn, ArrayList<String> listaHuespedes) {
		super(fechaInit, fechaFinit);		
		this.checkIn = checkIn;
		this.listaHuespedes = listaHuespedes;
	}

	public boolean getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}

	public ArrayList<String> getListaHuespedes() {
		return listaHuespedes;
	}

	public void setListaHuespedes(ArrayList<String> listaHuespedes) {
		this.listaHuespedes = listaHuespedes;
	}
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}
}
