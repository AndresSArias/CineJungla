package vista;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControladorEvento;
import controlador.Fachada;


public class vistaControlador extends JFrame {
	
	private Fachada fachada;
	private ControladorEvento control;
	private panelInicial panelInicial;
	private panelAdministrador panelAdministrador;
	private panelAdministradorUsuario panelAdministradorUsuario;
	private panelUsuario panelUsuario;
	private panelUsuarioCompra panelUsuarioCompra;
	private panelUsuarioCompraBoleteria panelUsuarioCompraBoleteria;
	private panelUsuarioCompraCofiteria panelUsuarioCompraCofiteria;
	
	
	public vistaControlador (Fachada fachada) {
		
		this.fachada = fachada;
		iniciarComponentes();
		capturarEventos();
		
		
	}
	
	
	public void iniciarComponentes() {
		
		//Inicialización de la ventana principal
		this.setTitle("Punto Ágil Cine Jungla");
		this.setBounds(100, 100, 854, 480);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(vistaControlador.class.getResource("/Imagen/Icono.png")));
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creación del panel inicial
		panelInicial = new panelInicial();
		this.getContentPane().add(panelInicial);
		
		//Creación del panel Administrador
		panelAdministrador = new panelAdministrador ();
		this.getContentPane().add(panelAdministrador);
		
		//Creación del panel AdmistradorUsuario
		panelAdministradorUsuario = new panelAdministradorUsuario();
		this.getContentPane().add(panelAdministradorUsuario);
		
		//Creación del panel Usuario
		panelUsuario = new panelUsuario();
		this.getContentPane().add(panelUsuario);
		
		//Creación del panel Usuario Compra
		panelUsuarioCompra = new panelUsuarioCompra();
		this.getContentPane().add(panelUsuarioCompra);
		
		//Creación del panel Usuario compra boletas
		panelUsuarioCompraBoleteria = new panelUsuarioCompraBoleteria();
		this.getContentPane().add(panelUsuarioCompraBoleteria);
		
		
		//Creaión del panel CompraCofiteria
		panelUsuarioCompraCofiteria = new panelUsuarioCompraCofiteria();
		this.getContentPane().add(panelUsuarioCompraCofiteria);
		
		//Visibilidad de los paneles
		panelInicial.setVisible(true);
		panelAdministrador.setVisible(false);
		panelAdministradorUsuario.setVisible(false);
		panelUsuario.setVisible(false);
		panelUsuarioCompra.setVisible(false);
		panelUsuarioCompraBoleteria.setVisible(false);
		panelUsuarioCompraCofiteria.setVisible(false);

	}
	
	public ControladorEvento getControl() {
		if (control == null) {
			control = new ControladorEvento(this);
			}

		return control;
		
	}
	
	public void capturarEventos() {
		
		//Oyente panelInicial
		panelInicial.getBotonSalir().addActionListener(getControl());
		panelInicial.getBotonIniciarSesion().addActionListener(getControl());
		//Oyentes panelAdminstrador
		panelAdministrador.getBotonCerrarSesion().addActionListener(getControl());
		panelAdministrador.getBotonUsuario().addActionListener(getControl());
		panelAdministrador.getBotonInforme().addActionListener(getControl());
		//Oyentes panelAdministradorUsuario
		panelAdministradorUsuario.getBotonRegresar().addActionListener(getControl());
		panelAdministradorUsuario.getBotonEliminarUsuario().addActionListener(getControl());
		panelAdministradorUsuario.getBotonAgregarUsuario().addActionListener(getControl());
		panelAdministradorUsuario.getTablaUsuario().addMouseListener(getControl());
		//Oyentes panelUsuario
		panelUsuario.getBotonCerrarSesion().addActionListener(getControl());
		panelUsuario.getBotonConsultar().addActionListener(getControl());
		panelUsuario.getBotonAgregarCliente().addActionListener(getControl());
		panelUsuario.getBotonEliminarCliente().addActionListener(getControl());
		panelUsuario.getTablaCliente().addMouseListener(getControl());
		//Oyentes del panel Usuario Compra
		panelUsuarioCompra.getBotonRegresar().addActionListener(getControl());
		panelUsuarioCompra.getBotonBoleteria().addActionListener(getControl());
		panelUsuarioCompra.getBotonCofiteria().addActionListener(getControl());
		//Oyentes del panel Boleteria
		panelUsuarioCompraBoleteria.getBotonConsultar().addActionListener(getControl());
		panelUsuarioCompraBoleteria.getBotonComprar().addActionListener(getControl());
		panelUsuarioCompraBoleteria.getBotonCancelar().addActionListener(getControl());
		//Oyentes del panel Cofiteria
		panelUsuarioCompraCofiteria.getBotonComprarPerro().addActionListener(getControl());
		panelUsuarioCompraCofiteria.getBotonComprarSandwich().addActionListener(getControl());
		panelUsuarioCompraCofiteria.getBotonComprarNachos().addActionListener(getControl());
		panelUsuarioCompraCofiteria.getBotonComprarPalomitas().addActionListener(getControl());
		panelUsuarioCompraCofiteria.getBotonComprarChocolatina().addActionListener(getControl());
		panelUsuarioCompraCofiteria.getBotonComprarGaseosa().addActionListener(getControl());
		panelUsuarioCompraCofiteria.getBotonAtras().addActionListener(getControl());
	}
	
	//Getts de los componentes que se modificarán y usarán
	
	public Fachada getFachada() {	
		return fachada;
	}
	
	public panelInicial getPanelInicial () {
		return panelInicial;
	}
	public panelAdministrador getPanelAdministrador () {
		return panelAdministrador;
	}
	public panelAdministradorUsuario getPanelAdministradorUsuario() {
		return panelAdministradorUsuario;
	}
	
	public panelUsuario getPanelUsuario () {
		return panelUsuario;
	}
	public panelUsuarioCompra getPanelUsuarioCompra() {
		return panelUsuarioCompra;
	}
	public panelUsuarioCompraBoleteria getPanelUsuarioCompraBoleteria() {
		return panelUsuarioCompraBoleteria;
	}
	public panelUsuarioCompraCofiteria getPanelUsuarioCompraCofiteria() {
		return panelUsuarioCompraCofiteria;
	}
}
