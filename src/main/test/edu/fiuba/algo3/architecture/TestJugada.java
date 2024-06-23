package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Anulador.AnuladorClasico;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PuntuarVerdaderoFalsoClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugada {
    @Test
    public void test01UnJugadorJuega() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;


        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles,new PuntuarVerdaderoFalsoClasico());
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuesta2);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);

    }
}
