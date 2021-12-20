package ejemplo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//
//Alberto Carrera Martín - Abril 2020
//
@Entity
public class DepartamentoEntity {
	@Id
	private int dptoId;
	private String nombre;
	private String localidad;
	@OneToMany(mappedBy="departamento")
		private Set<EmpleadoEntity> empleados = new HashSet<EmpleadoEntity>();
	//
	public DepartamentoEntity(int dptoId, String nombre, String localidad) {

		this.dptoId = dptoId;
		this.nombre = nombre;
		this.localidad = localidad;

	}
	//
	public int getDptoId() {
		return dptoId;
	}
	public void setDptoId(int dptoId) {
		this.dptoId = dptoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Set<EmpleadoEntity> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<EmpleadoEntity> empleados) {
		this.empleados = empleados;
	}
	@Override
	public String toString() {
		return "DepartamentoEntity [dptoId=" + dptoId + ", nombre=" + nombre + ", localidad=" + localidad
				+ ", empleados=" + empleados + "]";
	}
	
	
}
