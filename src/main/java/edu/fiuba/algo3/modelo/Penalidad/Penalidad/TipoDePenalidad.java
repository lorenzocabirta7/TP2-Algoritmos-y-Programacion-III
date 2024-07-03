package edu.fiuba.algo3.modelo.Penalidad.Penalidad;

public interface TipoDePenalidad {
    public int penalizarPuntaje(int puntaje);

    int penalizarPuntaje(int puntosPorRespuestaCorrecta, int respuestasCorrectasDelJugador, int respuestasIncorrectas, int respuestasCorrectas);

    String getTipoPenalidad(String mensaje);
}
