package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.Connection;

import Interfaces.Mostrar_Paquetes;
import Modelo.Paquete;

public class PaqueteControlador implements Mostrar_Paquetes {
	
	private final Connection agregarP;
	
	public PaqueteControlador() {
        this.agregarP = DatabaseConnection.getInstance().getConnection();
    }
	
	public void addPaquete(Paquete paquete) {
		// TODO Auto-generated method stub
			try {
		        // Verificar si el destino existe
		        PreparedStatement destinoStatement = agregarP.prepareStatement("SELECT id_destino FROM destinos WHERE nombre = ?");
		        destinoStatement.setString(1, paquete.getDestino().getNombre());
		        JOptionPane.showInputDialog("El destino existe");
		        ResultSet destinoResult = destinoStatement.executeQuery();

		        int destinoId = 0;
		        if (destinoResult.next()) {
		            destinoId = destinoResult.getInt("id_destino");
		        } else {
		            System.out.println("Error: El destino no existe en la base de datos.");
		            return; // Detiene la ejecución del método si el destino no existe
		        }

		        // Si el destino existe, crear el paquete
		        PreparedStatement paqueteStatement = agregarP.prepareStatement("INSERT INTO paquetes_turisticos (nombreP,descripcion,tipo_turismo,precio,id_destino) VALUES (?,?,?,?,?)");
		        paqueteStatement.setString(1, paquete.getNombreP());
		        paqueteStatement.setString(2, paquete.getDescripcion());
		        paqueteStatement.setString(3, paquete.getTipo_turismo());
		        paqueteStatement.setDouble(4, paquete.getPrecio());
		        paqueteStatement.setInt(5, destinoId); // Usar el ID de destino existente
		        
		        int rowsInserted = paqueteStatement.executeUpdate();
		        if (rowsInserted > 0) {
		            System.out.println("Paquete insertado exitosamente");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Error al crear el paquete.");
		    }
		}

	public List<Paquete> listarPaquete() {
		// TODO Auto-generated method stub
		return null;
	}

	public Paquete getPaqueteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void updatePaquete(Paquete destino) {
		// TODO Auto-generated method stub
		
	}

	public void deletePaquete(String nombreDestino) {
		// TODO Auto-generated method stub
		
	}

}
