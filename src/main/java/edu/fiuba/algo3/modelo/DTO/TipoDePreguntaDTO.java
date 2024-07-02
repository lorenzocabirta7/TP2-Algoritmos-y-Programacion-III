package edu.fiuba.algo3.modelo.DTO;

import edu.fiuba.algo3.modelo.ModoDePregunta.*;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;

public class TipoDePreguntaDTO {
    public TipoDePregunta TipoDePuntuacion(PreguntaDTO pregunta) {
        switch (pregunta.getTipo()) {
            case "Ordered choice":
                return new OrderedChoice(new PenalidadClasica());

            case "Multiple Choice Simple":
                return new MultipleChoice(new PenalidadClasica());

            case "Verdadero Falso":
                return new VerdaderoOFalso(new PenalidadClasica());

            case "Multiple Choice Puntaje Parcial":
                return new MultipleChoice(new PenalidadClasica());

            case "Verdadero Falso Penalidad":
                return new VerdaderoOFalso(new PenalidadConPenalidad());

            case "Multiple Choice Penalidad":
                return new MultipleChoice(new PenalidadConPenalidad());

            case "Group Choice":
                return new GroupChoice(new PenalidadClasica());
        }
        return null;
    }
}
