package main;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta {

    public PreguntaMultipleChoiceParcial(String enunciado, ArrayList<Respuesta> respuestas){
        super(enunciado, respuestas);
        this.gestor = new AnuladorClasico();
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int puntosObtenidos = 0;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            puntosObtenidos += respuestaDelJugador.actualizarPuntaje(1);
        }
        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            if (!respuestaDelJugador.EsCorrecta()){
                puntosObtenidos = 0;
            }
        }
        puntosObtenidos = this.gestor.puntosLuegoDeEvaluacion(puntosObtenidos,this.jugaodoresQueUsaronAnulador,unJugador);
        //en actualizar puntaje esta la logica sobre si respondio bien
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
