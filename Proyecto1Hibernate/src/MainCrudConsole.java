import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Departamentos;
import primero.SessionFactoryUtil;

public class MainCrudConsole {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		System.out.println("Datos del Departamento 10");
		System.out.println("==========================");
		Departamentos departamento = new Departamentos();
		
		departamento = (Departamentos)session.load(Departamentos.class, (byte) 10);
		System.out.println("Nombre departamento => "+departamento.getDnombre());
		System.out.println("Localidad departamento => "+departamento.getLoc());
		session.close();
		System.exit(0);
	}
}
