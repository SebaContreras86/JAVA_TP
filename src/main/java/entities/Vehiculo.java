package entities;

public class Vehiculo {
	private String patente;
	private String nroCarroceria;
	private String marca;
	private float kilometraje;
	private String anio;
	private TipoVehiculo tipoVehiculo;
	
	public Vehiculo() {}
	
	public Vehiculo(String patente) {
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getNroCarroceria() {
		return nroCarroceria;
	}

	public void setNroCarroceria(String nroCarroceria) {
		this.nroCarroceria = nroCarroceria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(float kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
}
