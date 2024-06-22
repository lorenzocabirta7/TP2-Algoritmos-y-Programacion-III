package edu.fiuba.algo3.modelo.DTO;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;

public class FormaDePuntuarDTO {
    public FormaDePuntuar TipoDePuntuacion(PreguntaDTO pregunta, ArrayList<Respuesta> respuestasPregunta) {
        switch (pregunta.getTipo()) {
            case "Ordered Choice":
                return new PuntuarDeFormaOrdenada(respuestasPregunta);

            case "Multiple Choice Simple":
                return new PuntuarMultipleChoiceClasico(respuestasPregunta);

            case "Verdadero Falso":
                return new PuntuarVerdaderoFalsoClasico();

            case "Multiple Choice Puntaje Parcial":
                return new PuntuarMultipleChoiceParcial();

            case "Verdadero Falso Penalidad":
                return new PuntuarVerdaderoFalsoPenalidad();

            case "Multiple Choice Penalidad":
                return new PuntuarMultipleChoicePenalidad();
            default:
                return new PuntuarDeFormaOrdenada(respuestasPregunta);
        }
    }
}
