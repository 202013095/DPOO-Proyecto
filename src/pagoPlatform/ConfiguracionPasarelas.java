package pagoPlatform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ConfiguracionPasarelas {
	
	private ArrayList<PasarelaPago> pasarelasDisponibles;
	
    public ConfiguracionPasarelas() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    
    
    pasarelasDisponibles = new ArrayList<>();
    
    ArrayList<String> clasesPasarelas = leerArchivoConfiguracion();
    
    for (String nombreClase : clasesPasarelas) {
        try {
            Class<?> clase = Class.forName(nombreClase);
            if (PasarelaPago.class.isAssignableFrom(clase)) {
                PasarelaPago pasarela = (PasarelaPago) clase.getDeclaredConstructor().newInstance();
                pasarelasDisponibles.add(pasarela);
            }
        } catch (ClassNotFoundException e) {
            ((Throwable) e).printStackTrace();
        }
    }
}

	public ArrayList<PasarelaPago> getPasarelasDisponibles() {
	    return pasarelasDisponibles;
	}

	private ArrayList<String> leerArchivoConfiguracion() {
		ArrayList<String> pasarelas = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("./data/pasarelas"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                pasarelas.add(linea);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	    return pasarelas;
	}


}
