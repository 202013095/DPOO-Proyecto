package gui;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JComboBox;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

import Procesamiento.Hotel;
import modelo.Factura;
import modelo.ItemMenu;
import pagoPlatform.GuiPago;
import pagoPlatform.InformacionPago;
import pagoPlatform.InformacionTarjetaCredito;
import pagoPlatform.PasarelaPago;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
public class VentanaEmpleado extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_3;
	private JTextField textField_4;
	private ButtonGroup buttonGroup;
	
	@SuppressWarnings("deprecation")
	public VentanaEmpleado(Hotel hotel) {
		
		//atributos
		
		int pago=0;
		
		//GUI
		setResizable(false);
		setTitle("EMPLEADO");
		getContentPane().setLayout(null);
		
		JPanel panelSeleccionFactura = new JPanel();
		panelSeleccionFactura.setLayout(null);
		panelSeleccionFactura.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		panelSeleccionFactura.setBorder(new TitledBorder(new LineBorder(new Color(0, 120, 215), 1, true), "SELECCIONAR FACTURA", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelSeleccionFactura.setBounds(10, 64, 275, 486);
		getContentPane().add(panelSeleccionFactura);
		
		JScrollPane FacturasbtnAgregar = new JScrollPane();
		FacturasbtnAgregar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		FacturasbtnAgregar.setToolTipText("sdfsdf");
		FacturasbtnAgregar.setBounds(24, 97, 383, 58);
		
	
		
		
	/*seleccionar factura*/
		
		JScrollPane facturas = new JScrollPane();
		facturas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		facturas.setToolTipText("sdfsdf");
		facturas.setBounds(20, 23, 234, 418);
		
		DefaultListModel<String> lista2= new DefaultListModel<>();
		JList<String> listaServicios2= new JList<>(lista2);
		listaServicios2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String selectedOption = listaServicios2.getSelectedValue();
				 
			        if (selectedOption != null) {
			        	Factura selec2= hotel.getFactura(selectedOption);
			        	textField_3.setText(selec2.getResponsable());
			        	textField_4.setText(selec2.getHabitacion());
			        	
			        	DefaultListModel<String> lista3= new DefaultListModel<>();
			    		JList<String> listaServicios3= new JList<>(lista3);
			        	
			        	for (String elemento : selec2.getHuespedes()) {
			        		lista3.addElement(elemento);;
	
			        	}
			        	
			        	listaServicios3.repaint();
			        	FacturasbtnAgregar.setViewportView(listaServicios3);
			    		
							
					  
				        	
				
			        }
			}
		});
		
		for (int i = 0; i < hotel.getFacturasText().size(); i++) {
		    String elemento =hotel.getFacturasText().get(i);
		    lista2.addElement(elemento);
		    }

		listaServicios2.repaint();
		facturas.setViewportView(listaServicios2);
		
		panelSeleccionFactura.add(facturas);
		
		JButton btnSeleccionar = new JButton("SELECCIONAR");
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_3.setEditable(false);
				textField_4.setEditable(false);
				FacturasbtnAgregar.setEnabled(false);	
				 String selectedOption = listaServicios2.getSelectedValue();
				  Factura selec3= hotel.getFactura(selectedOption);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(20, 36, 188, 388);
					
					
					DefaultListModel<String> lista4= new DefaultListModel<>();
		    		JList<String> listaServicios4= new JList<>(lista4);
		        	
		        	for (String elemento : selec3.getServiciosTomados()) {
		        		lista4.addElement(elemento);
		        	
		        		
		        	}
		        	
		        	listaServicios4.repaint();
		        	scrollPane.setViewportView(listaServicios4);
		}});
		btnSeleccionar.setForeground(Color.WHITE);
		btnSeleccionar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSeleccionar.setBorder(null);
		btnSeleccionar.setBackground(SystemColor.textHighlight);
		btnSeleccionar.setBounds(137, 452, 117, 23);
		panelSeleccionFactura.add(btnSeleccionar);
		
		JScrollPane ServiciosAdquiridos = new JScrollPane();
		ServiciosAdquiridos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ServiciosAdquiridos.setBounds(24, 402, 383, 58);
		
	//CODIGO DE PLATOS 
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	
		ArrayList<String> elementos = new ArrayList<>();
		
		for (int i = 0; i < hotel.getMenuFull().size(); i++) {
		    String elemento = hotel.getMenuFull().get(i);
		    elementos.add(elemento);}
		    
	comboBoxModel.addAll(elementos);
		
		//CODIGO DE PLATOS 
		
				DefaultListModel<String> lista = new DefaultListModel<>();
				
				for (int i = 0; i < hotel.getMenuFull().size(); i++) {
				    String elemento = hotel.getMenuFull().get(i);
				    lista.addElement(elemento);
				    }
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 725, 45);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE EMPLEADO");
		lblNewLabel_2.setBounds(606, 17, 109, 17);
		lblNewLabel_2.setFont(new Font("Prompt Medium", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(SystemColor.menu);
		panel.add(lblNewLabel_2);
		
		JTabbedPane AgregarServicio = new JTabbedPane(JTabbedPane.TOP);
		AgregarServicio.setBounds(295, 51, 429, 499);
		getContentPane().add(AgregarServicio);
		
		JPanel panelAdicionServicio = new JPanel();
		panelAdicionServicio.setForeground(SystemColor.textHighlight);
		AgregarServicio.addTab("AGREGAR SERVICIO", null, panelAdicionServicio, null);
		panelAdicionServicio.setBorder(new TitledBorder(new LineBorder(new Color(0, 120, 215), 1, true), "AGREGAR SERVICIO", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelAdicionServicio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		panelAdicionServicio.setLayout(null);
		
		JLabel lblNewLabelbtnAgregarbtnAgregar = new JLabel("Nombre");
		lblNewLabelbtnAgregarbtnAgregar.setBounds(24, 25, 50, 15);
		lblNewLabelbtnAgregarbtnAgregar.setForeground(SystemColor.textHighlight);
		lblNewLabelbtnAgregarbtnAgregar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		panelAdicionServicio.add(lblNewLabelbtnAgregarbtnAgregar);
		
		textField_3 = new JTextField();
		textField_3.setForeground(SystemColor.textHighlight);
		textField_3.setColumns(10);
		textField_3.setBounds(24, 44, 274, 20);
		panelAdicionServicio.add(textField_3);
		
		JLabel lblNewLabelbtnAgregarbtnAgregarbtnAgregar = new JLabel("Habitacion");
		lblNewLabelbtnAgregarbtnAgregarbtnAgregar.setForeground(SystemColor.textHighlight);
		lblNewLabelbtnAgregarbtnAgregarbtnAgregar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabelbtnAgregarbtnAgregarbtnAgregar.setBounds(308, 25, 89, 15);
		panelAdicionServicio.add(lblNewLabelbtnAgregarbtnAgregarbtnAgregar);
		
		textField_4 = new JTextField();
		textField_4.setForeground(SystemColor.textHighlight);
		textField_4.setColumns(10);
		textField_4.setBounds(308, 44, 99, 20);
		panelAdicionServicio.add(textField_4);
		
		JLabel lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar = new JLabel("Miembros del Grupo");
		lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setForeground(SystemColor.textHighlight);
		lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setBounds(24, 75, 191, 15);
		panelAdicionServicio.add(lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar);
		
		
	
		//BOTON GUARDAR EN FACTURAS
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(154, 205, 50));
		btnGuardar.setBounds(290, 471, 117, 23);
		panelAdicionServicio.add(btnGuardar);
		
		JLabel lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar_2 = new JLabel("Servicios");
		lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar_2.setForeground(SystemColor.textHighlight);
		lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar_2.setBounds(24, 166, 191, 15);
		panelAdicionServicio.add(lblNewLabelbtnAgregarbtnAgregarbtnAgregarbtnAgregar_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(24, 185, 383, 263);
		panelAdicionServicio.add(tabbedPane);
		
		JPanel panelbtnAgregar = new JPanel();
		panelbtnAgregar.setForeground(new Color(50, 205, 50));
		tabbedPane.addTab("Restaurante", null, panelbtnAgregar, null);
		panelbtnAgregar.setLayout(null);
		
		//TEXTO DEL PRECIO
		
		JFormattedTextField precioTxt = new JFormattedTextField();
		precioTxt.setEditable(false);
		precioTxt.setBounds(49, 96, 93, 20);
		panelbtnAgregar.add(precioTxt);
		
//		Elementos de factrura
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 188, 388);
		
		
		//PANEL PLATOS
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				Object opcionSeleccionadaObj = comboBox.getSelectedItem();
				if (opcionSeleccionadaObj != null) {
				    precioTxt.setText(String.valueOf(hotel.getPrecioPlato(opcionSeleccionadaObj.toString())));
				} 
			}
		});
		comboBox.setBounds(10, 62, 225, 23);
		comboBox.setModel(comboBoxModel);
		
		//FILTRO MENU HABITACION
		
		//Botonplatospara habitacion
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Habitacion");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				if (rdbtnNewRadioButton.isSelected()) {
					
					DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>();
					ArrayList<String> elementos2 = new ArrayList<>();
					
					for (int i = 0; i < hotel.getMenuHabitacion().size(); i++) {
					    String elemento =  hotel.getMenuHabitacion().get(i);
					    elementos2.add(elemento);
					    }
					comboBoxModel2.addAll(elementos2);
					comboBox.setModel(comboBoxModel2);
				}
				
				else {
					
					DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
					
					ArrayList<String> elementos = new ArrayList<>();
					
					for (int i = 0; i < hotel.getMenuFull().size(); i++) {
					    String elemento = hotel.getMenuFull().get(i);
					    elementos.add(elemento);}
					    
					    comboBoxModel.addAll(elementos);
					    comboBox.setModel(comboBoxModel);
					
				}
				
			}
		});
		rdbtnNewRadioButton.setBounds(10, 32, 109, 23);
		panelbtnAgregar.add(rdbtnNewRadioButton);
		
		
		
		panelbtnAgregar.add(comboBox);
		
		
		
		
		
		
		JLabel lblPlatos = new JLabel("Platos");
		lblPlatos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblPlatos.setForeground(SystemColor.textHighlight);
		lblPlatos.setBounds(10, 11, 109, 14);
		panelbtnAgregar.add(lblPlatos);
		
		JLabel lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregarbtnAgregar = new JLabel("Precio");
		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregarbtnAgregar.setForeground(SystemColor.textHighlight);
		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregarbtnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregarbtnAgregar.setBounds(10, 96, 73, 15);
		panelbtnAgregar.add(lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregarbtnAgregar);
		
		JButton _2 = new JButton("SELECCIONAR");
		_2.setForeground(Color.WHITE);
		_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		_2.setBorder(null);
		_2.setBackground(new Color(30, 144, 255));
		_2.setBounds(245, 61, 117, 23);
		_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Object opcionSeleccionadaObj = comboBox.getSelectedItem();
				if (opcionSeleccionadaObj != null) {
				    precioTxt.setText(String.valueOf(hotel.getPrecioPlato(opcionSeleccionadaObj.toString())));
				} 
			}});
		
		panelbtnAgregar.add(_2);
		
		JLabel lbError = new JLabel("No se ha seleccionado una factura o elemento para añadir");
		lbError.setForeground(SystemColor.controlHighlight);
		lbError.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lbError.setBounds(59, 164, 303, 14);
		panelbtnAgregar.add(lbError);
		
		JLabel lblElItemFue = new JLabel("El item fue anadido con exito");
		lblElItemFue.setForeground(SystemColor.controlHighlight);
		lblElItemFue.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblElItemFue.setBounds(59, 141, 303, 14);
		panelbtnAgregar.add(lblElItemFue);
		
		
		//Boton Agregar
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(new Color(154, 205, 50));
		btnAgregar.setBounds(251, 189, 117, 23);
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String selectedOption = listaServicios2.getSelectedValue();
		        Factura selec3= hotel.getFactura(selectedOption);
				
				if ((comboBox.getSelectedItem() != null) & (selectedOption != null)){
				String nombreadd = comboBox.getSelectedItem().toString();
				int precioAdd=hotel.getPrecioPlato(comboBox.getSelectedItem().toString());
				boolean pagoAdd = false;
				boolean recibido= false;
				lbError.setForeground(SystemColor.controlHighlight);
				selec3.aniadirServicio(nombreadd,pagoAdd, precioAdd, recibido);
				lblElItemFue.setForeground(Color.GREEN);
		
				} 
				
				else {
					lbError.setForeground(Color.RED);
				}
				
			}});
		
		panelbtnAgregar.add(btnAgregar);
		
		

		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Spa", null, panel_2, null);
		panel_2.setLayout(null);
		
		JRadioButton btnPagobtnAgregar = new JRadioButton("Pago");
		btnPagobtnAgregar.setBounds(93, 6, 49, 23);
		panel_2.add(btnPagobtnAgregar);
		
		JLabel lblHoraYDia = new JLabel("Hora y dia");
		lblHoraYDia.setBounds(10, 35, 73, 15);
		lblHoraYDia.setForeground(SystemColor.textHighlight);
		lblHoraYDia.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		panel_2.add(lblHoraYDia);
		
		JLabel lblNewLabel_3btnAgregar_2 = new JLabel("Caracteristicas");
		lblNewLabel_3btnAgregar_2.setBounds(10, 9, 73, 15);
		lblNewLabel_3btnAgregar_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_3btnAgregar_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		panel_2.add(lblNewLabel_3btnAgregar_2);
		
		JButton btnAgregar2 = new JButton("AGREGAR");
		btnAgregar2.setForeground(Color.WHITE);
		btnAgregar2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnAgregar2.setBorder(null);
		btnAgregar2.setBackground(new Color(30, 144, 255));
		btnAgregar2.setBounds(251, 6, 117, 23);
		panel_2.add(btnAgregar2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(10, 72, 73, 20);
		panel_2.add(formattedTextField);
		
 		JFormattedTextField formattedTextFieldbtnAgregar = new JFormattedTextField();
 		formattedTextFieldbtnAgregar.setBounds(93, 72, 73, 20);
 		panel_2.add(formattedTextFieldbtnAgregar);
 		
 		JFormattedTextField formattedTextFieldbtnAgregarbtnAgregar = new JFormattedTextField();
 		formattedTextFieldbtnAgregarbtnAgregar.setBounds(176, 72, 73, 20);
 		panel_2.add(formattedTextFieldbtnAgregarbtnAgregar);
 		
 		JFormattedTextField formattedTextFieldbtnAgregarbtnAgregarbtnAgregar = new JFormattedTextField();
 		formattedTextFieldbtnAgregarbtnAgregarbtnAgregar.setBounds(10, 125, 73, 20);
 		panel_2.add(formattedTextFieldbtnAgregarbtnAgregarbtnAgregar);
 		
 		JFormattedTextField formattedTextFieldbtnAgregarbtnAgregarbtnAgregarbtnAgregar = new JFormattedTextField();
 		formattedTextFieldbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setBounds(93, 125, 73, 20);
 		panel_2.add(formattedTextFieldbtnAgregarbtnAgregarbtnAgregarbtnAgregar);
 		
 		JLabel lblDiadd = new JLabel("Dia (DD)");
 		lblDiadd.setForeground(SystemColor.textHighlight);
 		lblDiadd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		lblDiadd.setBounds(10, 56, 73, 15);
 		panel_2.add(lblDiadd);
 		
 		JSpinner spinner = new JSpinner();
 		spinner.setBounds(219, 125, 30, 20);
 		panel_2.add(spinner);
 		
 		JLabel lblDiaddbtnAgregar = new JLabel("Dia (DD)");
 		lblDiaddbtnAgregar.setForeground(SystemColor.textHighlight);
 		lblDiaddbtnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		lblDiaddbtnAgregar.setBounds(93, 57, 73, 15);
 		panel_2.add(lblDiaddbtnAgregar);
 		
 		JLabel lblDiaddbtnAgregarbtnAgregar = new JLabel("Año (AAAA)");
 		lblDiaddbtnAgregarbtnAgregar.setForeground(SystemColor.textHighlight);
 		lblDiaddbtnAgregarbtnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		lblDiaddbtnAgregarbtnAgregar.setBounds(176, 57, 73, 15);
 		panel_2.add(lblDiaddbtnAgregarbtnAgregar);
 		
 		JLabel lblDiaddbtnAgregarbtnAgregarbtnAgregar = new JLabel("HORA (HH)");
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar.setForeground(SystemColor.textHighlight);
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar.setBounds(10, 99, 73, 15);
 		panel_2.add(lblDiaddbtnAgregarbtnAgregarbtnAgregar);
 		
 		JLabel lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregar = new JLabel("Entrada");
 		lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setForeground(SystemColor.textHighlight);
 		lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setBounds(10, 112, 73, 15);
 		panel_2.add(lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregar);
 		
 		JLabel lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregarbtnAgregar = new JLabel("Salida");
 		lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setForeground(SystemColor.textHighlight);
 		lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregarbtnAgregar.setBounds(93, 112, 73, 15);
 		panel_2.add(lblDiaddbtnAgregarbtnAgregarbtnAgregarbtnAgregarbtnAgregar);
 		
 		JLabel lblDiaddbtnAgregarbtnAgregarbtnAgregar_2 = new JLabel("PERSONAS ");
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2.setForeground(SystemColor.textHighlight);
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2.setBounds(176, 113, 73, 15);
 		panel_2.add(lblDiaddbtnAgregarbtnAgregarbtnAgregar_2);
 		
 		JLabel lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregar = new JLabel("Precio");
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregar.setForeground(SystemColor.textHighlight);
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregar.setBounds(261, 57, 73, 15);
 		panel_2.add(lblDiaddbtnAgregarbtnAgregarbtnAgregar_2btnAgregar);
 		
 		JFormattedTextField formattedTextFieldbtnAgregarbtnAgregar_2 = new JFormattedTextField();
 		formattedTextFieldbtnAgregarbtnAgregar_2.setEditable(false);
 		formattedTextFieldbtnAgregarbtnAgregar_2.setBounds(261, 72, 93, 20);
 		panel_2.add(formattedTextFieldbtnAgregarbtnAgregar_2);
 		
 		JButton btnSeleccionarbtnAgregar_2 = new JButton("EDITAR");
 		btnSeleccionarbtnAgregar_2.setForeground(new Color(30, 144, 255));
 		btnSeleccionarbtnAgregar_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
 		btnSeleccionarbtnAgregar_2.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
 		btnSeleccionarbtnAgregar_2.setBackground(new Color(255, 255, 255));
 		btnSeleccionarbtnAgregar_2.setBounds(151, 471, 117, 23);
 		panelAdicionServicio.add(btnSeleccionarbtnAgregar_2);
 		
 		JButton btnSeleccionarbtnAgregar_3 = new JButton("SELECCIONAR");
 		btnSeleccionarbtnAgregar_3.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 			}
 		});
