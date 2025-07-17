package Controlador;

import Modelo.Reserva;
import Modelo.Usuario;
import Modelo.Paquete;
import Modelo.Pasajero;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class ReservaControlador {

    private final Connection connection;

    public ReservaControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public ReservaControlador(Connection agregarP) {
        this.connection = agregarP;
    }
   

	
    public void insertarReserva(Reserva reserva) throws SQLException {
        String sql = "INSERT INTO reservas (nombre, apellido, cantidad_personas, id_paquete) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, reserva.getNombre());
            stmt.setString(2, reserva.getApellido());
            stmt.setInt(3, reserva.getCantidadPersonas());
            stmt.setInt(4, reserva.getPaquete().getId_paquete());
            stmt.executeUpdate();
        }
    }
    
}
