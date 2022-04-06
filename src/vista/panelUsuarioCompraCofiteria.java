package vista;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelUsuarioCompraCofiteria extends JPanel {
	
	//No interactivos
	private Image imagen = new ImageIcon(getClass().getResource("/Imagen/FondoUsuarioCompraCofiteria.jpg")).getImage();
	private JLabel etiquetaTitulo;
	private JLabel etiquetaParrafo;
	private JLabel etiquetaImagenPerro;
	private JLabel etiquetaParrafoPerro;
	private JLabel etiquetaValorPerro;
	
	
	///Interativos
	private JButton botonComprarPerro;
	private JButton botonComprarSandwich;
	private JButton botonComprarNachos;
	private JButton botonComprarPalomitas;
	private JButton botonComprarChocolatina;
	private JButton botonComprarGaseosa;
	private JButton botonAtras;
	
	public panelUsuarioCompraCofiteria () {
		
		this.setBounds(0, 0, 838, 441);
		this.setLayout(null);
		
		etiquetaTitulo = new JLabel("COFITERIA");
		etiquetaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaTitulo.setBounds(335, 11, 93, 14);
		this.add(etiquetaTitulo);
		
		etiquetaParrafo = new JLabel("Por favor seleccione COMPRAR en el producto que desea adquierir el cliente.");
		etiquetaParrafo.setBounds(10, 36, 774, 14);
		this.add(etiquetaParrafo);
		
		etiquetaImagenPerro = new JLabel("");
		etiquetaImagenPerro.setIcon(new ImageIcon(getClass().getResource("/Imagen/perro.jpg")));
		etiquetaImagenPerro.setBounds(23, 107, 86, 57);
		this.add(etiquetaImagenPerro);
		
		etiquetaParrafoPerro = new JLabel("Perro Caliente");
		etiquetaParrafoPerro.setBounds(23, 82, 107, 14);
		this.add(etiquetaParrafoPerro);
		
		etiquetaValorPerro = new JLabel("$12.700");
		etiquetaValorPerro.setBounds(162, 117, 58, 14);
		this.add(etiquetaValorPerro);
		
		botonComprarPerro = new JButton("COMPRAR");
		botonComprarPerro.setBounds(130, 142, 107, 23);
		this.add(botonComprarPerro);
		
		botonComprarSandwich = new JButton("COMPRAR");
		botonComprarSandwich.setBounds(130, 262, 107, 23);
		this.add(botonComprarSandwich);
		
		JLabel label = new JLabel("$11.000");
		label.setBounds(162, 237, 58, 14);
		this.add(label);
		
		JLabel etiquetaImagenSandwich = new JLabel("");
		etiquetaImagenSandwich.setIcon(new ImageIcon(getClass().getResource("/Imagen/sandwich.png")));
		etiquetaImagenSandwich.setBounds(23, 227, 86, 57);
		this.add(etiquetaImagenSandwich);
		
		JLabel etiquetaParrafoSandwich = new JLabel("S\u00E1ndwich");
		etiquetaParrafoSandwich.setBounds(23, 202, 107, 14);
		this.add(etiquetaParrafoSandwich);
		
		botonComprarNachos = new JButton("COMPRAR");
		botonComprarNachos.setBounds(372, 142, 107, 23);
		this.add(botonComprarNachos);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(getClass().getResource("/Imagen/nachos.jpg")));
		label_1.setBounds(265, 107, 86, 57);
		this.add(label_1);
		
		JLabel lblNachos = new JLabel("Nachos");
		lblNachos.setBounds(265, 82, 107, 14);
		this.add(lblNachos);
		
		JLabel label_3 = new JLabel("$10000");
		label_3.setBounds(404, 117, 58, 14);
		this.add(label_3);
		
		JLabel lblPopCorn = new JLabel("Pop Corn");
		lblPopCorn.setBounds(265, 202, 107, 14);
		this.add(lblPopCorn);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(getClass().getResource("/Imagen/popCorn.jpg")));
		label_5.setBounds(265, 227, 86, 57);
		this.add(label_5);
		
		botonComprarPalomitas = new JButton("COMPRAR");
		botonComprarPalomitas.setBounds(372, 262, 107, 23);
		this.add(botonComprarPalomitas);
		
		JLabel label_6 = new JLabel("$14.300");
		label_6.setBounds(404, 237, 58, 14);
		this.add(label_6);
		
		botonComprarChocolatina = new JButton("COMPRAR");
		botonComprarChocolatina.setBounds(630, 142, 107, 23);
		this.add(botonComprarChocolatina);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(getClass().getResource("/Imagen/chocolatina.jpg")));
		label_7.setBounds(523, 107, 86, 57);
		this.add(label_7);
		
		JLabel lblChocolatina = new JLabel("Chocolatina");
		lblChocolatina.setBounds(523, 82, 107, 14);
		this.add(lblChocolatina);
		
		JLabel label_9 = new JLabel("$5.500");
		label_9.setBounds(662, 117, 58, 14);
		this.add(label_9);
		
		JLabel lblGaseosa = new JLabel("Gaseosa");
		lblGaseosa.setBounds(523, 202, 107, 14);
		this.add(lblGaseosa);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(getClass().getResource("/Imagen/gaseosa.jpg")));
		label_11.setBounds(523, 227, 86, 57);
		this.add(label_11);
		
		botonComprarGaseosa = new JButton("COMPRAR");
		botonComprarGaseosa.setBounds(630, 262, 107, 23);
		this.add(botonComprarGaseosa);
		
		JLabel label_12 = new JLabel("$11.100");
		label_12.setBounds(662, 237, 58, 14);
		this.add(label_12);
		
		botonAtras = new JButton("ATRAS");
		botonAtras.setBounds(335, 380, 123, 23);
		this.add(botonAtras);
		
		
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);
		
	}
	
	public JButton getBotonComprarPerro() {
		return botonComprarPerro;
	}

	public JButton getBotonComprarSandwich() {
		return botonComprarSandwich;
	}

	public JButton getBotonComprarNachos() {
		return botonComprarNachos;
	}

	public JButton getBotonComprarPalomitas() {
		return botonComprarPalomitas;
	}

	public JButton getBotonComprarChocolatina() {
		return botonComprarChocolatina;
	}

	public JButton getBotonComprarGaseosa() {
		return botonComprarGaseosa;
	}

	public JButton getBotonAtras() {
		return botonAtras;
	}
	

}
