package test;

import org.junit.Assert;
import java.io.IOException;

import javax.swing.DefaultListModel;

import Procesamiento.Hotel;
import gui.PanelReservas;
import gui.VentanaCrearHuesped;
import junit.framework.TestCase;

public class ReservasTest extends TestCase{
	
	private Hotel hotel;
	private PanelReservas reservas;
	private VentanaCrearHuesped huesped;

	
	/**
	 * @BeforeEach
	 */		
    public void setUp() {
        try {
        	hotel = new Hotel();
            reservas = new PanelReservas(hotel);
            reservas.setVisible(false);
        }catch (Exception e) {
        	e.printStackTrace();
		}
    }
        
	/**
	 * @Test 
	 * @DisplayName("Get Nombre")
	 */	
    public void testGetNombreResponsable() {
    	setUp();
    	reservas.setResponsable("nombre");
    	Assert.assertEquals("nombre", reservas.getResponsable());
    }
        
	/**
	 * @Test 
	 * @DisplayName("Get Fecha Init")
	 */	
    public void testGetFechaInit() {
    	setUp();
    	reservas.setFechaInit("04/06/2023");
    	Assert.assertEquals("04/06/2023", reservas.getFechaInit());
    }
    
	/**
	 * @Test 
	 * @DisplayName("Get Fecha Finit")
	 */	
    public void testGetFechaFinit() {
    	setUp();
    	reservas.setFechaFinit("04/06/2023");
    	Assert.assertEquals("04/06/2023", reservas.getFechaFinit());    
    }   
    
	/**
	 * @Test 
	 * @DisplayName("Buscar Habitacion")
	 */	
	public void testBuscarHabitacion() throws IOException {
		setUp();
		
		DefaultListModel<String> habitaciones = new DefaultListModel<>();
      
        reservas.setResponsable("nombre");
        reservas.setFechaInit("04/06/2023");
        reservas.setFechaFinit("15/06/2023");
        reservas.buscarHabitacion(habitaciones, hotel);
	
        Assert.assertEquals(32, habitaciones.size()); 
        Assert.assertEquals("22----estandar----13----Doble,Queen----Calefaccion,Tv,Cafetera,Plancha,Secador,TomaA,TomaC,Desayuno----574000.0", habitaciones.get(0));
        Assert.assertEquals("21----suite----4----Doble----Calefaccion,Tv,Cafetera,Plancha----219000.0", habitaciones.get(31));
	}
    
	/**
	 * @Test 
	 * @DisplayName("Buscar Habitacion con restriccion de personas")
	 */	
	public void testBuscarHabitacion1() throws IOException {
		setUp();
		
		DefaultListModel<String> habitaciones = new DefaultListModel<>();
      
        reservas.setResponsable("nombre");
        reservas.setFechaInit("04/06/2023");
        reservas.setFechaFinit("15/06/2023");
        reservas.setNumAdultos(5);
        reservas.setNumAdultos(5);
        reservas.buscarHabitacion(habitaciones, hotel);
	
        Assert.assertEquals(12, habitaciones.size()); 
        Assert.assertEquals("22----estandar----13----Doble,Queen----Calefaccion,Tv,Cafetera,Plancha,Secador,TomaA,TomaC,Desayuno----574000.0", habitaciones.get(0));
        Assert.assertEquals("33----suite----13----Doble,Queen----Calefaccion,Tv,Cafetera,Plancha,TomaA----464000.0", habitaciones.get(6));
	}
    
	/**
	 * @Test 
	 * @DisplayName("Buscar Habitacion con nombre vacias")
	 */	
	public void testBuscarHabitacion2() throws IOException {
		setUp();
		
		DefaultListModel<String> habitaciones = new DefaultListModel<>();
      
        reservas.setResponsable("");
        reservas.setFechaInit("04/06/2023");
        reservas.setFechaFinit("15/06/2023");
        reservas.buscarHabitacion(habitaciones, hotel);
	
        Assert.assertEquals(0, habitaciones.size()); 
	}
	
	/**
	 * @Test 
	 * @DisplayName("Buscar Habitacion con fechas no validas")
	 */	
	public void testBuscarHabitacion3() throws IOException {
		setUp();
		
		DefaultListModel<String> habitaciones = new DefaultListModel<>();
      
        reservas.setResponsable("nombre");
        reservas.setFechaInit("0406%2023");
        reservas.setFechaFinit("1/5062$23");
        reservas.buscarHabitacion(habitaciones, hotel);
	
        Assert.assertEquals(0, habitaciones.size()); 
	}
	
	/**
	 * @Test 
	 * @DisplayName("Crear huesped")
	 */	
	public void testCrearHuesped() throws IOException {
    	huesped = new VentanaCrearHuesped(2, "Crear");
    	huesped.setVisible(false);
    	
    	huesped.setNombre("Nombre Apellido");
    	huesped.setDoc("10344310");
    	huesped.setCorreo("correo@gmail.com");
    	huesped.setCelu("32044444");
    	huesped.setEdad("19");
    	    	
    	Assert.assertEquals("Nombre Apellido",huesped.getNombre());
    	Assert.assertEquals("10344310", huesped.getDoc());  
    	Assert.assertEquals("correo@gmail.com", huesped.getCorreo());  
    	Assert.assertEquals("32044444", huesped.getCelu());  
    	Assert.assertEquals("19", huesped.getEdad());  
	}
}

