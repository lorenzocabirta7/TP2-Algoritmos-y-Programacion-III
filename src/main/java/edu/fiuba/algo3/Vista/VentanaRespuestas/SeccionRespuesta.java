package edu.fiuba.algo3.Vista.VentanaRespuestas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modelo;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public interface SeccionRespuesta {
    public VBox mostrarRespuestas(Pregunta pregunta, ArrayList<Respuesta> respuestasPosibles, Jugador jugadorActual);
}
