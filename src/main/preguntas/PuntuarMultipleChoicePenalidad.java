package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

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
