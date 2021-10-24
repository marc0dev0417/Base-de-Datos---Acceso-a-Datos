package Ejemplos;

import java.sql.*;
// Alberto Carrera Martín - 20 de Marzo de 2020
// Demo de llamada al procedimiento  jefeyPresupuesto almacenado en MySQL
// Este procedimiento ya se encuentra también compilado en MySQL después de lanzar 
// el script "script_procedimientosMySQL.sql". De todas formas al final de esta clase
// se encuentra el código fuente del mismo

public class Main2 {
	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "procedimientos";
    private static String hostname = "localhost";
    private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database +
									"?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "rootroot";
 
  	
	public static void main(String[] args) 
     throws ClassNotFoundException, SQLException {
	   Class.forName(driver);
	   Connection conn = DriverManager.getConnection(url, username, password);	
	   // Creo la llamada al procedimiento de manera muy parecida 
	   // a la empleada para sentencias preparadas
	   CallableStatement proc = conn.prepareCall(" CALL jefeyPresupuesto(?,?,?) ");
       // Acoplamiento de variables
	   // El primer dato ? es un entero y le asigno el valor 120
	   proc.setInt(1, 120); // Quiero saber el director y presupuesto departamento 120
       // El segundo dato ? es un entero y además un parámetro de salida, de tipo OUT
	   proc.registerOutParameter(2, Types.INTEGER);
       // El tercer dato ? es también un entero y de salida como el anterior
	   proc.registerOutParameter(3, Types.INTEGER);
       // Ejecuto el procedimiento
	   proc.execute();            
       System.out.println("Presupuesto y Director del departamento 120:");
       // Imprimo el 2º y 3º parámetro de salida
       System.out.println(proc.getInt(2) + " - " + proc.getInt(3));
    proc.close();   
	conn.close();
  }
	/*
	 CREATE PROCEDURE jefeyPresupuesto (IN departamento INTEGER,
                               OUT director INTEGER,
                               OUT presupuesto INTEGER)
	BEGIN
     SELECT direc, presu
       INTO director, presupuesto
      FROM departamentos
      WHERE numde = departamento;
	END $$
	 */
}// de Main2
