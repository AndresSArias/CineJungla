package vista;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelAdministrador extends JPanel {
	
	//Componentes visuales no interactivos
	private Image imagen = new ImageIcon(getClass().getResource("/Imagen/FondoAdministrador.jpg")).getImage();
	private JLabel etiquetaBienvenida;
	private JLabel etiquetaParrafo;
	
	//Componentes visuales interactivos
	private JButton botonInforme;
	private JButton botonUsuario;
	private JButton botonCerrarSesion;

	public panelAdministrador () {
		
		this.setBounds(0, 0, 838, 441);
		this.setLayout(null);
		
		JLabel etiquetaBienvenida = new JLabel("\u00A1Bienvenido ADMINISTRADOR!");
		etiquetaBienvenida.setFont(new Font("Arial Black", Font.BOLD, 16));
		etiquetaBienvenida.setBounds(263, 11, 319, 31);
		this.add(etiquetaBienvenida);
		
		JLabel etiquetaParrafo = new JLabel("Por favor seleccione la secci\u00F3n a consultar, podr\u00E1 agregar empleados/usuarios nuevos al sistema y generar informes de los multiplex.");
		etiquetaParrafo.setBounds(10, 72, 818, 14);
		this.add(etiquetaParrafo);
		
		botonInforme = new JButton("INFORME");
		botonInforme.setBounds(476, 191, 142, 133);
		this.add(botonInforme);
		
		botonUsuario = new JButton("USUARIOS");
		botonUsuario.setBounds(174, 191, 142, 133);
		this.add(botonUsuario);
		
		botonCerrarSesion = new JButton("CERRAR SESI\u00D3N");
		botonCerrarSesion.setBounds(332, 398, 142, 23);
		this.add(botonCerrarSesion);
		
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);
	
	}
	
	
	//Getters componentes interactivos
	public JButton getBotonInforme () {
		return botonInforme;
	}
	public JButton getBotonCerrarSesion () {
		return botonCerrarSesion;
	}
	public JButton getBotonUsuario () {
		return botonUsuario;
	}

}
