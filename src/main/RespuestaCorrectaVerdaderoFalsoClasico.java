package main;

import java.util.ArrayList;

public class RespuestaCorrectaVerdaderoFalsoClasico implements Respuesta{
    private String enunciadoRespuesta;
    private ArrayList<Jugador> jugadores;

    public RespuestaCorrectaVerdaderoFalsoClasico(){
        this.jugadores = new ArrayList<Jugador>();
    }

    @Override
    public void actualizarPuntaje(int puntaje) {
        for (Jugador jugador : jugadores) {
            jugador.modificarPuntaje(puntaje);
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
