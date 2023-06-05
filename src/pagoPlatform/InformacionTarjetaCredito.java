package pagoPlatform;

public class InformacionTarjetaCredito {
	
	 private String numeroTarjeta;
	 private String nombreTitular;
	 private String FechaVencimiento;
	private String Codigo;
	 
	 public String getNumeroTarjeta() {
	        return numeroTarjeta;
	    }

	    public void setNumeroTarjeta(String numeroTarjeta) {
	        this.numeroTarjeta = numeroTarjeta;
	    }

	    public String getNombreTitular() {
	        return nombreTitular;
	    }

	    public void setNombreTitular(String nombreTitular) {
	        this.nombreTitular = nombreTitular;
	    }

		public void setFechaVencimiento(String string) {
			this.FechaVencimiento= string;
			
		}

		public void setCodigoSeguridad(String string) {
			this.Codigo = string;
			
		}
		



}
