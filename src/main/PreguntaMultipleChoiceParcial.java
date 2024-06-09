package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta {

    public PreguntaMultipleChoiceParcial(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int PuntajeObtenido = 0;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
                PuntajeObtenido += respuestaDelJugador.actualizarPuntaje(1);
        }
        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            if (!respuestaDelJugador.EsCorrecta()){
                PuntajeObtenido = 0;
            }
        }
        if (this.anulada) {
            if (jugaodoresQueUsaronAnulador.size() == 1) {
                for (Jugador jugador : jugaodoresQueUsaronAnulador) {
                    if (jugador == unJugador) {
                        break;
                    } else PuntajeObtenido = 0;
                }
            }else {
                PuntajeObtenido = 0;
            }
        }
        unJugador.modificarPuntaje(PuntajeObtenido);
    }
}
