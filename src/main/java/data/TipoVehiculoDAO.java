package data;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.TipoVehiculo;
import entities.Vehiculo;

public class TipoVehiculoDAO {
	
	public List<TipoVehiculo> getAll() {
		List<TipoVehiculo> lista = new ArrayList<TipoVehiculo>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "SELECT * FROM tipo_vehiculo";
		
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			rs = statement.executeQuery();
			while (rs != null && rs.next()) {
				TipoVehiculo tipoVehiculo = new TipoVehiculo();
				tipoVehiculo.setId(rs.getInt("id"));
				tipoVehiculo.setDescripcion(rs.getString("descripcion"));
				tipoVehiculo.setTipo(rs.getString("tipo"));
				tipoVehiculo.setTarifa(rs.getFloat("tarifa_km"));
				
				lista.add(tipoVehiculo);
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
				
		return lista;
	}

	public TipoVehiculo getByVehiculo(Vehiculo vehiculo) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		TipoVehiculo tipoVehiculo = null;
		String query = "SELECT tipo_vehiculo.* "
				+ "FROM tipo_vehiculo "
				+ "INNER JOIN vehiculos "
				+ "ON tipo_vehiculo.id = vehiculos.id_tipo "
				+ "WHERE vehiculos.patente = ?";
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setString(1, vehiculo.getPatente());
			rs = statement.executeQuery();
			if (rs != null && rs.next()) {
				tipoVehiculo = new TipoVehiculo();
				tipoVehiculo.setId(rs.getInt("id"));
				tipoVehiculo.setTipo(rs.getString("tipo"));
				tipoVehiculo.setDescripcion(rs.getString("descripcion"));
				tipoVehiculo.setTarifa(rs.getFloat("tarifa_km"));
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
		return tipoVehiculo;
	}

	public TipoVehiculo getByTipo(String tipo) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		TipoVehiculo tipoVehiculo = null;
		String query = "SELECT tipo_vehiculo.* FROM tipo_vehiculo WHERE tipo_vehiculo.tipo = ?";
		
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setString(1, tipo);
			rs = statement.executeQuery();
			if (rs != null && rs.next()) {
				tipoVehiculo = new TipoVehiculo();
				tipoVehiculo.setId(rs.getInt("id"));
				tipoVehiculo.setTipo(rs.getString("tipo"));
				tipoVehiculo.setDescripcion(rs.getString("descripcion"));
				tipoVehiculo.setTarifa(rs.getFloat("tarifa_km"));
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
		
		return tipoVehiculo;
	}
}
