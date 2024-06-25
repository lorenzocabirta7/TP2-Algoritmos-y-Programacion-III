package edu.fiuba.algo3.modelo.preguntas;



import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarDeFormaOrdenada implements FormaDePuntuar{
    private ArrayList<Respuesta> respuestas;

    public PuntuarDeFormaOrdenada(ArrayList<Respuesta> respuestasPosibles) {
        this.respuestas = respuestasPosibles;
    }
    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        int RespuestasCorrectas = 0;
        int RespuestasCorrectasEsperadas = respuestas.size();
        int puntosObtenidos = 0;

        for (Respuesta respuesta : respuestas) {
            for(Respuesta respuestaPosible : this.respuestas){
                RespuestasCorrectas += respuesta.actualizarPuntaje(1, respuestaPosible);
            }
        }
        if (RespuestasCorrectas == RespuestasCorrectasEsperadas) {
            puntosObtenidos = 1;
        }
        return puntosObtenidos;
    }
}
