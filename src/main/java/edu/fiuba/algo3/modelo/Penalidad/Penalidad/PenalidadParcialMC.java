package edu.fiuba.algo3.modelo.Penalidad.Penalidad;

public class PenalidadParcialMC implements TipoDePenalidad{
    @Override
    public int penalizarPuntaje(int puntaje) {
        return 0;
    }

    @Override
    public int penalizarPuntaje(int puntosPorRespuestaCorrecta, int respuestasCorrectasDelJugador, int respuestasIncorrectas, int respuestasCorrectas) {
        if(respuestasIncorrectas > 0 ){
            return 0;
        }else{
            return respuestasCorrectasDelJugador*puntosPorRespuestaCorrecta;
        }
    }
}
