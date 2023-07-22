package servlets;

import java.io.IOException;

import entities.Usuario;
import data.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Usuario usuario = new Usuario(email, password);
		
		UsuarioDAO uDAO = new UsuarioDAO();
		usuario = uDAO.getOne(usuario);
		if (usuario != null) {
			request.getSession().setAttribute("usuario", usuario);
			if (usuario.isAdmin())
				response.sendRedirect("administrador/inicio.jsp");
			else {
				request.getRequestDispatcher("cliente/inicio.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("mensaje", "Usuario no encontrado");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
