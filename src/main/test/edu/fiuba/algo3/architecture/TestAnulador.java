package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Anulador.AnuladorClasico;
import edu.fiuba.algo3.modelo.Anulador.AnuladorPenalidad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestAnulador {
    @Test
    public void test01JugadorUtilizaAnuladorVecesYTiraExcepcion() throws AnuladorSeUsaMasDeUnaVez {
        int cantidadCatchesEsperador = 0;
        int cantidadCatchesObtenidos = 1;
        Jugador jugador1 = new Jugador("Spirulina");
        Pregunta pregunta = new Pregunta(null,null,null,new AnuladorClasico());
        jugador1.activarAnuladorDePuntaje(pregunta);
        try {
            jugador1.activarAnuladorDePuntaje(pregunta);
        } catch (AnuladorSeUsaMasDeUnaVez error) {
            cantidadCatchesEsperador++;
        }
        assertEquals(cantidadCatchesEsperador,cantidadCatchesObtenidos);
    }

    @Test
    public void test02JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaVerdaderoFalsoClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles,new PuntuarVerdaderoFalsoClasico(),new AnuladorClasico());

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
    @Test
    public void test03JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaVerdaderoFalsoClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles,new PuntuarVerdaderoFalsoClasico(),new AnuladorClasico());
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
    @Test
    public void test04VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaVerdaderoFalsoClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles,new PuntuarVerdaderoFalsoClasico(),new AnuladorClasico());

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

    @Test
    public void test05JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaVerdaderoFalsoPenalidad__() throws AnuladorSeUsaMasDeUnaVez {

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Gano la seleccion la copa america?";
        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles,new PuntuarVerdaderoFalsoPenalidad(),new AnuladorPenalidad());

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
    @Test
    public void test06JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaVerdaderoFalsoPenalidad__() throws AnuladorSeUsaMasDeUnaVez {

        int puntajeEsperadoJugador1 = -1;
        int puntajeEsperadoJugador2 = 0;

        String enunciado = "Gano la seleccion la copa america?";
        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles,new PuntuarVerdaderoFalsoPenalidad(),new AnuladorPenalidad());

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
    @Test
    public void test07VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaVerdaderoFalsoPenalidad__() throws AnuladorSeUsaMasDeUnaVez {

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = -1;
        int puntajeEsperadoJugador3 = 0;
        int puntajeEsperadoJugador4 = -1;

        String enunciado = "Gano la seleccion la copa america?";
        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles,new PuntuarVerdaderoFalsoPenalidad(),new AnuladorPenalidad());

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

    @Test
    public void test08JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoiceClasico__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1", "0");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2", "0");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new PenalidadClasica());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceClasico(respuestasPosibles), new AnuladorClasico());

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
    @Test
    public void test09JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoiceClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de MúltipleChoiceclásico recibe una lista de respuestas de un jugador
        // y asigna correctamente puntos a los jugadores que respondieron correctamente✅.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1", "0");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2", "0");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new PenalidadClasica());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceClasico(respuestasPosibles), new AnuladorClasico());

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
    @Test
    public void test10VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaMultipleChoiceClasico__() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de MúltipleChoiceclásico recibe una lista de respuestas de un jugador
        // y asigna correctamente puntos a los jugadores que respondieron correctamente✅.

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1", "0");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("2", "0");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new PenalidadClasica());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("4", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceClasico(respuestasPosibles), new AnuladorClasico());

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

    @Test
    public void test11JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoiceParcial__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 2;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani", "0");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez","0");
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli","0");
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceParcial(), new AnuladorClasico());

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
    @Test
    public void test12JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoiceParcial__() throws AnuladorSeUsaMasDeUnaVez{
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani", "0");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez","0");
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli","0");
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceParcial(), new AnuladorClasico());

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
    @Test
    public void test13VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaMultipleChoiceParcial__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuales fueron los 3 arqueros de Argentina en el mundial 2022?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Franco Armani", "0");
        RespuestaCorrecta respuesta2 = new RespuestaCorrecta("Emiliano Martinez","0");
        RespuestaCorrecta respuesta3 = new RespuestaCorrecta("Geronimo Rulli","0");
        RespuestaIncorrecta respuesta4 = new RespuestaIncorrecta("Sergio Romero", new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoiceParcial(), new AnuladorClasico());

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

    @Test
    public void test14JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoicePenalidad__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 2;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = -2;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1", "0");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("1", "0");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoicePenalidad(), new AnuladorPenalidad());

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
    @Test
    public void test15JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaMultipleChoicePenalidad__() throws AnuladorSeUsaMasDeUnaVez{
        int puntajeEsperadoJugador1 = -2;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = -2;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1", "0");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("1", "0");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoicePenalidad(), new AnuladorPenalidad());

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
    @Test
    public void test16VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaMultipleChoicePenalidad__() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Cuantas patas puede tener una gallina (cero no cuenta)?";

        RespuestaCorrecta respuestaDeLaPregunta1 = new RespuestaCorrecta("1", "0");
        RespuestaCorrecta respuestaDeLaPregunta2 = new RespuestaCorrecta("1", "0");
        RespuestaIncorrecta respuestaDeLaPregunta3 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());
        RespuestaIncorrecta respuestaDeLaPregunta4 = new RespuestaIncorrecta("3", new PenalidadConPenalidad());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuestaDeLaPregunta1);
        respuestasPosibles.add(respuestaDeLaPregunta2);
        respuestasPosibles.add(respuestaDeLaPregunta3);
        respuestasPosibles.add(respuestaDeLaPregunta4);

        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarMultipleChoicePenalidad(), new AnuladorPenalidad());

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

    @Test
    public void test17JugadorActivaAnuladorRespondeBienYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaOrderChoice__() throws AnuladorSeUsaMasDeUnaVez {

    }
    @Test
    public void test18JugadorActivaAnuladorRespondeMalYotrosJugadoresNoGananPuntosPorLaPregunta__PreguntaOrderChoice__() throws AnuladorSeUsaMasDeUnaVez {

    }
    @Test
    public void test19VariosJugadoresActivanAnuladorYNingunJugadorGanaPuntos__PreguntaOrderChoice__() throws AnuladorSeUsaMasDeUnaVez {

    }
}
