package main;

import java.util.ArrayList;

public interface Respuesta {

    public void actualizarPuntaje(int puntaje);

    public void setJugador(Jugador unJugador);

    public String getEnunciadoRespuesta();
}