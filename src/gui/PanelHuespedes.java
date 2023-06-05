package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelHuespedes extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JPanel jpListaGrupos;
	private JPanel jpModificarGrupos;
	private JPanel jpModificarHuespedes;
	private JList<String> listaGrupos;
	private JScrollPane scrollPaneGrupos;
	
	
	private JLabel lbResponsable;
	private JTextField textResponsable;
	private JLabel lbIntegrantes;
	
	private JList<String> listaIntegrantes;
	private JScrollPane scrollPaneIntegrantes;
	
	private JLabel lbEliminar;
	private JButton btEliminar;
	private JButton btAgregarHuesped;
	private JButton btEliminarHuesped;
	private JButton btEditar;
	private JButton btGuardar;
	
	private JLabel lbModificarHuesped;
	private JTextField textModificarUsuario;
	private JLabel lbModificarDoc;
	private JTextField textModificarDoc;
	private JLabel lbModificarCorreo;
	private JTextField textModificarCorreo;
	private JLabel lbModificarCelular;
	private JTextField textModificarCelular;
	private JLabel lbModificarEdad;
	private JTextField textModificarEdad;
	private JButton btEditarModificacion;
	private JButton btGuardarModificacion;

	
	public PanelHuespedes() {

		Color Azul = new Color(40, 130, 255);
		Color Rojo = new Color(200, 50, 50);
		Color Verde = new Color(100, 200, 70);


		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(550, 450));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Azul));        
		setLayout(new BorderLayout());
	    
	
	  //-----------------PANELES-----------------//
		jpListaGrupos = new JPanel();
	    jpModificarGrupos = new JPanel();
	    jpModificarHuespedes = new JPanel();
	    
	  //-----------------PANEL 1-----------------//
        jpListaGrupos.setBorder(BorderFactory.createTitledBorder("Consultar Huespedes"));
	    jpListaGrupos.setPreferredSize(new Dimension(250, 100));
	    jpListaGrupos.setBackground(Color.WHITE);
        	 
	    
	    DefaultListModel<String> Huespedes = new DefaultListModel<String>();
	    Huespedes.addElement("a");
	    Huespedes.addElement("b");
	    Huespedes.addElement("c");
	    
	    listaGrupos = new JList<>(Huespedes);
	    listaGrupos.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //String nombre = listaHuespedes.getSelectedValue();
//                String login = loginConNombre(hotel, nombre);
//                setModificarNombre(nombre);
//                setModificarUsuario(login);
//                setModificarContrasena(hotel.getUsuario().get(login).getPassword());
//                setModificarCorreo(hotel.getUsuario().get(login).getCorreo());
//                setModificarContrasena(hotel.getUsuario().get(login).getPassword());
            	//listaHuespedes.setSelectedItem();
            }
        });
        
        scrollPaneGrupos = new JScrollPane(listaGrupos);
        scrollPaneGrupos.setPreferredSize(new Dimension(190, 200));
        
        lbEliminar = new JLabel("Eliminar Grupo Seleccionado:");
        lbEliminar.setPreferredSize(new Dimension(180, 25));
        lbEliminar.setForeground(Azul);
        
        btEliminar = new JButton("Eliminar");
        btEliminar.setForeground(Color.WHITE);
        btEliminar.setBackground(Rojo);
