package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Anulador.AnuladorClasico;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PuntuarVerdaderoFalsoClasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPuntuarVerdaderoFalsoClasico {
    @Test
    public void Test01UnaPreguntaVerdaderoFalsoClasicoSeInicializaCorrectamenteConSusContenidos() {

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si", "0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadClasica());

        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        String enunciado = "Pregunta de Ejemplo";

        String enunciadoEsperado = enunciado;
        ArrayList<Respuesta> respuestasEsperadas = respuestas;

        Pregunta pregunta = new Pregunta(enunciado, respuestas, new PuntuarVerdaderoFalsoClasico(), new AnuladorClasico());

        assertEquals(enunciadoEsperado, pregunta.getEnunciado());
        assertEquals(respuestasEsperadas, pregunta.respuestasPosibles());

    }
}
