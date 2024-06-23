package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Modelo;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.swing.*;

public class VentanaTextoInicio extends JFrame {

    public VentanaTextoInicio(Modelo modelo){
        setTitle("Ejemplo de MVC | Texto");
        javafx.scene.control.Label labelInicioDeJuego = new javafx.scene.control.Label("Bienvenidos Al Juego de los alumnos de Algoritmos Y Programacion 3");
        javafx.scene.control.Button botonConfirmar = new Button("Confirmar");
        BorderPane mainPane = new BorderPane();

        mainPane.setCenter(labelInicioDeJuego);
        mainPane.setBottom(botonConfirmar);
    }
}
