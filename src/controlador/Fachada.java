package controlador;

import javax.swing.JOptionPane;

import modelo.Usuario;
import vista.panelAdministrador;
import vista.panelAdministradorUsuario;
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
	
	//Métodos lógicos
	public void salir() {
		System.exit(0);
	}
	
	public void iniciarSesion (panelInicial a, panelAdministrador b) {
		
		// VALIDACION DE LOS DATOS SI COINCIDEN O NO
		int bandera = 0;
		// SI LOS DATOS SON NULOS
		if (a.getTextoCedula().getText().length() == 0 || a.getTextoCodigo().getText().length() == 0) {

			JOptionPane.showMessageDialog(null, "Usuario o Contraseña erronea, vuelva a intentar.");
			a.getTextoCedula().setText(null);
			a.getTextoCodigo().setText(null);
			bandera++;
		}
		
		// SI LA ENTRADA DE TEXTO ES CORRECTA
		if (bandera == 0) {
					
		// SI PONE ADMIN DE USUARIO Y CONTRASEÑA ENTRA AL PANEL DE ADMIN
		if (a.getTextoCedula().getText().equals("admin") && a.getTextoCodigo().getText().equals("admin")) {
						
			JOptionPane.showMessageDialog(null, "Entrando a la cuenta del administrador");
						
			a.setVisible(false);
			b.setVisible(true);
			
			} else {

				JOptionPane.showMessageDialog(null,"¡En construcción!","Vuelva pronto...",JOptionPane.ERROR_MESSAGE);
				a.getTextoCedula().setText(null);
				a.getTextoCodigo().setText(null);
			}
		
		}
	}
	
	public void cerrarSesion (panelInicial a, panelAdministrador b) {
		
		a.setVisible(true);
		b.setVisible(false);
		a.getTextoCedula().setText(null);
		a.getTextoCodigo().setText(null);
		
	}
	
	public void administrarUsuario (panelAdministrador a, panelAdministradorUsuario b) {
		
		a.setVisible(false);
		b.setVisible(true);
		
	}
	
	public void cambiarPanel (panelAdministradorUsuario a, panelAdministrador b) {
		
		a.setVisible(false);
		b.setVisible(true);
		
	}
	
	public void agregarUsuario() {
		
		JOptionPane.showMessageDialog(null,"¡En construcción!","Vuelva pronto...",JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void eliminarUsuario() {
		
		JOptionPane.showMessageDialog(null,"¡En construcción!","Vuelva pronto...",JOptionPane.ERROR_MESSAGE);
		
	}

	public void administrarInforme() {
		
		JOptionPane.showMessageDialog(null,"¡En construcción!","Vuelva pronto...",JOptionPane.ERROR_MESSAGE);
		
	}
	
}