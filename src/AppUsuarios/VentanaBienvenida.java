package AppUsuarios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Procesamiento.Hotel;
import gui.VentanaAdmi;
import gui.VentanaEmpleado;
import gui.VentanaEntrada;
import gui.VentanaRecep;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class VentanaBienvenida extends JFrame{
	
	private JTextField textField;
	private JTextField textField_1;
	
	public VentanaBienvenida(Hotel hotel) {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 363, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hotel Manager");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setBackground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(143, 25, 113, 14);
		panel.add(lblNewLabel);
		
		JLabel lblB = new JLabel("Bienvenido de nuevo");
		lblB.setForeground(SystemColor.textHighlight);
		lblB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblB.setEnabled(true);
		lblB.setBackground(Color.WHITE);
		lblB.setBounds(124, 89, 139, 14);
		getContentPane().add(lblB);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(SystemColor.textHighlight);
		lblUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblUsuario.setEnabled(true);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(90, 113, 139, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblConstrasea = new JLabel("Constraseña");
		lblConstrasea.setForeground(SystemColor.textHighlight);
		lblConstrasea.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblConstrasea.setEnabled(true);
		lblConstrasea.setBackground(Color.WHITE);
		lblConstrasea.setBounds(90, 179, 139, 14);
		getContentPane().add(lblConstrasea);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(SystemColor.textHighlight));
		textField.setCaretColor(SystemColor.textHighlight);
		textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		textField.setForeground(SystemColor.textHighlight);
		textField.setBounds(90, 138, 189, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(SystemColor.textHighlight);
		textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		textField_1.setColumns(10);
		textField_1.setCaretColor(SystemColor.textHighlight);
		textField_1.setBorder(new LineBorder(SystemColor.textHighlight));
		textField_1.setBounds(90, 201, 189, 20);
		getContentPane().add(textField_1);
		
		JLabel lblEl = new JLabel("El usuario o contraseña no existe");
		lblEl.setForeground(Color.WHITE);
		lblEl.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblEl.setEnabled(true);
		lblEl.setBackground(Color.WHITE);
		lblEl.setBounds(90, 232, 215, 14);
		getContentPane().add(lblEl);
		
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (hotel.getUsuario().get(getLogin()) != null) {
					System.out.print((hotel.getUsuario().get(getLogin()) != null));
					lblEl.setForeground(Color.WHITE);
            		if (hotel.getUsuario().get(getLogin()).getPassword().equals(getContrasena())) {
            			if (hotel.getUsuario().get(getLogin()).getTipoUsuario().equals("Huesped")){
            				new VentanaReservasUser(hotel);
            			}

			}
				}
				else{
					lblEl.setForeground(Color.RED);
					
				}}});
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(90, 269, 189, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new VentanaUsuario(hotel);
			}
		});
		btnCrearUsuario.setForeground(SystemColor.textHighlight);
		btnCrearUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnCrearUsuario.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		btnCrearUsuario.setBackground(new Color(255, 255, 255));
		btnCrearUsuario.setBounds(90, 303, 189, 23);
		getContentPane().add(btnCrearUsuario);
		
		setVisible(true);
		setSize(new Dimension(380,400));
		setIconImage(null);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getLogin() {
		String login = textField.getText();
		return login;
	}

	public String getContrasena() {
		String contrasena = textField_1.getText();
		return contrasena;
	}
	
	


}



	

