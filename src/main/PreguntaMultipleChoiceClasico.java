package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico extends Pregunta{

    public PreguntaMultipleChoiceClasico(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
        this.gestor = new AnuladorClasico();
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
            puntosObtenidos = this.gestor.puntosLuegoDeEvaluacion(puntosObtenidos,this.jugaodoresQueUsaronAnulador,unJugador);
        }else {
            puntosObtenidos = 0;
        }
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}

