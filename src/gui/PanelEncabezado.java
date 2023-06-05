package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Procesamiento.Hotel;

public class PanelEncabezado extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lbHotel;
	private JLabel lbtipo;
	
	public PanelEncabezado(String tipo) 
	{		
		Color Azul = new Color(40, 130, 255);

		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(700, 50));
        setBackground(Azul); 
		setLayout(new BorderLayout());
		
		lbHotel = new JLabel("Hotel Manager");
		lbHotel.setPreferredSize(new Dimension(120, 40));
		lbHotel.setForeground(Color.WHITE);
		lbHotel.setBackground(Azul);
		//lbHotel.setHorizontalAlignment(SwingConstants.LEFT);
		
		lbtipo = new JLabel(tipo);
		lbtipo.setPreferredSize(new Dimension(80, 40));
		lbtipo.setForeground(Color.WHITE);
		lbtipo.setBackground(Azul);
		//lbHotel.setHorizontalAlignment(SwingConstants.RIGHT);

        add(lbHotel, BorderLayout.BEFORE_LINE_BEGINS);			
		add(lbtipo);
	}

}
