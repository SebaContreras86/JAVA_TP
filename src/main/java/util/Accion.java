package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Accion {
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
	
	public static Accion GetAccion(String tipo){
		Accion accion;
		switch (tipo) {
		case "buscarusuario":
			accion = new BuscarUsuario();
			break;
		case "modificarusuario":
			accion = new ModificarUsuario();
			break;
		default:
			accion = null;
			break;
		}
		return accion;
	}
}
