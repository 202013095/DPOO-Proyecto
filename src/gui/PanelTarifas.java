package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class PanelTarifas extends  JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanel jpVerTarifas;
	private JPanel jpModificarTarifa;
	private JPanel jpTarifasDiarias;
	private JList<String> listaEpocas;
	private JList<String> listaProductos;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JLabel lbEliminarTarifa;
	private JLabel lbNombreTarifa;
	private JLabel lbValorTarifa;
	private JLabel lbAplicacionTarifa;
	private JLabel lbFechasTarifa;
	
	private JLabel lbSeleccionarDia;
	private JLabel lbTarifaDiaria;
	
	
	private JTextField textNombreTarifa;
	private JTextField textValorTarifa;	
	private JTextField textFechaInit;
	private JTextField textFechaFinit;
	private JTextField textValorTarifaDia;
	private JButton btEliminarTarifa;	
	private JButton btEditarTarifa;
	private JButton btGuardarTarifa;
	private JButton btCrearNuevaTarifa;
	private JButton btEditarTarifaDia;
	private JButton btGuardarTarifaDia;
	
	private JToggleButton btLunes;
	private JToggleButton btMartes;
	private JToggleButton btMiercoles;
	private JToggleButton btJueves;
	private JToggleButton btViernes;
	private JToggleButton btSabado;
	private JToggleButton btDomingo;
	
	private JRadioButton btDescuento;
	private JRadioButton btAumento;
	private ButtonGroup grupoBotones;	
	
	private JRadioButton btDescuentoDia;
	private JRadioButton btAumentoDia;
	private ButtonGroup grupoBotonesDias;

	
	public PanelTarifas() 
	{
		Color Azul = new Color(40, 130, 255);
		Color Rojo = new Color(200, 50, 50);
		Color Verde = new Color(100, 200, 70);


		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(550, 450));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Azul));        
		setLayout(new BorderLayout());

