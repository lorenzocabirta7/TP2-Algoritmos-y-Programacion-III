package edu.fiuba.algo3.modelo;



import edu.fiuba.algo3.modelo.preguntas.Pregunta;

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

    public void agregarJugador(String unJugador){
        Jugador jugador = new Jugador(unJugador);
        jugadores.add(jugador);
    }

    public void asignarPregunta(Pregunta unaPregunta){
        preguntaActual = unaPregunta;
    }

    public void asignarNumeroDeJugadores(int cantidadDeJugadores){
        this.cantidadDeJugadores = cantidadDeJugadores;
    }

    public void iniciarJuego(){
        //Alguien tiene que llamar a asignarNumeroDeJugadores(int)
        //while (jugadores.size() < cantidadDeJugadores){
        //    //esperar a que se agreguen jugadores
        //}
        //for (pregunta : preguntas){
        //    asignarPregunta(pregunta);
        //    for (jugador : jugadores){
        //        jugadorActual = jugador;
        //        //esperar a que el jugador responda
        //        jugador.confirmarRespuesta(preguntaActual);
        //    }
        //     pregunta.puntarRespuestas(jugadores);
        //
        //}
        //algoJuego.mostrarGanador();
    }
}
