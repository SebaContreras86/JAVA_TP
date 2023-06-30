package data;

import entities.Usuario;

public class Test {

	public static void main(String[] args) {
		UsuarioDAO pDao = new UsuarioDAO();
		Usuario usuario = pDao.getOne(new Usuario("juan@hotmail.com", "123"));
		
		if (usuario.isAdmin()) {
			System.out.println(usuario.getNombre());
			System.out.println(usuario.getApellido());
			System.out.println(usuario.getRol().getTipo());
		} else {
			System.out.println("Usuario no encontrado");
		}
	}

}
