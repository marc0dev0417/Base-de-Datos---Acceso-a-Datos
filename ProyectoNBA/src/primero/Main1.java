package primero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main1 {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Query q = session.createQuery("from Jugadores where codigo = :codigoJuga").setInteger("codigoJuga",225);
		
		List<Jugadores> lista = q.list();
		
		for (Jugadores j : lista) {
			System.out.println(j.getEquipos().getNombre());
			System.out.println(j.getNombre());
			System.out.println(j.getCodigo());
			
			Set<Estadisticas> listaEstadistica = j.getEstadisticases();
	
			System.out.println("Temporada\tPuntos\tAsis\tTap\tReb");
			for(Estadisticas e : listaEstadistica) {
				System.out.println(e.getId().getTemporada()+"\t\t"+e.getPuntosPorPartido()+"\t"+e.getAsistenciasPorPartido()+"\t"+e.getTaponesPorPartido()+"\t"+e.getRebotesPorPartido());
			}
		}
		
	}

}
