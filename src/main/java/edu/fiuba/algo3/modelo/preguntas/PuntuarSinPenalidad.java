package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public abstract class PuntuarSinPenalidad implements FormaDePuntuar  {
    protected ArrayList<Jugador> jugadoresQueUsaronAnulador = new ArrayList<Jugador>();
    protected ArrayList<Jugador> jugadoresQueUsaronExclusividad = new ArrayList<Jugador>();
    protected Anulador anulador = new AnuladorClasico();
    public void agregarJugadorQueUsoAnulador(Jugador jugador){
        this.jugadoresQueUsaronAnulador.add(jugador);
    }

}