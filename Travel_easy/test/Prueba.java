package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Controlador.DestinosControlador;
import Modelo.Destino;

public class Prueba {

    @Test
    @DisplayName("Prueba de agregar destino")
    public void addDestino() {
        DestinosControlador controlador = new DestinosControlador();
        //EJEMPLO DE DESTINO ID:
        Destino destino = new Destino("Patagonia", "Chile y Argentina", "Sur",
                "Llevar ropa de abrigo y equipo de senderismo.", "Noviembre a Marzo","Noviembre a Marzo",18, "Transporte terrestre y aéreo", "Aventura");

        boolean result = controlador.addDestino(destino);

        assertTrue(result, "Destino insertado exitosamente");
    }
    


@Test
@DisplayName("Prueba de agregar destino con 1 parametro null")
public void addDestinoIncompleto() {
    DestinosControlador controlador = new DestinosControlador();

    Destino destino = new Destino("Patagonia", "Chile y Argentina", "Sur",
            "Llevar ropa de abrigo y equipo de senderismo.", null,"Noviembre a Marzo",18, "Transporte terrestre y aéreo", "Aventura");

    boolean result = controlador.addDestino(destino);

    assertTrue(result, "Destino insertado exitosamente");
}
}






