package util;

import data.VehiculoDAO;
import entities.TipoVehiculo;
import entities.Vehiculo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificarVehiculoAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		//TO DO validar los datos que vienen en la request
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setAnio(request.getParameter("anio"));
		vehiculo.setKilometraje(Float.parseFloat(request.getParameter("kilometraje")));
		vehiculo.setMarca(request.getParameter("marca"));
		vehiculo.setNroCarroceria(request.getParameter("nro-carroceria"));
		vehiculo.setPatente(request.getParameter("patente"));
		vehiculo.setTipoVehiculo(new TipoVehiculo(request.getParameter("tipo")));
		
		VehiculoDAO vDAO = new VehiculoDAO();
		vDAO.update(vehiculo);
		
		request.getSession().removeAttribute("vehiculoBuscado");
		request.setAttribute("succes", "Modificación completada");
		
		return "administrador/vehiculos/modificar-vehiculo.jsp";
	}
}
