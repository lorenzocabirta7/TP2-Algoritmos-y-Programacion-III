package edu.fiuba.algo3.modelo.ModoDePregunta;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;
import java.util.Optional;

public class GroupChoice implements TipoDePregunta{

    private TipoDePenalidad penalidad;
    public GroupChoice(TipoDePenalidad unaPenalidad){
        this.penalidad = unaPenalidad;
    }

    @Override
    public int actualizarPuntaje(int puntosPorRespuestaCorrecta, ArrayList<Respuesta> respuestasDelJugador, ArrayList<Respuesta> respuestasDeLaPregunta) {
        //Codigo Duplicado, se le puede pedir a la pregunta
        int respuestasCorrectas = 0;
        int respuestasCorrectasDelJugador = 0;
        int respuestasIncorrectas = 0;

        for (Respuesta respuesta : respuestasDeLaPregunta) {
            if (respuesta.EsCorrecta(respuesta)){
                respuestasCorrectas++;
            }
        }
        for (Respuesta respuesta : respuestasDelJugador) {
            Optional<Respuesta> respuestaDeLaPregunta = respuestasDeLaPregunta.stream()
                    .filter(respuesta1 -> respuesta1.getRespuesta().equals(respuesta.getRespuesta()))
                    .findFirst();

            if (respuestaDeLaPregunta.isPresent() && respuesta.EsCorrecta(respuestaDeLaPregunta.get())) {
                respuestasCorrectasDelJugador++;
            } else {
                respuestasIncorrectas++;
            }
        }
        if (respuestasCorrectas == respuestasCorrectasDelJugador && respuestasIncorrectas == 0){
            return 1;
        }
        return 0;
    }
}
