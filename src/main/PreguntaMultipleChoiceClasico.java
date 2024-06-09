package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico extends Pregunta{

    public PreguntaMultipleChoiceClasico(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int CantidadDeRespuestasCorrectas = 0;
        int puntosObtenidos = -1;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            if (respuestaDelJugador instanceof RespuestaCorrecta){
                CantidadDeRespuestasCorrectas += 1;
            }
        }

        if (CantidadDeRespuestasCorrectas == respuestasCorrectas.size()){
            if (this.anulada) {
                if (jugaodoresQueUsaronAnulador.size() == 1) {
                    for (Jugador jugador : jugaodoresQueUsaronAnulador) {
                        if (jugador == unJugador) {
                            puntosObtenidos = 1;
                            break;
                        } else puntosObtenidos = 0;
                    }
                }else {
                    puntosObtenidos = 0;
                }
            } else puntosObtenidos = 1;
        }else {
            puntosObtenidos = 0;
        }
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}

