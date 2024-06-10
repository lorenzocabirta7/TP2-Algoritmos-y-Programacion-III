package main;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoPenalidad extends Pregunta {

    public PreguntaVerdaderoFalsoPenalidad(String pregunta, ArrayList<Respuesta> respuestas) {
        super(pregunta, respuestas);
        this.gestor = new AnuladorPenalidad();
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador) {
        Respuesta respuestaDelJugador = respuestas.get(0); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(1);
        puntosObtenidos = this.gestor.puntosLuegoDeEvaluacion(puntosObtenidos,this.jugaodoresQueUsaronAnulador,unJugador);
        //else puntajeCorrespondiente = 1;
        //en actualizar puntaje esta la logica sobre si respondio bien
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
