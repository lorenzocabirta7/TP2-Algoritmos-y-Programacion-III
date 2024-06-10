package main;

import main.preguntas.Pregunta;

import java.util.ArrayList;

public class AlgoJuego {
    ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    Jugador jugadorActual;
    ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    Pregunta preguntaActual;
    int cantidadDePreguntas;
    int cantidadDeJugadores;

    private static AlgoJuego instance = new AlgoJuego();

    private AlgoJuego() {}

    public static AlgoJuego getInstance() {
        return instance;
    }

    public void agregarJugador(Jugador unJugador){
        jugadores.add(unJugador);
    }

    public void asignarPregunta(Pregunta unaPregunta){
        preguntaActual = unaPregunta;
    }
    

}
