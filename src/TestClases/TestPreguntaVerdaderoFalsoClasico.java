package TestClases;

import main.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPreguntaVerdaderoFalsoClasico {
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

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestas);

        assertEquals(enunciadoEsperado, pregunta.getEnunciado());
        assertEquals(respuestasEsperadas, pregunta.respuestasPosibles());

    }
}
