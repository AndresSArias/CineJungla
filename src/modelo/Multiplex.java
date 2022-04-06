package modelo;

public class Multiplex {

	private String nombre;
	private String numero_de_salas;
	
	//Constructor
	
	public Multiplex (String nombre, String numero_de_salas) {
		this.nombre = nombre;
		this.numero_de_salas = numero_de_salas;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNumerodeSalas() {
		return numero_de_salas;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumerodeSalas(String numero_de_salas) {
		this.numero_de_salas = numero_de_salas;
	}
}
