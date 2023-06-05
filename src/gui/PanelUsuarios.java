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
import java.util.ArrayList;

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

import Procesamiento.Hotel;

public class PanelUsuarios extends JPanel{

	private static final long serialVersionUID = 1L;
	public JPanel jpListaUsuarios;
	public JPanel jpModificarUsuario;
	private JPanel jpCrearUsuario;
	private JList<String> listaUsuarios;
	private JScrollPane scrollPane;
	private JLabel lbModificarUsuario;
	private JTextField textModificarUsuario;
	private JLabel lbModificarContraseña;
	private JTextField textModificarContraseña;
	private JLabel lbModificarNombre;
	private JTextField textModificarNombre;
	private JLabel lbModificarCorreo;
	private JTextField textModificarCorreo;
	private JLabel lbModificarTipo;
	private JComboBox<String> listaTipos;
	private JLabel lbEliminar;
	private JButton btEliminar;
	private JButton btEditar;
	private JButton btGuardar;
	private JLabel lbCrearUsuario;
	private JTextField textCrearUsuario;
	private JLabel lbCrearContraseña;
	private JTextField textCrearContraseña;
	private JLabel lbCrearNombre;
	private JTextField textCrearNombre;
	private JLabel lbCrearCorreo;
	private JTextField textCrearCorreo;
	private JLabel lbCrearTipo;
	protected JComboBox<String> listaCrearTipos;
	protected JButton btAgregar;

	
	public PanelUsuarios(Hotel hotel) 
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
	    jpListaUsuarios = new JPanel();
	    jpModificarUsuario = new JPanel();
	    jpCrearUsuario = new JPanel();	    
	    
	    
	  //-----------------PANEL 1-----------------//
        jpListaUsuarios.setBorder(BorderFactory.createTitledBorder("Consultar Usuarios"));
	    jpListaUsuarios.setPreferredSize(new Dimension(220, 220));
	    jpListaUsuarios.setBackground(Color.WHITE);
        	 
