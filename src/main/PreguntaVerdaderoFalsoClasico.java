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
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(1);
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
                }else puntosObtenidos = 0;
            }else {
                puntosObtenidos = 0;
            }
        }
        //en actualizar puntaje esta la logica sobre si respondio bien
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
