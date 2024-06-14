package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarMultipleChoiceParcial implements FormaDePuntuar{
    @Override
    public int puntuar(ArrayList<Respuesta> respuestas) {
        int PuntajeObtenido = 0;

        for (Respuesta respuestaDelJugador : respuestas) {
            PuntajeObtenido += respuestaDelJugador.actualizarPuntaje(1, respuestaDelJugador);
        }
        for (Respuesta respuestaDelJugador : respuestas) {
            if (!respuestaDelJugador.EsCorrecta(respuestaDelJugador)){
                PuntajeObtenido = 0;
            }
        }
        return PuntajeObtenido;
    }
}
