package util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Accion {
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
	
	public static Accion GetAccion(String tipo){
		Accion accion;
		switch (tipo) {
		case "buscarusuario":
			accion = new BuscarUsuarioAccion();
			break;
		case "modificarusuario":
			accion = new ModificarUsuarioAccion();
			break;
		case "registrarusuario":
			accion = new RegistrarUsuarioAccion();
			break;
		default:
			accion = null;
			break;
		}
		return accion;
	}
}
