package Modelo;

public class Destino {
	private int id_destino;
	private String nombre;
	private String descripcion;
	private String pais;
	private String zonaGeo;
	private String recomendaciones; 
	private String temporada_ideal;
	private int rango_edad; 
	private String transporte;
	private String tipo_turismo;
	private String servicios_requeridos;
	
	
	public Destino(int id_destino, String nombre, String descripcion, String pais, String zonaGeo,
			String recomendaciones, String temporada_ideal, int rango_edad, String transporte, String tipo_turismo,String servicios_requeridos) {
		
		this.id_destino = id_destino;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pais = pais;
		this.zonaGeo = zonaGeo;
		this.recomendaciones = recomendaciones;
		this.temporada_ideal = temporada_ideal;
		this.rango_edad = rango_edad;
		this.transporte = transporte;
		this.tipo_turismo = tipo_turismo;
		this.servicios_requeridos= servicios_requeridos;
	}
	
	public Destino() {
		//sobrecarga - uso de singleton
		
	}
	
	
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getZonaGeo() {
		return zonaGeo;
	}
	public void setZonaGeo(String zonaGeo) {
		this.zonaGeo = zonaGeo;
	}
	public String getRecomendaciones() {
		return recomendaciones;
	}
	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
	public String getTemporada_ideal() {
		return temporada_ideal;
	}
	public void setTemporada_ideal(String temporada_ideal) {
		this.temporada_ideal = temporada_ideal;
	}
	public int getRango_edad() {
		return rango_edad;
	}
	public void setRango_edad(int rango_edad) {
		this.rango_edad = rango_edad;
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	public String getTipo_turismo() {
		return tipo_turismo;
	}
	public void setTipo_turismo(String tipo_turismo) {
		this.tipo_turismo = tipo_turismo;
	}
	
	public String getServicios_requeridos() {
		return servicios_requeridos;
	}
	public void setServicios_requeridos(String servicios_requeridos) {
		this.servicios_requeridos = servicios_requeridos;
	}
	
	
	
	@Override
	public String toString() {
		return "Destino [id_destino=" + id_destino + ", nombre=" + nombre + ", descripcion=" + descripcion + ", pais="
				+ pais + ", zonaGeo=" + zonaGeo + ", recomendaciones=" + recomendaciones + ", temporada_ideal="
				+ temporada_ideal + ", rango_edad=" + rango_edad + ", transporte=" + transporte + ", tipo_turismo="
				+ tipo_turismo + ", servicios_requeridos=" + servicios_requeridos + "]";
	}

	public void agregarDestino(){
		Destino destino_cero = new Destino(0,"Bariloche","\nDESCRIPCION: Ideal para viajar en invierno si te gusta esquiar",
				"\nPais:Argentina", "\nZona geografica : America sur","\nRecomendacions: No viajar en invierno si no esta acostumbrado a niveles de frio altos, llevar mucho abrigo",
				"\nTemporada ideal: invierno.", 15 ,"\nTransporte: Avion","\nTipo de turismo: Aventura","\nServicios requeridos: si desea visitar pueblos cercanos es ideal alquilar un auto");
		
	}




}
