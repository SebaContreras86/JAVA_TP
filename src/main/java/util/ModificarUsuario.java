package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import data.UsuarioDAO;
import entities.Rol;
import entities.Usuario;

public class ModificarUsuario extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {		
		Usuario usuario = new Usuario();
		if (!request.getParameter("email").matches(Regex.EMAIL.getRegex())) {
			request.setAttribute("invalidData", "E-mail no válido");
			return "administrador/modificar-usuario.jsp";
		}
		if (!request.getParameter("nombre").matches(Regex.NOMBRE_APELLIDO.getRegex())) {
			request.setAttribute("invalidData", "Nombre no válido");
			return "administrador/modificar-usuario.jsp";
		}
		if (!request.getParameter("apellido").matches(Regex.NOMBRE_APELLIDO.getRegex())) {
			request.setAttribute("invalidData", "Apellido no válido");
			return "administrador/modificar-usuario.jsp";
		}
		if (!request.getParameter("dni").matches(Regex.DNI.getRegex())) {
			request.setAttribute("invalidData", "DNI no válido");
			return "administrador/modificar-usuario.jsp";
		}
		if (!request.getParameter("telefono").matches(Regex.TELEFONO.getRegex())) {
			request.setAttribute("invalidData", "Número de teléfono no válido");
			return "administrador/modificar-usuario.jsp";
		}
		if (!request.getParameter("direccion").matches(Regex.DIRECCION.getRegex())) {
			request.setAttribute("invalidData", "Dirección no válida");
			return "administrador/modificar-usuario.jsp";
		}
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setEmail(request.getParameter("email"));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellido(request.getParameter("apellido"));
		usuario.setDNI(request.getParameter("dni"));
		usuario.setTelefono(request.getParameter("telefono"));
		usuario.setDireccion(request.getParameter("direccion"));
		if (request.getParameter("habilitado") != null) {
			usuario.setHabilitado(true);
		} else {
			usuario.setHabilitado(false);
		}
		usuario.setRol(new Rol(request.getParameter("tipo")));
		
		UsuarioDAO uDAO = new UsuarioDAO();
		uDAO.update(usuario);
		request.setAttribute("succes", "Modificación completada");
		
		return "administrador/modificar-usuario.jsp";
	}

}
