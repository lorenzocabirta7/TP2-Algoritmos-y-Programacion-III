package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class Anulador {
    private EstadoAnulador estadoAnulador = new AnuladorDesactivado();
    private ArrayList<Jugador> jugadoresQueUsaronAnulador = new ArrayList<>();

    public void activar(Jugador jugador){
        jugadoresQueUsaronAnulador.add(jugador);
        estadoAnulador = new AnuladorActivado();
    }

    public int anular(int puntaje, Jugador jugador){
        return estadoAnulador.anular(puntaje, jugador, jugadoresQueUsaronAnulador);
    }

    public void desactivar(){
        estadoAnulador = new AnuladorDesactivado();
        jugadoresQueUsaronAnulador.clear();
    }

}
