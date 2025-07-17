package Modelo;

import java.util.Date;
import java.util.List;

public class Reserva {

	 private int id;
	    private String nombre;
	    private String apellido;
	    private int cantidadPersonas;
	    private Paquete paquete;
	    
		public Reserva(int id, String nombre, String apellido, int cantidadPersonas, Paquete paquete) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.cantidadPersonas = cantidadPersonas;
			this.paquete = paquete;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public int getCantidadPersonas() {
			return cantidadPersonas;
		}
		public void setCantidadPersonas(int cantidadPersonas) {
			this.cantidadPersonas = cantidadPersonas;
		}
		public Paquete getPaquete() {
			return paquete;
		}
		public void setPaquete(Paquete paquete) {
			this.paquete = paquete;
		}
    
		public Reserva() {
		    // constructor para la vista
			
		}

}
