package sesion4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccesoDatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "demodb";
    private static String hostname = "localhost";
    private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database +
									"?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "root";
    
    public Connection conecta;
    
    public boolean conectar() {
    	try {
			Class.forName(driver);
			conecta = DriverManager.getConnection(url, username, password);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }
    public boolean desconectar() {
    	if(conecta != null) {
    		try {
				conecta.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	return false;
    }
    public int actualizarSalarioConTransacciones(int departamento, double porcentaje) throws SQLException {
    	String actualizar = "UPDATE emp SET sal = sal * ? WHERE deptno = ?";
    	int devolveme = 0;
    	System.out.println("hola");
    	try {
			conecta.setAutoCommit(false);
			
			PreparedStatement preparacion = conecta.prepareStatement(actualizar);
			preparacion.setDouble(1, porcentaje);
			preparacion.setInt(2, departamento);
			
			
			devolveme = preparacion.executeUpdate();
			System.out.println("entra");
			conecta.commit();
			preparacion.close();
			conecta.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
			conecta.rollback();
		}
    	return devolveme;
    }
}
