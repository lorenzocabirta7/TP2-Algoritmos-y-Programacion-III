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

        for (Respuesta respuestaDelJugador : respuestasDelJugador) {
            if (respuestaDelJugador.EsCorrecta()){
                RespuestasCorrectas += 1;
            }
        }
        if (RespuestasCorrectas == respuestasCorrectas.size()){
            unJugador.modificarPuntaje(1);
        }
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
