package main.preguntas;

import main.Jugador;
import main.Respuesta;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoPenalidad extends Pregunta {
    private String enunciado;

    private ArrayList<Respuesta> respuestas;

    public PreguntaVerdaderoFalsoPenalidad(String pregunta, ArrayList<Respuesta> respuestas) {
        super(pregunta, respuestas);
        enunciado = pregunta;
        this.respuestas = respuestas;

    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador) {
        Respuesta respuestaDelJugador = respuestas.get(0); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(1, respuestaDelJugador);
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
