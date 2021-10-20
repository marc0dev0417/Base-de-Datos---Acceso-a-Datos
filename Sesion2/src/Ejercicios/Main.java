package Ejercicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {

		AccesoBaseDatos bd = new AccesoBaseDatos();
		
		bd.conectar();
		
		/*
		System.out.println(bd.busquedaPorCodigo(100));
		System.out.println("");
		System.out.println(bd.busquedaPorCodigo(7788));
		*/
		System.out.println(bd.busquedaPorOficio("Profesor"));
		System.out.println("");
		System.out.println(bd.busquedaPorOficio("CLERK"));
		System.out.println("");
		System.out.println("");
		
		System.out.println("Empleados contratados antes del 22 de febrero de 1981");
		System.out.println("=====================================================");
		
		java.util.Date fecha = null;
		java.sql.Date sqlFecha = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			fecha = sdf.parse("1981/02/22");
			sqlFecha = new java.sql.Date(fecha.getTime());
			} catch (ParseException e) {
			System.out.println("Error al convertir fecha");
			}	
		System.out.println(bd.busquedaPorAntiguedad(sqlFecha));
		System.out.println("");
		System.out.println("");
		
		java.util.Date fechaBean = null;
		java.sql.Date sqlFechaBean = null;
		SimpleDateFormat sdfBean = new SimpleDateFormat("yyyy/MM/dd");
		try {
		fechaBean = sdfBean.parse("2020/03/18");
		sqlFechaBean = new java.sql.Date(fechaBean.getTime());
		} catch (ParseException e) {
		System.out.println("Error al convertir fecha");
		}
		Empleado e1 = new Empleado(1, "CARRERA", "PROFESOR", 7788, sqlFechaBean, 700, 0, 20);
		Empleado e2 = new Empleado(10, "CARRERA", "FOL", 7788, sqlFecha, 700, 0, 35);
		System.out.println(bd.insertarConBean(e1)); // 1 (y se inserta en la tabla)
		//Repito la misma instrucción:
		System.out.println(bd.insertarConBean(e1));
		// 1062, ya existe un registro con esa clave!!!!
		System.out.println(bd.insertarConBean(e2));
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Subir un 20% el salario de los empleados del Departamento 30");
		System.out.println(bd.actualizarSalario(30, 0.2)); //6
		//
		System.out.println("Subir un 15% el salario de los empleados del Departamento 44");
		System.out.println(bd.actualizarSalario(44, 0.15));//0
		// No existe el departamento 44
		
		System.out.println("");
		System.out.println("");
		
		System.out.println(bd.borrarEmpleado(1));
		//1 - Se ha borrado el empleado de código 1 de la tabla
		System.out.println(bd.borrarEmpleado(99));
		//0 – No se ha borrado ninguno pues no existe el empleado 99
		System.out.println(bd.borrarEmpleado(7839));
		//1 – Se ha borrado el empleado 7839.
	}
	
}
