package entities;

public class Usuario {
	private Integer id;
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String direccion;
	private Rol rol;
	private Boolean habilitado;
	
	public Usuario() {}
	
	public Usuario(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public Usuario(String dni) {
		this.dni = dni;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRol() {
		return this.rol.getTipo();
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Boolean isHabilitado() {
		return this.habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public String getFullName() {
		return this.nombre + " " +  this.apellido;
	}

	public boolean isAdmin() {
		boolean admin = false;
		if (this.rol.getTipo().equals("admin")) admin = true;
		return admin;
	}

}
