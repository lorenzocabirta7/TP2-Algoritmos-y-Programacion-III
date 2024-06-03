package main;

import java.util.ArrayList;

public class RespuestaIncorrectaVerdaderoFalsoClasico implements Respuesta{
    private String enunciadoRespuesta;
    private ArrayList<Jugador> jugadores;

        public RespuestaIncorrectaVerdaderoFalsoClasico(){
            enunciadoRespuesta = "Falso";
            this.jugadores = new ArrayList<Jugador>();
        }

    @Override
    public void actualizarPuntaje(int puntaje) {
            //no hacer nada. Preguntar si esto esta bien, o sacamos de la interfaz el contrato del metodo.
    }

    @Override
    public void setJugador(Jugador unJugador){
            this.jugadores.add(unJugador);
    }

    @Override
    public String getEnunciadoRespuesta(){
        return enunciadoRespuesta;
    }
}
