package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

//Asigna un punto a cada jugador que responda con la opción correcta

public class PuntuarVerdaderoFalsoClasico implements FormaDePuntuar {
    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        Respuesta respuestaDelJugador = respuestas.get(0); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        return respuestaDelJugador.actualizarPuntaje(1, respuestaDelJugador);
    }
}
