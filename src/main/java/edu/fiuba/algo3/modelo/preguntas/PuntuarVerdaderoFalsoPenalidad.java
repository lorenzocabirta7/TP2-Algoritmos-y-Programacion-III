package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarVerdaderoFalsoPenalidad implements FormaDePuntuar {
    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        Respuesta respuestaDelJugador = respuestas.get(0); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(1, respuestaDelJugador);
        return puntosObtenidos;
    }
}
