package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class AnuladorClasico implements Anulador{
    private EstadoAnulador estado = new AnuladorDesactivado();

    public void activar() {
        this.estado = new AnuladorClasicoActivado();
    }

    public int puntosLuegoDeEvaluacion(int puntajeNoAnulado, ArrayList<Jugador> jugaodoresQueUsaronAnulador, Jugador unJugador) {
        return estado.puntosLuegoDeEvaluacion(puntajeNoAnulado,jugaodoresQueUsaronAnulador, unJugador);
    }

}
