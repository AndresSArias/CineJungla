package controlador;

import javax.swing.JOptionPane;

import modelo.Usuario;
import vista.panelInicial;
import vista.vistaControlador;

public class Fachada {

	//Atributos de fachada
	private vistaControlador interfaz;
	private Usuario usuario = null;
	
	
	
	public Fachada (){
		
		interfaz = new vistaControlador(this);
		
	}
	
	public void iniciar() {
		
		interfaz.setVisible(true);
		
	}
	
	//M�todos l�gicos
	public void salir() {
		System.exit(0);
	}
	
	public void iniciarSesion () {
		
		JOptionPane.showMessageDialog(null,"�En construcci�n!","Vuelva pronto...",JOptionPane.ERROR_MESSAGE);
	}
	
	
	
}