package vista;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class panelInicial extends JPanel{
	
	//Componenetes visuales no interactivos
	private Image imagen = new ImageIcon(getClass().getResource("/Imagen/FondoInicio.jpg")).getImage();
	private JLabel etiquetaTitulo;
	private JLabel etiquetaParrafo;
	private JLabel etiquetaAlias;
	private JLabel etiquetaContrasena;
	
	//Componentes visuales interactivos
	private JTextField textoCedula;
	private JPasswordField textoCodigo;
	private JButton botonIniciarSesion;
	private JButton botonSalir;
	
	
	public panelInicial () {
		
		this.setBounds(0, 0, 838, 441);
		this.setLayout(null);
		
		etiquetaTitulo = new JLabel("           ¡Bienvenido a Cine Jungla!");
		etiquetaTitulo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		etiquetaTitulo.setBounds(270, 33, 350, 57);
		this.add(etiquetaTitulo);
		
		etiquetaParrafo = new JLabel("Inicie sesión para utilizar el punto ágil.");
		etiquetaParrafo.setBounds(285, 120, 270, 14);
		this.add(etiquetaParrafo);
		
		etiquetaAlias = new JLabel("CÉDULA");
		etiquetaAlias.setBounds(325, 180, 50, 14);
		this.add(etiquetaAlias);
		
		textoCedula = new JTextField();
		textoCedula.setBounds(425, 180, 116, 20);
		this.add(textoCedula);
		textoCedula.setColumns(10);
		
		etiquetaContrasena = new JLabel("CÓDIGO DE EMPLEADO");
		etiquetaContrasena.setBounds(275, 241, 130, 14);
		this.add(etiquetaContrasena);
		
		textoCodigo = new JPasswordField();
		textoCodigo.setBounds(425, 238, 116, 20);
		this.add(textoCodigo);
		
		botonIniciarSesion = new JButton("INICIAR SESIÓN");
		botonIniciarSesion.setBounds(342, 319, 132, 23);
		this.add(botonIniciarSesion);
		
		botonSalir = new JButton("SALIR");
		botonSalir.setBounds(362, 363, 89, 23);
		this.add(botonSalir);
		
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);

	}

	
	//Gettes para el manejo de componentes visuales interactivos
	
	public JTextField getTextoAlias () {
		return textoCedula;
	}
	
	public JPasswordField getTextoContrasena() {
		return textoCodigo;
	}
	
	public JButton getBotonSalir () {
		return botonSalir;
	}
	
	public JButton getBotonIniciarSesion () {
		return botonIniciarSesion;
	}
}
