package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.TipoVehiculo;
import entities.Vehiculo;

public class VehiculoDAO {
	
	public Vehiculo getOne(Vehiculo vehiculoBuscado) {
		Vehiculo vehiculo = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "SELECT * FROM vehiculos WHERE vehiculos.patente = ?";
		
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setString(1, vehiculoBuscado.getPatente());
			rs = statement.executeQuery();
			if (rs != null && rs.next()) {
				vehiculo = new Vehiculo();
				vehiculo.setPatente(rs.getString("patente"));
				vehiculo.setNroCarroceria(rs.getString("nro_carroceria"));
				vehiculo.setMarca(rs.getString("marca"));
				vehiculo.setKilometraje(rs.getFloat("kilometraje"));
				vehiculo.setAnio(rs.getString("anio"));
				
				TipoVehiculoDAO tvDAO = new TipoVehiculoDAO();
				vehiculo.setTipoVehiculo(tvDAO.getByVehiculo(vehiculo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(statement != null) {statement.close();}
				DBConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vehiculo;
	}

	public void update(Vehiculo vehiculo) {
		PreparedStatement statement = null;
		String query = "UPDATE vehiculos "
				+ "SET patente = ?, nro_carroceria = ?, marca = ?, kilometraje = ?, anio = ?, id_tipo = ? "
				+ "WHERE (patente = ?)";
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setString(1, vehiculo.getPatente());
			statement.setString(2, vehiculo.getNroCarroceria());
			statement.setString(3, vehiculo.getMarca());
			statement.setFloat(4, vehiculo.getKilometraje());
			statement.setString(5, vehiculo.getAnio());
			
			TipoVehiculoDAO tvDAO = new TipoVehiculoDAO();
			TipoVehiculo tv = tvDAO.getByTipo(vehiculo.getTipoVehiculo().getTipo());
			statement.setInt(6, tv.getId());
			
			statement.setString(7, vehiculo.getPatente());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {statement.close();}
				DBConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}
