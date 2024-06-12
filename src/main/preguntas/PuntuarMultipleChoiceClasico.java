package main.preguntas;

import main.Jugador;
import main.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarMultipleChoiceClasico implements FormaDePuntuar{
    private ArrayList<Respuesta> respuestas;

    public PuntuarMultipleChoiceClasico(ArrayList<Respuesta> respuestasPosibles) {
        this.respuestas = respuestasPosibles;
    }

    @Override
    public void puntuar(ArrayList<Respuesta> respuestasDelJugador, Jugador unJugador) {
        int RespuestasCorrectas = 0;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        //respuestasDelJugador.stream().mapToInt().sum()

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            if (respuestaDelJugador.EsCorrecta(respuestaDelJugador)){
                RespuestasCorrectas += 1;
            }
        }
        if (RespuestasCorrectas == respuestasCorrectas.size()){
            unJugador.modificarPuntaje(1);
        }
    }

    private ArrayList<Respuesta> obtenerRespuestasCorrectas() {

        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();

        for (Respuesta respuestaPosible : respuestas) {
            if (respuestaPosible.EsCorrecta(respuestaPosible)) {
                respuestasCorrectas.add(respuestaPosible);
            }
        }
        return respuestasCorrectas;
    }
}
