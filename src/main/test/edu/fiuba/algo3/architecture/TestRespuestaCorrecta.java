package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaCorrecta {
    @org.junit.jupiter.api.Test
    public void Test01UnaRespuestaCorrectaSeInicializaCorrectamente(){
        String enunciadoEsperado = "enunciado De Prueba";
        String ordenEsperado = "0";

        Respuesta respuesta1 = new RespuestaCorrecta("enunciado De Prueba", "0");

        String enunciadoObtenido = respuesta1.getEnunciado();
        String ordenObtenido = respuesta1.getOrdenParcial();

        assertEquals(enunciadoEsperado, enunciadoObtenido);
        assertEquals(ordenEsperado, ordenObtenido);
    }

    @org.junit.jupiter.api.Test
    public void Test02UnaRespuestaCorrectaActuaComoUnaRespuestaCorrecta(){

        Boolean respuestaEsperada = true;

        Respuesta respuesta1 = new RespuestaCorrecta("enunciado De Prueba", "0");

        Boolean respuestaObtenida = respuesta1.EsCorrecta(respuesta1);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @org.junit.jupiter.api.Test
    public void Test03UnaRespuestaCorrectaActualizaSuPuntajeDeManeraCorrecta(){

        int puntajeEsperado = 1;

        Respuesta respuesta1 = new RespuestaCorrecta("enunciado De Prueba", "0");

        int puntajeObtenido = respuesta1.actualizarPuntaje(1, respuesta1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
