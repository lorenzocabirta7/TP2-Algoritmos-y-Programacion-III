package main.Respuestas.Penalidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPenalidadConPenalidad {
    @org.junit.jupiter.api.Test
    public void Test01UnaPenalidadConPenalidadActualizaUnPuntajeDeFormaCorrecta() {
        int puntajeEsperado = -1;

        TipoDePenalidad penalidadConPenalidad = new PenalidadConPenalidad();

        int puntajeObtenido = penalidadConPenalidad.actualizarPuntaje(1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
