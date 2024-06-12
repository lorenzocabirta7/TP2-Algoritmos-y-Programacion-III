package main.Anulador;

import main.Jugador;

import java.util.ArrayList;

public class AnuladorClasico extends GestorAnulador {
    @Override
    public int puntosLuegoDeEvaluacion(int puntajeNoAnulado, ArrayList<Jugador> jugaodoresQueUsaronAnulador, Jugador unJugador){
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
                    puntosObtenidos = 0;
                }
            }else {
                puntosObtenidos = 0;
            }
        }
        return puntosObtenidos;
    }
}
