package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarMultipleChoicePenalidad implements FormaDePuntuar{
    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        int puntosObtenidos = 0;
        for (Respuesta respuesta : respuestas) {
            puntosObtenidos += respuesta.actualizarPuntaje(1, respuesta);
        }
        return puntosObtenidos;
    }
}
