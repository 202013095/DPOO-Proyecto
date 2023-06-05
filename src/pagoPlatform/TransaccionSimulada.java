package pagoPlatform;

public class TransaccionSimulada {
	
	private InformacionTarjetaCredito tarjetaCredito;
    private InformacionPago informacionPago;

    public TransaccionSimulada(InformacionTarjetaCredito tarjetaCredito, InformacionPago informacionPago) {
        this.tarjetaCredito = tarjetaCredito;
        this.informacionPago = informacionPago;
    }

    public InformacionTarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(InformacionTarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public InformacionPago getInformacionPago() {
        return informacionPago;
    }

    public void setInformacionPago(InformacionPago informacionPago) {
        this.informacionPago = informacionPago;
    }

}
