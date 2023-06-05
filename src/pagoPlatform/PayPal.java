package pagoPlatform;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PayPal implements PasarelaPago{
	
	 @Override
	    public boolean realizarPago(InformacionTarjetaCredito tarjetaCredito, InformacionPago informacionPago) {
	        
		  TransaccionSimulada transaccion = new TransaccionSimulada(tarjetaCredito, informacionPago);

	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String jsonTransaccion = gson.toJson(transaccion);

	        try {
	            FileWriter fileWriter = new FileWriter("PayPal.json", true); 
	            fileWriter.write(jsonTransaccion);
	            fileWriter.write("\n"); 
	            fileWriter.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false; 
	        }

	        return true; 
	    
}

}
