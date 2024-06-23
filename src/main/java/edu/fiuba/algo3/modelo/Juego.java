package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.Controlador.ControladorCrearJugadores;
import edu.fiuba.algo3.Controlador.ControladorMostrarLeaderboard;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Juego {
    Modelo modelo;

    public void iniciar(){
        modelo = new Modelo();
        crearVetanaTextoInicial();
    }


    private void crearVetanaTextoInicial() {
        Label CartelBienvenida = new Label("Bienvenidos Al Juego del grupo 4 de Algoritmos y Programacion 3!");

        Label nameLabel = new Label("Ingresar Nombre Del Jugador:");
        TextField InputNombre = new TextField();
        InputNombre.setMaxWidth(250);

        Button ConfirmarJugadorBoton = new Button("Confirmar Jugador");
        Button EmpezarPartidaBoton = new Button("Empezar Partida");

        ControladorCrearJugadores controladorCrearJugador = new ControladorCrearJugadores(modelo, this);


        //logica de confirmar jugador
        ConfirmarJugadorBoton.setOnAction(e -> {
            String NombreDeJugador = InputNombre.getText().trim();
            controladorCrearJugador.seleccionarBoton(NombreDeJugador);
        });
        ConfirmarJugadorBoton.setStyle("-fx-background-color: #65d24a; -fx-background-radius: 5px; -fx-padding: 8px;");
        EmpezarPartidaBoton.setStyle("-fx-background-color: #f16363; -fx-background-radius: 5px; -fx-padding: 8px;");



        VBox root = new VBox(20);
        root.setPadding(new Insets(60, 60, 60, 60));
        root.getChildren().addAll(CartelBienvenida, nameLabel, InputNombre, ConfirmarJugadorBoton, EmpezarPartidaBoton);


        Scene scene = new Scene(root, 600, 400);

        Stage Stage = new Stage();
        // Set the scene on the primary stage
        Stage.setScene(scene);
        Stage.setTitle("Preguntados");
        Stage.show();

        EmpezarPartidaBoton.setOnAction(e -> {
            ControladorMostrarLeaderboard controladorLeaderboard = new ControladorMostrarLeaderboard(modelo, this);
            VBox vBoxJugadores = new VBox();
            ArrayList<Label> nombresJugadores = controladorLeaderboard.MostrarLeaderboard();

            vBoxJugadores.getChildren().addAll(nombresJugadores);
            Scene escenaJugadores = new Scene(vBoxJugadores, 600, 400);
            Stage.setScene(escenaJugadores);
        });
    }


    //public void iniciarJuego(){
        //Alguien tiene que llamar a asignarNumeroDeJugadores(int)
        //while (jugadores.size() < cantidadDeJugadores){
        //    //esperar a que se agreguen jugadores
        //}
        //for (pregunta : preguntas){
        //    asignarPregunta(pregunta);
        //    for (jugador : jugadores){
        //        jugadorActual = jugador;
        //        //esperar a que el jugador responda
        //        jugador.confirmarRespuesta(preguntaActual);
        //    }
        //     pregunta.puntarRespuestas(jugadores);
        //
        //}
        //algoJuego.mostrarGanador();
    }
