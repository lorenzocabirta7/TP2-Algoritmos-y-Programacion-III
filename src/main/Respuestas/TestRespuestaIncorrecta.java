package main.Respuestas;

import main.Respuestas.Penalidad.PenalidadClasica;
import main.Respuestas.Penalidad.PenalidadConPenalidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaIncorrecta {
    @org.junit.jupiter.api.Test
    public void Test01UnaRespuestaIncorrectaSeInicializaCorrectamente(){
        String enunciadoEsperado = "enunciado De Prueba";
        String ordenEsperado = "0";

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadClasica());

        String enunciadoObtenido = respuesta1.getEnunciado();
        String ordenObtenido = respuesta1.getOrdenParcial();

        assertEquals(enunciadoEsperado, enunciadoObtenido);
        assertEquals(ordenEsperado, ordenObtenido);
    }

    @org.junit.jupiter.api.Test
    public void Test02UnaRespuestaIncorrectaActuaComoUnaRespuestaIncorrecta(){

        Boolean respuestaEsperada = false;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadClasica());

        Boolean respuestaObtenida = respuesta1.EsCorrecta(respuesta1);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @org.junit.jupiter.api.Test
    public void Test03UnaRespuestaIncorrectaActualizaSuPuntajeDeManeraCorrectaSinPenalidad(){

        int puntajeEsperado = 0;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadClasica());

        int puntajeObtenido = respuesta1.actualizarPuntaje(1, respuesta1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @org.junit.jupiter.api.Test
    public void Test04UnaRespuestaIncorrectaActualizaSuPuntajeDeManeraCorrectaCuandoTienePenalidad(){

        int puntajeEsperado = -1;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadConPenalidad());

        int puntajeObtenido = respuesta1.actualizarPuntaje(1, respuesta1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
