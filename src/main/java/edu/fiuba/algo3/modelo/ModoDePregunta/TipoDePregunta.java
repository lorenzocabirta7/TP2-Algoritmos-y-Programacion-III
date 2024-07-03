package edu.fiuba.algo3.modelo.ModoDePregunta;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public interface TipoDePregunta {
    int actualizarPuntaje(int puntosPorRespuestaCorrecta, ArrayList<Respuesta> respuestasDelJugador,ArrayList<Respuesta> respuestasDeLaPregunta);

    String getTipoDePregunta(String mensaje);


    boolean EsDeOrderedChoice();

    boolean EsDeMultipleChoice();

    boolean EsDeVerdaderoFalso();

    boolean EsDeGroupChoice();
}
