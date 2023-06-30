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
				usuario.setCuit(rs.getString("cuit"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setDireccion(rs.getString("direccion"));
				
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
}
