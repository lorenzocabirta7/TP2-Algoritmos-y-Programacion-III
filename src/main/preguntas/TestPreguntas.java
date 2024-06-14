package main.preguntas;

import main.Anulador.AnuladorClasico;
import main.Jugador;
import main.Respuestas.*;
import main.Respuestas.Penalidad.PenalidadClasica;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntas {
    @org.junit.jupiter.api.Test
    public void Test01PreguntaVerdaderoFalsoClasicoRecibeEnunciadoYListaDeRespuestasYSeInicializaCorrectamente(){

        String enunciadoEsperado = "Estamos en el año 2024?";
        String enunciadoRespuestaCorrecta = "SI";
        String enunciadoRespuestaIncorrecta = "NO";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, "0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta(enunciadoRespuestaCorrecta, new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        Pregunta pregunta = new Pregunta(enunciadoEsperado, respuestasPosibles, new PuntuarVerdaderoFalsoClasico(), new AnuladorClasico());

        String enunciadoObtenido = pregunta.getEnunciado();
        ArrayList<Respuesta> respuestasObtenidas = pregunta.respuestasPosibles();

        assertEquals(enunciadoEsperado, enunciadoObtenido);
        assertEquals(respuestasPosibles, respuestasObtenidas);
    }
    @org.junit.jupiter.api.Test
    public void Test02PreguntaVerdaderoFalsoClasicoRecibeEnunciadoListaDeRespuestasYUnJugadorQueRespondeBienYPuntuaCorrectamente(){
        int puntajeEsperado = 1;
        String enunciado = "Estamos en el año 2024?";
        String enunciadoRespuestaCorrecta = "SI";
        String enunciadoRespuestaIncorrecta = "NO";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, "0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta(enunciadoRespuestaCorrecta, new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarVerdaderoFalsoClasico(), new AnuladorClasico());

        Jugador jugador = new Jugador("Jugador 1");
        RespuestaCorrecta respuestaDelJugador1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, "0");
        jugador.responder(pregunta, respuestaDelJugador1);
        jugador.confirmarRespuesta(pregunta);
        int puntajeObtenido = jugador.obtenerPuntos();

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @org.junit.jupiter.api.Test
    public void Test03PreguntaVerdaderoFalsoClasicoRecibeEnunciadoListaDeRespuestasYUnJugadorQueRespondeMalYPuntuaCorrectamente(){
        int puntajeEsperado = 0;
        String enunciado = "Estamos en el año 2024?";
        String enunciadoRespuestaCorrecta = "SI";
        String enunciadoRespuestaIncorrecta = "NO";

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta(enunciadoRespuestaCorrecta, "0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta(enunciadoRespuestaCorrecta, new PenalidadClasica());

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);
        Pregunta pregunta = new Pregunta(enunciado, respuestasPosibles, new PuntuarVerdaderoFalsoClasico(), new AnuladorClasico());

        Jugador jugador = new Jugador("Jugador 1");
        RespuestaIncorrecta respuestaDelJugador1 = new RespuestaIncorrecta(enunciadoRespuestaCorrecta, new PenalidadClasica());
        jugador.responder(pregunta, respuestaDelJugador1);
        jugador.confirmarRespuesta(pregunta);
        int puntajeObtenido = jugador.obtenerPuntos();

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

}
