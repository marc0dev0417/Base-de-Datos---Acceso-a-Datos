package Baloncesto;

public class Socio {

	private int socioID;
	private String nombre;
	private int estatura;
	private int edad;
	private String localidad;
	
	public Socio() {}
	public Socio(int id, String nombre, int estatura, int edad, String localidad) {
		socioID = id;
		this.nombre = nombre;
		this.estatura = estatura;
		this.edad = edad;
		this.localidad = localidad;
	}
	public int getSocioID() {
		return socioID;
	}
	public void setSocioID(int socioID) {
		this.socioID = socioID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstatura() {
		return estatura;
	}
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String toString() {
		return "Id: "+socioID+" Nombre: "+nombre+" Estatura "+estatura+" Edad: "+edad+" Localidad: "+localidad;
	}
}
