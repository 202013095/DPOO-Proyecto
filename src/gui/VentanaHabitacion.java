package gui;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Procesamiento.Hotel;
import modelo.Adicion;
import modelo.Cama;

public class VentanaHabitacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpInformacionHabitacion;
	
	private JLabel lbTipos;	
	private JLabel lbCamas;
	private JLabel lbAdiciones;

	private JButton btEditar;
	private JButton btGuardar;
	private JButton btCrear;
	private JButton btInhabilitar;
	private JTextField textSencilla;
	private JTextField textDoble;
	private JTextField textQueen;
	private JTextField textKing;
	
	private JRadioButton btEstandar;
	private JRadioButton btSuite;
	private JRadioButton btSuiteDoble;
	private ButtonGroup grupoBotones;	
	
	private JRadioButton btSencilla;
	private JRadioButton btDoble;
	private JRadioButton btQueen;
	private JRadioButton btKing;
	
	private JRadioButton btAire;
	private JRadioButton btCalefaccion;
	private JRadioButton btTv;	
	private JRadioButton btCafetera;
	private JRadioButton btRopaTapetes;
	private JRadioButton btPlancha;
	private JRadioButton btSecador;
	private JRadioButton btTomaA;
	private JRadioButton btTomaC;
	private JRadioButton btDesayuno;

	
	public VentanaHabitacion(String posicionActual, Hotel hotel, int cont) 
	{        
        Color Azul = new Color(40, 130, 255);
		Color Verde = new Color(100, 200, 70);
		Color Rojo = new Color(200, 50, 50);
        
		setSize(new Dimension(540,280));
		setIconImage(null);
		setResizable(false);				
		setVisible(true);

		//-----------------PANEL-----------------//
		jpInformacionHabitacion = new JPanel();		
		jpInformacionHabitacion.setBorder(BorderFactory.createTitledBorder(""));
        jpInformacionHabitacion.setPreferredSize(new Dimension(540, 270));
        jpInformacionHabitacion.setBackground(Color.WHITE);

        lbTipos = new JLabel("Tipos Habitaciones (Metros Cuadrados)");
        lbTipos.setPreferredSize(new Dimension(500, 30));
        lbTipos.setForeground(Azul);
                
        btEstandar = new JRadioButton("Estandar (18.5)",false);
        btEstandar.setPreferredSize(new Dimension(110, 15));
        btEstandar.setBorder(BorderFactory.createLineBorder(Azul));
        btEstandar.setBackground(Color.WHITE);
        btEstandar.setForeground(Azul);
        
        btSuite = new JRadioButton("Suite (23.5)",false);
        btSuite.setPreferredSize(new Dimension(80, 15));
        btSuite.setBorder(BorderFactory.createLineBorder(Azul));
        btSuite.setBackground(Color.WHITE);
        btSuite.setForeground(Azul);
        
        btSuiteDoble = new JRadioButton("Suite Doble (28)",false);
        btSuiteDoble.setPreferredSize(new Dimension(110, 15));
        btSuiteDoble.setBorder(BorderFactory.createLineBorder(Azul));
        btSuiteDoble.setBackground(Color.WHITE);
        btSuiteDoble.setForeground(Azul);
        
        grupoBotones = new ButtonGroup();
		grupoBotones.add(btEstandar);
		grupoBotones.add(btSuite);
		grupoBotones.add(btSuiteDoble);	
        
        
        lbCamas = new JLabel("Camas y cantidad (tamaño)");
        lbCamas.setPreferredSize(new Dimension(500, 30));
        lbCamas.setForeground(Azul);       
                     
        btSencilla = new JRadioButton("Sencilla (1.71)",false);
        btSencilla.setPreferredSize(new Dimension(100, 20));
        btSencilla.setBorder(BorderFactory.createLineBorder(Azul));
        btSencilla.setBackground(Color.WHITE);
        btSencilla.setForeground(Azul); 
        btSencilla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	 if (btSencilla.isSelected()) 
            		 textSencilla.setEditable(true);                 
            	 else 
                	 textSencilla.setEditable(false);                 
            }
        });

        textSencilla = new JTextField();
        textSencilla.setPreferredSize(new Dimension(30, 20));
        textSencilla.setBorder(BorderFactory.createLineBorder(Azul));
        textSencilla.setEditable(false);
		
        btDoble = new JRadioButton("Doble (2.66)",false);
        btDoble.setPreferredSize(new Dimension(90, 20));
        btDoble.setBorder(BorderFactory.createLineBorder(Azul));
        btDoble.setBackground(Color.WHITE);
        btDoble.setForeground(Azul);
        btDoble.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	 if (btDoble.isSelected()) 
            		 textDoble.setEditable(true);                  
            	 else 
            		 textDoble.setEditable(false);                 
            }
        });
		
        textDoble = new JTextField();
        textDoble.setPreferredSize(new Dimension(30, 20));
        textDoble.setBorder(BorderFactory.createLineBorder(Azul));
        textDoble.setEditable(false);

        
		btQueen = new JRadioButton("Queen (3.2)",false);
		btQueen.setPreferredSize(new Dimension(85, 20));
		btQueen.setBorder(BorderFactory.createLineBorder(Azul));
		btQueen.setBackground(Color.WHITE);
		btQueen.setForeground(Azul);
		btQueen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	 if (btQueen.isSelected()) 
            		 textQueen.setEditable(true);
            	 else 
            		 textQueen.setEditable(false);
                 
            }
        });

		textQueen = new JTextField();
		textQueen.setPreferredSize(new Dimension(30, 20));
		textQueen.setBorder(BorderFactory.createLineBorder(Azul));
		textQueen.setEditable(false);
		
		btKing = new JRadioButton("King (3.78)",false);
		btKing.setPreferredSize(new Dimension(80, 20));
		btKing.setBorder(BorderFactory.createLineBorder(Azul));
		btKing.setBackground(Color.WHITE);
		btKing.setForeground(Azul);
		btKing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	 if (btKing.isSelected()) 
            		 textKing.setEditable(true);                 
            	 else 
            		 textKing.setEditable(false);
                 
            }
        });
		
		textKing = new JTextField();
		textKing.setPreferredSize(new Dimension(30, 20));
		textKing.setBorder(BorderFactory.createLineBorder(Azul));
		textKing.setEditable(false);
		
        lbAdiciones = new JLabel("Adiciones");
        lbAdiciones.setPreferredSize(new Dimension(500, 30));
        lbAdiciones.setForeground(Azul);
		
		btAire = new JRadioButton("Aire Ac.",false);
		btAire.setPreferredSize(new Dimension(70, 20));
		btAire.setBorder(BorderFactory.createLineBorder(Azul));
		btAire.setBackground(Color.WHITE);
		btAire.setForeground(Azul);        

		btCalefaccion = new JRadioButton("Calefacción",false);
		btCalefaccion.setPreferredSize(new Dimension(85, 20));
		btCalefaccion.setBorder(BorderFactory.createLineBorder(Azul));
		btCalefaccion.setBackground(Color.WHITE);
		btCalefaccion.setForeground(Azul);		
		
		btTv = new JRadioButton("Tv",false);
		btTv.setPreferredSize(new Dimension(50, 20));
		btTv.setBorder(BorderFactory.createLineBorder(Azul));
		btTv.setBackground(Color.WHITE);
		btTv.setForeground(Azul);
		
		btCafetera = new JRadioButton("Cafetera",false);
		btCafetera.setPreferredSize(new Dimension(90, 20));
		btCafetera.setBorder(BorderFactory.createLineBorder(Azul));
		btCafetera.setBackground(Color.WHITE);
		btCafetera.setForeground(Azul);
		
		btRopaTapetes = new JRadioButton("Ropa de cama y tapetes",false);
		btRopaTapetes.setPreferredSize(new Dimension(160, 20));
		btRopaTapetes.setBorder(BorderFactory.createLineBorder(Azul));
		btRopaTapetes.setBackground(Color.WHITE);
		btRopaTapetes.setForeground(Azul);
		
		btPlancha = new JRadioButton("Plancha",false);
		btPlancha.setPreferredSize(new Dimension(90, 20));
		btPlancha.setBorder(BorderFactory.createLineBorder(Azul));
		btPlancha.setBackground(Color.WHITE);
		btPlancha.setForeground(Azul);
		
		btSecador = new JRadioButton("Secador",false);
		btSecador.setPreferredSize(new Dimension(90, 20));
		btSecador.setBorder(BorderFactory.createLineBorder(Azul));
		btSecador.setBackground(Color.WHITE);
		btSecador.setForeground(Azul);
				
		btTomaA = new JRadioButton("Toma USB-A",false);
		btTomaA.setPreferredSize(new Dimension(100, 20));
		btTomaA.setBorder(BorderFactory.createLineBorder(Azul));
		btTomaA.setBackground(Color.WHITE);
		btTomaA.setForeground(Azul);
		
		btTomaC = new JRadioButton("Toma USB-C",false);
		btTomaC.setPreferredSize(new Dimension(100, 20));
		btTomaC.setBorder(BorderFactory.createLineBorder(Azul));
		btTomaC.setBackground(Color.WHITE);
		btTomaC.setForeground(Azul);
		
		btDesayuno = new JRadioButton("Desayuno",false);
		btDesayuno.setPreferredSize(new Dimension(90, 20));
		btDesayuno.setBorder(BorderFactory.createLineBorder(Azul));
		btDesayuno.setBackground(Color.WHITE);
		btDesayuno.setForeground(Azul);
		
		btEditar = new JButton("Editar");
		btEditar.setForeground(Color.WHITE);
		btEditar.setBackground(Azul.darker());
		btEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	disponible(true);            	            
            }
        });

		btGuardar = new JButton("Guardar");
		btGuardar.setForeground(Color.WHITE);
		btGuardar.setBackground(Azul);
        btGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
            	if (btEstandar.isEnabled()==true && getCamasHabitaciones()!="" && (btSencilla.isSelected() || btDoble.isSelected() || btQueen.isSelected() || btKing.isSelected())) {
            	ArrayList<String> lineas = new ArrayList<>();
                
            	try (BufferedReader br = new BufferedReader(new FileReader("./data/habitaciones"))){
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }
                } 
            	catch (IOException k) {
            		k.printStackTrace();
                    return;
                }

            	String nuevaLinea = (posicionActual+";"+getTipoHabitaciones());            	
            	nuevaLinea+=getCamasHabitaciones();            	
            	nuevaLinea+=getAdiciones();
            	            	
            	lineas.removeIf(linea -> linea.startsWith(posicionActual));
                lineas.add(nuevaLinea);
                
                int conta = 0;
                
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/habitaciones"))){
                    for (String linea : lineas) {
                        bw.write(linea);
                        
                        if (conta != lineas.size()-1) {
                        	bw.write("\n");
                        }
                        
                        conta++;
                    }                   
                } 
                
                catch (IOException k) {
                	k.printStackTrace();
                    return;
                }
            }
                recetarTipos();
                recetearAdiciones();
                recetearCamas();
        }
            
        });
		
		btCrear = new JButton("Crear");
		btCrear.setForeground(Color.WHITE);
		btCrear.setBackground(Verde);	
		btCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {          
            	try {
            		if (getCamasHabitaciones()!="" && btAire.isEnabled()) {
            	
            			int posicion = hotel.getHabitaciones().size()+cont;
                        BufferedWriter bw = new BufferedWriter(new FileWriter("./data/habitaciones",true));
                        
                        bw.newLine();
                        bw.write(posicion+";"+getTipoHabitaciones()+getCamasHabitaciones()+getAdiciones());                    
                        bw.close();
                        
                        recetarTipos();
                        recetearAdiciones();
                        recetearCamas();
					}
            		                   
                } catch (IOException k) {
                    k.printStackTrace();
                }
            }
        });
			
		btInhabilitar = new JButton("Inhabilitar habitación");
		btInhabilitar.setForeground(Color.WHITE);
		btInhabilitar.setBackground(Rojo);
		
		jpInformacionHabitacion.add(lbTipos);
		jpInformacionHabitacion.add(btEstandar);
		jpInformacionHabitacion.add(btSuite);
		jpInformacionHabitacion.add(btSuiteDoble);
		
		jpInformacionHabitacion.add(lbCamas);
		jpInformacionHabitacion.add(btSencilla);
		jpInformacionHabitacion.add(textSencilla);
		jpInformacionHabitacion.add(btDoble);
		jpInformacionHabitacion.add(textDoble);
		jpInformacionHabitacion.add(btQueen);
		jpInformacionHabitacion.add(textQueen);
		jpInformacionHabitacion.add(btKing);
		jpInformacionHabitacion.add(textKing);
		
		jpInformacionHabitacion.add(lbAdiciones);
		jpInformacionHabitacion.add(btAire);
		jpInformacionHabitacion.add(btCalefaccion);
		jpInformacionHabitacion.add(btTv);	
		jpInformacionHabitacion.add(btCafetera);
		jpInformacionHabitacion.add(btRopaTapetes);
		jpInformacionHabitacion.add(btPlancha);
		jpInformacionHabitacion.add(btSecador);
		jpInformacionHabitacion.add(btTomaA);
		jpInformacionHabitacion.add(btTomaC);
		jpInformacionHabitacion.add(btDesayuno);
		
		
		jpInformacionHabitacion.add(btEditar);
		jpInformacionHabitacion.add(btGuardar);
		jpInformacionHabitacion.add(btCrear);
        
		
		add(jpInformacionHabitacion);
        
        
        setVisible(true);
    }
	
	
	//GETTERS & SETTERS
	public String getCamasSencillas() {
		return textSencilla.getText();
	}
	
	public String getCamasDobles() {
		return textDoble.getText();
	}
	
	public String getCamasQueen() {
		return textQueen.getText();
	}
	
	public String getCamasKing() {
		return textKing.getText();
	}
	
	
	public String getTipoHabitaciones() {		
		String tipo = "";
		
		if (btEstandar.isSelected()) 
			tipo += "estandar";		
		else if (btSuite.isSelected()) 
			tipo += "suite";		
		else if (btSuiteDoble.isSelected())
			tipo += "suite doble";
			
		return tipo;
	}
	
	public String getCamasHabitaciones() {
		String camas = ";";
		int sencillas = 0;
		int doble = 0;
		int queen = 0;
		int king = 0;
		
		
		if (btSencilla.isSelected() && getCamasSencillas().isEmpty()==false) {			
			sencillas = Integer.parseInt(getCamasSencillas());
			
			for (int i=0; i<sencillas; i++) {				
				camas+="Sencilla,";				                
			}		
			
		}
			
		if (btDoble.isSelected() && getCamasDobles().isEmpty()==false) {
			doble = Integer.parseInt(getCamasDobles());
						
			for (int i=0; i<doble; i++) {
				camas+="Doble,";		                
			}
		}
			
		if (btQueen.isSelected() && getCamasQueen().isEmpty()==false) {
			queen = Integer.parseInt(getCamasQueen());
						
			for (int i=0; i<queen; i++) {
				camas+="Queen,";		                
			}
		}
			
		if (btKing.isSelected() && getCamasKing().isEmpty()==false) {
			
			king = Integer.parseInt(getCamasKing());
						
			for (int i=0; i<king; i++) {
				camas+="King,";		                
			}
		}
		
		camas = camas.substring(0, camas.length() - 1);
			
		return camas;
	}
	
	public String getAdiciones() {		
		String camas=";";
		
		if (btAire.isSelected()) 
			camas+="Aire,";
				
		if (btCalefaccion.isSelected()) 
			camas+="Calefaccion,";
				
		if (btTv.isSelected()) 
			camas+="Tv,";
				
		if (btCafetera.isSelected()) 
			camas+="Cafetera,";
				
		if (btRopaTapetes.isSelected()) 
			camas+="RopaTapetes,";
				
		if (btPlancha.isSelected()) 
			camas+="Plancha,";
		
		if (btSecador.isSelected()) 
			camas+="Secador,";
		
		if (btTomaA.isSelected()) 
			camas+="TomaA,";
		
		if (btTomaC.isSelected()) 
			camas+="TomaC,";
		
		if (btDesayuno.isSelected()) 
			camas+="Desayuno,";
				
		camas = camas.substring(0, camas.length() - 1);
		
		return camas;
	}
	
	
	
	//Otras funciones
	
	public void disponible(boolean x) {
		btEstandar.setEnabled(x);
		btSuite.setEnabled(x);						
		btSuiteDoble.setEnabled(x);
		
		btSencilla.setEnabled(x);								
		btDoble.setEnabled(x);								
		btQueen.setEnabled(x);								
		btKing.setEnabled(x);		
		      		
		btAire.setEnabled(x);
		btCalefaccion.setEnabled(x);
		btTv.setEnabled(x);	
		btCafetera.setEnabled(x);
		btRopaTapetes.setEnabled(x);
		btPlancha.setEnabled(x);
		btSecador.setEnabled(x);
		btTomaA.setEnabled(x);
		btTomaC.setEnabled(x);
		btDesayuno.setEnabled(x);
		
	}

	public void recetarTipos() {
		btEstandar.setSelected(false);
		btSuite.setSelected(false);						
		btSuiteDoble.setSelected(false);
	}
	
	public void recetearCamas() {
		btSencilla.setSelected(false);								
		btDoble.setSelected(false);								
		btQueen.setSelected(false);								
		btKing.setSelected(false);
		
        textSencilla.setText("0");
        textDoble.setText("0");
        textQueen.setText("0");
        textKing.setText("0");
	}
	
	
	public void recetearAdiciones() {
		btAire.setSelected(false);
		btCalefaccion.setSelected(false);
		btTv.setSelected(false);	
		btCafetera.setSelected(false);
		btRopaTapetes.setSelected(false);
		btPlancha.setSelected(false);
		btSecador.setSelected(false);
		btTomaA.setSelected(false);
		btTomaC.setSelected(false);
		btDesayuno.setSelected(false);
		
	}
	
	public void botonesTipos(String tipoHabitacion){
    	if (tipoHabitacion.equals("estandar")) 
			btEstandar.setSelected(true);						
		else if (tipoHabitacion.equals("suite")) 
			btSuite.setSelected(true);						
		else if (tipoHabitacion.equals("suite doble")) 
			btSuiteDoble.setSelected(true);
	}
	
	public void botonesCamas(ArrayList<Cama> camas) {
		int contSencilla=0;
		int contDoble=0;
		int contQueen=0;
		int contKing=0;
    			            
    	for (Cama cama: camas) {		            		
			
			if (cama.getTipo().equals("Sencilla")) {
				contSencilla++;
				btSencilla.setSelected(true);								
		        textSencilla.setText(String.valueOf(contSencilla));
			}
			
			if (cama.getTipo().equals("Doble")) {
				contDoble++;
				btDoble.setSelected(true);								
				textDoble.setText(String.valueOf(contDoble));
			}
			
			if (cama.getTipo().equals("Queen")) {
				contQueen++;
				btQueen.setSelected(true);								
				textQueen.setText(String.valueOf(contQueen));
			}
			
			if (cama.getTipo().equals("King")) {
				contKing++;
				btKing.setSelected(true);								
				textKing.setText(String.valueOf(contKing));
			}

		}
	}
	
	public void botonesAdiciones(ArrayList<Adicion> adiciones) {
		for (Adicion adicion: adiciones) {		            		
			
			if (adicion.getAdicion().equals("Aire")) 
				btAire.setSelected(true);
			
			if (adicion.getAdicion().equals("Calefaccion")) 
				btCalefaccion.setSelected(true);
			
			if (adicion.getAdicion().equals("Tv")) 
				btTv.setSelected(true);	
			
			if (adicion.getAdicion().equals("Cafetera")) 
				btCafetera.setSelected(true);
			
			if (adicion.getAdicion().equals("RopaTapetes")) 
				btRopaTapetes.setSelected(true);
			
			if (adicion.getAdicion().equals("Plancha")) 
				btPlancha.setSelected(true);
			
			if (adicion.getAdicion().equals("Secador")) 
				btSecador.setSelected(true);
			
			if (adicion.getAdicion().equals("TomaA")) 
				btTomaA.setSelected(true);
			
			if (adicion.getAdicion().equals("TomaC")) 
				btTomaC.setSelected(true);
			
			if (adicion.getAdicion().equals("Desayuno")) 
				btDesayuno.setSelected(true);													
		}
	}

}
