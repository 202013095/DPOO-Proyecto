package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton btUsuario;
	private JButton btTarifas;
	private JButton btHabitaciones;
	private JButton btInventarios;

	
	public PanelOpciones(VentanaAdmi papa) 
	{
		Color Azul = new Color(40, 130, 255);

		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(180, 500));
        setBorder(BorderFactory.createLineBorder(Azul));        
		
        btUsuario = new JButton("Usuarios");
        btUsuario.setPreferredSize(new Dimension(170, 40));
        btUsuario.setForeground(Azul);
        btUsuario.setBackground(Color.WHITE);
        btUsuario.setBorder(BorderFactory.createLineBorder(Azul));
        btUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	papa.cambiarPanel(papa.getPanelUsuarios());
            }
        });
		
        btTarifas = new JButton("Tarifas");
        btTarifas.setPreferredSize(new Dimension(170, 40));
        btTarifas.setForeground(Azul);
        btTarifas.setBackground(Color.WHITE);
        btTarifas.setBorder(BorderFactory.createLineBorder(Azul));
		btTarifas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	papa.cambiarPanel(papa.getPanelTarifas());
            }
        });
		
        btHabitaciones = new JButton("Habitaciones");
        btHabitaciones.setPreferredSize(new Dimension(170, 40));
        btHabitaciones.setForeground(Azul);
        btHabitaciones.setBackground(Color.WHITE);
        btHabitaciones.setBorder(BorderFactory.createLineBorder(Azul));
        btHabitaciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	papa.cambiarPanel(papa.getPanelHabitaciones());
            }
        });
				
        btInventarios = new JButton("Inventarios");
        btInventarios.setPreferredSize(new Dimension(170, 40));
        btInventarios.setForeground(Azul);
        btInventarios.setBackground(Color.WHITE);
        btInventarios.setBorder(BorderFactory.createLineBorder(Azul));
        btInventarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	papa.cambiarPanel(papa.getPanelInventarios());
            }
        });

		add(btUsuario);
		add(btTarifas);
		add(btHabitaciones);
		add(btInventarios);
//	}
	}
}
