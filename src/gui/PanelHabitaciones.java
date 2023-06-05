package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Procesamiento.Hotel;
import modelo.Cama;
import modelo.Adicion;
import modelo.Habitacion;


public class PanelHabitaciones extends  JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanel jpVerHabitaciones;
	private JButton[][] tableroLabel;	
	
	private Habitacion habitacionActual;
	private String posicionActual;
	private JButton ultimoBoton = null;
	private VentanaHabitacion vh;
	private int cont=0;
	
	
	public PanelHabitaciones(Hotel hotel) 
	{	
		Color Azul = new Color(40, 130, 255);
		Color Verde = new Color(100, 200, 70);


		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(550, 450));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Azul));        
		setLayout(new BorderLayout());
		
		//-----------------PANELES-----------------//
		jpVerHabitaciones = new JPanel();
		
		//-----------------PANEL 1-----------------//
		jpVerHabitaciones.setBorder(BorderFactory.createTitledBorder("Ver Habitaciones"));
		jpVerHabitaciones.setPreferredSize(new Dimension(480, 400));
		jpVerHabitaciones.setBackground(Color.WHITE);
		jpVerHabitaciones.setLayout(new GridLayout(10,10));		
		tableroLabel = new JButton[10][10];
				
        for (int i = 0; i < 10; i++)                 	
			for (int ii = 0; ii < 10; ii++)
			{			
				JButton habitacion = new JButton();				
				habitacion.setPreferredSize(new Dimension(180/10, 180/10));				
				habitacion.setBackground(Color.WHITE);
				habitacion.setBorder(BorderFactory.createLineBorder(Color.black));
				habitacion.setOpaque(true);	
				
				String posicionY = String.valueOf(i);
				String posicionX = String.valueOf(ii);
				
				if(((i*10)+ii)<hotel.getHabitaciones().size()) {
					
					habitacion.setText(""+i+ii);					
					habitacion.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {			            				            				            
			            	if (ultimoBoton != null) {
			            		ultimoBoton.setBackground(Color.WHITE);
			            	}
			            	
			            	ultimoBoton = habitacion;
			            	habitacion.setBackground(Verde);
			            		
			            	posicionActual = posicionY+posicionX;
			            	habitacionActual = hotel.getHabitaciones().get(posicionActual);
			            	String tipoHabitacion = habitacionActual.getTipoHabitacion();
			            	ArrayList<Cama> camas = habitacionActual.getListaCamas();
			            	ArrayList<Adicion> adiciones = habitacionActual.getListaAdiciones();
			            	
			            	vh = new VentanaHabitacion(posicionActual, hotel, cont);
			            	vh.setVisible(true);			            	
			            	vh.disponible(false);			            			            	
			            	vh.botonesTipos(tipoHabitacion);			            			            	
			            	vh.recetearCamas();	
			            	vh.botonesCamas(camas);			            			            	
			            	vh.recetearAdiciones();
			            	vh.botonesAdiciones(adiciones);	
			            	cont++;

			            }
			        });				
				}			 
					
				tableroLabel[i][ii] = habitacion;		        
				jpVerHabitaciones.add(habitacion);
			}   
		add(jpVerHabitaciones, BorderLayout.CENTER);
	}
}
