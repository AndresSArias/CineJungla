package accesoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.Multiplex;
import utilidad.conexionBD;

public class MultiplexDao {

	private conexionBD conector;
	
	public Multiplex getMultiplex (String nombre) {
		
		conector = conexionBD.getInstancia();
		Multiplex multiplex = null;
		
        try {
        	
        	conector.conectarConexion();
            
            String sql = "SELECT * FROM multiplex WHERE nombre = '"+nombre+"';";
            
            Statement declaracion = conector.getConector().createStatement();
            ResultSet resultado    = declaracion.executeQuery(sql);
            
            while (resultado.next()) {
            	
                multiplex = new Multiplex(resultado.getString(1), resultado.getString(2));
                
            }
            
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }

        
        return multiplex;
        
	}
	
}
