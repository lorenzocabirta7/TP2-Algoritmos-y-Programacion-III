package edu.fiuba.algo3.modelo;

import java.util.ArrayList;


public class Modelo {
    private ArrayList<Jugador> jugadores;


    public Modelo() {
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(String nombreJugador) {
        jugadores.add(new Jugador(nombreJugador));
    }

    public String NombreJugador() {
        Jugador jugador = jugadores.get(0);
        return jugador.obtenerNombre();
    }

    public ArrayList<String> ConseguirJugadores(){
        ArrayList<String> jugadoresADevolver = new ArrayList<>();
        for (Jugador jugador : this.jugadores) {
            jugadoresADevolver.add(jugador.obtenerNombre());
        }
        return jugadoresADevolver;
    }

}
