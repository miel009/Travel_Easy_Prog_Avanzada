package Interfaces;

import java.util.List;

import Modelo.Paquete;

public interface Mostrar_Paquetes {
 
	List<Paquete> listarPaquete();  // ME TRAE UNA LISTA COMPLETA DE LOS PAQUETE QUE OFRECE TRAVELEASY
	
	Paquete getPaqueteById(int id); // BUSCA LOS PAQUETE POR ID
		
	void addPaquete(Paquete destino);  // AGREGA PAQUETE BD
										
	void updatePaquete(Paquete destino); // ACTUALIZA PAQUETE BD
												
	void deletePaquete(String nombreDestino);	//ELIMINA PAQUETE BD

	//Paquete detallarPaqueteTuristico(String nombrePaquete); //POdria ser para descripcion

}
