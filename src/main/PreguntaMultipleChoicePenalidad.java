package main;

import java.util.ArrayList;

public class PreguntaMultipleChoicePenalidad extends Pregunta{
    public PreguntaMultipleChoicePenalidad(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int puntosObtenidos = 0;
        for (Respuesta respuesta : respuestasDelJugador) {
            puntosObtenidos += respuesta.actualizarPuntaje(1);
        }
        if (this.anulada) {
            boolean jugadorEncontrado = false;
            if (jugaodoresQueUsaronAnulador.size() == 1) {
                for (Jugador jugador : jugaodoresQueUsaronAnulador) {
                    if (jugador == unJugador) {
                        jugadorEncontrado = true;
                        break;
                    }
                }
                if (jugadorEncontrado){
                    puntosObtenidos = puntosObtenidos;
                }else {
                    if (puntosObtenidos > 0){
                        puntosObtenidos = 0;
                    }
                }
            }else {
                if (puntosObtenidos > 0){
                    puntosObtenidos = 0;
                }
            }
        }
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