//        btEliminar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {  
//            	
//            	if (getModificarUsuario().isEmpty()==false) {            		            	            	
//	            	ArrayList<String> lineas = new ArrayList<>();
//	                
//	            	try (BufferedReader br = new BufferedReader(new FileReader("./data/usuarios"))){
//	                    String linea;
//	                    while ((linea = br.readLine()) != null) {
//	                        lineas.add(linea);
//	                    }
//	                } 
//	            	catch (IOException k) {
//	            		k.printStackTrace();
//	                    return;
//	                }
//	
//	                lineas.removeIf(linea -> linea.startsWith(getModificarUsuario()));
//	                int cont = 0;
//	                
//	                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/usuarios"))){
//	                    for (String linea : lineas) {
//	                        bw.write(linea);
//	                        
//	                        if (cont != lineas.size()-1) {
//	                        	bw.write("\n");
//	                        }                        
//	                        cont++;
//	                    }                    
//	                }
//	                
//	                catch (IOException k) {
//	                	k.printStackTrace();
//	                    return;
//	                }
//	            }
//            }
//        });
        
        jpListaGrupos.add(scrollPaneGrupos);
        jpListaGrupos.add(lbEliminar);
        jpListaGrupos.add(btEliminar);
        
        
      //-----------------PANEL 2-----------------//
        jpModificarGrupos.setBorder(BorderFactory.createTitledBorder("Modificar Huespedes"));
        jpModificarGrupos.setPreferredSize(new Dimension(300, 100));	   	    
        jpModificarGrupos.setBackground(Color.WHITE);	    
        
        lbResponsable = new JLabel("Responsable");
        lbResponsable.setPreferredSize(new Dimension(100, 25));
        lbResponsable.setForeground(Azul);
        
        textResponsable = new JTextField();
        textResponsable.setPreferredSize(new Dimension(250, 25));
        textResponsable.setBorder(BorderFactory.createLineBorder(Azul));
      
        lbIntegrantes = new JLabel("Integrantes");
        lbIntegrantes.setPreferredSize(new Dimension(100, 25));
        lbIntegrantes.setForeground(Azul);
        
        DefaultListModel<String> integrantes = new DefaultListModel<String>();
        integrantes.addElement("1");
        integrantes.addElement("2");
        integrantes.addElement("3");
	    
        listaIntegrantes = new JList<>(integrantes);
        listaIntegrantes.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //String nombre = listaHuespedes.getSelectedValue();
//                String login = loginConNombre(hotel, nombre);
//                setModificarNombre(nombre);
//                setModificarUsuario(login);
//                setModificarContrasena(hotel.getUsuario().get(login).getPassword());
//                setModificarCorreo(hotel.getUsuario().get(login).getCorreo());
//                setModificarContrasena(hotel.getUsuario().get(login).getPassword());
            	//listaHuespedes.setSelectedItem();
            }
        });
        
        scrollPaneIntegrantes = new JScrollPane(listaIntegrantes);
        scrollPaneIntegrantes.setPreferredSize(new Dimension(190, 100));
                        
        btAgregarHuesped = new JButton("Agregar Huesped");
        btAgregarHuesped.setForeground(Color.WHITE);
        btAgregarHuesped.setBackground(Azul);
		
		btEliminarHuesped = new JButton("Eliminar Huesped");
		btEliminarHuesped.setForeground(Color.WHITE);
		btEliminarHuesped.setBackground(Azul);
     
		btEditar = new JButton("Editar");
		btEditar.setForeground(Color.WHITE);
		btEditar.setBackground(Azul);
//		btEditar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {             	
//            	textModificarContraseña.setEditable(true);
//            	textModificarNombre.setEditable(true);
//            	textModificarCorreo.setEditable(true); 
//            	listaTipos.setEnabled(true);
//            }
//        });
		

        btGuardar = new JButton("Guardar");
        btGuardar.setForeground(Color.WHITE);
        btGuardar.setBackground(Verde);
