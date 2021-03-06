package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JTable;

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
	        	interfaz.getFachada().agregarUsuario(interfaz.getPanelAdministradorUsuario());
	        }
	        if(ae.getSource()==(interfaz.getPanelAdministradorUsuario().getBotonEliminarUsuario())) {
	        	interfaz.getFachada().eliminarUsuario(interfaz.getPanelAdministradorUsuario());
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuario().getBotonCerrarSesion())) {
	        	interfaz.getFachada().cerrarSesion(interfaz.getPanelInicial(), interfaz.getPanelUsuario());
	        }
	        if(ae.getSource()==(interfaz.getPanelUsuario().getBotonAgregarCliente())) {
	        	interfaz.getFachada().agregarCliente(interfaz.getPanelUsuario());
	        }
	        if(ae.getSource()==(interfaz.getPanelUsuario().getBotonEliminarCliente())) {
	        	interfaz.getFachada().eliminarCliente(interfaz.getPanelUsuario());
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
	        if (ae.getSource() == (interfaz.getPanelUsuarioCompra().getBotonCofiteria())) {
	        	interfaz.getFachada().entrarCofiteria(interfaz.getPanelUsuarioCompra(), interfaz.getPanelUsuarioCompraCofiteria());
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraCofiteria().getBotonAtras())) {
	        	interfaz.getFachada().regresar(interfaz.getPanelUsuarioCompra(), interfaz.getPanelUsuarioCompraCofiteria());
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraBoleteria().getBotonConsultar())) {
	        	
	        	interfaz.getFachada().consultarSala(interfaz.getPanelUsuarioCompraBoleteria());
				
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraBoleteria().getBotonComprar())) {
	        	
	        	interfaz.getFachada().comprarBoleteria(interfaz.getPanelUsuarioCompraBoleteria());
				
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraCofiteria().getBotonComprarPerro())) {
	        	interfaz.getFachada().comprarSnack(1);
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraCofiteria().getBotonComprarSandwich())) {
	        	interfaz.getFachada().comprarSnack(2);
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraCofiteria().getBotonComprarNachos())) {
	        	interfaz.getFachada().comprarSnack(3);
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraCofiteria().getBotonComprarPalomitas())) {
	        	interfaz.getFachada().comprarSnack(4);
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraCofiteria().getBotonComprarChocolatina())) {
	        	interfaz.getFachada().comprarSnack(5);
	        }
	        if(ae.getSource() == (interfaz.getPanelUsuarioCompraCofiteria().getBotonComprarGaseosa())) {
	        	interfaz.getFachada().comprarSnack(6);
	        }
		}

		@Override
		public void mouseClicked(MouseEvent me) {
			
			if (me.getClickCount() == 1) {
				if (me.getSource() == (interfaz.getPanelAdministradorUsuario().getTablaUsuario())) {
					
					JTable apuntar = (JTable)me.getSource();
					interfaz.getFachada().interactuarTablaUsuario(interfaz.getPanelAdministradorUsuario(),apuntar.getSelectedRow(),apuntar.getSelectedColumn());
					
				}
				if (me.getSource() == (interfaz.getPanelUsuario().getTablaCliente())) {
					JTable apuntar = (JTable)me.getSource();
					interfaz.getFachada().interactuarTablaCliente(interfaz.getPanelUsuario(),apuntar.getSelectedRow(),apuntar.getSelectedColumn());
				}
			}
			
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
