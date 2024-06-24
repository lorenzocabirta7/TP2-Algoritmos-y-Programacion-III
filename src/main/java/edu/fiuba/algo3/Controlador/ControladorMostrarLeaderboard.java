package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Modelo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Juego.ANCHO_PANTALLA;
import static edu.fiuba.algo3.modelo.Juego.LARGO_PANTALLA;

public class ControladorMostrarLeaderboard {
    Modelo modelo;
    Juego vista;


    public ControladorMostrarLeaderboard(Modelo modelo, Juego vista) {
        this.modelo = modelo;
        this.vista = vista;

    }

    public void MostrarLeaderboard(Stage stage, Button botonEmpezarPartida) {

        VBox vBoxJugadores = new VBox(botonEmpezarPartida);
        ArrayList<Label> nombresJugadores = this.ConseguirJugadores();

        vBoxJugadores.getChildren().addAll(nombresJugadores);
        Scene escenaJugadores = new Scene(vBoxJugadores, ANCHO_PANTALLA, LARGO_PANTALLA);
        stage.setScene(escenaJugadores);
    }

   private ArrayList<Label> ConseguirJugadores(){
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
