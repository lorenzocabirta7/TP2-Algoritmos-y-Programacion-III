package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.*;

import java.util.ArrayList;

public interface FormaDePuntuar {
    public int puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador);
    public void agregarJugadorQueUsoAnulador(Jugador jugador);

    void agregarJugadorQueUsoExclusividad(Jugador jugador);
}