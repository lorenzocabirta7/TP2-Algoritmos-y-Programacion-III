package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.cambioVentanas;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage scene) {
        cambioVentanas cambioVentanas = new cambioVentanas();
        cambioVentanas.iniciar();

    }

    public static void main(String[] args) {
        launch(args);
    }
}