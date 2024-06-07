package TestClases;

import main.*;
import main.exceptions.AnuladorSeUsaMasDeUnaVez;
import main.exceptions.ModificadorSeUsaMasDeUnaVezException;
import org.junit.jupiter.api.Disabled;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsJugador {
    @org.junit.jupiter.api.Test
    public void test01JugadorSeLeModificaElPuntaje() {

        Jugador jugador1 = new Jugador("Spirulina");

        jugador1.modificarPuntaje(5);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(5, puntosJugador);

    }

    @org.junit.jupiter.api.Test
    public void test02JugadorSeLeModificaElPuntajeDespuesDeUsarUnBonificador() throws ModificadorSeUsaMasDeUnaVezException {

        int puntajeEsperado = 2;
        Jugador jugador1 = new Jugador("Spirulina");

        jugador1.activarDuplicadorDePuntaje();
        jugador1.modificarPuntaje(1);

        int puntosJugador = jugador1.obtenerPuntos();

        assertEquals(puntajeEsperado, puntosJugador);

    }

    @org.junit.jupiter.api.Test

    public void test03JugadorEnUnGrupoUtilizaAnuladorDePuntajeEnPreguntaVerdaderoFalsoClasiocYSeAnulaLaPregunta() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta("Si");
        RespuestaCorrecta respuestaDelJugador2 = new RespuestaCorrecta("Si");

        jugador1.activarAnuladorDePuntaje();

        jugador1.responder(pregunta, respuestaDelJugador1);
        jugador2.responder(pregunta, respuestaDelJugador2);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);




    }
}