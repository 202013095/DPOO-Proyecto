package AppUsuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Procesamiento.Hotel;

public class VentanaNuevoUsuario extends JFrame{
	
	public VentanaNuevoUsuario(Hotel hotel){
		
		Color Azul = new Color(40, 130, 255);
		
		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(550, 450));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Azul));        
		setLayout(new BorderLayout());
		
		JPanel jpCrearUsuario = new PanelNuevoUsuario(hotel);	
		add(jpCrearUsuario);
		
		setVisible(true);
		setSize(new Dimension(500,200));
		setIconImage(null);
		setResizable(false);		
	}

	private void setBorder(Border border) {
		// TODO Auto-generated method stub
		
	}}


