package Modelo;
import Interfaces.Mostrar_Paquetes;
import Interfaces.ObtenerDestinoPor_id;
import Vista.Mostrar_Destinos;

public class Encargado_Vtas extends Usuario implements Mostrar_Destinos,
	Mostrar_Paquetes,ObtenerDestinoPor_id{
	
	private int id_vta;

	public Encargado_Vtas(String nombre, String apellido, int dni, int id_ingresoSistema, int id_vta) {
		super(nombre, apellido, dni, id_ingresoSistema);
		this.id_vta = id_vta;
	}

	public int getId_vta() {
		return id_vta;
	}

	public void setId_vta(int id_vta) {
		this.id_vta = id_vta;
	}

	@Override
	public String toString() {
		return "Encargado_Vtas [id_vta=" + id_vta + "]";
	}
	
	/*CREAR METODOS*/

}
