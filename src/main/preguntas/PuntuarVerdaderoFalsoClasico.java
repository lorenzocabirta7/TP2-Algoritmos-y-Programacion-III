package main.preguntas;


import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

//Asigna un punto a cada jugador que responda con la opción correcta
public class PuntuarVerdaderoFalsoClasico implements FormaDePuntuar {

    @Override
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador) {
        Respuesta respuestaDelJugador = respuestas.getFirst(); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(1, respuestaDelJugador);
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
