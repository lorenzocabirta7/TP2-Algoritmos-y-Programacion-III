package main;


import java.util.ArrayList;
import java.util.List;

//Asigna un punto a cada jugador que responda con la opción correcta
public class PreguntaVerdaderoFalsoClasico extends Pregunta {

    //private String enunciado;
    //private ArrayList<Respuesta> respuestas;
    //private boolean anulada;
    //private ArrayList<Jugador> jugaodoresQueUsaronAnulador;

    public PreguntaVerdaderoFalsoClasico(String pregunta, ArrayList<Respuesta> respuestas) {
        super(pregunta, respuestas);
        //this.enunciado = pregunta;
        //this.respuestas = respuestas;
        //this.jugaodoresQueUsaronAnulador =  new ArrayList<>();
        //this.anulada = false;
    }
    @Override
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador) {
        Respuesta respuestaDelJugador = respuestas.getFirst(); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntajeCorrespondiente = -1;
        if (this.anulada) {
            for (Jugador jugador : jugaodoresQueUsaronAnulador) {
                if (jugador == unJugador) {
                    puntajeCorrespondiente = 1;
                    break;
                } else puntajeCorrespondiente = 0;
            }
        } else puntajeCorrespondiente = 1;
        //en actualizar puntaje esta la logica sobre si respondio bien
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(puntajeCorrespondiente);
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
