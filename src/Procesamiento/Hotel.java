package Procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import modelo.Adicion;
import modelo.Administrador;
import modelo.Factura;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.ItemMenu;
import modelo.Usuario;

	public class Hotel
	{
		/*Attributes*/
		
		ArrayList<String> adicionesHotel;
		private Map <String, Habitacion> habitaciones;
		private Map <String, Usuario> usuario;
		private Map <String, Huesped> huesped;
		private Map <String, ItemMenu> menu;
		private Map <String, Factura> facturas;
		
		/*Constructors*/
		
		public Hotel () throws IOException
		
		{
			this.adicionesHotel= Loader.cargarAdicionesHotel();
			this.habitaciones = Loader.cargarHabitaciones(adicionesHotel, "./data/habitaciones");
			this.usuario = Loader.cargarUsuarios("./data/usuarios");
			this.huesped= Loader.cargarHuespedes("./data/huespedes");
			this.facturas=Loader.cargarFacturas();
			this.menu = Loader.cargarPlatosBebidas();
			Loader.cargarReservas(habitaciones, huesped, facturas);			
		}
		
		
		public Map<String, Usuario> getUsuario() {
			return usuario;
		}

		public void setUsuario(Map<String, Usuario> usuario) {
			this.usuario = usuario;
		}			

		public Map<String, Habitacion> getHabitaciones() {
			return habitaciones;
		}

		public void setHabitaciones(Map<String, Habitacion> habitaciones) {
			this.habitaciones = habitaciones;
		}

		public Map<String, Huesped> getHuesped() {
			return huesped;
		}

		public void setHuesped(Map<String, Huesped> huesped) {
			this.huesped = huesped;
		}
		
		//Retorna el menu disponible para la habitacion 
		
				public ArrayList<String> getMenuHabitacion(){
					
					ArrayList<String> lista= new ArrayList<>();
					
					for (Entry<String, ItemMenu> entry : menu.entrySet()) {
					    if (entry.getValue().getTrueHabitacion().equals("habitacion")) {
					    String producto = entry.getKey();
					    lista.add(producto);}
					    }
					return lista;
				}
		
		 //Retorna el menu completo 
				
				public ArrayList<String> getMenuFull(){
					
					ArrayList<String> lista= new ArrayList<>();
					
					for (Entry<String, ItemMenu> entry : menu.entrySet()) {
					    String producto = entry.getKey();
					    lista.add(producto);
					    }
					return lista;
				}
				
				public Factura getFactura(String key) {
					return facturas.get(key);
				}
				
				public ArrayList<String>getFacturasText() {
					

					ArrayList<String> lista= new ArrayList<>();
					
					for (Entry<String, Factura> entry : facturas.entrySet()) {
					    String producto = entry.getKey();
					    lista.add(producto);
					    }
					return lista;
				}
				
		
		//anade cosas a la factura
		
		public void aniadirConsumo(String nombre, int precio, boolean pago) {
			
			
		}

		
		//Retrona precio plato por llave tipo string
		
		public int getPrecioPlato(String plato) {
			
			return menu.get(plato).getPrecio();
			
		}
		
		
}
	