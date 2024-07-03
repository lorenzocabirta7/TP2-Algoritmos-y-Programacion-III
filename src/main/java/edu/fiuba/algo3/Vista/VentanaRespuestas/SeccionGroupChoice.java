package edu.fiuba.algo3.Vista.VentanaRespuestas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modelo;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaAVerificar;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SeccionGroupChoice implements SeccionRespuesta{
    private Pregunta pregunta;
    private Jugador jugador;
    private HashSet<String> gruposPosibles = new HashSet<>();
    //{"Letras", "Numeros"}



    @Override
    public VBox mostrarRespuestas(Pregunta pregunta, ArrayList<Respuesta> respuestasPosibles, Jugador jugadorActual) {
        VBox cajaRespuestas = new VBox();
        this.pregunta = pregunta;
        jugador = jugadorActual;
        for (Respuesta respuesta : respuestasPosibles) {
            gruposPosibles.add(respuesta.getOrdenParcial());
        }
        for (Respuesta respuesta : respuestasPosibles) {
            HBox respuestaIndividual = new HBox();

            Label enunciadoRespuesta = new Label(respuesta.getRespuesta());

            ComboBox<String> grupos = new ComboBox<>();
            for (String grupo : gruposPosibles) {
                grupos.getItems().add(grupo);
            }

            respuestaIndividual.getChildren().addAll(enunciadoRespuesta, grupos);
            cajaRespuestas.getChildren().add(respuestaIndividual);

            grupos.setOnAction(g -> {
                String ordenSeleccionado = grupos.getValue();
                if (ordenSeleccionado != null) {
                    RespuestaAVerificar respuestaAVerificar = new RespuestaAVerificar(respuesta.getRespuesta(), ordenSeleccionado);
                    jugador.agregarRespuesta(pregunta,respuestaAVerificar);
                }
            });
        }



        return cajaRespuestas;
    }
}
