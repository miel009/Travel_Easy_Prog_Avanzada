package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.Connection;

import Interfaces.Mostrar_Paquetes;
import Modelo.Destino;
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
		        PreparedStatement destinoStatement = agregarP.prepareStatement("SELECT id_destino FROM destinos WHERE nombreT = ?");
		        //destinoStatement.setString(1, paquete.getDestino().getNombre());
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
		        PreparedStatement paqueteStatement = agregarP.prepareStatement("INSERT INTO paquetes_turisticos (nombreT,descripcion,tipo_turismo,precio,id_destino) VALUES (?,?,?,?,?)");
		        paqueteStatement.setString(1, paquete.getNombreP());
		        paqueteStatement.setString(2, paquete.getDescripcion());
		        paqueteStatement.setString(3, paquete.getTipo_turismo());
		        paqueteStatement.setDouble(4, paquete.getPrecio());
		        paqueteStatement.setInt(5, paquete.getDestino()); // Usar el ID de destino existente
		        
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
		List<Paquete> paquetes = new ArrayList<>();
		try {

			PreparedStatement statement = agregarP.prepareStatement("SELECT * FROM paquetes_turisticos");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Paquete paquete1 = new Paquete(resultSet.getInt("id_paquete"),resultSet.getString("nombreT"), 
						resultSet.getString("descripcion"),
						resultSet.getString("tipo_turismo"), resultSet.getDouble("precio"),resultSet.getInt("id_destino") );

				//paquete1.getDestino();
				paquete1.setId_paquete(resultSet.getInt("id_paquete"));
				paquetes.add(paquete1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error en encontrar lista");
		}
		return paquetes;
		
		// TODO Auto-generated method stub

	}
	

	
	
	
	public Paquete getPaqueteById(int id_paquete) {
		// TODO Auto-generated method stub
		Paquete PaquetePorId= new Paquete();
		try {
			PreparedStatement statement = agregarP.prepareStatement("SELECT * FROM paquetes_turisticos WHERE id_paquete = ?");
			statement.setInt(1, id_paquete);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Paquete Paquete1 = new Paquete(resultSet.getInt("id_paquete"), resultSet.getString("nombreT"), 
					resultSet.getString("descripcion"),resultSet.getString("tipo_turismo"),
				    resultSet.getDouble("precio"),resultSet.getInt("id_destino"));
				
					PaquetePorId.setId_paquete(resultSet.getInt("id_destino"));
	            System.out.println("Destino encontrado: " + PaquetePorId.getId_paquete());
	        } else {
	            System.out.println("No se encontraron resultados para id_paquete = " + id_paquete);
	        }			
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PaquetePorId;
	}





	public void updatePaquete(Paquete paquete) {
		
		// TODO Auto-generated method stub
		
		try {
			String sql = "UPDATE paquetes_turisticos SET nombreT = ?, descripcion = ?, tipo_turismo = ?, precio = ? WHERE id_paquete = ?";
			PreparedStatement statement = agregarP.prepareStatement(sql);
			
			
			statement.setString(1, paquete.getNombreP() );
			statement.setString(2, paquete.getDescripcion());
			statement.setString(3, paquete.getTipo_turismo());
			statement.setDouble(4, paquete.getPrecio());	
			statement.setInt(5, paquete.getId_paquete()); //ID del destino
		

		 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Paquete actualizado exitosamente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deletePaquete(int id_paquete) {
		// TODO Auto-generated method stub			
			// funciona
			try {
				PreparedStatement statement = agregarP.prepareStatement("DELETE FROM paquetes_turisticos WHERE id_paquete = ?");
				statement.setInt(1, id_paquete);

				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted > 0) {
					System.out.println("Paquete eliminado exitosamente");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	

}
