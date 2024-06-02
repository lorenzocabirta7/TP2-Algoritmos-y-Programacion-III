package main;

import java.util.ArrayList;

public class RespuestaCorrectaVerdaderoFalsoClasico implements RespuestasDeVerdaderoFalsoClasico{
    private final String contenido;
    private ArrayList<Jugador> jugadores;
    private final Boolean veracidad;

    public RespuestaCorrectaVerdaderoFalsoClasico(String unContenido, Boolean unaVeracidad){
        this.contenido = unContenido;
        this.veracidad = unaVeracidad;
        this.jugadores = new ArrayList<Jugador>();
    }


    public Boolean esCorrecta() {
        return true;
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
}
