package TestClases;

import main.PreguntaVerdaderoFalsoClasico;
import main.Respuesta;
import main.RespuestaCorrectaVerdaderoFalsoClasico;
import main.RespuestaIncorrectaVerdaderoFalsoClasico;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPreguntaVerdaderoFalsoClasico {
    @org.junit.jupiter.api.Test
    public void Test01UnaPreguntaVerdaderoFalsoClasicoSeInicializaCorrectamenteConSusContenidos() {

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        RespuestaCorrectaVerdaderoFalsoClasico respuesta1 = new RespuestaCorrectaVerdaderoFalsoClasico();
        RespuestaIncorrectaVerdaderoFalsoClasico respuesta2 = new RespuestaIncorrectaVerdaderoFalsoClasico();

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
