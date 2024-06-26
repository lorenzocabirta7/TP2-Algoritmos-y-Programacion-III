package edu.fiuba.algo3.modelo.DTO;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;

public class TipoDePenalidadDTO {
    public TipoDePenalidad DevolverPenalidad(PreguntaDTO pregunta){
        switch (pregunta.getTipo()) {
            case "Ordered Choice":
                return new PenalidadClasica();

            case "Multiple Choice Simple":
                return new PenalidadClasica();

            case "Verdadero Falso":
                return new PenalidadClasica();

            case "Multiple Choice Puntaje Parcial":
                return new PenalidadClasica();

            case "Verdadero Falso Penalidad":
                return new PenalidadConPenalidad();

            case "Multiple Choice Penalidad":
                return new PenalidadConPenalidad();
            default:
                return new PenalidadClasica();
        }
    }
}
