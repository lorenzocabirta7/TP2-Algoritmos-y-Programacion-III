package edu.fiuba.algo3.Vista.VentanaRespuestas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SeccionVerdaderoFalso implements SeccionRespuesta {

    private Pregunta pregunta;
    private Jugador jugador;

    @Override
    public VBox mostrarRespuestas(Pregunta pregunta, ArrayList<Respuesta> respuestasPosibles, Jugador jugadorActual) {
        this.pregunta = pregunta;
        this.jugador = jugadorActual;

        VBox cajaDeRespuestas = new VBox();
        HBox contenido = new HBox();

        VBox respuestas = new VBox();
        ToggleGroup group = new ToggleGroup();

        for (Respuesta respuesta : respuestasPosibles) {
            HBox respuestaIndividual = new HBox();
            Label enunciado = new Label(respuesta.getRespuesta());
            ToggleButton opcion = new ToggleButton("Seleccionar");
            opcion.setToggleGroup(group);

            // Añadir evento para cambiar el texto del botón
            opcion.setOnAction(event -> {
                if (opcion.isSelected()) {
                    opcion.setText("Seleccionado");
                    jugador.agregarRespuesta(pregunta, respuesta);
                } else {
                    opcion.setText("Seleccionar");
                    jugador.eliminarRespuesta(pregunta, respuesta);
                }
            });

            respuestaIndividual.getChildren().addAll(enunciado, opcion);
            respuestas.getChildren().add(respuestaIndividual);
        }

        cajaDeRespuestas.getChildren().addAll(contenido, respuestas);

        return cajaDeRespuestas;
    }
}
