package ejemplo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class BaseDatos {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void conectar() {
		emf = Persistence.createEntityManagerFactory("db/empleados.odb");
		em = emf.createEntityManager();
	}
	public void desconectar() {
		em.close();
		emf.close();
	}
	
	public void empleadoNombreAlta() {
		Query consulta = em.createQuery("select e from EmpleadoEntity e");
		
		List<EmpleadoEntity> listaEmpleados = consulta.getResultList();
		
		//listaEmpleados.sort(Comparator.comparing(EmpleadoEntity :: getNombre));
		
		for(EmpleadoEntity e : listaEmpleados) {
			System.out.println(e.getNombre()+" - "+e.getAlta());
		}
	}
	public void empleadoApellido(String apellido) {
		Query consulta = em.createQuery("select e from EmpleadoEntity e");
		
		List<EmpleadoEntity> listaEmpleados = consulta.getResultList();
		
		for(EmpleadoEntity e : listaEmpleados) {
			if(e.getNombre().toLowerCase().contains(apellido.toLowerCase())) {
				System.out.println(e.getNombre()+" - "+e.getAlta());
			}
		}
	}
	public void empleadoPorDepartamento(String nombreDepartamento, String oficio) {
		
		String oficioFormateado = String.valueOf(oficio.charAt(0)).toUpperCase()+oficio.substring(1);
		
		Query consulta = em.createQuery("select e from EmpleadoEntity e where e.oficio = :oficio");
		consulta.setParameter("oficio", oficioFormateado);
		
		List<EmpleadoEntity> listaEmpleados = consulta.getResultList();
		
		for(EmpleadoEntity e : listaEmpleados) {
			if(e.getDepartamento().getNombre().toLowerCase().equals(nombreDepartamento.toLowerCase())) {
				System.out.println(e.getNombre()+" - "+e.getOficio()+" - "+e.getDepartamento().getNombre());
			}
		}
	}
	public void empleadoContratatadosFechaSuperior(Date fecha) {
		
		Query consulta = em.createQuery("select e from EmpleadoEntity e where e.alta >= :fecha");
		consulta.setParameter("fecha", fecha);
		List<EmpleadoEntity> listaEmpleado = consulta.getResultList();
		
		for(EmpleadoEntity e : listaEmpleado) {
			System.out.println(e.getNombre()+" - "+e.getAlta());
		}
	}
	public void empleadosOrdenadosPorDepartamento() {
		Query consulta = em.createQuery("select e from EmpleadoEntity e order by e.departamento.nombre");
		
		List<EmpleadoEntity> listaEmpleado = consulta.getResultList();
		
		for(EmpleadoEntity e : listaEmpleado) {
			System.out.println(e.getDepartamento().getNombre()+" - "+e.getNombre());
		}
	}
	public void departamentosConEmpleados() {
		Query consulta = em.createQuery("select d from DepartamentoEntity d order by d.nombre");
		
		List<DepartamentoEntity> listaDepartamento = consulta.getResultList();
		
		
			for (DepartamentoEntity d : listaDepartamento) {
				int maximoSalario = 0;
				int numeroTotalEmpleados = 0;
				int totalSalario = 0;
				
				if(!d.getEmpleados().isEmpty()) {
					System.out.print(d.getNombre()+" - ");
					Set<EmpleadoEntity> listaEmpleados = d.getEmpleados();
					
					for(EmpleadoEntity e : listaEmpleados) {
						numeroTotalEmpleados++;
						totalSalario += e.getSalario();
						
						if(e.getSalario() >= maximoSalario) {
							maximoSalario = e.getSalario();
						}
					}
					System.out.print(numeroTotalEmpleados+" - "+totalSalario+" - "+maximoSalario+"\n");
				}
			}
	}
	public void departamentosConEmpleadosMayorCinco() {
		Query consulta = em.createQuery("select d from DepartamentoEntity d order by d.nombre");
		
		List<DepartamentoEntity> listaDepartamento = consulta.getResultList();
		
			for (DepartamentoEntity d : listaDepartamento) {
				int numeroTotalEmpleados = 0;
				int totalSalario = 0;
				int maximoSalario = 0;
				
				if(!d.getEmpleados().isEmpty()) {
					
					Set<EmpleadoEntity> listaEmpleados = d.getEmpleados();
					
					for(EmpleadoEntity e : listaEmpleados) {
						numeroTotalEmpleados++;
						totalSalario += e.getSalario();
						
						if(e.getSalario() > maximoSalario) {
							maximoSalario = e.getSalario();
						}
					}
					if(numeroTotalEmpleados >= 5) {
						System.out.print(d.getNombre()+" - ");
					System.out.print(numeroTotalEmpleados+" - "+totalSalario+" - "+maximoSalario+"\n");
				}
			}
		}
	}
	public void empleadoJefe() {
		Query consulta = em.createQuery("select e from EmpleadoEntity e");
		
		List<EmpleadoEntity> listaEmpleados = consulta.getResultList();
		
		for(EmpleadoEntity e : listaEmpleados) {
			if(e.getDirId() != null) {
			System.out.println(e.getNombre()+" "+"su jefe es -> "+e.getDirId().getNombre());
			}
		}
	}
	public void departamentoEmpleado() {
	Query consulta = em.createQuery("select d from DepartamentoEntity d order by d.nombre");
		
		List<DepartamentoEntity> listaDepartamento = consulta.getResultList();
		
			for (DepartamentoEntity d : listaDepartamento) {
				int numeroTotalEmpleados = 0;
				
				if(!d.getEmpleados().isEmpty()) {
					System.out.print(d.getNombre()+" - ");
					Set<EmpleadoEntity> listaEmpleados = d.getEmpleados();
					
					for(EmpleadoEntity e : listaEmpleados) {
						numeroTotalEmpleados++;
					}
					System.out.print(numeroTotalEmpleados+"\n");
				}
			}
	}
	public void departamentoEmpleadoTodos() {
		Query consulta = em.createQuery("select d from DepartamentoEntity d order by d.nombre");
			
			List<DepartamentoEntity> listaDepartamento = consulta.getResultList();
			
				for (DepartamentoEntity d : listaDepartamento) {
					int numeroTotalEmpleados = 0;
			
						System.out.print(d.getNombre()+" - ");
						Set<EmpleadoEntity> listaEmpleados = d.getEmpleados();
						
						for(EmpleadoEntity e : listaEmpleados) {
							numeroTotalEmpleados++;
						}
						System.out.print(numeroTotalEmpleados+"\n");
					}
				}
	public void empleadoDepartamentosOrdenados() {
		Query consulta = em.createQuery("select e from EmpleadoEntity e order by e.departamento.dptoId desc, e.salario asc");
		
		List<EmpleadoEntity> listaEmpleados = consulta.getResultList();
		
		for(EmpleadoEntity e : listaEmpleados) {
			System.out.println(e.getDepartamento().getDptoId()+" - "+e.getNombre()+" - "+e.getSalario());
		}
	}
	public void empleadoSinJefe() {
		Query consulta = em.createQuery("select e from EmpleadoEntity e");
		
		List<EmpleadoEntity> listaEmpleados = consulta.getResultList();
		
		for(EmpleadoEntity e : listaEmpleados) {
			if(e.getDirId() == null) {
				System.out.println(e.getEmpnoId()+" - "+e.getNombre());
			}
		}
	}
	public void empleadoNumeroDepartamento(int noEmpleado) {
		Query consulta = em.createQuery("select e from EmpleadoEntity e");
		
		List<EmpleadoEntity> listaEmpleado = consulta.getResultList();
		
		for(EmpleadoEntity e : listaEmpleado) {
			if(e.getEmpnoId() == noEmpleado) {
				System.out.println(e.getDepartamento().getDptoId()+" - "+e.getDepartamento().getNombre());
			}
		}
	}
	//Me haran falta transacciones...
	public int incrementarSalario(int salario) {
		
		em.getTransaction().begin();
		Query actualizar = em.createQuery("update EmpleadoEntity e set e.salario = e.salario + :salario");
		//formula => 200*(1+(10/100))

		actualizar.setParameter("salario", salario);
	
		int filasActualizadas = actualizar.executeUpdate();
		em.getTransaction().commit();
		
		return filasActualizadas;
	}
	public int incrementarSalarioPorOficio(String oficio, int cantidad) {
		em.getTransaction().begin();
		Query actualizar = em.createQuery("update EmpleadoEntity e set e.salario = e.salario + :cantidad where e.oficio = :oficio");
		
		oficio = String.valueOf(oficio.charAt(0)).toUpperCase()+oficio.substring(1);
		
		actualizar.setParameter("cantidad", cantidad);
		actualizar.setParameter("oficio", oficio);
		
		int filasActualizadas = actualizar.executeUpdate();
		
		em.getTransaction().commit();
		
		return filasActualizadas;
	}
	public int incrementarSalarioDepartamento(int noDept, int cantidad) {
		em.getTransaction().begin();
		Query actualizar = em.createQuery("update EmpleadoEntity e set e.salario = e.salario + :cantidad where e.departamento.getDptoId() = :noDept");
		
		actualizar.setParameter("cantidad", cantidad);
		actualizar.setParameter("noDept", noDept);
		
		int filasActualizadas = actualizar.executeUpdate();
		
		em.getTransaction().commit();
		
		return filasActualizadas;
	}
	public int borrarEmpleado(int numeroEmpleado) {
		em.getTransaction().begin();
		Query consulta = em.createQuery("delete from EmpleadoEntity e where e.empnoId = :numeroEmpleado");
		
		consulta.setParameter("numeroEmpleado", numeroEmpleado);
		
		int filasBorradas = consulta.executeUpdate();
		
		em.getTransaction().commit();
		
		return filasBorradas;
	}
	public int borrarDepartamento(int numeroDepartamento) {
		
		em.getTransaction().begin();
		Query borrar = em.createQuery("delete from DepartamentoEntity d where d.dptoId = :numeroDepartamento");
		
		borrar.setParameter("numeroDepartamento", numeroDepartamento);
		
		int filasBorradas = borrar.executeUpdate();
		
		em.getTransaction().commit();
		
		return filasBorradas;
	}
	public void consultaEmpleadoBorrado(int numeroEmpleado) {
		Query c = em.createQuery("select e from EmpleadoEntity e where e.empnoId = :numeroEmpleado");
		c.setParameter("numeroEmpleado", numeroEmpleado);
		
		List<EmpleadoEntity> lista = c.getResultList();
		
		if(lista.isEmpty()) {
			System.out.println("No existe el empleado");
		}else {
		System.out.println(lista.get(0).getNombre());
		}
	}
}
