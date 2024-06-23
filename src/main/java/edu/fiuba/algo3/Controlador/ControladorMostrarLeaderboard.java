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
        ArrayList<String> arregloJugadores = modelo.ConseguirJugadores();
        ArrayList<Label> nombresJugadores = new ArrayList<>();

        for (String jugador : arregloJugadores) {
            nombresJugadores.add(new Label(jugador));

        }
    return nombresJugadores;
    }

}
