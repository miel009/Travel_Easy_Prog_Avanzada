package Modelo;

import Interfaces.Mostrar_Destinos;
import Interfaces.Mostrar_Paquetes;

public class Encargado_Vtas extends Usuario {
	
	private int id_vta;

	public Encargado_Vtas(String nombre, String apellido, int dni, int id_ingresoSistema, int id_usuario, int id_vta) {
		super(nombre, apellido, dni, id_ingresoSistema, id_usuario);
		this.id_vta = id_vta;
	}

	public int getId_vta() {
		return id_vta;
	}

	public void setId_vta(int id_vta) {
		this.id_vta = id_vta;
	}


}
