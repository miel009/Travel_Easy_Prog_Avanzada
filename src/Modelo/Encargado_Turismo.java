package Modelo;

import Interfaces.Mostrar_Destinos;
import Interfaces.Mostrar_Paquetes;


class Encargado_Turismo extends Usuario {

	private Destino destino;
	private Paquete paquete;
	private Servicio_ad servicio_ad;
	

	
	public Encargado_Turismo(String nombre, String apellido, int dni, int id_ingresoSistema, int id_usuario,
			Destino destino, Paquete paquete, Servicio_ad servicio_ad) {
		super(nombre, apellido, dni, id_ingresoSistema, id_usuario);
		this.destino = destino;
		this.paquete = paquete;
		this.servicio_ad = servicio_ad;
	}
	
	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Servicio_ad getServicio_ad() {
		return servicio_ad;
	}

	public void setServicio_ad(Servicio_ad servicio_ad) {
		this.servicio_ad = servicio_ad;
	}
	
	
	
	
	
	

}
