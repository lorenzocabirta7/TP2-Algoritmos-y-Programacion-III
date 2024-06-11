package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarMultipleChoiceParcial implements FormaDePuntuar{

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int PuntajeObtenido = 0;

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            PuntajeObtenido += respuestaDelJugador.actualizarPuntaje(1, respuestaDelJugador);
        }
        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            if (!respuestaDelJugador.EsCorrecta()){
                PuntajeObtenido = 0;
            }
        }
        unJugador.modificarPuntaje(PuntajeObtenido);
    }
}
