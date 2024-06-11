package TestClases;

import main.Respuestas.*;
import main.preguntas.Pregunta;
import main.preguntas.PuntuarVerdaderoFalsoClasico;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPuntuarVerdaderoFalsoClasico {
    @org.junit.jupiter.api.Test
    public void Test01UnaPreguntaVerdaderoFalsoClasicoSeInicializaCorrectamenteConSusContenidos() {

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si", new ConOrdenParcial("Si", "0"));
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadClasica());

        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        String enunciado = "Pregunta de Ejemplo";

        String enunciadoEsperado = enunciado;
        ArrayList<Respuesta> respuestasEsperadas = respuestas;

        Pregunta pregunta = new Pregunta(enunciado, respuestas, new PuntuarVerdaderoFalsoClasico());

        assertEquals(enunciadoEsperado, pregunta.getEnunciado());
        assertEquals(respuestasEsperadas, pregunta.respuestasPosibles());

    }
}
