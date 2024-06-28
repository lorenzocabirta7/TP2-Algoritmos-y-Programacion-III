package edu.fiuba.algo3.modelo.ModoDePregunta;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public class OrderedChoice implements TipoDePregunta{

    private TipoDePenalidad penalidad;
    public OrderedChoice(TipoDePenalidad unaPenalidad){
        this.penalidad = unaPenalidad;
    }


    @Override
    public int actualizarPuntaje(int puntaje, Respuesta respuestaDelJugador, Respuesta respuestaDeLaPregunta) {
        return respuestaDelJugador.actualizarPuntaje(puntaje, penalidad, respuestaDeLaPregunta);
    }
}
