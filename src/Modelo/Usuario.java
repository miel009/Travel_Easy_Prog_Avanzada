package Modelo;

import javax.swing.JOptionPane;

public class Usuario extends Persona{
	private int id_ingresoSistema;
	private int id_usuario;




	public Usuario(String nombre, String apellido, int dni, int id_ingresoSistema, int id_usuario) {
		super(nombre, apellido, dni);
		this.id_ingresoSistema = id_ingresoSistema;
		this.id_usuario = id_usuario;
	}
	
	

	public int getId_ingresoSistema() {
		return id_ingresoSistema;
	}


	public void setId_ingresoSistema(int id_ingresoSistema) {
		this.id_ingresoSistema = id_ingresoSistema;
	}





	public int getId_usuario() {
		return id_usuario;
	}





	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}



	@Override
	public String toString() {
		return "Usuario [id_ingresoSistema=" + id_ingresoSistema + ", id_usuario=" + id_usuario + "]";
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



}
