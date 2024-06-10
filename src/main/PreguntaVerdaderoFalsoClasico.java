package main;


import java.util.ArrayList;
import java.util.List;

//Asigna un punto a cada jugador que responda con la opción correcta
public class PreguntaVerdaderoFalsoClasico extends Pregunta {

    public PreguntaVerdaderoFalsoClasico(String pregunta, ArrayList<Respuesta> respuestas) {
        super(pregunta, respuestas);
        this.gestor = new AnuladorClasico();
    }
    @Override
    public void puntuar(ArrayList<Respuesta> respuestas, Jugador unJugador) {
        Respuesta respuestaDelJugador = respuestas.getFirst(); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int puntosObtenidos = respuestaDelJugador.actualizarPuntaje(1);
        puntosObtenidos = this.gestor.puntosLuegoDeEvaluacion(puntosObtenidos,this.jugaodoresQueUsaronAnulador,unJugador);
        unJugador.modificarPuntaje(puntosObtenidos);
    }
}
