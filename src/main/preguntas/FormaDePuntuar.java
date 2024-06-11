package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public interface FormaDePuntuar {
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador);
}
