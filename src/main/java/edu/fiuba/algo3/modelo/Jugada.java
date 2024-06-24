package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

public class Jugada {
    Jugador jugadorActual;
    Pregunta preguntaActual;

    public Jugada(Jugador jugadorActual, Pregunta preguntaActual) {
        this.jugadorActual = jugadorActual;
        this.preguntaActual = preguntaActual;
    }
}
