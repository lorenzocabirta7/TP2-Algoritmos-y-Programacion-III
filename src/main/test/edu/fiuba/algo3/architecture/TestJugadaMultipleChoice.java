package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ModoDePregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadParcialMC;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaMultipleChoice {
    Pregunta preguntaChoiceConPenalidad;
    Pregunta preguntaChoiceClasico;
    Pregunta preguntaChoiceParcial;
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;

    RespuestaCorrecta respuestaCorrecta1;
    RespuestaCorrecta respuestaCorrecta2;
    RespuestaCorrecta respuestaCorrecta3;
    RespuestaIncorrecta respuestaIncorrecta1;
    ArrayList<Respuesta> respuestas;

    @BeforeEach
    public void setUp() {
        respuestaCorrecta1 = new RespuestaCorrecta("Correcta1", "0");
        respuestaCorrecta2 = new RespuestaCorrecta("Correcta2", "0");
        respuestaCorrecta3 = new RespuestaCorrecta("Correcta3", "0");
        respuestaIncorrecta1 = new RespuestaIncorrecta("Incorrecta");


        respuestas = new ArrayList<>();
        respuestas.add(respuestaCorrecta1);
        respuestas.add(respuestaCorrecta2);
        respuestas.add(respuestaCorrecta3);
        respuestas.add(respuestaIncorrecta1);

        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");

        preguntaChoiceConPenalidad = new Pregunta("Un Enunciado", "UnTema", respuestas, new MultipleChoice(new PenalidadConPenalidad()));
        preguntaChoiceClasico = new Pregunta("Un Enunciado", "UnTema", respuestas, new MultipleChoice(new PenalidadClasica()));
        preguntaChoiceParcial = new Pregunta("Un Enunciado", "UnTema", respuestas, new MultipleChoice(new PenalidadParcialMC()));
    }


    @Test
    public void test01TresJugadoresJueganUnaRondaDeMultipleChoiceClasico() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        jugador1.agregarRespuesta(preguntaChoiceClasico,respuestaCorrecta1);
        jugador1.agregarRespuesta(preguntaChoiceClasico,respuestaCorrecta2);
        jugador1.agregarRespuesta(preguntaChoiceClasico,respuestaCorrecta3);
        jugador1.confirmarRespuesta(preguntaChoiceClasico);


        jugador2.agregarRespuesta(preguntaChoiceClasico,respuestaIncorrecta1);
        jugador2.agregarRespuesta(preguntaChoiceClasico,respuestaCorrecta2);
        jugador2.agregarRespuesta(preguntaChoiceClasico,respuestaCorrecta3);
        jugador2.confirmarRespuesta(preguntaChoiceClasico);

        jugador3.agregarRespuesta(preguntaChoiceClasico,respuestaIncorrecta1);
        jugador3.confirmarRespuesta(preguntaChoiceClasico);

        preguntaChoiceClasico.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1,puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3,puntajeObtenido3);
    }

    @Test
    public void test01TresJugadoresJueganUnaRondaDeMultipleChoiceParcial() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 3;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 1;

        jugador1.agregarRespuesta(preguntaChoiceParcial,respuestaCorrecta1);
        jugador1.agregarRespuesta(preguntaChoiceParcial,respuestaCorrecta2);
        jugador1.agregarRespuesta(preguntaChoiceParcial,respuestaCorrecta3);
        jugador1.confirmarRespuesta(preguntaChoiceParcial);


        jugador2.agregarRespuesta(preguntaChoiceParcial,respuestaIncorrecta1);
        jugador2.agregarRespuesta(preguntaChoiceParcial,respuestaCorrecta2);
        jugador2.agregarRespuesta(preguntaChoiceParcial,respuestaCorrecta3);
        jugador2.confirmarRespuesta(preguntaChoiceParcial);

        jugador3.agregarRespuesta(preguntaChoiceParcial,respuestaCorrecta2);
        jugador3.confirmarRespuesta(preguntaChoiceParcial);

        preguntaChoiceParcial.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1,puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3,puntajeObtenido3);
    }

    @Test
    public void test03TresJugadoresJueganUnaRondaDeMultipleChoiceConPenalidad() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 3;
        int puntajeEsperadoJugador2 = 1;
        int puntajeEsperadoJugador3 = -1;

        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta1);
        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta2);
        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta3);
        jugador1.confirmarRespuesta(preguntaChoiceConPenalidad);


        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaIncorrecta1);
        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta2);
        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta3);
        jugador2.confirmarRespuesta(preguntaChoiceConPenalidad);

        jugador3.agregarRespuesta(preguntaChoiceConPenalidad,respuestaIncorrecta1);
        jugador3.confirmarRespuesta(preguntaChoiceConPenalidad);

        preguntaChoiceConPenalidad.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1,puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3,puntajeObtenido3);
    }

    @Test
    public void test04TresJugadoresJueganUnaRondaDeMultipleChoiceClasicoYTodosUsanAnulador() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;


        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta1);
        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta2);
        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta3);
        jugador1.activarAnuladorDePuntaje(preguntaChoiceConPenalidad);
        jugador1.confirmarRespuesta(preguntaChoiceConPenalidad);


        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaIncorrecta1);
        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta2);
        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta3);
        jugador2.activarAnuladorDePuntaje(preguntaChoiceConPenalidad);
        jugador2.confirmarRespuesta(preguntaChoiceConPenalidad);

        jugador3.agregarRespuesta(preguntaChoiceConPenalidad,respuestaIncorrecta1);
        jugador3.activarAnuladorDePuntaje(preguntaChoiceConPenalidad);
        jugador3.confirmarRespuesta(preguntaChoiceConPenalidad);

        preguntaChoiceConPenalidad.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1,puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3,puntajeObtenido3);
    }

    @Test
    public void test05TresJugadoresJueganUnaRondaDeMultipleChoiceClasicoYUnJugadorUsaAnuladorYEseSoloRespondeBien() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 3;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;


        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta1);
        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta2);
        jugador1.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta3);
        jugador1.activarAnuladorDePuntaje(preguntaChoiceConPenalidad);
        jugador1.confirmarRespuesta(preguntaChoiceConPenalidad);


        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaIncorrecta1);
        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta2);
        jugador2.agregarRespuesta(preguntaChoiceConPenalidad,respuestaCorrecta3);
        jugador2.confirmarRespuesta(preguntaChoiceConPenalidad);

        jugador3.agregarRespuesta(preguntaChoiceConPenalidad,respuestaIncorrecta1);
        jugador3.confirmarRespuesta(preguntaChoiceConPenalidad);

        preguntaChoiceConPenalidad.puntuarJugadores();

        int puntajeObtenido1 = jugador1.obtenerPuntos();
        int puntajeObtenido2 = jugador2.obtenerPuntos();
        int puntajeObtenido3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1,puntajeObtenido1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenido2);
        assertEquals(puntajeEsperadoJugador3,puntajeObtenido3);
    }


    

}
