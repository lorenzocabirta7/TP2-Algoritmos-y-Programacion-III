package edu.fiuba.algo3.modelo.ModoDePregunta;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public interface TipoDePregunta {
    int actualizarPuntaje(int puntaje, Respuesta respuestaDelJugador, Respuesta respuestaDeLaPregunta);
}
