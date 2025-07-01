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
    
    
    public boolean validarCredenciales(String email, String contrasena) {
        try {
            String query = "SELECT COUNT(*) FROM usuario WHERE email = ? AND contrasena = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Usuario user = new Usuario(resultSet.getString("email"), resultSet.getString("contrasena"));
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
            //itera y me trae info del usuario
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
                System.out.println("Usuario insertado exitosamente");
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
