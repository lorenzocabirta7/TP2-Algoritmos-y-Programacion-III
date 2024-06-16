package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRespuestaIncorrecta {
    @Test
    public void Test01UnaRespuestaIncorrectaSeInicializaCorrectamente(){
        String enunciadoEsperado = "enunciado De Prueba";
        String ordenEsperado = "0";

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadClasica());

        String enunciadoObtenido = respuesta1.getEnunciado();
        String ordenObtenido = respuesta1.getOrdenParcial();

        assertEquals(enunciadoEsperado, enunciadoObtenido);
        assertEquals(ordenEsperado, ordenObtenido);
    }

    @Test
    public void Test02UnaRespuestaIncorrectaActuaComoUnaRespuestaIncorrecta(){

        Boolean respuestaEsperada = false;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadClasica());

        Boolean respuestaObtenida = respuesta1.EsCorrecta(respuesta1);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void Test03UnaRespuestaIncorrectaActualizaSuPuntajeDeManeraCorrectaSinPenalidad(){

        int puntajeEsperado = 0;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadClasica());

        int puntajeObtenido = respuesta1.actualizarPuntaje(1, respuesta1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void Test04UnaRespuestaIncorrectaActualizaSuPuntajeDeManeraCorrectaCuandoTienePenalidad(){

        int puntajeEsperado = -1;

        Respuesta respuesta1 = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadConPenalidad());

        int puntajeObtenido = respuesta1.actualizarPuntaje(1, respuesta1);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
