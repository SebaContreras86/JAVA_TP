package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import data.TipoVehiculoDAO;

public class LoadPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoadPage() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TipoVehiculoDAO tvDAO = new TipoVehiculoDAO();
		request.setAttribute("tvDAO", tvDAO);
		request.getRequestDispatcher("administrador/registrar-vehiculo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
