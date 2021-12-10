package primero;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void ejercicio2A() {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Estadisticas est = new Estadisticas();
		
		Query query = session.createQuery("from estadisticas est join jugadores on est.jugador = jugadores.codigo where jugadores.codigo = :numJugador");
		query.setInteger("numJugador", (int)227);
		
		List<Estadisticas> lista = query.list();
		
		for(Estadisticas e : lista) {
			System.out.println(e.getAsistenciasPorPartido()+" "+e.getPuntosPorPartido());
		}
	}
	
	public static void main(String[] args) {

		ejercicio2A();
		
	}

}
