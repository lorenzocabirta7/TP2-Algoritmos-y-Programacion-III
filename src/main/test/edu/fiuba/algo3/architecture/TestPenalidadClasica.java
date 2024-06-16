package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.TipoDePenalidad;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPenalidadClasica {

    @Test
    public void Test01UnaPenalidadClasicaActualizaUnPuntajeDeFormaCorrecta() {
        int puntajeEsperado = 0;

        TipoDePenalidad penalidadClasica = new PenalidadClasica();

        int puntajeObtenido = penalidadClasica.actualizarPuntaje(1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
