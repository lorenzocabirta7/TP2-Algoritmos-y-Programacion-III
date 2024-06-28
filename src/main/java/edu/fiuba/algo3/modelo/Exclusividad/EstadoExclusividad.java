package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public interface EstadoExclusividad {

    public int excluir(int puntaje, Jugador jugador, ArrayList<Jugador> jugadoresQueUsaronAnulador, ArrayList<Jugador> jugadoresQueRespondieronCorrectamente);
}