//        btGuardar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {  
//            	if (textModificarContraseña.isEditable()==true && getModificarUsuario().isEmpty()==false && getModificarContraseña().isEmpty()==false) {
//            	ArrayList<String> lineas = new ArrayList<>();
//                
//            	try (BufferedReader br = new BufferedReader(new FileReader("./data/usuarios"))){
//                    String linea;
//                    while ((linea = br.readLine()) != null) {
//                        lineas.add(linea);
//                    }
//                } 
//            	catch (IOException k) {
//            		k.printStackTrace();
//                    return;
//                }
//
//            	String nuevaLinea = getModificarUsuario()+";"+getModificarContraseña()+";"+getModificarNombre()+";"+getModificarTipo()+";"+getModificarCorreo();
//                lineas.removeIf(linea -> linea.startsWith(getModificarUsuario()));
//                lineas.add(nuevaLinea);
//                
//                int cont = 0;
//                
//                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/usuarios"))){
//                    for (String linea : lineas) {
//                        bw.write(linea);
//                        
//                        if (cont != lineas.size()-1) {
//                        	bw.write("\n");
//                        }
//                        
//                        cont++;
//                    }
//                    
//                    recetearModificarUsuarios();                  
//                } 
//                
//                catch (IOException k) {
//                	k.printStackTrace();
//                    return;
//                }
//            }
//        }});
        
        jpModificarGrupos.add(lbResponsable);
        jpModificarGrupos.add(textResponsable);
        jpModificarGrupos.add(lbIntegrantes);
        jpModificarGrupos.add(scrollPaneIntegrantes);
        jpModificarGrupos.add(btAgregarHuesped);
        jpModificarGrupos.add(btEliminarHuesped);              
        jpModificarGrupos.add(btEditar);
        jpModificarGrupos.add(btGuardar);
		
		
		//-----------------PANEL 3-----------------//
        jpModificarHuespedes.setBorder(BorderFactory.createTitledBorder("Crear Usuarios"));
		jpModificarHuespedes.setPreferredSize(new Dimension(500, 150));	   	    
		jpModificarHuespedes.setBackground(Color.WHITE);	
		
		lbModificarHuesped = new JLabel("Huesped");
		lbModificarHuesped.setPreferredSize(new Dimension(150, 12));
		lbModificarHuesped.setForeground(Azul);
        
		textModificarUsuario = new JTextField();
		textModificarUsuario.setPreferredSize(new Dimension(150, 20));
		textModificarUsuario.setBorder(BorderFactory.createLineBorder(Azul));
      
		lbModificarDoc = new JLabel("Documento");
		lbModificarDoc.setPreferredSize(new Dimension(150, 12));
		lbModificarDoc.setForeground(Azul);
        
		textModificarDoc = new JTextField();
		textModificarDoc.setPreferredSize(new Dimension(150, 20));
		textModificarDoc.setBorder(BorderFactory.createLineBorder(Azul));
      
		lbModificarCorreo = new JLabel("Correo");
		lbModificarCorreo.setPreferredSize(new Dimension(150, 12));
		lbModificarCorreo.setForeground(Azul);
        
		textModificarCorreo = new JTextField();
		textModificarCorreo.setPreferredSize(new Dimension(150, 20));
		textModificarCorreo.setBorder(BorderFactory.createLineBorder(Azul));
        
		lbModificarCelular = new JLabel("Celular");
		lbModificarCelular.setPreferredSize(new Dimension(150, 12));
		lbModificarCelular.setForeground(Azul);       
        
		textModificarCelular = new JTextField();
		textModificarCelular.setPreferredSize(new Dimension(150, 20));
		textModificarCelular.setBorder(BorderFactory.createLineBorder(Azul));
        
		lbModificarEdad = new JLabel("Edad");
		lbModificarEdad.setPreferredSize(new Dimension(150, 12));
		lbModificarEdad.setForeground(Azul);		
		
		textModificarEdad = new JTextField();
		textModificarEdad.setPreferredSize(new Dimension(150, 20));
		textModificarEdad.setBorder(BorderFactory.createLineBorder(Azul));
        
		btEditarModificacion = new JButton("Editar");
		btEditarModificacion.setForeground(Color.WHITE);
		btEditarModificacion.setBackground(Azul);
		
		btGuardarModificacion = new JButton("Guardar");
		btGuardarModificacion.setForeground(Color.WHITE);
		btGuardarModificacion.setBackground(Azul);
		
		JLabel espacio = new JLabel();
		espacio.setPreferredSize((new Dimension(150, 20)));
		espacio.setEnabled(false);

		jpModificarHuespedes.add(lbModificarHuesped);
		jpModificarHuespedes.add( textModificarUsuario);
		jpModificarHuespedes.add(lbModificarDoc);
		jpModificarHuespedes.add( textModificarDoc);
		jpModificarHuespedes.add(lbModificarCorreo);
		jpModificarHuespedes.add( textModificarCorreo);
		jpModificarHuespedes.add(lbModificarCelular);
		jpModificarHuespedes.add( textModificarCelular);
		jpModificarHuespedes.add(lbModificarEdad);
		jpModificarHuespedes.add( textModificarEdad);
		jpModificarHuespedes.add(btEditarModificacion);
		jpModificarHuespedes.add(btGuardarModificacion);
		
		
		
		add(jpListaGrupos, BorderLayout.WEST);
        add(jpModificarGrupos, BorderLayout.EAST);
        add(jpModificarHuespedes, BorderLayout.SOUTH);
	}
}
