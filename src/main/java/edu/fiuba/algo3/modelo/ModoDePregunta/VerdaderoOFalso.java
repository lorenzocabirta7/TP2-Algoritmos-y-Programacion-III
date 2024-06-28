package edu.fiuba.algo3.modelo.ModoDePregunta;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class VerdaderoOFalso implements TipoDePregunta{

    private TipoDePenalidad penalidad;
    public VerdaderoOFalso(TipoDePenalidad unaPenalidad){
        this.penalidad = unaPenalidad;
    }

    @Override
    public int actualizarPuntaje(int puntosPorRespuestaCorrecta, ArrayList<Respuesta> respuestasDelJugador, ArrayList<Respuesta> respuestasDeLaPregunta) {
        int puntajeTotal = 0;
        for (Respuesta respuesta : respuestasDelJugador) {
            puntajeTotal += respuesta.actualizarPuntaje(puntosPorRespuestaCorrecta,penalidad,respuesta);
        }
        return puntajeTotal;
    }


    //@Override
    //public int actualizarPuntaje(int puntaje, Respuesta respuestaDelJugador, Respuesta respuestaDeLaPregunta) {
    //    return respuestaDelJugador.actualizarPuntaje(puntaje, penalidad, respuestaDeLaPregunta);
    //}
}
