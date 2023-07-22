package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Usuario;

public class UsuarioDAO {
	
	public Usuario getOne(Usuario usuarioBuscado) {
		Usuario usuario = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "select * from usuarios where usuarios.email = ? and usuarios.password = ?";
		
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setString(1, usuarioBuscado.getEmail());
			statement.setString(2, usuarioBuscado.getPassword());
			rs = statement.executeQuery();
			if (rs != null && rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setDNI(rs.getString("dni"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setHabilitado(rs.getBoolean("habilitado"));
				
				RolDAO rDAO = new RolDAO();
				usuario.setRol(rDAO.getByUsuario(usuario));
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
		
		return usuario;
	}

	public Usuario getByDNI(Usuario usuarioBuscado) {
		Usuario usuario = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String query = "select * from usuarios where usuarios.dni = ?";
		
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setString(1, usuarioBuscado.getDNI());
			rs = statement.executeQuery();
			if (rs != null && rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setDNI(rs.getString("dni"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setHabilitado(rs.getBoolean("habilitado"));
				
				RolDAO rDAO = new RolDAO();
				usuario.setRol(rDAO.getByUsuario(usuario));
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
		return usuario;
	}

	public void update(Usuario usuario) {
		PreparedStatement statement = null;
		String query = "UPDATE usuarios SET email = ?, nombre = ?, apellido = ?, dni = ?, telefono = ?, direccion = ?, habilitado = ?, rol = ? WHERE (id = ?)";

		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setString(1, usuario.getEmail());
			statement.setString(2, usuario.getNombre());
			statement.setString(3, usuario.getApellido());
			statement.setString(4, usuario.getDNI());
			statement.setString(5, usuario.getTelefono());
			statement.setString(6, usuario.getDireccion());
			statement.setBoolean(7, usuario.isHabilitado());
			
			RolDAO rDAO = new RolDAO();
			statement.setInt(8, rDAO.getByTipo(usuario.getRol()).getId());
			
			statement.setInt(9, usuario.getId());
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
