package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

import Procesamiento.Hotel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaRecep extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private PanelEncabezado panelEncabezado;
	private PanelReservas panelReservas;
	private PanelHuespedes panelHuespedes;
	private PanelOpcionesRecep panelOpcionesRecep;
	
	public VentanaRecep(Hotel hotel) 
	{
		setLayout(new BorderLayout());

		panelEncabezado = new PanelEncabezado(" Recepcionista");
		panelReservas = new PanelReservas(hotel);
		panelHuespedes = new PanelHuespedes();
		panelOpcionesRecep = new PanelOpcionesRecep(this);
	

		add(panelEncabezado, BorderLayout.NORTH);		
		add(panelReservas, BorderLayout.EAST);
		//add(panelGrupos, BorderLayout.EAST);
		//add(panelTarifas, BorderLayout.EAST);
		//add(panelInventarios, BorderLayout.EAST);
		add(panelOpcionesRecep, BorderLayout.WEST);
		
		setSize(new Dimension(750,550));
		setIconImage(null);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	
	public PanelReservas getPanelReservas() {
		return panelReservas;
	}

	public void setPanelReservas(PanelReservas panelReservas) {
		this.panelReservas = panelReservas;
	}

	public PanelHuespedes getPanelHuespedes() {
		return panelHuespedes;
	}

	public void setPanelHuespedes(PanelHuespedes panelHuespedes) {
		this.panelHuespedes = panelHuespedes;
	}



	public void cambiarPanel(Component panel) {
		remove(panelReservas);
		remove(panelHuespedes);
	    add(panel, BorderLayout.EAST);
		revalidate();
	    repaint();	
	}
}
	