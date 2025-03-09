package Vista;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Modelo.Destino;
import Modelo.Paquete;

public class SingletonPaquetes {
	private static Paquete Instancia;
	private static LinkedList<Destino> destino_paq = new LinkedList<Destino>();
	
	private SingletonPaquetes (Paquete Instancia){
		this.Instancia = Instancia;
		
	}
	
	public static Paquete getInstancia() {
		if (Instancia==null) {
			Instancia = new Paquete();
		}else {
			JOptionPane.showMessageDialog(null, "Ya existe paquete");
		}
		return Instancia;
	}
	
	
	
	public static LinkedList<Destino> Mostrar_Destinos_paq(){
		return destino_paq;  //MUESTRA LOS DESTINOS DENTRO DEL PAQUETE
	}

}
