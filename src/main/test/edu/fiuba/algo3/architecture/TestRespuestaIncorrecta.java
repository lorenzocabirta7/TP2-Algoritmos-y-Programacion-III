package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRespuestaIncorrecta {
    @Test
    public void Test01UnaRespuestaIncorrectaSeInicializaCorrectamente(){
        String enunciadoEsperado = "enunciado De Prueba";
        String ordenEsperado = "0";

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba");

        String enunciadoObtenido = respuesta1.getRespuesta();
        String ordenObtenido = respuesta1.getOrdenParcial();

        assertEquals(enunciadoEsperado, enunciadoObtenido);
        assertEquals(ordenEsperado, ordenObtenido);
    }

    @Test
    public void Test02UnaRespuestaIncorrectaActuaComoUnaRespuestaIncorrecta(){

        Boolean respuestaEsperada = false;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba");

        Boolean respuestaObtenida = respuesta1.EsCorrecta(respuesta1);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void Test03UnaRespuestaIncorrectaActualizaSuPuntajeDeManeraCorrectaSinPenalidad(){

        int puntajeEsperado = 0;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba");

        int puntajeObtenido = respuesta1.actualizarPuntaje(1, new PenalidadClasica(), respuesta1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void Test04UnaRespuestaIncorrectaActualizaSuPuntajeDeManeraCorrectaCuandoTienePenalidad(){

        int puntajeEsperado = -1;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba");

        int puntajeObtenido = respuesta1.actualizarPuntaje(1, new PenalidadConPenalidad(), respuesta1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
