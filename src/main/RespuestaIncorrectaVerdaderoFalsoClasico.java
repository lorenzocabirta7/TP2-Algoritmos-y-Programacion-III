package main;

import java.util.ArrayList;

public class RespuestaIncorrectaVerdaderoFalsoClasico implements Respuesta{
    private ArrayList<Jugador> jugadores;

        public RespuestaIncorrectaVerdaderoFalsoClasico(){
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
}
