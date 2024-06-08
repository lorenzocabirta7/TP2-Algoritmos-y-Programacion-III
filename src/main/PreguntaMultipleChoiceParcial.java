package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta {
    //private String enunciado;

    //private ArrayList<Respuesta> respuestas;

    public PreguntaMultipleChoiceParcial(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
        //this.enunciado = enunciado;
        //this.respuestas = respuestas;
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
        unJugador.modificarPuntaje(PuntajeObtenido);
        }
    }
