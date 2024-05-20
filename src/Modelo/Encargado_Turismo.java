package Modelo;
import Vista.Mostrar_Destinos;

class Encargado_Turismo extends Usuario implements Mostrar_Destinos, 
	Mostrar_Paquetes, ObtenerDestinoPor_id {

	private Destino destino;
	private Paquete paquete;
	private Servicio_ad servicio_ad;
	

	public Encargado_Turismo(String nombre, String apellido, int dni, int id_ingresoSistema, Destino destino,
			Paquete paquete, Servicio_ad servicio_ad) {
		super(nombre, apellido, dni, id_ingresoSistema);
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


	public Paquete agregarPaquete(){
		//CREACION DE PAQUETE , CON TODAS SUS CARACTERISTICAS
		return paquete;
	}	
	public void eliminarPaquete(){
	
	}
	
	
	
	public Destino agregarDestino(){
		//CREACION DE DESTINO , CON TODAS SUS CARACTERISTICAS
		return destino;
	}	
	
	public void eliminarDestino( Destino destino) {
		
	}
	
	public void agregarServicio( Destino destino) {
		
	}
    public void eliminarServicio( Destino destino) {
		
	}
    public void Modificaciones( Destino destino) {
		// SUB MENU PARA SELECCIONAR QUE MODIFICAR
	}
	
	
	

}
