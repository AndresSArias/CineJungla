package accesoDao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;


import modelo.Usuario;
import utilidad.conexionBD;


import java.util.ArrayList;


public class UsuarioDao {
	
	private conexionBD conector;
	
	public ArrayList<Usuario> getUsuarios() {
		
		conector = conexionBD.getInstancia();
		
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            
        	conector.conectarConexion();
            
            String sql          = "SELECT * FROM usuario;";
            Statement declaracion = conector.getConector().createStatement();
            ResultSet resultado    = declaracion.executeQuery(sql);
            
            while (resultado.next()) {
                Usuario usuario = new Usuario(resultado.getString(1), resultado.getString(2),resultado.getString(3), resultado.getString(4),resultado.getString(5), resultado.getString(6),resultado.getString(7),resultado.getString(8));
                usuarios.add( usuario );
            }
            
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        
        return usuarios;
        
	}
	
	public Usuario getUsuario (String cedula) {
		
		conector = conexionBD.getInstancia();
		Usuario usuario = null;
		
        try {
        	
        	conector.conectarConexion();
            
            String sql = "SELECT * FROM usuario WHERE cedula = '"+cedula+"';";
            
            Statement declaracion = conector.getConector().createStatement();
            ResultSet resultado    = declaracion.executeQuery(sql);
            
            while (resultado.next()) {
            	
                usuario = new Usuario(resultado.getString(1), resultado.getString(2),resultado.getString(3), resultado.getString(4),resultado.getString(5), resultado.getString(6),resultado.getString(7),resultado.getString(8));
                
            }
            
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }

        
        return usuario;
        
	}
	
	public boolean validarUsuario (String cedula) {
		
		conector = conexionBD.getInstancia();
		boolean verificador = false;
		
		try {
			
			conector.conectarConexion();
            
            String sql = "SELECT usuario.cedula FROM usuario;";
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
	
	public void agregarUsuario (Usuario usuario) {
		
		conector = conexionBD.getInstancia();
		
		try {
			
			conector.conectarConexion();
			//INSERT INTO Usuario(cedula,nombre,celular,fechainiciocontrato,cargo,salario,multiplex) VALUES ('1000520869','Faider Trujillo','3012025465','2021-03-26','Director',3000000,'Titán');
			String sql = "INSERT INTO Usuario(cedula,nombre,celular,fechainiciocontrato,cargo,salario,multiplex) VALUES ('"
			+usuario.getCedula()+"','"+usuario.getNombre()+"','"+usuario.getCelular()+"','"+usuario.getFechaContrato()+"','"+usuario.getCargo()+"','"+1500000+"','"+usuario.getMultiplex()+"');";
			
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
	
}
