package Ejercicios;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class AccesoDatos {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "pedidos";
	private static String hostname = "localhost";
	private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
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
	public double importePedido(int pedido) {
		String funcion = "SELECT importePedido(?)";
		double pedidoImporte = 0.0;
		try {
			CallableStatement llamada = conecta.prepareCall(funcion);
			llamada.setInt(1, pedido);
			
			ResultSet resultado = llamada.executeQuery();
			
			if(resultado.next()) {
				pedidoImporte = resultado.getDouble(1);
				return pedidoImporte;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidoImporte;
	}
	public void productosCategoriaBajoMinimos(int categoria) {
		String procedimiento = "CALL productosCategoriaBajoMinimos(?)";
		boolean noExiste;
		try {
			CallableStatement llamada = conecta.prepareCall(procedimiento);
			llamada.setInt(1, categoria);
			
			ResultSet resultado = llamada.executeQuery();
			noExiste = resultado.next();
			if(!noExiste) {
				System.out.println("La categoria: "+categoria+" o no existe o no tiene productos bajo mínimos");
				
			}else {
				System.out.println("Nombre Producto - Precio - Existencias - Mínimo");
				System.out.println("-------------------------------------------------");
				System.out.println(resultado.getString(1)+" "+resultado.getDouble(2)+" "+resultado.getInt(3)+" "+resultado.getInt(4));
				while(resultado.next()) {
					System.out.println(resultado.getString(1)+" "+resultado.getDouble(2)+" "+resultado.getInt(3)+" "+resultado.getInt(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int incrementarPrecioCategoria(int categoria, int cantidad) {
		String procedimiento = "CALL incrementarPrecioCategoria(?, ?, ?)";
		int resultado = 0;
		try {
			CallableStatement llamada = conecta.prepareCall(procedimiento);
			llamada.setInt(1, categoria);
			llamada.setInt(2, cantidad);
			llamada.registerOutParameter(3, Types.INTEGER);
			
			llamada.execute();
			
			resultado = llamada.getInt(3);
		
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
