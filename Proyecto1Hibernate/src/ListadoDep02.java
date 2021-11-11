import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ListadoDep02 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		System.out.println("Datos del Departamento 10.");
		System.out.println("===========================");
		Departamentos dep = new Departamentos();
		dep=(Departamentos) session.load(Departamentos.class, (byte) 10);
		System.out.println("Nombre Dep: " + dep.getDnombre());
		System.out.println("Localidad: "+ dep.getLoc());
		session.close();
		System.exit(0);
	}

}
