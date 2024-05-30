package Interfaces;
import java.util.List;

import Modelo.Destino;
import Vista.SingletonDestino;

public interface Mostrar_Destinos {
	
	default public String[] MostrarDestino() {
	String[] Destinos= new String[SingletonDestino.MostrarDestinos_G().size()];
	for (int i = 0; i < Destinos.length; i++) {
		Destinos[i] = SingletonDestino.MostrarDestinos_G().get(i).getNombre();
	}
	return Destinos;
}
	
	// MVP
	// ENCARGADO TURISMO
	List<Destino> listarDestinos();  // ME TRAE UNA LISTA COMPLETA DE LOS DESTINOS QUE OFRECE TRAVELEASY // PARA ENCARGADDO Y VTAS
	
	Destino getDestinoById(int id); // BUSCA LOS DESTINOS POR ID
		
	boolean addDestino(Destino destino);  // AGREGA DESTINO BD -- LISTO
										
	void updateDestino(Destino destino); // ACTUALIZA DESTINO BD
												
	
	// SECUNDARIO - VTAS

	 // MUESTRA DESTINOS QUE ESTAN DISPONIBLES PARA EL ENCARGADO VTAS
	
	List<Destino> filtrarDestinosPorTipoYEdad(List<Destino> destinos, String tipoTurismo, String edad);
	// FILTRADO  DE PARTE DEL ENCARGADO DE VENTAS 

	void deleteDestino(int id_destino);

	}
