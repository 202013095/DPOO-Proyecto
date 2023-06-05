package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Procesamiento.Hotel;
import gui.VentanaEntrada;
import gui.VentanaHabitacion;

public class ConsolaApp{

	private static Hotel hotel;

	/*METODO MAIN*/	
	public static void main(String[] args) throws IOException
	{	
		hotel = new Hotel();
		new VentanaEntrada(hotel);
		//new VentanaHabitacion();
	}
	

    /*INPUT*/
	public String input(String mensaje)
		{
			try
			{
				System.out.print(mensaje + ": ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				return reader.readLine();
			}
			catch (IOException e)
			{
				System.out.println("Error leyendo de la consola");
				e.printStackTrace();
			}
			return null;
		}
	}
