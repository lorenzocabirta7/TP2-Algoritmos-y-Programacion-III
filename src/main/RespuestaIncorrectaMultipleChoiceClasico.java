package main;

import java.util.ArrayList;

public class RespuestaIncorrectaMultipleChoiceClasico implements Respuesta{
    private String enunciadoRespuesta;
    private ArrayList<Jugador> jugadores;

    public RespuestaIncorrectaMultipleChoiceClasico(String respuesta){
        this.enunciadoRespuesta = respuesta;
        this.jugadores = new ArrayList<Jugador>();
    }

    @Override
    public void actualizarPuntaje(int puntaje) {
        //no hacemos nada porque respondio de forma incorrecta y no hay penalidad
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
