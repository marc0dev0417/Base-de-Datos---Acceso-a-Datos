package ejemplo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

//
//Alberto Carrera Martín - Abril 2020
//

@Entity
public class EmpleadoEntity {
	@Id
	private int empnoId;
	private String nombre;
	private String oficio;
	private EmpleadoEntity dirId;
	private Date alta;
	private Integer salario;
	private Integer comision;
	@ManyToOne
		private DepartamentoEntity departamento;
	//
	public EmpleadoEntity(int empnoId, String nombre, String oficio, EmpleadoEntity dirId, Date alta, Integer salario,
			Integer comision, DepartamentoEntity departamento) {
		
		this.empnoId = empnoId;
		this.nombre = nombre;
		this.oficio = oficio;
		this.dirId = dirId;
		this.alta = alta;
		this.salario = salario;
		this.comision = comision;
		this.departamento = departamento;
	}
	//
	public int getEmpnoId() {
		return empnoId;
	}
	public void setEmpnoId(int empnoId) {
		this.empnoId = empnoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public EmpleadoEntity getDirId() {
		return dirId;
	}
	public void setDirId(EmpleadoEntity dirId) {
		this.dirId = dirId;
	}
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public Integer getSalario() {
		return salario;
	}
	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	public Integer getComision() {
		return comision;
	}
	public void setComision(Integer comision) {
		this.comision = comision;
	}
	public DepartamentoEntity getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoEntity departamento) {
		this.departamento = departamento;
	}
	
}
