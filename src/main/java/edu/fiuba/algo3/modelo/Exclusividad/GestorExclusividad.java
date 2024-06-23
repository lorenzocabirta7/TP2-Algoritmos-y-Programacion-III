package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.*;

public class GestorExclusividad {
    private int usosDisponiblesAnulador = 2;
    public void gestarActivacion(Pregunta pregunta, Jugador jugador) throws ExclusividadSeUsaMasdeDosVeces {
        if (this.usosDisponiblesAnulador > 0) {
            //pregunta.jugadorUsoExlsu(jugador);
            this.usosDisponiblesAnulador--;
        }
        else {
            throw new ExclusividadSeUsaMasdeDosVeces("No hay usos disponibles");
        }
    }
}
