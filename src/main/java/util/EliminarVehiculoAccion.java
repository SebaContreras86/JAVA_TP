package util;

import data.VehiculoDAO;
import entities.Vehiculo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminarVehiculoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		Vehiculo vehiculo = (Vehiculo) request.getSession().getAttribute("vehiculoBuscado");
		VehiculoDAO vDAO = new VehiculoDAO();
		vDAO.delete(vehiculo);
		
		request.getSession().removeAttribute("vehiculoBuscado");
		request.setAttribute("succes", "Vehiculo eliminado!");
		
		return "administrador/vehiculos/eliminar-vehiculo.jsp";
	}

}
