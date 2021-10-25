package sesion4;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		AccesoDatos bd = new AccesoDatos();
		
		bd.conectar();
			System.out.println("Se han actualizado => "+bd.actualizarSalarioConTransacciones(20, 0.1));
		bd.desconectar();
	}

}
