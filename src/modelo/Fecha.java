package modelo;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Fecha 
{
	//Atributos
	private LocalDate fechaInit;
	private LocalDate fechaFinit;
	
	//Generador
	public Fecha(String fechaInit, String fechaFinit)
	{
		this.fechaInit = LocalDate.parse(fechaInit, DateTimeFormatter.ofPattern("d/M/yyyy"));
		this.fechaFinit = LocalDate.parse(fechaFinit, DateTimeFormatter.ofPattern("d/M/yyyy"));		
	}

	//Getters and Setters
	public LocalDate getFechaInit() {
		return fechaInit;
	}

	public void setFechaInit(LocalDate fechaInit) {
		this.fechaInit = fechaInit;
	}

	public LocalDate getFechaFinit() {
		return fechaFinit;
	}

	public void setFechaFinit(LocalDate fechaFinit) {
		this.fechaFinit = fechaFinit;
	}
}
