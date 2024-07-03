package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.exceptions.YaJugaronTodosLosJugadores;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;

public class Jugada {
    private ArrayList<Jugador> jugadores;
    private Pregunta preguntaActual;
    private Integer IndiceUltimoJugador;


    public Jugada(ArrayList<Jugador> jugadores, Pregunta preguntaActual) {
        this.jugadores = jugadores;
        this.preguntaActual = preguntaActual;
        IndiceUltimoJugador = 0;
    }


    public Jugador conseguirJugador() {
//        if (IndiceUltimoJugador >= jugadores.size()){
//            IndiceUltimoJugador = 0; //reset
//        }
        return jugadores.get(IndiceUltimoJugador);
    }

    public void confirmarRespuestas(){
        this.conseguirJugador().confirmarRespuesta(preguntaActual);
    }

    public void siguienteJugador() throws YaJugaronTodosLosJugadores {
        Jugador jugadorActual = this.conseguirJugador();
        jugadorActual.confirmarRespuesta(preguntaActual);
        System.out.println(jugadorActual.obtenerPuntos());
        IndiceUltimoJugador++;
        if (IndiceUltimoJugador >= jugadores.size()) {
            IndiceUltimoJugador = 0; //reset
        throw new YaJugaronTodosLosJugadores("Ya jugaron todos los jugadores");
        }
    }

    public void puntuarTodosLosJugadores(Pregunta preguntaAPuntuar) {
        System.out.println("Aca se punuta");
        System.out.println(preguntaAPuntuar.getEnunciado());
        preguntaAPuntuar.puntuarJugadores();
    }
}
