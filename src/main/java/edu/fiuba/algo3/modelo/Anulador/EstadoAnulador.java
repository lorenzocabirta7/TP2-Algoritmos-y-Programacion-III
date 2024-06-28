package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public interface EstadoAnulador {
    public int anular(int puntaje, Jugador jugador, ArrayList<Jugador> jugadoresQueUsaronAnulador);
}