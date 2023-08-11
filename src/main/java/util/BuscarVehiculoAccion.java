package util;

import data.TipoVehiculoDAO;
import data.VehiculoDAO;
import entities.Vehiculo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BuscarVehiculoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String patente = request.getParameter("patente");
		Vehiculo vehiculo = new Vehiculo(patente);
		
		VehiculoDAO vDAO = new VehiculoDAO();
		vehiculo = vDAO.getOne(vehiculo);
		TipoVehiculoDAO tvDAO = new TipoVehiculoDAO();
		
		if (vehiculo != null) {
			request.getSession().setAttribute("vehiculoBuscado", vehiculo);
			request.getSession().setAttribute("tiposVehiculos", tvDAO.getAll());
		} else {
			request.setAttribute("notFound", "Vehículo no encontrado");
		}
		
		return (String) request.getSession().getAttribute("returnTo");
	}

}
