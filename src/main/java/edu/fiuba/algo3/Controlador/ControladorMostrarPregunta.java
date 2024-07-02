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


    public ControladorMostrarPregunta(Modelo modelo, VentanaPregunta vista, Button BotonProximoJugador) {
        this.modelo = modelo;
        this.vista = vista;
        this.BotonProximoJugador = BotonProximoJugador;


        modelo.addObserver(this.vista);

        this.BotonProximoJugador.setOnAction(this::ApretarBotonProximoJugador);
    }


    public void ApretarBotonSiguientePregunta()  {
        modelo.SiguientePregunta();
    }

    private void ApretarBotonProximoJugador(ActionEvent event) {
        try {
            modelo.confirmarRespuestas();
            modelo.SiguienteJugador();
        } catch (YaJugaronTodosLosJugadores e) {
            modelo.puntuarRespuestas();
            modelo.SiguientePregunta();
        }
    }


}
