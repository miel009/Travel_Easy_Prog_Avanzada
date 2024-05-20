package Modelo;

public class Paquete {
	private int id_paquete;
	private String descripcion;
	private String tipo_turismo;
	private double precio;
	private Destino destino;
	private Servicio_ad servicio_paquete;
	
	public Paquete(int id_paquete, String descripcion, String tipo_turismo, double precio, Destino destino,
			Servicio_ad servicio_paquete) {
		super();
		this.id_paquete = id_paquete;
		this.descripcion = descripcion;
		this.tipo_turismo = tipo_turismo;
		this.precio = precio;
		this.destino = destino;
		this.servicio_paquete = servicio_paquete;
		
	}
	public Paquete() {
	// PARA USO DE SINGLETON
	}

	public int getId_paquete() {
		return id_paquete;
	}

	public void setId_paquete(int id_paquete) {
		this.id_paquete = id_paquete;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo_turismo() {
		return tipo_turismo;
	}

	public void setTipo_turismo(String tipo_turismo) {
		this.tipo_turismo = tipo_turismo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Servicio_ad getServicio_paquete() {
		return servicio_paquete;
	}

	public void setServicio_paquete(Servicio_ad servicio_paquete) {
		this.servicio_paquete = servicio_paquete;
	}

	@Override
	public String toString() {
		return "Paquete [id_paquete=" + id_paquete + ", descripcion=" + descripcion + ", tipo_turismo=" + tipo_turismo
				+ ", precio=" + precio + ", destino=" + destino + ", servicio_paquete=" + servicio_paquete + "]";
	}
	
	
	
	
}
