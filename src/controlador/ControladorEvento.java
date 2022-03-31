package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.vistaControlador;



public class ControladorEvento implements ActionListener, MouseListener{
	
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
	        	 interfaz.getFachada().iniciarSesion(interfaz.getPanelInicial(),interfaz.getPanelAdministrador(),interfaz.getPanelUsuario());
	        }
	        if(ae.getSource()==(interfaz.getPanelAdministrador().getBotonCerrarSesion())) {
	        	 interfaz.getFachada().cerrarSesion(interfaz.getPanelInicial(),interfaz.getPanelAdministrador());
	        }
	        if(ae.getSource()==(interfaz.getPanelAdministrador().getBotonInforme())) {
	        	interfaz.getFachada().administrarInforme();
	        }
	        if(ae.getSource()==(interfaz.getPanelAdministrador().getBotonUsuario())) {
	        	interfaz.getFachada().administrarUsuario(interfaz.getPanelAdministrador(), interfaz.getPanelAdministradorUsuario());
	        }
	        if(ae.getSource()==(interfaz.getPanelAdministradorUsuario().getBotonRegresar())) {
	        	interfaz.getFachada().cambiarPanel(interfaz.getPanelAdministradorUsuario(), interfaz.getPanelAdministrador());
	        }
	        if(ae.getSource()==(interfaz.getPanelAdministradorUsuario().getBotonAgregarUsuario())) {
	        	interfaz.getFachada().agregarUsuario();
	        }
	        if(ae.getSource()==(interfaz.getPanelAdministradorUsuario().getBotonEliminarUsuario())) {
	        	interfaz.getFachada().eliminarUsuario();
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuario().getBotonCerrarSesion())) {
	        	interfaz.getFachada().cerrarSesion(interfaz.getPanelInicial(), interfaz.getPanelUsuario());
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuario().getBotonConsultar())) {
	        	interfaz.getFachada().comenzarCompra(interfaz.getPanelUsuario(), interfaz.getPanelUsuarioCompra());
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompra().getBotonRegresar())) {
	        	interfaz.getFachada().regresar(interfaz.getPanelUsuario(), interfaz.getPanelUsuarioCompra());
	        }
	        if (ae.getSource() == (interfaz.getPanelUsuarioCompra().getBotonBoleteria())) {
	        	interfaz.getFachada().entrarBoleteria(interfaz.getPanelUsuarioCompra(), interfaz.getPanelUsuarioCompraBoleteria());
	        }
	        if (ae.getSource() == (interfaz.getPanelUsuarioCompraBoleteria().getBotonCancelar())) {
	        	interfaz.getFachada().cancelarCompraBoleteria(interfaz.getPanelUsuarioCompra(), interfaz.getPanelUsuarioCompraBoleteria());
	        }
	       
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	
		
}
