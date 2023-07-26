package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import data.UsuarioDAO;
import entities.Usuario;

public class EliminarUsuarioAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioBuscado");
		UsuarioDAO uDAO = new UsuarioDAO();
		uDAO.delete(usuario);
		
		request.getSession().removeAttribute("usuarioBuscado");
		request.setAttribute("succes", "Usuario eliminado!");
		
		return "administrador/eliminar-usuario.jsp";
	}

}
