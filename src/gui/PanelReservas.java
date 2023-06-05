package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import AppUsuarios.OperacionExitosa;
import Procesamiento.Hotel;
import Procesamiento.Loader;
import modelo.Adicion;
import modelo.Cama;
import modelo.Habitacion;
import modelo.Reserva;
import pagoPlatform.ConfiguracionPasarelas;

public class PanelReservas extends JPanel{
	
	protected JPanel jpListaReservas;
	protected JPanel jpModificarReserva;
	protected JPanel jpCrearReserva;

	private JList<String> listaReservas;
	private JScrollPane scrollPaneReservas;
	private JLabel lbEliminar;
	private JButton btEliminar;
	
	private JLabel lbModificarResponsable;
	private JTextField textModificarResponsable;
	private JLabel lbCheckInOut;
	private JRadioButton btCheckIn;
	private JRadioButton btCheckOut;
	private ButtonGroup grupoBotones;

	private JLabel lbModificarFechaInit;
	private JTextField textModificarFechaInit;
	private JLabel lbModificarFechaFinit;
	private JTextField textModificarFechaFinit;
	private JButton btGuardar;
		
	private JLabel lbResponsable;
	private JTextField textResponsable;
	private JLabel lbNumAdultos;
	private JComboBox<String> listNumAdultos;
	private int numAdult = 1;
	private JLabel lbNumNiños;
	private JComboBox<String> listNumNiños;
	private int numNiños = 0;

	private JLabel lbFechaInit;
	private JTextField textFechaInit;
	private JLabel lbFechaFinit;
	private JTextField textFechaFinit;
	private JLabel infoHabitaciones;
	private JList<String> listaHabitaciones;
	private JScrollPane scrollPaneHabitaciones;
	private JButton btBuscarHabitaciones;
	private JButton btCrearReserva;
	
