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
	List<Destino> listarDestinos();  // ME TRAE UNA LISTA COMPLETA DE LOS DESTINOS QUE OFRECE TRAVELEASY // PARA ENCARGADDO Y VTAS// LISTO.
	
	Destino getDestinoById(int id); // BUSCA LOS DESTINOS POR ID // ERROR 
		
	boolean addDestino(Destino destino);  // AGREGA DESTINO BD -- LISTO
										
	void updateDestino(Destino destino); // ACTUALIZA DESTINO BD // ERROR
												
	void deleteDestino(int id_destino);  // LISTO.

	// SECUNDARIO - VTAS

	
	List<Destino> filtrarDestinosPorTipoYEdad(List<Destino> destinos, String tipoTurismo, String edad);
	// FILTRADO  DE PARTE DEL ENCARGADO DE VENTAS -- > PARA DESTINOS MAYORES > 18   

	
	}
