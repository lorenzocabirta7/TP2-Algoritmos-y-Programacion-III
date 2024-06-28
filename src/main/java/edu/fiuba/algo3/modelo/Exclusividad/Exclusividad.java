package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class Exclusividad {

    private EstadoExclusividad estadoExclusividad = new ExclusividadDesactivado();
    private ArrayList<Jugador> jugadoresQueUsaronBonificador = new ArrayList<>();

    public void activar(Jugador jugador){
        jugadoresQueUsaronBonificador.add(jugador);
        estadoExclusividad = new ExclusividadActivado();
    }

    public int excluir(int puntaje, Jugador jugador, ArrayList<Jugador> jugadoresQueRespondieronCorrectamente){
        return estadoExclusividad.excluir(puntaje, jugador, jugadoresQueUsaronBonificador, jugadoresQueRespondieronCorrectamente);
    }

    public void desactivar(){
        estadoExclusividad = new ExclusividadDesactivado();
        jugadoresQueUsaronBonificador.clear();
    }
}
