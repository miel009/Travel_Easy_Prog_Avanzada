package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Interfaces.Mostrar_Destinos;
import Modelo.Destino;

public class DestinosControlador implements Mostrar_Destinos {
	//private Destino mostrar;
	private final Connection agregar;
	
	public DestinosControlador() {
        this.agregar = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public boolean addDestino(Destino destino) {
		// TODO Auto-generated method stub
		try {
            PreparedStatement statement = agregar.prepareStatement("INSERT INTO destinos (nombre,descripcion,pais,zonaGeo,"
            		+ "recomendaciones,temporada_ideal,rango_edad,transporte,tipo_turismo,servicios_requeridos) VALUES (?,?,?,?,?,?,?,?,?,?)");
           
            statement.setString(1, destino.getNombre());
            statement.setString(2, destino.getDescripcion());
            statement.setString(3, destino.getPais());
            statement.setString(4, destino.getZonaGeo());
            statement.setString(5, destino.getRecomendaciones());
            statement.setString(6, destino.getTemporada_ideal());      
            statement.setInt(7, destino.getRango_edad());
            statement.setString(8, destino.getTransporte());
            statement.setString(9, destino.getTipo_turismo());
            statement.setString(10, destino.getServicios_requeridos());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Destino insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error, destino NO insertado");
            return false;
        }
		return true;
		
	}
	
	
	@Override
	public void updateDestino(Destino destino) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public List<Destino> listarDestinos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destino getDestinoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteDestino(String nombreDestino) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Destino> verDestinosDisponibles(List<Destino> destinos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destino> filtrarDestinosPorTipoYEdad(List<Destino> destinos, String tipoTurismo, String edad) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
