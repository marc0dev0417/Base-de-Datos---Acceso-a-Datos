package Ejercicios;

public class Empleado {

	private int numeroEmpleado;
	private String nombreEmpleado;
	private String oficio;
	private int numeroJefe;
	private java.sql.Date fechaAntiguedad;
	private double salario;
	private double comision;
	private int numeroDepartamento;
	
	public Empleado() {}
	public Empleado(int numEmp, String n, String o, int numJefe, java.sql.Date ant, double sal, double com, int numDept){
		
		numeroEmpleado = numEmp;
		nombreEmpleado = n;
		oficio = o;
		numeroJefe = numJefe;
		fechaAntiguedad = ant;
		salario = sal;
		comision = com;
		numeroDepartamento = numDept;
	}
	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public int getNumeroJefe() {
		return numeroJefe;
	}
	public void setNumeroJefe(int numeroJefe) {
		this.numeroJefe = numeroJefe;
	}
	public java.sql.Date getFechaAntiguedad() {
		return fechaAntiguedad;
	}
	public void setFechaAntiguedad(java.sql.Date fechaAntiguedad) {
		this.fechaAntiguedad = fechaAntiguedad;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public int getNumeroDepartamento() {
		return numeroDepartamento;
	}
	public void setNumeroDepartamento(int numeroDepartamento) {
		this.numeroDepartamento = numeroDepartamento;
	}
	@Override
	public String toString() {
		return "Empleado numeroEmpleado=" + numeroEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", oficio="
				+ oficio + ", numeroJefe=" + numeroJefe + ", fechaAntiguedad=" + fechaAntiguedad + ", salario="
				+ salario + ", comision=" + comision + ", numeroDepartamento=" + numeroDepartamento + "\n";
	}
	
}
