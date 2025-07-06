package Modelo;

import java.util.List;

import javax.swing.JOptionPane;

import Controlador.UsuarioControlador;

public class Usuario extends Persona {
	
	private int id_usuario;
	private String email;
	private String contrasena;
	
	public Usuario(int id_usuario, int id_persona, String nombre, String apellido, int dni, String email, String contrasena) {
	        super(id_persona, nombre, apellido, dni);
	        this.id_usuario = id_usuario;
	        this.email = email;
	        this.contrasena = contrasena;
	}
	
	// Constructor para login
	public Usuario(String email, String contrasena) {
	    super(0, "", "", 0);
	    this.email = email;
	    this.contrasena = contrasena;
	    
	}

	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + getNombre() + ", email=" + email + ", contrasena="
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


	public static String Ingresar(String email, String contrasena) {
	    if (email.isBlank()) {
	        return "Intente ingresar el email otra vez";
	    } else if (contrasena.isBlank()) {
	        return "Intente ingresar la contraseña otra vez";
	    } else {
	    	  UsuarioControlador controlador = new UsuarioControlador();
	          Usuario usuario = controlador.verificarUsuario(email, contrasena);
	    	  if (usuario != null) {
	              return "Ingreso con exito!";
	          } else {
	              return "No se encontró ningún usuario con los datos proporcionados";
	          }
	    }
	}
}
