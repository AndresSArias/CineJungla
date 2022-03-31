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

public class panelUsuarioCompraBoleteria extends JPanel{
	
	//Elementos no interactivos
	private Image imagen = new ImageIcon(getClass().getResource("/Imagen/FondoUsuarioCompraBoleteria.jpg")).getImage();
	private JLabel etiquetaTitulo;
	private JLabel etiquetaParrafo;
	private JLabel etiquetaSala;
	
	//Elementos interactivos
	private JComboBox cajaSala;
	private JButton botonConsultar;
	private panelSala panelSala;
	private JButton botonComprar;
	private JButton botonCancelar;
	
	public panelUsuarioCompraBoleteria() {
		
		this.setBounds(0, 0, 838, 441);
		this.setLayout(null);
		
		etiquetaTitulo = new JLabel("BOLETERIA");
		etiquetaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaTitulo.setBounds(335, 11, 93, 14);
		this.add(etiquetaTitulo);
		
		etiquetaParrafo = new JLabel("Por favor seleccione la sala y las sillas a comprar al darle en consultar y comprar.");
		etiquetaParrafo.setBounds(10, 31, 774, 14);
		this.add(etiquetaParrafo);
		
		cajaSala = new JComboBox();
		cajaSala.setModel(new DefaultComboBoxModel(new String[] {"Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5"}));
		cajaSala.setBounds(281, 62, 93, 22);
		this.add(cajaSala);
		
		etiquetaSala = new JLabel("Sala:");
		etiquetaSala.setBounds(200, 66, 46, 14);
		this.add(etiquetaSala);
		
		botonConsultar = new JButton("Consultar");
		botonConsultar.setBounds(514, 62, 89, 23);
		this.add(botonConsultar);
		
		panelSala = new panelSala();
		this.add(panelSala);
		
		botonComprar = new JButton("COMPRAR");
		botonComprar.setBounds(452, 395, 100, 23);
		this.add(botonComprar);
		
		botonCancelar = new JButton("CANCELAR");
		botonCancelar.setBounds(217, 395, 100, 23);
		this.add(botonCancelar);
		
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);
		
	}

	public JComboBox getCajaSala() {
		return cajaSala;
	}

	public JButton getBotonConsultar() {
		return botonConsultar;
	}

	public panelSala getPanelSala() {
		return panelSala;
	}

	public JButton getBotonComprar() {
		return botonComprar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

}
