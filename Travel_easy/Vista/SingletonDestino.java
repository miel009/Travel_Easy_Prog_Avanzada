package Vista;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Modelo.Destino;

public class SingletonDestino {
	private static Destino Instancia;
	private static LinkedList<Destino> destino_g = new LinkedList<Destino>();
	
	private SingletonDestino (Destino Instancia){
		this.Instancia = Instancia;
	}
	
	public static Destino getInstancia() {
		if (Instancia == null) {
			Instancia = new Destino(); // USE UN CONSTRUCTOR VACIO
			
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe destino");
		}
		return Instancia;
		
	}
	
	public static LinkedList<Destino> MostrarDestinos_G(){
		return destino_g;
	} // MUESTRA TODOS LOS DESTINOS QUE OFRECE LA AGENCIA DE VIAJES
	 // Agregar destinos en la clase destinos -- HACER una sobre carga.
}
