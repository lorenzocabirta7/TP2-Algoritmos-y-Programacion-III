package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VentanaPregunta;
import edu.fiuba.algo3.modelo.Modelo;
import edu.fiuba.algo3.modelo.exceptions.YaJugaronTodosLosJugadores;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.awt.event.MouseAdapter;

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

        ActualizarVista();

        modelo.addObserver((o, arg) -> {
            ActualizarVista();
        });

        this.BotonproximaPregunta.setOnAction(this::ApretarBotonSiguientePregunta);
        this.BotonProximoJugador.setOnAction(this::ApretarBotonProximoJugador);
    }



    private void ApretarBotonSiguientePregunta(ActionEvent event)  {
        modelo.SiguientePregunta();

        modelo.notifyObservers();
    }

    private void ApretarBotonProximoJugador(ActionEvent event) {
        try {
            modelo.confirmarRespuestas();
            modelo.SiguienteJugador();
            //modelo.notifyObservers(vista);
        } catch (YaJugaronTodosLosJugadores e) {
            BotonproximaPregunta.fire();
        }
    }


    private void ActualizarVista() {
        vista.updatePlayerLabel(modelo.conseguirJugador().obtenerNombre());
        vista.resetAnswerButtons();
        vista.updatePreguntaLabel(modelo.ConseguirPregunta());
        vista.siguienteJugador(modelo.conseguirJugador());
    }

}
