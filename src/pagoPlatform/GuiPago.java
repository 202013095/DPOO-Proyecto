package pagoPlatform;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiPago extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public GuiPago(PasarelaPago pasarela, String pasarelaname, int precio, int notrans) {
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 434, 74);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(pasarelaname);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(30, 11, 141, 39);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(SystemColor.textHighlight));
		textField.setBounds(93, 153, 239, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(SystemColor.textHighlight));
		textField_1.setBounds(93, 223, 239, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(SystemColor.textHighlight));
		textField_2.setBounds(93, 292, 239, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Numero Tarjeta");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(93, 129, 125, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de Vencimiento");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(93, 198, 125, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Codigo de seguridad");
		lblNewLabel_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_1.setBounds(93, 267, 125, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Total a Pagar");
		lblNewLabel_1_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_2.setBounds(93, 354, 125, 14);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("No.Transaccion");
		lblNewLabel_1_1_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_2_1.setBounds(93, 385, 125, 14);
		getContentPane().add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("");
		lblNewLabel_1_1_2_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1_2_1_1.setBounds(93, 410, 125, 14);
		getContentPane().add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("----");
		lblNewLabel_1_1_2_2.setForeground(SystemColor.controlText);
		lblNewLabel_1_1_2_2.setBounds(252, 354, 80, 14);
		getContentPane().add(lblNewLabel_1_1_2_2);
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("$");
		lblNewLabel_1_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_2_2_1.setBounds(228, 354, 18, 14);
		getContentPane().add(lblNewLabel_1_1_2_2_1);
		
		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("----");
		lblNewLabel_1_1_2_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2_2_2.setBounds(252, 385, 80, 14);
		getContentPane().add(lblNewLabel_1_1_2_2_2);
		
		JButton btnNewButton = new JButton("Realizar Pago");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Boolean pagoestado = realizarPago( pasarela,textField.getText(),textField_1.getText(),textField_2.getText(), precio, notrans );
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setForeground(SystemColor.controlLtHighlight);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(196, 441, 136, 23);
		getContentPane().add(btnNewButton);
	}
	
    public boolean realizarPago(PasarelaPago pasarela, String num, String ven,String cod, int precio, int nume) {
        
    	PasarelaPago pasarelaPago = pasarela;

    	// Crear la instancia de InformacionTarjetaCredito
    	InformacionTarjetaCredito tarjetaCredito = new InformacionTarjetaCredito();
    	tarjetaCredito.setNumeroTarjeta(num);
    	tarjetaCredito.setFechaVencimiento(ven);
    	tarjetaCredito.setCodigoSeguridad(cod);

    	// Crear la instancia de InformacionPago
    	InformacionPago informacionPago = new InformacionPago();
    	informacionPago.setMonto(100);
    	informacionPago.setNumeroCuenta(Integer.toString(precio));
    	informacionPago.setNumeroTransaccion(Integer.toString(nume));

    	// Realizar el pago utilizando la pasarela de pago seleccionada
    	boolean pagoExitoso = pasarelaPago.realizarPago(tarjetaCredito, informacionPago);

    	// Verificar el resultado del pago
    	if (pagoExitoso) {
    	    System.out.println("Pago realizado exitosamente");
    	} else {
    	    System.out.println("El pago no pudo ser procesado");
    	}
    	
		return pagoExitoso;
    }
}
