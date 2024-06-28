package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class AnuladorActivado implements EstadoAnulador {

    @Override
    public int anular(int puntaje, Jugador jugador, ArrayList<Jugador> jugadoresQueUsaronAnulador){

        if (jugadoresQueUsaronAnulador.size() == 1 && jugador.equals(jugadoresQueUsaronAnulador.get(0))){
            return puntaje;
        }
        return 0;
    }
}
