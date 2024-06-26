package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaAVerificar;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaAVerificar {

    @Test
    public void Test01UnaRespuestaAVerificarSeInicializaCorrectamente(){
        String enunciadoEsperado = "enunciado De Prueba";
        String ordenEsperado = "0";

        Respuesta respuesta1 = new RespuestaAVerificar("enunciado De Prueba", "0");

        String enunciadoObtenido = respuesta1.getRespuesta();
        String ordenObtenido = respuesta1.getOrdenParcial();

        assertEquals(enunciadoEsperado, enunciadoObtenido);
        assertEquals(ordenEsperado, ordenObtenido);
    }


    @Test
    public void Test02UnaRespuestaAVerificarSeActualizaAUnaRespuestaCorrectaDeFormaCorrecta(){

        Boolean respuestaEsperada = true;

        Respuesta respuestaCorrecta = new RespuestaCorrecta("enunciado De Prueba", "2");

        Respuesta respuestaAVerificar = new RespuestaAVerificar("enunciado De Prueba", "2");

        Boolean respuestaObtenida = respuestaAVerificar.EsCorrecta(respuestaCorrecta);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void Test03UnaRespuestaAVerificarSeActualizaAUnaRespuestaIncorrectaDeFormaCorrecta(){

        Boolean respuestaEsperada = false;

        Respuesta respuestaIncorrecta = new RespuestaIncorrecta("enunciado De Prueba", new PenalidadClasica());

        Respuesta respuestaAVerificar = new RespuestaAVerificar("enunciado De Prueba", "2");

        Boolean respuestaObtenida = respuestaAVerificar.EsCorrecta(respuestaIncorrecta);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void Test04UnaRespuestaAVerificarActualizaElPuntajeDeFormaCorrectaCuandoRespondeBien(){

        int puntajeEsperado = 1;

        Respuesta respuestaCorrecta = new RespuestaCorrecta("enunciado De Prueba", "2");

        Respuesta respuestaAVerificar = new RespuestaAVerificar("enunciado De Prueba", "2");

        TipoDePenalidad unaPenalidad = new PenalidadClasica();

        int puntajeObtenido = respuestaAVerificar.actualizarPuntaje(1,unaPenalidad, respuestaCorrecta);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void Test05UnaRespuestaAVerificarActualizaElPuntajeDeFormaCorrectaCuandoRespondeMal(){

        int puntajeEsperado = 0;

        Respuesta respuestaCorrecta = new RespuestaCorrecta("enunciado De Prueba", "2");

        Respuesta respuestaAVerificar = new RespuestaAVerificar("enunciado De Prueba", "2.0");

        TipoDePenalidad unaPenalidad = new PenalidadClasica();

        int puntajeObtenido = respuestaAVerificar.actualizarPuntaje(1,unaPenalidad, respuestaCorrecta);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void Test05UnaRespuestaAVerificarActualizaElPuntajeDeFormaCorrectaCuandoRespondeBienAunqueHayanMasDe2RespuestasCorrectas(){

        int puntajeEsperado = 1;

        Respuesta respuestaCorrecta1 = new RespuestaCorrecta("enunciado De Prueba", "2");
        Respuesta respuestaCorrecta2 = new RespuestaCorrecta("enunciado De Prueba2", "-3");

        Respuesta respuestaAVerificar = new RespuestaAVerificar("enunciado De Prueba", "2");

        TipoDePenalidad unaPenalidad = new PenalidadClasica();

        int puntajeObtenido = respuestaAVerificar.actualizarPuntaje(1,unaPenalidad, respuestaCorrecta1);
        puntajeObtenido += respuestaAVerificar.actualizarPuntaje(1,unaPenalidad, respuestaCorrecta2);


        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}
