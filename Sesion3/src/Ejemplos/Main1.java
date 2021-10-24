package Ejemplos;

import java.sql.*;
// Alberto Carrera Martín - 20 de Marzo de 2020
// Demo de llamada a la función "totalEmpleados" almacenada en MySQL
// Esta función ya se encuentra también compilada en MySQL después de lanzar 
// el script "script_procedimientosMySQL.sql". De todas formas al final de esta clase
// se encuentra el código fuente de la misma


public class Main1 {
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
      // Creo la llamada a la función de manera muy parecida 
	  // a la empleada para sentencias preparadas
	  CallableStatement proc = conn.prepareCall("Select totalEmpleados(?) ");
      // Acoplamiento de variables: El ? de la línea anterior
	  // es un entero de valor 110
	   proc.setInt(1, 110); // Quiero saber el número empleados del departamento 110            
       // Ejecuto la llamada y recojo las filas resultantes 
	   // en un ResultSet. Realmente, solo una fila y una única columna 
	   // que contendrá  la cuenta de empleados de ese departamento
	   ResultSet rs=proc.executeQuery();
       //Declaro una variable donde recoger el valor de la columna
	   // (se puede hacer directamente sin esta variable)
	   int numero=0;
       if (rs.next()) {
    	   numero = rs.getInt(1);
           System.out.println("Número empleados Departamento 110 --> " + numero);
       }
       else
    	   System.out.println("No se recuperaron datos");
       rs.close();
    proc.close();   
	conn.close();
  } // de clase Main1.java
	
	/*
	 * CREATE FUNCTION totalEmpleados (p_departamento INTEGER)
    	RETURNS INTEGER
    	READS SQL DATA
	BEGIN
    	DECLARE v_num_total INTEGER;
    	SELECT COUNT(*)
    	INTO v_num_total
    	FROM empleados
    	WHERE numde=p_departamento;
    	RETURN(v_num_total);
	END $$
	 */
	
}