	private ConfiguracionPasarelas cPasarelas;
	
		
	public PanelReservas(Hotel hotel) 
	{
		Color Azul = new Color(40, 130, 255);
		Color Rojo = new Color(200, 50, 50);
		Color Verde = new Color(100, 200, 70);


		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(550, 450));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Azul));        
		setLayout(new BorderLayout());
	    
	
	  //-----------------PANELES-----------------//
		jpListaReservas = new JPanel();
		jpModificarReserva = new JPanel();
		jpCrearReserva = new JPanel();	    
	    
	    
	  //-----------------PANEL 1-----------------//
        jpListaReservas.setBorder(BorderFactory.createTitledBorder("Consultar Reserva"));
	    jpListaReservas.setPreferredSize(new Dimension(230, 185));
	    jpListaReservas.setBackground(Color.WHITE);
        	 
        listaReservas = new JList<>(listaReservas(hotel));
        listaReservas.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	 String llave = listaReservas.getSelectedValue().substring(0, 2);                
            	 String codigoHuesped = hotel.getHabitaciones().get(llave).getListaReservas().get(0).getListaHuespedes().get(0);            	             	 
            	             	
            	 setModificarInfo(hotel.getHuesped().get(codigoHuesped).getNombre(), hotel.getHabitaciones().get(llave).getListaReservas().get(0).getCheckIn(), listaReservas.getSelectedValue().substring(8, 18), listaReservas.getSelectedValue().substring(24, 34));
            }
        });
        
        scrollPaneReservas = new JScrollPane(listaReservas);
        scrollPaneReservas.setPreferredSize(new Dimension(210, 100));
        
        lbEliminar = new JLabel("Eliminar Reserva Seleccionada:");
        lbEliminar.setPreferredSize(new Dimension(180, 15));
        lbEliminar.setForeground(Azul);
        
        btEliminar = new JButton("Eliminar Reserva");
        btEliminar.setForeground(Color.WHITE);
        btEliminar.setBackground(Rojo);
        btEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {              	
            	if (listaReservas.getSelectedValue()!=null) {               		            		
	            	ArrayList<String> lineas = new ArrayList<>();
	                
	            	try (BufferedReader br = new BufferedReader(new FileReader("./data/reservas"))){
	                    String linea;
	                    while ((linea = br.readLine()) != null) {
	                        lineas.add(linea);
	                    }
	                } 
	            	catch (IOException k) {
	            		k.printStackTrace();
	                    return;
	                }
	            	String lineaData = listaReservas.getSelectedValue();
	                lineas.removeIf(linea -> linea.contains(lineaData.substring(32, 34) +"/"+ lineaData.substring(29, 31)+"/"+ lineaData.substring(24, 28)+";"+ lineaData.substring(0, 2)));
	                int cont = 0;
	                
	                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/reservas"))){
	                    for (String linea : lineas) {
	                        bw.write(linea);
	                        
	                        if (cont != lineas.size()-1) {
	                        	bw.write("\n");
	                        }                        
	                        cont++;
	                    }                    
	                }
	                
	                catch (IOException k) {
	                	k.printStackTrace();
	                    return;
	                }
	            }
            }
        });
        
        
        
        jpListaReservas.add(scrollPaneReservas);
        jpListaReservas.add(lbEliminar);
        jpListaReservas.add(btEliminar);
        
        
      //-----------------PANEL 2-----------------//
        jpModificarReserva.setBorder(BorderFactory.createTitledBorder("Modificar Reserva"));
        jpModificarReserva.setPreferredSize(new Dimension(320, 185));	   	    
        jpModificarReserva.setBackground(Color.WHITE);	    
        
        lbModificarResponsable = new JLabel("Responsable");
        lbModificarResponsable.setPreferredSize(new Dimension(150, 20));
        lbModificarResponsable.setForeground(Azul);
        
        textModificarResponsable = new JTextField();
        textModificarResponsable.setPreferredSize(new Dimension(160, 20));
        textModificarResponsable.setBorder(BorderFactory.createLineBorder(Azul));     
        
        lbCheckInOut = new JLabel("Checked:");
        lbCheckInOut.setPreferredSize(new Dimension(60, 20));
        lbCheckInOut.setForeground(Azul);

        
        btCheckIn = new JRadioButton("In");
        btCheckIn.setPreferredSize(new Dimension(60, 20));
        btCheckIn.setBorder(BorderFactory.createLineBorder(Azul));
        btCheckIn.setBackground(Color.WHITE);
        btCheckIn.setForeground(Azul);
        
        btCheckOut = new JRadioButton("Out");
        btCheckOut.setPreferredSize(new Dimension(60, 20));
        btCheckOut.setBorder(BorderFactory.createLineBorder(Azul));
        btCheckOut.setBackground(Color.WHITE);
        btCheckOut.setForeground(Azul);

        grupoBotones = new ButtonGroup();
		grupoBotones.add(btCheckIn);
		grupoBotones.add(btCheckOut);
        
        
        lbModificarFechaInit = new JLabel("Fecha Ingreso");
        lbModificarFechaInit.setPreferredSize(new Dimension(140, 20));
        lbModificarFechaInit.setForeground(Azul);       
        
        textModificarFechaInit = new JTextField();
        textModificarFechaInit.setPreferredSize(new Dimension(140, 20));
        textModificarFechaInit.setBorder(BorderFactory.createLineBorder(Azul));
        
        lbModificarFechaFinit = new JLabel("Fecha Salida");
        lbModificarFechaFinit.setPreferredSize(new Dimension(140, 20));
        lbModificarFechaFinit.setForeground(Azul);
        
        textModificarFechaFinit = new JTextField();
        textModificarFechaFinit.setPreferredSize(new Dimension(140, 20));
        textModificarFechaFinit.setBorder(BorderFactory.createLineBorder(Azul));		

        btGuardar = new JButton("Cambiar Estado Reserva");
        btGuardar.setForeground(Color.WHITE);
        btGuardar.setBackground(Verde);
        btGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
        		ArrayList<String> lineas = new ArrayList<>();
        		String lineaData = listaReservas.getSelectedValue();
        	
        		try (BufferedReader br = new BufferedReader(new FileReader("./data/reservas"))){
        			String linea;

        			while ((linea = br.readLine()) != null) { 
        				if (linea.contains(lineaData.substring(32, 34) +"/"+ lineaData.substring(29, 31)+"/"+ lineaData.substring(24, 28)+";"+ lineaData.substring(0, 2))) {
        					lineas.add(linea.replace("true", "false"));
        				}
        				else
        					lineas.add(linea);            				
        			}
        		} 
        		catch (IOException k) {
        			k.printStackTrace();
        			return;
        		}            	
        	
        		recetearModificarReserva(false);
            	
                int cont = 0;
                
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/reservas"))){
                    for (String linea : lineas) {
                        bw.write(linea);
                        
                        if (cont != lineas.size()-1) {
                        	bw.write("\n");
                        }
                        
                        cont++;
                    }	                    	                   
                } 
                
                catch (IOException k) {
                	k.printStackTrace();
                    return;
                }            
            }		    
        });
		
		JLabel espacio = new JLabel();
		espacio.setPreferredSize((new Dimension(300, 20)));
		espacio.setEnabled(false);
		
        
        jpModificarReserva.add(lbModificarResponsable);      
        jpModificarReserva.add(lbCheckInOut);        
        jpModificarReserva.add(textModificarResponsable);
        jpModificarReserva.add(btCheckIn);
        jpModificarReserva.add(btCheckOut); 
        jpModificarReserva.add(lbModificarFechaInit);
        jpModificarReserva.add(lbModificarFechaFinit);
        jpModificarReserva.add(textModificarFechaInit);
        jpModificarReserva.add(textModificarFechaFinit);        
        jpModificarReserva.add(btGuardar);
		
		
	  //-----------------PANEL 3-----------------//
		jpCrearReserva.setBorder(BorderFactory.createTitledBorder("Crear Reserva"));
		jpCrearReserva.setPreferredSize(new Dimension(500, 275));	   	    
		jpCrearReserva.setBackground(Color.WHITE);	
		
		lbResponsable = new JLabel("Responsable");
		lbResponsable.setPreferredSize(new Dimension(300, 12));
		lbResponsable.setForeground(Azul);
        
		textResponsable = new JTextField();
		textResponsable.setPreferredSize(new Dimension(300, 20));
		textResponsable.setBorder(BorderFactory.createLineBorder(Azul));
      
		lbNumAdultos = new JLabel("#Adultos");
		lbNumAdultos.setPreferredSize(new Dimension(90, 12));
		lbNumAdultos.setForeground(Azul);
        
		listNumAdultos = new JComboBox<>(new String[]{"1","2","3","4","5","6","7",
												  "8","9","10","11","12","13",
												  "14","15","16","17","18","19",
												  "20","21","22","23","24","25"});
		listNumAdultos.setPreferredSize((new Dimension(100, 20)));
		listNumAdultos.addActionListener(new ActionListener() {						
            @Override
            public void actionPerformed(ActionEvent e) {
            	String numA = (String) listNumAdultos.getSelectedItem();                           	                
                numAdult = Integer.parseInt(numA);		
            }
        });
      
		lbNumNiños = new JLabel("#Niños");
		lbNumNiños.setPreferredSize(new Dimension(90, 12));
		lbNumNiños.setForeground(Azul);
        
		listNumNiños = new JComboBox<>(new String[]{"0", "1","2","3","4","5","6","7",
												"8","9","10","11","12","13","14","15"});
		listNumNiños.setPreferredSize((new Dimension(100, 20)));
		listNumNiños.addActionListener(new ActionListener() {						
            @Override
            public void actionPerformed(ActionEvent e) {
            	String numN = (String) listNumNiños.getSelectedItem();                           	                
            	numNiños = Integer.parseInt(numN);	
            }
        });
		
		lbFechaInit = new JLabel("Fecha Ingreso (DD/MM/AAAA)");
		lbFechaInit.setPreferredSize(new Dimension(250, 12));
		lbFechaInit.setForeground(Azul);       
        
		textFechaInit = new JTextField();
		textFechaInit.setPreferredSize(new Dimension(250, 20));
		textFechaInit.setBorder(BorderFactory.createLineBorder(Azul));
        
		lbFechaFinit = new JLabel("Fecha Salida (DD/MM/AAAA)");
		lbFechaFinit.setPreferredSize(new Dimension(250, 12));
		lbFechaFinit.setForeground(Azul);
        
		textFechaFinit = new JTextField();
		textFechaFinit.setPreferredSize(new Dimension(250, 20));
		textFechaFinit.setBorder(BorderFactory.createLineBorder(Azul));
       		
		infoHabitaciones = new JLabel("#Habitacion---Tipo---Capacidad----Camas----Adiciones----Precio");
		infoHabitaciones.setPreferredSize(new Dimension(450, 12));
		infoHabitaciones.setForeground(Azul);
		
        DefaultListModel<String> habitaciones = new DefaultListModel<String>();

		listaHabitaciones = new JList<>(habitaciones);
		scrollPaneHabitaciones = new JScrollPane(listaHabitaciones);
        scrollPaneHabitaciones.setPreferredSize(new Dimension(530, 82));
		        
        btBuscarHabitaciones = new JButton("Buscar Habitaciones");
        btBuscarHabitaciones.setForeground(Color.WHITE);
        btBuscarHabitaciones.setBackground(Azul);
        btBuscarHabitaciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	if(getResponsable().isEmpty()==false && getFechaInit().isEmpty()==false && getFechaFinit().isEmpty()==false) {
	            		            		     
            		buscarHabitacion(habitaciones, hotel);
	            }
            	
            	else {
            		
            		new panelError();
            	}
            }
        });
     
        btCrearReserva = new JButton("Crear Reserva");
        btCrearReserva.setForeground(Color.WHITE);
        btCrearReserva.setBackground(Verde);
        btCrearReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	if(getResponsable().isEmpty()==false && getFechaInit().isEmpty()==false && getFechaFinit().isEmpty()==false  && listaHabitaciones.getSelectedValue()!=null) {
	            	try {	            		            			                
	                    BufferedWriter bw = new BufferedWriter(new FileWriter("./data/reservas", true));
	                    bw.newLine();
	                    bw.write(getFechaInit().trim());
	                    bw.write(";");
	                    bw.write(getFechaFinit().trim());
	                    bw.write(";");
	                    bw.write(getHabitacionSelected());
	                    bw.write(";");
	                    bw.write("true");
	                    bw.write(";");
	                    
	            		for (int i = 0; i < numAdult+numNiños; i++)
	            			new VentanaCrearHuesped(i);	            			
						
	                    bw.close();	  
	                    new OperacionExitosa();
	                    recetearCrearReserva(habitaciones);    
	                    
	                } catch (IOException k) {
	                    k.printStackTrace();
	                }
	            }
            }
        });
				
		jpCrearReserva.add(lbResponsable);
		jpCrearReserva.add(lbNumAdultos);
		jpCrearReserva.add(lbNumNiños);
		jpCrearReserva.add(textResponsable);
		jpCrearReserva.add(listNumAdultos);
		jpCrearReserva.add(listNumNiños);
		
		jpCrearReserva.add(lbFechaInit);
		jpCrearReserva.add(lbFechaFinit);

		jpCrearReserva.add(textFechaInit);
		jpCrearReserva.add(textFechaFinit);
		jpCrearReserva.add(btBuscarHabitaciones);

		jpCrearReserva.add(infoHabitaciones);
		jpCrearReserva.add(scrollPaneHabitaciones);
		jpCrearReserva.add(btCrearReserva);
		
        add(jpListaReservas, BorderLayout.WEST);
        add(jpModificarReserva, BorderLayout.EAST);
        add(jpCrearReserva, BorderLayout.SOUTH);        
	}
		
	public DefaultListModel<String> listaHabitaciones(Hotel hotel){		
		DefaultListModel<String> habitaciones = new DefaultListModel<String>();;
		
		for (String login :hotel.getUsuario().keySet()) {
			String nombre = hotel.getUsuario().get(login).getNombre();
			habitaciones.addElement(nombre);
		}		
		return habitaciones;
	}
	
	
	public void recetearCrearReserva(DefaultListModel<String> habitaciones) {
		setResponsable("");
		setFechaInit("");
		setFechaFinit("");
		habitaciones.clear();
	}
	
