import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransientPropertyValueException;
import org.hibernate.exception.ConstraintViolationException;

public class InsertaEmpleado01Rev01 {
	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Inserto un EMPLEADO EN EL DEPARTAMENTO 10.");

		Float salario = new Float(1500);
		Float comision = new Float(10); 

		Empleados em = new Empleados(); 
		em.setEmpNo((short) 4457); 
		em.setApellido("JORGE");
		em.setDir((short) 7499); 
		em.setOficio("VENDEDOR");
		em.setSalario(salario);
		em.setComision(comision);

		Departamentos d = new Departamentos(); 
		d.setDeptNo((byte) 99); 
		em.setDepartamentos(d);

		// fecha de alta
		java.util.Date hoy = new java.util.Date();
		java.sql.Date fecha = new java.sql.Date(hoy.getTime());
		em.setFechaAlt(fecha);

		session.save(em);
		try {
				tx.commit();
		} catch (ConstraintViolationException e) {
				// EMPLEADO REPETIDO O NO EXISTE EL DEPARTAMENTO
			    System.out.println("ERROR EN RESTRICCIONES (primaria o ajena)");
				System.out.printf("MENSAJE: %s%n", e.getMessage());
				// ERROR PROPIO MYSQL
				System.out.printf("COD ERROR DE MYSQL: %d%n", e.getErrorCode());
				System.out.printf("ERROR SQL: %s%n", e.getSQLException().getMessage());
				// ERROR ESTANDAR, MISMO PARA CUALQUIER GESTOR DE BASE DE DATOS
				// REALMENTE NO ME VALE PUES DOS ERRORES DISTINTOS (clave primaria o
				// (clave ajena) TIENEN ASIGNADO EL MISMO ERROR ESTANDAR!!!!! (23000)
				System.out.printf("ERROR SQL ESTANDAR: %s%n", e.getSQLException().getSQLState());
		}
		catch (Exception e) {
			System.out.println("ERROR NO CONTROLADO....");
			e.printStackTrace();
		}

		session.close();
		System.exit(0);
	}
}
