package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpcionesRecep extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JButton btReservas;
	private JButton btHuespedes;
	//private JButton btFacturas;

	
	public PanelOpcionesRecep(VentanaRecep papa) 
	{
		Color Azul = new Color(40, 130, 255);

		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(180, 500));
        setBorder(BorderFactory.createLineBorder(Azul));        
		
        btReservas = new JButton("Reservas");
        btReservas.setPreferredSize(new Dimension(170, 40));
        btReservas.setForeground(Azul);
        btReservas.setBackground(Color.WHITE);
        btReservas.setBorder(BorderFactory.createLineBorder(Azul));
        btReservas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	papa.cambiarPanel(papa.getPanelReservas());
            }
        });
        
        btHuespedes = new JButton("Huespedes");
        btHuespedes.setPreferredSize(new Dimension(170, 40));
        btHuespedes.setForeground(Azul);
        btHuespedes.setBackground(Color.WHITE);
        btHuespedes.setBorder(BorderFactory.createLineBorder(Azul));
        btHuespedes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	papa.cambiarPanel(papa.getPanelHuespedes());
            }
        });					
//        btFacturas = new JButton("Facturas");
//        btFacturas.setPreferredSize(new Dimension(170, 40));
//        btFacturas.setForeground(Azul);
//        btFacturas.setBackground(Color.WHITE);
//        btFacturas.setBorder(BorderFactory.createLineBorder(Azul));
//        btFacturas.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {             	
//            	papa.cambiarPanel(papa.getPanelInventarios());
//            }
//        });
		add(btReservas);
		add(btHuespedes);
//		add(btFacturas);
	}
}

