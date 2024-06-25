package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage scene) {
        Juego juego = new Juego();
        juego.iniciar();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
