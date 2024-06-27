package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class ExclusividadDesactivado implements Exclusividad {
    public ExclusividadDesactivado() {

    }
    public int puntosLuegoDeEvaluacion(int puntajeSinModificar, ArrayList<Jugador> jugaodoresQueUsaronExclusividad, Jugador jugadorEvaluado, Jugador juagdorAlQueSeLeAplica) {
        return puntajeSinModificar;
    }
}
