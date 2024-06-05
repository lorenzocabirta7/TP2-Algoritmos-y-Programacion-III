package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico extends Pregunta{
    private String enunciado;

    private ArrayList<Respuesta> respuestas;

    public PreguntaMultipleChoiceClasico(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
        this.enunciado = enunciado;
        this.respuestas = respuestas;
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int CantidadDeRespuestasCorrectas = 0;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            for (Respuesta respuestaCorrecta : respuestasCorrectas) {
                if (respuestaDelJugador == respuestaCorrecta){
                    CantidadDeRespuestasCorrectas += 1;
                }
            }
        }

        if (CantidadDeRespuestasCorrectas == respuestasCorrectas.size()){
            int puntosObtenidos = 1;
            unJugador.modificarPuntaje(puntosObtenidos);
        }
    }
}

