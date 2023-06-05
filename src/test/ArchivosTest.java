package test;

import org.junit.Assert;

import junit.framework.TestCase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ArchivosTest extends TestCase{
	    
    public void testCargarAdiciones() {
    	String archivo = "./data/adiciones";
    	testArchicoExiste(archivo);
    	testArchivoVacio(archivo);
    	testFormatoValido(archivo);
    	testLineasDuplicadas(archivo);
    	testCaracteresRaros(archivo);
    }
    
    public void testCargarCamas() {
    	String archivo = "./data/camas";
    	testArchicoExiste(archivo);
    	testArchivoVacio(archivo);
    	testFormatoValido(archivo);
    	testLineasDuplicadas(archivo);
    	testCaracteresRaros(archivo);
    	testLineaVacia(archivo);
    }
    
    public void testCargarHabitaciones() {  
    	String archivo = "./data/habitaciones";
    	testArchicoExiste(archivo);
    	testArchivoVacio(archivo);
    	testFormatoValido(archivo);
    	testLineasDuplicadas(archivo);
    	testCaracteresRaros(archivo);
    	testLineaVacia(archivo);
    }
    
    public void testCargarHuespedes() {  
    	String archivo = "./data/huespedes";
    	testArchicoExiste(archivo);
    	testArchivoVacio(archivo);
    	testFormatoValido(archivo);
    	testLineasDuplicadas(archivo);
    	testCaracteresRaros(archivo);
    	testLineaVacia(archivo);
    }  
    
    public void testCargarUsuarios() {
    	String archivo = "./data/usuarios";
    	testArchicoExiste(archivo);
    	testArchivoVacio(archivo);
    	testFormatoValido(archivo);
    	testLineasDuplicadas(archivo);
    	testCaracteresRaros(archivo);
    	testLineaVacia(archivo);
    }  
    
    public void testCargarReservas() { 
    	String archivo = "./data/reservas";
    	testArchicoExiste(archivo);
    	testArchivoVacio(archivo);
    	testFormatoValido(archivo);
    	testLineasDuplicadas(archivo);
    	testCaracteresRaros(archivo);
    	testLineaVacia(archivo);
    } 
        
	/**
	 * @Test 
	 * @DisplayName("Archico Existe")	
	 */	
    public void testArchicoExiste(String archivo) {
        File file = new File(archivo);
        Assert.assertTrue("Archivo no existente", file.exists());
    }

	/**
	 * @Test 
	 * @DisplayName("Archico Vacio")
	 */	
    public void testArchivoVacio(String archivo) {
        try (BufferedReader rd = new BufferedReader(new FileReader(archivo))) {
            String linea = rd.readLine();
            Assert.assertNotNull("Archivo vacío", linea);
        } catch (IOException e) {
            Assert.fail("Error leyendo archivo");
        }
    }

	/**
	 * @Test 
	 * @DisplayName("Formato Valido")
	 */	
    public void testFormatoValido(String archivo) {
        try (BufferedReader rd = new BufferedReader(new FileReader(archivo))) {
            String linea = rd.readLine();
            Assert.assertTrue("El archivo no tiene un formato válido", linea.contains(";"));
        } catch (IOException e) {
            Assert.fail("Error leyendo archivo");
        }
    }
       
	/**
	 * @Test 
	 * @DisplayName("Linea Duplicada")
	 */	
    public void testLineasDuplicadas(String archivo) {
        try (BufferedReader rd = new BufferedReader(new FileReader(archivo))) {
            String linea;
            Set<String> lineasSet = new HashSet<>();
            while ((linea = rd.readLine()) != null) {
                Assert.assertTrue("Hay una línea duplicada: " + linea, lineasSet.add(linea));
            }
        } catch (IOException e) {
            Assert.fail("Error leyendo archivo");
        }
    }
    
	/**
	 * @Test 
	 * @DisplayName("Archivo con Caracteres raros")
	 */
    public void testCaracteresRaros(String archivos) {
        try (BufferedReader rd = new BufferedReader(new FileReader(archivos))) {
            String linea;
            while ((linea = rd.readLine()) != null) {
                Assert.assertFalse("Línea con caracter no valido: " + linea, linea.contains("  "));
                Assert.assertFalse("Línea con caracter no valido: " + linea, linea.contains(", "));
                Assert.assertFalse("Línea con caracter no valido: " + linea, linea.contains("; "));
                Assert.assertFalse("Línea con caracter no valido: " + linea, linea.contains(" ,"));
                Assert.assertFalse("Línea con caracter no valido: " + linea, linea.contains(" ;"));
            }
        } catch (IOException e) {
            Assert.fail("Error leyendo archivo");
        }
    }
    
	/**
	 * @Test 
	 * @DisplayName("Linea blanca")
	 */    
    public void testLineaVacia(String archivo) {
        try (BufferedReader rd = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int num = 1;
            while ((linea = rd.readLine()) != null) {
                Assert.assertFalse("Línea vacía en la línea " + num, linea.isEmpty());
                num++;
            }
        } catch (IOException e) {
            Assert.fail("Error leyendo archivo");
        }
    }
    
    
}