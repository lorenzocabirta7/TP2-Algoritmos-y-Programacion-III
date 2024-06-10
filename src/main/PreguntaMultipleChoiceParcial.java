package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta {

    public PreguntaMultipleChoiceParcial(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int puntajeCorrespondiente = 0;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            puntajeCorrespondiente += respuestaDelJugador.actualizarPuntaje(1);
        }
        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            if (!respuestaDelJugador.EsCorrecta()){
                puntajeCorrespondiente = 0;
            }
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
                    puntajeCorrespondiente = puntajeCorrespondiente;
                }else puntajeCorrespondiente = 0;
            }else {
                puntajeCorrespondiente = 0;
            }
        }
        //en actualizar puntaje esta la logica sobre si respondio bien
        unJugador.modificarPuntaje(puntajeCorrespondiente);
    }
}
