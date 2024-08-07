package edu.fiuba.algo3.modelo.Exclusividad;


import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class ExclusividadActivado implements EstadoExclusividad {


    @Override
    public int excluir(int puntaje, Jugador jugador, ArrayList<Jugador> jugadoresQueUsaronExclusividad, ArrayList<Jugador> jugadoresQueRespondieronCorrectamente) {
        int multiplicador = jugadoresQueUsaronExclusividad.size() * 2;
        if (jugadoresQueRespondieronCorrectamente.size() == 1 && jugador.equals(jugadoresQueRespondieronCorrectamente.get(0))){
            return puntaje * multiplicador;
        }
        return 0;
    }
}