package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.vistaControlador;



public class ControladorEvento implements ActionListener{
	
	//Atribustos
	private vistaControlador interfaz;
		
		public ControladorEvento (vistaControlador interfaz) {
			
			this.interfaz = interfaz;
			
		}

		public void actionPerformed(ActionEvent ae) {
			
			//PARA EL BOTON SALIR DEL PANEL INICIAL
	        if(ae.getSource()==(interfaz.getPanelInicial().getBotonSalir())) {
	        	 interfaz.getFachada().salir();
	        }
	        if(ae.getSource()==(interfaz.getPanelInicial().getBotonIniciarSesion())) {
	        	 interfaz.getFachada().iniciarSesion();
	        }
	       
		}

	
		
}
