package main.Respuestas.Penalidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPenalidadClasica {

    @org.junit.jupiter.api.Test
    public void Test01UnaPenalidadClasicaActualizaUnPuntajeDeFormaCorrecta() {
        int puntajeEsperado = 0;

        TipoDePenalidad penalidadClasica = new PenalidadClasica();

        int puntajeObtenido = penalidadClasica.actualizarPuntaje(1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
