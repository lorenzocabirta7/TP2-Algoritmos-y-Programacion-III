package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage scene) {
        // Crear los elementos de la interfaz

        Label labelEnunciado = new Label("[Enunciado]");
        Label labelTipoDePregunta = new Label("[Tipo de Pregunta]");

        ToggleGroup answersGroup = new ToggleGroup();
        RadioButton option1 = new RadioButton("Opción 1");
        RadioButton option2 = new RadioButton("Opción 2");
        RadioButton option3 = new RadioButton("Opción 3");
        RadioButton option4 = new RadioButton("Opción 4");
        RadioButton option5 = new RadioButton("Opción 5");

        option1.setToggleGroup(answersGroup);
        option2.setToggleGroup(answersGroup);
        option3.setToggleGroup(answersGroup);
        option4.setToggleGroup(answersGroup);
        option5.setToggleGroup(answersGroup);

        Button botonConfirmar = new Button("Confirmar");

        VBox cajaDeRespuestas = new VBox(20, option1, option2, option3, option4, option5);

        cajaDeRespuestas.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), Insets.EMPTY)));

        Button botonMultiplicadorPorDos = new Button("Multiplicador X2");
        Button botonMultiplicadorPorTres = new Button("Multiplicador X3");
        Button botonExclusividad = new Button("Exclusividad");
        Button botonAnulador = new Button("Anulador");

        botonMultiplicadorPorDos.setDisable(true); //Para tener despues, cuando haya que implementarlo

        VBox cajaDeBonificadores = new VBox(10, botonMultiplicadorPorDos, botonMultiplicadorPorTres, botonExclusividad, botonAnulador);
        cajaDeBonificadores.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(10), Insets.EMPTY)));

        BorderPane mainPane = new BorderPane();

        VBox cajaPregunta = new VBox(10, labelEnunciado, labelTipoDePregunta, cajaDeRespuestas);

        mainPane.setCenter(cajaPregunta);
        mainPane.setRight(cajaDeBonificadores);
        mainPane.setBottom(botonConfirmar);

        Scene layoutPregunta = new Scene(mainPane, 640, 480);
        scene.setScene(layoutPregunta);
        scene.setTitle("Algo Preguntados");
        scene.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
