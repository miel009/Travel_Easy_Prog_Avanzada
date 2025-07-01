package Modelo;

import java.util.Date;
import java.util.List;

public class Reserva {

    private int id_reserva;
    private Usuario usuario;  // quien hizo la reserva
    private Paquete paquete;  // paquete reservado
    private List<Pasajero> pasajeros; // lista de pasajeros
    private Date fechaReserva;
    private double precioTotal;

    // Constructor completo
    public Reserva(int idReserva, Usuario usuario, Paquete paquete, List<Pasajero> pasajeros, Date fechaReserva) {
        this.id_reserva = idReserva;
        this.usuario = usuario;
        this.paquete = paquete;
        this.pasajeros = pasajeros;
        this.fechaReserva = fechaReserva;
        calcularPrecioTotal();
    }

    // Constructor sin id (para crear reservas nuevas)
    public Reserva(Usuario usuario, Paquete paquete, List<Pasajero> pasajeros, Date fechaReserva) {
        this.usuario = usuario;
        this.paquete = paquete;
        this.pasajeros = pasajeros;
        this.fechaReserva = fechaReserva;
        calcularPrecioTotal();
    }

   

    public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
        calcularPrecioTotal();  // recalcula si cambia el paquete
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
        calcularPrecioTotal();  // recalcula si cambia la lista
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    // Método para calcular el precio total en base a precio paquete * pasajeros
    public void calcularPrecioTotal() {
        if (paquete != null && pasajeros != null) {
            this.precioTotal = paquete.getPrecio() * pasajeros.size();
        } else {
            this.precioTotal = 0;
        }
    }
}
