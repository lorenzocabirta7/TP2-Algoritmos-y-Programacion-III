package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;

public class GestorExclusividad {
    private int usosDisponiblesExclusividad = 2;
        public void gestarActivacion(Pregunta pregunta, Jugador jugador) throws ExclusividadSeUsaMasdeDosVeces {
        if (this.usosDisponiblesExclusividad > 0) {
            pregunta.activarExclusividad(jugador);

            this.usosDisponiblesExclusividad--;
        }
        else {
            throw new ExclusividadSeUsaMasdeDosVeces("No hay usos disponibles");
        }
    }
}
