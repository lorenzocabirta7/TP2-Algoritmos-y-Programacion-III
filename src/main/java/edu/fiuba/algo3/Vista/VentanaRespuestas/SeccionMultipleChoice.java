package edu.fiuba.algo3.Vista.VentanaRespuestas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SeccionMultipleChoice implements SeccionRespuesta{
    private Pregunta pregunta;

    public VBox mostrarRespuestas(Pregunta pregunta, ArrayList<Respuesta> respuestasPosibles, Jugador jugadorActual) {
        VBox cajaDeRespuestas = new VBox();
        for (Respuesta respuesta : respuestasPosibles) {
            HBox cajaRespuestaIndividual = new HBox();
            Label enunciadoRespuesta = new Label(respuesta.getRespuesta());
            ToggleButton opcion1 = new ToggleButton("Agregar Respuesta");
            opcion1.setOnAction(event -> {
                if (opcion1.isSelected()) {
                    opcion1.setText("Eliminar Repuesta");
                    Respuesta respuestaAAgregar;
                    jugadorActual.agregarRespuesta(pregunta,respuesta);
                } else {
                    opcion1.setText("Agregar Repuesta");
                    jugadorActual.eliminarRespuesta(pregunta,respuesta);
                }
            });
            cajaDeRespuestas.getChildren().addAll(enunciadoRespuesta, opcion1);
        }
        return cajaDeRespuestas;
    }



}
