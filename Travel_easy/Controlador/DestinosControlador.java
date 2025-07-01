package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Interfaces.Mostrar_Destinos;
import Modelo.Destino;
import Modelo.Usuario;

public class DestinosControlador implements Mostrar_Destinos {

	private final Connection agregar;

	public DestinosControlador() {
		this.agregar = DatabaseConnection.getInstance().getConnection();
	}

	@Override
	public boolean addDestino(Destino destino) {
		// TODO Auto-generated method stub
		// fUNCIONA
		try {
			PreparedStatement statement = agregar
					.prepareStatement("INSERT INTO destinos (nombre,descripcion,pais,zonaGeo,"
							+ "recomendaciones,temporada_ideal,rango_edad,transporte,tipo_turismo,servicios_requeridos) VALUES (?,?,?,?,?,?,?,?,?)");

			statement.setString(1, destino.getNombre());
			statement.setString(2, destino.getDescripcion());
			statement.setString(3, destino.getPais());
			statement.setString(4, destino.getZonaGeo());
			statement.setString(5, destino.getRecomendaciones());
			statement.setString(6, destino.getTemporada_ideal());
			statement.setInt(7, destino.getRango_edad());
			statement.setString(8, destino.getTransporte());
			statement.setString(9, destino.getTipo_turismo());
			

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				
			JOptionPane.showMessageDialog(null, "Destino insertado exitosamente");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error, destino NO insertado");
			
			return false;
		}
		return true;

	}

	@Override
	public void updateDestino(Destino destino) {
		try {
			String sql = "UPDATE destinos SET nombre = ?, descripcion = ?, pais = ?, zonaGeo = ?, recomendaciones = ?, temporada_ideal = ?, rango_edad = ?, transporte = ?, tipo_turismo = ? WHERE id_destino = ?";
			PreparedStatement statement = agregar.prepareStatement(sql);

			statement.setString(1, destino.getNombre());
			statement.setString(2, destino.getDescripcion());
			statement.setString(3, destino.getPais());
			statement.setString(4, destino.getZonaGeo());
			statement.setString(5, destino.getRecomendaciones());
			statement.setString(6, destino.getTemporada_ideal());
			statement.setInt(7, destino.getRango_edad());
			statement.setString(8, destino.getTransporte());
			statement.setString(9, destino.getTipo_turismo());
			statement.setInt(11, destino.getId_destino()); 
			

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "Destino actualizado exitosamente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Destino> listarDestinos() {
		
		// TODO Auto-generated method stub
		// FUNCIONA
		
		List<Destino> destinos = new ArrayList<>();
		try {

			PreparedStatement statement = agregar.prepareStatement("SELECT * FROM destinos ");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Destino destinos1 = new Destino(resultSet.getString("nombre"), resultSet.getString("descripcion"),
						resultSet.getString("pais"), resultSet.getString("zonaGeo"),
						resultSet.getString("recomendaciones"), resultSet.getString("temporada_ideal"),
						resultSet.getInt("rango_edad"), resultSet.getString("transporte"),
						resultSet.getString("tipo_turismo"));

				destinos1.setId_destino(resultSet.getInt("id_destino"));
				destinos.add(destinos1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error en encontrar lista");
		}
		return destinos;
	}

	@Override
	// funciona 
	public Destino getDestinoById(int id_destino) {
	    Destino destinoPorId = null; // Cambiamos a null en caso de que no haya resultados

	    try {
	        PreparedStatement statement = agregar.prepareStatement("SELECT * FROM destinos WHERE id_destino = ?");
	        statement.setInt(1, id_destino);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            destinoPorId = new Destino(
	                resultSet.getInt("id_destino"), 
	                resultSet.getString("nombre"), 
	                resultSet.getString("descripcion"),
	                resultSet.getString("pais"), 
	                resultSet.getString("zonaGeo"),
	                resultSet.getString("recomendaciones"), 
	                resultSet.getString("temporada_ideal"),
	                resultSet.getInt("rango_edad"), 
	                resultSet.getString("transporte"),
	                resultSet.getString("tipo_turismo")
	                
	                
	            );
	            System.out.println("Destino encontrado: " + destinoPorId.getNombre());
	        } else {
	            System.out.println("No se encontraron resultados para id_destino = " + id_destino);
	        }            

	        // Cierre de recursos
	        resultSet.close();
	        statement.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return destinoPorId;
	}


	
	
	public void deleteDestino(int id_destino) { 
		
		// funciona
		try {
			PreparedStatement statement = agregar.prepareStatement("DELETE FROM destinos WHERE id_destino = ?");
			statement.setInt(1, id_destino);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Destino eliminado exitosamente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Destino> filtrarDestinosPorTipoYEdad(List<Destino> destinos, String tipoTurismo, String edad) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	//DESEABLE
	
	
}
