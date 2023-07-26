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
		String query = "SELECT * FROM usuarios "
				+ "WHERE usuarios.email = ? AND usuarios.password = ?";
		
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
		String query = "SELECT * FROM usuarios WHERE usuarios.dni = ?";
		
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
		String query = "UPDATE usuarios "
				+ "SET email = ?, nombre = ?, apellido = ?, dni = ?, telefono = ?, direccion = ?, habilitado = ?, rol = ? "
				+ "WHERE (id = ?)";

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

	public void add(Usuario usuario) {
		PreparedStatement statement = null;
		String query = "INSERT INTO usuarios "
				+ "(email, password, nombre, apellido, dni, telefono, direccion, habilitado, rol) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			
			statement.setString(1, usuario.getEmail());
			statement.setString(2, usuario.getPassword());
			statement.setString(3, usuario.getNombre());
			statement.setString(4, usuario.getApellido());
			statement.setString(5, usuario.getDNI());
			statement.setString(6, usuario.getTelefono());
			statement.setString(7, usuario.getDireccion());
			statement.setBoolean(8, usuario.isHabilitado());
			
			RolDAO rDAO = new RolDAO();
			statement.setInt(9, rDAO.getByTipo(usuario.getRol()).getId());
			
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

	public void delete(Usuario usuario) {
		PreparedStatement statement = null;
		String query = "DELETE FROM usuarios WHERE id = ?";

		try {
			statement = DBConnector.getInstancia().getConn().prepareStatement(query);
			statement.setInt(1, usuario.getId());
			
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
