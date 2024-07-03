package edu.fiuba.algo3.modelo.DTO;

import edu.fiuba.algo3.modelo.ModoDePregunta.*;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadParcialMC;

public class TipoDePreguntaDTO {
    public TipoDePregunta TipoDePuntuacion(PreguntaDTO pregunta) {
        switch (pregunta.getTipo()) {
            case "Ordered Choice":
                return new OrderedChoice(new PenalidadClasica());

            case "Multiple Choice Simple":
                return new MultipleChoice(new PenalidadClasica());

            case "Verdadero Falso Simple":
                return new VerdaderoOFalso(new PenalidadClasica());

            case "Multiple Choice Puntaje Parcial":
                return new MultipleChoice(new PenalidadParcialMC());

            case "Verdadero Falso Penalidad":
                return new VerdaderoOFalso(new PenalidadConPenalidad());

            case "Multiple Choice Penalidad":
                return new MultipleChoice(new PenalidadConPenalidad());

            case "Group Choice":
                System.out.println("Se encontro una pregunta group choice");
                return new GroupChoice(new PenalidadClasica());
        }
        System.out.println("Aca es el ERORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        System.out.println(pregunta.getTipo());
        return null;
    }
}
