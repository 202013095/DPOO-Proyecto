package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

import Procesamiento.Hotel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaRece extends JFrame{
	public VentanaRece() {
		getContentPane().setLayout(null);
		
		JTabbedPane OpcionesRecep = new JTabbedPane(JTabbedPane.LEFT);
		OpcionesRecep.setAlignmentY(3.0f);
		OpcionesRecep.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		OpcionesRecep.setBounds(new Rectangle(5, 10, 0, 0));
		OpcionesRecep.setOpaque(true);
		OpcionesRecep.setSize(new Dimension(5, 0));
		OpcionesRecep.setBorder(null);
		OpcionesRecep.setBackground(SystemColor.controlHighlight);
		OpcionesRecep.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		OpcionesRecep.setForeground(SystemColor.textHighlight);
		OpcionesRecep.setBounds(0, 48, 739, 512);
		getContentPane().add(OpcionesRecep);
		
		JPanel panelGrupos = new JPanel();
		OpcionesRecep.addTab("GRUPOS", null, panelGrupos, null);
		panelGrupos.setLayout(null);
		
		JPanel panelConsultarGrupos = new JPanel();
		panelConsultarGrupos.setLayout(null);
		panelConsultarGrupos.setBackground(Color.WHITE);
		panelConsultarGrupos.setBounds(10, 11, 320, 284);
		panelGrupos.add(panelConsultarGrupos);
		
		JLabel lblPanel = new JLabel("CONSULTAR GRUPOS");
		lblPanel.setForeground(SystemColor.textHighlight);
		lblPanel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblPanel.setBounds(10, 11, 128, 18);
		panelConsultarGrupos.add(lblPanel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		comboBox_1.setBorder(new LineBorder(SystemColor.textInactiveText, 1, true));
		comboBox_1.setBounds(10, 28, 285, 245);
		panelConsultarGrupos.add(comboBox_1);
		
		JPanel panelModificarG = new JPanel();
		panelModificarG.setLayout(null);
		panelModificarG.setBackground(Color.WHITE);
		panelModificarG.setBounds(330, 11, 318, 284);
		panelGrupos.add(panelModificarG);
		
		JLabel lblModificarGrupo = new JLabel("MODIFICAR GRUPO");
		lblModificarGrupo.setForeground(SystemColor.textHighlight);
		lblModificarGrupo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblModificarGrupo.setBounds(22, 11, 128, 18);
		panelModificarG.add(lblModificarGrupo);
		
		JLabel lblResponsable = new JLabel("Responsable");
		lblResponsable.setForeground(SystemColor.textHighlight);
		lblResponsable.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblResponsable.setBounds(22, 23, 128, 18);
		panelModificarG.add(lblResponsable);
		
		JLabel lblIntegrantes = new JLabel("Integrantes");
		lblIntegrantes.setForeground(SystemColor.textHighlight);
		lblIntegrantes.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblIntegrantes.setBounds(22, 71, 128, 18);
		panelModificarG.add(lblIntegrantes);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setCaretColor(SystemColor.activeCaption);
		textField_10.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_10.setBackground(Color.WHITE);
		textField_10.setBounds(22, 40, 286, 20);
		panelModificarG.add(textField_10);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setForeground(Color.WHITE);
		btnEditar_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEditar_1.setBorder(null);
		btnEditar_1.setBackground(SystemColor.textHighlight);
		btnEditar_1.setBounds(120, 236, 89, 23);
		panelModificarG.add(btnEditar_1);
		
		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.setForeground(Color.WHITE);
		btnGuardar_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnGuardar_1.setBorder(null);
		btnGuardar_1.setBackground(SystemColor.textHighlight);
		btnGuardar_1.setBounds(219, 235, 89, 23);
		panelModificarG.add(btnGuardar_1);
		
		JComboBox integrantesgRupo = new JComboBox();
		integrantesgRupo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		integrantesgRupo.setBorder(new LineBorder(SystemColor.textInactiveText, 1, true));
		integrantesgRupo.setBounds(22, 92, 285, 79);
		panelModificarG.add(integrantesgRupo);
		
		JButton btnAgregarH = new JButton("Agregar Huesped");
		btnAgregarH.setForeground(SystemColor.textHighlight);
		btnAgregarH.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnAgregarH.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		btnAgregarH.setBackground(SystemColor.window);
		btnAgregarH.setBounds(22, 180, 137, 23);
		panelModificarG.add(btnAgregarH);
		
		JButton btnEliminarH = new JButton("Eliminar Huesped");
		btnEliminarH.setForeground(new Color(255, 69, 0));
		btnEliminarH.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEliminarH.setBorder(new LineBorder(new Color(255, 69, 0), 1, true));
		btnEliminarH.setBackground(Color.WHITE);
		btnEliminarH.setBounds(169, 182, 137, 23);
		panelModificarG.add(btnEliminarH);
		
		JPanel panelEliminar_1 = new JPanel();
		panelEliminar_1.setLayout(null);
		panelEliminar_1.setBackground(Color.WHITE);
		panelEliminar_1.setBounds(10, 293, 638, 39);
		panelGrupos.add(panelEliminar_1);
		
		JLabel lblElim_1 = new JLabel("Eliminar grupo seleccionado");
		lblElim_1.setForeground(SystemColor.textHighlight);
		lblElim_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblElim_1.setBounds(20, 11, 186, 18);
		panelEliminar_1.add(lblElim_1);
		
		JButton btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setForeground(Color.WHITE);
		btnEliminar_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEliminar_1.setBorder(null);
		btnEliminar_1.setBackground(new Color(255, 69, 0));
		btnEliminar_1.setBounds(440, 6, 188, 23);
		panelEliminar_1.add(btnEliminar_1);
		
		JPanel panelAgregar_1 = new JPanel();
		panelAgregar_1.setLayout(null);
		panelAgregar_1.setBounds(10, 337, 638, 159);
		panelGrupos.add(panelAgregar_1);
		
		JLabel lblNuevoG = new JLabel("NUEVO GRUPO");
		lblNuevoG.setForeground(SystemColor.textHighlight);
		lblNuevoG.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblNuevoG.setBounds(10, 11, 128, 18);
		panelAgregar_1.add(lblNuevoG);
		
		JLabel lblNombreCompleto_1_1 = new JLabel("Responsable");
		lblNombreCompleto_1_1.setForeground(SystemColor.textHighlight);
		lblNombreCompleto_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNombreCompleto_1_1.setBounds(10, 23, 128, 18);
		panelAgregar_1.add(lblNombreCompleto_1_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setCaretColor(SystemColor.activeCaption);
		textField_12.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_12.setBackground(Color.WHITE);
		textField_12.setBounds(10, 47, 286, 20);
		panelAgregar_1.add(textField_12);
		
		JButton btnAgregarUsuario_1 = new JButton("Guardar Grupo");
		btnAgregarUsuario_1.setForeground(Color.WHITE);
		btnAgregarUsuario_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnAgregarUsuario_1.setBorder(null);
		btnAgregarUsuario_1.setBackground(new Color(154, 205, 50));
		btnAgregarUsuario_1.setBounds(10, 112, 286, 23);
		panelAgregar_1.add(btnAgregarUsuario_1);
		
		JLabel lblIntegrantes_1 = new JLabel("Integrantes");
		lblIntegrantes_1.setForeground(SystemColor.textHighlight);
		lblIntegrantes_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblIntegrantes_1.setBounds(317, 23, 128, 18);
		panelAgregar_1.add(lblIntegrantes_1);
		
		JComboBox integrantesgRupo_1 = new JComboBox();
		integrantesgRupo_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		integrantesgRupo_1.setBorder(new LineBorder(SystemColor.textInactiveText, 1, true));
		integrantesgRupo_1.setBounds(317, 44, 285, 91);
		panelAgregar_1.add(integrantesgRupo_1);
		
		JButton btnAgregarH_1 = new JButton("Agregar Huesped");
		btnAgregarH_1.setForeground(SystemColor.textHighlight);
		btnAgregarH_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnAgregarH_1.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		btnAgregarH_1.setBackground(Color.WHITE);
		btnAgregarH_1.setBounds(10, 78, 137, 23);
		panelAgregar_1.add(btnAgregarH_1);
		
		JButton btnEliminarH_1 = new JButton("Eliminar Huesped");
		btnEliminarH_1.setForeground(new Color(255, 69, 0));
		btnEliminarH_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEliminarH_1.setBorder(new LineBorder(new Color(255, 69, 0), 1, true));
		btnEliminarH_1.setBackground(Color.WHITE);
		btnEliminarH_1.setBounds(157, 78, 137, 23);
		panelAgregar_1.add(btnEliminarH_1);
		
		JPanel panelReservas = new JPanel();
		OpcionesRecep.addTab("RESERVAS", null, panelReservas, null);
		panelReservas.setLayout(null);
		
		JPanel panelConsultarGrupos_1 = new JPanel();
		panelConsultarGrupos_1.setLayout(null);
		panelConsultarGrupos_1.setBackground(Color.WHITE);
		panelConsultarGrupos_1.setBounds(10, 11, 320, 284);
		panelReservas.add(panelConsultarGrupos_1);
		
		JLabel lblConsultarReservas = new JLabel("CONSULTAR RESERVAS");
		lblConsultarReservas.setForeground(SystemColor.textHighlight);
		lblConsultarReservas.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblConsultarReservas.setBounds(10, 11, 216, 18);
		panelConsultarGrupos_1.add(lblConsultarReservas);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		comboBox_1_1.setBorder(new LineBorder(SystemColor.textInactiveText, 1, true));
		comboBox_1_1.setBounds(10, 28, 285, 245);
		panelConsultarGrupos_1.add(comboBox_1_1);
		
		JPanel panelModificarG_1 = new JPanel();
		panelModificarG_1.setLayout(null);
		panelModificarG_1.setBackground(Color.WHITE);
		panelModificarG_1.setBounds(330, 11, 318, 284);
		panelReservas.add(panelModificarG_1);
		
		JLabel lblModificarReserva = new JLabel("MODIFICAR RESERVA");
		lblModificarReserva.setForeground(SystemColor.textHighlight);
		lblModificarReserva.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblModificarReserva.setBounds(22, 11, 128, 18);
		panelModificarG_1.add(lblModificarReserva);
		
		JLabel lblResponsable_1 = new JLabel("Responsable");
		lblResponsable_1.setForeground(SystemColor.textHighlight);
		lblResponsable_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblResponsable_1.setBounds(22, 23, 128, 18);
		panelModificarG_1.add(lblResponsable_1);
		
		JLabel lblNumeroDePersonas = new JLabel("#Personas");
		lblNumeroDePersonas.setForeground(SystemColor.textHighlight);
		lblNumeroDePersonas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNumeroDePersonas.setBounds(22, 67, 63, 18);
		panelModificarG_1.add(lblNumeroDePersonas);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setCaretColor(SystemColor.activeCaption);
		textField_8.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(22, 40, 286, 20);
		panelModificarG_1.add(textField_8);
		
		JButton btnEditar_1_1 = new JButton("Editar");
		btnEditar_1_1.setForeground(Color.WHITE);
		btnEditar_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEditar_1_1.setBorder(null);
		btnEditar_1_1.setBackground(SystemColor.textHighlight);
		btnEditar_1_1.setBounds(117, 235, 89, 23);
		panelModificarG_1.add(btnEditar_1_1);
		
		JButton btnGuardar_1_1 = new JButton("Guardar");
		btnGuardar_1_1.setForeground(Color.WHITE);
		btnGuardar_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnGuardar_1_1.setBorder(null);
		btnGuardar_1_1.setBackground(SystemColor.textHighlight);
		btnGuardar_1_1.setBounds(219, 235, 89, 23);
		panelModificarG_1.add(btnGuardar_1_1);
		
		JLabel lblNumeroDeNios = new JLabel("#Niños");
		lblNumeroDeNios.setForeground(SystemColor.textHighlight);
		lblNumeroDeNios.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNumeroDeNios.setBounds(132, 67, 43, 18);
		panelModificarG_1.add(lblNumeroDeNios);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso");
		lblFechaIngreso.setForeground(SystemColor.textHighlight);
		lblFechaIngreso.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblFechaIngreso.setBounds(22, 96, 79, 18);
		panelModificarG_1.add(lblFechaIngreso);
		
		JLabel lblFechaSalida = new JLabel("Fecha Salida");
		lblFechaSalida.setForeground(SystemColor.textHighlight);
		lblFechaSalida.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblFechaSalida.setBounds(129, 96, 89, 18);
		panelModificarG_1.add(lblFechaSalida);
		
		JLabel lblFecha = new JLabel("Habitacion ");
		lblFecha.setForeground(SystemColor.textHighlight);
		lblFecha.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblFecha.setBounds(22, 146, 63, 18);
		panelModificarG_1.add(lblFecha);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setCaretColor(SystemColor.activeCaption);
		textField_11.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_11.setBackground(Color.WHITE);
		textField_11.setBounds(84, 67, 38, 20);
		panelModificarG_1.add(textField_11);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setCaretColor(SystemColor.activeCaption);
		textField_13.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_13.setBackground(Color.WHITE);
		textField_13.setBounds(171, 67, 38, 20);
		panelModificarG_1.add(textField_13);
		
		txtDdmmaaaa = new JTextField();
		txtDdmmaaaa.setText("DD/MM/AAAA");
		txtDdmmaaaa.setColumns(10);
		txtDdmmaaaa.setCaretColor(SystemColor.activeCaption);
		txtDdmmaaaa.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		txtDdmmaaaa.setBackground(Color.WHITE);
		txtDdmmaaaa.setBounds(22, 115, 89, 20);
		panelModificarG_1.add(txtDdmmaaaa);
		
		textField_14 = new JTextField();
		textField_14.setText("DD/MM/AAAA");
		textField_14.setColumns(10);
		textField_14.setCaretColor(SystemColor.activeCaption);
		textField_14.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_14.setBackground(Color.WHITE);
		textField_14.setBounds(132, 115, 89, 20);
		panelModificarG_1.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setCaretColor(SystemColor.activeCaption);
		textField_15.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_15.setBackground(Color.WHITE);
		textField_15.setBounds(22, 162, 63, 20);
		panelModificarG_1.add(textField_15);
		
		JLabel lblDetalleHabitacion = new JLabel("Detalle Habitacion");
		lblDetalleHabitacion.setForeground(SystemColor.textHighlight);
		lblDetalleHabitacion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblDetalleHabitacion.setBounds(95, 142, 156, 18);
		panelModificarG_1.add(lblDetalleHabitacion);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setBounds(95, 162, 213, 20);
		panelModificarG_1.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(SystemColor.textHighlight);
		lblPrecio.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblPrecio.setBounds(146, 193, 63, 18);
		panelModificarG_1.add(lblPrecio);
		
		textField_17 = new JTextField();
		textField_17.setEnabled(false);
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setCaretColor(SystemColor.activeCaption);
		textField_17.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_17.setBackground(Color.WHITE);
		textField_17.setBounds(206, 189, 102, 20);
		panelModificarG_1.add(textField_17);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("CHECK-IN");
		rdbtnNewRadioButton.setBounds(22, 189, 89, 23);
		panelModificarG_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnCheckout = new JRadioButton("CHECK-OUT");
		rdbtnCheckout.setBounds(22, 215, 89, 23);
		panelModificarG_1.add(rdbtnCheckout);
		
		JRadioButton rdbtnLate = new JRadioButton("LATE");
		rdbtnLate.setBounds(22, 236, 79, 23);
		panelModificarG_1.add(rdbtnLate);
		
		JPanel panelEliminar_1_1 = new JPanel();
		panelEliminar_1_1.setLayout(null);
		panelEliminar_1_1.setBackground(Color.WHITE);
		panelEliminar_1_1.setBounds(10, 293, 638, 39);
		panelReservas.add(panelEliminar_1_1);
		
		JLabel lblElim_1_1 = new JLabel("Eliminar resrva seleccionado");
		lblElim_1_1.setForeground(SystemColor.textHighlight);
		lblElim_1_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblElim_1_1.setBounds(20, 11, 186, 18);
		panelEliminar_1_1.add(lblElim_1_1);
		
		JButton btnEliminar_1_1 = new JButton("Eliminar");
		btnEliminar_1_1.setForeground(Color.WHITE);
		btnEliminar_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEliminar_1_1.setBorder(null);
		btnEliminar_1_1.setBackground(new Color(255, 69, 0));
		btnEliminar_1_1.setBounds(440, 6, 188, 23);
		panelEliminar_1_1.add(btnEliminar_1_1);
		
		JPanel panelAgregar_1_1 = new JPanel();
		panelAgregar_1_1.setLayout(null);
		panelAgregar_1_1.setBounds(10, 337, 638, 159);
		panelReservas.add(panelAgregar_1_1);
		
		JLabel lblNuevoG_1 = new JLabel("NUEVO RESERVA");
		lblNuevoG_1.setForeground(SystemColor.textHighlight);
		lblNuevoG_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblNuevoG_1.setBounds(10, 11, 128, 18);
		panelAgregar_1_1.add(lblNuevoG_1);
		
		JLabel lblNombreCompleto_1_1_1 = new JLabel("Responsable");
		lblNombreCompleto_1_1_1.setForeground(SystemColor.textHighlight);
		lblNombreCompleto_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNombreCompleto_1_1_1.setBounds(10, 23, 128, 18);
		panelAgregar_1_1.add(lblNombreCompleto_1_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setCaretColor(SystemColor.activeCaption);
		textField_9.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_9.setBackground(Color.WHITE);
		textField_9.setBounds(10, 47, 286, 20);
		panelAgregar_1_1.add(textField_9);
		
		JButton btnAgregarUsuario_1_1 = new JButton("Guardar Grupo");
		btnAgregarUsuario_1_1.setForeground(Color.WHITE);
		btnAgregarUsuario_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnAgregarUsuario_1_1.setBorder(null);
		btnAgregarUsuario_1_1.setBackground(new Color(154, 205, 50));
		btnAgregarUsuario_1_1.setBounds(491, 125, 137, 23);
		panelAgregar_1_1.add(btnAgregarUsuario_1_1);
		
		JLabel lblNumeroDePersonas_1 = new JLabel("#Personas");
		lblNumeroDePersonas_1.setForeground(SystemColor.textHighlight);
		lblNumeroDePersonas_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNumeroDePersonas_1.setBounds(10, 79, 63, 18);
		panelAgregar_1_1.add(lblNumeroDePersonas_1);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setCaretColor(SystemColor.activeCaption);
		textField_18.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_18.setBackground(Color.WHITE);
		textField_18.setBounds(68, 79, 38, 20);
		panelAgregar_1_1.add(textField_18);
		
		JLabel lblNumeroDeNios_1 = new JLabel("#Niños");
		lblNumeroDeNios_1.setForeground(SystemColor.textHighlight);
		lblNumeroDeNios_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNumeroDeNios_1.setBounds(116, 78, 43, 18);
		panelAgregar_1_1.add(lblNumeroDeNios_1);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setCaretColor(SystemColor.activeCaption);
		textField_19.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_19.setBackground(Color.WHITE);
		textField_19.setBounds(155, 79, 38, 20);
		panelAgregar_1_1.add(textField_19);
		
		JLabel lblFechaIngreso_1 = new JLabel("Fecha Ingreso");
		lblFechaIngreso_1.setForeground(SystemColor.textHighlight);
		lblFechaIngreso_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblFechaIngreso_1.setBounds(10, 108, 79, 18);
		panelAgregar_1_1.add(lblFechaIngreso_1);
		
		textField_20 = new JTextField();
		textField_20.setText("DD/MM/AAAA");
		textField_20.setColumns(10);
		textField_20.setCaretColor(SystemColor.activeCaption);
		textField_20.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_20.setBackground(Color.WHITE);
		textField_20.setBounds(10, 128, 89, 20);
		panelAgregar_1_1.add(textField_20);
		
		JLabel lblFechaSalida_1 = new JLabel("Fecha Salida");
		lblFechaSalida_1.setForeground(SystemColor.textHighlight);
		lblFechaSalida_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblFechaSalida_1.setBounds(109, 108, 89, 18);
		panelAgregar_1_1.add(lblFechaSalida_1);
		
		textField_21 = new JTextField();
		textField_21.setText("DD/MM/AAAA");
		textField_21.setColumns(10);
		textField_21.setCaretColor(SystemColor.activeCaption);
		textField_21.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_21.setBackground(Color.WHITE);
		textField_21.setBounds(109, 128, 89, 20);
		panelAgregar_1_1.add(textField_21);
		
		JLabel lblFecha_1 = new JLabel("Habitacion ");
		lblFecha_1.setForeground(SystemColor.textHighlight);
		lblFecha_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblFecha_1.setBounds(323, 127, 63, 18);
		panelAgregar_1_1.add(lblFecha_1);
		
		JLabel lblHabitacionesDisponibles = new JLabel("Habitaciones Disponibles");
		lblHabitacionesDisponibles.setForeground(SystemColor.textHighlight);
		lblHabitacionesDisponibles.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblHabitacionesDisponibles.setBounds(323, 23, 156, 18);
		panelAgregar_1_1.add(lblHabitacionesDisponibles);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setForeground(SystemColor.textHighlight);
		lblPrecio_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblPrecio_1.setBounds(208, 112, 63, 18);
		panelAgregar_1_1.add(lblPrecio_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(313, 69, 315, 44);
		panelAgregar_1_1.add(comboBox_2);
		
		JButton btnEditar_1_1_1 = new JButton("Buscar Habitaciones");
		btnEditar_1_1_1.setForeground(Color.WHITE);
		btnEditar_1_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEditar_1_1_1.setBorder(null);
		btnEditar_1_1_1.setBackground(SystemColor.textHighlight);
		btnEditar_1_1_1.setBounds(480, 22, 137, 23);
		panelAgregar_1_1.add(btnEditar_1_1_1);
		
		textField_23 = new JTextField();
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		textField_23.setBounds(208, 128, 89, 20);
		panelAgregar_1_1.add(textField_23);
		
		textField_22 = new JTextField();
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBounds(384, 128, 79, 20);
		panelAgregar_1_1.add(textField_22);
		
		JButton btnEditar_1_1_1_1 = new JButton("Crear Grupo");
		btnEditar_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar_1_1_1_1.setForeground(Color.WHITE);
		btnEditar_1_1_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEditar_1_1_1_1.setBorder(null);
		btnEditar_1_1_1_1.setBackground(SystemColor.textHighlight);
		btnEditar_1_1_1_1.setBounds(203, 78, 93, 23);
		panelAgregar_1_1.add(btnEditar_1_1_1_1);
		
		JPanel panelFacturas = new JPanel();
		OpcionesRecep.addTab("FACTURAS", null, panelFacturas, null);
		panelFacturas.setLayout(null);
		
		JPanel panelHuespedes = new JPanel();
		panelHuespedes.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		panelHuespedes.setBackground(SystemColor.text);
		panelHuespedes.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		panelHuespedes.setForeground(SystemColor.textHighlight);
		OpcionesRecep.addTab("HUESPEDES", null, panelHuespedes, null);
		panelHuespedes.setLayout(null);
		
		JPanel panelConsultarHuesped = new JPanel();
		panelConsultarHuesped.setBackground(SystemColor.window);
		panelConsultarHuesped.setBounds(10, 11, 320, 284);
		panelHuespedes.add(panelConsultarHuesped);
		panelConsultarHuesped.setLayout(null);
		
		JLabel namePanel = new JLabel("CONSULTAR HUESPED");
		namePanel.setBounds(10, 11, 128, 18);
		namePanel.setForeground(SystemColor.textHighlight);
		namePanel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		panelConsultarHuesped.add(namePanel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		comboBox.setBorder(new LineBorder(SystemColor.textInactiveText, 1, true));
		comboBox.setBounds(10, 28, 285, 245);
		panelConsultarHuesped.add(comboBox);
		
		JPanel panelModificar = new JPanel();
		panelModificar.setBackground(SystemColor.window);
		panelModificar.setBounds(330, 11, 318, 284);
		panelHuespedes.add(panelModificar);
		panelModificar.setLayout(null);
		
		JLabel panelModificarHuesped = new JLabel("MODIFICAR HUESPED");
		panelModificarHuesped.setBounds(22, 11, 128, 18);
		panelModificarHuesped.setForeground(SystemColor.textHighlight);
		panelModificarHuesped.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		panelModificar.add(panelModificarHuesped);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo");
		lblNombreCompleto.setForeground(SystemColor.textHighlight);
		lblNombreCompleto.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNombreCompleto.setBounds(22, 29, 128, 18);
		panelModificar.add(lblNombreCompleto);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(SystemColor.textHighlight);
		lblCorreo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblCorreo.setBounds(22, 89, 128, 18);
		panelModificar.add(lblCorreo);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(SystemColor.textHighlight);
		lblTelefono.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblTelefono.setBounds(22, 149, 128, 18);
		panelModificar.add(lblTelefono);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(SystemColor.textHighlight);
		lblEdad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblEdad.setBounds(22, 207, 128, 18);
		panelModificar.add(lblEdad);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField.setBackground(SystemColor.window);
		textField.setCaretColor(SystemColor.activeCaption);
		textField.setBounds(22, 58, 286, 20);
		panelModificar.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setCaretColor(SystemColor.activeCaption);
		textField_1.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(22, 118, 286, 20);
		panelModificar.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setCaretColor(SystemColor.activeCaption);
		textField_2.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(22, 178, 286, 20);
		panelModificar.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setCaretColor(SystemColor.activeCaption);
		textField_3.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(22, 236, 61, 20);
		panelModificar.add(textField_3);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBorder(null);
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setForeground(SystemColor.window);
		btnEditar.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEditar.setBounds(120, 236, 89, 23);
		panelModificar.add(btnEditar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(SystemColor.textHighlight);
		btnGuardar.setBounds(219, 235, 89, 23);
		panelModificar.add(btnGuardar);
		
		JPanel panelEliminar = new JPanel();
		panelEliminar.setBackground(SystemColor.window);
		panelEliminar.setBounds(10, 293, 638, 39);
		panelHuespedes.add(panelEliminar);
		panelEliminar.setLayout(null);
		
		JLabel lblElim = new JLabel("Eliminar huesped seleccionado");
		lblElim.setBounds(20, 11, 186, 18);
		lblElim.setForeground(SystemColor.textHighlight);
		lblElim.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		panelEliminar.add(lblElim);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(255, 69, 0));
		btnEliminar.setBounds(440, 6, 188, 23);
		panelEliminar.add(btnEliminar);
		
		JPanel panelAgregar = new JPanel();
		panelAgregar.setBounds(10, 337, 638, 159);
		panelHuespedes.add(panelAgregar);
		panelAgregar.setLayout(null);
		
		JLabel lblNombrePanel = new JLabel("NUEVO HUESPED");
		lblNombrePanel.setBounds(10, 11, 128, 18);
		lblNombrePanel.setForeground(SystemColor.textHighlight);
		lblNombrePanel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		panelAgregar.add(lblNombrePanel);
		
		JLabel lblNombreCompleto_1 = new JLabel("Nombre Completo");
		lblNombreCompleto_1.setForeground(SystemColor.textHighlight);
		lblNombreCompleto_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblNombreCompleto_1.setBounds(10, 36, 128, 18);
		panelAgregar.add(lblNombreCompleto_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setCaretColor(SystemColor.activeCaption);
		textField_4.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(10, 65, 286, 20);
		panelAgregar.add(textField_4);
		
		JLabel lblCorreo_1 = new JLabel("Correo");
		lblCorreo_1.setForeground(SystemColor.textHighlight);
		lblCorreo_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblCorreo_1.setBounds(10, 96, 128, 18);
		panelAgregar.add(lblCorreo_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setCaretColor(SystemColor.activeCaption);
		textField_5.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(10, 125, 286, 20);
		panelAgregar.add(textField_5);
		
		JLabel lblTelefono_1 = new JLabel("Telefono");
		lblTelefono_1.setForeground(SystemColor.textHighlight);
		lblTelefono_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblTelefono_1.setBounds(316, 36, 128, 18);
		panelAgregar.add(lblTelefono_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setCaretColor(SystemColor.activeCaption);
		textField_6.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(316, 65, 286, 20);
		panelAgregar.add(textField_6);
		
		JLabel lblEdad_1 = new JLabel("Edad");
		lblEdad_1.setForeground(SystemColor.textHighlight);
		lblEdad_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblEdad_1.setBounds(316, 94, 128, 18);
		panelAgregar.add(lblEdad_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setCaretColor(SystemColor.activeCaption);
		textField_7.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(316, 123, 61, 20);
		panelAgregar.add(textField_7);
		
		JButton btnAgregarUsuario = new JButton("Guardar Huesped");
		btnAgregarUsuario.setForeground(Color.WHITE);
		btnAgregarUsuario.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		btnAgregarUsuario.setBorder(null);
		btnAgregarUsuario.setBackground(new Color(154, 205, 50));
		btnAgregarUsuario.setBounds(414, 123, 188, 23);
		panelAgregar.add(btnAgregarUsuario);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(SystemColor.textHighlight);
		panelHeader.setBounds(0, 0, 739, 48);
		getContentPane().add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recepcionista");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 11));
		lblNewLabel.setBounds(433, 23, 91, 14);
		panelHeader.add(lblNewLabel);
		
		JLabel lblBienvenidoDeNuevo = new JLabel("Bienvenido de nuevo Usuario");
		lblBienvenidoDeNuevo.setForeground(Color.WHITE);
		lblBienvenidoDeNuevo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		lblBienvenidoDeNuevo.setBounds(546, 19, 169, 14);
		panelHeader.add(lblBienvenidoDeNuevo);
	
		setSize(new Dimension(750,600));
		setIconImage(null);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_12;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField txtDdmmaaaa;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_23;
	private JTextField textField_22;
}

