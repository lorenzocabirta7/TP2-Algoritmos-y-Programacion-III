package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarVerdaderoFalsoPenalidad implements FormaDePuntuar {

    @Override
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador) {
        Respuesta respuestaDelJugador = respuestas.get(0); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(1, respuestaDelJugador);
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
