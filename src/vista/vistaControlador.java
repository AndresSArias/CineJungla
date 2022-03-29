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

	
	
	public vistaControlador (Fachada fachada) {
		
		this.fachada = fachada;
		iniciarComponentes();
		capturarEventos();
		
		
	}
	
	
	public void iniciarComponentes() {
		
		//Inicialización de la ventana principal
		this.setTitle("Sofi&Migue Entertainment");
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
		
		//Visibilidad de los paneles
		panelInicial.setVisible(true);
		panelAdministrador.setVisible(false);

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
	
}
