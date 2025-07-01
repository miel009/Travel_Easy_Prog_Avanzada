package Modelo;

import javax.swing.JOptionPane;

import Controlador.UsuarioControlador;

public class Usuario extends Persona {
	
	private int id_usuario;
	private String email;
	private String contrasena;
	private Persona Persona;
	

// al hacer funcionalidad de registro de nuevo usuario: - usar herencia persona->usuario

	


	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	


	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", email=" + email + ", contrasena="
				+ contrasena + "]";
	}


	public static boolean ValidarIngresoEmpleado(String cadena) {
    	    boolean flag = false;

    	    if (cadena.equalsIgnoreCase("EmpleadoT") || cadena.equalsIgnoreCase("EmpleadoV")) {
    	        flag = true;
    	    } else {
    	        JOptionPane.showMessageDialog(null, "Error, ingreso no válido. Ingrese con su contrasena personal");
    	    }

    	    return flag;
    	}


	public static String Ingresar(String nombre, String email,  String contrasena) {
    	    
		if (nombre.isBlank() ) {
			return "Intente ingresar el nombre otra vez";
							
			} else {
			if (email.isBlank()) {
				return "Intente ingresar el email otra vez";
			} else {									
				
	
    	    UsuarioControlador controlador = new UsuarioControlador();
    	    if (controlador.getAllUsers().isEmpty()) {
    	    	return  "No hay usuarios con los datos proporcionados";
				
			} else {
				
	    	    for ( Usuario usuario : controlador.getAllUsers()) {
					if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getEmail().equalsIgnoreCase(email) && usuario.getContrasena().equalsIgnoreCase(contrasena) ) {
						return "Ingreso con exito!";
				    	
					}
				}
			}
    	    return "No se encontro resultados";
	}  
			} } 
}
