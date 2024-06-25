package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VentanaLeaderboard;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Modelo;
import javafx.event.ActionEvent;
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
    private VentanaLeaderboard vista;
    private Button BotonproximaPregunta;

    public ControladorMostrarLeaderboard(Modelo modelo, VentanaLeaderboard vista, Button BotonproximaPregunta) {
        this.modelo = modelo;
        this.vista = vista;
        this.BotonproximaPregunta = BotonproximaPregunta;
        modelo.addObserver(vista);
    }
    public void initialize() {
        updateLabel();

        BotonproximaPregunta.setOnAction(this::ApretarBotonSiguientePregunta);
    }

    private void ApretarBotonSiguientePregunta(ActionEvent event)  {
        modelo.SiguientePregunta();
        updateLabel();
    }

    private void updateLabel() {
        vista.update(modelo, null);
    }




}
