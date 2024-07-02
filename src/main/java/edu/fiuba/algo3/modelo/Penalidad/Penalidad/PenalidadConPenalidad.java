package edu.fiuba.algo3.modelo.Penalidad.Penalidad;

public class PenalidadConPenalidad implements TipoDePenalidad {

    int penalidad = -1;
    @Override
    public int penalizarPuntaje(int puntaje){
        return (puntaje * penalidad);
    }

    @Override
    public int penalizarPuntaje(int puntosPorRespuestaCorrecta, int respuestasCorrectasDelJugador, int respuestasIncorrectas, int respuestasCorrectas) {
        int puntaje = 0;
        puntaje += puntosPorRespuestaCorrecta*respuestasCorrectasDelJugador;
        puntaje += puntosPorRespuestaCorrecta*respuestasIncorrectas*penalidad;
        return puntaje;
    }

    @Override
    public String getTipoPenalidad() {
        return "Con Penalidad";
    }

}
