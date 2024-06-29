package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ModoDePregunta.GroupChoice;
import edu.fiuba.algo3.modelo.ModoDePregunta.GroupChoice;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaAVerificar;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaGroupChoice {
    Pregunta preguntaGroupChoice;
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
        respuestaCorrecta1 = new RespuestaCorrecta("Numero1", "Numero");
        respuestaCorrecta2 = new RespuestaCorrecta("Numero2", "Numero");
        respuestaCorrecta3 = new RespuestaCorrecta("LetraA", "Letra");
        respuestaCorrecta4 = new RespuestaCorrecta("LetraB", "Letra");

        respuestas = new ArrayList<>();
        respuestas.add(respuestaCorrecta1);
        respuestas.add(respuestaCorrecta2);
        respuestas.add(respuestaCorrecta3);
        respuestas.add(respuestaCorrecta4);

        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");

        preguntaGroupChoice = new Pregunta("Un Enunciado", "UnTema", respuestas, new GroupChoice(new PenalidadClasica()));
    }

    @Test
    public void test01TresJugadoresJueganUnaRondaDeGroupChoice() throws edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;
        int puntajeEsperadoJugador3 = 0;

        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador1.confirmarRespuesta(preguntaGroupChoice);


        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador2.confirmarRespuesta(preguntaGroupChoice);

        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador3.confirmarRespuesta(preguntaGroupChoice);

        preguntaGroupChoice.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenido3);
    }
    @Test
    public void test02TresJugadoresJueganUnaRondaDeGroupChoiceConMultiplicadores() throws edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 2;
        int puntajeEsperadoJugador2 = 3;
        int puntajeEsperadoJugador3 = 0;

        jugador1.activarDuplicadorDePuntaje();
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador1.confirmarRespuesta(preguntaGroupChoice);

        jugador2.activarTriplicadorDePuntaje();
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador2.confirmarRespuesta(preguntaGroupChoice);


        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador3.confirmarRespuesta(preguntaGroupChoice);

        preguntaGroupChoice.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenido3);
    }
    @Test
    public void test03TresJugadoresJueganUnaRondaDeGroupChoice() throws edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez, edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida, edu.fiuba.algo3.modelo.exceptions.ExclusividadSeUsaMasdeDosVeces {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        jugador1.activarExclusividad(preguntaGroupChoice);
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador1.confirmarRespuesta(preguntaGroupChoice);

        jugador2.activarAnuladorDePuntaje(preguntaGroupChoice);
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador2.confirmarRespuesta(preguntaGroupChoice);

        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador3.confirmarRespuesta(preguntaGroupChoice);

        preguntaGroupChoice.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenido3);
    }
    @Test
    public void test04TresJugadoresJueganUnaRondaDeGroupChoice() throws edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;
        int puntajeEsperadoJugador3 = 0;

        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador1.confirmarRespuesta(preguntaGroupChoice);


        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador2.confirmarRespuesta(preguntaGroupChoice);

        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador3.confirmarRespuesta(preguntaGroupChoice);

        preguntaGroupChoice.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenido3);
    }
    @Test
    public void test05TresJugadoresJueganUnaRondaDeGroupChoiceUnoAplicaExclusividadYsoloUNoRespondeBien() throws edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez, edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida, edu.fiuba.algo3.modelo.exceptions.ExclusividadSeUsaMasdeDosVeces {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador1.confirmarRespuesta(preguntaGroupChoice);

        jugador2.activarExclusividad(preguntaGroupChoice);
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador2.confirmarRespuesta(preguntaGroupChoice);

        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador3.confirmarRespuesta(preguntaGroupChoice);

        preguntaGroupChoice.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenido3);
    }
    @Test
    public void test06TresJugadoresJueganUnaRondaDeGroupChoice() throws edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez, edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida, edu.fiuba.algo3.modelo.exceptions.ExclusividadSeUsaMasdeDosVeces {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 6;
        int puntajeEsperadoJugador3 = 0;


        jugador1.activarExclusividad(preguntaGroupChoice);
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Numero"));
        jugador1.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador1.confirmarRespuesta(preguntaGroupChoice);

        jugador2.activarExclusividad(preguntaGroupChoice);
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Letra"));
        jugador2.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador2.confirmarRespuesta(preguntaGroupChoice);

        jugador3.activarExclusividad(preguntaGroupChoice);
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero1", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("Numero2", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraA", "Numero"));
        jugador3.responder(preguntaGroupChoice, new RespuestaAVerificar("LetraB","Letra"));
        jugador3.confirmarRespuesta(preguntaGroupChoice);

        preguntaGroupChoice.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenido3);
    }
}

