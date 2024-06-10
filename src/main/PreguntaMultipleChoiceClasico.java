package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico extends Pregunta{

    public PreguntaMultipleChoiceClasico(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int CantidadDeRespuestasCorrectas = 0;
        int puntosObtenidos = 1;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            if (respuestaDelJugador instanceof RespuestaCorrecta){
                CantidadDeRespuestasCorrectas += 1;
            }
        }

        if (CantidadDeRespuestasCorrectas == respuestasCorrectas.size()){
            if (this.anulada) {
                boolean jugadorEncontrado = false;
            /*
            si mas de un jugador activo Aulador, nadie cosigue puntos.
            creo que todo este comportamiento de Anular Puntaje se puede
            implementar con un gestor de de Anulador en lugar de hacer
            todo en la clase Pregunta
            */
                if (jugaodoresQueUsaronAnulador.size() == 1) {
                    for (Jugador jugador : jugaodoresQueUsaronAnulador) {
                        if (jugador == unJugador) {
                            jugadorEncontrado = true;
                            break;
                        }
                    }
                    if (jugadorEncontrado){
                        puntosObtenidos = puntosObtenidos;
                    }else puntosObtenidos = 0;
                }else {
                    puntosObtenidos = 0;
                }
            }
        }else {
            puntosObtenidos = 0;
        }
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}

