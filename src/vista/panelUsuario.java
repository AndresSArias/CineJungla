package vista;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class panelUsuario extends JPanel {
	
	//Componentes visuales no interactivos
	private JLabel etiquetaParrafo;
	private Image imagen = new ImageIcon(getClass().getResource("/Imagen/FondoUsuario.jpg")).getImage();
	private JLabel etiquetaCedula;
	private JLabel etiquetaNombre;
	
	//Componentes visuales interactivos
	private JLabel etiquetaBienvenida;
	private JButton botonEliminarCliente;
	private JButton botonAgregarCliente;
	private JButton botonCerrarSesion;
	private JComboBox cajaMultiplex;
	private JTextField textoCedula;
	private JTextField textoNombre;
	private JTable tablaCliente;
	private JScrollPane scrollTablaCliente;
	private JButton botonConsultar;
	
	public panelUsuario () {
			
		this.setBounds(0, 0, 838, 441);
		this.setLayout(null);
			
		etiquetaBienvenida = new JLabel("\u00A1Bienvenido CARGO USUARIO!");
		etiquetaBienvenida.setFont(new Font("Arial Black", Font.BOLD, 16));
		etiquetaBienvenida.setBounds(314, 11, 350, 31);
		this.add(etiquetaBienvenida);
		
		scrollTablaCliente = new JScrollPane();
		scrollTablaCliente.setBounds(37, 113, 452, 232);
		this.add(scrollTablaCliente);
		
		tablaCliente = new JTable();
		scrollTablaCliente.setViewportView(tablaCliente);
		
		JLabel etiquetaParrafo = new JLabel("Por favor seleccione al cliente para seguir con el proceso en el punto \u00E1gil o cree un cliente nuevo para usar el punto \u00E1gil.");
		etiquetaParrafo.setBounds(37, 72, 727, 14);
		this.add(etiquetaParrafo);
		
		
		botonCerrarSesion = new JButton("CERRAR SESION");
		botonCerrarSesion.setBounds(605, 375, 128, 23);
		this.add(botonCerrarSesion);
		
		botonConsultar = new JButton("CONSULTAR");
		botonConsultar.setBounds(595, 261, 138, 51);
		this.add(botonConsultar);
		
		JLabel etiquetaMultiplex = new JLabel("MULTIPLEX:");
		etiquetaMultiplex.setBounds(519, 188, 89, 14);
		this.add(etiquetaMultiplex);
		
		cajaMultiplex = new JComboBox();
		cajaMultiplex.setModel(new DefaultComboBoxModel(new String[] {"Tit\u00E1n", "Unicentro", "Plaza Central", "Gran Estaci\u00F3n", "Embajador", "Am\u00E9ricas"}));
		cajaMultiplex.setBounds(625, 184, 108, 22);
		this.add(cajaMultiplex);
		
		
		etiquetaCedula = new JLabel("C\u00C9DULA");
		etiquetaCedula.setBounds(37, 379, 46, 14);
		this.add(etiquetaCedula);
		
		etiquetaNombre = new JLabel("NOMBRE");
		etiquetaNombre.setBounds(269, 377, 56, 14);
		this.add(etiquetaNombre);
		
		textoCedula = new JTextField();
		textoCedula.setBounds(114, 374, 92, 20);
		this.add(textoCedula);
		textoCedula.setColumns(10);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(328, 374, 124, 20);
		this.add(textoNombre);
		textoNombre.setColumns(10);
		
		botonEliminarCliente = new JButton("ELIMINAR");
		botonEliminarCliente.setBounds(136, 411, 89, 23);
		this.add(botonEliminarCliente);
		
		
		
		botonAgregarCliente = new JButton("AGREGAR");
		botonAgregarCliente.setBounds(279, 411, 89, 23);
		this.add(botonAgregarCliente);
		
	}
		
	public void paint(Graphics g) {
			
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);
		
	}
		
	public JLabel getEtiquetaBienvenida () {
		return etiquetaBienvenida;
	}
	public JButton getBotonEliminarCliente() {
		return botonEliminarCliente;
	}
	public JButton getBotonAgregarCliente() {
		return botonAgregarCliente;
	}
	public JButton getBotonCerrarSesion () {
		return botonCerrarSesion;
	}
	
	public JComboBox getCajaMultiplex() {
		return cajaMultiplex;
	}
	
	public JTextField getTextoCedula() {
		return textoCedula;
	}

	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public JTable getTablaCliente() {
		return tablaCliente;
	}
	public JButton getBotonConsultar() {
		return botonConsultar;
	}

	//Setter tabla interactiva
	public void setTablaUsuario(JTable tablaCliente) {
		this.tablaCliente = tablaCliente;
	}

}
