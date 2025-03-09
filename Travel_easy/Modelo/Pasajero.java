package Modelo;

public class Pasajero extends Persona{
	 
	private String email;
	private int edad; 
	private boolean c_especial; 
	
	public Pasajero(String nombre, String apellido, int dni, String email, int edad, boolean c_especial) {
		super(nombre, apellido, dni);
		this.email = email;
		this.edad = edad;
		this.c_especial = c_especial;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isC_especial() {
		return c_especial;
	}
	public void setC_especial(boolean c_especial) {
		this.c_especial = c_especial;
	}
	@Override
	public String toString() {
		return "Pasajero [email=" + email + ", edad=" + edad + ", c_especial=" + c_especial + "]";
	}

}
