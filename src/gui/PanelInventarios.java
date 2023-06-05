package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelInventarios extends  JPanel{
	
	private JPanel jpInventario;
	private JPanel jpInformación;
	private JList<String> listaInventario;
	private JList<String> listaInfo;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;

	
	public PanelInventarios() 
	{
		Color Azul = new Color(40, 130, 255);
		Color Rojo = new Color(200, 50, 50);
		Color Verde = new Color(100, 200, 70);


		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(550, 450));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Azul));        
		setLayout(new BorderLayout());

//      setLayout(new GridBagLayout());
//	    GridBagConstraints def = new GridBagConstraints();
	    
	
	  //-----------------PANELES-----------------//
		jpInventario = new JPanel();
		jpInformación = new JPanel();
	    
	    
	  //-----------------PANEL 1-----------------//
	    jpInventario.setBorder(BorderFactory.createTitledBorder("Seleccionar Inventario"));
	    jpInventario.setPreferredSize(new Dimension(200, 200));
	    jpInventario.setBackground(Color.WHITE);
	    
        String[] inventario = {"Facturas","Huespedes","Reservas"};
        listaInventario = new JList<>(inventario);
        scrollPane1 = new JScrollPane(listaInventario);
        scrollPane1.setPreferredSize(new Dimension(190, 190));
        
        jpInventario.add(scrollPane1);

        
      //-----------------PANEL 2-----------------//
        jpInformación.setBorder(BorderFactory.createTitledBorder("Seleccionar Inventario"));
	    jpInformación.setPreferredSize(new Dimension(300, 450));
	    jpInformación.setBackground(Color.WHITE);
	    
        String[] info = {"----# Inicio---------  Fin--------- Costo---------", "----# Inicio---------  Fin--------- Costo---------", "----# Inicio---------  Fin--------- Costo---------"};
        listaInfo = new JList<>(info);
        scrollPane2 = new JScrollPane(listaInfo);
        scrollPane2.setPreferredSize(new Dimension(320, 420));
        
        jpInformación.add(scrollPane2);
        
        
        add(jpInventario, BorderLayout.WEST);
        add(jpInformación, BorderLayout.CENTER);
	    
	}

}
