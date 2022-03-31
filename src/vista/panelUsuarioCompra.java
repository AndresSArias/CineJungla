package vista;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelUsuarioCompra extends JPanel {

	//Compononentes no interactivos
	private Image imagen = new ImageIcon(getClass().getResource("/Imagen/FondoUsuarioCompra.jpg")).getImage();
	
	//Componenetes interactivos
	private JLabel etiquetaTitulo;
	private JLabel etiquetaParrafo;
	private JButton botonBoleteria;
	private JButton botonCofiteria;
	private JButton botonCalificacion;
	private JButton botonRegresar;
	
	public panelUsuarioCompra() {
		
		this.setBounds(0, 0, 838, 441);
		this.setLayout(null);
		
		etiquetaTitulo = new JLabel("\u00A1BIENVENIDO AL MUTIPLEX DE multiplex!");
		etiquetaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaTitulo.setBounds(208, 11, 397, 22);
		this.add(etiquetaTitulo);
		
		etiquetaParrafo = new JLabel("Por favor seleccione la secci\u00F3n que desea el/la cliente/a NOMBRE a comprar, boleteria y/o cofeteria. \u00A1No olvides calificarnos!");
		etiquetaParrafo.setBounds(10, 66, 774, 14);
		this.add(etiquetaParrafo);
		
		botonBoleteria = new JButton("BOLETERIA");
		botonBoleteria.setBounds(143, 161, 138, 79);
		this.add(botonBoleteria);
		
		botonCofiteria = new JButton("COFITERIA");
		botonCofiteria.setBounds(481, 161, 138, 79);
		this.add(botonCofiteria);
		
		botonCalificacion = new JButton("\u00A1CALIF\u00CDCANOS!");
		botonCalificacion.setBounds(279, 277, 201, 79);
		this.add(botonCalificacion);
		
		botonRegresar = new JButton("REGRESAR");
		botonRegresar.setBounds(27, 403, 111, 23);
		this.add(botonRegresar);
		
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);
		
	}
	
	public JLabel getEtiquetaTitulo () {
		return etiquetaTitulo;
	}
	public JLabel getEtiquetaParrafo() {
		return etiquetaParrafo;
	}
	public JButton getBotonBoleteria() {
		return botonBoleteria;
	}
	public JButton getBotonCofiteria() {
		return botonCofiteria;
	}
	public JButton getBotonRegresar() {
		return botonRegresar;
	}
}
