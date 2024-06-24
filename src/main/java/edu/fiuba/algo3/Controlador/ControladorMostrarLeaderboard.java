package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Modelo;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ControladorMostrarLeaderboard {
    Modelo modelo;
    Juego vista;


    public ControladorMostrarLeaderboard(Modelo modelo, Juego vista) {
        this.modelo = modelo;
        this.vista = vista;

    }

    public ArrayList<Label> MostrarLeaderboard() {
        ArrayList<String> arregloJugadores = modelo.ConseguirTodosLosJugadores();
        ArrayList<Integer> arregloPuntajeJugadores = modelo.ConseguirTodosLosPuntajes();
        ArrayList<Label> jugadores = new ArrayList<>();


        for (int i = 0; i < arregloJugadores.size(); i++) {
            String jugadorConPuntaje = arregloJugadores.get(i) + (" " + (arregloPuntajeJugadores.get(i)) );
            jugadores.add(new Label(jugadorConPuntaje));
        }
    return jugadores;
    }

}
