package AppUsuarios;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;

public class OperacionExitosa extends JFrame{
	public OperacionExitosa() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("La operacion fue exitosa");
		lblNewLabel.setBounds(47, 33, 175, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblYaPuedeCerrar = new JLabel("Ya puede cerrar la ventana");
		lblYaPuedeCerrar.setBounds(47, 50, 175, 14);
		getContentPane().add(lblYaPuedeCerrar);
		
		setVisible(true);
		setSize(new Dimension(228,158));
		setIconImage(null);
		setResizable(false);
	}

}
