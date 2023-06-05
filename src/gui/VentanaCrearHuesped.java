package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaCrearHuesped extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel jpEncabezado;	
	private JLabel lbNombre;
	private JTextField textNombre;
	private JLabel lbDoc;
	private JTextField textDoc;
	private JLabel lbCorreo;
	private JTextField textCorreo;
	private JLabel lbCelu;
	private JTextField textCelu;
	private JLabel lbEdad;
	private JTextField textEdad;
	private JButton btCrear;
	

	public VentanaCrearHuesped(int i) 
	{		
		Color Azul = new Color(40, 130, 255);
		Color Verde = new Color(100, 200, 70);
		
		ArrayList<String> docs = new ArrayList<>();
		
		jpEncabezado = new JPanel();		
		
		jpEncabezado.setBorder(BorderFactory.createTitledBorder("Crear huesped"));
        jpEncabezado.setPreferredSize(new Dimension(320, 200));	   	    
        jpEncabezado.setBackground(Color.WHITE);	    
  
		lbNombre = new JLabel("Nombre:");
        lbNombre.setPreferredSize(new Dimension(200, 20));
        lbNombre.setForeground(Azul);
        
        textNombre = new JTextField();
        textNombre.setPreferredSize(new Dimension(200, 20));
        textNombre.setBorder(BorderFactory.createLineBorder(Azul));

        lbDoc = new JLabel("Documento:");
        lbDoc.setPreferredSize(new Dimension(200, 20));
        lbDoc.setForeground(Azul);
        
        textDoc = new JTextField();
        textDoc.setPreferredSize(new Dimension(200, 20));
        textDoc.setBorder(BorderFactory.createLineBorder(Azul));

        lbCorreo = new JLabel("Correo:");
        lbCorreo.setPreferredSize(new Dimension(200, 20));
        lbCorreo.setForeground(Azul);
        
        textCorreo = new JTextField();
        textCorreo.setPreferredSize(new Dimension(200, 20));
        textCorreo.setBorder(BorderFactory.createLineBorder(Azul));

        lbCelu = new JLabel("Celu:");
        lbCelu.setPreferredSize(new Dimension(200, 20));
        lbCelu.setForeground(Azul);
        
        textCelu = new JTextField();
        textCelu.setPreferredSize(new Dimension(200, 20));
        textCelu.setBorder(BorderFactory.createLineBorder(Azul));
        
        lbEdad = new JLabel("Edad:");
        lbEdad.setPreferredSize(new Dimension(200, 20));
        lbEdad.setForeground(Azul);
        
        textEdad = new JTextField();
        textEdad.setPreferredSize(new Dimension(200, 20));
        textEdad.setBorder(BorderFactory.createLineBorder(Azul));

        btCrear = new JButton("Crear");
        btCrear.setForeground(Color.WHITE);
        btCrear.setBackground(Verde);
        btCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
            	if(getNombre().isEmpty()==false && getDoc().isEmpty()==false 
            			&& getCorreo().isEmpty()==false
            			&& getCelu().isEmpty()==false 
            			&& getEdad().isEmpty()==false) {
            	
	            	try {
	                    BufferedWriter bw = new BufferedWriter(new FileWriter("./data/huespedes", true));
	                    BufferedWriter bwr = new BufferedWriter(new FileWriter("./data/reservas", true));
	                    
	                    bw.newLine();
	                    bw.write(getNombre().trim());
	                    bw.write(";");
	                    bw.write(getDoc().trim());	                    
	                    bw.write(";");
	                    bw.write(getCorreo().trim());
	                    bw.write(";");
	                    bw.write(getCelu().trim());
	                    bw.write(";");
	                    bw.write(getEdad().trim());
	                    
	                    bwr.write(getDoc().trim());
	                    if (i>0)
	                    	bwr.write(",");
						
	                    bwr.close();
	                    
	                    bw.close();
	                    
	                    recetearCrearUsuarios();
	                    dispose();
	                    
	                } catch (IOException k) {
	                    k.printStackTrace();
	                }
	            }
            	else
            		dispose();
            }
        });
		
        
        jpEncabezado.add(btCrear);
        
        jpEncabezado.add(lbNombre);
        jpEncabezado.add(textNombre);
        jpEncabezado.add(lbDoc);
        jpEncabezado.add(textDoc);
        jpEncabezado.add(lbCorreo);
        jpEncabezado.add(textCorreo);
        jpEncabezado.add(lbCelu);
        jpEncabezado.add(textCelu);
        jpEncabezado.add(lbEdad);
        jpEncabezado.add(textEdad);
        jpEncabezado.add(btCrear);
        
		add(jpEncabezado);		
		setSize(new Dimension(250,350));
		setIconImage(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void recetearCrearUsuarios() {
		setNombre("");
		setDoc("");
		setCorreo("");
        setCelu("");
        setEdad("");
	}

	public void setNombre(String nombre) {
		textNombre.setText(nombre);
	}
	
	public void setDoc(String doc) {
		textDoc.setText(doc);
	}

	public void setCorreo(String correo) {
		textCorreo.setText(correo);
	}

	public void setCelu(String celu) {
		textCelu.setText(celu);
	}
	
	public void setEdad(String edad) {
		textEdad.setText(edad);
	}

	public String getNombre() {
		return textNombre.getText();
	}
	
	public String getDoc() {
		return textDoc.getText();
	}
	
	public String getCorreo() {
		return textCorreo.getText();
	}
	
	public String getCelu() {
		return textCelu.getText();
	}
	
	public String getEdad() {
		return textEdad.getText();
	}

}

