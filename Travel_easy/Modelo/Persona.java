package Modelo;

public abstract class Persona {

  private int id_persona;
  private String nombre;
  private String apellido;
  private int dni;
 
 
public Persona(int id_persona , String nombre, String apellido, int dni) {
	super();
	this.id_persona = id_persona; 
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
}


public int getId_persona() {
	return id_persona;
}

public void setId_persona(int id_persona) {
	this.id_persona = id_persona;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getDni() {
	return dni;
}
public void setDni(int dni) {
	this.dni = dni;
}
@Override
public String toString() {
	return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
}

}