//      setLayout(new GridBagLayout());
//	    GridBagConstraints def = new GridBagConstraints();
	    
	
	  //-----------------PANELES-----------------//
	    jpVerTarifas = new JPanel();
	    jpModificarTarifa = new JPanel();
	    jpTarifasDiarias = new JPanel();	    
	    
	    
	  //-----------------PANEL 1-----------------//
	    jpVerTarifas.setBorder(BorderFactory.createTitledBorder("Ver Tarifa"));
	    jpVerTarifas.setPreferredSize(new Dimension(220, 200));
	    jpVerTarifas.setBackground(Color.WHITE);
        
        String[] epocas = {"Semana Santa","Mitad de Año","Semana de receso","Navidad", "Verano", "Invierno", "Otoño", "Primavera"};
        listaEpocas = new JList<>(epocas);
        scrollPane1 = new JScrollPane(listaEpocas);
        scrollPane1.setPreferredSize(new Dimension(190, 200));

        
        lbEliminarTarifa = new JLabel("Eliminar Tarifa Seleccionada");
        lbEliminarTarifa.setPreferredSize(new Dimension(180, 30));
        lbEliminarTarifa.setForeground(Azul);
        
        btEliminarTarifa = new JButton("Eliminar");
        btEliminarTarifa.setForeground(Color.WHITE);
        btEliminarTarifa.setBackground(Rojo);
        
        jpVerTarifas.add(scrollPane1);
        jpVerTarifas.add(lbEliminarTarifa);
        jpVerTarifas.add(btEliminarTarifa);
        
      //-----------------PANEL 2-----------------//
        jpModificarTarifa.setBorder(BorderFactory.createTitledBorder("Modificar Tarifa"));
        jpModificarTarifa.setPreferredSize(new Dimension(330, 200));	   	    
        jpModificarTarifa.setBackground(Color.WHITE);
        
        lbNombreTarifa = new JLabel("Nombre Tarifa");
        lbNombreTarifa.setPreferredSize(new Dimension(100, 20));
        lbNombreTarifa.setForeground(Azul);
        
        textNombreTarifa = new JTextField();
        textNombreTarifa.setPreferredSize(new Dimension(250, 20));
        textNombreTarifa.setBorder(BorderFactory.createLineBorder(Azul));
      
        lbValorTarifa = new JLabel("Tarifa a Aplicar");
        lbValorTarifa.setPreferredSize(new Dimension(90, 25));
        lbValorTarifa.setForeground(Azul);
        
        textValorTarifa = new JTextField();
        textValorTarifa.setPreferredSize(new Dimension(30, 20));
        textValorTarifa.setBorder(BorderFactory.createLineBorder(Azul));
      
        btDescuento = new JRadioButton("Descuento",true);
		btDescuento.setPreferredSize(new Dimension(90, 20));
		btDescuento.setBorder(BorderFactory.createLineBorder(Azul));
		btDescuento.setBackground(Color.WHITE);
		btDescuento.setForeground(Azul);
		
		btAumento = new JRadioButton("Aumento",false);
		btAumento.setPreferredSize(new Dimension(70, 20));
		btAumento.setBorder(BorderFactory.createLineBorder(Azul));
		btAumento.setBackground(Color.WHITE);
		btAumento.setForeground(Azul);        
        
        grupoBotones = new ButtonGroup();
		grupoBotones.add(btDescuento);
		grupoBotones.add(btAumento);
		
		lbAplicacionTarifa = new JLabel("Tarifa aplicada a");
		lbAplicacionTarifa.setPreferredSize(new Dimension(150, 12));
		lbAplicacionTarifa.setForeground(Azul);
        
		lbFechasTarifa = new JLabel("Fechas Tarifa");
		lbFechasTarifa.setPreferredSize(new Dimension(140, 20));
		lbFechasTarifa.setForeground(Azul);
				
		String[] productos = {"Consumibles","Precio Habitacion","Total"};
        listaProductos = new JList<>(productos);
        scrollPane2 = new JScrollPane(listaProductos);
        scrollPane2.setPreferredSize(new Dimension(120, 80));
       
        textFechaInit = new JTextField();
        textFechaInit.setPreferredSize(new Dimension(90, 20));
        textFechaInit.setBorder(BorderFactory.createLineBorder(Azul));
      
        textFechaFinit = new JTextField();
        textFechaFinit.setPreferredSize(new Dimension(90, 20));
        textFechaFinit.setBorder(BorderFactory.createLineBorder(Azul));             
        
        btEditarTarifa = new JButton(" Editar ");
        btEditarTarifa.setForeground(Color.WHITE);
        btEditarTarifa.setBackground(Azul.darker());
        
        btGuardarTarifa = new JButton(" Guardar ");
        btGuardarTarifa.setForeground(Color.WHITE);
        btGuardarTarifa.setBackground(Azul);
        
        btCrearNuevaTarifa = new JButton(" Crear Nueva Tarifa ");
        btCrearNuevaTarifa.setForeground(Color.WHITE);
        btCrearNuevaTarifa.setBackground(Verde);
                
        JLabel espacio = new JLabel();
		espacio.setPreferredSize((new Dimension(300, 15)));
		espacio.setEnabled(false);
        
        jpModificarTarifa.add(lbNombreTarifa);
        jpModificarTarifa.add(textNombreTarifa);
        jpModificarTarifa.add(lbValorTarifa);
        jpModificarTarifa.add(textValorTarifa);
        jpModificarTarifa.add(btDescuento);
        jpModificarTarifa.add(btAumento);
        jpModificarTarifa.add(espacio);
        jpModificarTarifa.add(lbAplicacionTarifa);
        jpModificarTarifa.add(lbFechasTarifa);
        jpModificarTarifa.add(scrollPane2);
        jpModificarTarifa.add(textFechaInit);
        jpModificarTarifa.add(textFechaFinit);        
        jpModificarTarifa.add(btEditarTarifa);
        jpModificarTarifa.add(btGuardarTarifa);
        jpModificarTarifa.add(btCrearNuevaTarifa);
        
      //-----------------PANEL 3-----------------//
        jpTarifasDiarias.setBorder(BorderFactory.createTitledBorder("Tarifas Diarias"));
        jpTarifasDiarias.setPreferredSize(new Dimension(500, 150));	   	    
        jpTarifasDiarias.setBackground(Color.WHITE);
    
        
        lbSeleccionarDia = new JLabel("Seleccionar día de la semana");
        lbSeleccionarDia.setPreferredSize(new Dimension(500, 20));
        lbSeleccionarDia.setForeground(Azul);
        
        lbTarifaDiaria  = new JLabel("Tarifa a aplicar");
        lbTarifaDiaria.setPreferredSize(new Dimension(500, 20));
        lbTarifaDiaria.setForeground(Azul);
   
        btLunes = new JToggleButton("  Lu  ");
        btLunes.setBorder(BorderFactory.createLineBorder(Azul));
        btLunes.setForeground(Color.WHITE);
        btLunes.setForeground(Azul);
       
        btMartes = new JToggleButton("  Ma  ");
        btMartes.setBorder(BorderFactory.createLineBorder(Azul));
        btMartes.setForeground(Color.WHITE);
        btMartes.setForeground(Azul);
        
        btMiercoles = new JToggleButton("  Mi  ");
        btMiercoles.setBorder(BorderFactory.createLineBorder(Azul));
        btMiercoles.setForeground(Color.WHITE);
        btMiercoles.setForeground(Azul);
        
        btJueves = new JToggleButton("  Ju  ");
        btJueves.setBorder(BorderFactory.createLineBorder(Azul));
        btJueves.setForeground(Color.WHITE);
        btJueves.setForeground(Azul);
        
        btViernes = new JToggleButton("  Vi  ");
        btViernes.setBorder(BorderFactory.createLineBorder(Azul));
        btViernes.setForeground(Color.WHITE);
        btViernes.setForeground(Azul);
        
        btSabado = new JToggleButton("  Sa  ");
        btSabado.setBorder(BorderFactory.createLineBorder(Azul));
        btSabado.setForeground(Color.WHITE);
        btSabado.setForeground(Azul);
        
        btDomingo = new JToggleButton("  Do  ");
        btDomingo.setBorder(BorderFactory.createLineBorder(Azul));
        btDomingo.setForeground(Color.WHITE);
        btDomingo.setForeground(Azul);
        
        textValorTarifaDia = new JTextField();
        textValorTarifaDia.setPreferredSize(new Dimension(30, 20));
        textValorTarifaDia.setBorder(BorderFactory.createLineBorder(Azul));
      
        btDescuentoDia = new JRadioButton("Descuento",true);
        btDescuentoDia.setPreferredSize(new Dimension(90, 20));
        btDescuentoDia.setBorder(BorderFactory.createLineBorder(Azul));
        btDescuentoDia.setBackground(Color.WHITE);
        btDescuentoDia.setForeground(Azul);
		
		btAumentoDia = new JRadioButton("Aumento",false);
		btAumentoDia.setPreferredSize(new Dimension(70, 20));
		btAumentoDia.setBorder(BorderFactory.createLineBorder(Azul));
		btAumentoDia.setBackground(Color.WHITE);
		btAumentoDia.setForeground(Azul);        
        
        grupoBotonesDias = new ButtonGroup();
        grupoBotonesDias.add(btDescuentoDia);
        grupoBotonesDias.add(btAumentoDia);
        
        btEditarTarifaDia = new JButton(" Editar ");
        btEditarTarifaDia.setForeground(Color.WHITE);
        btEditarTarifaDia.setBackground(Azul.darker());
        
        btGuardarTarifaDia = new JButton(" Guardar ");
        btGuardarTarifaDia.setForeground(Color.WHITE);
        btGuardarTarifaDia.setBackground(Azul);
        
        jpTarifasDiarias.add(lbSeleccionarDia);
        jpTarifasDiarias.add(btLunes);
        jpTarifasDiarias.add(btMartes);
        jpTarifasDiarias.add(btMiercoles);
        jpTarifasDiarias.add(btJueves);
        jpTarifasDiarias.add(btViernes);
        jpTarifasDiarias.add(btSabado);
        jpTarifasDiarias.add(btDomingo);  
        jpTarifasDiarias.add(lbTarifaDiaria);
        jpTarifasDiarias.add(textValorTarifaDia);
        jpTarifasDiarias.add(btDescuentoDia);
        jpTarifasDiarias.add(btAumentoDia);
        jpTarifasDiarias.add(btEditarTarifaDia);
        jpTarifasDiarias.add(btGuardarTarifaDia);

        
        add(jpVerTarifas, BorderLayout.WEST);
        add(jpModificarTarifa, BorderLayout.EAST);
        add(jpTarifasDiarias, BorderLayout.SOUTH);
		
	}

}
