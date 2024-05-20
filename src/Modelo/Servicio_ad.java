package Modelo;

public class Servicio_ad {
	 private String alquilerAuto;
	 private String asistenciaPersonalizada;
	 private  int precio;
	public Servicio_ad(String alquilerAuto, String asistenciaPersonalizada, int precio) {
		super();
		this.alquilerAuto = alquilerAuto;
		this.asistenciaPersonalizada = asistenciaPersonalizada;
		this.precio = precio;
	}
	public String getAlquilerAuto() {
		return alquilerAuto;
	}
	public void setAlquilerAuto(String alquilerAuto) {
		this.alquilerAuto = alquilerAuto;
	}
	public String getAsistenciaPersonalizada() {
		return asistenciaPersonalizada;
	}
	public void setAsistenciaPersonalizada(String asistenciaPersonalizada) {
		this.asistenciaPersonalizada = asistenciaPersonalizada;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Servicio_ad [alquilerAuto=" + alquilerAuto + ", asistenciaPersonalizada=" + asistenciaPersonalizada
				+ ", precio=" + precio + "]";
	}
	 
}
