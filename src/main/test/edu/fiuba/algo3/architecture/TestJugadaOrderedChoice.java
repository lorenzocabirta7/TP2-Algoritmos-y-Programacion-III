package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ModoDePregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaAVerificar;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaOrderedChoice {
    Pregunta preguntaOrderedChoice;
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;

    RespuestaCorrecta respuestaCorrecta1;
    RespuestaCorrecta respuestaCorrecta2;
    RespuestaCorrecta respuestaCorrecta3;
    RespuestaCorrecta respuestaCorrecta4;
    ArrayList<Respuesta> respuestas;

    @BeforeEach
    public void setUp() {
        respuestaCorrecta1 = new RespuestaCorrecta("Correcta1", "1");
        respuestaCorrecta2 = new RespuestaCorrecta("Correcta2", "2");
        respuestaCorrecta3 = new RespuestaCorrecta("Correcta3", "3");
        respuestaCorrecta4 = new RespuestaCorrecta("Correcta3", "4");


        respuestas = new ArrayList<>();
        respuestas.add(respuestaCorrecta1);
        respuestas.add(respuestaCorrecta2);
        respuestas.add(respuestaCorrecta3);

        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");

        preguntaOrderedChoice = new Pregunta("Un Enunciado", "UnTema", respuestas, new OrderedChoice(new PenalidadClasica()));
    }

    @Test
    public void test01TresJugadoresJueganUnaRondaDeOrderedChoice() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        jugador1.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta1", "1"));
        jugador1.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta2", "2"));
        jugador1.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta3", "3"));
        jugador1.confirmarRespuesta(preguntaOrderedChoice);


        jugador2.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta1", "1"));
        jugador2.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta2", "3"));
        jugador2.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta3", "2"));
        jugador2.confirmarRespuesta(preguntaOrderedChoice);

        jugador3.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta1", "3"));
        jugador3.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta2", "1"));
        jugador3.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta3", "2"));
        jugador3.confirmarRespuesta(preguntaOrderedChoice);

        preguntaOrderedChoice.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenido3);
    }

    @Test
    public void test02TresJugadoresJueganUnaRondaDeOrderedChoice() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        jugador1.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta1", "1"));
        jugador1.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta2", "2"));
        jugador1.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta3", "3"));
        jugador1.confirmarRespuesta(preguntaOrderedChoice);


        jugador2.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta1", "1"));
        jugador2.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta2", "3"));
        jugador2.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta3", "2"));
        jugador2.confirmarRespuesta(preguntaOrderedChoice);

        jugador3.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta1", "3"));
        jugador3.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta2", "1"));
        jugador3.responder(preguntaOrderedChoice, new RespuestaAVerificar("Correcta3", "2"));
        jugador3.confirmarRespuesta(preguntaOrderedChoice);

        preguntaOrderedChoice.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenido3);
    }

}
        

