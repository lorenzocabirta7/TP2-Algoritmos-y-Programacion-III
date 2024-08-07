package edu.fiuba.algo3.modelo.ModoDePregunta;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class OrderedChoice implements TipoDePregunta{

    private TipoDePenalidad penalidad;
    public OrderedChoice(TipoDePenalidad unaPenalidad){
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


    @Override
    public String getTipoDePregunta(String mensaje) {
        String mensajePenalidad = "Penalidad: ";
        return mensaje + "Ordered Choice " + penalidad.getTipoPenalidad(mensajePenalidad);
    }

    @Override
    public boolean EsDeOrderedChoice() {
        return true;
    }

    @Override
    public boolean EsDeMultipleChoice() {
        return false;
    }

    @Override
    public boolean EsDeVerdaderoFalso() {
        return false;
    }

    @Override
    public boolean EsDeGroupChoice() {
        return false;
    }

    @Override
    public void activarExclusividad() throws ExclusividadInvalida {
        penalidad.activarExlcusividad();
    }

}
