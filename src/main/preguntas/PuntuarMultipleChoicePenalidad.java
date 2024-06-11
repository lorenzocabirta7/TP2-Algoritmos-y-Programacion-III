package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarMultipleChoicePenalidad implements FormaDePuntuar{

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int puntosObtenidos = 0;
        for (Respuesta respuesta : respuestasDelJugador) {
            puntosObtenidos += respuesta.actualizarPuntaje(1, respuesta);
        }
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
