package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarMultipleChoiceParcial implements FormaDePuntuar{
    private ArrayList<Respuesta> respuestas;

    public PuntuarMultipleChoiceParcial(ArrayList<Respuesta> respuestasPosibles) {
        this.respuestas = respuestasPosibles;
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int PuntajeObtenido = 0;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

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
    public ArrayList<Respuesta> obtenerRespuestasCorrectas() {

        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();

        for (Respuesta respuestaPosible : respuestas) {
            if (respuestaPosible.EsCorrecta()) {
                respuestasCorrectas.add(respuestaPosible);
            }
        }
        return respuestasCorrectas;
    }
}
