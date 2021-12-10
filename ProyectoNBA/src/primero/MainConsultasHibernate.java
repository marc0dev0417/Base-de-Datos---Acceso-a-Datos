package primero;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainConsultasHibernate {

	
	public static void insertarJugador(Jugadores jugador) {
		
		//SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		//Session session = sesion.openSession();
		
		//Transaction tx = session.beginTransaction();
		
		
		
		System.out.println(jugador.getNombre());
	}
	public static void main(String[] args) {
		
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		Query c = session.createQuery("from Equipos");
		
		List<Equipos> lista = c.list();
		
		for(Equipos e : lista) {
			Set<Jugadores> listaJuga = e.getJugadoreses();
			System.out.println("------------"+e.getNombre()+"---------------");
				for(Jugadores j : listaJuga) {
					Set<Estadisticas> listaEsta = j.getEstadisticases();
					double contador = 0;
					double suma = 0;
					System.out.println("=================");
					System.out.println("\t"+j.getNombre());
					for (Estadisticas est : listaEsta) {
						suma += est.getPuntosPorPartido();
						contador++;
						
						//System.out.println("\t\t"+est.getPuntosPorPartido());
					}
					System.out.println("\t"+(suma / contador));
				}
		}
	}

}
