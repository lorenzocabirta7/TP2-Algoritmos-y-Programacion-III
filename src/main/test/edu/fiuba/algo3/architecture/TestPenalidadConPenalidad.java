package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.TipoDePenalidad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPenalidadConPenalidad {
    @Test
    public void Test01UnaPenalidadConPenalidadActualizaUnPuntajeDeFormaCorrecta() {
        int puntajeEsperado = -1;

        TipoDePenalidad penalidadConPenalidad = new PenalidadConPenalidad();

        int puntajeObtenido = penalidadConPenalidad.actualizarPuntaje(1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
