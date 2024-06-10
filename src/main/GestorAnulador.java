package main;

import java.util.ArrayList;

public abstract class GestorAnulador {
    private boolean activado = false;

    public void activar() {this.activado = true;}

    public abstract int puntosLuegoDeEvaluacion(int puntajeNoAnulado, ArrayList<Jugador> jugaodoresQueUsaronAnulador, Jugador unJugador);
}
