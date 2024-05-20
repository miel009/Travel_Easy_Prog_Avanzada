package Modelo;

public class Usuario extends Persona{
	private int id_ingresoSistema;

	
	
	public Usuario(String nombre, String apellido, int dni, int id_ingresoSistema) {
		super(nombre, apellido, dni);
		this.id_ingresoSistema = id_ingresoSistema;
	}
	

	public int getId_ingresoSistema() {
		return id_ingresoSistema;
	}



	public void setId_ingresoSistema(int id_ingresoSistema) {
		this.id_ingresoSistema = id_ingresoSistema;
	}
	
	@Override
	public String toString() {
		return "Usuario [id_ingresoSistema=" + id_ingresoSistema + "]";
	}


	public boolean ingresoSist(int id_ingresoSistema) {
		// determinar clave y validar
		// si entra como encargado de turismo o ventas que aparezca un mensaje "bienvenido X"
		return true;
		
	}

}
