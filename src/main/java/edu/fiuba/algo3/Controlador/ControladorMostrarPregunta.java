package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VentanaPregunta;
import edu.fiuba.algo3.modelo.Modelo;
import edu.fiuba.algo3.modelo.exceptions.YaJugaronTodosLosJugadores;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class ControladorMostrarPregunta extends MouseAdapter {
    private Modelo modelo;
    private VentanaPregunta vista;
    private Button BotonProximoJugador;
    private Button BotonproximaPregunta;


    public ControladorMostrarPregunta(Modelo modelo, VentanaPregunta vista, Button BotonProximoJugador, Button BotonproximaPregunta) {
        this.modelo = modelo;
        this.vista = vista;
        this.BotonProximoJugador = BotonProximoJugador;
        this.BotonproximaPregunta = BotonproximaPregunta;
        modelo.addObserver(vista);
    }

    public void initialize() {
        updateLabel();

        BotonproximaPregunta.setOnAction(this::ApretarBotonSiguientePregunta);
        BotonProximoJugador.setOnAction(this::ApretarBotonProximoJugador);
    }

    private void ApretarBotonSiguientePregunta(ActionEvent event)  {
        modelo.SiguientePregunta();
    }

    private void ApretarBotonProximoJugador(ActionEvent event) {
        try {
            modelo.SiguienteJugador();
        } catch (YaJugaronTodosLosJugadores e) {
            BotonproximaPregunta.fire();
        }
    }

    private void updateLabel() {
        vista.update(modelo, null);
    }
}
