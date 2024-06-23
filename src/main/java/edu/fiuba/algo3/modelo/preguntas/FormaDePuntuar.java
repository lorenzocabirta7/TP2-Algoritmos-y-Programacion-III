package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.*;

import java.util.ArrayList;

public abstract class FormaDePuntuar {

    protected ArrayList<Jugador> jugadoresQueUsaronAnulador = new ArrayList<Jugador>();;

    public abstract int puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador);

    public void agregarJugadorQueUsoAnulador(Jugador jugador){
        this.jugadoresQueUsaronAnulador.add(jugador);
    }
}