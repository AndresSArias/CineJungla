package accesoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.Multiplex;
import modelo.Salas;
import utilidad.conexionBD;

public class SalasDao {
	
	private conexionBD conector;
	
	public Salas getSala (String multiplex, int numeroSala) {
		
		conector = conexionBD.getInstancia();
		Salas sala = null;
		
		try {
        	
        	conector.conectarConexion();
            
            String sql = "SELECT * FROM salas WHERE multiplex = '"+multiplex+"' AND numerodesala = "+numeroSala+";";
            
            Statement declaracion = conector.getConector().createStatement();
            ResultSet resultado    = declaracion.executeQuery(sql);
            
            while (resultado.next()) {
            	
                sala = new Salas(resultado.getString(1), resultado.getString(2), resultado.getArray(3),resultado.getArray(4));
                
            }
            
            conector.detenerConexion();
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }

		
		return sala;
	}
	
}
