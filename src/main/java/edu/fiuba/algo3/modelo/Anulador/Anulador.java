package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public interface Anulador {
    public void activar();
    public int puntosLuegoDeEvaluacion(int puntajeNoAnulado, ArrayList<Jugador> jugaodoresQueUsaronAnulador, Jugador unJugador);
}