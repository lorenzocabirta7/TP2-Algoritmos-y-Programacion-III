package edu.fiuba.algo3.modelo;



import edu.fiuba.algo3.Controlador.ControladorCrearJugadores;
import edu.fiuba.algo3.Controlador.ControladorMostrarLeaderboard;
import edu.fiuba.algo3.Controlador.ControladorPreguntaParaUnJugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaAVerificar;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Juego {
    public static final int ANCHO_PANTALLA = 1100;
    public static final int LARGO_PANTALLA = 750;

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
        Button MostrarLeaderBoardBoton = new Button("Avanzar");

        ControladorCrearJugadores controladorCrearJugador = new ControladorCrearJugadores(modelo, this);


        //logica de confirmar jugador
        ConfirmarJugadorBoton.setOnAction(e -> {
            String NombreDeJugador = InputNombre.getText().trim();
            controladorCrearJugador.seleccionarBoton(NombreDeJugador);
        });
        ConfirmarJugadorBoton.setStyle("-fx-background-color: #65d24a; -fx-background-radius: 5px; -fx-padding: 8px;");
        MostrarLeaderBoardBoton.setStyle("-fx-background-color: #f16363; -fx-background-radius: 5px; -fx-padding: 8px;");



        VBox root = new VBox(20);
        root.setPadding(new Insets(60, 60, 60, 60));
        root.getChildren().addAll(CartelBienvenida, nameLabel, InputNombre, ConfirmarJugadorBoton, MostrarLeaderBoardBoton);


        Scene scene = new Scene(root, ANCHO_PANTALLA, LARGO_PANTALLA);

        Stage Stage = new Stage();

        Stage.setScene(scene);
        Stage.setTitle("Preguntados");
        Stage.show();

        Button empezarPartida = new Button("Avanzar");

        empezarPartida.setOnAction(e -> {

            Label jugadorLabel = new Label("Jugador Actual: ");
            jugadorLabel.setStyle("-fx-background-color: black;\n" +
                    "        -fx-text-fill: white; \n" +
                    "        -fx-padding: 5px;");

            Pregunta preguntaAMostrar = modelo.ConseguirPregunta();
            Jugador jugadorActual = modelo.conseguirJugador();
            Label jugadorJugando = new Label(jugadorActual.obtenerNombre());
            jugadorJugando.setStyle("-fx-background-color: black;\n" +
                    "        -fx-text-fill: white; \n" +
                    "        -fx-padding: 5px;");



            Button botonConfirmar = new Button("Confirmar");


            botonConfirmar.setOnAction(f -> {
                jugadorActual.confirmarRespuesta(preguntaAMostrar);

                ControladorMostrarLeaderboard controladorLeaderboard = new ControladorMostrarLeaderboard(modelo, this);
                VBox vBoxJugadores = new VBox(empezarPartida);
                ArrayList<Label> nombresJugadores = controladorLeaderboard.MostrarLeaderboard();

                vBoxJugadores.getChildren().addAll(nombresJugadores);
                Scene escenaJugadores = new Scene(vBoxJugadores, ANCHO_PANTALLA, LARGO_PANTALLA);
                Stage.setScene(escenaJugadores);
            });


            Label labelEnunciado = new Label(preguntaAMostrar.getEnunciado());
            Label labelTipoDePregunta = new Label("[Tipo de Pregunta]");


            HBox cajaJugador = new HBox(jugadorLabel, jugadorJugando);

            VBox cajaDeRespuestas = new VBox(20, cajaJugador, botonConfirmar);
            ArrayList<Respuesta> respuestasPosibles = preguntaAMostrar.respuestasPosibles();
            ToggleGroup grupoRespuestas = new ToggleGroup();


            for (Respuesta respuesta : respuestasPosibles) {
                RadioButton opcion = new RadioButton(respuesta.getRespuesta());
                //ControladorPreguntaParaUnJugador controladorRespuesta = new ControladorPreguntaParaUnJugador(modelo, this);

                opcion.setOnAction(g -> {jugadorActual.responder(preguntaAMostrar, new RespuestaAVerificar(respuesta.getRespuesta(),
                        jugadorActual.obtenerOrdenParcial()));
                        opcion.setDisable(true);
                });
                opcion.setToggleGroup(grupoRespuestas);
                cajaDeRespuestas.getChildren().add(opcion);

            }





            Button botonMultiplicadorPorDos = new Button("Multiplicador X2");
            Button botonMultiplicadorPorTres = new Button("Multiplicador X3");
            Button botonExclusividad = new Button("Exclusividad");
            Button botonAnulador = new Button("Anulador");

            botonMultiplicadorPorDos.setDisable(true); //Para tener despues, cuando haya que implementarlo

            VBox cajaDeBonificadores = new VBox(10, botonMultiplicadorPorDos, botonMultiplicadorPorTres, botonExclusividad, botonAnulador);
            cajaDeBonificadores.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(10), Insets.EMPTY)));



            BorderPane mainPane = new BorderPane();



            cajaDeRespuestas.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));

            VBox cajaPregunta = new VBox(10, labelEnunciado, labelTipoDePregunta, cajaDeRespuestas);

            mainPane.setCenter(cajaPregunta);
            mainPane.setRight(cajaDeBonificadores);
            //mainPane.setBottom(botonConfirmar);

            Scene escenaPregunta = new Scene(mainPane, ANCHO_PANTALLA, LARGO_PANTALLA);
            Stage.setScene(escenaPregunta);
        });


        MostrarLeaderBoardBoton.setOnAction(e -> {
            ControladorMostrarLeaderboard controladorLeaderboard = new ControladorMostrarLeaderboard(modelo, this);
            VBox vBoxJugadores = new VBox(empezarPartida);
            ArrayList<Label> nombresJugadores = controladorLeaderboard.MostrarLeaderboard();

            vBoxJugadores.getChildren().addAll(nombresJugadores);
            Scene escenaJugadores = new Scene(vBoxJugadores, ANCHO_PANTALLA, LARGO_PANTALLA);
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
