package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VentanaPregunta;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.exceptions.YaJugaronTodosLosJugadores;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.awt.event.MouseAdapter;

public class ControladorMostrarPregunta extends MouseAdapter {
    private Juego juego;
    private VentanaPregunta vista;
    private Button BotonProximoJugador;


    public ControladorMostrarPregunta(Juego juego, VentanaPregunta vista, Button BotonProximoJugador) {
        this.juego = juego;
        this.vista = vista;
        this.BotonProximoJugador = BotonProximoJugador;


        juego.addObserver(this.vista);

        this.BotonProximoJugador.setOnAction(this::ApretarBotonProximoJugador);
    }


    private void ApretarBotonProximoJugador(ActionEvent event) {
        try {
            juego.SiguienteJugador();
        } catch (YaJugaronTodosLosJugadores e) {
            juego.puntuarRespuestas();
            juego.SiguientePregunta();
        }
    }

}
