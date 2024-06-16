package edu.fiuba.algo3.modelo.Anulador;



import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class AnuladorPenalidad extends GestorAnulador {
    @Override
    public int puntosLuegoDeEvaluacion(int puntajeNoAnulado, ArrayList<Jugador> jugaodoresQueUsaronAnulador, Jugador unJugador) {
        int puntosObtenidos = puntajeNoAnulado;
        if (this.activado) {
            boolean jugadorEncontrado = false;
            if (jugaodoresQueUsaronAnulador.size() == 1) {
                for (Jugador jugador : jugaodoresQueUsaronAnulador) {
                    if (jugador == unJugador) {
                        jugadorEncontrado = true;
                        break;
                    }
                }
                if (!jugadorEncontrado){
                    if (puntosObtenidos > 0){
                        puntosObtenidos = 0;
                    }
                }
            }else {
                if (puntosObtenidos > 0){
                    puntosObtenidos = 0;
                }
            }
        }
        return puntosObtenidos;
    }
}
