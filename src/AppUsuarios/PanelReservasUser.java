package AppUsuarios;

import java.awt.Dimension;

import javax.swing.JPanel;

import Procesamiento.Hotel;
import gui.PanelReservas;

public class PanelReservasUser extends PanelReservas{

	public PanelReservasUser(Hotel hotel) {
		super(hotel);
		eliminarTodosLosBotones();
		// TODO Auto-generated constructor stub
	}
	
 public void eliminarTodosLosBotones() {
	 
	 JPanel jpListaReservas= super.getjpListaReservas();
	 JPanel jpModificarReserva= super.getjpModificarReserva();
		 
		 remove(jpListaReservas);
		 remove(jpModificarReserva);
		 revalidate();
	     repaint();
	     
	    setVisible(true);
		setSize(new Dimension(500,275));	
	    }

}
