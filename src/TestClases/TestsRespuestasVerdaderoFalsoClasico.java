package TestClases;

import main.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsRespuestasVerdaderoFalsoClasico {
    @org.junit.jupiter.api.Test
    public void Test01UnaRespuestaCorrectaAsignaAUnJugadorSuPuntajeCorrectamente() {

        int puntajeEsperado  = 1;

        Jugador jugador1 = new Jugador("Riquelme");
        RespuestaCorrectaVerdaderoFalsoClasico respuesta = new RespuestaCorrectaVerdaderoFalsoClasico("Si");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);
        RespuestaCorrectaVerdaderoFalsoClasico RespuestaDelJugador = new RespuestaCorrectaVerdaderoFalsoClasico("Si");

        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico("es 2024?", respuestas);
        jugador1.responder(pregunta, RespuestaDelJugador);
        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);

        int puntajeObtenido =  jugador1.obtenerPuntos();

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}