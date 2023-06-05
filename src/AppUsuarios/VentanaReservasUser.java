package AppUsuarios;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Procesamiento.Hotel;

public class VentanaReservasUser extends JFrame{
	
	public VentanaReservasUser(Hotel hotel) {
		
		JPanel jpNuevaReserva = new PanelReservasUser(hotel);	
		add(jpNuevaReserva);
		
		setVisible(true);
		setSize(new Dimension(580,300));
		setIconImage(null);
		setResizable(false);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

}
