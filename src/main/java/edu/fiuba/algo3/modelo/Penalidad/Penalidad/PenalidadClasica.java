package edu.fiuba.algo3.modelo.Penalidad.Penalidad;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class PenalidadClasica implements TipoDePenalidad {

    @Override
    public int penalizarPuntaje(int puntaje) {
        return 0;
    }

    public int penalizarPuntaje(int puntosTotales, int respuestasCorrectasDelJugador, int respuestasIncorrectas, int respuestasCorrectas){
        if (respuestasCorrectasDelJugador == respuestasCorrectas){
            return puntosTotales;
        } else{
            return 0;
        }
    }

    @Override
    public String getTipoPenalidad() {
        return "Clasica";
    }
}
