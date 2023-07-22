package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Rol;
import entities.Usuario;

public class RolDAO {

	public RolDAO() {}

	public Rol getByUsuario(Usuario usuario) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Rol rol = null;
		String query = "select roles.* from roles "
				+ "inner join usuarios "
				+ "on usuarios.rol = roles.id "
				+ "where usuarios.id = ?";
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setInt(1, usuario.getId());
			rs = statement.executeQuery();
			if (rs != null && rs.next()) {
				rol = new Rol();
				rol.setId(rs.getInt("id"));
				rol.setTipo(rs.getString("tipo"));
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
		return rol;
	}

	public Rol getByTipo(String tipo) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		Rol rol = null;
		String query = "select roles.* from roles where roles.tipo = ?";
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setString(1, tipo);
			rs = statement.executeQuery();
			if (rs != null && rs.next()) {
				rol = new Rol();
				rol.setId(rs.getInt("id"));
				rol.setTipo(rs.getString("tipo"));
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
		return rol;
	}

}
