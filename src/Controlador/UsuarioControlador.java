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
    

    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Usuario user = new Usuario(resultSet.getInt("id_usuario"),  resultSet.getString("nombre"), resultSet.getString("email"),
            			resultSet.getString("contrasena"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Usuario getUserById(int id_usuario) {
        Usuario usuario = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
            statement.setInt(1, id_usuario);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	Usuario usuario1 = new Usuario(resultSet.getInt("id_usuario"),resultSet.getString("nombre"), resultSet.getString("email"),
            			resultSet.getString("contrasena"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

	@Override
    public void addUser(Usuario usuario) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario (nombre, email,contrasena) VALUES (?, ?, ?)");
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getContrasena());
            
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
            PreparedStatement statement = connection.prepareStatement("UPDATE usuario SET nombre = ?, email = ? , contrasena = ? WHERE id = ?");
            statement.setString(1, usuario.getNombre());
            //statement.setString(2, usuario.getEmail());
    
            
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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id = ?");
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
