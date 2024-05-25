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



	public boolean ingresoSist(int id_ingresoSistema) {
		
		//int ingresoCont = Integer.parseInt(JOptionPane.showInputDialog("ingrese"));
		
		if(id_ingresoSistema == 9999) {
		
			JOptionPane.showMessageDialog(null,"BIENVENIDO");
			return true;
		} else {
			JOptionPane.showMessageDialog(null,"error");	
		}
		
		// determinar clave y validar
		// si entra como encargado de turismo o ventas que aparezca un mensaje "bienvenido X"
		return true;
		
	}
	
	
	
	// VALIDACION LETRAS Y NUM 
	public static boolean ValidarNumeros(String cadena){
		
		boolean flag=true;
		for (int i = 0; i < cadena.length(); i++) {
			if (!Character.isDigit(cadena.charAt(i))) {
				flag=false;
			}
		}
		if (flag==false) {
			JOptionPane.showMessageDialog(null, "Error al ingresar numero, ingrese de nuevo");
		} else {
			if(Integer.parseInt(cadena)<0){
				JOptionPane.showMessageDialog(null, "Error, no puede agregarse. vuelva a ingresar ");
		}
			
		}
		
		return flag;
	}
     public static boolean ValidarLetras(String cadena){
		
		boolean flag=true;
		for (int i = 0; i < cadena.length(); i++) {
			if (!Character.isAlphabetic(cadena.charAt(i))) {
				flag=false;
			}
		}
		if (flag==false) {
			JOptionPane.showMessageDialog(null, "Error, ingrese de nuevo");
		} else {
			if(cadena.isEmpty()== true){
				JOptionPane.showMessageDialog(null, "Error,por favor ingrese otra vez");
		}
			
		}
		
		return flag;
	}

}
