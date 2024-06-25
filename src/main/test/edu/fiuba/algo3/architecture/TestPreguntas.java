package edu.fiuba.algo3.architecture;


import edu.fiuba.algo3.modelo.Anulador.AnuladorClasico;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PuntuarVerdaderoFalsoClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPreguntas {
    @Test
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
    @Test
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

    @Test
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
