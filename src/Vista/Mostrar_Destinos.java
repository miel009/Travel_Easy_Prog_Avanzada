package Vista;

public interface Mostrar_Destinos {
	
	default public String[] MostrarDestino() {
	String[] Destinos= new String[SingletonDestino.MostrarDestinos_G().size()];
	for (int i = 0; i < Destinos.length; i++) {
		Destinos[i] = SingletonDestino.MostrarDestinos_G().get(i).getNombre();
	}
	return Destinos;
}
	}
