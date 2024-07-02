package edu.fiuba.algo3.Vista.VentanaRespuestas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaAVerificar;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SeccionOrdenParcial implements SeccionRespuesta {
    private Pregunta pregunta;
    private Jugador jugador;


    public VBox mostrarRespuestas(Pregunta pregunta, ArrayList<Respuesta> respuestasPosibles, Jugador jugador) {
        this.pregunta = pregunta;
        this.jugador = jugador;

        VBox cajaDeRespuestas = new VBox();
        int cantidadRespuestas = respuestasPosibles.size();

        for (Respuesta respuesta : respuestasPosibles) {
            HBox cajaRespuestaIndividual = new HBox();
            Label enunciadoRespuesta = new Label(respuesta.getRespuesta());

            ComboBox<Integer> ordenParcial = new ComboBox<>();
            for (int i = 1; i <= cantidadRespuestas; i++) {
                ordenParcial.getItems().add(i);
            }
            cajaRespuestaIndividual.getChildren().addAll(enunciadoRespuesta, ordenParcial);
            cajaDeRespuestas.getChildren().add(cajaRespuestaIndividual);

            ordenParcial.setOnAction(g -> {
                Integer ordenSeleccionado = ordenParcial.getValue();
                if (ordenSeleccionado != null) {
                    String ordenParcialString = ordenSeleccionado.toString();
                    RespuestaAVerificar respuestaAVerificar = new RespuestaAVerificar(respuesta.getRespuesta(), ordenParcialString);
                    jugador.agregarRespuesta(pregunta, respuestaAVerificar);
                }
            });
        }

        return cajaDeRespuestas;
    }

}
