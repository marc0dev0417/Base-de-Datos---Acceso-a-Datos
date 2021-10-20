package Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoBaseDatos {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "demodb";
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
	public Empleado busquedaPorCodigo(int numero) {
		Empleado empleado;
		String consulta = "SELECT * FROM emp WHERE empno = ?";
		try {
			PreparedStatement preparacion = conecta.prepareStatement(consulta);
			preparacion.setInt(1, numero);
			ResultSet resultado = preparacion.executeQuery();
			
			if(resultado.next()) {
				empleado = new Empleado(resultado.getInt("empno"), resultado.getString("ename"), resultado.getString("job"), resultado.getInt("mgr"), resultado.getDate("hiredate"), resultado.getDouble("sal"), resultado.getDouble("comm"), resultado.getInt("deptno"));
				return empleado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Empleado> busquedaPorOficio(String oficio){
		ArrayList<Empleado> lista= new ArrayList<Empleado>();
		
		String consulta = "SELECT * FROM emp WHERE job = ?";
		try {
			PreparedStatement preparacion = conecta.prepareStatement(consulta);
			preparacion.setString(1, oficio);
			
			ResultSet resultado = preparacion.executeQuery();
			
			while(resultado.next()) {
				lista.add(new Empleado(resultado.getInt("empno"), resultado.getString("ename"), resultado.getString("job"), resultado.getInt("mgr"), resultado.getDate("hiredate"), resultado.getDouble("sal"), resultado.getDouble("comm"), resultado.getInt("deptno")));
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Empleado> busquedaPorAntiguedad(java.sql.Date fecha){
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		
		String consulta = "SELECT * FROM emp WHERE hiredate <= ?";
		try {
			PreparedStatement preparacion = conecta.prepareStatement(consulta);
			preparacion.setDate(1, fecha);
			
			ResultSet resultado = preparacion.executeQuery();
			
			while(resultado.next()) {
				lista.add(new Empleado(resultado.getInt("empno"), resultado.getString("ename"), resultado.getString("job"), resultado.getInt("mgr"), resultado.getDate("hiredate"), resultado.getDouble("sal"), resultado.getDouble("comm"), resultado.getInt("deptno")));
				
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int insertarConBean(Empleado empleado) {
		String insercion = "INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)";
		int codigoSql;
		try {
			PreparedStatement preparacion = conecta.prepareStatement(insercion);
			preparacion.setInt(1, empleado.getNumeroEmpleado());
			preparacion.setString(2, empleado.getNombreEmpleado());
			preparacion.setString(3, empleado.getOficio());
			preparacion.setInt(4, empleado.getNumeroJefe());
			preparacion.setDate(5, empleado.getFechaAntiguedad());
			preparacion.setDouble(6, empleado.getSalario());
			preparacion.setDouble(7, empleado.getComision());
			preparacion.setInt(8, empleado.getNumeroDepartamento());
			
			preparacion.executeUpdate();
			return 1;
		} catch (SQLException error) {
			codigoSql = error.getErrorCode();
		}
		return codigoSql;
	}
	public int actualizarSalario(int departamento, double porcentaje) {
		String actualizar = "UPDATE emp SET sal = sal * ? WHERE deptno = ?";
		
		try {
			PreparedStatement preparacion = conecta.prepareStatement(actualizar);
			preparacion.setDouble(1,porcentaje);
			preparacion.setInt(2, departamento);
			
			return preparacion.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int borrarEmpleado(int numero) {
		String eliminar = "DELETE FROM emp WHERE empno = ?";
		int codigoError;
		
		try {
			PreparedStatement preparacion = conecta.prepareStatement(eliminar);
			preparacion.setInt(1, numero);
			return preparacion.executeUpdate();
		} catch (SQLException e) {
			codigoError = e.getErrorCode();
		}
		return codigoError;
	}
}
