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
import Modelo.Reserva;
import Controlador.ReservaControlador;


public class PaqueteControlador implements Mostrar_Paquetes {
	
	private final Connection agregarP;
	private final DestinosControlador destinosControlador;
	private final ReservaControlador reservaControlador;


	
	public PaqueteControlador() {
        this.agregarP = DatabaseConnection.getInstance().getConnection();
        this.destinosControlador = new DestinosControlador();
        this.reservaControlador = new ReservaControlador();
    }
	
	public void addPaquete(Paquete paquete) {
	    try {
	       
	        if (paquete.getDestino() == null || paquete.getDestino().getNombre() == null) {
	            System.out.println("Error: El destino del paquete no está seteado correctamente.");
	            JOptionPane.showMessageDialog(null, "Debe seleccionar un destino válido para el paquete.");
	            return;
	        }
	 
	        PreparedStatement destinoStatement = agregarP.prepareStatement(
	            "SELECT id_destino FROM destinos WHERE nombre = ?"
	        );
	        destinoStatement.setString(1, paquete.getDestino().getNombre());
	        ResultSet destinoResult = destinoStatement.executeQuery();

	        int destinoId = 0;
	        if (destinoResult.next()) {
	            destinoId = destinoResult.getInt("id_destino");
	        } else {
	            System.out.println("Error: El destino no existe en la base de datos.");
	            JOptionPane.showMessageDialog(null, "El destino no existe en la base de datos.");
	            return;
	        }

	        
	        PreparedStatement paqueteStatement = agregarP.prepareStatement(
	            "INSERT INTO paquetes_turisticos (nombreP, descripcion, tipo_turismo, precio, id_destino) VALUES (?, ?, ?, ?, ?)"
	        );
	        paqueteStatement.setString(1, paquete.getNombreP());
	        paqueteStatement.setString(2, paquete.getDescripcion());
	        paqueteStatement.setString(3, paquete.getTipo_turismo());
	        paqueteStatement.setDouble(4, paquete.getPrecio());
	        paqueteStatement.setInt(5, destinoId);

	        int rowsInserted = paqueteStatement.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("Paquete insertado exitosamente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al crear el paquete.");
	    }
	}

	public Destino buscarDestinoPorNombre(String nombre) {
	    
	    List<Destino> todos = destinosControlador.listarDestinos();
	    for (Destino d : todos) {
	        if (d.getNombre().equalsIgnoreCase(nombre)) {
	            return d;
	        }
	    }
	    return null;
	}
	


	public List<Paquete> listarPaquete() {
		
		
		List<Paquete> paquetes = new ArrayList<>();
		try {
			PreparedStatement statement = agregarP.prepareStatement("SELECT * FROM paquetes_turisticos");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
			    int idDestino = resultSet.getInt("id_destino");
			    Destino destino = destinosControlador.getDestinoById(idDestino); // recupera objeto completo

			    Paquete paquete1 = new Paquete(
			        resultSet.getInt("id_paquete"),
			        resultSet.getString("nombreP"),
			        resultSet.getString("descripcion"),
			        resultSet.getString("tipo_turismo"),
			        resultSet.getDouble("precio"),
			        destino
			    );

			    paquetes.add(paquete1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error en encontrar lista");
		}
		return paquetes;
		

	}
	

	public Paquete getPaqueteById(int id_paquete) {
	    Paquete paquete = null;
	    try {
	        PreparedStatement statement = agregarP.prepareStatement("SELECT * FROM paquetes_turisticos WHERE id_paquete = ?");
	        statement.setInt(1, id_paquete);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int idDestino = resultSet.getInt("id_destino");
	            Destino destino = destinosControlador.getDestinoById(idDestino);

	            paquete = new Paquete(
	                resultSet.getInt("id_paquete"),
	                resultSet.getString("nombreP"),
	                resultSet.getString("descripcion"),
	                resultSet.getString("tipo_turismo"),
	                resultSet.getDouble("precio"),
	                destino
	            );
	        } else {
	            System.out.println("No se encontró el paquete con id = " + id_paquete);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return paquete;
	}





	public void updatePaquete(Paquete paquete) {
		
		// TODO Auto-generated method stub
		
		try {
			String sql = "UPDATE paquetes_turisticos SET nombreP = ?, descripcion = ?, tipo_turismo = ?, precio = ? WHERE id_paquete = ?";
			PreparedStatement statement = agregarP.prepareStatement(sql);

			statement.setString(1, paquete.getNombreP());
			statement.setString(2, paquete.getDescripcion());
			statement.setString(3, paquete.getTipo_turismo());
			statement.setDouble(4, paquete.getPrecio());

			int destinoId = destinosControlador.getIdDestinoPorNombre(paquete.getDestino().getNombre());
			statement.setInt(5, paquete.getId_paquete());

		 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Paquete actualizado exitosamente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<String> getNombresDestinos() {
	    List<String> nombres = new ArrayList<>();
	    try {
	        String sql = "SELECT nombre FROM destinos";
	        PreparedStatement ps = agregarP.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            nombres.add(rs.getString("nombre"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return nombres;
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
