package ejemplo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws ParseException {

		BaseDatos bd = new BaseDatos();
		
		bd.conectar();
		//bd.empleadoNombreAlta();
		//bd.empleadoApellido("carrera");
		//bd.empleadoPorDepartamento("i+d", "empleado");

	//	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		//bd.empleadoContratatadosFechaSuperior(formato.parse("2003-02-24"));
		
		//bd.empleadosOrdenadosPorDepartamento();
		
		/*
		bd.departamentosConEmpleados();
		System.out.println("\n");
		System.out.println("departamentos con más de 5 empleados");
		bd.departamentosConEmpleadosMayorCinco();
		*/
		//bd.empleadoJefe();
		//bd.departamentoEmpleado();
		//bd.departamentoEmpleadoTodos();
		//bd.empleadoDepartamentosOrdenados();
		//bd.empleadoSinJefe();
		bd.empleadoNumeroDepartamento(1039);
		bd.desconectar();
		
		
	}

}
