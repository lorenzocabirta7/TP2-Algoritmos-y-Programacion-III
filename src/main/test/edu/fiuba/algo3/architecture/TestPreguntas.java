package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ModoDePregunta.VerdaderoOFalso;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntas {
    @Test
    public void Test01PreguntaVerdaderoFalsoClasicoRecibeEnunciadoYListaDeRespuestasYSeInicializaCorrectamente(){

        String enunciadoEsperado = "Estamos en el año 2024?";
        String enunciadoRespuestaCorrecta = "SI";
        String enunciadoRespuestaIncorrecta = "NO";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, "0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta(enunciadoRespuestaCorrecta);

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciadoEsperado, "Sin Tema", respuestasPosibles, new VerdaderoOFalso(new PenalidadClasica()));

        String enunciadoObtenido = pregunta.getEnunciado();
        ArrayList<Respuesta> respuestasObtenidas = pregunta.respuestasPosibles();

        assertEquals(enunciadoEsperado, enunciadoObtenido);
        assertEquals(respuestasPosibles, respuestasObtenidas);
    }
    @Test
    public void Test02PreguntaVerdaderoFalsoClasicoRecibeEnunciadoListaDeRespuestasYUnJugadorQueRespondeBienYPuntuaCorrectamente(){
        int puntajeEsperado = 1;
        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("SI", "0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("NO");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        Pregunta pregunta = new Pregunta("Un Enunciado", "Sin Tema", respuestasPosibles, new VerdaderoOFalso(new PenalidadClasica()));

        Jugador jugador = new Jugador("Jugador 1");
        RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta("SI","0");
        jugador.agregarRespuesta(pregunta, respuestaDelJugador1);
        jugador.confirmarRespuesta(pregunta);

        pregunta.puntuarJugadores();

        int puntajeObtenido = jugador.obtenerPuntos();

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void Test03PreguntaVerdaderoFalsoConPenalidadRecibeEnunciadoListaDeRespuestasYUnJugadorQueRespondeMalYPuntuaCorrectamente(){
    int puntajeEsperado1 = 1;


    String enunciado = "Estamos en el año 2024?";

    RespuestaCorrecta respuesta1 = new RespuestaCorrecta("SI", "0");
    RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("NO");

    ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
    respuestasPosibles.add(respuesta1);
    respuestasPosibles.add(respuesta2);

    Pregunta pregunta = new Pregunta("Un Enunciado", "Sin Tema", respuestasPosibles, new VerdaderoOFalso(new PenalidadClasica()));

    Jugador jugador = new Jugador("Jugador 1");
    RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta("SI","0");
    jugador.agregarRespuesta(pregunta, respuestaDelJugador1);
    jugador.confirmarRespuesta(pregunta);
    pregunta.puntuarJugadores();

    int puntajeObtenido = jugador.obtenerPuntos();

    assertEquals(puntajeEsperado1, puntajeObtenido);
    }


    @Test
    public void test04PreguntaDevuelveLosJugadoresQueRespondieronCorrectamente() {
        Respuesta respuesta1 = new RespuestaCorrecta("0", "0");
        Respuesta respuesta2 = new RespuestaCorrecta("2", "0");
        Respuesta respuesta3 = new RespuestaCorrecta("4", "0");
        Respuesta respuesta4 = new RespuestaIncorrecta("3");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        respuestasPosibles.add(respuesta3);
        respuestasPosibles.add(respuesta4);
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");


        Pregunta pregunta = new Pregunta("Cual De los Numeros son pares?", "unTema",respuestasPosibles, new VerdaderoOFalso(new PenalidadClasica()));

        jugador1.agregarRespuesta(pregunta, respuesta1);
        jugador1.agregarRespuesta(pregunta, respuesta2);
        jugador1.agregarRespuesta(pregunta, respuesta3);
        jugador1.confirmarRespuesta(pregunta);

        jugador2.agregarRespuesta(pregunta, respuesta1);
        jugador2.agregarRespuesta(pregunta, respuesta2);
        jugador2.agregarRespuesta(pregunta, respuesta3);
        jugador2.agregarRespuesta(pregunta, respuesta4);
        jugador2.confirmarRespuesta(pregunta);

        jugador3.agregarRespuesta(pregunta, respuesta1);
        jugador3.agregarRespuesta(pregunta, respuesta2);
        jugador3.agregarRespuesta(pregunta, respuesta3);
        jugador3.agregarRespuesta(pregunta, respuesta4);
        jugador3.confirmarRespuesta(pregunta);

        ArrayList<Jugador> jugadoresQueRespondieronBien = pregunta.getJugadoresQueRespondieronCorrectamente();

        assertEquals(jugadoresQueRespondieronBien.size(),3);
    }

}
