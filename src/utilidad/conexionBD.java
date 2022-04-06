package utilidad;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class conexionBD {
	
	//Singleton
	private static conexionBD instancia;
	private static Connection conector;

	private conexionBD() {
		conector = null;
	}
	
	public static conexionBD getInstancia() {
		if (instancia == null) {
            instancia = new conexionBD();
        }
        return instancia;
	}
	
	//Metodo por el cual se conecta a la base de datos
	public static void conectarConexion() {
			
		//Atributos del metodo conectar, Un Jason que contiene las credenciales de acceso a la BD  y el Conector a la bd
		JSONParser analizador = new JSONParser();
		conector = null;
		//Intentar conectar
		try {
			//Se localizan las credenciales de acceso al bd
			String localizacionCrendenciales = System.getProperty("user.dir") + "/src/utilidad/credenciales_bd.json";
			
			//Se transforman a un diccioanrio JSon
			JSONObject diccionarioJson = (JSONObject)analizador.parse(new FileReader(localizacionCrendenciales));  
			
			//Se establecen las partes del Diccionario a las varianbles que compondran la url para hacer la conexion con Posgress
			String hostIp     = (String)diccionarioJson.get("db_ip");
			String puerto     = (String)diccionarioJson.get("dp_port");
			String usuarioBd = (String)diccionarioJson.get("db_user");
			String contrasenaBd = (String)diccionarioJson.get("db_pssword");
			String nombreBd = (String)diccionarioJson.get("db_nombreBD");
		    	
		    //Creacion de la URL conectora con la Base de datos
			String dbURL = "jdbc:postgresql://"+hostIp+":"+puerto+"/"+nombreBd;
		        
		    //Creacion del conector de la bd 
			conector = DriverManager.getConnection(dbURL, usuarioBd, contrasenaBd);
		    	
		    //Si no hubise error en los datos para hacer la conexion, ya estamos conectados
		    if( conector != null ) {
		    	System.out.println ( "Conectado" );
		    }
		    
		 }catch( SQLException | FileNotFoundException ex ) {
			 ex.printStackTrace();
			 System.out.println("Problemas de conexion");
		 }catch (IOException | ParseException ex) {
			 ex.printStackTrace();
			 System.out.println("Problemas de conexion");
		 }
		
		    
	}
		

	//Metodo para desconectar la bd.
	public static void detenerConexion() {
		try {
			conector.close();
			System.out.println("Conexion detenida");
		}catch( SQLException ex ) {
			ex.printStackTrace();
			System.out.println("Problema al detener la conexion");
		}
		
	}
	
	public static Connection getConector() {
		return conector;
	}

	public static void setConector(Connection conector) {
		conexionBD.conector = conector;
	}

}
