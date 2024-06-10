package TestClases;

import main.*;
import main.exceptions.AnuladorSeUsaMasDeUnaVez;
import main.exceptions.ModificadorSeUsaMasDeUnaVezException;

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
    public void test03JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaVerdaderoFalsoClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuesta1);
        jugador2.responder(pregunta, respuesta1);
        jugador3.responder(pregunta, respuesta2);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }
    @org.junit.jupiter.api.Test
    public void test04JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaVerdaderoFalsoClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuesta2);
        jugador2.responder(pregunta, respuesta1);
        jugador3.responder(pregunta, respuesta1);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }
    @org.junit.jupiter.api.Test
    public void test05VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaVerdaderoFalsoClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.activarAnuladorDePuntaje(pregunta);
        jugador2.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuesta1);
        jugador2.responder(pregunta, respuesta1);
        jugador3.responder(pregunta, respuesta1);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador2);


        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }

    @org.junit.jupiter.api.Test
    public void test06JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaVerdaderoFalsoPenalidad__() throws AnuladorSeUsaMasDeUnaVez {

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Gano la seleccion la copa america?";
        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Todavia No");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("Si", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuesta1);
        jugador2.responder(pregunta, respuesta1);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);

    }
    @org.junit.jupiter.api.Test
    public void test07JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaVerdaderoFalsoPenalidad__() throws AnuladorSeUsaMasDeUnaVez {

        int puntajeEsperadoJugador1 = -1;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Gano la seleccion la copa america?";
        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Todavia No");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("Si", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuesta2);
        jugador2.responder(pregunta, respuesta1);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);

    }
    @org.junit.jupiter.api.Test
    public void test08VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaVerdaderoFalsoPenalidad__() throws AnuladorSeUsaMasDeUnaVez {

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = -1;
        int puntajeEsperadoJugador3 = 0;
        int puntajeEsperadoJugador4 = -1;

        String enunciado = "Gano la seleccion la copa america?";
        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Todavia No");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("Si", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");
        Jugador jugador4 = new Jugador("Jugador 4");

        jugador1.activarAnuladorDePuntaje(pregunta);
        jugador2.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuesta1);
        jugador2.responder(pregunta, respuesta2);
        jugador3.responder(pregunta, respuesta1);
        jugador4.responder(pregunta, respuesta2);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);
        pregunta.puntuar(jugador4.obtenerRespuestas(), jugador4);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();
        int puntajeObtenidoJugador4 = jugador4.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
        assertEquals(puntajeEsperadoJugador4, puntajeObtenidoJugador4);

    }

    @org.junit.jupiter.api.Test
    public void test09JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoiceClasico__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new RespuestaClasica());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");
        Jugador jugador3 = new Jugador("Zenon");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuestaDeLaPregunta1);
        jugador1.responder(pregunta, respuestaDeLaPregunta2);

        jugador2.responder(pregunta, respuestaDeLaPregunta1);
        jugador2.responder(pregunta, respuestaDeLaPregunta2);

        jugador3.responder(pregunta, respuestaDeLaPregunta3);
        jugador3.responder(pregunta, respuestaDeLaPregunta4);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }
    @org.junit.jupiter.api.Test
    public void test10JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoiceClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de MúltipleChoiceclásico recibe una lista de respuestas de un jugador
        // y asigna correctamente puntos a los jugadores que respondieron correctamente✅.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new RespuestaClasica());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");
        Jugador jugador3 = new Jugador("Zenon");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuestaDeLaPregunta3);
        jugador1.responder(pregunta, respuestaDeLaPregunta4);

        jugador2.responder(pregunta, respuestaDeLaPregunta1);
        jugador2.responder(pregunta, respuestaDeLaPregunta2);

        jugador3.responder(pregunta, respuestaDeLaPregunta3);
        jugador3.responder(pregunta, respuestaDeLaPregunta4);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);

    }
    @org.junit.jupiter.api.Test
    public void test11VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaMultipleChoiceClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de MúltipleChoiceclásico recibe una lista de respuestas de un jugador
        // y asigna correctamente puntos a los jugadores que respondieron correctamente✅.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new RespuestaClasica());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");
        Jugador jugador3 = new Jugador("Zenon");


        jugador1.activarAnuladorDePuntaje(pregunta);
        jugador2.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuestaDeLaPregunta1);
        jugador1.responder(pregunta, respuestaDeLaPregunta2);

        jugador2.responder(pregunta, respuestaDeLaPregunta1);
        jugador2.responder(pregunta, respuestaDeLaPregunta2);

        jugador3.responder(pregunta, respuestaDeLaPregunta3);
        jugador3.responder(pregunta, respuestaDeLaPregunta4);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);

    }

    @org.junit.jupiter.api.Test
    public void test12JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoiceParcial__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 2;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez");
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli");
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new PreguntaMultipleChoiceParcial(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");
        Jugador jugador3 = new Jugador("Juan");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta,respuesta1);
        jugador1.responder(pregunta,respuesta2);
        jugador2.responder(pregunta,respuesta1);
        jugador2.responder(pregunta,respuesta2);
        jugador3.responder(pregunta,respuesta1);
        jugador3.responder(pregunta,respuesta4);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3,puntajeObtenidoJugador3);
    }
    @org.junit.jupiter.api.Test
    public void test13JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoiceParcial__() throws AnuladorSeUsaMasDeUnaVez{
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez");
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli");
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new PreguntaMultipleChoiceParcial(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");
        Jugador jugador3 = new Jugador("Juan");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta,respuesta1);
        jugador1.responder(pregunta,respuesta4);
        jugador2.responder(pregunta,respuesta1);
        jugador2.responder(pregunta,respuesta2);
        jugador3.responder(pregunta,respuesta1);
        jugador3.responder(pregunta,respuesta4);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3,puntajeObtenidoJugador3);
    }
    @org.junit.jupiter.api.Test
    public void test14VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaMultipleChoiceParcial__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez");
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli");
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new RespuestaClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new PreguntaMultipleChoiceParcial(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Manuel");
        Jugador jugador2 = new Jugador("Sebastian");
        Jugador jugador3 = new Jugador("Juan");

        jugador1.activarAnuladorDePuntaje(pregunta);
        jugador2.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta,respuesta1);
        jugador1.responder(pregunta,respuesta2);
        jugador2.responder(pregunta,respuesta1);
        jugador2.responder(pregunta,respuesta2);
        jugador3.responder(pregunta,respuesta1);
        jugador3.responder(pregunta,respuesta4);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3,puntajeObtenidoJugador3);
    }

    @org.junit.jupiter.api.Test
    public void test15JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoicePenalidad__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 2;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = -2;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new RespuestaConPenalidad());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new PreguntaMultipleChoicePenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");
        Jugador jugador3 = new Jugador("Zenon");


        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuestaDeLaPregunta1);
        jugador1.responder(pregunta, respuestaDeLaPregunta2);

        jugador2.responder(pregunta, respuestaDeLaPregunta1);
        jugador2.responder(pregunta, respuestaDeLaPregunta2);

        jugador3.responder(pregunta, respuestaDeLaPregunta3);
        jugador3.responder(pregunta, respuestaDeLaPregunta4);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }
    @org.junit.jupiter.api.Test
    public void test16JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoicePenalidad__() throws AnuladorSeUsaMasDeUnaVez{
        int puntajeEsperadoJugador1 = -2;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = -2;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new RespuestaConPenalidad());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new PreguntaMultipleChoicePenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");
        Jugador jugador3 = new Jugador("Zenon");

        jugador1.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuestaDeLaPregunta3);
        jugador1.responder(pregunta, respuestaDeLaPregunta4);

        jugador2.responder(pregunta, respuestaDeLaPregunta1);
        jugador2.responder(pregunta, respuestaDeLaPregunta2);

        jugador3.responder(pregunta, respuestaDeLaPregunta3);
        jugador3.responder(pregunta, respuestaDeLaPregunta4);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }
    @org.junit.jupiter.api.Test
    public void test17VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaMultipleChoicePenalidad__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new RespuestaConPenalidad());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new RespuestaConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new PreguntaMultipleChoicePenalidad(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Riquelme");
        Jugador jugador2 = new Jugador("Palermo");
        Jugador jugador3 = new Jugador("Zenon");

        jugador1.activarAnuladorDePuntaje(pregunta);
        jugador2.activarAnuladorDePuntaje(pregunta);

        jugador1.responder(pregunta, respuestaDeLaPregunta1);
        jugador1.responder(pregunta, respuestaDeLaPregunta2);

        jugador2.responder(pregunta, respuestaDeLaPregunta1);
        jugador2.responder(pregunta, respuestaDeLaPregunta2);

        jugador3.responder(pregunta, respuestaDeLaPregunta1);
        jugador3.responder(pregunta, respuestaDeLaPregunta2);

        pregunta.puntuar(jugador1.obtenerRespuestas(), jugador1);
        pregunta.puntuar(jugador2.obtenerRespuestas(), jugador2);
        pregunta.puntuar(jugador3.obtenerRespuestas(), jugador3);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();


        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }
}
