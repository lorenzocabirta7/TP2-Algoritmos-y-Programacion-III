package edu.fiuba.algo3;

<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
        App.main(args);
=======
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
>>>>>>> 34d219b9453522c049dc262b1b5823048cd15648
    }
}
