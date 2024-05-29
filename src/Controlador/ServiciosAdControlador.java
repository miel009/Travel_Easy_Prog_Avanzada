package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Interfaces.Servicios_Adicionales;
import Modelo.Servicio_ad;


public class ServiciosAdControlador implements Servicios_Adicionales {

    private final Connection agregarS;

    public ServiciosAdControlador() {
        this.agregarS = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void addServicio(Servicio_ad servicio) {
        if (!validarServicio(servicio)) {
            System.out.println("Error: Datos del servicio no son válidos.");
            return;
        }

        try {
            PreparedStatement statement = agregarS.prepareStatement(
                "INSERT INTO servicios_ad (alquiler_auto, asistencia_personalizada, precio) VALUES (?, ?, ?)"
            );

            statement.setString(1, servicio.getAlquilerAuto());
            statement.setString(2, servicio.getAsistenciaPersonalizada());
            statement.setInt(3, servicio.getPrecio());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Servicio insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error, servicio NO insertado");
        }
    }

    private boolean validarServicio(Servicio_ad servicio) {
        if (servicio.getAlquilerAuto() == null || servicio.getAlquilerAuto().isEmpty()) {
            System.out.println("El alquiler de auto es obligatorio.");
            return false;
        }
        if (servicio.getAsistenciaPersonalizada() == null || servicio.getAsistenciaPersonalizada().isEmpty()) {
            System.out.println("La asistencia personalizada es obligatoria.");
            return false;
        }
        if (servicio.getPrecio() <= 0) {
            System.out.println("El precio debe ser mayor que 0.");
            return false;
        }
        return true;
    }
}