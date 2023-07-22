package entities;

public class Rol {
	public static final String ADMIN = "admin";
	public static final String CLIENTE = "cliente";
	private Integer id;
	private String tipo;
	
	public Rol() {}
	
	public Rol(String tipo) {
		this.tipo = tipo;
	}
	
	public Rol(Integer id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