//	public void recetearModificarReserva() {
//		setModificarResponsable("");
//		setFechaInit("");
//		setFechaFinit("");
//	}
	
	public void buscarHabitacion( DefaultListModel<String> habitaciones, Hotel hotel){
		
		habitaciones.clear();
		for (String llaves: hotel.getHabitaciones().keySet()) {
			Habitacion habitacion = hotel.getHabitaciones().get(llaves);
			
			if(habitacion.getListaReservas().isEmpty() == false && habitacion.getCapacidad() >= (getNumAdultos()+getNumNiños())) {
				
				for(int i=0; i<habitacion.getListaReservas().size(); i++) {
					
					if((habitacion.getListaReservas().get(i).getFechaFinit().isBefore(getFechaInitDateLocal()) || habitacion.getListaReservas().get(i).getFechaInit().isAfter(getFechaFinitDateLocal()))) {	            			            						
						habitaciones.addElement(habitacion.getIdHabitacion()+"----"+habitacion.getTipoHabitacion()+"----"+habitacion.getCapacidad()+"----"+getStringCamas(habitacion)+"----"+getStringAdiciones(habitacion)+"----"+getStringAdHotel(habitacion)+"----"+habitacion.getPrecioFinal());
					}	            						            			
				}
			}
			else if (habitacion.getCapacidad() >= (getNumAdultos()+getNumNiños())) {
				habitaciones.addElement(habitacion.getIdHabitacion()+"----"+habitacion.getTipoHabitacion()+"----"+habitacion.getCapacidad()+"----"+getStringCamas(habitacion)+"----"+getStringAdiciones(habitacion)+"----"+getStringAdHotel(habitacion)+"----"+habitacion.getPrecioFinal());
			}
		}
	}
	
	public void recetearModificarReserva(boolean editable) {
		btCheckIn.setSelected(editable);
		btCheckOut.setSelected(!editable);		
	}
	
	
	public String getHabitacionSelected() {		
		return listaHabitaciones.getSelectedValue().substring(0, 2);
	}

	public void setScrollPaneHabitaciones(JScrollPane scrollPaneHabitaciones) {
		this.scrollPaneHabitaciones = scrollPaneHabitaciones;
	}

	public void setResponsable(String nombre) {
		textResponsable.setText(nombre);
	}
	
	public void setFechaInit(String fecha) {
		textFechaInit.setText(fecha);
	}

	public void setFechaFinit(String fecha) {
		textFechaFinit.setText(fecha);
	}
	
	
	public void setModificarInfo(String nombre, boolean valor, String init, String finit) {
		textModificarResponsable.setText(nombre);
		textModificarResponsable.setEditable(false);			
		btCheckIn.setSelected(valor);
		btCheckOut.setSelected(!valor);
		btCheckIn.setEnabled(false);
		btCheckOut.setEnabled(false);
		textModificarFechaInit.setText(init);
		textModificarFechaFinit.setText(finit);
		textModificarFechaInit.setEditable(false);
		textModificarFechaFinit.setEditable(false);
		
	}
	
	public String getResponsable() {
		return textResponsable.getText();
	}
	
	public String getFechaInit() {
		return textFechaInit.getText().trim();
	}
	
	public String getFechaFinit() {
		return textFechaFinit.getText().trim();
	}
	
	public LocalDate getFechaInitDateLocal() {
		return LocalDate.parse(getFechaInit(), DateTimeFormatter.ofPattern("d/M/yyyy"));
	}
	
	public LocalDate getFechaFinitDateLocal() {
		return LocalDate.parse(getFechaFinit(), DateTimeFormatter.ofPattern("d/M/yyyy"));
	}
	
	public int getNumAdultos() {
		String num = (String)listNumAdultos.getSelectedItem();
		return Integer.parseInt(num);
	}
	
	public int getNumNiños() {
		String num = (String)listNumNiños.getSelectedItem();
		return Integer.parseInt(num);
	}
	
	public String getStringCamas(Habitacion habitacion) {
		ArrayList<Cama> camas = habitacion.getListaCamas();
		String listaCamas = "";
		
		for (Cama laCama: camas) {
			if (!listaCamas.contains(laCama.getTipo()))
				listaCamas+=laCama.getTipo()+",";
		}
		listaCamas = listaCamas.substring(0, listaCamas.length() - 1);
		return listaCamas;
	}
	
	public String getStringAdHotel(Habitacion habitacion) {
		ArrayList<String> adicion = habitacion.getAdicionesHotel();
		String lista = "";
		
		for (String laAdicion: adicion) {
				lista+=laAdicion+",";
		}
		lista = lista.substring(0, lista.length() - 1);
		return lista;
	}
	
	public String getStringAdiciones(Habitacion habitacion) {
		ArrayList<Adicion> adiciones = habitacion.getListaAdiciones();
		String listaAdiciones = "";
		
		for (Adicion laAdicion: adiciones) {
			if (!listaAdiciones.contains(laAdicion.getAdicion()))
				listaAdiciones+=laAdicion.getAdicion()+",";
		}
		listaAdiciones = listaAdiciones.substring(0, listaAdiciones.length() - 1);
		return listaAdiciones;
	}
	 
	
	public DefaultListModel<String> listaReservas(Hotel hotel){		
		DefaultListModel<String> reservas = new DefaultListModel<String>();
		
		for (String login : hotel.getHabitaciones().keySet()) {
		
			if (!hotel.getHabitaciones().get(login).getListaReservas().isEmpty()) {
				ArrayList<Reserva> lasReservas = hotel.getHabitaciones().get(login).getListaReservas();
				
				for (int i=0; i<lasReservas.size(); i++) {
					reservas.addElement(login+" ---- "+lasReservas.get(i).getFechaInit()+" ---- "+lasReservas.get(i).getFechaFinit());				
				}
			}
			
		}		
		return reservas;
	}
	
	
	protected JPanel getjpListaReservas() {
	    return jpListaReservas;
	}
	
	protected JPanel getjpModificarReserva() {
	    return jpModificarReserva;
	}
	
	protected JPanel getjpCrearReserva() {
	    return jpCrearReserva;
	}
}
