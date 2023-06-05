package pagoPlatform;

public interface PasarelaPago {
	
    boolean realizarPago(InformacionTarjetaCredito tarjetaCredito, InformacionPago informacionPago);
}
