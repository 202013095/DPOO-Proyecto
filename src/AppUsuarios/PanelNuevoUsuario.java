package AppUsuarios;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Procesamiento.Hotel;
import gui.PanelUsuarios;

public class PanelNuevoUsuario extends PanelUsuarios{

	public PanelNuevoUsuario(Hotel hotel) {
		super(hotel);
		eliminarTodosLosBotones();
		// TODO Auto-generated constructor stub
		
		JButton btAgregar = super.getbtAgregar();
		btAgregar.setText("Crear Usuario");
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
		
		
		JComboBox<String> tipoUser = super.getlistaCrearTipos();
		tipoUser.setModel(new DefaultComboBoxModel<>(new String[]{"Huesped"}));
		
	}

	 public void eliminarTodosLosBotones() {
		 
		 JPanel jpListaUsuarios = super.getJpListaUsuarios();
		 JPanel jpModificarUsuario=super.getJpModificarUsuario();
		 remove(jpListaUsuarios);
		 remove(jpModificarUsuario);
		 revalidate();
	     repaint();
	     
	    }
	
	
	

}
