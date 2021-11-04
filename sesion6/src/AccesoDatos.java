import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoDatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "pedidos";
	private static String hostname = "localhost";
	private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "root";
	private DatabaseMetaData metadatos;
	
	public Connection conecta;
	
	
	public boolean conectar() {
		try {
			Class.forName(driver);
			conecta = DriverManager.getConnection(url, username, password);
			metadatos = conecta.getMetaData();
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
	public void columnasMetaData(String catalogo, String tabla) {
		
		try {
			ResultSet rs = metadatos.getColumns(catalogo, null, tabla, null);
			
		if(rs.next()) {
			while(rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME")+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(18));
			}
		}else {
			System.out.println("No existe");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
