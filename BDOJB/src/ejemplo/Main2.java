package ejemplo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {

	public static void main(String[] args) throws ParseException {
        
		AccesoBdatos abd = new AccesoBdatos();
		abd.conectar();
	//	abd.imprimirDepartamento(90);
	//	abd.imprimirDepartamento(40);
	//	abd.imprimirDepartamento(10);
		
    //  System.out.println(abd.insertarDepartamento(new DepartamentoEntity(60,"Recursos Humanos", "Chimillas")));
    //  System.out.println(abd.insertarDepartamento(new DepartamentoEntity(60,"Recursos Humanos", "Chimillas")));
    //  abd.imprimirDepartamento(60);
		
	//	System.out.println(abd.modificarDepartamento(new DepartamentoEntity(88,"RRHH", "Huerrios")));
	//	System.out.println(abd.modificarDepartamento(new DepartamentoEntity(60,"RRHH", "Esquedas")));
	//	abd.imprimirDepartamento(60);
		
	//	abd.borrarDepartamento(88); // false no existe
	//	abd.borrarDepartamento(60); // true
	//	abd.borrarDepartamento(10); // false pues tiene empleados
		
	//	abd.imprimirDepartamento(10);
	
	abd.demoJPQL();
		
		abd.desconectar();
	

	}

}

