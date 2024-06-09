package main;


import java.util.ArrayList;
import java.util.List;

//Asigna un punto a cada jugador que responda con la opción correcta
public class PreguntaVerdaderoFalsoClasico extends Pregunta {

    public PreguntaVerdaderoFalsoClasico(String pregunta, ArrayList<Respuesta> respuestas) {
        super(pregunta, respuestas);
    }
    @Override
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador) {
        Respuesta respuestaDelJugador = respuestas.getFirst(); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntajeCorrespondiente = -1;
        if (this.anulada) {
            /*
            si mas de un jugador activo Aulador, nadie cosigue puntos.
            creo que todo este comportamiento de Anular Puntaje se puede
            implementar con un gestor de de Anulador en lugar de hacer
            todo en la clase Pregunta
            */
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
        } else puntajeCorrespondiente = 1;
        //en actualizar puntaje esta la logica sobre si respondio bien
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(puntajeCorrespondiente);
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
