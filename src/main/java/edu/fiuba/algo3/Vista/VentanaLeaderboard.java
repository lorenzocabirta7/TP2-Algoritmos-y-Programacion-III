package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorMostrarLeaderboard;
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


    private Scene escenaJugadores;
    private Button siguienteVentana;
    private ControladorMostrarLeaderboard controlador;
    private Modelo modelo;
    private ArrayList<Label> nombresJugadores;
    private VBox jugadoresBox;

    public VentanaLeaderboard(Modelo modelo) {
        this.modelo = modelo;

        jugadoresBox = new VBox();
        nombresJugadores = this.ConseguirJugadores(modelo);

        jugadoresBox.getChildren().addAll(nombresJugadores);

        siguienteVentana = new Button("Siguiente");


        controlador = new ControladorMostrarLeaderboard(modelo, this);


        jugadoresBox.getChildren().add(siguienteVentana);


        escenaJugadores = new Scene(jugadoresBox, ANCHO_PANTALLA, LARGO_PANTALLA);

    }


    public void inicializarVentana(Stage stage) {
        stage.setScene(escenaJugadores);
    }

    private ArrayList<Label> ConseguirJugadores(Modelo modelo) {
        ArrayList<String> arregloJugadores = modelo.ConseguirTodosLosJugadores();
        ArrayList<Integer> arregloPuntajeJugadores = modelo.ConseguirTodosLosPuntajes();
        ArrayList<Label> jugadores = new ArrayList<>();


        for (int i = 0; i < arregloJugadores.size(); i++) {
            String jugadorConPuntaje = arregloJugadores.get(i) + ("  Puntaje: " + (arregloPuntajeJugadores.get(i)));
            jugadores.add(new Label(jugadorConPuntaje));
        }
        return jugadores;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("Siguiente Pregunta")){
            this.modelo = (Modelo) o;
            updateLabelJugadores();
        }
    }

    public void updateLabelJugadores() {

        ArrayList<String> arregloJugadores = this.modelo.ConseguirTodosLosJugadores();
        ArrayList<Integer> arregloPuntajeJugadores = this.modelo.ConseguirTodosLosPuntajes();
        Integer indice = 0;
        for (Label jugador : nombresJugadores) {
            String jugadorConPuntaje = arregloJugadores.get(indice) + ("  Puntaje: " + (arregloPuntajeJugadores.get(indice)));
            jugador.setText(jugadorConPuntaje);
            indice++;
        }
    }
    @Override
    public void AlCambiarVentana(Runnable runnable) {
        siguienteVentana.setOnAction(e -> {
            controlador.ApretarBotonSiguientePregunta();
            runnable.run();
        });
    }
}
