package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

import java.util.ArrayList;

public interface FormaDePuntuar {
    public int puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador);
    public void agregarJugadorQueUsoAnulador(Jugador jugador);

    public void agregarJugadorQueUsoExclusividad(Jugador jugador,Pregunta pregunta) throws ExclusividadInvalida;

}