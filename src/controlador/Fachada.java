package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import accesoDao.ClienteDao;
import accesoDao.MultiplexDao;
import accesoDao.SalasDao;
import accesoDao.UsuarioDao;
import modelo.Cliente;
import modelo.Multiplex;
import modelo.Salas;
import modelo.Usuario;
import utilidad.conexionBD;
import vista.panelAdministrador;
import vista.panelAdministradorUsuario;
import vista.panelInicial;
import vista.panelUsuario;
import vista.panelUsuarioCompra;
import vista.panelUsuarioCompraBoleteria;
import vista.panelUsuarioCompraCofiteria;
import vista.vistaControlador;

public class Fachada {

	//Atributos de fachada
	private vistaControlador interfaz;
	private Usuario usuario = null;
	private ArrayList<Usuario> usuarios = null;
	private Cliente cliente = null;
	private ArrayList<Cliente> clientes = null;
	private Multiplex multiplex = null;
	
	private Salas sala = null;
	private JCheckBox[] sillasG = null;
	private JCheckBox[] sillasP = null;
	
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
	
	public void iniciarSesion (panelInicial a, panelAdministrador b, panelUsuario c) {
		
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
				
				UsuarioDao usuarioDao = new UsuarioDao();
		        
				if (usuarioDao.validarUsuario(a.getTextoCedula().getText()) && usuarioDao.validarCodigo(a.getTextoCodigo().getText()) ) {
					
				JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitosamente!");
					
				usuario = usuarioDao.getUsuario(a.getTextoCedula().getText());
					
				a.setVisible(false);
				c.setVisible(true);
				c.getEtiquetaBienvenida().setText(("¡Bienvenido "+usuario.getCargo()+" "+usuario.getNombre()+"!"));
				establecerTabla(c);
				actualizarPanelUsuario(c,0);

					
				}else {
					
				// SI NO SE ENCUENTRA REGISTRO
				JOptionPane.showMessageDialog(null, "Cédula incorrecto o código invalido!");
				a.getTextoCedula().setText(null);
				a.getTextoCodigo().setText(null);
					
				}

			}
		
		}
	}
	
	public void establecerTabla (panelUsuario panel) {
		
		ClienteDao clienteDao = new ClienteDao();
		clientes = clienteDao.getClientes();
		int contador = 0;
        
		
		String[] nombreColumna = {"NOMBRE", "CÉDULA", "PUNTOS"};
		
        panel.getTablaCliente().removeAll();
        DefaultTableModel modeloTabla = new DefaultTableModel() {
        	public boolean isCellEditable (int filas, int columnas) {
        		if (columnas == 3) {
        			return true;
        		}else {
        			return false;
        		}
        	}
        };
       
        modeloTabla.setColumnIdentifiers(nombreColumna); 
        panel.getTablaCliente().setModel(modeloTabla);
        
        
        for(int i=0; i<clientes.size(); i++){
        	
            modeloTabla.addRow(clientes.get(i).toArray());
            contador++;
		
	}
        
        panel.getTablaCliente().getColumnModel().getColumn(0).setPreferredWidth(100);
        panel.getTablaCliente().getColumnModel().getColumn(1).setPreferredWidth(100);
        panel.getTablaCliente().getColumnModel().getColumn(2).setPreferredWidth(100);
        panel.getTablaCliente().getColumnModel().getColumn(0).setResizable(false);
        panel.getTablaCliente().getColumnModel().getColumn(1).setResizable(false);
        panel.getTablaCliente().getColumnModel().getColumn(2).setResizable(false);
     
        panel.getTablaCliente().getTableHeader().setReorderingAllowed(false) ;
        
        
	}
	
	public void interactuarTablaCliente (panelUsuario panel,int fila, int columna) {
		
		ClienteDao clienteDao = new ClienteDao();
		String cedula = (String) panel.getTablaCliente().getValueAt(fila, 1);
		cliente = clienteDao.getCliente(cedula);
		actualizarPanelUsuario(panel,1);
		
	}
	
	public void actualizarPanelUsuario (panelUsuario panel, int caso) {
		
		if (caso == 0) {
			
			panel.getTextoCedula().setText(null);
			panel.getTextoNombre().setText(null);
			panel.getCajaMultiplex().setSelectedIndex(0);
			
		}
		
		if (caso == 1) {
			
			panel.getTextoCedula().setText(cliente.getCedula());
			panel.getTextoNombre().setText(cliente.getNombre());
			
			
		}
		
	}
	
	public void agregarCliente(panelUsuario panel) {
		
		// VALIDACION DE LOS DATOS SI COINCIDEN O NO
		int bandera = 0;
		// SI LOS DATOS SON NULOS
		if (panel.getTextoCedula().getText().length() == 0  || panel.getTextoNombre().getText().length() == 0 ) {
			
			JOptionPane.showMessageDialog(null, "Los datos están incompletos, vuelva a intentar.");		
			actualizarPanelUsuario(panel,0);
			bandera++;
			
		}
				
		// SI LA ENTRADA DE TEXTO ES VALIDA
		if (bandera == 0) {
						
			ClienteDao clienteDao = new ClienteDao();
			Cliente auxCliente = new Cliente (panel.getTextoNombre().getText(), panel.getTextoCedula().getText(),"0", "0","0");

			if (clienteDao.validarCedula(panel.getTextoCedula().getText())) {
						
				JOptionPane.showMessageDialog(null, "El Cliente con esa Cédula ya está registrado, vuelva a intentar.");
				actualizarPanelUsuario(panel,0);
					
			}else{
				
				clienteDao.agregarCliente(auxCliente);
				establecerTabla(panel);
				actualizarPanelUsuario(panel,0);
								
								
			}
						
		}
		
	}
	
	public void eliminarCliente(panelUsuario panel) {
		
		// VALIDACION DE LOS DATOS SI COINCIDEN O NO
		int bandera = 0;
		// SI LOS DATOS SON NULOS
		if (panel.getTextoCedula().getText().length() == 0  || panel.getTextoNombre().getText().length() == 0 ) {
			
			JOptionPane.showMessageDialog(null, "Los datos están incompletos, vuelva a intentar.");		
			actualizarPanelUsuario(panel,0);
			bandera++;
			
		}
				
		// SI LA ENTRADA DE TEXTO ES VALIDA
		if (bandera == 0) {
		
			ClienteDao clienteDao = new ClienteDao();
			Cliente auxCliente = new Cliente (panel.getTextoNombre().getText(), panel.getTextoCedula().getText(),"0", "0","0");
			
			if (clienteDao.validarCedula(panel.getTextoCedula().getText())) {
				
				
				clienteDao.eliminarCliente(auxCliente.getCedula());
				establecerTabla(panel);
				actualizarPanelUsuario(panel,0);
					
			}else{
				
				JOptionPane.showMessageDialog(null, "El cliente que quiere eliminar no existe, vuelva a intentar.");
				actualizarPanelUsuario(panel,0);
								
								
			}
				
		}
		
	}
	
	public void cerrarSesion (panelInicial a, panelAdministrador b) {
		
		a.setVisible(true);
		b.setVisible(false);
		a.getTextoCedula().setText(null);
		a.getTextoCodigo().setText(null);
		
	}
	public void cerrarSesion (panelInicial a, panelUsuario b) {
		
		a.setVisible(true);
		b.setVisible(false);
		a.getTextoCedula().setText(null);
		a.getTextoCodigo().setText(null);
		
	}
	
	public void administrarUsuario (panelAdministrador a, panelAdministradorUsuario b) {
		
		a.setVisible(false);
		b.setVisible(true);
		establecerTabla(b);
		actualizarPanelAdministradorUsuario(b,0);
	}
	
	public void establecerTabla (panelAdministradorUsuario panel) {
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarios = usuarioDao.getUsuarios();
		int contador = 0;
        
		
		String[] nombreColumna = {"CÉDULA", "CÓDIGO", "NOMBRE", "CELULAR", "CONTRATO", "CARGO", "SALARIO","MULTIPLEX"};
		
        panel.getTablaUsuario().removeAll();
        DefaultTableModel modeloTabla = new DefaultTableModel() {
        	public boolean isCellEditable (int filas, int columnas) {
        		if (columnas == 8) {
        			return true;
        		}else {
        			return false;
        		}
        	}
        };
       
        modeloTabla.setColumnIdentifiers(nombreColumna); 
        panel.getTablaUsuario().setModel(modeloTabla);
        
        
        for(int i=0; i<usuarios.size(); i++){
        	
            modeloTabla.addRow(usuarios.get(i).toArray());
            contador++;
		
	}
        
        panel.getTablaUsuario().getColumnModel().getColumn(0).setPreferredWidth(55);
        panel.getTablaUsuario().getColumnModel().getColumn(1).setPreferredWidth(55);
        panel.getTablaUsuario().getColumnModel().getColumn(2).setPreferredWidth(100);
        panel.getTablaUsuario().getColumnModel().getColumn(3).setPreferredWidth(55);
        panel.getTablaUsuario().getColumnModel().getColumn(4).setPreferredWidth(55);
        panel.getTablaUsuario().getColumnModel().getColumn(5).setPreferredWidth(55);
        panel.getTablaUsuario().getColumnModel().getColumn(6).setPreferredWidth(100);
        panel.getTablaUsuario().getColumnModel().getColumn(7).setPreferredWidth(55);
        panel.getTablaUsuario().getColumnModel().getColumn(0).setResizable(false);
        panel.getTablaUsuario().getColumnModel().getColumn(1).setResizable(false);
        panel.getTablaUsuario().getColumnModel().getColumn(2).setResizable(false);
        panel.getTablaUsuario().getColumnModel().getColumn(3).setResizable(false);
        panel.getTablaUsuario().getColumnModel().getColumn(4).setResizable(false);
        panel.getTablaUsuario().getColumnModel().getColumn(5).setResizable(false);
        panel.getTablaUsuario().getColumnModel().getColumn(6).setResizable(false);
        panel.getTablaUsuario().getColumnModel().getColumn(7).setResizable(false);
        panel.getTablaUsuario().getTableHeader().setReorderingAllowed(false) ;
        
        
	}
	
	public void actualizarPanelAdministradorUsuario (panelAdministradorUsuario panel, int caso) {
		
		if (caso == 0) {
			
			panel.getTextoCedula().setText(null);
			panel.getTextoNombre().setText(null);
			panel.getTextoCelular().setText(null);
			panel.getTextoFechaContrato().setText(null);
			panel.getCajaCargo().setSelectedIndex(0);
			panel.getCajaMultiplex().setSelectedIndex(0);
			
		}
		
		if (caso == 1) {
			
			panel.getTextoCedula().setText(usuario.getCedula());
			panel.getTextoNombre().setText(usuario.getNombre());
			panel.getTextoCelular().setText(usuario.getCelular());
			panel.getTextoFechaContrato().setText(usuario.getFechaContrato());
			panel.getCajaCargo().setSelectedIndex(indexCargo());
			panel.getCajaMultiplex().setSelectedIndex(indexMultiplex());
		}
		
		
	}
	
	public int indexCargo() {
		
		int index = 0;
		
		switch (usuario.getCargo()){

	        case "Director":{
	
	        	index = 0;
	
	            break;
	
	        }
	
	        case "Cajero":{
	
	        	index = 1;
	
	            break;
	
	        }
	
	        case "Cofiteria":{
	
	        	index = 2;
	
	            break;
	
	        }
	        case "Encargado":{
	
	        	index = 3;
	
	            break;
	
	        }
	        case "Aseador":{
	
	        	index = 4;
	
	            break;
	
	        }
	
	        default: {
	
	            System.out.println("Error en el index del cargo");
	
	        }
	
	  }
		
		return index;
	}
	
	public int indexMultiplex() {
		
		int index = 0;
		
		switch (usuario.getMultiplex()){

	        case "Titán":{
	
	        	index = 0;
	
	            break;
	
	        }
	
	        case "Unicentro":{
	
	        	index = 1;
	
	            break;
	
	        }
	
	        case "Plaza Central":{
	
	        	index = 2;
	
	            break;
	
	        }
	        case "Gran Estación":{
	
	        	index = 3;
	
	            break;
	
	        }
	        case "Embajador":{
	
	        	index = 4;
	
	            break;
	
	        }
	        case "Américas":{
	        	
	        	index = 5;
	
	            break;
	
	        }
	
	        default: {
	
	            System.out.println("Error en el index del multiplex");
	
	        }
	
	  }
		
		return index;
	}

	public void interactuarTablaUsuario (panelAdministradorUsuario panel,int fila, int columna) {
		
		UsuarioDao usuarioDao = new UsuarioDao();
		String cedula = (String) panel.getTablaUsuario().getValueAt(fila, 0);
		usuario = usuarioDao.getUsuario(cedula);
		actualizarPanelAdministradorUsuario(panel,1);
		
	}
	
	public void cambiarPanel (panelAdministradorUsuario a, panelAdministrador b) {
		
		a.setVisible(false);
		b.setVisible(true);
		
	}
	
	public void agregarUsuario(panelAdministradorUsuario panel) {
		
		// VALIDACION DE LOS DATOS SI COINCIDEN O NO
		int bandera = 0;
		// SI LOS DATOS SON NULOS
		if (panel.getTextoCedula().getText().length() == 0  || panel.getTextoNombre().getText().length() == 0 ||panel.getTextoFechaContrato().getText().length() == 0 || panel.getTextoCelular().getText().length() == 0) {
			
			JOptionPane.showMessageDialog(null, "Los datos están incompletos, vuelva a intentar.");		
			actualizarPanelAdministradorUsuario(panel,0);
			bandera++;
			
		}
				
		// SI LA ENTRADA DE TEXTO ES VALIDA
		if (bandera == 0) {
						
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario auxUsuario = new Usuario (panel.getTextoCedula().getText(), null,panel.getTextoNombre().getText(), panel.getTextoCelular().getText(),panel.getTextoFechaContrato().getText(), (String) panel.getCajaCargo().getSelectedItem(),null,(String) panel.getCajaMultiplex().getSelectedItem());

			if (usuarioDao.validarUsuario(panel.getTextoCedula().getText())) {
						
				JOptionPane.showMessageDialog(null, "El Usuario con esa Cédula ya está registrado, vuelva a intentar.");
				actualizarPanelAdministradorUsuario(panel,0);
					
			}else{
				
				usuarioDao.agregarUsuario(auxUsuario);
				establecerTabla(panel);
				actualizarPanelAdministradorUsuario(panel,0);
								
								
			}
						
		}
		
	}

	
	public void eliminarUsuario(panelAdministradorUsuario panel) {
		
		// VALIDACION DE LOS DATOS SI COINCIDEN O NO
		int bandera = 0;
		// SI LOS DATOS SON NULOS
		if (panel.getTextoCedula().getText().length() == 0  || panel.getTextoNombre().getText().length() == 0 ||panel.getTextoFechaContrato().getText().length() == 0 || panel.getTextoCelular().getText().length() == 0) {
			
			JOptionPane.showMessageDialog(null, "Los datos están incompletos, vuelva a intentar.");		
			actualizarPanelAdministradorUsuario(panel,0);
			bandera++;
			
		}
				
		// SI LA ENTRADA DE TEXTO ES VALIDA
		if (bandera == 0) {
					
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario auxUsuario = new Usuario (panel.getTextoCedula().getText(), null,panel.getTextoNombre().getText(), panel.getTextoCelular().getText(),panel.getTextoFechaContrato().getText(), (String) panel.getCajaCargo().getSelectedItem(),null,(String) panel.getCajaMultiplex().getSelectedItem());
				
			if (usuarioDao.validarUsuario(panel.getTextoCedula().getText())) {
				
				
				usuarioDao.eliminarUsuario(auxUsuario.getCedula());
				establecerTabla(panel);
				actualizarPanelAdministradorUsuario(panel,0);
					
			}else{
				
				JOptionPane.showMessageDialog(null, "El registro que quiere eliminar no existe, vuelva a intentar.");
				actualizarPanelAdministradorUsuario(panel,0);
								
								
			}
				
		}
		
	}

	public void administrarInforme() {
		
		JOptionPane.showMessageDialog(null,"¡En construcción!","Vuelva pronto...",JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void comenzarCompra(panelUsuario a, panelUsuarioCompra b) {
		
		// VALIDACION DE LOS DATOS SI COINCIDEN O NO
		int bandera = 0;
		// SI LOS DATOS SON NULOS
		if (a.getTextoCedula().getText().length() == 0 || a.getTextoNombre().getText().length() == 0) {

			JOptionPane.showMessageDialog(null, "Cliente no seleccionado");
			actualizarPanelUsuario(a,0);
			bandera++;
		}
		
		// SI LA ENTRADA DE TEXTO ES CORRECTA
		if (bandera == 0) {
			
			ClienteDao clienteDao = new ClienteDao();
			MultiplexDao multiplexDao = new MultiplexDao();
							
			if (clienteDao.validarCliente(a.getTextoCedula().getText(), a.getTextoNombre().getText())) {
				
				a.setVisible(false);
				b.setVisible(true);
				
				cliente = clienteDao.getCliente(a.getTextoCedula().getText());
				multiplex = multiplexDao.getMultiplex((String)a.getCajaMultiplex().getSelectedItem());
				
				b.getEtiquetaTitulo().setText("¡BIENVENIDO AL MUTIPLEX DE "+multiplex.getNombre()+"!");
				b.getEtiquetaParrafo().setText("Por favor seleccione la secci\u00F3n que desea el/la cliente/a "+cliente.getNombre()+" a comprar, boleteria y/o cofeteria. \u00A1No olvides calificarnos!");
		
					
			}else {
				
				JOptionPane.showMessageDialog(null, "Cliente no registrado, vuelva a intentarlo");
				
				actualizarPanelUsuario(a,0);
				
			}
		
		
		}
	}
	public void regresar (panelUsuario a, panelUsuarioCompra b) {
		
		a.setVisible(true);
		b.setVisible(false);
		
		actualizarPanelUsuario(a,0);
		
		cliente = null;
		multiplex = null;
		
	}
	public void regresar (panelUsuarioCompra a, panelUsuarioCompraCofiteria b) {
		
		a.setVisible(true);
		b.setVisible(false);
		
	}
	
	public void entrarBoleteria (panelUsuarioCompra a , panelUsuarioCompraBoleteria b) {
		
		a.setVisible(false);
		b.setVisible(true);
		
		b.getCajaSala().removeAllItems();
		
		
		for(int i = 0; i < Integer.parseInt(multiplex.getNumerodeSalas());i++) {
				
			b.getCajaSala().addItem("Sala " + (i+1));
			
		}
	
		
	}
	
	public void cancelarCompraBoleteria (panelUsuarioCompra a , panelUsuarioCompraBoleteria b) {
		a.setVisible(true);
		b.setVisible(false);
	}
	
	public void entrarCofiteria (panelUsuarioCompra a , panelUsuarioCompraCofiteria b) {
		
		a.setVisible(false);
		b.setVisible(true);
		
	}
	
	public void consultarSala (panelUsuarioCompraBoleteria panel)  {
		
		SalasDao salasDao = new SalasDao();
		
		sala = salasDao.getSala(multiplex.getNombre(), (panel.getCajaSala().getSelectedIndex()+1));
		
		establecerSala(panel);
		
	}
	
	public void establecerSala (panelUsuarioCompraBoleteria panel) {
		/*
		for (int i = 0; i < panel.g)
		*/
	}
	
}