package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
	private int codigo_reserva;
	private Encargado_Vtas encargado_vtas; // NOMBRE DE LA PERSONA QUE REALIZO LA RESERVA
	private double precio_total; // suma de los destino, de serv adicionales.
	private Paquete paquete; // PAQUETE ARMADO- DESTINOS QUE INCLUYE.
	private int cant_pasajeros; // APARTIR DE ESTO SUMAR EN EL TOTAL SI SON MAS DE DOS PERSONAS
	private Servicio_ad servicio_ad;
	private Pasajero pasajero;
	private LocalDate fecha_salida;
	private LocalDate fecha_llegada;
	private LocalTime hora_salida; // o directamente agregar a atributo transporte.
	private LocalTime hora_llegada;
	private String detalles;
	// PENSAR SI PUEDO AGREGAR ALGO MAS //
	public Reserva(int codigo_reserva, Encargado_Vtas encargado_vtas, double precio_total, Paquete paquete,
			int cant_pasajeros, Servicio_ad servicio_ad, Pasajero pasajero, LocalDate fecha_salida,
			LocalDate fecha_llegada, LocalTime hora_salida, LocalTime hora_llegada, String detalles) {
		super();
		this.codigo_reserva = codigo_reserva;
		this.encargado_vtas = encargado_vtas;
		this.precio_total = precio_total;
		this.paquete = paquete;
		this.cant_pasajeros = cant_pasajeros;
		this.servicio_ad = servicio_ad;
		this.pasajero = pasajero;
		this.fecha_salida = fecha_salida;
		this.fecha_llegada = fecha_llegada;
		this.hora_salida = hora_salida;
		this.hora_llegada = hora_llegada;
		this.detalles = detalles;
	}
	public int getCodigo_reserva() {
		return codigo_reserva;
	}
	public void setCodigo_reserva(int codigo_reserva) {
		this.codigo_reserva = codigo_reserva;
	}
	public Encargado_Vtas getEncargado_vtas() {
		return encargado_vtas;
	}
	public void setEncargado_vtas(Encargado_Vtas encargado_vtas) {
		this.encargado_vtas = encargado_vtas;
	}
	public double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
	public Paquete getPaquete() {
		return paquete;
	}
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	public int getCant_pasajeros() {
		return cant_pasajeros;
	}
	public void setCant_pasajeros(int cant_pasajeros) {
		this.cant_pasajeros = cant_pasajeros;
	}
	public Servicio_ad getServicio_ad() {
		return servicio_ad;
	}
	public void setServicio_ad(Servicio_ad servicio_ad) {
		this.servicio_ad = servicio_ad;
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public LocalDate getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(LocalDate fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public LocalDate getFecha_llegada() {
		return fecha_llegada;
	}
	public void setFecha_llegada(LocalDate fecha_llegada) {
		this.fecha_llegada = fecha_llegada;
	}
	public LocalTime getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(LocalTime hora_salida) {
		this.hora_salida = hora_salida;
	}
	public LocalTime getHora_llegada() {
		return hora_llegada;
	}
	public void setHora_llegada(LocalTime hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "Reserva [codigo_reserva=" + codigo_reserva + ", encargado_vtas=" + encargado_vtas + ", precio_total="
				+ precio_total + ", paquete=" + paquete + ", cant_pasajeros=" + cant_pasajeros + ", servicio_ad="
				+ servicio_ad + ", pasajero=" + pasajero + ", fecha_salida=" + fecha_salida + ", fecha_llegada="
				+ fecha_llegada + ", hora_salida=" + hora_salida + ", hora_llegada=" + hora_llegada + ", detalles="
				+ detalles + "]";
	}
	
	
	
	
	

}
