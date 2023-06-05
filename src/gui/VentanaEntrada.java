package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Procesamiento.Hotel;
import gui.VentanaAdmi;


public class VentanaEntrada extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lbLogin;
	private JLabel lbContrasena;
	private JLabel lbBienvenida;
	private JTextField textLogin;
	private JTextField textContrasena;
	private JButton btIngresar;
	
	public VentanaEntrada(Hotel hotel)
	{
		//Caracteristicas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setIconImage(null);
		setResizable(false);
        setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		Color Azul = new Color(40, 130, 255);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setPreferredSize(new Dimension(250, 250));
        
        lbBienvenida = new JLabel("Bienvenido a \nHotel Manager");
        lbBienvenida.setPreferredSize(new Dimension(200, 60));

        
        lbLogin = new JLabel("Usuario:");
        lbLogin.setPreferredSize(new Dimension(200, 25));
        //lbUsuario.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        lbLogin.setForeground(Azul);
        
        textLogin = new JTextField();
        textLogin.setPreferredSize(new Dimension(200, 25));
        //textUsuario.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        textLogin.setBorder(BorderFactory.createLineBorder(Azul));
      
        lbContrasena = new JLabel("Contraseña:");
        lbContrasena.setPreferredSize(new Dimension(200, 25));
        lbContrasena.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lbContrasena.setForeground(Azul);

        textContrasena = new JTextField();          
        textContrasena.setPreferredSize(new Dimension(200, 25));
        textContrasena.setBorder(BorderFactory.createLineBorder(Azul));

		
        btIngresar = new JButton("Ingresar");
        btIngresar.setForeground(Color.WHITE);
        btIngresar.setBackground(Azul);
        btIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
            	//System.out.println(hotel.getUsuario().get(getLogin()));
            	//System.out.println(hotel.getUsuario().get(getLogin()).getPassword());
            	//System.out.println(getContrasena());
            	
            	if (hotel.getUsuario().get(getLogin()) != null) {
            		if (hotel.getUsuario().get(getLogin()).getPassword().equals(getContrasena())) {
            			if (hotel.getUsuario().get(getLogin()).getTipoUsuario().equals("Administrador")){
            				new VentanaAdmi(hotel);
            			}
            			else if (hotel.getUsuario().get(getLogin()).getTipoUsuario().equals("Recepcionista")) {
            				new VentanaRecep(hotel);
            			}
            			else if (hotel.getUsuario().get(getLogin()).getTipoUsuario().equals("Empleado")) {
            				new VentanaEmpleado(hotel);
            			}            			
            		}            							
				}
            }
        });

        panel.add(lbBienvenida);
        panel.add(lbLogin);
        panel.add(textLogin);
        panel.add(lbContrasena);
        panel.add(textContrasena);
        panel.add(btIngresar);

        add(panel);
        
		setVisible(true);
	}
	
	public String getLogin() {
		String login = textLogin.getText();
		return login;
	}
	
	public String getContrasena() {
		String contrasena = textContrasena.getText();
		return contrasena;
	}

}
