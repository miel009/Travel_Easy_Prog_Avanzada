package Modelo;

import javax.swing.JOptionPane;

public class Servicio_ad {
	
	 private int id_servicio;
	 private String alquilerAuto;
	 private String asistenciaPersonalizada;
	 private  int precio;
	 public Servicio_ad( String alquilerAuto, String asistenciaPersonalizada, int precio) {
		super();
		
		this.alquilerAuto = alquilerAuto;
		this.asistenciaPersonalizada = asistenciaPersonalizada;
		this.precio = precio;
	}
	public Servicio_ad() {
		
	}	
	public int getId_servicio() {
		return id_servicio;
	}


	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
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
	
	
	public static Servicio_ad obtenerDatosServicio() {
	    String alquilerAuto = JOptionPane.showInputDialog("Ingrese el alquiler de auto:");
	    String asistenciaPersonalizada = JOptionPane.showInputDialog("Ingrese la asistencia personalizada:");
	    int precio;
	    try {
	        precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del servicio:"));
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.");
	        return null;
	    }

	    return new Servicio_ad(alquilerAuto, asistenciaPersonalizada, precio);
	}
	@Override
	public String toString() {
		return "Servicio_ad [id_servicio=" + id_servicio + ", alquilerAuto=" + alquilerAuto
				+ ", asistenciaPersonalizada=" + asistenciaPersonalizada + ", precio=" + precio + "]";
	}


	
}
