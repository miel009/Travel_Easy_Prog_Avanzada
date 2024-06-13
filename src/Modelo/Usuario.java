package Modelo;

import javax.swing.JOptionPane;

import Controlador.UsuarioControlador;

public class Usuario {
	
	private int id_usuario;
	private String nombre;
	private String email;
	private String contrasena;
	



	public Usuario(int id_usuario, String nombre, String email, String contrasena) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
	}

	
	public Usuario() {
		
	}




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
