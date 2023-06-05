package modelo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class Factura {
	
	private String responsable;
	private String[] huespedes;
	private Map<String,Boolean> pagosServicios;
	private ArrayList<String> serviciosTomados;
	private Map<String,Integer> precioServicio;
	private Map<String,Boolean> servicioRecibido;
	private String habitacion;
	private int precioTotal;
	private int pagado=0;
	private int debe=0;
	private boolean paziSalvo;
	
	public Factura(Map<String,Boolean> serv, Map<String,Boolean> pago, ArrayList<String> ser, Map<String,Integer> precios, String pt, int paga,
			int pt2, boolean tr, String RESPON, String[] Huesp) {
		serviciosTomados=ser;
		pagosServicios = pago;
		precioServicio=precios;
		habitacion=pt;
		precioTotal=pt2;
		pagado=paga;
		debe=pt2-paga;
		paziSalvo=tr;
		responsable=RESPON;
		huespedes=Huesp;
		servicioRecibido=serv;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String[] getHuespedes() {
		return huespedes;
	}

	public void setHuespedes(String[] huespedes) {
		this.huespedes = huespedes;
	}

	public Map<String, Boolean> getServicioRecibido() {
		return servicioRecibido;
	}

	public void setServicioRecibido(Map<String, Boolean> servicioRecibido) {
		this.servicioRecibido = servicioRecibido;
	}

	public int getPagado() {
		return pagado;
	}

	public void setPagado(int pagado) {
		this.pagado = pagado;
	}

	public int getDebe() {
		return debe;
	}

	public void setDebe(int debe) {
		this.debe = debe;
	}
	

	
	public void aniadirServicio(String servicio, Boolean pago, int precio, boolean recibido) {
		
		pagosServicios.put(servicio,pago);
		serviciosTomados.add(servicio);
		precioServicio.put(servicio, precio);
		servicioRecibido.put(servicio, recibido);
		addprecio(precio);
		
	}
	
	public void addprecio(int precio) {
		precioTotal+=precio;
	}
	
	public void eliminarServicio(String servicio) {
		
		if (servicioRecibido.get(servicio) & !pagosServicios.get(servicio)) {
			precioTotal-=precioServicio.get(servicio);
			pagosServicios.remove(servicio);
			serviciosTomados.remove(servicio);
			precioServicio.remove(servicio);
		}
		
	}
	
	public int getdebe() {
		return debe= precioTotal-pagado;
	}
	
	public void evaluarpazysalvo() {
		
		paziSalvo=true;
		
		for (Entry<String, Boolean> entry : pagosServicios.entrySet()) {
		    if (!entry.getValue()){
		    	paziSalvo=false;
		    }
		    
		    else {
		    	pagado+=precioServicio.get(entry.getKey());
		    }
		}
	}
	
	public Map<String, Boolean> getPagosServicios() {
		return pagosServicios;
	}
	public void setPagosServicios(Map<String, Boolean> pagosServicios) {
		this.pagosServicios = pagosServicios;
		}
	
	
	public Map<String, Integer> getPrecioServicio() {
		return precioServicio;
	}

	public void setPrecioServicio(Map<String, Integer> precioServicio) {
		this.precioServicio = precioServicio;
	}

	public ArrayList<String> getServiciosTomados() {
		return serviciosTomados;
	}
	public void setServiciosTomados(ArrayList<String> serviciosTomados) {
		this.serviciosTomados = serviciosTomados;
	}
	public int getPrecioTotal() {
		return precioTotal;
	}
	
	public String getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(String habibi) {
		habitacion = habibi;
	}
	
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	public boolean isPaziSalvo() {
		return paziSalvo;
	}
	public void setPaziSalvo(boolean paziSalvo) {
		this.paziSalvo = paziSalvo;
	}
	
}