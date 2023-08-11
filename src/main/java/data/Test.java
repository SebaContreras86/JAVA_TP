package data;

import entities.Vehiculo;

public class Test {

	public static void main(String[] args) {
		Vehiculo vehiculo = new Vehiculo("aaa111bbb");
		VehiculoDAO vDAO = new VehiculoDAO();
		
		vDAO.getOne(vehiculo);
		System.out.println();
	}
}
