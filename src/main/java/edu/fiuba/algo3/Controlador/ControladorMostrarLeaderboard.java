package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.Ventana;
import edu.fiuba.algo3.Vista.VentanaLeaderboard;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Modelo;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Juego.ANCHO_PANTALLA;
import static edu.fiuba.algo3.modelo.Juego.LARGO_PANTALLA;

public class ControladorMostrarLeaderboard extends MouseAdapter {
    Modelo modelo;
    private VentanaLeaderboard vista;

    public ControladorMostrarLeaderboard(Modelo modelo, VentanaLeaderboard vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.modelo.addObserver(this.vista);
    }


    public void ApretarBotonSiguientePregunta()  {
        modelo.SiguientePregunta();
    }



}
