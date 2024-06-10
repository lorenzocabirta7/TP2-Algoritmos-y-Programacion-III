package main;

import java.util.ArrayList;

public class PreguntaMultipleChoicePenalidad extends Pregunta{
    public PreguntaMultipleChoicePenalidad(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
        this.gestor = new AnuladorPenalidad();
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int puntosObtenidos = 0;
        for (Respuesta respuesta : respuestasDelJugador) {
            puntosObtenidos += respuesta.actualizarPuntaje(1);
        }
        puntosObtenidos = this.gestor.puntosLuegoDeEvaluacion(puntosObtenidos,this.jugaodoresQueUsaronAnulador,unJugador);
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
