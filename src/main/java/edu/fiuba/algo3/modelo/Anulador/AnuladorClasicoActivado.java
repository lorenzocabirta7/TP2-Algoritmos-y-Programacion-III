package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class AnuladorClasicoActivado implements EstadoAnulador {

    @Override
    public int puntosLuegoDeEvaluacion(int puntajeNoAnulado, ArrayList<Jugador> jugaodoresQueUsaronAnulador, Jugador unJugador){
        int puntosObtenidos = puntajeNoAnulado;
        boolean jugadorEncontrado = false;
        if (jugaodoresQueUsaronAnulador.size() == 1) {
            for (Jugador jugador : jugaodoresQueUsaronAnulador) {
                if (jugador == unJugador) {
                    jugadorEncontrado = true;
                    break;
                }
            }
            if (!jugadorEncontrado){
                puntosObtenidos = 0;
            }
        }else {
            puntosObtenidos = 0;
        }
        return puntosObtenidos;
    }

}
