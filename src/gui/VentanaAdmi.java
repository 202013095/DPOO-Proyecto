package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

import Procesamiento.Hotel;


public class VentanaAdmi extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelEncabezado panelEncabezado;
	private PanelOpciones panelOpciones;
	private PanelUsuarios panelUsuarios;
	private PanelHabitaciones panelHabitaciones;
	private PanelTarifas panelTarifas;
	private PanelInventarios panelInventarios;
	
	public VentanaAdmi(Hotel hotel)
	{
		setLayout(new BorderLayout());

		panelEncabezado = new PanelEncabezado(" Administrador");
		panelUsuarios = new PanelUsuarios(hotel);
		panelHabitaciones = new PanelHabitaciones(hotel);
		panelTarifas = new PanelTarifas();
		panelInventarios = new PanelInventarios();
		panelOpciones = new PanelOpciones(this);
	

		add(panelEncabezado, BorderLayout.NORTH);		
		add(panelUsuarios, BorderLayout.EAST);
		//add(panelHabitaciones, BorderLayout.EAST);
		//add(panelTarifas, BorderLayout.EAST);
		//add(panelInventarios, BorderLayout.EAST);
		add(panelOpciones, BorderLayout.WEST);
		
		setSize(new Dimension(750,550));
		setIconImage(null);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public PanelUsuarios getPanelUsuarios() {
		return panelUsuarios;
	}

	public void setPanelUsuarios(PanelUsuarios panelUsuarios) {
		this.panelUsuarios = panelUsuarios;
	}

	public PanelTarifas getPanelTarifas() {
		return panelTarifas;
	}

	public void setPanelTarifas(PanelTarifas panelTarifas) {
		this.panelTarifas = panelTarifas;
	}
	
	public PanelHabitaciones getPanelHabitaciones() {
		return panelHabitaciones;
	}

	public void setPanelHabitaciones(PanelHabitaciones panelHabitaciones) {
		this.panelHabitaciones = panelHabitaciones;
	}

	public PanelInventarios getPanelInventarios() {
		return panelInventarios;
	}

	public void setPanelInventarios(PanelInventarios panelInventarios) {
		this.panelInventarios = panelInventarios;
	}

	public void cambiarPanel(Component panel) {
		//cardLayout.show(panelContenedor, panel);
		remove(panelUsuarios);
		remove(panelTarifas);
		remove(panelHabitaciones);
		remove(panelInventarios);		
        add(panel, BorderLayout.EAST);
		revalidate();
        repaint();	
	}
}
