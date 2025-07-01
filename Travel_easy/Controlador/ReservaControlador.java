package Controlador;

import Modelo.Reserva;
import Modelo.Usuario;
import Modelo.Paquete;
import Modelo.Pasajero;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservaControlador {

    private final Connection connection;

    public ReservaControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // Obtener reserva por ID, con Usuario, Paquete y lista Pasajeros cargados
    public Reserva getReservaById(int id_reserva) {
        Reserva reserva = null;
        try {
            // 1. Obtener reserva básica (incluye id_usuario e id_paquete)
            String sqlReserva = "SELECT * FROM reservas WHERE id_reserva = ?";
            PreparedStatement psReserva = connection.prepareStatement(sqlReserva);
            psReserva.setInt(1, id_reserva);
            ResultSet rsReserva = psReserva.executeQuery();

            if (rsReserva.next()) {
                int idUsuario = rsReserva.getInt("id_usuario");
                int idPaquete = rsReserva.getInt("id_paquete");
                Timestamp fechaReservaTS = rsReserva.getTimestamp("fecha_reserva");

                // 2. Obtener usuario completo
                Usuario usuario = getUsuarioById(idUsuario);

                // 3. Obtener paquete completo
                Paquete paquete = getPaqueteById(idPaquete);

                // 4. Obtener pasajeros asociados
                List<Pasajero> pasajeros = getPasajerosByReserva(id_reserva);

                // 5. Crear objeto Reserva (el constructor calcula precio total)
                reserva = new Reserva(
                	id_reserva,
                    usuario,
                    paquete,
                    pasajeros,
                    new Date(fechaReservaTS.getTime())
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;
    }

    // Crear nueva reserva (inserta reserva + pasajeros)
    public boolean addReserva(Reserva reserva) {
        boolean success = false;
        try {
            connection.setAutoCommit(false); // iniciar transacción

            // 1. Insertar reserva
            String sqlInsertReserva = "INSERT INTO reservas (id_usuario, id_paquete, fecha_reserva, precio_total) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsertReserva = connection.prepareStatement(sqlInsertReserva, Statement.RETURN_GENERATED_KEYS);
            psInsertReserva.setInt(1, reserva.getUsuario().getId_usuario());
            psInsertReserva.setInt(2, reserva.getPaquete().getId_paquete());
            psInsertReserva.setTimestamp(3, new Timestamp(reserva.getFechaReserva().getTime()));
            psInsertReserva.setDouble(4, reserva.getPrecioTotal());
            int affectedRows = psInsertReserva.executeUpdate();

            if (affectedRows == 0) {
                connection.rollback();
                return false;
            }

            // Obtener id generado de la reserva
            ResultSet generatedKeys = psInsertReserva.getGeneratedKeys();
            int id_reserva = 0;
            if (generatedKeys.next()) {
            	id_reserva = generatedKeys.getInt(1);
                reserva.setId_reserva(id_reserva);
            } else {
                connection.rollback();
                return false;
            }

            // 2. Insertar pasajeros
            String sqlInsertPasajero = "INSERT INTO pasajeros (id_reserva, nombre, apellido, documento, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psInsertPasajero = connection.prepareStatement(sqlInsertPasajero);

            for (Pasajero p : reserva.getPasajeros()) {
                psInsertPasajero.setInt(1, id_reserva);
                psInsertPasajero.setString(2, p.getNombre());
                psInsertPasajero.setString(3, p.getApellido());
                psInsertPasajero.setString(4, p.getDocumento());
                psInsertPasajero.setString(5, p.getTelefono());
                psInsertPasajero.setString(6, p.getEmail());
                psInsertPasajero.addBatch();
            }
            psInsertPasajero.executeBatch();

            connection.commit();
            success = true;
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return success;
    }

    // Otros métodos para actualizar y borrar reserva si quieres, similares

    // Método auxiliar para obtener Usuario por ID
    private Usuario getUsuarioById(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setNombre(rs.getString("nombre"));
            u.setEmail(rs.getString("email"));
            u.setContrasena(rs.getString("contrasena"));  // ajusta según tipo
            return u;
        }
        return null;
    }

    // Método auxiliar para obtener Paquete por ID
    private Paquete getPaqueteById(int idPaquete) throws SQLException {
        String sql = "SELECT * FROM paquetes_turisticos WHERE id_paquete = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idPaquete);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Paquete p = new Paquete();
            p.setId_paquete(rs.getInt("id_paquete"));
            p.setNombreP(rs.getString("nombreP"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setTipo_turismo(rs.getString("tipo_turismo"));
            p.setPrecio(rs.getDouble("precio"));
            p.setDestino(rs.getInt("id_destino"));
            return p;
        }
        return null;
    }

    
    private List<Pasajero> getPasajerosByReserva(int id_reserva) throws SQLException {
        List<Pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT * FROM pasajeros WHERE id_reserva = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id_reserva);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pasajero p = new Pasajero();
            p.setIdPasajero(rs.getInt("id_pasajero"));
            p.setNombre(rs.getString("nombre"));
            p.setApellido(rs.getString("apellido"));
            p.setDocumento(rs.getString("documento"));
            p.setTelefono(rs.getString("telefono"));
            p.setEmail(rs.getString("email"));
            pasajeros.add(p);
        }
        return pasajeros;
    }
}
