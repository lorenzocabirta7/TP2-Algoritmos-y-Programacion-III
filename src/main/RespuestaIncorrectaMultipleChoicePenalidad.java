package main;

import java.util.ArrayList;

public class RespuestaIncorrectaMultipleChoicePenalidad implements Respuesta{
    private String enunciadoRespuesta;
    private ArrayList<Jugador> jugadores;

    public RespuestaIncorrectaMultipleChoicePenalidad(String respuesta){
        this.enunciadoRespuesta = respuesta;
        this.jugadores = new ArrayList<Jugador>();
    }

    @Override
    public void actualizarPuntaje(int puntaje) {
        for (Jugador jugador : jugadores) {
            jugador.modificarPuntaje(puntaje * -1);
        }

    }

    @Override
    public void setJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }

    public String NombreDeJugador(){
        for (Jugador jugador : jugadores) {
            return jugador.obtenerNombre();
        }
        return "";
    }
    @Override
    public String getEnunciadoRespuesta(){
        return enunciadoRespuesta;
    }
}
