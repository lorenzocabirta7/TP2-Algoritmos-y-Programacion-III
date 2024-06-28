package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ModoDePregunta.VerdaderoOFalso;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadSeUsaMasdeDosVeces;
import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaVerdaderoFalso {
    @Test
    public void test01TresJugadoresJueganUnaRonda() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 1;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadClasica()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.responder(pregunta, respuesta2);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.responder(pregunta, respuesta1);
        jugador2.confirmarRespuesta(pregunta);

        jugador3.responder(pregunta, respuesta2);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);

    }
    @Test
    public void test02TresJugadoresJueganUnaRondaVerdaderoFalsoConPenalidad() throws AnuladorSeUsaMasDeUnaVez {
        int puntajeEsperadoJugador1 = -1;
        int puntajeEsperadoJugador2 = 1;
        int puntajeEsperadoJugador3 = -1;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadConPenalidad()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.responder(pregunta, respuesta2);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.responder(pregunta, respuesta1);
        jugador2.confirmarRespuesta(pregunta);

        jugador3.responder(pregunta, respuesta2);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }

    @Test
    public void test03TresJugadoresJueganUnaRondaVerdaderoFalsoConPenalidadUsandoMultiplicadores() throws AnuladorSeUsaMasDeUnaVez, ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperadoJugador1 = -2;
        int puntajeEsperadoJugador2 = 3;
        int puntajeEsperadoJugador3 = -1;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadConPenalidad()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.activarDuplicadorDePuntaje();
        jugador1.responder(pregunta, respuesta2);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.activarTriplicadorDePuntaje();
        jugador2.responder(pregunta, respuesta1);
        jugador2.confirmarRespuesta(pregunta);


        jugador3.responder(pregunta, respuesta2);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }


    @Test
    public void test04TresJugadoresJueganUnaRondaVerdaderoFalsoConPenalidadUsandoAnulador() throws AnuladorSeUsaMasDeUnaVez, ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 0;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadConPenalidad()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.activarAnuladorDePuntaje(pregunta);
        jugador1.responder(pregunta, respuesta2);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.activarAnuladorDePuntaje(pregunta);
        jugador2.responder(pregunta, respuesta1);
        jugador2.confirmarRespuesta(pregunta);


        jugador3.responder(pregunta, respuesta2);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }

    @Test
    public void test06TresJugadoresJueganUnaRondaVerdaderoFalsoConPenalidadSoloUnoDeEllosUsaAnuladorYEseRespondeBien() throws AnuladorSeUsaMasDeUnaVez, ModificadorSeUsaMasDeUnaVezException {
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 1;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadConPenalidad()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.responder(pregunta, respuesta2);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.activarAnuladorDePuntaje(pregunta);
        jugador2.responder(pregunta, respuesta1);
        jugador2.confirmarRespuesta(pregunta);

        jugador3.responder(pregunta, respuesta2);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }

    @Test
    public void test07TresJugadoresJueganUnaRondaVerdaderoFalsoConPenalidadSoloUnoDeEllosUsaAnuladorYOtroRespondeBien() throws AnuladorSeUsaMasDeUnaVez, ModificadorSeUsaMasDeUnaVezException {

        // Supuesto, si un jugador activa el anulador de Puntaje y se usa en una pregunta con Penalidad, este puede restar puntos
        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = -1;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadConPenalidad()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.responder(pregunta, respuesta1);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.activarAnuladorDePuntaje(pregunta);
        jugador2.responder(pregunta, respuesta2);
        jugador2.confirmarRespuesta(pregunta);

        jugador3.responder(pregunta, respuesta2);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }

    @Test
    public void test08TresJugadoresJueganUnaRondaVerdaderoFalsoSinPenalidadSoloUnoDeEllosUsaExclusividadYRespondeBien() throws AnuladorSeUsaMasDeUnaVez, ModificadorSeUsaMasDeUnaVezException, ExclusividadInvalida, ExclusividadSeUsaMasdeDosVeces {

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 2;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadClasica()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.responder(pregunta, respuesta2);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.activarExclusividad(pregunta);
        jugador2.responder(pregunta, respuesta1);
        jugador2.confirmarRespuesta(pregunta);

        jugador3.responder(pregunta, respuesta2);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }

    @Test
    public void test09TresJugadoresJueganUnaRondaVerdaderoFalsoSinPenalidadLosTresUsanExclusividadYUnoRespondeBien() throws AnuladorSeUsaMasDeUnaVez, ModificadorSeUsaMasDeUnaVezException, ExclusividadInvalida, ExclusividadSeUsaMasdeDosVeces {

        int puntajeEsperadoJugador1 = 0;
        int puntajeEsperadoJugador2 = 6;
        int puntajeEsperadoJugador3 = 0;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadClasica()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.activarExclusividad(pregunta);
        jugador1.responder(pregunta, respuesta2);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.activarExclusividad(pregunta);
        jugador2.responder(pregunta, respuesta1);
        jugador2.confirmarRespuesta(pregunta);

        jugador3.activarExclusividad(pregunta);
        jugador3.responder(pregunta, respuesta2);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }

    @Test
    public void test10TresJugadoresJueganUnaRondaVerdaderoFalsoSinPenalidadLosTresUsanExclusividadYTodosRespondenBien() throws AnuladorSeUsaMasDeUnaVez, ModificadorSeUsaMasDeUnaVezException, ExclusividadInvalida, ExclusividadSeUsaMasdeDosVeces {

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;
        int puntajeEsperadoJugador3 = 1;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si","0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciado, "Un Tema",respuestasPosibles, new VerdaderoOFalso(new PenalidadClasica()));
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");

        jugador1.activarExclusividad(pregunta);
        jugador1.responder(pregunta, respuesta1);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.activarExclusividad(pregunta);
        jugador2.responder(pregunta, respuesta1);
        jugador2.confirmarRespuesta(pregunta);

        jugador3.activarExclusividad(pregunta);
        jugador3.responder(pregunta, respuesta1);
        jugador3.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();
        int puntajeObtenidoJugador3 = jugador3.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1, puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2, puntajeObtenidoJugador2);
        assertEquals(puntajeEsperadoJugador3, puntajeObtenidoJugador3);
    }

}
