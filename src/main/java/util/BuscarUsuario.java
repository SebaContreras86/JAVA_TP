package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import data.UsuarioDAO;
import entities.Usuario;

public class BuscarUsuario extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String dni = request.getParameter("dni");
		Usuario usuario = new Usuario(dni);
		
		UsuarioDAO uDAO = new UsuarioDAO();
		usuario = uDAO.getByDNI(usuario);
		
		if (usuario != null) {
			request.setAttribute("usuarioBuscado", usuario);
		} else {
			request.setAttribute("notFound", "Usuario no encontrado");
		}
		return "administrador/modificar-usuario.jsp";
	}

}
