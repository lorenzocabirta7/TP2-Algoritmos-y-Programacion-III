package main;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoPenalidad extends Pregunta {

    public PreguntaVerdaderoFalsoPenalidad(String pregunta, ArrayList<Respuesta> respuestas) {
        super(pregunta, respuestas);
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador) {
        Respuesta respuestaDelJugador = respuestas.get(0); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntajeCorrespondiente = 1;
        if (this.anulada) {
            if (jugaodoresQueUsaronAnulador.size() == 1) {
                for (Jugador jugador : jugaodoresQueUsaronAnulador) {
                    if (jugador == unJugador) {
                        puntajeCorrespondiente = 1;
                        break;
                    } else puntajeCorrespondiente = 0;
                }
            }else {
                puntajeCorrespondiente = 0;
            }
        }
        //else puntajeCorrespondiente = 1;
        //en actualizar puntaje esta la logica sobre si respondio bien
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(puntajeCorrespondiente);
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
