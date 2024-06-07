package main;

import java.util.ArrayList;

public class PreguntaOrdenada extends Pregunta{
    private String enunciado;
    private ArrayList<Respuesta> respuestas;

    public PreguntaOrdenada(String enunciado, ArrayList<Respuesta> respuestasPosibles) {
        super(enunciado, respuestasPosibles);
        this.enunciado = enunciado;
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
