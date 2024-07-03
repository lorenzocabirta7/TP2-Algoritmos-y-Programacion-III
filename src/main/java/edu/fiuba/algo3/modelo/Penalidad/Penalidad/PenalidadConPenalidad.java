package edu.fiuba.algo3.modelo.Penalidad.Penalidad;

import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

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
    public String getTipoPenalidad(String mensaje) {
        return mensaje + "Con Penalidad";
    }

    @Override
    public void activarExlcusividad() throws ExclusividadInvalida {
        throw new ExclusividadInvalida("No se Puede usar la Exclusividad en una pregunta de Penalidad");
    }

}
