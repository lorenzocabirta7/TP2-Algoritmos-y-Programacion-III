package edu.fiuba.algo3.modelo.Anulador;



import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public abstract class GestorAnulador {
    protected boolean activado = false;

    public void activar() {this.activado = true;}

    public abstract int puntosLuegoDeEvaluacion(int puntajeNoAnulado, ArrayList<Jugador> jugaodoresQueUsaronAnulador, Jugador unJugador);
}
