package entities;

import java.util.Objects;

public class TipoVehiculo {
	private int id;
	private String tipo;
	private String descripcion;
	private float tarifa;
	
	public TipoVehiculo() {}
	
	public TipoVehiculo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getTarifa() {
		return tarifa;
	}
	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TipoVehiculo))
			return false;
		TipoVehiculo other = (TipoVehiculo) obj;
		return id == other.id;
	}
}
