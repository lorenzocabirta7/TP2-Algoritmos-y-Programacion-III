package edu.fiuba.algo3.Vista;


import edu.fiuba.algo3.Controlador.ControladorMostrarLeaderboard;
import edu.fiuba.algo3.Controlador.ControladorMostrarPregunta;
import edu.fiuba.algo3.modelo.Modelo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static edu.fiuba.algo3.modelo.Juego.ANCHO_PANTALLA;
import static edu.fiuba.algo3.modelo.Juego.LARGO_PANTALLA;

public class VentanaLeaderboard implements Ventana, Observer {

    private final Scene escenaJugadores;
    private final Button siguienteVentana;
    private VBox jugadoresBox;

    public VentanaLeaderboard(Modelo modelo) {
        jugadoresBox = new VBox();
        ArrayList<Label> nombresJugadores = this.ConseguirJugadores(modelo);

        jugadoresBox.getChildren().addAll(nombresJugadores);

        siguienteVentana = new Button("Siguiente");
        ControladorMostrarLeaderboard controlador = new ControladorMostrarLeaderboard(modelo, this, siguienteVentana);
        controlador.initialize();


        jugadoresBox.getChildren().add(siguienteVentana);



        escenaJugadores = new Scene(jugadoresBox, ANCHO_PANTALLA, LARGO_PANTALLA);

    }

    public void inicializarVentana(Stage stage){
        stage.setScene(escenaJugadores);
    }

    private ArrayList<Label> ConseguirJugadores(Modelo modelo){
        ArrayList<String> arregloJugadores = modelo.ConseguirTodosLosJugadores();
        ArrayList<Integer> arregloPuntajeJugadores = modelo.ConseguirTodosLosPuntajes();
        ArrayList<Label> jugadores = new ArrayList<>();


        for (int i = 0; i < arregloJugadores.size(); i++) {
            String jugadorConPuntaje = arregloJugadores.get(i) + (" " + (arregloPuntajeJugadores.get(i)) );
            jugadores.add(new Label(jugadorConPuntaje));
        }
        return jugadores;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Modelo) {
            Modelo modelo = (Modelo) o;
            jugadoresBox = new VBox();
            ArrayList<Label> nombresJugadores = this.ConseguirJugadores(modelo);

            jugadoresBox.getChildren().addAll(nombresJugadores);
        }
    }

    @Override
    public void AlCambiarVentana(Runnable runnable) {
        siguienteVentana.setOnAction(e -> runnable.run());
    }
}
