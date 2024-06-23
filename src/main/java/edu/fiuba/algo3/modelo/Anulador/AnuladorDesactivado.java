package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class AnuladorDesactivado implements EstadoAnulador{
    @Override
    public int puntosLuegoDeEvaluacion(int puntajeNoAnulado, ArrayList<Jugador> jugaodoresQueUsaronAnulador, Jugador unJugador) {
        return puntajeNoAnulado;
    }
}