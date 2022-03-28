package modelo;

public class Usuario {
	
	//Atributos de la clase Usuario
	private String cedula = " ";
	private String codigo = " ";
	private String nombre = " ";
	private String celular = " ";
	private String fechaContrato = " ";
	private String cargo = " ";
	private String salario = " ";
	private String multiplex = " ";
	
	public Usuario (String cedula,String codigo,String nombre,String celular,String fechaContrato,String cargo,String salario, String multiplex) {
		
		this.cedula = cedula;
		this.codigo = codigo;
		this.nombre = nombre;
		this.celular = celular;
		this.fechaContrato = fechaContrato;
		this.cargo = cargo;
		this.salario = salario;
		this.multiplex = multiplex;
	}
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrator(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getMultiplex() {
		return multiplex;
	}
	public void setMultiplex (String multiplex) {
		this.multiplex = multiplex;
	}
	
}
