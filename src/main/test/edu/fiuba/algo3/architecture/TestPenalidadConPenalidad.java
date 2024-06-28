package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPenalidadConPenalidad {
    @Test
    public void Test01UnaPenalidadConPenalidadActualizaUnPuntajeDeFormaCorrecta() {
        int puntajeEsperado = -1;

        TipoDePenalidad penalidadConPenalidad = new PenalidadConPenalidad();

        int puntajeObtenido = penalidadConPenalidad.penalizarPuntaje(1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
