package vista;

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;

public class panelAdministradorUsuario extends JPanel {
	
	//Componentes visuales no interactivos
	private Image imagen = new ImageIcon(getClass().getResource("/Imagen/FondoAdministradorUsuario.jpg")).getImage();
	private JLabel etiquetaTitulo;
	private JLabel etiquetaAlias;
	private JLabel etiquetaNombre;
	private JLabel etiquetaParrafo;
	private JLabel etiquetaApellido;
	private JLabel etiquetaEmail;
	private JLabel etiquetaCelular;
	private JLabel etiquetaMultiplex;
	private JLabel etiquetaFechaNacimiento;
	
	//Componentes visuales interactivos
	private JTextField textoCedula;
	private JTextField textoNombre;
	private JTextField textoCelular;
	private JTextField textoFechaContrato;
	private JComboBox cajaCargo;
	private JComboBox cajaMultiplex;
	private JButton botonEliminarUsuario;
	private JButton botonAgregarUsuario;
	private JButton botonRegresar;
	private JTable tablaUsuario;
	private JScrollPane scrollTablaUsuario;
	

	public panelAdministradorUsuario () {
		
		this.setBounds(0, 0, 838, 441);
		this.setLayout(null);
		
		etiquetaTitulo = new JLabel("USUARIOS DEL SISTEMA");
		etiquetaTitulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		etiquetaTitulo.setBounds(290, 11, 319, 31);
		this.add(etiquetaTitulo);
		
		
		scrollTablaUsuario = new JScrollPane();
		scrollTablaUsuario.setBounds(10, 44, 818, 232);
		this.add(scrollTablaUsuario);
		
		tablaUsuario = new JTable();
		scrollTablaUsuario.setViewportView(tablaUsuario);
		
		etiquetaAlias = new JLabel("C\u00C9DULA");
		etiquetaAlias.setBounds(10, 287, 46, 14);
		this.add(etiquetaAlias);
		
		etiquetaNombre = new JLabel("NOMBRE");
		etiquetaNombre.setBounds(112, 287, 56, 14);
		this.add(etiquetaNombre);
		
		etiquetaApellido = new JLabel("CELULAR");
		etiquetaApellido.setBounds(246, 287, 68, 14);
		this.add(etiquetaApellido);
		
		etiquetaEmail = new JLabel("FECHA DE CONTRATO");
		etiquetaEmail.setBounds(380, 287, 146, 14);
		this.add(etiquetaEmail);
		
		etiquetaCelular = new JLabel("CARGO");
		etiquetaCelular.setBounds(514, 287, 56, 14);
		this.add(etiquetaCelular);
		
		etiquetaMultiplex = new JLabel("MULTIPLEX");
		etiquetaMultiplex.setBounds(631, 287, 89, 14);
		this.add(etiquetaMultiplex);
		
		textoCedula = new JTextField();
		textoCedula.setBounds(10, 324, 92, 20);
		this.add(textoCedula);
		textoCedula.setColumns(10);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(112, 324, 124, 20);
		this.add(textoNombre);
		textoNombre.setColumns(10);
		
		textoCelular = new JTextField();
		textoCelular.setBounds(246, 324, 124, 20);
		this.add(textoCelular);
		textoCelular.setColumns(10);
		
		textoFechaContrato = new JTextField();
		textoFechaContrato.setBounds(380, 324, 124, 20);
		this.add(textoFechaContrato);
		textoFechaContrato.setColumns(10);
		
		
		
		cajaCargo = new JComboBox();
		cajaCargo.setModel(new DefaultComboBoxModel(new String[] {"Director", "Cajero", "Cofiteria", "Encargado", "Aseador"}));
		cajaCargo.setBounds(514, 323, 89, 22);
		this.add(cajaCargo);
		
		cajaMultiplex = new JComboBox();
		cajaMultiplex.setModel(new DefaultComboBoxModel(new String[] {"Titán", "Unicentro", "Plaza Central", "Gran Estación", "Embajador", "Américas"}));
		cajaMultiplex.setBounds(631, 323, 108, 22);
		this.add(cajaMultiplex);
		
		botonEliminarUsuario = new JButton("ELIMINAR");
		botonEliminarUsuario.setBounds(290, 377, 89, 23);
		this.add(botonEliminarUsuario);
		
		botonAgregarUsuario = new JButton("AGREGAR");
		botonAgregarUsuario.setBounds(437, 377, 89, 23);
		this.add(botonAgregarUsuario);
		
		botonRegresar = new JButton("REGRESAR");
		botonRegresar.setBounds(10, 407, 108, 23);
		this.add(botonRegresar);
		
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		setOpaque(false);
		super.paint(g);
	
	}
	
	//Getters de los componentes interativos
	public JTextField getTextoCedula() {
		return textoCedula;
	}

	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public JComboBox getCajaCargo() {
		return cajaCargo;
	}

	public JComboBox getCajaMultiplex() {
		return cajaMultiplex;
	}

	public JTextField getTextoCelular() {
		return textoCelular;
	}

	public JTextField getTextoFechaContrato() {
		return textoFechaContrato;
	}

	public JButton getBotonEliminarUsuario() {
		return botonEliminarUsuario;
	}

	public JButton getBotonAgregarUsuario() {
		return botonAgregarUsuario;
	}

	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	public JTable getTablaUsuario() {
		return tablaUsuario;
	}

	//Setter tabla interactiva
	public void setTablaUsuario(JTable tablaUsuario) {
		this.tablaUsuario = tablaUsuario;
	}
}
