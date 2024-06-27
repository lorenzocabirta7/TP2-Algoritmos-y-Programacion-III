package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.GestorPuntaje;
import java.util.ArrayList;

public class AnuladorClasicoActivado implements EstadoAnulador {
    //private GestorPuntaje gestorPuntaje = new GestorPuntaje();
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
                puntosObtenidos = GestorPuntaje.PuntajeError();
            }
        }else {
            puntosObtenidos = GestorPuntaje.PuntajeError();
        }
        return puntosObtenidos;
    }

}
