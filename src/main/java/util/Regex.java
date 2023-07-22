package util;

public enum Regex {
	EMAIL("^[\\w]+[\\w-._]*@[\\w]+\\.[\\w]{2,3}$"),
	NOMBRE_APELLIDO("^[a-zA-Z]{3,15}$"),
	DNI("^[\\d]{7,8}$"),
	TELEFONO("^4[\\d]{6}$"),
	DIRECCION("^[\\w\s]{4,30} [\\d]{1,4}$");
	
	final String value;
	
	private Regex(String value) {
		this.value = value;
	}
	
	public String getRegex() {
		return this.value;
	}
}
