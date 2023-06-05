package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

public class panelError extends JFrame {
	public panelError() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("No ha ingresado el nombre");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(25, 11, 142, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblOFecha = new JLabel("o fecha de la reserva");
		lblOFecha.setForeground(Color.RED);
		lblOFecha.setBounds(35, 29, 142, 42);
		getContentPane().add(lblOFecha);
		
		setIconImage(null);
		setSize(200,130);
		setResizable(false);		
		setVisible(true);}
	}
	
	
