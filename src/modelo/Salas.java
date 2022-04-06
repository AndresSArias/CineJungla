package modelo;

public class Salas {
	
	private String multiplex;
	private String numero_de_sala;
	private int[] arreglo_sillas_generales;
	private int[] arreglo_sillas_preferenciales;
	
	//Constructor
	
	public Salas (String multiplex, String numero_de_sala, int[] arreglo_sillas_generales, int[] arreglo_sillas_preferenciales) {
		
		this.multiplex = multiplex;
		this.numero_de_sala = numero_de_sala;
		this.arreglo_sillas_generales = arreglo_sillas_generales;
		this.arreglo_sillas_preferenciales = arreglo_sillas_preferenciales;
	}
	
	public String getMultiplex() {
		return multiplex;
	}
	
	public void setMultiplex(String multiplex) {
		this.multiplex = multiplex;
	}
	
	public String getNumeroDeSala() {
		return numero_de_sala;
	}
	public void setNumeroDeSala(String numero_de_sala) {
		this.numero_de_sala = numero_de_sala;
	}
	
	public int[] getArregloSillasGenerales() {
		return arreglo_sillas_generales;
	}
	public void setArregloSillasGenerales(int[] arreglo_sillas_generales) {
		this.arreglo_sillas_generales = arreglo_sillas_generales;
	}
	
	public int[] getArregloSillasPreferenciales() {
		return arreglo_sillas_preferenciales;
	}
	public void setArregloSillasPreferenciales(int[] arreglo_sillas_preferenciales) {
		this.arreglo_sillas_preferenciales = arreglo_sillas_preferenciales;
	}
}
