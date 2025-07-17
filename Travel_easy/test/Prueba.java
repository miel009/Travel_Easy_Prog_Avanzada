package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        Destino destino = new Destino("Patagonia Test", "Chile", "Sur", "Abrigo", "Noviembre", "Febrero", 18, "Avión", "Aventura");
        boolean result = controlador.addDestino(destino);
        assertTrue(result, "Destino insertado exitosamente");
    }
    


    @Test
    @DisplayName("Prueba de agregar destino con 1 parametro null")
    public void addDestinoIncompleto() {
    	DestinosControlador controlador = new DestinosControlador();
    	Destino destino = new Destino("Patagonia", "Chile", "Sur", "Abrigo", null, "Febrero", 18, "Avión", "Aventura");
    	boolean result = controlador.addDestino(destino);
    	assertFalse(result, "Destino no debe insertarse con temporada alta nula");
}
}






