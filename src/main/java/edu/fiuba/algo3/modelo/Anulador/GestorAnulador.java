package edu.fiuba.algo3.modelo.Anulador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;


public class GestorAnulador{
    private int usosDisponiblesAnulador = 1;
    public void gestarActivacion(Pregunta pregunta, Jugador jugador) throws AnuladorSeUsaMasDeUnaVez{
        if (this.usosDisponiblesAnulador > 0) {
            pregunta.jugadorUsoAnulador(jugador);
            this.usosDisponiblesAnulador--;
        }
        else {
            throw new AnuladorSeUsaMasDeUnaVez("No hay usos disponibles");
        }
    }
}
