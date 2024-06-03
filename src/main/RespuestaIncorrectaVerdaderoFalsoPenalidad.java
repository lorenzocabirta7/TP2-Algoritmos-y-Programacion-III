package main;

import java.util.ArrayList;

public class RespuestaIncorrectaVerdaderoFalsoPenalidad implements Respuesta{
    private final String enunciadoRespuesta;
    private ArrayList<Jugador> jugadores;

    public RespuestaIncorrectaVerdaderoFalsoPenalidad(){
        this.enunciadoRespuesta = "Falso";
        this.jugadores = new ArrayList<Jugador>();
    }

    @Override
    public void actualizarPuntaje(int puntaje) {
        for (Jugador jugador : jugadores) {
            jugador.modificarPuntaje((-1 * puntaje));
        }
    }

    @Override
    public void setJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }
}
