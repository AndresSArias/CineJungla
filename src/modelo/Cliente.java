package modelo;

public class Cliente {
	
	//Atributos de la clase Cliente
	private String nombre = " ";
	private String cedula = " ";
	private String puntos = " ";
	private String calificacion_cine_jungla = " ";
	private String calificacion_pelicula = " ";
	
	//Constructor
	
	public Cliente (String nombre, String cedula, String puntos, String calificacion_cine_jungla, String calificacion_pelicula) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.puntos = puntos;
		this.calificacion_cine_jungla = calificacion_cine_jungla;
		this.calificacion_pelicula = calificacion_pelicula;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getPuntos() {
		return puntos;
	}
	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}
	
	public String getCalificacionCineJungla() {
		return calificacion_cine_jungla;
	}
	public void setCalificacionCineJungla(String calificacion_cine_jungla) {
		this.calificacion_cine_jungla = calificacion_cine_jungla;
	}
	
	public String getCalificacionPelicula() {
		return calificacion_pelicula;
	}
	public void setCalificacionPelicula(String calificacion_pelicula) {
		this.calificacion_pelicula = calificacion_pelicula;
	}
	
	public Object[] toArray(){
        Object[] data = {nombre, cedula, puntos};
        return data;
    }
	
}
  