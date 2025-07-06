package Controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.UserRepository;
import Modelo.Usuario;


public class UsuarioControlador implements UserRepository {
    private final Connection connection;

    public UsuarioControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
    
    public Usuario verificarUsuario(String email, String contrasena) {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        Usuario usuario = null;
        try {
            String sql = "SELECT usuario.*, persona.nombre, persona.apellido, persona.dni " +
                         "FROM usuario JOIN persona ON usuario.id_persona = persona.id_persona " +
                         "WHERE usuario.email = ? AND usuario.contrasena = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               
                int id_usuario = rs.getInt("id_usuario");
                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                String correo = rs.getString("email");
                String pass = rs.getString("contrasena");

                usuario = new Usuario(id_usuario, id_persona, nombre, apellido, dni, correo, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }



    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> users = new ArrayList<>();
        try {
            String query = "SELECT u.id_usuario, u.email, u.contrasena, "
                         + "p.id_persona, p.nombre, p.apellido, p.dni "
                         + "FROM usuario u "
                         + "JOIN persona p ON u.id_persona = p.id_persona";
                         
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Usuario user = new Usuario(
                    resultSet.getInt("id_usuario"),
                    resultSet.getInt("id_persona"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getInt("dni"),
                    resultSet.getString("email"),
                    resultSet.getString("contrasena")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    
// me trae a los usuarios(por ID)
    public Usuario getUserById(int id_usuario) {
        Usuario usuario = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
            statement.setInt(1, id_usuario);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	usuario = new Usuario(resultSet.getString("email"), resultSet.getString("contrasena"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

	@Override
    public void addUser(Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario ( email,contrasena) VALUES ( ?, ?)");
            
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getContrasena());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usu  ario insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();           
        }
    }

	@Override
    public void updateUser(Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE usuario SET  email = ? , contrasena = ? WHERE id = ?");
            
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getContrasena());
            statement.setInt(3, usuario.getId_usuario());
    
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario actualizado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id_usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            statement.setInt(1, id_usuario);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuario eliminado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	}
