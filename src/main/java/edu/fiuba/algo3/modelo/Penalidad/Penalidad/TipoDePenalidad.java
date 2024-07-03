package edu.fiuba.algo3.modelo.Penalidad.Penalidad;

import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

public interface TipoDePenalidad {
    public int penalizarPuntaje(int puntaje);

    int penalizarPuntaje(int puntosPorRespuestaCorrecta, int respuestasCorrectasDelJugador, int respuestasIncorrectas, int respuestasCorrectas);

    String getTipoPenalidad(String mensaje);

    void activarExlcusividad() throws ExclusividadInvalida;
}
