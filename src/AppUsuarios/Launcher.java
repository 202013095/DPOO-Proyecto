package AppUsuarios;

import java.io.IOException;

import Procesamiento.Hotel;
import gui.VentanaEntrada;

public class Launcher {
	
	private static Hotel hotel;
	
	/*METODO MAIN*/	
	public static void main(String[] args) throws IOException
	{	
		
		hotel = new Hotel();
		new VentanaBienvenida(hotel);
		//new VentanaHabitacion();
	}

}