        listaUsuarios = new JList<>(listaUsuarios(hotel));
        listaUsuarios.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String nombre = listaUsuarios.getSelectedValue();
                String login = loginConNombre(hotel, nombre);
                setModificarNombre(nombre);
                setModificarUsuario(login);
                setModificarContrasena(hotel.getUsuario().get(login).getPassword());
                setModificarCorreo(hotel.getUsuario().get(login).getCorreo());
                setModificarContrasena(hotel.getUsuario().get(login).getPassword());
                listaTipos.setSelectedItem(hotel.getUsuario().get(login).getTipoUsuario());
                listaTipos.setEditable(false);
                listaTipos.setEnabled(false);
            }
        });
        
        scrollPane = new JScrollPane(listaUsuarios);
        scrollPane.setPreferredSize(new Dimension(190, 150));
        
        lbEliminar = new JLabel("Eliminar Usuario Seleccionado:");
        lbEliminar.setPreferredSize(new Dimension(180, 25));
        lbEliminar.setForeground(Azul);
        
        btEliminar = new JButton("Eliminar");
        btEliminar.setForeground(Color.WHITE);
        btEliminar.setBackground(Rojo);
        btEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
            	
            	if (getModificarUsuario().isEmpty()==false) {            		            	            	
	            	ArrayList<String> lineas = new ArrayList<>();
	                
	            	try (BufferedReader br = new BufferedReader(new FileReader("./data/usuarios"))){
	                    String linea;
	                    while ((linea = br.readLine()) != null) {
	                        lineas.add(linea);
	                    }
	                } 
	            	catch (IOException k) {
	            		k.printStackTrace();
	                    return;
	                }
	
	                lineas.removeIf(linea -> linea.startsWith(getModificarUsuario()));
	                int cont = 0;
	                
	                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/usuarios"))){
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
        
        jpListaUsuarios.add(scrollPane);
        jpListaUsuarios.add(lbEliminar);
        jpListaUsuarios.add(btEliminar);
        
        
      //-----------------PANEL 2-----------------//
        jpModificarUsuario.setBorder(BorderFactory.createTitledBorder("Modificar Usuarios"));
        jpModificarUsuario.setPreferredSize(new Dimension(330, 220));	   	    
        jpModificarUsuario.setBackground(Color.WHITE);	    
        
        lbModificarUsuario = new JLabel("Usuario");
        lbModificarUsuario.setPreferredSize(new Dimension(100, 12));
        lbModificarUsuario.setForeground(Azul);
        
        textModificarUsuario = new JTextField();
        textModificarUsuario.setPreferredSize(new Dimension(250, 20));
        textModificarUsuario.setBorder(BorderFactory.createLineBorder(Azul));
      
        lbModificarContraseña = new JLabel("Contraseña");
        lbModificarContraseña.setPreferredSize(new Dimension(100, 12));
        lbModificarContraseña.setForeground(Azul);
        
        textModificarContraseña = new JTextField();
        textModificarContraseña.setPreferredSize(new Dimension(250, 20));
        textModificarContraseña.setBorder(BorderFactory.createLineBorder(Azul));
      
        lbModificarNombre = new JLabel("Nombre");
        lbModificarNombre.setPreferredSize(new Dimension(100, 12));
        lbModificarNombre.setForeground(Azul);
        
        textModificarNombre = new JTextField();
        textModificarNombre.setPreferredSize(new Dimension(250, 20));
        textModificarNombre.setBorder(BorderFactory.createLineBorder(Azul));
        
        lbModificarCorreo = new JLabel("Correo");
        lbModificarCorreo.setPreferredSize(new Dimension(100, 12));
        lbModificarCorreo.setForeground(Azul);       
        
        textModificarCorreo = new JTextField();
        textModificarCorreo.setPreferredSize(new Dimension(250, 20));
        textModificarCorreo.setBorder(BorderFactory.createLineBorder(Azul));
        
        lbModificarTipo = new JLabel("Tipo Usuario");
        lbModificarTipo.setPreferredSize(new Dimension(100, 12));
        lbModificarTipo.setForeground(Azul);
        
        listaTipos = new JComboBox<>(new String[]{"Administrador","Recepcionista","Empleado"});
		listaTipos.setPreferredSize((new Dimension(250, 20)));
		listaTipos.setBorder(BorderFactory.createLineBorder(Azul));
		
		btEditar = new JButton("Editar");
		btEditar.setForeground(Color.WHITE);
		btEditar.setBackground(Azul);
		btEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	textModificarContraseña.setEditable(true);
            	textModificarNombre.setEditable(true);
            	textModificarCorreo.setEditable(true); 
            	listaTipos.setEnabled(true);
            }
        });
		

        btGuardar = new JButton("Guardar");
        btGuardar.setForeground(Color.WHITE);
        btGuardar.setBackground(Verde);
        btGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
            	if (textModificarContraseña.isEditable()==true && getModificarUsuario().isEmpty()==false && getModificarContraseña().isEmpty()==false) {
            	ArrayList<String> lineas = new ArrayList<>();
                
            	try (BufferedReader br = new BufferedReader(new FileReader("./data/usuarios"))){
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }
                } 
            	catch (IOException k) {
            		k.printStackTrace();
                    return;
                }

            	String nuevaLinea = getModificarUsuario()+";"+getModificarContraseña()+";"+getModificarNombre()+";"+getModificarTipo()+";"+getModificarCorreo();
                lineas.removeIf(linea -> linea.startsWith(getModificarUsuario()));
                lineas.add(nuevaLinea);
                
                int cont = 0;
                
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/usuarios"))){
                    for (String linea : lineas) {
                        bw.write(linea);
                        
                        if (cont != lineas.size()-1) {
                        	bw.write("\n");
                        }
                        
                        cont++;
                    }
                    
                    recetearModificarUsuarios();                  
                } 
                
                catch (IOException k) {
                	k.printStackTrace();
                    return;
                }
            }
        }});
        
		jpModificarUsuario.add(lbModificarUsuario);
		jpModificarUsuario.add(textModificarUsuario);
		jpModificarUsuario.add(lbModificarContraseña);
		jpModificarUsuario.add(textModificarContraseña);
		jpModificarUsuario.add(lbModificarNombre);
		jpModificarUsuario.add(textModificarNombre);
		jpModificarUsuario.add(lbModificarCorreo);
		jpModificarUsuario.add(textModificarCorreo);
		jpModificarUsuario.add(lbModificarTipo);
		jpModificarUsuario.add(listaTipos);
		jpModificarUsuario.add(btEditar);
		jpModificarUsuario.add(btGuardar);
		
		
	  //-----------------PANEL 3-----------------//
		jpCrearUsuario.setBorder(BorderFactory.createTitledBorder("Nuevo Usuario"));
		jpCrearUsuario.setPreferredSize(new Dimension(500, 150));	   	    
		jpCrearUsuario.setBackground(Color.WHITE);	
		
		lbCrearUsuario = new JLabel("Usuario");
		lbCrearUsuario.setPreferredSize(new Dimension(150, 12));
		lbCrearUsuario.setForeground(Azul);
        
		textCrearUsuario = new JTextField();
		textCrearUsuario.setPreferredSize(new Dimension(150, 20));
		textCrearUsuario.setBorder(BorderFactory.createLineBorder(Azul));
      
		lbCrearContraseña = new JLabel("Contraseña");
		lbCrearContraseña.setPreferredSize(new Dimension(150, 12));
		lbCrearContraseña.setForeground(Azul);
        
		textCrearContraseña = new JTextField();
		textCrearContraseña.setPreferredSize(new Dimension(150, 20));
		textCrearContraseña.setBorder(BorderFactory.createLineBorder(Azul));
      
		lbCrearNombre = new JLabel("Nombre");
		lbCrearNombre.setPreferredSize(new Dimension(150, 12));
		lbCrearNombre.setForeground(Azul);
        
		textCrearNombre = new JTextField();
		textCrearNombre.setPreferredSize(new Dimension(150, 20));
		textCrearNombre.setBorder(BorderFactory.createLineBorder(Azul));
        
		lbCrearCorreo = new JLabel("Correo");
		lbCrearCorreo.setPreferredSize(new Dimension(150, 12));
		lbCrearCorreo.setForeground(Azul);       
        
		textCrearCorreo = new JTextField();
		textCrearCorreo.setPreferredSize(new Dimension(150, 20));
		textCrearCorreo.setBorder(BorderFactory.createLineBorder(Azul));
        
		lbCrearTipo = new JLabel("Tipo Usuario");
		lbCrearTipo.setPreferredSize(new Dimension(150, 12));
		lbCrearTipo.setForeground(Azul);
        
		listaCrearTipos = new JComboBox<>(new String[]{"Administrador","Recepcionista","Empleado"});
		listaCrearTipos.setPreferredSize((new Dimension(150, 20)));
		listaCrearTipos.setBorder(BorderFactory.createLineBorder(Azul));

		btAgregar = new JButton("Agregar Usuario");
		btAgregar.setForeground(Color.WHITE);
		btAgregar.setBackground(Azul);
		btAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
            	if(getCrearUsuario().isEmpty()==false && getCrearContraseña().isEmpty()==false) {
            	
	            	try {
	                    FileWriter fileWriter = new FileWriter("./data/usuarios",true);
	                    BufferedWriter bw = new BufferedWriter(fileWriter);
	                    
	                    bw.newLine();
	                    bw.write(getCrearUsuario().trim());
	                    bw.write(";");
	                    bw.write(getCrearContraseña());
	                    bw.write(";");
	                    bw.write(getCrearNombre());
	                    bw.write(";");
	                    bw.write(getCrearTipo());
	                    bw.write(";");
	                    bw.write(getCrearCorreo().trim());
	                    
	                    bw.close();
	                    
	                    recetearCrearUsuarios();    
	                    
	                } catch (IOException k) {
	                    k.printStackTrace();
	                }
	            }
            }
        });
		
		JLabel espacio = new JLabel();
		espacio.setPreferredSize((new Dimension(150, 20)));
		espacio.setEnabled(false);
		
		jpCrearUsuario.add(lbCrearUsuario);
		jpCrearUsuario.add(lbCrearNombre);
		jpCrearUsuario.add(lbCrearTipo);
		jpCrearUsuario.add(textCrearUsuario);
		jpCrearUsuario.add(textCrearNombre);
		jpCrearUsuario.add(listaCrearTipos);
		jpCrearUsuario.add(lbCrearContraseña);
		jpCrearUsuario.add(lbCrearCorreo);
		jpCrearUsuario.add(espacio);
		jpCrearUsuario.add(textCrearContraseña);
		jpCrearUsuario.add(textCrearCorreo);
		jpCrearUsuario.add(btAgregar);
		
        add(jpListaUsuarios, BorderLayout.WEST);
        add(jpModificarUsuario, BorderLayout.EAST);
        add(jpCrearUsuario, BorderLayout.SOUTH);
        
	}
	
	
	public DefaultListModel<String> listaUsuarios(Hotel hotel){		
		DefaultListModel<String> nombres = new DefaultListModel<String>();
		
		for (String login :hotel.getUsuario().keySet()) {
			String nombre = hotel.getUsuario().get(login).getNombre();
			nombres.addElement(nombre);
		}		
		return nombres;
	}
	
	public String loginConNombre(Hotel hotel, String name) {
		String loginNombre = "";
		for (String login :hotel.getUsuario().keySet()) {
			String nombre = hotel.getUsuario().get(login).getNombre();			
			
			if (nombre==name) {
				loginNombre = login;
			}
		}		
		return loginNombre;
	}
	
	public void recetearModificarUsuarios() {
        setModificarUsuario("");
        setModificarNombre("");
        setModificarContrasena("");
        setModificarCorreo("");
	}
	
	public void recetearCrearUsuarios() {
        setCrearUsuario("");
        setCrearNombre("");
        setCrearContrasena("");
        setCrearCorreo("");
	}
	
	public void setModificarNombre(String nombre) {
		textModificarNombre.setEditable(true);
		textModificarNombre.setText(nombre);
		textModificarNombre.setEditable(false);
	}

	public void setModificarUsuario(String usuario) {
		textModificarUsuario.setEditable(true);
		textModificarUsuario.setText(usuario);
		textModificarUsuario.setEditable(false);
	}
	
	public void setModificarCorreo(String correo) {
		textModificarCorreo.setEditable(true);
		textModificarCorreo.setText(correo);
		textModificarCorreo.setEditable(false);
	}
	
	public void setModificarContrasena(String contrasena) {
		textModificarContraseña.setEditable(true);
		textModificarContraseña.setText(contrasena);
		textModificarContraseña.setEditable(false);
	}
	
	protected JPanel getJpListaUsuarios() {
	    return jpListaUsuarios;
	}

	protected JPanel getJpModificarUsuario() {
	    return jpModificarUsuario;
	}
	
	protected JButton getbtAgregar() {
	    return btAgregar;
	}
	protected JComboBox<String> getlistaCrearTipos() {
	    return listaCrearTipos;
	}
	
	public String getModificarUsuario() {
		String usuario = textModificarUsuario.getText();
		return usuario;
	}
	
	public String getModificarNombre() {
		String nombre = textModificarNombre.getText();
		return nombre;
	}
	
	public String getModificarContraseña() {
		String contrasena = textModificarContraseña.getText();
		return contrasena;
	}
	
	public String getModificarCorreo() {
		String correo = textModificarCorreo.getText();
		return correo;
	}
	
	public String getModificarTipo() {
		String tipo = (String) listaTipos.getSelectedItem();
		return tipo;
	}
	
	
	
	public void setCrearNombre(String nombre) {
		textCrearNombre.setEditable(true);
		textCrearNombre.setText(nombre);
	}

	public void setCrearUsuario(String usuario) {
		textCrearUsuario.setEditable(true);
		textCrearUsuario.setText(usuario);
	}
	
	public void setCrearCorreo(String correo) {
		textCrearCorreo.setEditable(true);
		textCrearCorreo.setText(correo);
	}
	
	public void setCrearContrasena(String contrasena) {
		textCrearContraseña.setEditable(true);
		textCrearContraseña.setText(contrasena);
	}
	
	
	
	public String getCrearUsuario() {
		String usuario = textCrearUsuario.getText();
		return usuario;
	}
	
	public String getCrearNombre() {
		String nombre = textCrearNombre.getText();
		return nombre;
	}
	
	public String getCrearContraseña() {
		String contrasena = textCrearContraseña.getText();
		return contrasena;
	}
	
	public String getCrearCorreo() {
		String correo = textCrearCorreo.getText();
		return correo;
	}
	
	public String getCrearTipo() {
		String tipo = (String) listaCrearTipos.getSelectedItem();
		return tipo;
	}
}
