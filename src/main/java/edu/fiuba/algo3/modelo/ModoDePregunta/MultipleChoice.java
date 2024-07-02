package edu.fiuba.algo3.modelo.ModoDePregunta;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class MultipleChoice implements TipoDePregunta{
    private TipoDePenalidad penalidad;


    public MultipleChoice(TipoDePenalidad unaPenalidad){
        this.penalidad = unaPenalidad;
    }

    @Override
    public int actualizarPuntaje(int puntosPorRespuestaCorrecta, ArrayList<Respuesta> respuestasDelJugador, ArrayList<Respuesta> respuestasDeLaPregunta) {

        int respuestasCorrectas = 0;
        int respuestasCorrectasDelJugador = 0;
        int respuestasIncorrectas = 0;
        for (Respuesta respuesta : respuestasDeLaPregunta) {
            if (respuesta.EsCorrecta(respuesta)){
                respuestasCorrectas++;
            }
        }
        for (Respuesta respuesta : respuestasDelJugador) {
            if (respuesta.EsCorrecta(respuesta)){
                respuestasCorrectasDelJugador++;
            } else {
                respuestasIncorrectas++;
            }
        }
        int puntaje = penalidad.penalizarPuntaje(puntosPorRespuestaCorrecta, respuestasCorrectasDelJugador,respuestasIncorrectas, respuestasCorrectas);
        return puntaje;
    }

    @Override
    public String getTipoDePregunta() {
        return "Pregunta: Multiple Choice \n Penalidad: " + penalidad.getTipoPenalidad();
    }

    @Override
    public boolean EsDeOrderedChoice() {
        return false;
    }

    @Override
    public boolean EsDeMultipleChoice() {
        return true;
    }

    @Override
    public boolean EsDeVerdaderoFalso() {
        return false;
    }

    @Override
    public boolean EsDeGroupChoice() {
        return false;
    }

}
