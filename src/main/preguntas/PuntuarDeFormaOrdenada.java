package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarDeFormaOrdenada implements FormaDePuntuar{
    private ArrayList<Respuesta> respuestas;

    public PuntuarDeFormaOrdenada(ArrayList<Respuesta> respuestasPosibles) {
        this.respuestas = respuestasPosibles;
    }

    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unjugador){
        int RespuestasCorrectas = 0;
        int RespuestasCorrectasEsperadas = respuestas.size();

        for (Respuesta respuesta : respuestasDelJugador) {
            for(Respuesta respuestaPosible : respuestas){
                RespuestasCorrectas += respuesta.actualizarPuntaje(1, respuestaPosible);
            }
        }
        if (RespuestasCorrectas == RespuestasCorrectasEsperadas) {
            unjugador.modificarPuntaje(1);
        }
    }
}
