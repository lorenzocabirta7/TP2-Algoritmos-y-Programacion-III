package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExlusividad {
    @Test
    public void test01JugadorUtilizaExclusividad3VecesYTiraExcepcion() throws ExclusividadSeUsaMasdeDosVeces {
        int cantidadCatchesEsperador = 0;
        int cantidadCatchesObtenidos = 1;
        Jugador jugador1 = new Jugador("Spirulina");
        Pregunta pregunta = new Pregunta(null,null,new PuntuarVerdaderoFalsoClasico());
        jugador1.activarExclusividad(pregunta);
        jugador1.activarExclusividad(pregunta);
        try {
            jugador1.activarExclusividad(pregunta);
        } catch (ExclusividadSeUsaMasdeDosVeces error) {
            cantidadCatchesEsperador++;
        }
        assertEquals(cantidadCatchesEsperador,cantidadCatchesObtenidos);
    }

}
