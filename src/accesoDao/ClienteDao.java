package accesoDao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Salas;
import utilidad.conexionBD;

public class ClienteDao {
	
	private conexionBD conector;
	
	public ArrayList<Cliente> getClientes() {
		
		conector = conexionBD.getInstancia();
		
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            
        	conector.conectarConexion();
            
            String sql          = "SELECT * FROM cliente;";
            Statement declaracion = conector.getConector().createStatement();
            ResultSet resultado    = declaracion.executeQuery(sql);
            
            while (resultado.next()) {
                Cliente cliente = new Cliente(resultado.getString(1), resultado.getString(2),resultado.getString(3), resultado.getString(4),resultado.getString(5));
                clientes.add( cliente );
            }
            
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        
        return clientes;
        
	}
	
	public Cliente getCliente (String cedula) {
		
		conector = conexionBD.getInstancia();
		Cliente cliente = null;
		
        try {
        	
        	conector.conectarConexion();
            
            String sql = "SELECT * FROM cliente WHERE cedula = '"+cedula+"';";
            
            Statement declaracion = conector.getConector().createStatement();
            ResultSet resultado    = declaracion.executeQuery(sql);
            
            while (resultado.next()) {
            	
                cliente = new Cliente(resultado.getString(1), resultado.getString(2),resultado.getString(3), resultado.getString(4),resultado.getString(5));
                
            }
            
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }

        
        return cliente;
        
	}
	
	public boolean validarCedula (String cedula) {
		
		conector = conexionBD.getInstancia();
		boolean verificador = false;
		
		try {
			
			conector.conectarConexion();
            
            String sql = "SELECT cliente.cedula FROM cliente;";
            Statement declaracion = conector.getConector().createStatement();
            ResultSet resultado    = declaracion.executeQuery(sql);
            
            
            while (resultado.next()) {
            	
            	BigDecimal decimal = resultado.getBigDecimal(1);
            	BigInteger mob = (decimal == null ? null : decimal.toBigInteger());
            	
                if ((mob+"").equals(cedula)) {
                	verificador = true;
                	break;
                }
            }
            
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
			
		return verificador;
	}
	
	public void agregarCliente (Cliente cliente) {
		
		conector = conexionBD.getInstancia();
		
		try {
			
			conector.conectarConexion();

			String sql = "INSERT INTO Cliente VALUES ('"+cliente.getNombre()+"','"+cliente.getCedula()+"','"+cliente.getPuntos()+"','"+cliente.getCalificacionCineJungla()+"','"+cliente.getCalificacionPelicula()+"');";
			
			 PreparedStatement declaracion = conector.getConector().prepareStatement(sql);
	         int filaInsertada = declaracion.executeUpdate();
	         if (filaInsertada > 0) {
	             JOptionPane.showMessageDialog(null, "¡El usuario fue agregado exitosamente!");
	          }
			
	         conector.detenerConexion();
			
		}catch (SQLException ex) {
			
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());      
			
			JOptionPane.showMessageDialog(null,"¡Error al ingresar al usuario!","Intentelo de nuevo...",JOptionPane.ERROR_MESSAGE);
        }
		
	}
	
	public void eliminarCliente (String cedula) {
		
		conector = conexionBD.getInstancia();
		
		try {
        	
			conector.conectarConexion();
            
            String sql = "DELETE FROM cliente WHERE cedula = '"+cedula+"';";
            PreparedStatement declaracion = conector.getConector().prepareStatement(sql);
            int filaEliminada = declaracion.executeUpdate();
            if (filaEliminada > 0) {
                JOptionPane.showMessageDialog(null, "¡El usuario fue borrado exitosamente!");
            }
            
            conector.detenerConexion();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
		
	}
	
	public boolean validarCliente (String cedula, String nombre) {
		
		conector = conexionBD.getInstancia();
		boolean verificador = false;
		
		try {
			
			conector.conectarConexion();
            
            String sql = "SELECT cliente.nombre, cliente.cedula FROM cliente;";
            Statement declaracion = conector.getConector().createStatement();
            ResultSet resultado    = declaracion.executeQuery(sql);
            
            
            while (resultado.next()) {
            	            	
            	BigDecimal decimal = resultado.getBigDecimal(2);
            	BigInteger mob = (decimal == null ? null : decimal.toBigInteger());
            	
                if (resultado.getString(1).equals(nombre)&&(mob+"").equals(cedula)) {
                	verificador = true;
                	break;
                }
            }
            
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
			
		return verificador;
		
	}
	
	public void actualizarCliente (Cliente cliente) {
		
		conector = conexionBD.getInstancia();
		
		try {
        	
			conector.conectarConexion();
            
            
            String sql = "UPDATE cliente SET nombre = '"+cliente.getNombre()+"', puntos = "+cliente.getPuntos()+" , calificacioncinejungla = "+cliente.getCalificacionCineJungla()+", calificacionpelicula = "+cliente.getCalificacionPelicula()+"  WHERE cedula = "+cliente.getCedula()+" ;";
           
            PreparedStatement declaracion = conector.getConector().prepareStatement(sql);
            
            int filaActualizada = declaracion.executeUpdate();
            
            if (filaActualizada > 0) {
                JOptionPane.showMessageDialog(null, "¡El cliente fue actualizado exitosamente!");
               }
         
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());      	
        }
	}
	
}