btnSeleccionarbtnAgregar_3.setForeground(Color.WHITE);
btnSeleccionarbtnAgregar_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
btnSeleccionarbtnAgregar_3.setBorder(null);
btnSeleccionarbtnAgregar_3.setBackground(SystemColor.textHighlight);
btnSeleccionarbtnAgregar_3.setBounds(24, 472, 117, 23);
panelAdicionServicio.add(btnSeleccionarbtnAgregar_3);
						
						JPanel panel_1 = new JPanel();
						panel_1.setForeground(SystemColor.textHighlight);
						AgregarServicio.addTab("SERVICIOS ADQUIRIDOS Y PAGO", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SERVICIOS ADQUIRIDOS");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(10, 11, 149, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnSeleccionar_1 = new JButton("SELECCIONAR");
		btnSeleccionar_1.setForeground(Color.WHITE);
		btnSeleccionar_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSeleccionar_1.setBorder(null);
		btnSeleccionar_1.setBackground(SystemColor.textHighlight);
		btnSeleccionar_1.setBounds(91, 437, 117, 23);
		panel_1.add(btnSeleccionar_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Medio de Pago");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(218, 323, 149, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("PayPal");
		rdbtnNewRadioButton_1_1.setForeground(SystemColor.textHighlight);
		rdbtnNewRadioButton_1_1.setBounds(238, 338, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("PayU");
		rdbtnNewRadioButton_1_2.setForeground(SystemColor.textHighlight);
		rdbtnNewRadioButton_1_2.setBounds(238, 364, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_2_1 = new JRadioButton("Sire");
		rdbtnNewRadioButton_1_2_1.setForeground(SystemColor.textHighlight);
		rdbtnNewRadioButton_1_2_1.setBounds(238, 390, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1_2_1);
		
		 buttonGroup = new ButtonGroup();
		
		 buttonGroup.add(rdbtnNewRadioButton_1_1);
		 buttonGroup.add(rdbtnNewRadioButton_1_2);
		 buttonGroup.add(rdbtnNewRadioButton_1_2_1);
		 
		 
		JButton btnSeleccionar_1_1 = new JButton("PAGAR");
		btnSeleccionar_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("pato");
				String selectedOption = listaServicios2.getSelectedValue();
		        Factura selec3= hotel.getFactura(selectedOption);
				JRadioButton selectedRadioButton = getSelectedRadioButton(buttonGroup);
				Random random = new Random();
				int precio=selec3.getdebe();
				
				
				if (selectedRadioButton != null) {
	                    String selectedText = selectedRadioButton.getActionCommand();
	                   try {
							
	                	   PasarelaPago pasarelaPago;
		                    
						    Class<?> pasarelaClass = Class.forName(selectedText);
						    pasarelaPago = (PasarelaPago) pasarelaClass.newInstance();
						    
						    new GuiPago(pasarelaPago,selectedText,precio,random.nextInt(900) + 100);
						}
	                   
	                  catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
						    e.printStackTrace();
						    return;
						}
	                   
	                   }
				 

                    
                } 
				
			
			
		});
		btnSeleccionar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
 								
		btnSeleccionar_1_1.setForeground(Color.WHITE);
		btnSeleccionar_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSeleccionar_1_1.setBorder(null);
		btnSeleccionar_1_1.setBackground(SystemColor.textHighlight);
		btnSeleccionar_1_1.setBounds(276, 437, 117, 23);
		
		
		String selectedOption = listaServicios2.getSelectedValue();
	    Factura selec3= hotel.getFactura(selectedOption);
		
		
		
		System.out.println("Manuelita");
    	
    	panel_1.add(scrollPane);
    	panel_1.add(btnSeleccionar_1_1);						

 		panelAdicionServicio.add(FacturasbtnAgregar);
		setSize(new Dimension(750,600));
		setIconImage(null);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private JRadioButton getSelectedRadioButton(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return (JRadioButton) button;
            }
        }
        return null;
    }
	

}

	

